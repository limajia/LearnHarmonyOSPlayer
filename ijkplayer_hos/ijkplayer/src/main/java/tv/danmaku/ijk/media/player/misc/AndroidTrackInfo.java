/*
 * Copyright (C) 2015 Bilibili
 * Copyright (C) 2015 Zhang Rui <bbcallen@gmail.com>
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

package tv.danmaku.ijk.media.player.misc;


import ohos.media.codec.TrackInfo;
import ohos.media.common.Format;
import ohos.media.player.Player;


public class AndroidTrackInfo implements ITrackInfo {

    private final TrackInfo mTrackInfo;

    public static AndroidTrackInfo[] fromMediaPlayer(Player mp) {
        return null;
    }

    private AndroidTrackInfo(TrackInfo trackInfo) {
        mTrackInfo = trackInfo;
    }

    @Override
    public IMediaFormat getFormat() {
        if (mTrackInfo == null)
            return null;

        Format mediaFormat = null;
        if (mediaFormat == null)
            return null;

        return new AndroidMediaFormat(mediaFormat);
    }


    @Override
    public String getLanguage() {
        if (mTrackInfo == null)
            return "und";

        return "und";
    }


    @Override
    public int getTrackType() {
        if (mTrackInfo == null)
            return MEDIA_TRACK_TYPE_UNKNOWN;

        return MEDIA_TRACK_TYPE_UNKNOWN;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(128);
        out.append(getClass().getSimpleName());
        out.append('{');
        if (mTrackInfo != null) {
            out.append(mTrackInfo.toString());
        } else {
            out.append("null");
        }
        out.append('}');
        return out.toString();
    }

    @Override
    public String getInfoInline() {
        if (mTrackInfo != null) {
            return mTrackInfo.toString();
        } else {
            return "null";
        }
    }
}
