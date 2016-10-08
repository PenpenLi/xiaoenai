package com.alimama.mobile.sdk.config;

public abstract interface IAdBaseInfo
{
  public abstract String encodeModel();
  
  public abstract String getId();
  
  public abstract int getType();
  
  public static class Type
  {
    public static final int AD_BASED = 0;
    public static final int AD_DEVICE = 2;
    public static final int AD_VIDEO = 1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\IAdBaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */