/*
 * Copyright (C) 2015 Zhang Rui <bbcallen@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * https://github.com/Bilibili/jni4android
 * This file is automatically generated by jni4android, do not modify.
 */

#include "BufferInfo.h"


typedef struct J4AC_ohos_media_common_BufferInfo {
    jclass id;

    jfieldID field_bufferType;
    jfieldID field_offset;
    jfieldID field_size;
    jfieldID field_timeStamp;
    jmethodID constructor_BufferInfo;
} J4AC_ohos_media_common_BufferInfo;
static J4AC_ohos_media_common_BufferInfo class_J4AC_ohos_media_common_BufferInfo;

jint J4AC_ohos_media_common_BufferInfo__bufferType__get(JNIEnv *env, jobject thiz)
{
    return (*env)->GetIntField(env, thiz, class_J4AC_ohos_media_common_BufferInfo.field_bufferType);
}

jint J4AC_ohos_media_common_BufferInfo__bufferType__get__catchAll(JNIEnv *env, jobject thiz)
{
    jint ret_value = J4AC_ohos_media_common_BufferInfo__bufferType__get(env, thiz);
    if (J4A_ExceptionCheck__catchAll(env)) {
        return 0;
    }

    return ret_value;
}

void J4AC_ohos_media_common_BufferInfo__bufferType__set(JNIEnv *env, jobject thiz, jint value)
{
    (*env)->SetIntField(env, thiz, class_J4AC_ohos_media_common_BufferInfo.field_bufferType, value);
}

void J4AC_ohos_media_common_BufferInfo__bufferType__set__catchAll(JNIEnv *env, jobject thiz, jint value)
{
    J4AC_ohos_media_common_BufferInfo__bufferType__set(env, thiz, value);
    J4A_ExceptionCheck__catchAll(env);
}

jint J4AC_ohos_media_common_BufferInfo__offset__get(JNIEnv *env, jobject thiz)
{
    return (*env)->GetIntField(env, thiz, class_J4AC_ohos_media_common_BufferInfo.field_offset);
}

jint J4AC_ohos_media_common_BufferInfo__offset__get__catchAll(JNIEnv *env, jobject thiz)
{
    jint ret_value = J4AC_ohos_media_common_BufferInfo__offset__get(env, thiz);
    if (J4A_ExceptionCheck__catchAll(env)) {
        return 0;
    }

    return ret_value;
}

void J4AC_ohos_media_common_BufferInfo__offset__set(JNIEnv *env, jobject thiz, jint value)
{
    (*env)->SetIntField(env, thiz, class_J4AC_ohos_media_common_BufferInfo.field_offset, value);
}

void J4AC_ohos_media_common_BufferInfo__offset__set__catchAll(JNIEnv *env, jobject thiz, jint value)
{
    J4AC_ohos_media_common_BufferInfo__offset__set(env, thiz, value);
    J4A_ExceptionCheck__catchAll(env);
}

jint J4AC_ohos_media_common_BufferInfo__size__get(JNIEnv *env, jobject thiz)
{
    return (*env)->GetIntField(env, thiz, class_J4AC_ohos_media_common_BufferInfo.field_size);
}

jint J4AC_ohos_media_common_BufferInfo__size__get__catchAll(JNIEnv *env, jobject thiz)
{
    jint ret_value = J4AC_ohos_media_common_BufferInfo__size__get(env, thiz);
    if (J4A_ExceptionCheck__catchAll(env)) {
        return 0;
    }

    return ret_value;
}

void J4AC_ohos_media_common_BufferInfo__size__set(JNIEnv *env, jobject thiz, jint value)
{
    (*env)->SetIntField(env, thiz, class_J4AC_ohos_media_common_BufferInfo.field_size, value);
}

void J4AC_ohos_media_common_BufferInfo__size__set__catchAll(JNIEnv *env, jobject thiz, jint value)
{
    J4AC_ohos_media_common_BufferInfo__size__set(env, thiz, value);
    J4A_ExceptionCheck__catchAll(env);
}

jlong J4AC_ohos_media_common_BufferInfo__timeStamp__get(JNIEnv *env, jobject thiz)
{
    return (*env)->GetLongField(env, thiz, class_J4AC_ohos_media_common_BufferInfo.field_timeStamp);
}

jlong J4AC_ohos_media_common_BufferInfo__timeStamp__get__catchAll(JNIEnv *env, jobject thiz)
{
    jlong ret_value = J4AC_ohos_media_common_BufferInfo__timeStamp__get(env, thiz);
    if (J4A_ExceptionCheck__catchAll(env)) {
        return 0;
    }

    return ret_value;
}

void J4AC_ohos_media_common_BufferInfo__timeStamp__set(JNIEnv *env, jobject thiz, jlong value)
{
    (*env)->SetLongField(env, thiz, class_J4AC_ohos_media_common_BufferInfo.field_timeStamp, value);
}

void J4AC_ohos_media_common_BufferInfo__timeStamp__set__catchAll(JNIEnv *env, jobject thiz, jlong value)
{
    J4AC_ohos_media_common_BufferInfo__timeStamp__set(env, thiz, value);
    J4A_ExceptionCheck__catchAll(env);
}

jobject J4AC_ohos_media_common_BufferInfo__BufferInfo(JNIEnv *env)
{
    return (*env)->NewObject(env, class_J4AC_ohos_media_common_BufferInfo.id, class_J4AC_ohos_media_common_BufferInfo.constructor_BufferInfo);
}

jobject J4AC_ohos_media_common_BufferInfo__BufferInfo__catchAll(JNIEnv *env)
{
    jobject ret_object = J4AC_ohos_media_common_BufferInfo__BufferInfo(env);
    if (J4A_ExceptionCheck__catchAll(env) || !ret_object) {
        return NULL;
    }

    return ret_object;
}

jobject J4AC_ohos_media_common_BufferInfo__BufferInfo__asGlobalRef__catchAll(JNIEnv *env)
{
    jobject ret_object   = NULL;
    jobject local_object = J4AC_ohos_media_common_BufferInfo__BufferInfo__catchAll(env);
    if (J4A_ExceptionCheck__catchAll(env) || !local_object) {
        ret_object = NULL;
        goto fail;
    }

    ret_object = J4A_NewGlobalRef__catchAll(env, local_object);
    if (!ret_object) {
        ret_object = NULL;
        goto fail;
    }

fail:
    J4A_DeleteLocalRef__p(env, &local_object);
    return ret_object;
}

int J4A_loadClass__J4AC_ohos_media_common_BufferInfo(JNIEnv *env)
{

    int         ret                   = -1;
    const char *J4A_UNUSED(name)      = NULL;
    const char *J4A_UNUSED(sign)      = NULL;
    jclass      J4A_UNUSED(class_id)  = NULL;
    int         J4A_UNUSED(api_level) = 0;

    if (class_J4AC_ohos_media_common_BufferInfo.id != NULL)
        return 0;

    sign = "ohos/media/common/BufferInfo";
    class_J4AC_ohos_media_common_BufferInfo.id = J4A_FindClass__asGlobalRef__catchAll(env, sign);
    if (class_J4AC_ohos_media_common_BufferInfo.id == NULL)
        goto fail;

    class_id = class_J4AC_ohos_media_common_BufferInfo.id;
    name     = "bufferType";
    sign     = "I";
    class_J4AC_ohos_media_common_BufferInfo.field_bufferType = J4A_GetFieldID__catchAll(env, class_id, name, sign);
    if (class_J4AC_ohos_media_common_BufferInfo.field_bufferType == NULL)
        goto fail;

    class_id = class_J4AC_ohos_media_common_BufferInfo.id;
    name     = "offset";
    sign     = "I";
    class_J4AC_ohos_media_common_BufferInfo.field_offset = J4A_GetFieldID__catchAll(env, class_id, name, sign);
    if (class_J4AC_ohos_media_common_BufferInfo.field_offset == NULL)
        goto fail;

    class_id = class_J4AC_ohos_media_common_BufferInfo.id;
    name     = "size";
    sign     = "I";
    class_J4AC_ohos_media_common_BufferInfo.field_size = J4A_GetFieldID__catchAll(env, class_id, name, sign);
    if (class_J4AC_ohos_media_common_BufferInfo.field_size == NULL)
        goto fail;

    class_id = class_J4AC_ohos_media_common_BufferInfo.id;
    name     = "timeStamp";
    sign     = "J";
    class_J4AC_ohos_media_common_BufferInfo.field_timeStamp = J4A_GetFieldID__catchAll(env, class_id, name, sign);
    if (class_J4AC_ohos_media_common_BufferInfo.field_timeStamp == NULL)
        goto fail;

    class_id = class_J4AC_ohos_media_common_BufferInfo.id;
    name     = "<init>";
    sign     = "()V";
    class_J4AC_ohos_media_common_BufferInfo.constructor_BufferInfo = J4A_GetMethodID__catchAll(env, class_id, name, sign);
    if (class_J4AC_ohos_media_common_BufferInfo.constructor_BufferInfo == NULL)
        goto fail;


    J4A_ALOGD("J4ALoader: OK: '%s' loaded\n", "ohos.media.common.BufferInfo");
    ret = 0;
fail:

    return ret;
}
