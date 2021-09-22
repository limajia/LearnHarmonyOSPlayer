# the minimum version of CMake.
cmake_minimum_required(VERSION 3.10.2)

project("ijkplayer")

set(CMAKE_C_FLAGS "-std=c99 -Wno-typedef-redefinition")

add_subdirectory(ohoslog)

add_library(ijksdl  SHARED     ${CMAKE_CURRENT_SOURCE_DIR}/../ijksdl_aout.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../ijksdl_audio.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../ijksdl_egl.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../ijksdl_error.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../ijksdl_mutex.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../ijksdl_stdinc.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../ijksdl_thread.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../ijksdl_timer.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../ijksdl_vout.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../ijksdl_extra_log.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../gles2/color.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../gles2/common.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../gles2/renderer.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../gles2/renderer_rgb.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../gles2/renderer_yuv420p.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../gles2/renderer_yuv444p10le.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../gles2/shader.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../gles2/fsh/rgb.fsh.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../gles2/fsh/yuv420p.fsh.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../gles2/fsh/yuv444p10le.fsh.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../gles2/vsh/mvp.vsh.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../dummy/ijksdl_vout_dummy.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../ffmpeg/ijksdl_vout_overlay_ffmpeg.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../ffmpeg/abi_all/image_convert.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/android_audiotrack.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/android_nativewindow.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/ijksdl_android_jni.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/ijksdl_aout_android_audiotrack.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/ijksdl_aout_android_opensles.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/ijksdl_codec_android_mediacodec_dummy.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/ijksdl_codec_android_mediacodec_internal.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/ijksdl_codec_android_mediacodec_java.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/ijksdl_codec_android_mediacodec.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/ijksdl_codec_android_mediadef.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/ijksdl_codec_android_mediaformat_java.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/ijksdl_codec_android_mediaformat.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/ijksdl_vout_android_nativewindow.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/ijksdl_vout_android_surface.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../android/ijksdl_vout_overlay_android_mediacodec.c
                                ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/j4a_allclasses.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/j4a_base.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/ohos/media/audio/AudioRenderer.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/ohos/media/audio/AudioRendererInfo.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/ohos/media/audio/AudioStreamInfo.c

                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/ohos/media/mycodec/MyICodecListener.c

                                ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/ohos/media/codec/Codec.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/ohos/media/common/BufferInfo.c
                                ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/ohos/media/common/Format.c
                                ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/ohos/media/common/Source.c
                               ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/ohos/media/extractor/Extractor.c
                                ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/ohos/utils/PacMap.c
                                ${CMAKE_CURRENT_SOURCE_DIR}/../ohos/AudioRendererWrapper.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../ohos/audio_stream_info.c

                                ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/android/media/MediaCodec.c
                                ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/android/media/MediaFormat.c
                                ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/android/media/PlaybackParams.c

                                ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/android/os/Build.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/android/os/Bundle.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/java/nio/Buffer.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/java/nio/ByteBuffer.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/java/util/ArrayList.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/tv/danmaku/ijk/media/player/misc/IMediaDataSource.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/tv/danmaku/ijk/media/player/misc/IAndroidIO.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4a/class/tv/danmaku/ijk/media/player/IjkMediaPlayer.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4au/class/android/media/AudioTrack.util.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../j4au/class/java/nio/ByteBuffer.util.c
                                 ${CMAKE_CURRENT_SOURCE_DIR}/../log/log.c)

add_library(yuv STATIC IMPORTED)
set_target_properties(yuv PROPERTIES IMPORTED_LOCATION ${CMAKE_CURRENT_SOURCE_DIR}/../libs/yuv/${OHOS_ARCH}/libyuv.a)

add_library(ffmpeg SHARED IMPORTED)
set_target_properties(ffmpeg PROPERTIES IMPORTED_LOCATION ${CMAKE_CURRENT_SOURCE_DIR}/../libs/libffmpeg//${OHOS_ARCH}/libijkffmpeg.so)

add_library(openSLES SHARED IMPORTED)
set_target_properties(openSLES PROPERTIES IMPORTED_LOCATION ${CMAKE_CURRENT_SOURCE_DIR}/../libs/openSLES/${OHOS_ARCH}/libOpenSLES.so)

if(${OHOS_ARCH} STREQUAL "armeabi-v7a")
add_library(atomic_static STATIC IMPORTED)
set_target_properties(atomic_static PROPERTIES IMPORTED_LOCATION ${CMAKE_CURRENT_SOURCE_DIR}/../libs/atomic/${OHOS_ARCH}/libatomic.a)
endif()


include_directories(${CMAKE_CURRENT_SOURCE_DIR}/..)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/../libs/libffmpeg/include)
#include_directories(${CMAKE_CURRENT_SOURCE_DIR}/../libs/ijk4a/include)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/../libs/yuv/include)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/../libs/soundtouch/include)

if(${OHOS_ARCH} STREQUAL "armeabi-v7a")
target_link_libraries(ijksdl atomic_static
ohoslog yuv ffmpeg  EGL GLESv3 zgraphic.z openSLES hilog_ndk.z)
else()
target_link_libraries(ijksdl
ohoslog yuv ffmpeg  EGL GLESv3 zgraphic.z openSLES hilog_ndk.z)
endif()
