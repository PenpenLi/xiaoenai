package com.alibaba.sdk.android.trace;

import android.util.Log;
import com.alibaba.sdk.android.message.Message;

public class AliSDKLogger
{
  public static void d(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    TraceLoggerManager.INSTANCE.log(paramInt, 3, paramString1, paramString2, paramString3);
  }
  
  public static void d(String paramString)
  {
    TraceLoggerManager.INSTANCE.log(2, 3, null, null, paramString);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    TraceLoggerManager.INSTANCE.log(paramString1, paramInt, 3, paramString2, paramString3, paramString4);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    TraceLoggerManager.INSTANCE.log(paramString1, 2, 3, null, null, paramString2);
  }
  
  public static void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    TraceLoggerManager.INSTANCE.log(paramInt, 6, paramString1, paramString2, paramString3);
  }
  
  public static void e(int paramInt, String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    TraceLoggerManager.INSTANCE.log(paramInt, 6, paramString1, paramString2, paramString3 + '\n' + Log.getStackTraceString(paramThrowable));
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    TraceLoggerManager.INSTANCE.log(paramString1, paramInt, 6, paramString2, paramString3, paramString4);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, Throwable paramThrowable)
  {
    TraceLoggerManager.INSTANCE.log(paramString1, paramInt, 6, paramString2, paramString3, paramString4 + '\n' + Log.getStackTraceString(paramThrowable));
  }
  
  public static void e(String paramString1, String paramString2)
  {
    TraceLoggerManager.INSTANCE.log(paramString1, 2, 6, null, null, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    TraceLoggerManager.INSTANCE.log(paramString1, 2, 6, null, null, paramString2 + '\n' + Log.getStackTraceString(paramThrowable));
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    TraceLoggerManager.INSTANCE.log(paramString, 2, 6, null, null, Log.getStackTraceString(paramThrowable));
  }
  
  public static void i(String paramString1, String paramString2)
  {
    TraceLoggerManager.INSTANCE.log(paramString1, 2, 4, null, null, paramString2);
  }
  
  public static boolean isDebugEnabled()
  {
    return TraceLoggerManager.INSTANCE.isLogCatDebugEnabled();
  }
  
  public static void log(int paramInt, String paramString)
  {
    d(paramInt, null, null, paramString);
  }
  
  public static void log(String paramString)
  {
    log(1, paramString);
  }
  
  public static void log(String paramString, Message paramMessage)
  {
    log(paramString, paramMessage, null);
  }
  
  public static void log(String paramString, Message paramMessage, Throwable paramThrowable)
  {
    if (!isDebugEnabled()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("***********************************************************\n");
    localStringBuilder.append("错误编码 = ").append(paramMessage.code).append("\n");
    localStringBuilder.append("错误消息 = ").append(paramMessage.message).append("\n");
    localStringBuilder.append("解决建议 = ").append(paramMessage.action).append("\n");
    if (paramThrowable != null) {
      localStringBuilder.append("错误堆栈 = ").append(Log.getStackTraceString(paramThrowable)).append("\n");
    }
    localStringBuilder.append("***********************************************************\n");
    paramMessage = paramMessage.type;
    if ("D".equals(paramMessage))
    {
      d(paramString, localStringBuilder.toString());
      return;
    }
    if ("E".equals(paramMessage))
    {
      e(paramString, localStringBuilder.toString());
      return;
    }
    if ("W".equals(paramMessage))
    {
      w(paramString, localStringBuilder.toString());
      return;
    }
    i(paramString, localStringBuilder.toString());
  }
  
  public static void printStackTraceAndMore(Throwable paramThrowable)
  {
    TraceLoggerManager.INSTANCE.log(2, 6, null, null, Log.getStackTraceString(paramThrowable));
  }
  
  public static void w(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    TraceLoggerManager.INSTANCE.log(paramInt, 5, paramString1, paramString2, paramString3);
  }
  
  public static void w(int paramInt, String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    TraceLoggerManager.INSTANCE.log(paramInt, 5, paramString1, paramString2, paramString3 + '\n' + Log.getStackTraceString(paramThrowable));
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    TraceLoggerManager.INSTANCE.log(paramString1, paramInt, 5, paramString2, paramString3, paramString4);
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, Throwable paramThrowable)
  {
    TraceLoggerManager.INSTANCE.log(paramString1, paramInt, 5, paramString2, paramString3, paramString4 + '\n' + Log.getStackTraceString(paramThrowable));
  }
  
  public static void w(String paramString1, String paramString2)
  {
    TraceLoggerManager.INSTANCE.log(paramString1, 2, 5, null, null, paramString2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\trace\AliSDKLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */