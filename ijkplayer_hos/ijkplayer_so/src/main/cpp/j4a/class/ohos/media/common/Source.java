package ohos.media.common;

import java.io.FileDescriptor;

public class Source {

    public Source(FileDescriptor fd);

    public Source(FileDescriptor fd, long offset, long len);

}
