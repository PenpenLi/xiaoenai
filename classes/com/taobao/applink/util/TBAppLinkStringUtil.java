package com.taobao.applink.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TBAppLinkStringUtil
{
  public static final String IS_NUMERIC = "[0-9]*";
  public static final String IS_URL = "^(http://|https://)?((?:[A-Za-z0-9]+-[A-Za-z0-9]+|[A-Za-z0-9]+)\\.)+([A-Za-z]+)[/\\?\\:]?.*$";
  
  public static boolean compatVersion(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    paramString1 = paramString1.split("[.]");
    paramString2 = paramString2.split("[.]");
    if (paramString1.length < paramString2.length) {}
    int k;
    int m;
    for (int i = paramString1.length;; i = paramString2.length)
    {
      int j = 0;
      for (;;)
      {
        if (j >= i) {
          break label103;
        }
        k = Integer.valueOf(paramString1[j]).intValue();
        m = Integer.valueOf(paramString2[j]).intValue();
        if (k != m) {
          break;
        }
        j += 1;
      }
    }
    return k > m;
    label103:
    if (paramString1.length > paramString2.length) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean isBlank(String paramString)
  {
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (paramString != null)
    {
      j = paramString.length();
      if (j != 0) {}
    }
    else
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label48;
      }
      bool1 = bool2;
      if (!Character.isWhitespace(paramString.charAt(i))) {
        break;
      }
      i += 1;
    }
    label48:
    return true;
  }
  
  public static boolean isNumeric(String paramString)
  {
    if (isBlank(paramString)) {
      return false;
    }
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public static boolean isURL(String paramString)
  {
    if (isBlank(paramString)) {
      return false;
    }
    return Pattern.compile("^(http://|https://)?((?:[A-Za-z0-9]+-[A-Za-z0-9]+|[A-Za-z0-9]+)\\.)+([A-Za-z]+)[/\\?\\:]?.*$").matcher(paramString).matches();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\util\TBAppLinkStringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */