# ijkplayer hos

## 注意
>+ 如果是自己写demo,要把 libc++.so ,libijkffmpeg.so ,libijksdl.so,libijkplayer.so和classes.jar集成到工程中
>+ 如果是直接运行此项目,由于entry依赖了ijkplayer和ijkplayer_so这两个module,所以只需要在libs中放入libffmpeg.so即可,
>+ 首次运行工程前请先执行Build->Build Hap(s)/APP(S)->Build Hap(s)保证so文件的生成，再点击Run entry
>+ 如果需要jni层打印日志信息，请上层业务侧设置IjkMediaPlayer.native_setLogLevel(IjkMediaPlayer.IJK_LOG_DEBUG);
>+ 详见IjkVideoView-》createPlayer（）中的注释说明

## 环境配置：
>+ IDE版本：官网上下载DevEco Studio 2.1 Release 2.1.0.501 
>+ ohos NDK版本：最新的NDK版本
>+ linux环境下编译ffmpeg&ijkplayer的源码版本信息：
   [FFmpeg版本](https://github.com/bilibili/FFmpeg/releases/tag/ff4.0--ijk0.8.8--20210205--001)
   [ijkplayer版本](https://github.com/bilibili/ijkplayer/releases/tag/k0.8.8)
   A侧的使用的NDK版本：ndk10（10~14都可以） 

## 编译步骤
>+ linux环境下成功编译A侧原三方库ijkplayer项目，步骤见《附录1》
>+ ijkplayer_so/src/main/cpp/libs/libffmpeg/对应指令集下导入libijkffmpeg.so
>+ ijkplayer_so/src/main/cpp/libs/openSLES/对应指令集下导入libOpenSLES.so
>+ ijkplayer_so/src/main/cpp/libs/soundtouch/对应指令集下导入libsoundtouch.a
>+ ijkplayer_so/src/main/cpp/libs/yuv/对应指令集下导入libyuv.a
>+ 如果需要编译32位so,以上文件需要全部替换为32位的再编译此工程,另外还需额外在ijkplayer_so/src/main/cpp/libs/atomic/armeabi-v7a下导入libatomic.a
>+ 开始编译：
>+ 点击Build->Build Hap(s)/APP(S)->Build Hap(s)
>+ 编译成功后会在ijkplayer_so/intermediates/cmake/对应指令集（如arm64-v8a,arm64-v7a）中生成 libc++.so ,libijksdl.so ,libijkplayer.so,这些文件是cmake编译生成的文件
>+ 点击右侧gradle命令->ijkplayer_hos->ijkplayer->ohos:debug->generateDebugClassesJar,在ijkplayer/build/intermediates/javac/debug/下生成classes.jar
>+ libc++.so ，libijkffmpeg.so ，libijksdl.so  ，libijkplayer.so和classes.jar，这些就是需要集成到工程的最终成品

## 相关文件溯源
>+ 其中libOpenSLES.so是从A侧平台的 NDK 拷贝而来
>+ libatomic.a也是从A侧平台的NDK拷贝而来
>+ libijkffmpeg.so，libsoundtouch.a，libyuv.a及其ijkplayer_so/src/main/cpp/libs中涉及的一些头文件等等都是在linux
环境下编译原ijkplayer后拿过来的，这块的内容可以直接看ijkplayer项目的[readme](https://github.com/bilibili/ijkplayer#readme),里面有非常详细的编译过程.  
>+ 唯一要注意的点就是：要保证头文件.h&.c和.so版本是匹配的，否则在播放时会报so找不到。


## 移植总结
>+ 目前画面渲染只支持SurfaceProvider,不支持TextureView，待ohos后续提供相关实现
>+ 软解码为开源ffmpeg实现,ohos平台的硬解码目前暂未适配
>+ 音频播放，用的OpenSLes和AudioRenderer,两者可自选,其中默认为AudioRenderer
>+ 如果你需要更换新的ffmpeg版本或者定制ffmpeg源码重新编译，请同步修改ijkplayer_hos工程中对应的文件（主要是entry/src/main/cpp/libs
目录，其他的不用动,建议用文件对比工具对比看下cpp/libs哪些文件有差异），例如替换libijkffmpeg.so后请一定同步替换libffmpeg/include下的相关文件，特别是头文件,
直接把linux环境下编译完成的相关文件复制到此工程即可，否则头文件和so不匹配会出现即使编译通过，但是应用在播放视频加载so的时候依然crash的问题

## 后续迭代计划
>+ 1：相关so发布到远程maven 
>+ 2：兼容原生Player 

## 附录1：linux环境下编译github的ijkplayer工程
##### 配置编译环境
>+ 1. 搭建linux环境
>+ 2. 下载A侧linux版的NDK，版本最小ndk10，最大ndk14，配置ndk环境变量
>+ 3. git clone ijkplayer的源码
>+ 4. 完整的编译脚本参考github的流程[readme](https://github.com/bilibili/ijkplayer#readme)，这里只说一些特殊的供参考：
```
   //需要openssl模块,可执行以下代码，用于播放https的视频，不需要则忽略，直接下一步
   ./compile-openssl.sh clean
   ./compile-openssl.sh all
```
   
```
   //如果只需要某个指令集的so，可以用以下指令，这里以64位的为例
   //编译完成后可用的ijkplayer相关的so存放的目录为ijkplayer/ijkplayer-arm64/src/main/libs/arm64-v8a
   ./compile-openssl.sh arm64
```   
>+ 5. 值得注意的一点是，如果你需要选择jkplayer编译的ffmpeg，openssl版本，
可以在[init-android.sh](https://github.com/bilibili/ijkplayer/blob/master/init-android.sh)脚本修改IJK_FFMPEG_COMMIT参数去选定[ffmpeg版本](https://github.com/bilibili/FFmpeg)，
在[init-android-openssl.sh](https://github.com/bilibili/ijkplayer/blob/master/init-android-openssl.sh)脚本修改IJK_OPENSSL_COMMIT参数去选定[openssl版本](https://github.com/bilibili/openssl)，
这些版本bilibili已经fork代码，放在他们的仓库里，可以从Tags获取版本信息。

### License

```
Copyright (c) 2017 Bilibili
Licensed under LGPLv2.1 or later
```

ijkplayer required features are based on or derives from projects below:
- LGPL
  - [FFmpeg](http://git.videolan.org/?p=ffmpeg.git)
  - [libVLC](http://git.videolan.org/?p=vlc.git)
  - [kxmovie](https://github.com/kolyvan/kxmovie)
  - [soundtouch](http://www.surina.net/soundtouch/sourcecode.html)
- zlib license
  - [SDL](http://www.libsdl.org)
- BSD-style license
  - [libyuv](https://code.google.com/p/libyuv/)
- ISC license
  - [libyuv/source/x86inc.asm](https://code.google.com/p/libyuv/source/browse/trunk/source/x86inc.asm)

android/ijkplayer-exo is based on or derives from projects below:
- Apache License 2.0
  - [ExoPlayer](https://github.com/google/ExoPlayer)

android/example is based on or derives from projects below:
- GPL
  - [android-ndk-profiler](https://github.com/richq/android-ndk-profiler) (not included by default)

ios/IJKMediaDemo is based on or derives from projects below:
- Unknown license
  - [iOS7-BarcodeScanner](https://github.com/jpwiddy/iOS7-BarcodeScanner)

ijkplayer's build scripts are based on or derives from projects below:
- [gas-preprocessor](http://git.libav.org/?p=gas-preprocessor.git)
- [VideoLAN](http://git.videolan.org)
- [yixia/FFmpeg-Android](https://github.com/yixia/FFmpeg-Android)
- [kewlbear/FFmpeg-iOS-build-script](https://github.com/kewlbear/FFmpeg-iOS-build-script) 

 ### Commercial Use

ijkplayer is licensed under LGPLv2.1 or later, so itself is free for commercial use under LGPLv2.1 or later

But ijkplayer is also based on other different projects under various licenses, which I have no idea whether they are compatible to each other or to your product.

[IANAL](https://en.wikipedia.org/wiki/IANAL), you should always ask your lawyer for these stuffs before use it in your product.



