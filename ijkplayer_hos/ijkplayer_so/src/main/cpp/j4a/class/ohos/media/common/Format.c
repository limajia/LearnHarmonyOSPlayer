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

#include "Format.h"

#include <jni.h>

typedef struct J4AC_ohos_media_common_Format {
    jclass id;

    jmethodID constructor_Format;
    jmethodID method_getIntValue;
    jmethodID method_putIntValue;
    jmethodID method_putObjectValue;
    jmethodID method_getObjectValue;
    jmethodID method_getStringValue;
} J4AC_ohos_media_common_Format;
static J4AC_ohos_media_common_Format class_J4AC_ohos_media_common_Format;

jobject J4AC_ohos_media_common_Format__Format(JNIEnv *env)
{
    return (*env)->NewObject(env, class_J4AC_ohos_media_common_Format.id, class_J4AC_ohos_media_common_Format.constructor_Format);
}

jobject J4AC_ohos_media_common_Format__Format__catchAll(JNIEnv *env)
{
    jobject ret_object = J4AC_ohos_media_common_Format__Format(env);
    if (J4A_ExceptionCheck__catchAll(env) || !ret_object) {
        return NULL;
    }

    return ret_object;
}

jobject J4AC_ohos_media_common_Format__Format__asGlobalRef__catchAll(JNIEnv *env)
{
    jobject ret_object   = NULL;
    jobject local_object = J4AC_ohos_media_common_Format__Format__catchAll(env);
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

jint J4AC_ohos_media_common_Format__getIntValue(JNIEnv *env, jobject thiz, jstring key)
{
    return (*env)->CallIntMethod(env, thiz, class_J4AC_ohos_media_common_Format.method_getIntValue, key);
}

jint J4AC_ohos_media_common_Format__getIntValue__catchAll(JNIEnv *env, jobject thiz, jstring key)
{
    jint ret_value = J4AC_ohos_media_common_Format__getIntValue(env, thiz, key);
    if (J4A_ExceptionCheck__catchAll(env)) {
        return 0;
    }

    return ret_value;
}

jint J4AC_ohos_media_common_Format__getIntValue__withCString(JNIEnv *env, jobject thiz, const char *key_cstr__)
{
    jint ret_value = 0;
    jstring key = NULL;

    key = (*env)->NewStringUTF(env, key_cstr__);
    if (J4A_ExceptionCheck__throwAny(env) || !key)
        goto fail;

    ret_value = J4AC_ohos_media_common_Format__getIntValue(env, thiz, key);
    if (J4A_ExceptionCheck__throwAny(env)) {
        ret_value = 0;
        goto fail;
    }

fail:
    J4A_DeleteLocalRef__p(env, &key);
    return ret_value;
}

jint J4AC_ohos_media_common_Format__getIntValue__withCString__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__)
{
    jint ret_value = 0;
    jstring key = NULL;

    key = (*env)->NewStringUTF(env, key_cstr__);
    if (J4A_ExceptionCheck__catchAll(env) || !key)
        goto fail;

    ret_value = J4AC_ohos_media_common_Format__getIntValue__catchAll(env, thiz, key);
    if (J4A_ExceptionCheck__catchAll(env)) {
        ret_value = 0;
        goto fail;
    }

fail:
    J4A_DeleteLocalRef__p(env, &key);
    return ret_value;
}

void J4AC_ohos_media_common_Format__putIntValue(JNIEnv *env, jobject thiz, jstring key, jint value)
{

    if(class_J4AC_ohos_media_common_Format.method_putIntValue==NULL){

    }else{

    }

    if(thiz==NULL){

    }else{

    }

    (*env)->CallVoidMethod(env, thiz, class_J4AC_ohos_media_common_Format.method_putIntValue, key, value);
}

void J4AC_ohos_media_common_Format__putIntValue__catchAll(JNIEnv *env, jobject thiz, jstring key, jint value)
{
    J4AC_ohos_media_common_Format__putIntValue(env, thiz, key, value);
    J4A_ExceptionCheck__catchAll(env);
}

void J4AC_ohos_media_common_Format__putIntValue__withCString(JNIEnv *env, jobject thiz, const char *key_cstr__, jint value)
{
    jstring key = NULL;

    key = (*env)->NewStringUTF(env, key_cstr__);
    if (J4A_ExceptionCheck__throwAny(env) || !key)
        goto fail;

    J4AC_ohos_media_common_Format__putIntValue(env, thiz, key, value);

fail:
    J4A_DeleteLocalRef__p(env, &key);
}

void J4AC_ohos_media_common_Format__putIntValue__withCString__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__, jint value)
{
    jstring key = NULL;

    key = (*env)->NewStringUTF(env, key_cstr__);
    if (J4A_ExceptionCheck__catchAll(env) || !key)
        goto fail;

    J4AC_ohos_media_common_Format__putIntValue__catchAll(env, thiz, key, value);

fail:
    J4A_DeleteLocalRef__p(env, &key);
}

void J4AC_ohos_media_common_Format__putObjectValue(JNIEnv *env, jobject thiz, jstring key, jobject value)
{
    (*env)->CallVoidMethod(env, thiz, class_J4AC_ohos_media_common_Format.method_putObjectValue, key, value);
}

jobject J4AC_ohos_media_common_Format__getObjectValue__withCString(JNIEnv *env, jobject thiz, const char *key_cstr__)
{
    jstring key = NULL;
    key = (*env)->NewStringUTF(env, key_cstr__);
    return (*env)->CallObjectMethod(env, thiz, class_J4AC_ohos_media_common_Format.method_getObjectValue, key);
}

void J4AC_ohos_media_common_Format__putObjectValue__catchAll(JNIEnv *env, jobject thiz, jstring key, jobject value)
{
    J4AC_ohos_media_common_Format__putObjectValue(env, thiz, key, value);
    J4A_ExceptionCheck__catchAll(env);
}

void J4AC_ohos_media_common_Format__putObjectValue__withCString(JNIEnv *env, jobject thiz, const char *key_cstr__, jobject value)
{
    jstring key = NULL;

    key = (*env)->NewStringUTF(env, key_cstr__);
    if (J4A_ExceptionCheck__throwAny(env) || !key)
        goto fail;

    J4AC_ohos_media_common_Format__putObjectValue(env, thiz, key, value);

fail:
    J4A_DeleteLocalRef__p(env, &key);
}

void J4AC_ohos_media_common_Format__putObjectValue__withCString__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__, jobject value)
{
    jstring key = NULL;

    key = (*env)->NewStringUTF(env, key_cstr__);
    if (J4A_ExceptionCheck__catchAll(env) || !key)
        goto fail;

    J4AC_ohos_media_common_Format__putObjectValue__catchAll(env, thiz, key, value);

fail:
    J4A_DeleteLocalRef__p(env, &key);
}

jstring J4AC_ohos_media_common_Format__getStringValue(JNIEnv *env, jobject thiz, jstring key)
{
    return (*env)->CallObjectMethod(env, thiz, class_J4AC_ohos_media_common_Format.method_getStringValue, key);
}

jstring J4AC_ohos_media_common_Format__getStringValue__catchAll(JNIEnv *env, jobject thiz, jstring key)
{
    jstring ret_object = J4AC_ohos_media_common_Format__getStringValue(env, thiz, key);
    if (J4A_ExceptionCheck__catchAll(env) || !ret_object) {
        return NULL;
    }

    return ret_object;
}

jstring J4AC_ohos_media_common_Format__getStringValue__asGlobalRef__catchAll(JNIEnv *env, jobject thiz, jstring key)
{
    jstring ret_object   = NULL;
    jstring local_object = J4AC_ohos_media_common_Format__getStringValue__catchAll(env, thiz, key);
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

const char *J4AC_ohos_media_common_Format__getStringValue__asCBuffer(JNIEnv *env, jobject thiz, jstring key, char *out_buf, int out_len)
{
    const char *ret_value = NULL;
    const char *c_str     = NULL;
    jstring local_string = J4AC_ohos_media_common_Format__getStringValue(env, thiz, key);
    if (J4A_ExceptionCheck__throwAny(env) || !local_string) {
        goto fail;
    }

    c_str = (*env)->GetStringUTFChars(env, local_string, NULL );
    if (J4A_ExceptionCheck__throwAny(env) || !c_str) {
        goto fail;
    }

    strlcpy(out_buf, c_str, out_len);
    ret_value = out_buf;

fail:
    J4A_ReleaseStringUTFChars__p(env, local_string, &c_str);
    J4A_DeleteLocalRef__p(env, &local_string);
    return ret_value;
}

const char *J4AC_ohos_media_common_Format__getStringValue__asCBuffer__catchAll(JNIEnv *env, jobject thiz, jstring key, char *out_buf, int out_len)
{
    const char *ret_value = NULL;
    const char *c_str     = NULL;
    jstring local_string = J4AC_ohos_media_common_Format__getStringValue__catchAll(env, thiz, key);
    if (J4A_ExceptionCheck__catchAll(env) || !local_string) {
        goto fail;
    }

    c_str = (*env)->GetStringUTFChars(env, local_string, NULL );
    if (J4A_ExceptionCheck__catchAll(env) || !c_str) {
        goto fail;
    }

    strlcpy(out_buf, c_str, out_len);
    ret_value = out_buf;

fail:
    J4A_ReleaseStringUTFChars__p(env, local_string, &c_str);
    J4A_DeleteLocalRef__p(env, &local_string);
    return ret_value;
}

jstring J4AC_ohos_media_common_Format__getStringValue__withCString(JNIEnv *env, jobject thiz, const char *key_cstr__)
{
    jstring ret_object = NULL;
    jstring key = NULL;

    key = (*env)->NewStringUTF(env, key_cstr__);
    if (J4A_ExceptionCheck__throwAny(env) || !key)
        goto fail;

    ret_object = J4AC_ohos_media_common_Format__getStringValue(env, thiz, key);
    if (J4A_ExceptionCheck__throwAny(env) || !ret_object) {
        ret_object = NULL;
        goto fail;
    }

fail:
    J4A_DeleteLocalRef__p(env, &key);
    return ret_object;
}

jstring J4AC_ohos_media_common_Format__getStringValue__withCString__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__)
{
    jstring ret_object = NULL;
    jstring key = NULL;

    key = (*env)->NewStringUTF(env, key_cstr__);
    if (J4A_ExceptionCheck__catchAll(env) || !key)
        goto fail;

    ret_object = J4AC_ohos_media_common_Format__getStringValue__catchAll(env, thiz, key);
    if (J4A_ExceptionCheck__catchAll(env) || !ret_object) {
        ret_object = NULL;
        goto fail;
    }

fail:
    J4A_DeleteLocalRef__p(env, &key);
    return ret_object;
}

jstring J4AC_ohos_media_common_Format__getStringValue__withCString__asGlobalRef__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__)
{
    jstring ret_object   = NULL;
    jstring local_object = J4AC_ohos_media_common_Format__getStringValue__withCString__catchAll(env, thiz, key_cstr__);
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

const char *J4AC_ohos_media_common_Format__getStringValue__withCString__asCBuffer(JNIEnv *env, jobject thiz, const char *key_cstr__, char *out_buf, int out_len)
{
    const char *ret_value = NULL;
    const char *c_str     = NULL;
    jstring local_string = J4AC_ohos_media_common_Format__getStringValue__withCString(env, thiz, key_cstr__);
    if (J4A_ExceptionCheck__throwAny(env) || !local_string) {
        goto fail;
    }

    c_str = (*env)->GetStringUTFChars(env, local_string, NULL );
    if (J4A_ExceptionCheck__throwAny(env) || !c_str) {
        goto fail;
    }

    strlcpy(out_buf, c_str, out_len);
    ret_value = out_buf;

fail:
    J4A_ReleaseStringUTFChars__p(env, local_string, &c_str);
    J4A_DeleteLocalRef__p(env, &local_string);
    return ret_value;
}

const char *J4AC_ohos_media_common_Format__getStringValue__withCString__asCBuffer__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__, char *out_buf, int out_len)
{
    const char *ret_value = NULL;
    const char *c_str     = NULL;
    jstring local_string = J4AC_ohos_media_common_Format__getStringValue__withCString__catchAll(env, thiz, key_cstr__);
    if (J4A_ExceptionCheck__catchAll(env) || !local_string) {
        goto fail;
    }

    c_str = (*env)->GetStringUTFChars(env, local_string, NULL );
    if (J4A_ExceptionCheck__catchAll(env) || !c_str) {
        goto fail;
    }

    strlcpy(out_buf, c_str, out_len);
    ret_value = out_buf;

fail:
    J4A_ReleaseStringUTFChars__p(env, local_string, &c_str);
    J4A_DeleteLocalRef__p(env, &local_string);
    return ret_value;
}

int J4A_loadClass__J4AC_ohos_media_common_Format(JNIEnv *env)
{

    int         ret                   = -1;
    const char *J4A_UNUSED(name)      = NULL;
    const char *J4A_UNUSED(sign)      = NULL;
    jclass      J4A_UNUSED(class_id)  = NULL;
    int         J4A_UNUSED(api_level) = 0;

    if (class_J4AC_ohos_media_common_Format.id != NULL)
        return 0;

    sign = "ohos/media/common/Format";
    class_J4AC_ohos_media_common_Format.id = J4A_FindClass__asGlobalRef__catchAll(env, sign);
    if (class_J4AC_ohos_media_common_Format.id == NULL)
        goto fail;

    class_id = class_J4AC_ohos_media_common_Format.id;
    name     = "<init>";
    sign     = "()V";
    class_J4AC_ohos_media_common_Format.constructor_Format = J4A_GetMethodID__catchAll(env, class_id, name, sign);
    if (class_J4AC_ohos_media_common_Format.constructor_Format == NULL)
        goto fail;

    class_id = class_J4AC_ohos_media_common_Format.id;
    name     = "getIntValue";
    sign     = "(Ljava/lang/String;)I";
    class_J4AC_ohos_media_common_Format.method_getIntValue = J4A_GetMethodID__catchAll(env, class_id, name, sign);
    if (class_J4AC_ohos_media_common_Format.method_getIntValue == NULL)
        goto fail;

    class_id = class_J4AC_ohos_media_common_Format.id;
    name     = "getObjectValue";
    sign     = "(Ljava/lang/String;)Ljava/lang/Object;";
    class_J4AC_ohos_media_common_Format.method_getObjectValue = J4A_GetMethodID__catchAll(env, class_id, name, sign);
    if (class_J4AC_ohos_media_common_Format.method_getObjectValue == NULL)
        goto fail;

    class_id = class_J4AC_ohos_media_common_Format.id;
    name     = "putIntValue";
    sign     = "(Ljava/lang/String;I)V";
    class_J4AC_ohos_media_common_Format.method_putIntValue = J4A_GetMethodID__catchAll(env, class_id, name, sign);
    if (class_J4AC_ohos_media_common_Format.method_putIntValue == NULL)
        goto fail;

    class_id = class_J4AC_ohos_media_common_Format.id;
    name     = "putObjectValue";
    sign     = "(Ljava/lang/String;Ljava/lang/Object;)V";
    class_J4AC_ohos_media_common_Format.method_putObjectValue = J4A_GetMethodID__catchAll(env, class_id, name, sign);
    if (class_J4AC_ohos_media_common_Format.method_putObjectValue == NULL)
        goto fail;

    class_id = class_J4AC_ohos_media_common_Format.id;
    name     = "getStringValue";
    sign     = "(Ljava/lang/String;)Ljava/lang/String;";
    class_J4AC_ohos_media_common_Format.method_getStringValue = J4A_GetMethodID__catchAll(env, class_id, name, sign);
    if (class_J4AC_ohos_media_common_Format.method_getStringValue == NULL)
        goto fail;


    J4A_ALOGD("J4ALoader: OK: '%s' loaded\n", "ohos.media.common.Format");
    ret = 0;
fail:

    return ret;
}
