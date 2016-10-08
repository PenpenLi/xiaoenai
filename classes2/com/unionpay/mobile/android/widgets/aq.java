package com.unionpay.mobile.android.widgets;

import android.os.Handler;
import android.os.Message;

final class aq
  extends Thread
{
  aq(ao paramao, int paramInt) {}
  
  public final void run()
  {
    long l1 = System.currentTimeMillis() + this.a * 1000;
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (l2 <= l1)
      {
        int i = (int)((l1 - l2 + this.a) / 1000L);
        if (i > 0)
        {
          Message localMessage = Message.obtain();
          localMessage.what = 0;
          localMessage.arg1 = i;
          ao.b(this.b).sendMessage(localMessage);
          try
          {
            sleep(1000L);
          }
          catch (InterruptedException localInterruptedException)
          {
            ao.b(this.b).sendEmptyMessage(1);
            return;
          }
        }
      }
    }
    ao.b(this.b).sendEmptyMessage(1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\widgets\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */