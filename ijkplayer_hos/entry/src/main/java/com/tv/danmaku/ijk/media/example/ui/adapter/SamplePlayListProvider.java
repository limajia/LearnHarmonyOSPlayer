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
package com.tv.danmaku.ijk.media.example.ui.adapter;


import com.tv.danmaku.ijk.media.example.ResourceTable;
import com.tv.danmaku.ijk.media.example.slice.SamplePlayListAbilitySlice;
import ohos.agp.components.*;

import java.util.List;

/**
 * 视频播放列表的适配器
 */
public class SamplePlayListProvider extends RecycleItemProvider {
    private static final String TAG = "SampleListItemProvider";

    private SamplePlayListAbilitySlice abilitySlice;

    private List<SampleItem> itemLists;

    public SamplePlayListProvider(SamplePlayListAbilitySlice currentAbilitySlice, List<SampleItem> itemList) {
        this.abilitySlice = currentAbilitySlice;
        if (itemList != null) {
            this.itemLists = itemList;
        }
    }

    @Override
    public int getCount() {
        return itemLists == null ? 0 : itemLists.size();
    }

    @Override
    public Object getItem(int position) {
        return itemLists == null ? null : itemLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Component getComponent(int position, Component component, ComponentContainer componentContainer) {
        return getRootView(position);
    }

    private Component getRootView(int position) {
        Component rootView = LayoutScatter.getInstance(abilitySlice)
                .parse(ResourceTable.Layout_item_sample_play_list, null, false);
        if (itemLists != null && itemLists.size() > 0) {
            SampleItem sampleItem = itemLists.get(position);
            Text itemName = (Text) rootView.findComponentById(ResourceTable.Id_item_name);
            Text itemUrl = (Text) rootView.findComponentById(ResourceTable.Id_item_url);
            itemName.setText(sampleItem.key);
            itemUrl.setText(sampleItem.value);
        }
        return rootView;
    }

}