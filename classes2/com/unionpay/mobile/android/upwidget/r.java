package com.unionpay.mobile.android.upwidget;

import android.os.Handler;
import android.os.Message;
import java.util.List;

final class r
  extends Handler
{
  r(UPRadiationView paramUPRadiationView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      UPRadiationView.a(this.a);
      this.a.invalidate();
    } while ((UPRadiationView.b(this.a) == null) || (UPRadiationView.b(this.a).size() <= 0));
    UPRadiationView.c(this.a).sendEmptyMessageDelayed(0, 50L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\upwidget\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */