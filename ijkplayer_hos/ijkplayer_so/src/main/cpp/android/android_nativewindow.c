/*****************************************************************************
 * android_nativewindow.c
 *****************************************************************************
 *
 * Copyright (c) 2013 Bilibili
 * copyright (c) 2013 Zhang Rui <bbcallen@gmail.com>
 *
 * This file is part of ijkPlayer.
 *
 * ijkPlayer is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * ijkPlayer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with ijkPlayer; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */

#include "android_nativewindow.h"

#include <assert.h>
#include <native_layer.h>
#include <stdio.h>
#include "../ijksdl_vout.h"
#include "../ijksdl_vout_internal.h"
#include "../ffmpeg/ijksdl_inc_ffmpeg.h"

#include "ijksdl_inc_internal_android.h"

#ifdef SDLTRACE
#undef SDLTRACE
#define SDLTRACE(...)
#endif

static int android_render_yv12_on_yv12(NativeLayerBuffer * out_buffer, const SDL_VoutOverlay * overlay)
{
    // SDLTRACE("SDL_VoutAndroid: android_render_yv12_on_yv12(%p)", overlay);
    assert(overlay->format == SDL_FCC_YV12);
    assert(overlay->planes == 3);

    int min_height = IJKMIN(out_buffer->buffer_height, overlay->h);
    int dst_y_stride = out_buffer->buffer_pattern;
    int dst_c_stride = IJKALIGN(out_buffer->buffer_pattern / 2, 16);
    int dst_y_size = dst_y_stride * out_buffer->buffer_height;
    int dst_c_size = dst_c_stride * out_buffer->buffer_height / 2;

    // ALOGE("stride:%d/%d, size:%d/%d", dst_y_stride, dst_c_stride, dst_y_size, dst_c_size);

    uint8_t * dst_pixels_array[] = {
        out_buffer->buffer_bits,
        out_buffer->buffer_bits + dst_y_size,
        out_buffer->buffer_bits + dst_y_size + dst_c_size,
    };
    int dst_line_height[] = {
        min_height, min_height / 2, min_height / 2
    };
    int dst_line_size_array[] = {
        dst_y_stride, dst_c_stride, dst_c_stride
    };

    for (int i = 0; i < 3; ++i) {
        int dst_line_size = dst_line_size_array[i];
        int src_line_size = overlay->pitches[i];
        int line_height = dst_line_height[i];
        uint8_t * dst_pixels = dst_pixels_array[i];
        const uint8_t * src_pixels = overlay->pixels[i];

        if (dst_line_size == src_line_size) {
            int plane_size = src_line_size * line_height;

            // ALOGE("sdl_image_copy_plane %p %p %d", dst_pixels, src_pixels, dst_plane_size);
            memcpy(dst_pixels, src_pixels, plane_size);
        } else {
            // TODO: 9 padding
            int bytewidth = IJKMIN(dst_line_size, src_line_size);

            // ALOGE("av_image_copy_plane %p %d %p %d %d %d", dst_pixels, dst_line_size, src_pixels, src_line_size, bytewidth, line_height);
            av_image_copy_plane(dst_pixels, dst_line_size, src_pixels, src_line_size, bytewidth, line_height);
        }
    }

    return 0;
}

static int android_render_on_yv12(NativeLayerBuffer * out_buffer, const SDL_VoutOverlay * overlay)
{
    assert(out_buffer);
    assert(overlay);

    switch (overlay->format) {
        case SDL_FCC_YV12: {
            return android_render_yv12_on_yv12(out_buffer, overlay);
        }
    }

    return -1;
}

static int android_render_rgb_on_rgb(NativeLayerBuffer * out_buffer, const SDL_VoutOverlay * overlay, int bpp)
{

    // SDLTRACE("SDL_VoutAndroid: android_render_rgb_on_rgb(%p)", overlay);
    assert(overlay->format == SDL_FCC_RV16);
    assert(overlay->planes == 1);

    int min_height = IJKMIN(out_buffer->buffer_height, overlay->h);
    int dst_stride = out_buffer->buffer_pattern;
    int src_line_size = overlay->pitches[0];
    int dst_line_size = dst_stride * bpp / 8;

    uint8_t * dst_pixels = out_buffer->buffer_bits;
    const uint8_t * src_pixels = overlay->pixels[0];



    if (dst_line_size == src_line_size) {
        int plane_size = src_line_size * min_height;
        // ALOGE("android_render_rgb_on_rgb (pix-match) %p %p %d", dst_pixels, src_pixels, plane_size);
        memcpy(dst_pixels, src_pixels, plane_size);


    } else {
        // TODO: 9 padding
        int bytewidth = IJKMIN(dst_line_size, src_line_size);

        // ALOGE("android_render_rgb_on_rgb (pix-mismatch) %p %d %p %d %d %d", dst_pixels, dst_line_size, src_pixels, src_line_size, bytewidth, min_height);
        av_image_copy_plane(dst_pixels, dst_line_size, src_pixels, src_line_size, bytewidth, min_height);


    }



    return 0;
}

static int android_render_rgb565_on_rgb565(NativeLayerBuffer * out_buffer, const SDL_VoutOverlay * overlay)
{
    return android_render_rgb_on_rgb(out_buffer, overlay, 16);
}

static int android_render_on_rgb565(NativeLayerBuffer * out_buffer, const SDL_VoutOverlay * overlay)
{
    ALOGD("android_render_on_rgb565 %d",overlay->format);

    assert(out_buffer);
    assert(overlay);

    switch (overlay->format) {
        case SDL_FCC_RV16: {
            return android_render_rgb565_on_rgb565(out_buffer, overlay);
        }
    }



    return -1;
}

static int android_render_rgb32_on_rgb8888(NativeLayerBuffer * out_buffer, const SDL_VoutOverlay * overlay)
{
    return android_render_rgb_on_rgb(out_buffer, overlay, 32);
}

static int android_render_on_rgb8888(NativeLayerBuffer * out_buffer, const SDL_VoutOverlay * overlay)
{
    assert(out_buffer);
    assert(overlay);

    switch (overlay->format) {
        case SDL_FCC_RV32: {
            return android_render_rgb32_on_rgb8888(out_buffer, overlay);
        }
    }

    return -1;
}

typedef struct AndroidHalFourccDescriptor {
    Uint32 fcc_or_hal;
    const char* name;

    int hal_format;

    int (* render)(NativeLayerBuffer * native_buffer, const SDL_VoutOverlay * overlay);
} AndroidHalFourccDescriptor;

static AndroidHalFourccDescriptor g_hal_fcc_map[] = {
// YV12
    {
        HAL_PIXEL_FORMAT_YV12, "HAL_YV12", HAL_PIXEL_FORMAT_YV12, android_render_on_yv12
    },
    {
        SDL_FCC_YV12, "YV12", HAL_PIXEL_FORMAT_YV12, android_render_on_yv12
    },

    // RGB565
    {
        HAL_PIXEL_FORMAT_RGB_565, "HAL_RGB_565", HAL_PIXEL_FORMAT_RGB_565, android_render_on_rgb565
    },
    {
        SDL_FCC_RV16, "RV16", HAL_PIXEL_FORMAT_RGB_565, android_render_on_rgb565
    },

    // RGB8888
    {
        HAL_PIXEL_FORMAT_RGBX_8888, "HAL_RGBX_8888", HAL_PIXEL_FORMAT_RGBX_8888, android_render_on_rgb8888
    },
    {
        HAL_PIXEL_FORMAT_RGBA_8888, "HAL_RGBA_8888", HAL_PIXEL_FORMAT_RGBA_8888, android_render_on_rgb8888
    },
    {
        HAL_PIXEL_FORMAT_BGRA_8888, "HAL_BGRA_8888", HAL_PIXEL_FORMAT_BGRA_8888, android_render_on_rgb8888
    },
    {
        SDL_FCC_RV32, "RV32", HAL_PIXEL_FORMAT_RGBX_8888, android_render_on_rgb8888
    },
};

AndroidHalFourccDescriptor * native_window_get_desc(int fourcc_or_hal)
{
    for (int i = 0; i < NELEM(g_hal_fcc_map); ++i) {
        AndroidHalFourccDescriptor * desc = &g_hal_fcc_map[i];
        if (desc->fcc_or_hal == fourcc_or_hal)
            return desc;
    }

    return NULL;
}

int SDL_Android_NativeWindow_display_l(struct ANativeWindow * native_window, SDL_VoutOverlay * overlay)
{
    ALOGD("执行渲染 SDL_Android_NativeWindow_display_l");

    int retval;

    if (!native_window) {
        ALOGE("SDL_Android_NativeWindow_display_l !native_window");
        return -1;
    }

    if (!overlay) {
        ALOGE("SDL_Android_NativeWindow_display_l !overlay");
        ALOGE("SDL_Android_NativeWindow_display_l: NULL overlay");
        return -1;
    }

    if (overlay->w <= 0 || overlay->h <= 0) {
        ALOGE("SDL_Android_NativeWindow_display_l: invalid overlay dimensions(%d, %d)", overlay->w, overlay->h);
        return -1;
    }

    int curr_w = NativeLayerHandle(native_window, GET_WIDTH);
    int curr_h = NativeLayerHandle(native_window, GET_HEIGHT);
    int curr_format = NativeLayerHandle(native_window, GET_FORMAT);


    ALOGD("Android_NativeWindow宽%d,高%d,格式%d", curr_w, curr_h, curr_format);

    int buff_w = IJKALIGN(overlay->w, 2);
    int buff_h = IJKALIGN(overlay->h, 2);

    AndroidHalFourccDescriptor * overlayDesc = native_window_get_desc(overlay->format);
    if (!overlayDesc) {
        ALOGE("SDL_Android_NativeWindow_display_l: unknown overlay format: %d", overlay->format);
        return -1;
    }

    ALOGD("执行渲染 SDL_Android_NativeWindow_display_l overlayDesc");

    AndroidHalFourccDescriptor * voutDesc = native_window_get_desc(curr_format);

    ALOGD("SDL_Android_NativeWindow_display_l format=%d %d",voutDesc->hal_format, overlayDesc->hal_format);

    if (!voutDesc || voutDesc->hal_format != overlayDesc->hal_format) {
        retval=NativeLayerHandle(native_window, SET_WIDTH_AND_HEIGHT, buff_w, buff_h, overlayDesc->hal_format);
        if (retval < 0) {
            ALOGD("SDL_Android_NativeWindow_display_l: ANativeWindow_setBuffersGeometry: failed %d", retval);
            return retval;
        }
        if (!voutDesc) {
            ALOGE("SDL_Android_NativeWindow_display_l: unknown hal format %d", curr_format);
            return -1;
        }
    } else {
        ALOGD("不执行SDL_Android_NativeWindow_display_l");
    }

    NativeLayerBuffer out_buffer;
    //retval = ANativeWindow_lock(native_window, &out_buffer, NULL);
    retval = NativeLayerHandle(native_window, LOCK_LAYER, &out_buffer, NULL);

    if (retval < 0) {
        ALOGE("SDL_Android_NativeWindow_display_l: ANativeWindow_lock: failed %d", retval);
        return retval;
    }else{
        ALOGD("执行渲染 SDL_Android_NativeWindow_display_l  LOCK_LAYER成功了");
    }

    ALOGD("SDL_Android_NativeWindow_display_l bufferWidth=%d bufferHeight=%d",out_buffer.buffer_width,out_buffer.buffer_height);

    if (out_buffer.buffer_width != buff_w || out_buffer.buffer_height != buff_h) {
        ALOGD("unexpected native window buffer (%p)(w:%d, h:%d, fmt:'%.4s'0x%x), expecting (w:%d, h:%d, fmt:'%.4s'0x%x)",
                native_window,
                out_buffer.buffer_width, out_buffer.buffer_height, (char*)&out_buffer.buffer_pattern, out_buffer.buffer_pattern,
                buff_w, buff_h, (char*)&overlay->format, overlay->format);

        // TODO: 8 set all black
        NativeLayerHandle(native_window, DRAW_LAYER);
        NativeLayerHandle(native_window, SET_WIDTH_AND_HEIGHT, buff_w, buff_h, overlayDesc->hal_format);

        return -1;
    }

    int render_ret = voutDesc->render(&out_buffer, overlay);
    if (render_ret < 0) {
        // TODO: 8 set all black
        // return after unlock image;
    }

    retval = NativeLayerHandle(native_window, DRAW_LAYER);

    if (retval < 0) {
        ALOGE("SDL_Android_NativeWindow_display_l: ANativeWindow_unlockAndPost: failed %d", retval);
        return retval;
    }else{
        ALOGD("SDL_Android_NativeWindow_display_l:界面绘制成功 %d",retval);
    }

    ALOGE("SDL_Android_NativeWindow_display_l: 执行成功 %d",render_ret);

    return render_ret;
}
