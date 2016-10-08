package com.sina.weibo.sdk.statistic;

import android.content.Context;

class StatisticConfig
{
  public static boolean ACTIVITY_DURATION_OPEN = false;
  private static final long DEFAULT_UPLOAD_INTERVAL = 90000L;
  private static final long MAX_UPLOAD_INTERVAL = 28800000L;
  public static final long MIN_UPLOAD_INTERVAL = 30000L;
  public static long kContinueSessionMillis;
  private static long kForceUploadInterval = 30000L;
  private static long kUploadInterval;
  private static String mAppkey = null;
  private static String mChannel = null;
  private static boolean mNeedGizp;
  
  static
  {
    ACTIVITY_DURATION_OPEN = true;
    mNeedGizp = true;
    kContinueSessionMillis = 30000L;
    kUploadInterval = 90000L;
  }
  
  public static String getAppkey(Context paramContext)
  {
    if (mAppkey == null) {
      mAppkey = LogBuilder.getAppKey(paramContext);
    }
    return mAppkey;
  }
  
  public static String getChannel(Context paramContext)
  {
    if (mChannel == null) {
      mChannel = LogBuilder.getChannel(paramContext);
    }
    return mChannel;
  }
  
  public static long getForceUploadInterval()
  {
    return kForceUploadInterval;
  }
  
  public static long getUploadInterval()
  {
    return kUploadInterval;
  }
  
  public static boolean isNeedGizp()
  {
    return mNeedGizp;
  }
  
  public static void setAppkey(String paramString)
  {
    mAppkey = paramString;
  }
  
  public static void setChannel(String paramString)
  {
    mChannel = paramString;
  }
  
  public static void setForceUploadInterval(long paramLong)
  {
    kForceUploadInterval = paramLong;
  }
  
  public static void setNeedGizp(boolean paramBoolean)
  {
    mNeedGizp = paramBoolean;
  }
  
  public static void setUploadInterval(long paramLong)
  {
    if ((paramLong < 30000L) || (paramLong > 28800000L)) {
      throw new Exception("The interval must be between 30 seconds and 8 hours");
    }
    kUploadInterval = paramLong;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\statistic\StatisticConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */