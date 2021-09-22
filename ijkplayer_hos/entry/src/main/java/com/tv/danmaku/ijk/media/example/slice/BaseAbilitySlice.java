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

package com.tv.danmaku.ijk.media.example.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

/**
 * slice基类
 */
public abstract class BaseAbilitySlice extends AbilitySlice {
    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(getLayoutRes());
        initData();
    }

    @Override
    public void onActive() {
        super.onActive();
        initComponent();
    }

    /**
     * ability即将被销毁
     */
    @Override
    protected void onStop() {
        super.onStop();
        release();
    }


    /**
     * 布局layout
     *
     * @return 布局id
     */
    protected abstract int getLayoutRes();

    /**
     * component初始化
     */
    protected abstract void initComponent();

    /**
     * 数据初始化
     */
    protected abstract void initData();

    /**
     * 当ability即将被销毁时，释放资源
     */
    protected abstract void release();

}
