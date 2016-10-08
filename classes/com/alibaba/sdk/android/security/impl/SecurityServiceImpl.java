package com.alibaba.sdk.android.security.impl;

import com.alibaba.sdk.android.security.SecurityService;
import com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent;

public class SecurityServiceImpl
  implements SecurityService
{
  public static final SecurityService INSTANCE = new SecurityServiceImpl();
  
  private Long analyzeOpenId(String paramString, byte[] paramArrayOfByte)
  {
    return SecurityGuardWrapper.INSTANCE.analyzeOpenId(paramString, "AppIDKey", "OpenIDSaltKey", paramArrayOfByte);
  }
  
  public Long analyzeItemId(String paramString)
  {
    return analyzeOpenId(paramString, IOpenSDKComponent.OPEN_BIZ_IID);
  }
  
  public Long analyzeUserId(String paramString)
  {
    return analyzeOpenId(paramString, IOpenSDKComponent.OPEN_BIZ_UID);
  }
  
  public String signTopOld(String paramString)
  {
    return SecurityGuardWrapper.INSTANCE.signRequest(paramString, 2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\impl\SecurityServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */