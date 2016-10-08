package com.pingplusplus.android;

import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.app.PayTask;

class a
  extends Thread
{
  a(PaymentActivity paramPaymentActivity, String paramString) {}
  
  public void run()
  {
    String str = new PayTask(this.b).pay(this.a);
    PingppLog.d("PaymentActivity alipay result: " + str);
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = str;
    PaymentActivity.a(this.b).sendMessage(localMessage);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\pingplusplus\android\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */