package ohos.media.extractor;

import ohos.media.common.Format;
import ohos.media.common.Source;

import java.nio.ByteBuffer;

public class Extractor {

    public Extractor();

    public boolean setSource(Source source);

    public final int getTotalStreams();

    public final Format getStreamFormat(int id);

    public boolean specifyStream(int id);

    public int getIntValue(String key);

    public int readBuffer(ByteBuffer buf, int offset);

    public long getFrameTimestamp();

    public boolean next();

    public boolean release();

}
