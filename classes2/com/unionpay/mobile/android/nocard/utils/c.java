package com.unionpay.mobile.android.nocard.utils;

import android.content.Context;
import android.text.TextUtils;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.views.order.l;

public final class c
{
  public static int a(Context paramContext, b paramb)
  {
    paramContext = PreferenceUtils.b(paramContext);
    int j = l.b.intValue();
    int i = j;
    if (!TextUtils.isEmpty(paramContext))
    {
      i = j;
      if (TextUtils.isDigitsOnly(paramContext)) {
        i = Integer.valueOf(paramContext).intValue();
      }
    }
    boolean bool2 = "0".equalsIgnoreCase(paramb.ai);
    boolean bool1 = bool2;
    if (paramb.ar)
    {
      bool1 = bool2;
      if ((paramb.aj & 0x11101) == 0) {
        bool1 = true;
      }
    }
    if (bool1) {
      i = l.a.intValue();
    }
    do
    {
      return i;
      if (!TextUtils.isEmpty(paramb.p)) {
        i = l.b.intValue();
      }
    } while (!f.a(paramb.o));
    return l.b.intValue();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\nocard\utils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */