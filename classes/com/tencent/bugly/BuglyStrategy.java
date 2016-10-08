package com.tencent.bugly;

import java.util.Map;

public class BuglyStrategy
{
  private String a;
  private String b;
  private String c;
  private long d;
  private String e;
  private String f;
  private boolean g = true;
  private boolean h = true;
  private boolean i = true;
  private Class<?> j = null;
  private boolean k = true;
  private boolean l = true;
  private boolean m = false;
  private a n;
  
  /* Error */
  public String getAppChannel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/tencent/bugly/BuglyStrategy:b	Ljava/lang/String;
    //   6: ifnonnull +14 -> 20
    //   9: invokestatic 54	com/tencent/bugly/crashreport/common/info/a:a	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   12: getfield 56	com/tencent/bugly/crashreport/common/info/a:j	Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 49	com/tencent/bugly/BuglyStrategy:b	Ljava/lang/String;
    //   24: astore_1
    //   25: goto -9 -> 16
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	BuglyStrategy
    //   15	10	1	str	String
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	finally
    //   20	25	28	finally
  }
  
  /* Error */
  public String getAppPackageName()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 59	com/tencent/bugly/BuglyStrategy:c	Ljava/lang/String;
    //   6: ifnonnull +14 -> 20
    //   9: invokestatic 54	com/tencent/bugly/crashreport/common/info/a:a	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   12: getfield 60	com/tencent/bugly/crashreport/common/info/a:c	Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 59	com/tencent/bugly/BuglyStrategy:c	Ljava/lang/String;
    //   24: astore_1
    //   25: goto -9 -> 16
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	BuglyStrategy
    //   15	10	1	str	String
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	finally
    //   20	25	28	finally
  }
  
  public long getAppReportDelay()
  {
    try
    {
      long l1 = this.d;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public String getAppVersion()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/tencent/bugly/BuglyStrategy:a	Ljava/lang/String;
    //   6: ifnonnull +14 -> 20
    //   9: invokestatic 54	com/tencent/bugly/crashreport/common/info/a:a	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   12: getfield 69	com/tencent/bugly/crashreport/common/info/a:i	Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: aload_0
    //   21: getfield 67	com/tencent/bugly/BuglyStrategy:a	Ljava/lang/String;
    //   24: astore_1
    //   25: goto -9 -> 16
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	BuglyStrategy
    //   15	10	1	str	String
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	finally
    //   20	25	28	finally
  }
  
  public a getCrashHandleCallback()
  {
    try
    {
      a locala = this.n;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getDeviceID()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getLibBuglySOFilePath()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Class<?> getUserInfoActivity()
  {
    try
    {
      Class localClass = this.j;
      return localClass;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isBuglyLogUpload()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isEnableANRCrashMonitor()
  {
    try
    {
      boolean bool = this.h;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isEnableNativeCrashMonitor()
  {
    try
    {
      boolean bool = this.g;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isEnableUserInfo()
  {
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isReplaceOldChannel()
  {
    return this.l;
  }
  
  public boolean recordUserInfoOnceADay()
  {
    try
    {
      boolean bool = this.m;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public BuglyStrategy setAppChannel(String paramString)
  {
    try
    {
      this.b = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setAppPackageName(String paramString)
  {
    try
    {
      this.c = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setAppReportDelay(long paramLong)
  {
    try
    {
      this.d = paramLong;
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public BuglyStrategy setAppVersion(String paramString)
  {
    try
    {
      this.a = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setBuglyLogUpload(boolean paramBoolean)
  {
    try
    {
      this.k = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public BuglyStrategy setCrashHandleCallback(a parama)
  {
    try
    {
      this.n = parama;
      return this;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public BuglyStrategy setDeviceID(String paramString)
  {
    try
    {
      this.f = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setEnableANRCrashMonitor(boolean paramBoolean)
  {
    try
    {
      this.h = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public BuglyStrategy setEnableNativeCrashMonitor(boolean paramBoolean)
  {
    try
    {
      this.g = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public BuglyStrategy setEnableUserInfo(boolean paramBoolean)
  {
    try
    {
      this.i = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public BuglyStrategy setLibBuglySOFilePath(String paramString)
  {
    try
    {
      this.e = paramString;
      return this;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public BuglyStrategy setRecordUserInfoOnceADay(boolean paramBoolean)
  {
    try
    {
      this.m = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setReplaceOldChannel(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public BuglyStrategy setUserInfoActivity(Class<?> paramClass)
  {
    try
    {
      this.j = paramClass;
      return this;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public static class a
  {
    public static final int CRASHTYPE_ANR = 4;
    public static final int CRASHTYPE_COCOS2DX_JS = 5;
    public static final int CRASHTYPE_COCOS2DX_LUA = 6;
    public static final int CRASHTYPE_JAVA_CATCH = 1;
    public static final int CRASHTYPE_JAVA_CRASH = 0;
    public static final int CRASHTYPE_NATIVE = 2;
    public static final int CRASHTYPE_U3D = 3;
    public static final int MAX_USERDATA_KEY_LENGTH = 100;
    public static final int MAX_USERDATA_VALUE_LENGTH = 30000;
    
    public Map<String, String> onCrashHandleStart(int paramInt, String paramString1, String paramString2, String paramString3)
    {
      return null;
    }
    
    public byte[] onCrashHandleStart2GetExtraDatas(int paramInt, String paramString1, String paramString2, String paramString3)
    {
      return null;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\tencent\bugly\BuglyStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */