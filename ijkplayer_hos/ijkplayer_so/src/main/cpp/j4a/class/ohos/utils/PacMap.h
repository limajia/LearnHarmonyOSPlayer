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

#ifndef J4A__ohos_utils_PacMap__H
#define J4A__ohos_utils_PacMap__H

#include "j4a/j4a_base.h"

jobject J4AC_ohos_utils_PacMap__PacMap(JNIEnv *env);
jobject J4AC_ohos_utils_PacMap__PacMap__catchAll(JNIEnv *env);
jobject J4AC_ohos_utils_PacMap__PacMap__asGlobalRef__catchAll(JNIEnv *env);
jint J4AC_ohos_utils_PacMap__getIntValue(JNIEnv *env, jobject thiz, jstring key, jint defaultValue);
jint J4AC_ohos_utils_PacMap__getIntValue__catchAll(JNIEnv *env, jobject thiz, jstring key, jint defaultValue);
jint J4AC_ohos_utils_PacMap__getIntValue__withCString(JNIEnv *env, jobject thiz, const char *key_cstr__, jint defaultValue);
jint J4AC_ohos_utils_PacMap__getIntValue__withCString__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__, jint defaultValue);
void J4AC_ohos_utils_PacMap__putIntValue(JNIEnv *env, jobject thiz, jstring key, jint value);
void J4AC_ohos_utils_PacMap__putIntValue__catchAll(JNIEnv *env, jobject thiz, jstring key, jint value);
void J4AC_ohos_utils_PacMap__putIntValue__withCString(JNIEnv *env, jobject thiz, const char *key_cstr__, jint value);
void J4AC_ohos_utils_PacMap__putIntValue__withCString__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__, jint value);
jstring J4AC_ohos_utils_PacMap__getString(JNIEnv *env, jobject thiz, jstring key);
jstring J4AC_ohos_utils_PacMap__getString__catchAll(JNIEnv *env, jobject thiz, jstring key);
jstring J4AC_ohos_utils_PacMap__getString__asGlobalRef__catchAll(JNIEnv *env, jobject thiz, jstring key);
const char *J4AC_ohos_utils_PacMap__getString__asCBuffer(JNIEnv *env, jobject thiz, jstring key, char *out_buf, int out_len);
const char *J4AC_ohos_utils_PacMap__getString__asCBuffer__catchAll(JNIEnv *env, jobject thiz, jstring key, char *out_buf, int out_len);
jstring J4AC_ohos_utils_PacMap__getString__withCString(JNIEnv *env, jobject thiz, const char *key_cstr__);
jstring J4AC_ohos_utils_PacMap__getString__withCString__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__);
jstring J4AC_ohos_utils_PacMap__getString__withCString__asGlobalRef__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__);
const char *J4AC_ohos_utils_PacMap__getString__withCString__asCBuffer(JNIEnv *env, jobject thiz, const char *key_cstr__, char *out_buf, int out_len);
const char *J4AC_ohos_utils_PacMap__getString__withCString__asCBuffer__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__, char *out_buf, int out_len);
void J4AC_ohos_utils_PacMap__putString(JNIEnv *env, jobject thiz, jstring key, jstring value);
void J4AC_ohos_utils_PacMap__putString__catchAll(JNIEnv *env, jobject thiz, jstring key, jstring value);
void J4AC_ohos_utils_PacMap__putString__withCString(JNIEnv *env, jobject thiz, const char *key_cstr__, const char *value_cstr__);
void J4AC_ohos_utils_PacMap__putString__withCString__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__, const char *value_cstr__);
void J4AC_ohos_utils_PacMap__putSequenceableObjectList(JNIEnv *env, jobject thiz, jstring key, jobject sequenceables);
void J4AC_ohos_utils_PacMap__putSequenceableObjectList__catchAll(JNIEnv *env, jobject thiz, jstring key, jobject sequenceables);
void J4AC_ohos_utils_PacMap__putSequenceableObjectList__withCString(JNIEnv *env, jobject thiz, const char *key_cstr__, jobject sequenceables);
void J4AC_ohos_utils_PacMap__putSequenceableObjectList__withCString__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__, jobject sequenceables);
jlong J4AC_ohos_utils_PacMap__getLongValue(JNIEnv *env, jobject thiz, jstring key);
jlong J4AC_ohos_utils_PacMap__getLongValue__catchAll(JNIEnv *env, jobject thiz, jstring key);
jlong J4AC_ohos_utils_PacMap__getLongValue__withCString(JNIEnv *env, jobject thiz, const char *key_cstr__);
jlong J4AC_ohos_utils_PacMap__getLongValue__withCString__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__);
void J4AC_ohos_utils_PacMap__putLongValue(JNIEnv *env, jobject thiz, jstring key, jlong value);
void J4AC_ohos_utils_PacMap__putLongValue__catchAll(JNIEnv *env, jobject thiz, jstring key, jlong value);
void J4AC_ohos_utils_PacMap__putLongValue__withCString(JNIEnv *env, jobject thiz, const char *key_cstr__, jlong value);
void J4AC_ohos_utils_PacMap__putLongValue__withCString__catchAll(JNIEnv *env, jobject thiz, const char *key_cstr__, jlong value);
int J4A_loadClass__J4AC_ohos_utils_PacMap(JNIEnv *env);

#define J4A_HAVE_SIMPLE__J4AC_ohos_utils_PacMap

#define J4AC_PacMap__PacMap J4AC_ohos_utils_PacMap__PacMap
#define J4AC_PacMap__PacMap__asGlobalRef__catchAll J4AC_ohos_utils_PacMap__PacMap__asGlobalRef__catchAll
#define J4AC_PacMap__PacMap__catchAll J4AC_ohos_utils_PacMap__PacMap__catchAll
#define J4AC_PacMap__getIntValue J4AC_ohos_utils_PacMap__getIntValue
#define J4AC_PacMap__getIntValue__catchAll J4AC_ohos_utils_PacMap__getIntValue__catchAll
#define J4AC_PacMap__getIntValue__withCString J4AC_ohos_utils_PacMap__getIntValue__withCString
#define J4AC_PacMap__getIntValue__withCString__catchAll J4AC_ohos_utils_PacMap__getIntValue__withCString__catchAll
#define J4AC_PacMap__putIntValue J4AC_ohos_utils_PacMap__putIntValue
#define J4AC_PacMap__putIntValue__catchAll J4AC_ohos_utils_PacMap__putIntValue__catchAll
#define J4AC_PacMap__putIntValue__withCString J4AC_ohos_utils_PacMap__putIntValue__withCString
#define J4AC_PacMap__putIntValue__withCString__catchAll J4AC_ohos_utils_PacMap__putIntValue__withCString__catchAll
#define J4AC_PacMap__getString J4AC_ohos_utils_PacMap__getString
#define J4AC_PacMap__getString__asCBuffer J4AC_ohos_utils_PacMap__getString__asCBuffer
#define J4AC_PacMap__getString__asCBuffer__catchAll J4AC_ohos_utils_PacMap__getString__asCBuffer__catchAll
#define J4AC_PacMap__getString__asGlobalRef__catchAll J4AC_ohos_utils_PacMap__getString__asGlobalRef__catchAll
#define J4AC_PacMap__getString__catchAll J4AC_ohos_utils_PacMap__getString__catchAll
#define J4AC_PacMap__getString__withCString J4AC_ohos_utils_PacMap__getString__withCString
#define J4AC_PacMap__getString__withCString__asCBuffer J4AC_ohos_utils_PacMap__getString__withCString__asCBuffer
#define J4AC_PacMap__getString__withCString__asCBuffer__catchAll J4AC_ohos_utils_PacMap__getString__withCString__asCBuffer__catchAll
#define J4AC_PacMap__getString__withCString__asGlobalRef__catchAll J4AC_ohos_utils_PacMap__getString__withCString__asGlobalRef__catchAll
#define J4AC_PacMap__getString__withCString__catchAll J4AC_ohos_utils_PacMap__getString__withCString__catchAll
#define J4AC_PacMap__putString J4AC_ohos_utils_PacMap__putString
#define J4AC_PacMap__putString__catchAll J4AC_ohos_utils_PacMap__putString__catchAll
#define J4AC_PacMap__putString__withCString J4AC_ohos_utils_PacMap__putString__withCString
#define J4AC_PacMap__putString__withCString__catchAll J4AC_ohos_utils_PacMap__putString__withCString__catchAll
#define J4AC_PacMap__putSequenceableObjectList J4AC_ohos_utils_PacMap__putSequenceableObjectList
#define J4AC_PacMap__putSequenceableObjectList__catchAll J4AC_ohos_utils_PacMap__putSequenceableObjectList__catchAll
#define J4AC_PacMap__putSequenceableObjectList__withCString J4AC_ohos_utils_PacMap__putSequenceableObjectList__withCString
#define J4AC_PacMap__putSequenceableObjectList__withCString__catchAll J4AC_ohos_utils_PacMap__putSequenceableObjectList__withCString__catchAll
#define J4AC_PacMap__getLongValue J4AC_ohos_utils_PacMap__getLongValue
#define J4AC_PacMap__getLongValue__catchAll J4AC_ohos_utils_PacMap__getLongValue__catchAll
#define J4AC_PacMap__getLongValue__withCString J4AC_ohos_utils_PacMap__getLongValue__withCString
#define J4AC_PacMap__getLongValue__withCString__catchAll J4AC_ohos_utils_PacMap__getLongValue__withCString__catchAll
#define J4AC_PacMap__putLongValue J4AC_ohos_utils_PacMap__putLongValue
#define J4AC_PacMap__putLongValue__catchAll J4AC_ohos_utils_PacMap__putLongValue__catchAll
#define J4AC_PacMap__putLongValue__withCString J4AC_ohos_utils_PacMap__putLongValue__withCString
#define J4AC_PacMap__putLongValue__withCString__catchAll J4AC_ohos_utils_PacMap__putLongValue__withCString__catchAll
#define J4A_loadClass__J4AC_PacMap J4A_loadClass__J4AC_ohos_utils_PacMap

#endif//J4A__ohos_utils_PacMap__H
