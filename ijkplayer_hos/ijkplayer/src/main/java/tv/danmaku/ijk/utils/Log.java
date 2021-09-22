/*
 * Copyright (C) 2021 Huawei Device Co., Ltd.
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

package tv.danmaku.ijk.utils;

import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

/**
 * Log工具类
 */
public class Log {
    public static void e(String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0, tag);
        HiLog.error(label, message);
    }

    public static void d(String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0, tag);
        HiLog.info(label, message);
    }

    public static void v(String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0, tag);
        HiLog.info(label, message);
    }

    public static void i(String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0, tag);
        HiLog.info(label, message);
    }

    public static void w(String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0, tag);
        HiLog.warn(label, message);
    }

    public static void wtf(String tag, String message) {
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0, tag);
        HiLog.fatal(label, message);
    }
}
