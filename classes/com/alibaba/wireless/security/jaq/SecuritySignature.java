package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import java.util.HashMap;

public class SecuritySignature
{
  private Context a;
  
  public SecuritySignature(Context paramContext)
  {
    if (paramContext != null) {
      this.a = paramContext.getApplicationContext();
    }
  }
  
  public String atlasSign(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("INPUT", paramString1);
    paramString1 = new SecurityGuardParamContext();
    paramString1.appKey = paramString2;
    paramString1.paramMap = localHashMap;
    paramString1.requestType = 5;
    try
    {
      if (SecurityGuardManager.getInstance(this.a).getAtlasEncryptComp() != null) {
        return SecurityGuardManager.getInstance(this.a).getSecureSignatureComp().signRequest(paramString1, "0335");
      }
      throw new SecException(1098);
    }
    catch (SecException paramString1)
    {
      paramString1.printStackTrace();
      throw new JAQException(paramString1.getErrorCode());
    }
  }
  
  public String sign(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("INPUT", paramString1);
    paramString1 = new SecurityGuardParamContext();
    paramString1.appKey = paramString2;
    paramString1.paramMap = localHashMap;
    paramString1.requestType = 3;
    try
    {
      paramString1 = SecurityGuardManager.getInstance(this.a).getSecureSignatureComp().signRequest(paramString1, "0335");
      return paramString1;
    }
    catch (SecException paramString1)
    {
      paramString1.printStackTrace();
      throw new JAQException(paramString1.getErrorCode());
    }
  }
  
  public String signWithSimulator(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("INPUT", paramString1);
    paramString1 = new SecurityGuardParamContext();
    paramString1.appKey = paramString2;
    paramString1.paramMap = localHashMap;
    paramString1.requestType = 6;
    try
    {
      paramString1 = SecurityGuardManager.getInstance(this.a).getSecureSignatureComp().signRequest(paramString1, "0335");
      return paramString1;
    }
    catch (SecException paramString1)
    {
      paramString1.printStackTrace();
      throw new JAQException(paramString1.getErrorCode());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\jaq\SecuritySignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */