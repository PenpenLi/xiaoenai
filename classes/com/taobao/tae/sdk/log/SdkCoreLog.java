package com.taobao.tae.sdk.log;

import android.util.Log;
import com.alibaba.sdk.android.ConfigManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SdkCoreLog
{
  public static final String FAILURE = "failure";
  public static final String SUCCESS = "success";
  private static Map<String, Long> timestamps = new ConcurrentHashMap();
  
  public static String content(String paramString, long paramLong, String... paramVarArgs)
  {
    paramString = new StringBuilder(paramString + ":" + paramLong + ":");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramString.append(paramVarArgs[i]);
      i += 1;
    }
    return paramString.toString();
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if ((ConfigManager.DEBUG) && (paramString1 != null) && (paramString2 != null)) {
      Log.d("SdkCoreDebug", paramString1 + ":" + paramString2);
    }
  }
  
  public static long getTimeUsed(String paramString)
  {
    paramString = (Long)timestamps.remove(paramString);
    if (paramString == null) {
      return 0L;
    }
    return System.currentTimeMillis() - paramString.longValue();
  }
  
  public static void startTimeRecord(String paramString)
  {
    timestamps.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\tae\sdk\log\SdkCoreLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */