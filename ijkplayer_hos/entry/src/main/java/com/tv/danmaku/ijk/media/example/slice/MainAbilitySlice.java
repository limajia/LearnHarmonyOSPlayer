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

import com.tv.danmaku.ijk.constant.RouteRegister;
import com.tv.danmaku.ijk.media.example.ResourceTable;
import com.tv.danmaku.ijk.utils.SliceNaviUtil;

import ohos.aafwk.content.Intent;

/**
 * 程序主界面入口
 */
public class MainAbilitySlice extends BaseAbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
    }

    @Override
    protected int getLayoutRes() {
        return ResourceTable.Layout_ability_main;
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    /**
     * initComponent
     */
    protected void initComponent() {
        findComponentById(ResourceTable.Id_tv_sample_play_list)
                .setClickedListener(
                        component ->
                                SliceNaviUtil.gotoSlice(MainAbilitySlice.this, RouteRegister.SLICE_SAMPLY_PLAY_LIST));
        findComponentById(ResourceTable.Id_tv_fullscreen_play)
                .setClickedListener(
                        component ->
                                SliceNaviUtil.gotoSlice(MainAbilitySlice.this, RouteRegister.SLICE_FULLSCREEN_PLAY));
    }

    @Override
    protected void initData() {}

    @Override
    protected void release() {}
}