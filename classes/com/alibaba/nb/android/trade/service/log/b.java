package com.alibaba.nb.android.trade.service.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.alibaba.nb.android.trade.AliTradeContext;

final class b
  extends Handler
{
  b(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return;
        paramMessage = (c)paramMessage.obj;
        a.a(this.a, paramMessage.h);
        if (AliTradeContext.isDebugable()) {
          Log.v("TLog.AliTradeLogCache", "The deal message length is : " + paramMessage.h + "  and the messageQueue size is : " + a.a(this.a));
        }
        paramMessage = a.a(this.a, paramMessage);
      } while (paramMessage == null);
      a locala = this.a;
      a.a(paramMessage);
      return;
    }
    paramMessage = this.a;
    a.d();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\service\log\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */