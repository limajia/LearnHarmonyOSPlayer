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

package com.tv.danmaku.ijk.media.example.ui.widget.media;

import com.tv.danmaku.ijk.utils.LogUtils;

import ohos.agp.components.surfaceprovider.SurfaceProvider;
import ohos.agp.graphics.SurfaceOps;
import ohos.agp.utils.Point;
import ohos.agp.window.service.DisplayManager;
import ohos.app.Context;
import ohos.app.dispatcher.task.TaskPriority;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.InnerEvent;
import ohos.media.common.Source;
import ohos.media.player.Player;

import java.io.IOException;
import java.util.Optional;

/**
 * 自定义的SurfaceProvider，使用ohos原生的Player播放视频
 */
public class OhosSurfaceComponent extends SurfaceProvider implements Player.IPlayerCallback {
    private String TAG = "VideoComponent";

    private static final int STATE_DEFAULT = 0x101; // 默认状态
    private static final int STATE_INIT = 0x102; // 初始化
    private static final int STATE_PAUSE = 0x104; // 暂停播放
    private static final int STATE_STOP = 0X105; // 结束播放
    private static final int STATE_DESTROY = 0x106; // 销毁
    /**
     * 播放中
     */
    public static final int STATE_PLAYING = 0x103;

    private static final int MESSAGE_UPDATE_PLAY_TIME = 100; // event id
    private int screenHeight; // 屏幕高度，用于自适应屏幕
    private int screenWidth; // 屏幕宽度，用于自适应屏幕

    /**
     * 设置handler
     *
     * @param handler EventHandler
     */
    public void setHandler(EventHandler handler) {
        this.handler = handler;
    }

    private EventHandler handler;

    private final Player player;

    private int state = STATE_DEFAULT;

    public OhosSurfaceComponent(Context context, SurfaceOps.Callback callback) {
        super(context);
        DisplayManager dm = DisplayManager.getInstance();
        Point point = new Point();
        dm.getDefaultDisplay(getContext()).get().getRealSize(point);
        screenWidth = (int) point.position[0];
        screenHeight = (int) point.position[1];
        player = new Player(getContext());
        player.setPlayerCallback(this);
        Optional<SurfaceOps> surfaceHolderOptional = getSurfaceOps();
        SurfaceOps surfaceHolder = surfaceHolderOptional.get();
        surfaceHolder.addCallback(callback);
        state = STATE_INIT;
    }

    /**
     * 获取视频总时长
     *
     * @return Duration
     */
    public int getAllTime() {
        return player.getDuration();
    }

    /**
     * 获取视频当前播放时间
     *
     * @return CurrentTime
     */
    public int getPlayTime() {
        return player.getCurrentTime();
    }

    /**
     * 获取视频当前播放时间
     *
     * @return CurrentTime
     */
    public int getCurrentTime() {
        return currentTime;
    }

    /**
     * 设置指定的视频播放时间
     *
     * @param currentTime 指定的时间
     */
    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    private int currentTime = 0;

    /**
     * 播放在线视频
     *
     * @param holder    holder
     * @param isLooping 是否循环
     * @param videoUrl  url
     */
    public void playOnlineVideo(String videoUrl, boolean isLooping, SurfaceOps holder) {
        // 设置播放的视频URL
        player.setSource(new Source(videoUrl));
        player.setVideoSurface(holder.getSurface());
        player.enableSingleLooping(isLooping);
        player.enableScreenOn(true);
        initPlayViewSize();
        // 在线视频播放是耗时操作，需要放在子线程播放
        getContext()
                .getGlobalTaskDispatcher(TaskPriority.HIGH)
                .asyncDispatch(
                        new Runnable() {
                            @Override
                            public void run() {
                                player.prepare();
                                player.play();
                                player.rewindTo(getCurrentTime() * 1000);
                                state = STATE_PLAYING;
                                handler.sendEvent(InnerEvent.get(MESSAGE_UPDATE_PLAY_TIME));
                            }
                        });
    }

    /**
     * 播放本地资源的视频
     *
     * @param fileName  文件路径
     * @param isLooping 是否循环
     * @param holder    holder
     */
    public void playLocalVideo(String fileName, boolean isLooping, SurfaceOps holder) {
        try {
            player.setSource(getContext().getResourceManager().getRawFileEntry(fileName).openRawFileDescriptor());
            player.setVideoSurface(holder.getSurface());
            player.enableSingleLooping(isLooping);
            player.enableScreenOn(true);
            initPlayViewSize();
            // 在线视频播放是耗时操作，需要放在子线程播放
            getContext()
                    .getGlobalTaskDispatcher(TaskPriority.HIGH)
                    .asyncDispatch(
                            new Runnable() {
                                @Override
                                public void run() {
                                    player.prepare();
                                    player.play();
                                    player.rewindTo(getCurrentTime() * 1000);
                                    state = STATE_PLAYING;
                                    handler.sendEvent(InnerEvent.get(MESSAGE_UPDATE_PLAY_TIME));
                                }
                            });
        } catch (IOException ioe) {
            LogUtils.e(TAG, ioe.getMessage());
        }
    }

    /**
     * 播放分布式系统中的视频
     *
     * @param source    文件路径
     * @param isLooping 是否循环
     * @param holder    holder
     */
    public void playDistributedVideo(Source source, boolean isLooping, SurfaceOps holder) {
        player.setSource(source);
        player.setVideoSurface(holder.getSurface());
        player.enableSingleLooping(isLooping);
        player.enableScreenOn(true);
        initPlayViewSize();
        // 在线视频播放是耗时操作，需要放在子线程播放
        getContext()
                .getGlobalTaskDispatcher(TaskPriority.HIGH)
                .asyncDispatch(
                        new Runnable() {
                            @Override
                            public void run() {
                                player.prepare();
                                player.play();
                                player.rewindTo(getCurrentTime() * 1000);
                                state = STATE_PLAYING;
                                handler.sendEvent(InnerEvent.get(MESSAGE_UPDATE_PLAY_TIME));
                            }
                        });
    }

    /**
     * 播放界面自适应屏幕宽高
     */
    private void initPlayViewSize() {
        int videoWidth = player.getVideoWidth();
        int videoHeight = player.getVideoHeight();
        if (videoWidth < videoHeight) {
            double scale = screenHeight * 1.f / videoHeight;
            double currHeight = videoHeight * scale;
            double currWidth = videoWidth * scale;
            setHeight(((int) currHeight));
            setWidth(((int) currWidth));
        } else {
            double scale = screenWidth * 1.f / videoWidth;
            double currHeight = videoHeight * scale;
            double currWidth = videoWidth * scale;
            setHeight(((int) currHeight));
            setWidth(((int) currWidth));
        }
    }

    /**
     * 开始播放
     */
    public void start() {
        if (state == STATE_PAUSE || state == STATE_INIT) {
            player.play();
            state = STATE_PLAYING;
            handler.sendEvent(InnerEvent.get(MESSAGE_UPDATE_PLAY_TIME), 500);
        }
    }

    /**
     * 暂停播放
     */
    public void pause() {
        if (state == STATE_PLAYING) {
            player.pause();
            handler.removeAllEvent();
            state = STATE_PAUSE;
        }
    }

    /**
     * 停止播放
     */
    public void stop() {
        if (state == STATE_PLAYING || state == STATE_PAUSE) {
            setCurrentTime(player.getCurrentTime());
            player.pause();
            handler.removeAllEvent();
            state = STATE_STOP;
        }
    }

    /**
     * 获取播放状态
     *
     * @return int
     */
    public int getPlayState() {
        return state;
    }

    /**
     * 销毁资源
     */
    public void destroy() {
        player.stop();
        player.release();
        handler.removeAllEvent();
        state = STATE_DESTROY;
    }

    @Override
    public void onPlayBackComplete() {
        handler.sendEvent(InnerEvent.get(MESSAGE_UPDATE_PLAY_TIME), EventHandler.Priority.HIGH);
    }

    @Override
    public void onRewindToComplete() {}

    @Override
    public void onBufferingChange(int percent) {}

    @Override
    public void onNewTimedMetaData(Player.MediaTimedMetaData mediaTimedMetaData) {}

    @Override
    public void onMediaTimeIncontinuity(Player.MediaTimeInfo mediaTimeInfo) {}

    @Override
    public void onPrepared() {}

    @Override
    public void onMessage(int type, int extra) {}

    @Override
    public void onError(int errorType, int errorCode) {
        state = STATE_INIT;
        player.stop();
    }

    @Override
    public void onResolutionChanged(int width, int height) {}
}
