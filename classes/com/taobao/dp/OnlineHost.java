package com.taobao.dp;

import java.security.InvalidParameterException;

public final class OnlineHost
{
  private static final int Custrom_Imdex = 3;
  public static final OnlineHost GENERAL = new OnlineHost("GENERAL", "ynuf.alipay.com", 0);
  public static final OnlineHost JAPAN = new OnlineHost("JAPAN", "fcumid.ynuf.alipay.com", 2);
  public static final OnlineHost USA = new OnlineHost("USA", "us.ynuf.alipay.com", 1);
  private String mHost;
  private int mIndex;
  private String mName;
  
  private OnlineHost(String paramString1, String paramString2, int paramInt)
  {
    this.mName = paramString1;
    this.mHost = paramString2;
    this.mIndex = paramInt;
  }
  
  public static OnlineHost valueof(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new InvalidParameterException("Invalid Host");
    }
    return new OnlineHost("", paramString, 3);
  }
  
  public final String getHost()
  {
    return this.mHost;
  }
  
  public final int getIndex()
  {
    return this.mIndex;
  }
  
  public final String getName()
  {
    return this.mName;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\OnlineHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */