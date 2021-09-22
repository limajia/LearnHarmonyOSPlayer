
/*
 * Copyright (C) 2006 Bilibili
 * Copyright (C) 2006 The Android Open Source Project
 * Copyright (C) 2013 Zhang Rui <bbcallen@gmail.com>
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

package tv.danmaku.ijk.media.player;


import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;

import ohos.agp.graphics.Surface;
import ohos.agp.graphics.SurfaceOps;
import ohos.app.Context;
import ohos.media.audio.AudioManager;
import ohos.media.audio.AudioStreamInfo;
import ohos.media.player.Player;
import ohos.utils.net.Uri;
import tv.danmaku.ijk.media.player.misc.AndroidTrackInfo;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.pragma.DebugLog;

public class AndroidMediaPlayer extends AbstractMediaPlayer {

    private final Player mInternalMediaPlayer;
    private String mDataSource;


    private final Object mInitLock = new Object();
    private boolean mIsReleased;

    private static MediaInfo sMediaInfo;

    public AndroidMediaPlayer(Context context) {
        synchronized (mInitLock) {
            mInternalMediaPlayer = new Player(context);
        }
        attachInternalListeners();
    }

    public Player getInternalMediaPlayer() {
        return mInternalMediaPlayer;
    }

    @Override
    public void setDisplay(SurfaceOps sh) {
    }

    @Override
    public void setSurface(Surface surface) {
    }

    @Override
    public void setDataSource(Context context, Uri uri)
            throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
    }


    @Override
    public void setDataSource(Context context, Uri uri, Map<String, String> headers)
            throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
    }

    @Override
    public void setDataSource(FileDescriptor fd)
            throws IOException, IllegalArgumentException, IllegalStateException {
    }

    @Override
    public void setDataSource(String path) throws IOException,
            IllegalArgumentException, SecurityException, IllegalStateException {
        mDataSource = path;
        Uri uri = Uri.parse(path);
        String scheme = uri.getScheme();
    }

    @Override
    public void setDataSource(IMediaDataSource mediaDataSource) {
        releaseMediaDataSource();

    }



    @Override
    public String getDataSource() {
        return mDataSource;
    }

    private void releaseMediaDataSource() {

    }

    @Override
    public void prepareAsync() throws IllegalStateException {
        mInternalMediaPlayer.prepare();
    }

    @Override
    public void start() throws IllegalStateException {
        mInternalMediaPlayer.play();
    }

    @Override
    public void stop() throws IllegalStateException {
        mInternalMediaPlayer.stop();
    }

    @Override
    public void pause() throws IllegalStateException {
        mInternalMediaPlayer.pause();
    }

    @Override
    public void setScreenOnWhilePlaying(boolean screenOn) {
       mInternalMediaPlayer.enableScreenOn(screenOn);
    }

    @Override
    public ITrackInfo[] getTrackInfo() {
        return AndroidTrackInfo.fromMediaPlayer(mInternalMediaPlayer);
    }

    @Override
    public int getVideoWidth() {
        return mInternalMediaPlayer.getVideoWidth();
    }

    @Override
    public int getVideoHeight() {
        return mInternalMediaPlayer.getVideoHeight();
    }

    @Override
    public int getVideoSarNum() {
        return 1;
    }

    @Override
    public int getVideoSarDen() {
        return 1;
    }

    @Override
    public boolean isPlaying() {
        try {
            return mInternalMediaPlayer.isNowPlaying();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
            return false;
        }
    }

    @Override
    public void seekTo(long msec) throws IllegalStateException {
        mInternalMediaPlayer.rewindTo(  msec);
    }

    @Override
    public long getCurrentPosition() {
        try {
            return mInternalMediaPlayer.getCurrentTime();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
            return 0;
        }
    }

    @Override
    public long getDuration() {
        try {
            return mInternalMediaPlayer.getDuration();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
            return 0;
        }
    }

    @Override
    public void release() {
        mIsReleased = true;
        mInternalMediaPlayer.release();
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    @Override
    public void reset() {
        try {
            mInternalMediaPlayer.reset();
        } catch (IllegalStateException e) {
            DebugLog.printStackTrace(e);
        }
        releaseMediaDataSource();
        resetListeners();
        attachInternalListeners();
    }

    @Override
    public void setLooping(boolean looping) {
        mInternalMediaPlayer.enableSingleLooping(looping);
    }

    @Override
    public boolean isLooping() {
        return mInternalMediaPlayer.isSingleLooping();
    }

    @Override
    public void setVolume(float leftVolume, float rightVolume) {
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    @Override
    public MediaInfo getMediaInfo() {
        if (sMediaInfo == null) {
            MediaInfo module = new MediaInfo();

            module.mVideoDecoder = "android";
            module.mVideoDecoderImpl = "HW";

            module.mAudioDecoder = "android";
            module.mAudioDecoderImpl = "HW";

            sMediaInfo = module;
        }

        return sMediaInfo;
    }

    @Override
    public void setLogEnabled(boolean enable) {
    }

    @Override
    public boolean isPlayable() {
        return true;
    }

    /*--------------------
     * misc
     */
    @Override
    public void setWakeMode(Context context, int mode) {

    }

    @Override
    public void setAudioStreamType(int streamtype) {
        mInternalMediaPlayer.setAudioStreamType(streamtype);
    }

    @Override
    public void setKeepInBackground(boolean keepInBackground) {
    }

    /*--------------------
     * Listeners adapter
     */
    private void attachInternalListeners() {

    }

}
