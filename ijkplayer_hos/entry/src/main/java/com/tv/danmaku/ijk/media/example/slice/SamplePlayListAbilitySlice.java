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

import com.tv.danmaku.ijk.constant.Constants;
import com.tv.danmaku.ijk.constant.RouteRegister;
import com.tv.danmaku.ijk.media.example.ResourceTable;
import com.tv.danmaku.ijk.media.example.ui.adapter.SampleItem;
import com.tv.danmaku.ijk.media.example.ui.adapter.SamplePlayListProvider;
import com.tv.danmaku.ijk.utils.SliceNaviUtil;

import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * 视频列表入口
 */
public class SamplePlayListAbilitySlice extends BaseAbilitySlice implements ListContainer.ItemClickedListener {
    private SamplePlayListProvider listItemProvider;
    private List<SampleItem> itemList = null;

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
    }

    @Override
    protected int getLayoutRes() {
        return ResourceTable.Layout_sample_play_list_slice;
    }

    @Override
    protected void initComponent() {
        ListContainer listContainer = (ListContainer) findComponentById(ResourceTable.Id_sample_file_list_view);
        listItemProvider = new SamplePlayListProvider(SamplePlayListAbilitySlice.this, itemList);
        listContainer.setItemClickedListener(this);
        listContainer.setItemProvider(listItemProvider);
    }

    @Override
    protected void initData() {
        itemList = new ArrayList<>();
        // 视频播放url可自行补充
        itemList.add(
                new SampleItem(
                        "https://newcntv.qcloudcdn"
                                + ".com/asp/hls/450/0303000a/3/default"
                                + "/84f142fa588d499d91ef249a01592d95/450.m3u8",
                        "m3u8 test 1"));
        itemList.add(
                new SampleItem(
                        "http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear4/prog_index.m3u8",
                        "bipbop basic 960x720 @ 2 Mbps"));
        itemList.add(
                new SampleItem(
                        "http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_16x9/gear5/prog_index.m3u8",
                        "bipbop advanced 1920x1080 @ 2 Mbps"));
    }

    @Override
    protected void release() {
        if (itemList != null && itemList.size() > 0) {
            itemList.clear();
            itemList = null;
        }
    }

    /**
     * 视频播放点击跳转入口
     *
     * @param listContainer 列表容器
     * @param component     点击的组件
     * @param position      被点击component在列表中的位置
     * @param id            被点击component对应的id
     */
    @Override
    public void onItemClicked(ListContainer listContainer, Component component, int position, long id) {
        SampleItem itemProviderItem = (SampleItem) listItemProvider.getItem(position);
        Intent intentData = new Intent();
        intentData.setParam(Constants.VIDEO_TITLE, itemProviderItem.key);
        intentData.setParam(Constants.VIDEO_PATH, itemProviderItem.value);
        SliceNaviUtil.gotoSlice(SamplePlayListAbilitySlice.this, RouteRegister.SLICE_VIDEO_PLAY, intentData);
    }
}
