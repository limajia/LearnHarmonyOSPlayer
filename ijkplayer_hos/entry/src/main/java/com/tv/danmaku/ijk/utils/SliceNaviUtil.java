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
package com.tv.danmaku.ijk.utils;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;

/**
 * 页面跳转工具类
 */
public class SliceNaviUtil {
    /**
     * pageslice页面跳转
     *
     * @param action  指定的路由
     * @param context 上下文
     */
    public static void gotoSlice(AbilitySlice context, String action) {
        Intent intent = new Intent();
        Operation operation = new Intent.OperationBuilder()
                .withAction(action)
                .build();
        intent.setOperation(operation);
        context.startAbilityForResult(intent, 1);
    }

    /**
     * pageslice携带基本类型的数据页面跳转
     *
     * @param action     指定的路由
     * @param context    上下文
     * @param intentData 携带的数据
     */
    public static void gotoSlice(AbilitySlice context, String action, Intent intentData) {
        Operation operation = new Intent.OperationBuilder()
                .withAction(action)
                .build();
        intentData.setOperation(operation);
        context.startAbility(intentData);
    }
}
