package com.alibaba.sdk.android.security;

public abstract interface AccessController
{
  public abstract boolean checkPluginLoadPermission(String paramString);
  
  public abstract boolean checkWebPageAccessPermission(String paramString);
  
  public abstract String getConfigProperty(String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\AccessController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */