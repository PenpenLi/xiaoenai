package com.alibaba.wireless.security.open.securesignature;

import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;

public abstract interface ISecureSignatureComponent
  extends IComponent
{
  public abstract String getSafeCookie(String paramString1, String paramString2, String paramString3);
  
  public abstract String signRequest(SecurityGuardParamContext paramSecurityGuardParamContext, String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\securesignature\ISecureSignatureComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */