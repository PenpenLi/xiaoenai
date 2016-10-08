package com.taobao.wireless.security.adapter.b;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.statickeyencrypt.a;
import com.taobao.wireless.security.adapter.JNICLibrary;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public final class b
{
  private JNICLibrary a = JNICLibrary.a();
  
  private String a(String[] paramArrayOfString, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i] != null) {}
      try
      {
        paramArrayOfString[i] = new String(paramArrayOfString[i].getBytes("UTF-8"), "UTF-8");
        i += 1;
      }
      catch (UnsupportedEncodingException paramArrayOfString)
      {
        throw new SecException("", 601);
      }
    }
    if (paramInt1 != 0)
    {
      paramString1 = (String)this.a.doCommandNative(401, new int[] { paramInt1, paramInt2 }, new String[] { paramString1, paramString2 }, null, new Object[] { paramArrayOfString });
      if (paramInt2 != 0)
      {
        paramArrayOfString = paramString1;
        if (paramInt2 != 2) {}
      }
      else
      {
        paramArrayOfString = paramString1;
        if (paramString1 != null) {
          paramArrayOfString = paramString1.toUpperCase();
        }
      }
      return paramArrayOfString;
    }
    throw new SecException("", 601);
  }
  
  public final String a(SecurityGuardParamContext paramSecurityGuardParamContext, String paramString)
  {
    int i = 2;
    String str1 = paramSecurityGuardParamContext.appKey;
    Object localObject = paramSecurityGuardParamContext.paramMap;
    int j = a.a.a[paramSecurityGuardParamContext.requestType];
    paramSecurityGuardParamContext = null;
    switch (1.a[(j - 1)])
    {
    default: 
      i = 0;
    }
    while (paramSecurityGuardParamContext != null)
    {
      return a(paramSecurityGuardParamContext, i, str1, j - 1, paramString);
      if ((localObject != null) && (((Map)localObject).size() != 2))
      {
        String.format("Input map size invalid : required size is \"%d\" and actual size is \"%d\"", new Object[] { Integer.valueOf(2), Integer.valueOf(((Map)localObject).size()) });
        throw new SecException("", 601);
      }
      String str2 = (String)((Map)localObject).get("INPUT");
      localObject = a.a((String)((Map)localObject).get("SEEDKEY"));
      if ((str2 != null) && (!"".equals(str2)) && (localObject != null) && (!"".equals(localObject)))
      {
        paramSecurityGuardParamContext = new String[2];
        paramSecurityGuardParamContext[0] = str2;
        paramSecurityGuardParamContext[1] = localObject;
      }
      else
      {
        if ((str2 == null) || ("".equals(str2)))
        {
          String.format("Input map value invalid : key \"%1s\" not exits or the relative value is empty", new Object[] { "INPUT" });
          throw new SecException("", 601);
        }
        throw new SecException("", 606);
        if ((localObject != null) && (((Map)localObject).size() != 1))
        {
          String.format("Input map size invalid : required size is \"%d\" and actual size is \"%d\"", new Object[] { Integer.valueOf(1), Integer.valueOf(((Map)localObject).size()) });
          throw new SecException("", 601);
        }
        localObject = (String)((Map)localObject).get("INPUT");
        if ((localObject != null) && (!"".equals(localObject)))
        {
          paramSecurityGuardParamContext = new String[1];
          paramSecurityGuardParamContext[0] = localObject;
          i = 1;
        }
        else
        {
          String.format("Input map value invalid : key \"%1s\" not exits or the relative value is empty", new Object[] { "INPUT" });
          throw new SecException("", 601);
        }
      }
    }
    throw new SecException("", 601);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */