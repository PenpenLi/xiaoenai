package com.xiaoenai.app.utils.d;

import android.os.Bundle;
import android.text.TextUtils;
import java.security.InvalidKeyException;
import java.util.Calendar;

public final class b
{
  public static String a(String paramString1, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    String str = paramString1;
    if (paramString1.startsWith("http://")) {
      str = paramString1.substring(7);
    }
    paramString1 = str;
    if (str.contains("?")) {
      paramString1 = str.substring(0, str.indexOf("?"));
    }
    try
    {
      long l = Calendar.getInstance().getTimeInMillis() / 1000L;
      paramString1 = h.d("{\"E\":" + Long.valueOf(l + 600L + paramLong) + ",\"S\":" + "\"" + paramString1 + "\"}");
      paramString2 = h.b(n.a(paramString1, paramString2));
      paramString1 = "1:" + paramString2 + ":" + paramString1;
      return paramString1;
    }
    catch (InvalidKeyException paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static Bundle b(String paramString1, String paramString2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("Cookie", "qiniuToken=" + a(paramString1, paramString2, paramLong));
    return localBundle;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */