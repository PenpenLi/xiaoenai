package com.taobao.applink.util;

import android.util.Log;
import java.security.MessageDigest;

public class TBAppLinkMD5Util
{
  private static final String MD5 = "MD5";
  
  public static String encryptByMD5(String paramString)
  {
    if (TBAppLinkStringUtil.isBlank(paramString)) {
      return null;
    }
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = new StringBuffer();
      localObject = ((MessageDigest)localObject).digest();
      int i = 0;
      while (i < localObject.length)
      {
        int k = localObject[i];
        int j = k;
        if (k < 0) {
          j = k + 256;
        }
        if (j < 16) {
          paramString.append("0");
        }
        paramString.append(Integer.toHexString(j));
        i += 1;
      }
      paramString = paramString.toString();
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.d("AppLink", paramString.toString());
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\applink\util\TBAppLinkMD5Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */