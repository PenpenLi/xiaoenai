package com.alibaba.wireless.security.open.securesignature;

import android.content.ContextWrapper;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.taobao.wireless.security.adapter.b.b;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements ISecureSignatureComponent
{
  private b a = new b();
  private ContextWrapper b = null;
  
  public a(ContextWrapper paramContextWrapper)
  {
    this.b = paramContextWrapper;
  }
  
  public final String getSafeCookie(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      SecurityGuardManager localSecurityGuardManager = SecurityGuardManager.getInstance(this.b);
      Object localObject = new HashMap();
      ((HashMap)localObject).put("INPUT", paramString1);
      SecurityGuardParamContext localSecurityGuardParamContext = new SecurityGuardParamContext();
      localSecurityGuardParamContext.appKey = paramString2;
      localSecurityGuardParamContext.paramMap = ((Map)localObject);
      localSecurityGuardParamContext.requestType = 3;
      localObject = localSecurityGuardManager.getSecureSignatureComp().signRequest(localSecurityGuardParamContext, paramString3);
      paramString1 = (String)localObject + paramString1;
      paramString1 = localSecurityGuardManager.getStaticDataEncryptComp().staticSafeEncrypt(16, paramString2, paramString1, paramString3);
      paramString1 = "AE001" + paramString1;
      return paramString1;
    }
    catch (SecException paramString1)
    {
      if ((paramString1.getErrorCode() > 600) && (paramString1.getErrorCode() < 699)) {
        throw paramString1;
      }
      if (paramString1.getErrorCode() == 302) {
        throw new SecException(607);
      }
      if (paramString1.getErrorCode() == 303) {
        throw new SecException(608);
      }
      if (paramString1.getErrorCode() == 304) {
        throw new SecException(609);
      }
      if (paramString1.getErrorCode() == 305) {
        throw new SecException(610);
      }
      if (paramString1.getErrorCode() == 306) {
        throw new SecException(611);
      }
      if (paramString1.getErrorCode() == 307) {
        throw new SecException(612);
      }
      if (paramString1.getErrorCode() == 308) {
        throw new SecException(602);
      }
      throw new SecException(699);
    }
  }
  
  public final String signRequest(SecurityGuardParamContext paramSecurityGuardParamContext, String paramString)
  {
    if ((paramSecurityGuardParamContext == null) || (paramSecurityGuardParamContext.paramMap == null)) {
      return null;
    }
    return this.a.a(paramSecurityGuardParamContext, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\securesignature\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */