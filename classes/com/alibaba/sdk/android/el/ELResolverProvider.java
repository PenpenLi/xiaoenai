package com.alibaba.sdk.android.el;

public abstract interface ELResolverProvider
{
  public static final String EL_KEY_NAME = "key";
  
  public abstract String getValue(String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\el\ELResolverProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */