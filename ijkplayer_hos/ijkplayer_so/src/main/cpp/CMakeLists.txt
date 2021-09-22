# the minimum version of CMake.
cmake_minimum_required(VERSION 3.10.2)

project("ijkplayer")

set(CMAKE_C_FLAGS "-std=c99 -Wno-typedef-redefinition")

add_subdirectory(ijksdl)

add_library(ijkplayer  SHARED
                               ff_cmdutils.c
                               ff_ffplay.c
                               ff_ffpipeline.c
                               ff_ffpipenode.c
                               ijkmeta.c
                               ijkplayer.c
                               pipeline/ffpipeline_ffplay.c
                               pipeline/ffpipenode_ffplay_vdec.c
                               android/ffmpeg_api_jni.c
                               android/ijkplayer_android.c
                                android/ijkplayer_jni.c
                               android/pipeline/ffpipeline_android.c
                               android/pipeline/ffpipenode_android_mediacodec_vdec.c
                               ijkavformat/allformats.c
                               ijkavformat/ijklivehook.c
                               ijkavformat/ijkmediadatasource.c
                               ijkavformat/ijkio.c
                               ijkavformat/ijkiomanager.c
                               ijkavformat/ijkiocache.c
                               ijkavformat/ijkioffio.c
                               ijkavformat/ijkioandroidio.c
                                ijkavformat/ijkioprotocol.c
                                ijkavformat/ijkioapplication.c
                                ijkavformat/ijkiourlhook.c
                                ijkavformat/ijkasync.c
                                ijkavformat/ijkurlhook.c
                                ijkavformat/ijklongurl.c
                                ijkavformat/ijksegment.c
                                ijkavutil/ijkdict.c
                                ijkavutil/ijkutils.c
                                ijkavutil/ijkthreadpool.c
                                 ijkavutil/ijktree.c
                                 ijkavutil/ijkfifo.c
                                 ijkavutil/ijkstl.cpp
                                  )

add_library(soundtouch STATIC IMPORTED)
set_target_properties(soundtouch PROPERTIES IMPORTED_LOCATION ${CMAKE_CURRENT_SOURCE_DIR}/libs/soundtouch/${OHOS_ARCH}/libsoundtouch.a)

add_library(ffmpeg SHARED IMPORTED)
set_target_properties(ffmpeg PROPERTIES IMPORTED_LOCATION ${CMAKE_CURRENT_SOURCE_DIR}/libs/libffmpeg/${OHOS_ARCH}/libijkffmpeg.so)

add_library(openSLES SHARED IMPORTED)
set_target_properties(openSLES PROPERTIES IMPORTED_LOCATION ${CMAKE_CURRENT_SOURCE_DIR}/libs/openSLES/${OHOS_ARCH}/libOpenSLES.so)

add_library(ijksdl_so SHARED IMPORTED)
set_target_properties(ijksdl_so PROPERTIES IMPORTED_LOCATION ${CMAKE_LIBRARY_OUTPUT_DIRECTORY}/libijksdl.so)

if(${OHOS_ARCH} STREQUAL "armeabi-v7a")
add_library(atomic_static STATIC IMPORTED)
set_target_properties(atomic_static PROPERTIES IMPORTED_LOCATION ${CMAKE_CURRENT_SOURCE_DIR}/../libs/atomic/${OHOS_ARCH}/libatomic.a)
endif()

include_directories(${CMAKE_CURRENT_SOURCE_DIR})
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/libs/libffmpeg/include)
#include_directories(${CMAKE_CURRENT_SOURCE_DIR}/libs/ijk4a/include)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/libs/yuv/include)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/libs/soundtouch/include)



if(${OHOS_ARCH} STREQUAL "armeabi-v7a")
target_link_libraries(ijkplayer atomic_staic ijksdl_so
ohoslog soundtouch ffmpeg  EGL GLESv3 zgraphic.z openSLES hilog_ndk.z)
else()
target_link_libraries(ijkplayer ijksdl_so
ohoslog soundtouch ffmpeg  EGL GLESv3 zgraphic.z openSLES hilog_ndk.z)
endif()