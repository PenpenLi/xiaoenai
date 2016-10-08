package com.alipay.apmobilesecuritysdk.e;

import java.io.PrintStream;
import java.util.Map;
import java.util.Set;

public final class a
{
  public static String a(Map<String, Integer> paramMap, String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() <= 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2 + ":");
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      return localStringBuilder.toString();
    }
    paramString1 = paramString1.split(",");
    if ((paramString1 == null) || (paramString1.length <= 0)) {
      return localStringBuilder.toString();
    }
    if ((paramMap == null) || (paramMap.size() <= 0)) {
      return localStringBuilder.toString();
    }
    paramMap = paramMap.keySet();
    if ((paramMap == null) || (paramMap.size() <= 0)) {
      return localStringBuilder.toString();
    }
    try
    {
      paramString2 = new byte[paramString1.length / 8 + 1];
      int i = 0;
      while (i < paramString2.length)
      {
        paramString2[i] = 0;
        i += 1;
      }
      int n = paramString1.length;
      i = 0;
      int j = 0;
      while (i < n)
      {
        Object localObject = paramString1[i];
        int m = paramString2[(j / 8)];
        int k = m;
        if (paramMap.contains(localObject))
        {
          k = m | 128 >> j % 8;
          System.out.println(j);
        }
        paramString2[(j / 8)] = ((byte)(k & 0xFF));
        j += 1;
        i += 1;
      }
      localStringBuilder.append(com.alipay.security.mobile.module.a.a.a.a(paramString2));
    }
    catch (Throwable paramMap)
    {
      for (;;) {}
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */