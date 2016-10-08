package com.alipay.sdk.widget;

import android.app.ProgressDialog;

final class c
  implements Runnable
{
  c(a parama) {}
  
  public final void run()
  {
    try
    {
      if ((this.a.b != null) && (this.a.a())) {
        this.a.b.dismiss();
      }
      this.a.b = null;
      return;
    }
    catch (Exception localException)
    {
      localException = localException;
      this.a.b = null;
      return;
    }
    finally
    {
      localObject = finally;
      this.a.b = null;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\widget\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */