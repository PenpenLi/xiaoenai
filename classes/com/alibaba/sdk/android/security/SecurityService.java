package com.alibaba.sdk.android.security;

public abstract interface SecurityService
{
  public abstract Long analyzeItemId(String paramString);
  
  public abstract Long analyzeUserId(String paramString);
  
  public abstract String signTopOld(String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\SecurityService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */