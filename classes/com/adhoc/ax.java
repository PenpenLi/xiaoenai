package com.adhoc;

import java.io.UnsupportedEncodingException;

public final class ax
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = er.a((paramString1 + ":" + paramString2).getBytes("ISO-8859-1")).b();
      paramString1 = "Basic " + paramString1;
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new AssertionError();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */