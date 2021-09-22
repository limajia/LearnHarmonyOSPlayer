package ohos.media.audio;

import java.nio.ByteBuffer;

@SimpleCClassName
@IncludeUtil
public class AudioRenderer {

    public static class SpeedPara {
        SpeedPara(float speed, float pitch);

        public float getSpeed();

        public float getPitch();

        public static class Builder {
            public Builder();

            public AudioRenderer.SpeedPara.Builder speed;

            public AudioRenderer.SpeedPara.Builder pitch;

            public AudioRenderer.SpeedPara build();
        }
    }

    public static class ChannelVolume {

        public ChannelVolume(float inputLeftVolume, float inputRightVolume);
    }

    public AudioRenderer(AudioRendererInfo audioRendererInfo, Object pm);

    public static int getMinBufferSize(int sampleRate, Object format, Object channelMask);

    public static float getMaxVolume();

    public static float getMinVolume();

    public int getSampleRate();

    public boolean start();

    public boolean pause();

    public boolean stop();

    public boolean flush();

    public boolean release();

    public boolean write(byte[] data, int offset, int size);

    public boolean setVolume(AudioRenderer.ChannelVolume channelVolume);

    public int getRendererSessionId();

    public AudioRenderer.SpeedPara getPlaybackSpeed();

    public boolean setPlaybackSpeed(AudioRenderer.SpeedPara speedPara);

}
