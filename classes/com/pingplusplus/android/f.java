package com.pingplusplus.android;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class f
  extends Handler
{
  WeakReference a;
  
  f(PaymentActivity paramPaymentActivity)
  {
    this.a = new WeakReference(paramPaymentActivity);
  }
  
  private int a(String paramString)
  {
    return Integer.parseInt(a(paramString.replace("{", "").replace("}", ""), "resultStatus=", ";memo"));
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString2) + paramString2.length();
    if (paramString3 != null) {
      return paramString1.substring(i, paramString1.indexOf(paramString3));
    }
    return paramString1.substring(i);
  }
  
  public void handleMessage(Message paramMessage)
  {
    PaymentActivity localPaymentActivity = (PaymentActivity)this.a.get();
    switch (paramMessage.what)
    {
    default: 
      PaymentActivity.a(localPaymentActivity, "fail", "testmode_notify_failed");
      return;
    case 1: 
      paramMessage = (String)paramMessage.obj;
      int i;
      try
      {
        i = a(paramMessage);
        if (i == 9000)
        {
          PaymentActivity.a(localPaymentActivity, "success");
          return;
        }
      }
      catch (Exception localException)
      {
        PaymentActivity.a(localPaymentActivity, "fail", "channel_returns_fail", paramMessage);
        return;
      }
      if (i == 6001)
      {
        PaymentActivity.a(localPaymentActivity, "cancel", "user_cancelled");
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("resultStatus");
      localArrayList.add(String.valueOf(i));
      PaymentActivity.a(localPaymentActivity, "fail", "channel_returns_fail", TextUtils.join("=", localArrayList));
      return;
    }
    PaymentActivity.a(localPaymentActivity, "success");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\pingplusplus\android\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */