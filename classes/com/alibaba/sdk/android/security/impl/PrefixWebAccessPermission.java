package com.alibaba.sdk.android.security.impl;

import com.alibaba.sdk.android.security.WebAccessPermission;

public class PrefixWebAccessPermission
  implements WebAccessPermission
{
  private String prefix;
  
  public PrefixWebAccessPermission(String paramString)
  {
    this.prefix = paramString;
  }
  
  public boolean checkPermission(String paramString)
  {
    return (paramString != null) && (paramString.startsWith(this.prefix));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\impl\PrefixWebAccessPermission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */