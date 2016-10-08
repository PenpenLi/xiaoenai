package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.nocard.views.l;
import org.simalliance.openmobileapi.SEService;
import org.simalliance.openmobileapi.SEService.CallBack;

public final class i
  implements SEService.CallBack
{
  private static SEService b = null;
  private Context a;
  private b c;
  private Handler.Callback d = new j(this);
  private Handler e = new Handler(this.d);
  
  public i() {}
  
  public i(Context paramContext, b paramb)
  {
    this.a = paramContext;
    this.c = paramb;
    if (b == null) {
      try
      {
        b = new SEService(this.a, this);
        new k(this).start();
        return;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        h.c("uppay", " service ERROR!!!");
        this.e.sendEmptyMessage(2);
        return;
      }
    }
    ((l)this.c).s();
  }
  
  public static SEService a()
  {
    return b;
  }
  
  public final void serviceConnected(SEService paramSEService)
  {
    h.c("uppay", "se service connected");
    h.c("uppay", "mSEService:" + b);
    h.c("uppay", "mSEService.isConnected:" + b.isConnected());
    this.e.sendEmptyMessage(1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\utils\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */