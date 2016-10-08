package com.alibaba.nb.android.trade.utils.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class AliTradeHttpHelper
{
  public static String a(String paramString)
  {
    try
    {
      paramString = a.a(b(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new HttpHelpterException(paramString);
    }
  }
  
  private static InputStream b(String paramString)
  {
    try
    {
      paramString = c(paramString);
      int i = paramString.getResponseCode();
      if (i != 200) {
        throw new RuntimeException("http request exception, response code: " + i);
      }
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString);
    }
    paramString = paramString.getInputStream();
    return paramString;
  }
  
  private static HttpURLConnection c(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setConnectTimeout(5000);
      paramString.setReadTimeout(5000);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static class HttpHelpterException
    extends Exception
  {
    HttpHelpterException(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\http\AliTradeHttpHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */