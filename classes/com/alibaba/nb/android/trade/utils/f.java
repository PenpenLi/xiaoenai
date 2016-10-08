package com.alibaba.nb.android.trade.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.nb.android.trade.utils.d.a;

final class f
  extends Handler
{
  f(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    try
    {
      super.handleMessage(paramMessage);
      return;
    }
    catch (Throwable paramMessage)
    {
      a.b("AliTradeExecutorServiceUtil", paramMessage.getMessage());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */