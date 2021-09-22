package ohos.utils;

import java.util.ArrayList;

@SimpleCClassName
public class PacMap {

    public PacMap();

    public int getIntValue(String key, int defaultValue);

    public void putIntValue(String key, int value);

    public String getString(String key);

    public void putString(String key, String value);

    public void putSequenceableObjectList(String key, ArrayList sequenceables);

    public long getLongValue(String key);

    public void putLongValue(String key, long value);

}
