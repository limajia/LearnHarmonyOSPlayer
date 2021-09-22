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

#include "ohos_log.h"
#include <stdio.h>

#include <hilog/log.h>
bool OHOS_LOG_ON;//log开关、默认关
void __ohos_log_print(enum IjkLogLevel level, const char* tag, const char* fmt, ...)
{
    if (!OHOS_LOG_ON)
        return;
    char buf[OHOS_LOG_BUF_SIZE] = { 0 };
    va_list arg;
    va_start(arg, fmt);
    vsnprintf(buf, OHOS_LOG_BUF_SIZE, fmt, arg);
    switch(level){
        case IL_INFO:
        HiLogPrint(LOG_APP, LOG_INFO, LOG_DOMAIN, tag, "%{public}s", buf);break;
        case IL_DEBUG:
        HiLogPrint(LOG_APP, LOG_DEBUG, LOG_DOMAIN, tag, "%{public}s", buf);break;
        case IL_WARN:
        HiLogPrint(LOG_APP, LOG_WARN, LOG_DOMAIN, tag, "%{public}s", buf);break;
        case IL_ERROR:
        HiLogPrint(LOG_APP, LOG_ERROR, LOG_DOMAIN, tag, "%{public}s", buf);break;
        case IL_FATAL:
        HiLogPrint(LOG_APP, LOG_FATAL, LOG_DOMAIN, tag, "%{public}s", buf);break;
        default:
        HiLogPrint(LOG_APP, LOG_INFO, LOG_DOMAIN, tag, "%{public}s", buf);break;
    }
    va_end(arg);
}

void __ohos_log_print_debug(enum IjkLogLevel level, const char* tag, const char* file, int line, const char* fmt, ...)
{
    if (!OHOS_LOG_ON)
        return;
    char buf[OHOS_LOG_BUF_SIZE] = { 0 };
    va_list arg;
    va_start(arg, fmt);
    vsnprintf(buf, OHOS_LOG_BUF_SIZE, fmt, arg);
    switch(level){
        case IL_INFO:
        HiLogPrint(LOG_APP, LOG_INFO, LOG_DOMAIN, tag, "%{public}s:%{public}d %{public}s", file, line, buf);
        break;
        case IL_DEBUG:
        HiLogPrint(LOG_APP, LOG_DEBUG, LOG_DOMAIN, tag, "%{public}s:%{public}d %{public}s", file, line, buf);
        break;
        case IL_WARN:
        HiLogPrint(LOG_APP, LOG_WARN, LOG_DOMAIN, tag, "%{public}s:%{public}d %{public}s", file, line, buf);
        break;
        case IL_ERROR:
        HiLogPrint(LOG_APP, LOG_ERROR, LOG_DOMAIN, tag, "%{public}s:%{public}d %{public}s", file, line, buf);
        break;
        case IL_FATAL:
        HiLogPrint(LOG_APP, LOG_FATAL, LOG_DOMAIN, tag, "%{public}s:%{public}d %{public}s", file, line, buf);
        break;
        default:
        HiLogPrint(LOG_APP, LOG_INFO, LOG_DOMAIN, tag, "%{public}s:%{public}d %{public}s", file, line, buf);
        break;
    }
    va_end(arg);
}