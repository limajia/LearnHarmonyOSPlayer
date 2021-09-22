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

#include <stdbool.h>
#ifndef ijkplayer_hos_ohos_log_H
#define ijkplayer_hos_ohos_log_H

#define OHOSIJK_LOG_TAG    "nativeijk"
enum IjkLogLevel {
    IL_INFO,
    IL_DEBUG,
    IL_WARN,
    IL_ERROR,
    IL_FATAL
};
#ifdef IJKDEBUG
#define OHLOGD(...) __ohos_log_print_debug(IL_DEBUG ,OHOSIJK_LOG_TAG,__FILE__,__LINE__,__VA_ARGS__)
#define OHLOGI(...) __ohos_log_print_debug(IL_INFO ,OHOSIJK_LOG_TAG, __FILE__,__LINE__,__VA_ARGS__)
#define OHLOGW(...) __ohos_log_print_debug(IL_WARN ,OHOSIJK_LOG_TAG,__FILE__,__LINE__, __VA_ARGS__)
#define OHLOGE(...) __ohos_log_print_debug(IL_ERROR ,OHOSIJK_LOG_TAG,__FILE__,__LINE__,__VA_ARGS__)
#define OHLOGF(...) __ohos_log_print_debug(IL_FATAL ,OHOSIJK_LOG_TAG,__FILE__,__LINE__,__VA_ARGS__)
#else
#define OHLOGD(...) __ohos_log_print(IL_DEBUG ,OHOSIJK_LOG_TAG, __VA_ARGS__)
#define OHLOGI(...) __ohos_log_print(IL_INFO ,OHOSIJK_LOG_TAG, __VA_ARGS__)
#define OHLOGW(...) __ohos_log_print(IL_WARN ,OHOSIJK_LOG_TAG, __VA_ARGS__)
#define OHLOGE(...) __ohos_log_print(IL_ERROR ,OHOSIJK_LOG_TAG,__VA_ARGS__)
#define OHLOGF(...) __ohos_log_print(IL_FATAL ,OHOSIJK_LOG_TAG,__VA_ARGS__)
#endif

#define OHOS_LOG_BUF_SIZE (4096)
#ifdef __cplusplus
extern "C" {
#endif
extern bool OHOS_LOG_ON;//log开关、默认关
void __ohos_log_print(enum IjkLogLevel level, const char* tag, const char* fmt, ...);
void __ohos_log_print_debug(enum IjkLogLevel level, const char* tag,const char* file,int line, const char* fmt, ...);
#ifdef __cplusplus
}
#endif
#endif//ijkplayer_hos_ohos_log.h_H
