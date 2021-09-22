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
import com.tv.danmaku.ijk.media.example.ResourceTable;
import com.tv.danmaku.ijk.media.example.ui.adapter.HudListItemProvider;
import com.tv.danmaku.ijk.media.example.ui.adapter.SampleItem;
import com.tv.danmaku.ijk.media.example.ui.widget.media.IjkVideoView;
import com.tv.danmaku.ijk.utils.LogUtils;

import ohos.aafwk.content.Intent;
import ohos.aafwk.content.IntentParams;
import ohos.agp.components.Component;
import ohos.agp.components.Image;
import ohos.agp.components.ListContainer;
import ohos.agp.components.Slider;
import ohos.agp.components.Text;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;
import ohos.eventhandler.InnerEvent;
import ohos.global.resource.RawFileDescriptor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/**
 * ijk视频播放器页面：播放网络视频和本地视频
 * 默认播放传过来的网络视频，当需要播放本地视频时请打开initData中的代码，并修改initIjkVideoView中的代码为本地视频路径
 */
public class IjkMediaPlayAilitySlice extends BaseAbilitySlice
        implements Component.ClickedListener, Slider.ValueChangedListener {
    private static final String TAG = "VideoPlayAilitySlice";
    private MyHandler handler = new MyHandler(EventRunner.getMainEventRunner());
    private String videoPath;
    private boolean mDragging;
    private StringBuilder mFormatBuilder;
    private Formatter mFormatter;
    private HudListItemProvider listItemProvider;
    private ListContainer hudListContainer;
    private IjkVideoView ijkVideoView;
    private Image mPauseButton;
    private Slider mProgress;
    private Text mEndTime;
    private Text mCurrentTime;

    // 单位ms
    private static final long DELAYTIME = 500;
    private List<String> playList = new ArrayList<>();
    private int curIndex = -1;
    private InputStream inStream;
    private FileOutputStream fs;
    private RawFileDescriptor rfd;

    @Override
    protected int getLayoutRes() {
        return ResourceTable.Layout_video_play_slice;
    }

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        IntentParams ip = intent.getParams();
        videoPath = (String) ip.getParam(Constants.VIDEO_PATH);
        initData();
        initComponent();
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeTask(mShowProgress);
        handler.removeAllEvent();
        if (ijkVideoView != null) {
            ijkVideoView.stopPlayback();
            // 在释放的时候请考虑，频繁在两个页面切换播放的场景，reset可能会超时阻塞主线程，需要规避。
            ijkVideoView.release(true);
        }
    }

    @Override
    protected void initComponent() {
        initTitleBarView();
        initHudView();
        initIjkVideoView();
        initMediaControllerView();
    }

    private void initMediaControllerView() {
        mPauseButton = (Image) findComponentById(ResourceTable.Id_pause);
        if (mPauseButton != null) {
            mPauseButton.requestFocus();
            mPauseButton.setClickedListener(this);
        }

        mProgress = (Slider) findComponentById(ResourceTable.Id_mediacontroller_progress);
        mCurrentTime = (Text) findComponentById(ResourceTable.Id_time_current);
        mEndTime = (Text) findComponentById(ResourceTable.Id_time);
        Image mFfwdButton = (Image) findComponentById(ResourceTable.Id_ffwd);
        Image mRewButton = (Image) findComponentById(ResourceTable.Id_rew);
        Image mSwitchImag = (Image) findComponentById(ResourceTable.Id_next);

        mRewButton.setClickedListener(this);
        mFfwdButton.setClickedListener(this);
        mProgress.setValueChangedListener(this);
        mSwitchImag.setClickedListener(this);

        mFormatBuilder = new StringBuilder();
        mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());
    }

    private void initIjkVideoView() {
        ijkVideoView = (IjkVideoView) findComponentById(ResourceTable.Id_video_view);
        ijkVideoView.setHudView();
        ijkVideoView.setVideoPath(videoPath);
        //        ijkVideoView.setVideoPath(playList.get(0)); // 本地视频播放
        ijkVideoView.setOnPreparedListener(
                mp -> {
                    // note: onPrepared回调之后才能获取数据，例如播放状态，总时长等
                    handler.sendEvent(MSG_UPDATE_HUD, DELAYTIME);
                    handler.sendEvent(MSG_PLAYER_DEFAULT_STATUS, DELAYTIME);
                });
        ijkVideoView.start();
    }

    private void initHudView() {
        hudListContainer = (ListContainer) findComponentById(ResourceTable.Id_hud_view);
    }

    private void initTitleBarView() {
        Component tvBack = findComponentById(ResourceTable.Id_tv_action_back);
        tvBack.setClickedListener(this);
    }

    @Override
    protected void initData() {
        //        loadLocalVideoFile();
        //        initLocalPlayLists();
    }

    @Override
    protected void release() {}

    @Override
    public void onClick(Component component) {
        switch (component.getId()) {
            case ResourceTable.Id_pause:
                doPauseResume();
                break;
            case ResourceTable.Id_ffwd:
                int pos = (int) ijkVideoView.getCurrentPosition();
                pos += 5000; // milliseconds
                ijkVideoView.seekTo(pos);
                setProgress();
                break;
            case ResourceTable.Id_rew:
                int posRew = (int) ijkVideoView.getCurrentPosition();
                posRew -= 3000; // milliseconds
                ijkVideoView.seekTo(posRew);
                setProgress();
                break;
            case ResourceTable.Id_next:
                // 切换视频
                playNextVideo();
                break;
        }
    }

    /**
     * 加载本地视频
     */
    private void loadLocalVideoFile() {
        try {
            String filePath = getFilesDir() + File.separator + "local.mp4";
            rfd = getResourceManager().getRawFileEntry("resources/rawfile/local.mp4").openRawFileDescriptor();
            long start = rfd.getStartPosition();
            long fileSize = rfd.getFileSize();
            // 读入原文件
            inStream = new FileInputStream(rfd.getFileDescriptor());
            inStream.skip(start);
            fs = new FileOutputStream(filePath);
            byte[] buffer = new byte[(int) fileSize];
            inStream.read(buffer);
            fs.write(buffer);
        } catch (IOException e) {
            LogUtils.e(TAG, e.getMessage());
        } finally {
            try {
                fs.close();
                inStream.close();
                rfd.close();
            } catch (IOException e) {
                LogUtils.e(TAG, e.getMessage());
            }
        }
    }

    /**
     * 本地视频,可自行在resources/rawfile下预制本地媒体资源测试
     */
    private void initLocalPlayLists() {
        playList.add(getFilesDir() + File.separator + "local.mp4");
    }

    private void playNextVideo() {
        try {
            if (curIndex == playList.size() - 1) {
                curIndex = 0;
            } else {
                curIndex++;
            }
            if (ijkVideoView != null) {
                ijkVideoView.stopPlayback();
                ijkVideoView.release(true);
            }
            ijkVideoView.setVideoPath(playList.get(curIndex));
            ijkVideoView.start();

        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }

    // =========================================音视频界面控制按钮==================================================================

    private void updatePausePlay() {
        if (mPauseButton == null) {
            return;
        }
        if (ijkVideoView.isPlaying()) {
            mPauseButton.setPixelMap(ResourceTable.Media_ic_media_pause);
        } else {
            mPauseButton.setPixelMap(ResourceTable.Media_ic_media_play);
        }
    }

    private void doPauseResume() {
        if (ijkVideoView.isPlaying()) {
            ijkVideoView.pause();
        } else {
            ijkVideoView.start();
        }
        // 执行暂停、播放之后再更新Ui
        updatePausePlay();
    }

    private long setProgress() {
        if (ijkVideoView == null || mDragging) {
            return 0;
        }
        long position = ijkVideoView.getCurrentPosition();
        long duration = ijkVideoView.getDuration();

        if (mProgress != null) {
            if (duration > 0) {
                // use long to avoid overflow
                long pos = 1000L * position / duration;
                mProgress.setProgressValue((int) pos);
            }
            int percent = ijkVideoView.getBufferPercentage();
            mProgress.setViceProgress(percent * 10);
        }
        if (mEndTime != null) {
            mEndTime.setText(stringForTime(duration));
        }
        if (mCurrentTime != null) {
            mCurrentTime.setText(stringForTime(position));
        }
        return position;
    }

    private String stringForTime(long timeMs) {
        int totalSeconds = (int) (timeMs / 1000);

        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;

        mFormatBuilder.setLength(0);
        if (hours > 0) {
            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } else {
            return mFormatter.format("%02d:%02d", minutes, seconds).toString();
        }
    }

    @Override
    public void onProgressUpdated(Slider slider, int progressValue, boolean updated) {
        if (!updated) {
            return;
        }
        long duration = ijkVideoView.getDuration();
        long newposition = (duration * progressValue) / 1000L;
        ijkVideoView.seekTo((int) newposition);
        if (mCurrentTime != null) {
            mCurrentTime.setText(stringForTime((int) newposition));
        }
    }

    @Override
    public void onTouchStart(Slider slider) {
        mDragging = true;
        handler.removeTask(mShowProgress);
    }

    @Override
    public void onTouchEnd(Slider slider) {
        mDragging = false;
        setProgress();
        updatePausePlay();
        handler.postTask(mShowProgress);
    }

    // ===========================================实时刷新显示码流等信息===================================================
    private static final int MSG_UPDATE_HUD = 1;
    private static final int MSG_PLAYER_DEFAULT_STATUS = 2;
    private final Runnable mShowProgress =
            new Runnable() {
                @Override
                public void run() {
                    long pos = setProgress();
                    if (!mDragging && ijkVideoView.isPlaying()) {
                        handler.postTask(mShowProgress, 1000 - (pos % 1000));
                    }
                }
            };

    private class MyHandler extends EventHandler {
        MyHandler(EventRunner runner) throws IllegalArgumentException {
            super(runner);
        }

        @Override
        protected void processEvent(InnerEvent event) {
            super.processEvent(event);
            switch (event.eventId) {
                case MSG_PLAYER_DEFAULT_STATUS:
                    setProgress();
                    updatePausePlay();
                    handler.postTask(mShowProgress);
                    handler.removeEvent(MSG_PLAYER_DEFAULT_STATUS);
                    break;
                case MSG_UPDATE_HUD: {
                    // 每500ms刷新一次数据
                    if (ijkVideoView != null) {
                        List<SampleItem> itemHudViewList = ijkVideoView.getHudViewDataLists();
                        if (itemHudViewList != null && itemHudViewList.size() > 0) {
                            if (listItemProvider == null) {
                                listItemProvider =
                                        new HudListItemProvider(IjkMediaPlayAilitySlice.this, itemHudViewList);
                                hudListContainer.setItemProvider(listItemProvider);
                            } else {
                                listItemProvider.setData(itemHudViewList);
                            }
                        }
                    }
                    handler.removeEvent(MSG_UPDATE_HUD);
                    handler.sendEvent(MSG_UPDATE_HUD, DELAYTIME);
                }
                break;
            }
        }
    }
}
