package com.xiaoenai.app.widget.wheel;

import android.os.Handler;
import android.os.Message;
import android.widget.Scroller;

class h
  extends Handler
{
  h(f paramf) {}
  
  public void handleMessage(Message paramMessage)
  {
    f.b(this.a).computeScrollOffset();
    int i = f.b(this.a).getCurrY();
    int j = f.a(this.a) - i;
    f.a(this.a, i);
    if (j != 0) {
      f.c(this.a).a(j);
    }
    if (Math.abs(i - f.b(this.a).getFinalY()) < 1)
    {
      f.b(this.a).getFinalY();
      f.b(this.a).forceFinished(true);
    }
    if (!f.b(this.a).isFinished())
    {
      f.d(this.a).sendEmptyMessage(paramMessage.what);
      return;
    }
    if (paramMessage.what == 0)
    {
      f.e(this.a);
      return;
    }
    this.a.b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\wheel\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */