

#include "log.h""



int __android_log_vprint(int prio, const char* tag, const char* fmt, va_list ap){

   // HiLogPrint(LOG_APP,LOG_ERROR,10,tag,fmt,ap);
    return 0;
}

int __android_log_print(int prio, const char* tag, const char* fmt, ...){
   // HiLogPrint(LOG_APP,LOG_ERROR,10,tag,fmt);
    return 0;
}