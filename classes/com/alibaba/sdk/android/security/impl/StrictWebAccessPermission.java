package com.alibaba.sdk.android.security.impl;

import com.alibaba.sdk.android.security.WebAccessPermission;

public class StrictWebAccessPermission
  implements WebAccessPermission
{
  private String targetUrl;
  
  public StrictWebAccessPermission(String paramString)
  {
    this.targetUrl = paramString;
  }
  
  public boolean checkPermission(String paramString)
  {
    return this.targetUrl.equals(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\impl\StrictWebAccessPermission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */