package ohos.media.audio;

public class AudioStreamInfo {

    public static class Builder {

        public Builder();

        public AudioStreamInfo.Builder encodingFormat(Object inputEncodingFormat);

        public AudioStreamInfo.Builder sampleRate(int inputSampleRate);

        public AudioStreamInfo.Builder channelMask(Object inputChannelMask);

        public AudioStreamInfo.Builder streamUsage(Object inputStreamUsage);

        public AudioStreamInfo.Builder audioStreamFlag(Object flag);

        public AudioStreamInfo build();
    }

}
