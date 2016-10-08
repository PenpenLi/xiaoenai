package com.adhoc;

import java.net.Proxy.Type;

public final class ec
{
  public static String a(bc parambc)
  {
    String str1 = parambc.i();
    String str2 = parambc.k();
    parambc = str1;
    if (str2 != null) {
      parambc = str1 + '?' + str2;
    }
    return parambc;
  }
  
  public static String a(bi parambi)
  {
    if (parambi == bi.a) {
      return "HTTP/1.0";
    }
    return "HTTP/1.1";
  }
  
  static String a(bj parambj, Proxy.Type paramType, bi parambi)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parambj.d());
    localStringBuilder.append(' ');
    if (a(parambj, paramType)) {
      localStringBuilder.append(parambj.a());
    }
    for (;;)
    {
      localStringBuilder.append(' ');
      localStringBuilder.append(a(parambi));
      return localStringBuilder.toString();
      localStringBuilder.append(a(parambj.a()));
    }
  }
  
  private static boolean a(bj parambj, Proxy.Type paramType)
  {
    return (!parambj.i()) && (paramType == Proxy.Type.HTTP);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */