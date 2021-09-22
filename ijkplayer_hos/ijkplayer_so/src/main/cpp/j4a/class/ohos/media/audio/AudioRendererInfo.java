package ohos.media.audio;

public class AudioRendererInfo {

    public static class Builder {

        public Builder();

        public AudioRendererInfo.Builder audioStreamInfo(AudioStreamInfo audioStreamInfo);

        public AudioRendererInfo.Builder bufferSizeInBytes(long bufferSizeInBytes);

        public AudioRendererInfo.Builder isOffload(boolean isOffload);

        public AudioRendererInfo.Builder audioStreamOutputFlag(Object outputFlag);

        public AudioRendererInfo.Builder distributedDeviceId(String distributedDeviceId);

        public AudioRendererInfo build();
    }

}
