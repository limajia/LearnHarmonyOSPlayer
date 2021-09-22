package ohos.media.common;


@SimpleCClassName
public class Format {

    public Format();

    public int getIntValue(String key);

    public void putIntValue(String key, int value);

    public void putObjectValue(String key, Object value);

    public String getStringValue(String key);
}
