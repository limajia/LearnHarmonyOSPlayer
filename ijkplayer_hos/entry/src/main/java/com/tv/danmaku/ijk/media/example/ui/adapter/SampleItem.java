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

import java.io.Serializable;

/**
 * SampleItem
 */
public class SampleItem implements Serializable {
    /**
     * value
     */
    public String value;
    /**
     * key
     */
    public String key;

    public SampleItem(String url, String name) {
        value = url;
        key = name;
    }

    public SampleItem() {
    }

    @Override
    public String toString() {
        return "SampleItem{" +
                "value='" + value + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
