package com.alipay.apmobilesecuritysdk.c;

final class c
  implements Runnable
{
  c(b paramb) {}
  
  public final void run()
  {
    try
    {
      b.a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.alipay.security.mobile.module.a.c.a(localThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */