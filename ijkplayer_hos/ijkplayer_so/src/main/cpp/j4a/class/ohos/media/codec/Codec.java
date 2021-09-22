package ohos.media.codec;

import ohos.agp.graphics.Surface;
import ohos.media.common.BufferInfo;
import ohos.media.common.Format;

import java.nio.ByteBuffer;

@SimpleCClassName
public class Codec {

    public static Codec createDecoder();

    public void setVideoSurface(Surface surface);

    public void setCodecFormat(Format format);

    public boolean registerCodecListener(Codec.ICodecListener listener);

    public interface ICodecListener {
        void onReadBuffer(ByteBuffer var1, BufferInfo var2, int var3);

        void onError(int var1, int var2, int var3);
    }

    public Format getBufferFormat(ByteBuffer buffer);

    public boolean writeBuffer(ByteBuffer buffer, BufferInfo info);

    public ByteBuffer getAvailableBuffer(long timeout);

    public boolean start();

    public boolean stop();

    public boolean release();

}
