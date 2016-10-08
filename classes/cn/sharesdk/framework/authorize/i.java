package cn.sharesdk.framework.authorize;

import android.app.Instrumentation;

class i
  extends Thread
{
  i(h paramh) {}
  
  public void run()
  {
    try
    {
      new Instrumentation().sendKeyDownUpSync(4);
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
      AuthorizeListener localAuthorizeListener = this.a.a.a.getAuthorizeListener();
      if (localAuthorizeListener != null) {
        localAuthorizeListener.onCancel();
      }
      this.a.a.finish();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\authorize\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */