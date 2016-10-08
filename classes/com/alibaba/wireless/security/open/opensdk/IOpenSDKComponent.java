package com.alibaba.wireless.security.open.opensdk;

public abstract interface IOpenSDKComponent
{
  public static final byte[] OPEN_BIZ_IID = { 0, 2 };
  public static final byte[] OPEN_BIZ_TID = { 0, 3 };
  public static final byte[] OPEN_BIZ_UID = { 0, 1 };
  
  public abstract Long analyzeOpenId(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\opensdk\IOpenSDKComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */