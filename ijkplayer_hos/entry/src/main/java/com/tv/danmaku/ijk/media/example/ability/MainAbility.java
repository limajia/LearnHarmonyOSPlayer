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

package com.tv.danmaku.ijk.media.example.ability;

import com.tv.danmaku.ijk.constant.RouteRegister;
import com.tv.danmaku.ijk.media.example.slice.IjkMediaPlayAilitySlice;
import com.tv.danmaku.ijk.media.example.slice.MainAbilitySlice;
import com.tv.danmaku.ijk.media.example.slice.OhosPlayerAbilitySlice;
import com.tv.danmaku.ijk.media.example.slice.SamplePlayListAbilitySlice;
import com.tv.danmaku.ijk.utils.LogUtils;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.bundle.IBundleManager;

/**
 * 程序主界面入口
 */
public class MainAbility extends Ability {
    private String TAG = "MainAbility";
    private String[] permissionLists = new String[] {"ohos.permission.READ_MEDIA", "ohos.permission.WRITE_MEDIA"};
    private int REQUESTCODE = 1;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());

        initActionRoute();

        verifyPermissions();
    }

    /**
     * 统一管理页面跳转的路由，请注意在config.json里面静态注册action
     */
    private void initActionRoute() {
        addActionRoute(RouteRegister.SLICE_SAMPLY_PLAY_LIST, SamplePlayListAbilitySlice.class.getName());
        addActionRoute(RouteRegister.SLICE_VIDEO_PLAY, IjkMediaPlayAilitySlice.class.getName());
        addActionRoute(RouteRegister.SLICE_FULLSCREEN_PLAY, OhosPlayerAbilitySlice.class.getName());
    }

    private void verifyPermissions() {
        // 权限验证
        for (String permissionList : permissionLists) {
            int result = verifySelfPermission(permissionList);
            if (result != IBundleManager.PERMISSION_GRANTED) {
                requestPermissionsFromUser(permissionLists, REQUESTCODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsFromUserResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUESTCODE) {
            if (grantResults.length > 0 && grantResults[0] == IBundleManager.PERMISSION_GRANTED) {
                LogUtils.debug(TAG, "requestPermission success");
            }
        }
    }
}
