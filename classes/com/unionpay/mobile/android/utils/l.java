package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.os.Handler;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.net.c;
import com.unionpay.mobile.android.net.d;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import java.util.HashMap;

public final class l
  extends UPPayEngine
  implements a
{
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public final String a(String paramString)
  {
    h.c("uppay", "post message = " + paramString);
    paramString = e(paramString);
    c().a(paramString);
    paramString = new HashMap(1);
    paramString.put("sid", e());
    c().a(paramString);
    paramString = new c(c());
    int i = paramString.a();
    paramString = paramString.c();
    if (i == 0)
    {
      paramString = f(paramString);
      h.a("uppay", "[ response msg ] " + paramString);
      return paramString;
    }
    paramString = d().obtainMessage(2);
    paramString.arg1 = i;
    d().sendMessage(paramString);
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\unionpay\mobile\android\utils\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */