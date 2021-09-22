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

package com.tv.danmaku.ijk.media.example.ui.widget.media;

import com.tv.danmaku.ijk.constant.MediaConstant;
import com.tv.danmaku.ijk.media.example.ui.adapter.InfoHudViewHolder;
import com.tv.danmaku.ijk.media.example.ui.adapter.SampleItem;
import com.tv.danmaku.ijk.resource.Resource;
import com.tv.danmaku.ijk.utils.LogUtils;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.StackLayout;
import ohos.agp.components.surfaceprovider.SurfaceProvider;
import ohos.agp.utils.LayoutAlignment;
import ohos.app.Context;
import ohos.media.audio.AudioInterrupt;
import ohos.media.audio.AudioManager;
import ohos.media.audio.AudioRemoteException;
import ohos.utils.net.Uri;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.utils.TextUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * VideoView （创建不同的player 和 不同的DisplayView）
 */
public class IjkVideoView extends StackLayout {
    private String TAG = "IjkVideoView";
    // settable by the client
    private Uri mUri;

    // all possible internal states
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PREPARING = 1;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;

    // mCurrentState is a VideoView object's current state.
    // mTargetState is the state that a method caller intends to reach.
    // For instance, regardless the VideoView object's current state,
    // calling pause() intends to bring the object to a target state
    // of STATE_PAUSED.
    private int mCurrentState = STATE_IDLE;
    private int mTargetState = STATE_IDLE;

    // All the stuff we need for playing and showing a video
    private IRenderView.ISurfaceHolder mSurfaceHolder = null;
    private IMediaPlayer mMediaPlayer = null;

    private int mVideoWidth;
    private int mVideoHeight;
    private int mSurfaceWidth;
    private int mSurfaceHeight;
    private int mVideoRotationDegree;
    private IMediaController mMediaController;
    private IMediaPlayer.OnCompletionListener mOnCompletionListener;
    private IMediaPlayer.OnPreparedListener mOnPreparedListener;
    private int mCurrentBufferPercentage;
    private IMediaPlayer.OnErrorListener mOnErrorListener;
    private IMediaPlayer.OnInfoListener mOnInfoListener;
    private int mSeekWhenPrepared; // recording the seek position while preparing
    private boolean mCanPause = true;
    private boolean mCanSeekBack = true;
    private boolean mCanSeekForward = true;

    private IRenderView mRenderView;
    private int mVideoSarNum;
    private int mVideoSarDen;

    private InfoHudViewHolder mHudViewHolder;

    private long mPrepareStartTime = 0;

    private long mSeekStartTime = 0;
    private AudioManager audioManager;
    private AudioInterrupt audioInterrupt;

    public IjkVideoView(Context context) {
        super(context);
        initVideoView(context);
    }

    public IjkVideoView(Context context, AttrSet attrSet) {
        super(context, attrSet);
        initVideoView(context);
    }

    public IjkVideoView(Context context, AttrSet attrSet, String styleName) {
        super(context, attrSet, styleName);
        initVideoView(context);
    }

    private void initVideoView(Context context) {
        initBackground();
        initRenders();

        mVideoWidth = 0;
        mVideoHeight = 0;
        requestFocus();
        mCurrentState = STATE_IDLE;
        mTargetState = STATE_IDLE;
    }

    private void setRenderView(IRenderView renderView) {
        if (mRenderView != null) {
            if (mMediaPlayer != null) {
                mMediaPlayer.setDisplay(null);
            }

            Component renderUIView = mRenderView.getView();
            mRenderView.removeRenderCallback(mSHCallback);
            mRenderView = null;
            removeComponent(renderUIView);
        }

        if (renderView == null) {
            return;
        }

        mRenderView = renderView;
        renderView.setAspectRatio(mCurrentAspectRatio);
        if (mVideoWidth > 0 && mVideoHeight > 0) {
            renderView.setVideoSize(mVideoWidth, mVideoHeight);
        }
        if (mVideoSarNum > 0 && mVideoSarDen > 0) {
            renderView.setVideoSampleAspectRatio(mVideoSarNum, mVideoSarDen);
        }

        SurfaceProvider renderUIView = (SurfaceProvider) mRenderView.getView();
        renderUIView.setLayoutConfig(
                new LayoutConfig(
                        ComponentContainer.LayoutConfig.MATCH_PARENT,
                        ComponentContainer.LayoutConfig.MATCH_PARENT));

        // 此行必加，不然显示不出来
        renderUIView.pinToZTop(true);
        addComponent(renderUIView);

        mRenderView.addRenderCallback(mSHCallback);
        mRenderView.setVideoRotation(mVideoRotationDegree);
    }

    public void setRender(int render) {
        switch (render) {
            case RENDER_NONE:
                setRenderView(null);
                break;
            case RENDER_TEXTURE_VIEW: {
                // TextureView后续计划支持
                break;
            }
            case RENDER_SURFACE_VIEW: {
                SurfaceRenderView renderView = new SurfaceRenderView(getContext());
                setRenderView(renderView);
                break;
            }
            default:
                LogUtils.e(TAG, String.format(Locale.getDefault(), "invalid render %d\n", render));
                break;
        }
    }

    public void setHudView() {
        mHudViewHolder = new InfoHudViewHolder();
    }

    public List<SampleItem> getHudViewDataLists() {
        if (mHudViewHolder != null) {
            return mHudViewHolder.getDataLists();
        }
        return null;
    }

    /**
     * Sets video path.
     *
     * @param path the path of the video.
     */
    public void setVideoPath(String path) {
        if (path.contains("adaptationSet")) {
            setVideoURI(Uri.parse("EMPTY"));
        } else {
            setVideoURI(Uri.parse(path));
        }
    }

    /**
     * Sets video URI.
     *
     * @param uri the URI of the video.
     */
    public void setVideoURI(Uri uri) {
        setVideoURI(uri, null);
    }

    /**
     * Sets video URI using specific headers.
     *
     * @param uri     the URI of the video.
     * @param headers the headers for the URI request.
     *                Note that the cross domain redirection is allowed by default, but that can be
     *                changed with key/value pairs through the headers parameter with
     *                "android-allow-cross-domain-redirect" as the key and "0" or "1" as the value
     *                to disallow or allow cross domain redirection.
     */
    private void setVideoURI(Uri uri, Map<String, String> headers) {
        mUri = uri;
        mSeekWhenPrepared = 0;
        openVideo();
        invalidate();
    }

    public IMediaPlayer getMediaPlayer() {
        if (mMediaPlayer != null) {
            return mMediaPlayer;
        }
        return null;
    }

    public void stopPlayback() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
            if (mHudViewHolder != null) {
                mHudViewHolder.setMediaPlayer(null);
            }
            mCurrentState = STATE_IDLE;
            mTargetState = STATE_IDLE;
            // 释放音频焦点
            if (audioManager != null && audioInterrupt != null) {
                audioManager.deactivateAudioInterrupt(audioInterrupt);
            }
        }
    }

    private void openVideo() {
        if (mUri == null || mSurfaceHolder == null) {
            // not ready for playback just yet, will try again later
            return;
        }
        // we shouldn't clear the target state, because somebody might have
        // called start() previously
        release(false);

        // 申请音频焦点，类型STREAM_MUSIC
        audioManager = new AudioManager(getContext());
        try {
            audioManager.setVolume(
                    AudioManager.AudioVolumeType.STREAM_MUSIC,
                    audioManager.getVolume(AudioManager.AudioVolumeType.STREAM_MUSIC));
        } catch (AudioRemoteException e) {
            LogUtils.e(TAG, e.getMessage());
        }
        audioInterrupt = new AudioInterrupt();
        audioManager.activateAudioInterrupt(audioInterrupt);

        try {
            mMediaPlayer = createPlayer(0);
            mMediaPlayer.setOnPreparedListener(mPreparedListener);
            mMediaPlayer.setOnVideoSizeChangedListener(mSizeChangedListener);
            mMediaPlayer.setOnCompletionListener(mCompletionListener);
            mMediaPlayer.setOnErrorListener(mErrorListener);
            mMediaPlayer.setOnInfoListener(mInfoListener);
            mMediaPlayer.setOnBufferingUpdateListener(mBufferingUpdateListener);
            mMediaPlayer.setOnSeekCompleteListener(mSeekCompleteListener);
            mMediaPlayer.setOnTimedTextListener(mOnTimedTextListener);
            mCurrentBufferPercentage = 0;
            String scheme = mUri.getScheme();
            if (MediaConstant.OHOS_RESOURCE_SCHEME_RAW.equals(scheme)) {
                // uri: "resources/base/media/.mp4";
                String resourcepath = new Resource(mUri.toString()).getResourcePath();
                try {
                    mMediaPlayer.setDataSource(
                            getResourceManager()
                                    .getRawFileEntry(resourcepath)
                                    .openRawFileDescriptor()
                                    .getFileDescriptor());
                } catch (Exception e) {
                    LogUtils.e(TAG, "setDataSource fail : " + e.getMessage());
                    return;
                }
            } else {
                mMediaPlayer.setDataSource(mUri.toString());
            }
            bindSurfaceHolder(mMediaPlayer, mSurfaceHolder);
            mMediaPlayer.setScreenOnWhilePlaying(true);
            mPrepareStartTime = System.currentTimeMillis();
            mMediaPlayer.prepareAsync();
            if (mHudViewHolder != null) {
                mHudViewHolder.setMediaPlayer(mMediaPlayer);
            }

            mCurrentState = STATE_PREPARING;
            LogUtils.e(TAG, "openVideo CurrentState" + mCurrentState);
            attachMediaController();
        } catch (IOException | IllegalArgumentException ex) {
            mCurrentState = STATE_ERROR;
            mTargetState = STATE_ERROR;
        }
    }

    public void setMediaController(IMediaController controller) {
        if (mMediaController != null) {
            mMediaController.hide();
        }
        mMediaController = controller;
        attachMediaController();
    }

    private void attachMediaController() {
    }

    IMediaPlayer.OnVideoSizeChangedListener mSizeChangedListener =
            new IMediaPlayer.OnVideoSizeChangedListener() {
                public void onVideoSizeChanged(IMediaPlayer mp, int width, int height, int sarNum, int sarDen) {
                    mVideoWidth = mp.getVideoWidth();
                    mVideoHeight = mp.getVideoHeight();
                    mVideoSarNum = mp.getVideoSarNum();
                    mVideoSarDen = mp.getVideoSarDen();
                    if (mVideoWidth != 0 && mVideoHeight != 0) {
                        if (mRenderView != null) {
                            mRenderView.setVideoSize(mVideoWidth, mVideoHeight);
                            mRenderView.setVideoSampleAspectRatio(mVideoSarNum, mVideoSarDen);
                        }

                        // 获取的surfaceProvider的宽度和高度在OnPreparedListener里面有可能等于0导致视频画面出现拉伸,
                        // OnPreparedListener只会执行一次，因此在此增加容错处理
                        // =========================start=========================================
                        float ratio = mVideoWidth / (float) mVideoHeight;
                        int surfaceViewWidth;
                        int surfaceViewHeight;
                        if (ratio > 1) {
                            surfaceViewWidth = ComponentContainer.LayoutConfig.MATCH_PARENT;
                            surfaceViewHeight = (int) (mRenderView.getView().getWidth() / ratio);
                        } else {
                            surfaceViewWidth = (int) (mRenderView.getView().getHeight() * ratio);
                            surfaceViewHeight = ComponentContainer.LayoutConfig.MATCH_PARENT;
                        }
                        mRenderView
                                .getView()
                                .setLayoutConfig(
                                        new LayoutConfig(surfaceViewWidth, surfaceViewHeight, LayoutAlignment.CENTER));
                        // =========================end=========================================
                    }
                }
            };

    IMediaPlayer.OnPreparedListener mPreparedListener =
            new IMediaPlayer.OnPreparedListener() {
                public void onPrepared(IMediaPlayer mp) {
                    long mPrepareEndTime = System.currentTimeMillis();
                    mHudViewHolder.updateLoadCost(mPrepareEndTime - mPrepareStartTime);
                    mCurrentState = STATE_PREPARED;

                    // Get the capabilities of the player for this stream
                    // REMOVED: Metadata

                    if (mOnPreparedListener != null) {
                        mOnPreparedListener.onPrepared(mMediaPlayer);
                    }
                    if (mMediaController != null) {
                        mMediaController.setEnabled(true);
                    }
                    mVideoWidth = mp.getVideoWidth();
                    mVideoHeight = mp.getVideoHeight();

                    int seekToPosition = mSeekWhenPrepared; // mSeekWhenPrepared may be changed
                    // after seekTo() call
                    if (seekToPosition != 0) {
                        seekTo(seekToPosition);
                    }
                    if (mVideoWidth != 0 && mVideoHeight != 0) {
                        if (mRenderView != null) {
                            mRenderView.setVideoSize(mVideoWidth, mVideoHeight);
                            mRenderView.setVideoSampleAspectRatio(mVideoSarNum, mVideoSarDen);
                            if (!mRenderView.shouldWaitForResize()
                                    || mSurfaceWidth == mVideoWidth && mSurfaceHeight == mVideoHeight) {
                                // We didn't actually change the size (it was already at the size
                                // we need), so we won't get a "surface changed" callback, so
                                // start the video here instead of in the callback.
                                if (mTargetState == STATE_PLAYING) {
                                    start();
                                    if (mMediaController != null) {
                                        mMediaController.show();
                                    }
                                }
                            }
                        }
                    } else {
                        // We don't know the video size yet, but should start anyway.
                        // The video size might be reported to us later.
                        if (mTargetState == STATE_PLAYING) {
                            start();
                        }
                    }
                }
            };

    private IMediaPlayer.OnCompletionListener mCompletionListener =
            new IMediaPlayer.OnCompletionListener() {
                public void onCompletion(IMediaPlayer mp) {
                    mCurrentState = STATE_PLAYBACK_COMPLETED;
                    mTargetState = STATE_PLAYBACK_COMPLETED;
                    if (mMediaController != null) {
                        mMediaController.hide();
                    }
                    if (mOnCompletionListener != null) {
                        mOnCompletionListener.onCompletion(mMediaPlayer);
                    }
                }
            };

    private IMediaPlayer.OnInfoListener mInfoListener =
            new IMediaPlayer.OnInfoListener() {
                public boolean onInfo(IMediaPlayer mp, int arg1, int arg2) {
                    if (mOnInfoListener != null) {
                        mOnInfoListener.onInfo(mp, arg1, arg2);
                    }
                    switch (arg1) {
                        case IMediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING:
                            LogUtils.debug(TAG, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                            break;
                        case IMediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START:
                            LogUtils.debug(TAG, "MEDIA_INFO_VIDEO_RENDERING_START:");
                            break;
                        case IMediaPlayer.MEDIA_INFO_BUFFERING_START:
                            LogUtils.debug(TAG, "MEDIA_INFO_BUFFERING_START:");
                            break;
                        case IMediaPlayer.MEDIA_INFO_BUFFERING_END:
                            LogUtils.debug(TAG, "MEDIA_INFO_BUFFERING_END:");
                            break;
                        case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH:
                            LogUtils.debug(TAG, "MEDIA_INFO_NETWORK_BANDWIDTH: " + arg2);
                            break;
                        case IMediaPlayer.MEDIA_INFO_BAD_INTERLEAVING:
                            LogUtils.debug(TAG, "MEDIA_INFO_BAD_INTERLEAVING:");
                            break;
                        case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE:
                            LogUtils.debug(TAG, "MEDIA_INFO_NOT_SEEKABLE:");
                            break;
                        case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE:
                            LogUtils.debug(TAG, "MEDIA_INFO_METADATA_UPDATE:");
                            break;
                        case IMediaPlayer.MEDIA_INFO_UNSUPPORTED_SUBTITLE:
                            LogUtils.debug(TAG, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                            break;
                        case IMediaPlayer.MEDIA_INFO_SUBTITLE_TIMED_OUT:
                            LogUtils.debug(TAG, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                            break;
                        case IMediaPlayer.MEDIA_INFO_VIDEO_ROTATION_CHANGED:
                            mVideoRotationDegree = arg2;
                            LogUtils.debug(TAG, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + arg2);
                            if (mRenderView != null) {
                                mRenderView.setVideoRotation(arg2);
                            }
                            break;
                        case IMediaPlayer.MEDIA_INFO_AUDIO_RENDERING_START:
                            LogUtils.debug(TAG, "MEDIA_INFO_AUDIO_RENDERING_START:");
                            break;
                    }
                    return true;
                }
            };

    private IMediaPlayer.OnErrorListener mErrorListener =
            new IMediaPlayer.OnErrorListener() {
                public boolean onError(IMediaPlayer mp, int framework_err, int impl_err) {
                    LogUtils.w(TAG, " OnErrorListener Error: " + framework_err + "," + impl_err);
                    mCurrentState = STATE_ERROR;
                    mTargetState = STATE_ERROR;
                    if (mMediaController != null) {
                        mMediaController.hide();
                    }

                    /* If an error handler has been supplied, use it and finish. */
                    if (mOnErrorListener != null) {
                        if (mOnErrorListener.onError(mMediaPlayer, framework_err, impl_err)) {
                            return true;
                        }
                    }
                    return true;
                }
            };

    private IMediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener =
            new IMediaPlayer.OnBufferingUpdateListener() {
                public void onBufferingUpdate(IMediaPlayer mp, int percent) {
                    LogUtils.info(getClass().getSimpleName(), " onBufferingUpdate " + percent);
                    mCurrentBufferPercentage = percent;
                }
            };

    private IMediaPlayer.OnSeekCompleteListener mSeekCompleteListener =
            new IMediaPlayer.OnSeekCompleteListener() {
                @Override
                public void onSeekComplete(IMediaPlayer mp) {
                    LogUtils.info(getClass().getSimpleName(), " onSeekComplete");
                    long mSeekEndTime = System.currentTimeMillis();
                    mHudViewHolder.updateSeekCost(mSeekEndTime - mSeekStartTime);
                }
            };

    private IMediaPlayer.OnTimedTextListener mOnTimedTextListener =
            new IMediaPlayer.OnTimedTextListener() {
                @Override
                public void onTimedText(IMediaPlayer mp, IjkTimedText text) {
                }
            };

    /**
     * Register a callback to be invoked when the media file
     * is loaded and ready to go.
     *
     * @param l The callback that will be run
     */
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener l) {
        mOnPreparedListener = l;
    }

    /**
     * Register a callback to be invoked when the end of a media file
     * has been reached during playback.
     *
     * @param l The callback that will be run
     */
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener l) {
        mOnCompletionListener = l;
    }

    /**
     * Register a callback to be invoked when an error occurs
     * during playback or setup.  If no listener is specified,
     * or if the listener returned false, VideoView will inform
     * the user of any errors.
     *
     * @param l The callback that will be run
     */
    public void setOnErrorListener(IMediaPlayer.OnErrorListener l) {
        mOnErrorListener = l;
    }

    /**
     * Register a callback to be invoked when an informational event
     * occurs during playback or setup.
     *
     * @param l The callback that will be run
     */
    public void setOnInfoListener(IMediaPlayer.OnInfoListener l) {
        mOnInfoListener = l;
    }

    private void bindSurfaceHolder(IMediaPlayer mp, IRenderView.ISurfaceHolder holder) {
        if (mp == null) return;

        if (holder == null) {
            mp.setDisplay(null);
            return;
        }

        holder.bindToMediaPlayer(mp);
    }

    IRenderView.IRenderCallback mSHCallback = new IRenderView.IRenderCallback() {
        @Override
        public void onSurfaceChanged(IRenderView.ISurfaceHolder holder, int format, int w, int h) {
            if (holder.getRenderView() != mRenderView) {
                LogUtils.e(TAG, "onSurfaceChanged: unmatched render callback\n");
                return;
            }

            mSurfaceWidth = w;
            mSurfaceHeight = h;
            boolean isValidState = (mTargetState == STATE_PLAYING);
            boolean hasValidSize = !mRenderView.shouldWaitForResize() || (mVideoWidth == w && mVideoHeight == h);
            if (mMediaPlayer != null && isValidState && hasValidSize) {
                start();
            }
        }

        @Override
        public void onSurfaceCreated(IRenderView.ISurfaceHolder holder, int width, int height) {
            if (holder.getRenderView() != mRenderView) {
                LogUtils.e(TAG, "onSurfaceCreated: unmatched render callback\n");
                return;
            }

            mSurfaceHolder = holder;
            if (mMediaPlayer != null) bindSurfaceHolder(mMediaPlayer, holder);
            else openVideo();
        }

        @Override
        public void onSurfaceDestroyed(IRenderView.ISurfaceHolder holder) {
            if (holder.getRenderView() != mRenderView) {
                LogUtils.e(TAG, "onSurfaceDestroyed: unmatched render callback\n");
                return;
            }

            // after we return from this we can't use the surface any more
            mSurfaceHolder = null;
            releaseWithoutStop();
        }
    };

    public void releaseWithoutStop() {
        if (mMediaPlayer != null) mMediaPlayer.setDisplay(null);
    }

    /**
     * release the media player in any state
     *
     * @param cleartargetstate true: clear state
     */
    public void release(boolean cleartargetstate) {
        if (mMediaPlayer != null) {
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
            mCurrentState = STATE_IDLE;
            if (cleartargetstate) {
                mTargetState = STATE_IDLE;
            }
            // 释放音频焦点
            if (audioManager != null && audioInterrupt != null) {
                audioManager.deactivateAudioInterrupt(audioInterrupt);
            }
        }
    }

    private void toggleMediaControlsVisiblity() {
        if (mMediaController.isShowing()) {
            mMediaController.hide();
        } else {
            mMediaController.show();
        }
    }

    public void start() {
        if (mMediaPlayer != null) {
            mMediaPlayer.start();
            mCurrentState = STATE_PLAYING;
        }
        mTargetState = STATE_PLAYING;
    }

    public void pause() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            mCurrentState = STATE_PAUSED;
        }
        mTargetState = STATE_PAUSED;
    }

    public void suspend() {
        release(false);
    }

    public void resume() {
        openVideo();
    }

    public long getDuration() {
        if (mMediaPlayer != null) {
            return mMediaPlayer.getDuration();
        }
        return -1;
    }

    public long getCurrentPosition() {
        if (mMediaPlayer != null) {
            return mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int msec) {
        if (mMediaPlayer != null) {
            mSeekStartTime = System.currentTimeMillis();
            mMediaPlayer.seekTo(msec);
            mSeekWhenPrepared = 0;
        } else {
            mSeekWhenPrepared = msec;
        }
    }

    public boolean isPlaying() {
        return mMediaPlayer != null && mMediaPlayer.isPlaying();
    }

    public int getBufferPercentage() {
        if (mMediaPlayer != null) {
            return mCurrentBufferPercentage;
        }
        return 0;
    }

    private boolean isInPlaybackState() {
        return mMediaPlayer != null
                && mCurrentState != STATE_ERROR
                && mCurrentState != STATE_IDLE
                && mCurrentState != STATE_PREPARING;
    }

    public boolean canPause() {
        return mCanPause;
    }

    public boolean canSeekBackward() {
        return mCanSeekBack;
    }

    public boolean canSeekForward() {
        return mCanSeekForward;
    }

    public int getAudioSessionId() {
        return 0;
    }

    // -------------------------
    // Extend: Aspect Ratio
    // -------------------------

    private static final int[] s_allAspectRatio = {
            IRenderView.AR_ASPECT_FIT_PARENT,
            IRenderView.AR_ASPECT_FILL_PARENT,
            IRenderView.AR_ASPECT_WRAP_CONTENT,
            // IRenderView.AR_MATCH_PARENT,
            IRenderView.AR_16_9_FIT_PARENT,
            IRenderView.AR_4_3_FIT_PARENT
    };
    private int mCurrentAspectRatioIndex = 0;
    private int mCurrentAspectRatio = s_allAspectRatio[0];

    public int toggleAspectRatio() {
        mCurrentAspectRatioIndex++;
        mCurrentAspectRatioIndex %= s_allAspectRatio.length;
        mCurrentAspectRatio = s_allAspectRatio[mCurrentAspectRatioIndex];
        if (mRenderView != null) {
            mRenderView.setAspectRatio(mCurrentAspectRatio);
        }
        return mCurrentAspectRatio;
    }

    // -------------------------
    // Extend: Render
    // -------------------------
    private static final int RENDER_NONE = 0;
    private static final int RENDER_SURFACE_VIEW = 1;
    private static final int RENDER_TEXTURE_VIEW = 2;

    private List<Integer> mAllRenders = new ArrayList<>();
    private int mCurrentRenderIndex = 0;
    private int mCurrentRender = RENDER_NONE;

    private void initRenders() {
        mAllRenders.clear();
        mAllRenders.add(RENDER_SURFACE_VIEW);
        if (mAllRenders.isEmpty()) mAllRenders.add(RENDER_SURFACE_VIEW);
        mCurrentRender = mAllRenders.get(mCurrentRenderIndex);
        setRender(mCurrentRender);
    }

    public int toggleRender() {
        mCurrentRenderIndex++;
        mCurrentRenderIndex %= mAllRenders.size();

        mCurrentRender = mAllRenders.get(mCurrentRenderIndex);
        setRender(mCurrentRender);
        return mCurrentRender;
    }

    // 显示相关渲染component信息todo
    public static String getRenderText(Context context, int render) {
        return "";
    }

    // -------------------------
    // Extend: Player
    // -------------------------
    public int togglePlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
        }

        if (mRenderView != null) {
            mRenderView.getView().invalidate();
        }
        openVideo();
        // 默认0
        return 0;
    }

    // 显示相关播放器信息todo
    public static String getPlayerText(Context context, int player) {
        return "";
    }

    public IMediaPlayer createPlayer(int playerType) {
        IMediaPlayer mediaPlayer = null;
        switch (playerType) {
            default: {
                IjkMediaPlayer ijkMediaPlayer = null;
                if (mUri != null) {
                    ijkMediaPlayer = new IjkMediaPlayer();
                    /**
                     * ohos中暂时没法判断是debug还是release,后续优化
                     * 请调用IjkMediaPlayer.native_setLogLevel以打印ijk相关的native日志，正式版本请关闭，默认是关闭的
                     * */
                    IjkMediaPlayer.native_setLogLevel(IjkMediaPlayer.IJK_LOG_DEBUG);

                    /**
                     * 一些通用设置，可了解ffmpeg相关的Option自行补充，这里仅做参考
                     * */
                    // 是否启用硬解码，目前ohos平台的硬解码未适配，不支持硬解，默认0是软解
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "mediacodec", 0);
                    // 音频解析,1是启用Audiotrack，默认0用的ohos的AudioRenderer
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "opensles", 0);
                    // 跳帧处理,当CPU处理较慢时，进行跳帧处理，保证播放流畅，画面和声音同步
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "framedrop", 1L);
                    // 设置是否开启环路过滤: 0开启，画面质量高，解码开销大，48关闭，画面质量差点，解码开销小
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, "skip_loop_filter", 48);
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "start-on" + "-prepared", 0);
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_FORMAT, "http-detect" + "-range-support", 0);

                    // ============================以下ffmepg相关的Option设置项请自行按需调节参数值================

                    /**
                     * 执行seekto，或者快进快推操作后想更快的继续播放，需要设置max-buffer-size和min-frames，否则需要等待比较久才会继续播放
                     * */
                    // 自定义缓冲大小,单位kb
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "max-buffer-size", 100 * 1024);
                    // 最大fps
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "min-frames", 100);

                    /**
                     * 在刚刚进入页面的时候可以更快的出画面播放视频，有一定的效果
                     * */
                    // 设置播放前的探测时间 1,达到首屏秒开效果
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_FORMAT, "analyzeduration", 1);

                    //                    // 设置播放前的最大探测时间
                    //                    ijkMediaPlayer.setOption(IjkMediaPlayer
                    //                    .OPT_CATEGORY_FORMAT,
                    // "analyzemaxduration", 100L);
                    //                    // 播放前的探测Size， 改小一点会出画面更快, 但是值过小会导致一些视频播放时有画面但没有声音,需要注意
                    //                    ijkMediaPlayer.setOption(IjkMediaPlayer
                    //                    .OPT_CATEGORY_FORMAT, "probesize",
                    // 10240 * 10);
                    // 每处理一个packet之后刷新io上下文
                    //                    ijkMediaPlayer.setOption(IjkMediaPlayer
                    //                    .OPT_CATEGORY_FORMAT, "flush_packets"
                    //                            , 1L);
                    //                    // 是否开启预缓冲，一般直播项目会开启，达到秒开的效果，不过会带来播放丢帧卡顿的问题
                    //                    ijkMediaPlayer.setOption(IjkMediaPlayer
                    //                    .OPT_CATEGORY_PLAYER,
                    // "packet-buffering", 0L);
                    //
                    //                    // SeekTo设置优化:seek只支持关键帧,
                    //                    当压缩的视频文件关键帧比较少时，在执行SeekTo的时候，存在会跳回到拖动前的位置的问题
                    //                    ijkMediaPlayer.setOption(IjkMediaPlayer
                    //                    .OPT_CATEGORY_PLAYER,
                    // "enable-accurate-seek", 1);
                    //倍数播放
//                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "soundtouch", 1);
//                    ijkMediaPlayer.setSpeed(3f);
                }
                mediaPlayer = ijkMediaPlayer;
            }
            break;
        }
        return mediaPlayer;
    }

    // -------------------------
    // Extend: Background
    // -------------------------

    private boolean mEnableBackgroundPlay = false;

    // 目前服务中后台播放todo
    private void initBackground() {
    }

    public boolean isBackgroundPlayEnabled() {
        return mEnableBackgroundPlay;
    }

    public void enterBackground() {
    }

    public void stopBackgroundPlay() {
    }

    // -------------------------
    // Extend: Background
    // -------------------------
    public void showMediaInfo() {
    }

    private String buildResolution(int width, int height, int sarNum, int sarDen) {
        StringBuilder sb = new StringBuilder();
        sb.append(width);
        sb.append(" x ");
        sb.append(height);

        if (sarNum > 1 || sarDen > 1) {
            sb.append("[");
            sb.append(sarNum);
            sb.append(":");
            sb.append(sarDen);
            sb.append("]");
        }

        return sb.toString();
    }

    private String buildTimeMilli(long duration) {
        long total_seconds = duration / 1000;
        long hours = total_seconds / 3600;
        long minutes = (total_seconds % 3600) / 60;
        long seconds = total_seconds % 60;
        if (duration <= 0) {
            return "--:--";
        }
        if (hours >= 100) {
            return String.format(Locale.US, "%d:%02d:%02d", hours, minutes, seconds);
        } else if (hours > 0) {
            return String.format(Locale.US, "%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            return String.format(Locale.US, "%02d:%02d", minutes, seconds);
        }
    }

    private String buildTrackType(int type) {
        return "Video";
    }

    private String buildLanguage(String language) {
        if (TextUtils.isEmpty(language)) return "und";
        return language;
    }

    public ITrackInfo[] getTrackInfo() {
        if (mMediaPlayer == null) return null;

        return mMediaPlayer.getTrackInfo();
    }

    public void selectTrack(int stream) {
        MediaPlayerCompat.selectTrack(mMediaPlayer, stream);
    }

    public void deselectTrack(int stream) {
        MediaPlayerCompat.deselectTrack(mMediaPlayer, stream);
    }

    public int getSelectedTrack(int trackType) {
        return MediaPlayerCompat.getSelectedTrack(mMediaPlayer, trackType);
    }
}
