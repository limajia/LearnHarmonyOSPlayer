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


#include "audio_stream_info.h""

#include "j4a/j4a_base.h"

jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_ENCODING_INVALID(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"ENCODING_INVALID","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_ENCODING_DEFAULT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"ENCODING_DEFAULT","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_ENCODING_PCM_16BIT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"ENCODING_PCM_16BIT","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_ENCODING_PCM_8BIT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"ENCODING_PCM_8BIT","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_ENCODING_PCM_FLOAT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"ENCODING_PCM_FLOAT","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_ENCODING_MP3(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"ENCODING_MP3","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}

jobject J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_INVALID(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$EncodingFormat");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"ENCODING_INVALID","Lohos/media/audio/AudioStreamInfo$EncodingFormat");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_DEFAULT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$EncodingFormat");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"ENCODING_DEFAULT","Lohos/media/audio/AudioStreamInfo$EncodingFormat");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_PCM_16BIT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$EncodingFormat");
    if(clazz==NULL){

    }else{

    }

    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"ENCODING_PCM_16BIT","Lohos/media/audio/AudioStreamInfo$EncodingFormat;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_PCM_8BIT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$EncodingFormat");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"ENCODING_PCM_8BIT","Lohos/media/audio/AudioStreamInfo$EncodingFormat;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_PCM_FLOAT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$EncodingFormat");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"ENCODING_PCM_FLOAT","Lohos/media/audio/AudioStreamInfo$EncodingFormat");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_EncodingFormat_ENCODING_MP3(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$EncodingFormat");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"ENCODING_MP3","Lohos/media/audio/AudioStreamInfo$EncodingFormat");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}

//channelMask
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_INVALID(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_INVALID","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_DEFAULT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_DEFAULT","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_FRONT_LEFT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_FRONT_LEFT","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_FRONT_RIGHT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_FRONT_RIGHT","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_FRONT_CENTER(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_FRONT_CENTER","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_LOW_FREQUENCY(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_LOW_FREQUENCY","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_BACK_LEFT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_BACK_LEFT","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_BACK_RIGHT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_BACK_RIGHT","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_FRONT_LEFT_OF_CENTER(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_FRONT_LEFT_OF_CENTER","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_FRONT_RIGHT_OF_CENTER(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_FRONT_RIGHT_OF_CENTER","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_BACK_CENTER(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_BACK_CENTER","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_SIDE_LEFT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_SIDE_LEFT","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_SIDE_RIGHT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_SIDE_RIGHT","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_CENTER(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_TOP_CENTER","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_FRONT_LEFT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_TOP_FRONT_LEFT","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_FRONT_CENTER(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_TOP_FRONT_CENTER","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_FRONT_RIGHT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_TOP_FRONT_RIGHT","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_BACK_LEFT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_TOP_BACK_LEFT","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_BACK_CENTER(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_TOP_BACK_CENTER","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_TOP_BACK_RIGHT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_TOP_BACK_RIGHT","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_MONO(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_MONO","Lohos/media/audio/AudioStreamInfo$ChannelMask;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_STEREO(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_STEREO","Lohos/media/audio/AudioStreamInfo$ChannelMask;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_QUAD(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_QUAD","Lohos/media/audio/AudioStreamInfo$ChannelMask;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_QUAD_SIDE(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_QUAD_SIDE","Lohos/media/audio/AudioStreamInfo$ChannelMask;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_SURROUND(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_SURROUND","Lohos/media/audio/AudioStreamInfo$ChannelMask;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_5POINT1(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_5POINT1","Lohos/media/audio/AudioStreamInfo$ChannelMask;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_5POINT1_SIDE(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_5POINT1_SIDE","Lohos/media/audio/AudioStreamInfo$ChannelMask;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_OUT_7POINT1(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_OUT_7POINT1","Lohos/media/audio/AudioStreamInfo$ChannelMask");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_IN_MONO(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_IN_MONO","Lohos/media/audio/AudioStreamInfo$ChannelMask;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_ChannelMask_CHANNEL_IN_STEREO(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$ChannelMask");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"CHANNEL_IN_STEREO","Lohos/media/audio/AudioStreamInfo$ChannelMask;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}

//StreamType
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_VOICE_CALL(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"STREAM_TYPE_VOICE_CALL","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_SYSTEM(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"STREAM_TYPE_SYSTEM","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_RING(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"STREAM_TYPE_RING","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_MUSIC(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"STREAM_TYPE_MUSIC","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_ALARM(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"STREAM_TYPE_ALARM","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_NOTIFICATION(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"STREAM_TYPE_NOTIFICATION","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_DTMF(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"STREAM_TYPE_DTMF","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamType_STREAM_TYPE_ACCESSIBILITY(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamType");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"STREAM_TYPE_ACCESSIBILITY","Lohos/media/audio/AudioStreamInfo$StreamType");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}

jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_NONE(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_NONE","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_AUDIBILITY_ENFORCED(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_AUDIBILITY_ENFORCED","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_SECURE(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_SECURE","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_SCO(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_SCO","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_BEACON(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_BEACON","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_HW_AV_SYNC(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_HW_AV_SYNC","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_HW_HOTWORD(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_HW_HOTWORD","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_BYPASS_INTERRUPTION_POLICY(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_BYPASS_INTERRUPTION_POLICY","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_BYPASS_MUTE(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_BYPASS_MUTE","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_LOW_LATENCY(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_LOW_LATENCY","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_DEEP_BUFFER(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_DEEP_BUFFER","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_NO_MEDIA_PROJECTION(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_NO_MEDIA_PROJECTION","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_MUTE_HAPTIC(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_MUTE_HAPTIC","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_NO_SYSTEM_CAPTURE(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_NO_SYSTEM_CAPTURE","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_DIRECT_OUTPUT(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_DIRECT_OUTPUT","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}
jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_MAY_DUCK(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_MAY_DUCK","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}

jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamFlag_AUDIO_STREAM_FLAG_MAY_RESUME(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$AudioStreamFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_FLAG_MAY_RESUME","Lohos/media/audio/AudioStreamInfo$AudioStreamFlag;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}

//StreamUsage
jobject J4AC_AudioStreamInfo_AudioStreamInfo_StreamUsage_STREAM_USAGE_MEDIA(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioStreamInfo$StreamUsage");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"STREAM_USAGE_MEDIA","Lohos/media/audio/AudioStreamInfo$StreamUsage;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);

}

jobject J4AC_AudioStreamInfo_AudioStreamInfo_AudioStreamOutputFlag_AUDIO_STREAM_OUTPUT_FLAG_COMPRESS_OFFLOAD(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioRendererInfo$AudioStreamOutputFlag");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"AUDIO_STREAM_OUTPUT_FLAG_COMPRESS_OFFLOAD","Lohos/media/audio/AudioRendererInfo$AudioStreamOutputFlag;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}

jobject J4AC_AudioRenderer_PlayMode_MODE_STREAM(JNIEnv* env){
    jclass clazz=J4A_FindClass__catchAll(env,"ohos/media/audio/AudioRenderer$PlayMode");
    jfieldID fieldId = J4A_GetStaticFieldID__catchAll(env,clazz,"MODE_STREAM","Lohos/media/audio/AudioRenderer$PlayMode;");
    return (*env)->GetStaticObjectField(env, clazz, fieldId);
}