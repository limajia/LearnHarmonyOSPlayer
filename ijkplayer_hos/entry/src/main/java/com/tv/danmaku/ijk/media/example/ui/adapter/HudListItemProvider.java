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
import com.tv.danmaku.ijk.media.example.slice.IjkMediaPlayAilitySlice;

import ohos.agp.components.*;

import java.util.List;

/**
 * HudListItemProvider
 */
public class HudListItemProvider extends RecycleItemProvider {
    private IjkMediaPlayAilitySlice abilitySlice;

    private List<SampleItem> itemLists;

    public HudListItemProvider(IjkMediaPlayAilitySlice currentAbilitySlice, List<SampleItem> itemList) {
        this.abilitySlice = currentAbilitySlice;
        this.itemLists = itemList;
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
        Component rootView =
                LayoutScatter.getInstance(abilitySlice).parse(ResourceTable.Layout_item_hud_list, null, false);
        SampleItem sampleItem = itemLists.get(position);
        Text itemKey = (Text) rootView.findComponentById(ResourceTable.Id_item_key);
        Text itemValue = (Text) rootView.findComponentById(ResourceTable.Id_item_value);
        itemKey.setText(sampleItem.key);
        itemValue.setText(sampleItem.value);
        return rootView;
    }

    /**
     * setData for refrush listContainer
     */
    public void setData(List<SampleItem> newDataLists) {
        itemLists.containsAll(newDataLists);
        notifyDataChanged();
    }
}
