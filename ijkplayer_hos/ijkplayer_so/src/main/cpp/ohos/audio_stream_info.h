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

#ifndef ijkplayer_hos_audio_stream_info_H
#define ijkplayer_hos_audio_stream_info_H


#include <jni.h>

//StreamType
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_VOICE_CALL(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_SYSTEM(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_RING(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_MUSIC(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_ALARM(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_NOTIFICATION(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_DTMF(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_ACCESSIBILITY(JNIEnv* env);

//AudioStreamFlag
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_NONE(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_AUDIBILITY_ENFORCED(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_SECURE(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_SCO(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_BEACON(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_HW_AV_SYNC(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_HW_HOTWORD(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_BYPASS_INTERRUPTION_POLICY(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_BYPASS_MUTE(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_LOW_LATENCY(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_DEEP_BUFFER(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_NO_MEDIA_PROJECTION(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_MUTE_HAPTIC(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_NO_SYSTEM_CAPTURE(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_DIRECT_OUTPUT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_MAY_DUCK(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_MAY_RESUME(JNIEnv* env);

//EncodingFormat
jobject J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_INVALID(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_DEFAULT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_PCM_16BIT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_PCM_8BIT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_PCM_FLOAT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_MP3(JNIEnv* env);

//ChannelMask
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_INVALID(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_DEFAULT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_FRONT_LEFT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_FRONT_RIGHT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_FRONT_CENTER(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_LOW_FREQUENCY(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_BACK_LEFT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_BACK_RIGHT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_FRONT_LEFT_OF_CENTER(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_FRONT_RIGHT_OF_CENTER(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_BACK_CENTER(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_SIDE_LEFT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_SIDE_RIGHT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_CENTER(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_FRONT_LEFT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_FRONT_CENTER(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_FRONT_RIGHT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_BACK_LEFT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_BACK_CENTER(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_BACK_RIGHT(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_MONO(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_STEREO(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_QUAD(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_QUAD_SIDE(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_SURROUND(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_5POINT1(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_5POINT1_SIDE(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_7POINT1(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_IN_MONO(JNIEnv* env);
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_IN_STEREO(JNIEnv* env);


//StreamUsage
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamUsage_STREAM_USAGE_MEDIA(JNIEnv* env);

//AudioStreamOutputFlag
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamOutputFlag_AUDIO_STREAM_OUTPUT_FLAG_COMPRESS_OFFLOAD(JNIEnv* env);

//AudioType
jobject J4AC_AudioRenderer_PlayMode_MODE_STREAM(JNIEnv* env);


#endif //ijkplayer_hos_audio_stream_info_H
