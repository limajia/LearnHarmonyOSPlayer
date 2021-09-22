package com.tv.danmaku.ijk.media.example.ui.adapter;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaPlayerProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * 播放视频时显示fps, vdec, load-cost.....bit_rate 等信息时需要的数据
 */
public class InfoHudViewHolder {
    private IMediaPlayer mMediaPlayer;
    private long mLoadCost = 0;
    private long mSeekCost = 0;
    private List<SampleItem> mDataLists;


    public InfoHudViewHolder() {
    }

    /**
     * bind mediaPlayer
     *
     * @param mediaPlayer MediaPlayer
     */
    public void setMediaPlayer(IMediaPlayer mediaPlayer) {
        mMediaPlayer = mediaPlayer;
    }

    public List<SampleItem> getDataLists() {
        IjkMediaPlayer mediaPlayer = null;
        if (mMediaPlayer == null) {
            return null;
        }
        if (mMediaPlayer instanceof IjkMediaPlayer) {
            mediaPlayer = (IjkMediaPlayer) mMediaPlayer;
        } else if (mMediaPlayer instanceof MediaPlayerProxy) {
            // no use
            MediaPlayerProxy proxy = (MediaPlayerProxy) mMediaPlayer;
            IMediaPlayer internal = proxy.getInternalMediaPlayer();
            if (internal != null && internal instanceof IjkMediaPlayer) {
                mediaPlayer = (IjkMediaPlayer) internal;
            }
        }
        if (mediaPlayer == null) {
            return null;
        }

        // 构造数据给外面hudview刷新显示
        if (mDataLists == null) {
            mDataLists = new ArrayList<>();
        }
        mDataLists.clear();

        int vdec = mediaPlayer.getVideoDecoder();
        switch (vdec) {
            case IjkMediaPlayer.FFP_PROPV_DECODER_AVCODEC:
                mDataLists.add(setRowValue("vdec", "avcodec"));
                break;
            case IjkMediaPlayer.FFP_PROPV_DECODER_MEDIACODEC:
                mDataLists.add(setRowValue("vdec", "MediaCodec"));
                break;
            default:
                mDataLists.add(setRowValue("vdec", ""));
                break;
        }

        float fpsOutput = mediaPlayer.getVideoOutputFramesPerSecond();
        float fpsDecode = mediaPlayer.getVideoDecodeFramesPerSecond();

        long videoCachedDuration = mediaPlayer.getVideoCachedDuration();
        long audioCachedDuration = mediaPlayer.getAudioCachedDuration();
        long videoCachedBytes = mediaPlayer.getVideoCachedBytes();
        long audioCachedBytes = mediaPlayer.getAudioCachedBytes();
        long tcpSpeed = mediaPlayer.getTcpSpeed();
        long bitRate = mediaPlayer.getBitRate();
        long seekLoadDuration = mediaPlayer.getSeekLoadDuration();

        mDataLists.add(setRowValue("fps", String.format(Locale.US, "%.2f / %.2f", fpsDecode, fpsOutput)));

        mDataLists.add(setRowValue("v_cache", String.format(Locale.US, "%s, %s", formatedDurationMilli(videoCachedDuration), formatedSize(videoCachedBytes))));
        mDataLists.add(setRowValue("a_cache", String.format(Locale.US, "%s, %s", formatedDurationMilli(audioCachedDuration), formatedSize(audioCachedBytes))));
        mDataLists.add(setRowValue("load_cost", String.format(Locale.US, "%d ms", mLoadCost)));
        mDataLists.add(setRowValue("seek_cost", String.format(Locale.US, "%d ms", mSeekCost)));
        mDataLists.add(setRowValue("seek_load_cost", String.format(Locale.US, "%d ms", seekLoadDuration)));
        mDataLists.add(setRowValue("tcp_speed", String.format(Locale.US, "%s", formatedSpeed(tcpSpeed, 1000))));
        mDataLists.add(setRowValue("bit_rate", String.format(Locale.US, "%.2f kbs", bitRate / 1000f)));

        return mDataLists;
    }

    private SampleItem setRowValue(String keyName, String value) {
        SampleItem sampleItem = new SampleItem();
        sampleItem.setKey(keyName);
        sampleItem.setValue(value);
        return sampleItem;
    }

    public void updateLoadCost(long time) {
        mLoadCost = time;
    }

    public void updateSeekCost(long time) {
        mSeekCost = time;
    }

    private static String formatedDurationMilli(long duration) {
        if (duration >= 1000) {
            return String.format(Locale.US, "%.2f sec", ((float) duration) / 1000);
        } else {
            return String.format(Locale.US, "%d msec", duration);
        }
    }

    private static String formatedSpeed(long bytes, long elapsedMilli) {
        if (elapsedMilli <= 0) {
            return "0 B/s";
        }

        if (bytes <= 0) {
            return "0 B/s";
        }

        float bytes_per_sec = ((float) bytes) * 1000.f / elapsedMilli;
        if (bytes_per_sec >= 1000 * 1000) {
            return String.format(Locale.US, "%.2f MB/s", ((float) bytes_per_sec) / 1000 / 1000);
        } else if (bytes_per_sec >= 1000) {
            return String.format(Locale.US, "%.1f KB/s", ((float) bytes_per_sec) / 1000);
        } else {
            return String.format(Locale.US, "%d B/s", (long) bytes_per_sec);
        }
    }

    private static String formatedSize(long bytes) {
        if (bytes >= 100 * 1000) {
            return String.format(Locale.US, "%.2f MB", ((float) bytes) / 1000 / 1000);
        } else if (bytes >= 100) {
            return String.format(Locale.US, "%.1f KB", ((float) bytes) / 1000);
        } else {
            return String.format(Locale.US, "%d B", bytes);
        }
    }


}
