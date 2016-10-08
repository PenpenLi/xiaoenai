package com.alibaba.sdk.android.util;

import com.alibaba.sdk.android.trace.AliSDKLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLUtils
{
  protected static final String TAG = URLUtils.class.getName();
  
  public static String changeQueryValue(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = paramString1;
    if (paramString2 != null)
    {
      str = paramString1;
      if (paramString3 != null)
      {
        if (paramString4 != null) {
          break label24;
        }
        str = paramString1;
      }
    }
    label24:
    int j;
    int m;
    do
    {
      do
      {
        do
        {
          do
          {
            return str;
            i = paramString1.indexOf('?');
            str = paramString1;
          } while (i < 0);
          paramString2 = encode(paramString2, paramString4);
          str = paramString1;
        } while (i > paramString1.length());
        j = paramString1.indexOf('#', i);
        m = paramString1.indexOf(paramString2 + '=', i);
        str = paramString1;
      } while (m <= i);
      if (j < 0) {
        break;
      }
      str = paramString1;
    } while (m >= j);
    int k = paramString1.indexOf('&', m);
    if (k >= 0)
    {
      i = k;
      if (k > j)
      {
        i = k;
        if (j <= 0) {}
      }
    }
    else
    {
      if (j >= 0) {
        break label214;
      }
    }
    label214:
    for (int i = paramString1.length();; i = j)
    {
      paramString1 = paramString1.substring(0, m + paramString2.length() + 1) + encode(paramString3, paramString4) + paramString1.substring(i);
      break;
    }
  }
  
  public static String decode(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return paramString1;
    }
    try
    {
      paramString2 = URLDecoder.decode(paramString1, paramString2);
      return paramString2;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      AliSDKLogger.e(TAG, paramString2.getMessage(), paramString2);
    }
    return paramString1;
  }
  
  public static String encode(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return paramString1;
    }
    try
    {
      paramString2 = URLEncoder.encode(paramString1, paramString2);
      return paramString2;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      AliSDKLogger.e(TAG, paramString2.getMessage(), paramString2);
    }
    return paramString1;
  }
  
  public static String subUrlHash(String paramString)
  {
    int i = paramString.indexOf("#");
    String str = paramString;
    if (i != -1) {
      str = paramString.substring(0, i);
    }
    return str;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\URLUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */