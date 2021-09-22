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

import static ohos.agp.components.ComponentContainer.LayoutConfig.MATCH_CONTENT;
import static ohos.agp.components.ComponentContainer.LayoutConfig.MATCH_PARENT;

import com.tv.danmaku.ijk.constant.Constants;
import com.tv.danmaku.ijk.media.example.ResourceTable;
import com.tv.danmaku.ijk.media.example.ui.widget.media.OhosSurfaceComponent;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.IntentParams;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.DependentLayout;
import ohos.agp.components.Image;
import ohos.agp.components.ProgressBar;
import ohos.agp.components.Text;
import ohos.agp.components.element.Element;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.graphics.SurfaceOps;
import ohos.agp.utils.Color;
import ohos.agp.window.service.Window;
import ohos.agp.window.service.WindowManager;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;
import ohos.eventhandler.InnerEvent;
import ohos.multimodalinput.event.KeyEvent;

/**
 * 全屏自适应屏幕播放本地视频
 */
public class OhosPlayerAbilitySlice extends AbilitySlice implements SurfaceOps.Callback {
    // ohos原生播放器封装
    private OhosSurfaceComponent ohosSurfaceComponent;
    private ProgressBar roundProgressBar;
    private Text timePlay;
    private Image playBtn;

    private static final int MESSAGE_UPDATE_PLAY_TIME = 100;
    private static final int DELAY_TIME = 500;

    private EventHandler handler =
            new EventHandler(EventRunner.current()) {
                @Override
                protected void processEvent(InnerEvent event) {
                    super.processEvent(event);
                    if (event.eventId == MESSAGE_UPDATE_PLAY_TIME) {
                        int time = ohosSurfaceComponent.getPlayTime();
                        int hour = time / (60 * 60 * 1000);
                        int minute = (time - hour * 60 * 60 * 1000) / (60 * 1000);
                        int second = (time - hour * 60 * 60 * 1000 - minute * 60 * 1000) / 1000;
                        time = ohosSurfaceComponent.getAllTime();
                        int h1 = time / (60 * 60 * 1000);
                        int m1 = (time - hour * 60 * 60 * 1000) / (60 * 1000);
                        int s1 = (time - hour * 60 * 60 * 1000 - minute * 60 * 1000) / 1000;
                        if (event.eventId == MESSAGE_UPDATE_PLAY_TIME) {
                            roundProgressBar.setProgressValue(
                                    100 * ohosSurfaceComponent.getPlayTime() / ohosSurfaceComponent.getAllTime());
                            timePlay.setText(hour + ":" + minute + ":" + second + "/" + h1 + ":" + m1 + ":" + s1);
                            if (ohosSurfaceComponent.getPlayState() == OhosSurfaceComponent.STATE_PLAYING) {
                                handler.sendEvent(InnerEvent.get(MESSAGE_UPDATE_PLAY_TIME), DELAY_TIME);
                            }
                        }
                    }
                }
            };

    private Element getBackGroundFocus() {
        ShapeElement drawable = new ShapeElement();
        drawable.setShape(ShapeElement.RECTANGLE);
        RgbColor rgbColor = new RgbColor();
        rgbColor.setAlpha(0xaa);
        rgbColor.setRed(0x3E);
        rgbColor.setGreen(0x43);
        rgbColor.setBlue(0x49);
        drawable.setRgbColor(rgbColor);
        drawable.setCornerRadius(12);
        return drawable;
    }

    private Element getBackGroundNormal() {
        ShapeElement drawable = new ShapeElement();
        drawable.setShape(ShapeElement.RECTANGLE);
        RgbColor rgbColor = new RgbColor();
        rgbColor.setAlpha(0x00);
        rgbColor.setRed(0x00);
        rgbColor.setGreen(0x00);
        rgbColor.setBlue(0x00);
        drawable.setRgbColor(rgbColor);
        drawable.setCornerRadius(12);
        return drawable;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent keyEvent) {
        switch (keyCode) {
            case KeyEvent.KEY_DPAD_CENTER:
            case KeyEvent.KEY_ENTER:
                if (playBtn.hasFocus()) {
                    playBtn.callOnClick();
                }
                return true;
            default:
                break;
        }
        return false;
    }

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        IntentParams ip = intent.getParams();
        String videoPath = (String) ip.getParam(Constants.VIDEO_PATH);
        WindowManager windowManager = WindowManager.getInstance();
        Window window = windowManager.getTopWindow().get();
        window.setTransparent(true);
        getWindow().addFlags(WindowManager.LayoutConfig.MARK_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutConfig.MARK_TRANSLUCENT_NAVIGATION);
        getWindow().addFlags(WindowManager.LayoutConfig.MARK_FULL_SCREEN);

        DependentLayout myLayout = new DependentLayout(this);
        DependentLayout.LayoutConfig params = new DependentLayout.LayoutConfig(MATCH_PARENT, MATCH_PARENT);
        myLayout.setLayoutConfig(params);

        DependentLayout.LayoutConfig lpVideo = new DependentLayout.LayoutConfig(MATCH_PARENT, MATCH_PARENT);
        ohosSurfaceComponent = new OhosSurfaceComponent(this, this);
        ohosSurfaceComponent.setHandler(handler);
        myLayout.addComponent(ohosSurfaceComponent, lpVideo);

        DependentLayout rlParent = new DependentLayout(this);
        DependentLayout.LayoutConfig lpParent = new DependentLayout.LayoutConfig(MATCH_PARENT, MATCH_CONTENT);
        lpParent.addRule(DependentLayout.LayoutConfig.ALIGN_PARENT_BOTTOM);
        lpParent.setMarginLeft(40);
        lpParent.setMarginRight(40);
        lpParent.setMarginBottom(40);
        myLayout.addComponent(rlParent, lpParent);

        addPlayButtonComponent(rlParent);
        addPlayTimeComponent(rlParent);
        addPlayProgressComponent(rlParent);

        super.setUIContent(myLayout);
    }

    /**
     * 显示播放进度条
     *
     * @param rlParent parent component
     */
    private void addPlayProgressComponent(DependentLayout rlParent) {
        roundProgressBar = new ProgressBar(this);
        roundProgressBar.setProgressWidth(10);
        roundProgressBar.setProgressColor(Color.RED);
        roundProgressBar.setMaxValue(100);
        roundProgressBar.setProgressValue(0);
        DependentLayout.LayoutConfig lpProgressBar = new DependentLayout.LayoutConfig(MATCH_PARENT, 80);
        lpProgressBar.addRule(DependentLayout.LayoutConfig.RIGHT_OF, timePlay.getId());
        lpProgressBar.setMarginLeft(20);
        lpProgressBar.setMarginRight(100);
        rlParent.addComponent(roundProgressBar, lpProgressBar);
    }

    /**
     * 显示当前视频播放时间
     *
     * @param rlParent parent component
     */
    private void addPlayTimeComponent(DependentLayout rlParent) {
        timePlay = new Text(this);
        DependentLayout.LayoutConfig lpTimePlay = new DependentLayout.LayoutConfig(MATCH_CONTENT, MATCH_CONTENT);
        lpTimePlay.addRule(DependentLayout.LayoutConfig.VERTICAL_CENTER);
        timePlay.setLayoutConfig(lpTimePlay);
        timePlay.setId(1111);
        timePlay.setText("00:00/00:00");
        timePlay.setTextSize(60);
        timePlay.setTextColor(Color.WHITE);
        rlParent.addComponent(timePlay);
    }

    /**
     * 显示播放暂停按钮
     *
     * @param rlParent parent component
     */
    private void addPlayButtonComponent(DependentLayout rlParent) {
        playBtn = new Image(this);
        DependentLayout.LayoutConfig lpPlayBtn = new DependentLayout.LayoutConfig(80, 80);
        lpPlayBtn.addRule(DependentLayout.LayoutConfig.ALIGN_PARENT_RIGHT);
        playBtn.setBackground(getBackGroundFocus());
        playBtn.setLayoutConfig(lpPlayBtn);
        playBtn.setId(1112);
        playBtn.setPixelMap(ResourceTable.Media_ic_media_pause);
        playBtn.setScaleMode(Image.ScaleMode.STRETCH);
        playBtn.requestFocus();
        playBtn.setFocusChangedListener(
                (component, focusChange) -> {
                    if (focusChange) {
                        playBtn.setBackground(OhosPlayerAbilitySlice.this.getBackGroundFocus());
                    } else {
                        playBtn.setBackground(OhosPlayerAbilitySlice.this.getBackGroundNormal());
                    }
                });
        playBtn.setClickedListener(
                component -> {
                    if (ohosSurfaceComponent.getPlayState() == OhosSurfaceComponent.STATE_PLAYING) {
                        ohosSurfaceComponent.pause();
                        playBtn.setPixelMap(ResourceTable.Media_ic_media_play);
                    } else {
                        ohosSurfaceComponent.start();
                        playBtn.setPixelMap(ResourceTable.Media_ic_media_pause);
                    }
                });
        rlParent.addComponent(playBtn);
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (ohosSurfaceComponent != null) {
            ohosSurfaceComponent.destroy();
            ohosSurfaceComponent.removeFromWindow();
        }
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }

    @Override
    protected void onBackground() {
        super.onBackground();
    }

    @Override
    public void surfaceCreated(SurfaceOps surfaceOps) {
        ohosSurfaceComponent.playLocalVideo("resources/rawfile/local.mp4", true, surfaceOps);
    }

    @Override
    public void surfaceChanged(SurfaceOps surfaceOps, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceOps surfaceOps) {
        ohosSurfaceComponent.stop();
    }
}
