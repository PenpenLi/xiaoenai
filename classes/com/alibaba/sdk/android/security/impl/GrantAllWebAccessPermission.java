package com.alibaba.sdk.android.security.impl;

import com.alibaba.sdk.android.security.WebAccessPermission;

public class GrantAllWebAccessPermission
  implements WebAccessPermission
{
  public boolean checkPermission(String paramString)
  {
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\impl\GrantAllWebAccessPermission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */