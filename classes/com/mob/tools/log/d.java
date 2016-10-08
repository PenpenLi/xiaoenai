package com.mob.tools.log;

import android.content.Context;
import android.util.Log;
import java.util.HashMap;

public abstract class d
{
  private static HashMap<String, d> loggers = new HashMap();
  private static b printer = new b();
  
  static
  {
    c.a();
  }
  
  public d()
  {
    loggers.put(getSDKTag(), this);
    if (loggers.size() == 1) {
      loggers.put("__FIRST__", this);
    }
  }
  
  protected static final d getInstanceForSDK(String paramString, boolean paramBoolean)
  {
    Object localObject2 = (d)loggers.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (d)loggers.get("__FIRST__");
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (paramBoolean) {
        localObject2 = new e(paramString);
      }
    }
    return (d)localObject2;
  }
  
  public static void setCollector(String paramString, a parama)
  {
    printer.a(paramString, parama);
  }
  
  public static void setContext(Context paramContext)
  {
    if (paramContext != null)
    {
      printer.a(paramContext);
      NativeErrorHandler.a(paramContext);
    }
  }
  
  public final int crash(Throwable paramThrowable)
  {
    return printer.a(getSDKTag(), 6, 1, Log.getStackTraceString(paramThrowable));
  }
  
  public final int d(Object paramObject, Object... paramVarArgs)
  {
    String str = paramObject.toString();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    return printer.a(getSDKTag(), 3, 0, (String)paramObject);
  }
  
  public final int d(Throwable paramThrowable)
  {
    return printer.a(getSDKTag(), 3, 0, Log.getStackTraceString(paramThrowable));
  }
  
  public final int d(Throwable paramThrowable, Object paramObject, Object... paramVarArgs)
  {
    String str = paramObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    paramThrowable = (String)paramObject + '\n' + Log.getStackTraceString(paramThrowable);
    return printer.a(getSDKTag(), 3, 0, paramThrowable);
  }
  
  public final int e(Object paramObject, Object... paramVarArgs)
  {
    String str = paramObject.toString();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    return printer.a(getSDKTag(), 6, 0, (String)paramObject);
  }
  
  public final int e(Throwable paramThrowable)
  {
    return printer.a(getSDKTag(), 6, 0, Log.getStackTraceString(paramThrowable));
  }
  
  public final int e(Throwable paramThrowable, Object paramObject, Object... paramVarArgs)
  {
    String str = paramObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    paramThrowable = (String)paramObject + '\n' + Log.getStackTraceString(paramThrowable);
    return printer.a(getSDKTag(), 6, 0, paramThrowable);
  }
  
  protected abstract String getSDKTag();
  
  public final int i(Object paramObject, Object... paramVarArgs)
  {
    String str = paramObject.toString();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    return printer.a(getSDKTag(), 4, 0, (String)paramObject);
  }
  
  public final int i(Throwable paramThrowable)
  {
    return printer.a(getSDKTag(), 4, 0, Log.getStackTraceString(paramThrowable));
  }
  
  public final int i(Throwable paramThrowable, Object paramObject, Object... paramVarArgs)
  {
    String str = paramObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    paramThrowable = (String)paramObject + '\n' + Log.getStackTraceString(paramThrowable);
    return printer.a(getSDKTag(), 4, 0, paramThrowable);
  }
  
  public final void nativeCrashLog(String paramString)
  {
    printer.a(getSDKTag(), paramString);
  }
  
  public final int v(Object paramObject, Object... paramVarArgs)
  {
    String str = paramObject.toString();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    return printer.a(getSDKTag(), 2, 0, (String)paramObject);
  }
  
  public final int v(Throwable paramThrowable)
  {
    return printer.a(getSDKTag(), 2, 0, Log.getStackTraceString(paramThrowable));
  }
  
  public final int v(Throwable paramThrowable, Object paramObject, Object... paramVarArgs)
  {
    String str = paramObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    paramThrowable = (String)paramObject + '\n' + Log.getStackTraceString(paramThrowable);
    return printer.a(getSDKTag(), 2, 0, paramThrowable);
  }
  
  public final int w(Object paramObject, Object... paramVarArgs)
  {
    String str = paramObject.toString();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    return printer.a(getSDKTag(), 5, 0, (String)paramObject);
  }
  
  public final int w(Throwable paramThrowable)
  {
    return printer.a(getSDKTag(), 5, 0, Log.getStackTraceString(paramThrowable));
  }
  
  public final int w(Throwable paramThrowable, Object paramObject, Object... paramVarArgs)
  {
    String str = paramObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    paramObject = str;
    if (paramVarArgs.length > 0) {
      paramObject = String.format(str, paramVarArgs);
    }
    paramThrowable = (String)paramObject + '\n' + Log.getStackTraceString(paramThrowable);
    return printer.a(getSDKTag(), 5, 0, paramThrowable);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\log\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */