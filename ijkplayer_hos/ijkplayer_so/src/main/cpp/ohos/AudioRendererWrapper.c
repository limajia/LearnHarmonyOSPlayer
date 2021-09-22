/*****************************************************************************
 * Copyright (C) 2021 Huawei Device Co., Ltd.
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


#include "AudioRendererWrapper.h"
#include "android/android_audiotrack.h"
#include "audio_stream_info.h"
#include "j4a/j4a_base.h"
#include <EGL/egl.h>


jobject androidToOhosEncondingFormat(JNIEnv* env,int format){
   switch(format){
       case ENCODING_PCM_16BIT:{
            return J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_PCM_16BIT(env);
       }
       break;
       case ENCODING_PCM_8BIT:{
           return J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_PCM_8BIT(env);
       }
       break;
       case ENCODING_PCM_FLOAT:{
           return J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_PCM_FLOAT(env);
       }
      break;
   }

    return NULL;
}

jobject androidToOhosChannelMask(JNIEnv* env,int channel){

    switch(channel){
        case CHANNEL_OUT_MONO:{
            return J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_MONO(env);
        }
        break;
        case CHANNEL_OUT_STEREO:{
            return J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_STEREO(env);
        }
        break;
    }
    return NULL;
}

