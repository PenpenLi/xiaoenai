package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.alipay.security.mobile.module.a.a;
import com.alipay.security.mobile.module.c.c;
import java.util.UUID;

public final class b
{
  public static String a(Context paramContext)
  {
    String str2 = c.a(paramContext, "alipay_vkey_random", "random", "");
    String str1 = str2;
    if (a.a(str2))
    {
      str2 = com.alipay.security.mobile.module.a.a.b.a(UUID.randomUUID().toString());
      str1 = str2;
      if (str2 != null)
      {
        paramContext = paramContext.getSharedPreferences("alipay_vkey_random", 0).edit();
        str1 = str2;
        if (paramContext != null)
        {
          paramContext.clear();
          paramContext.putString("random", str2);
          paramContext.commit();
          str1 = str2;
        }
      }
    }
    return str1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */