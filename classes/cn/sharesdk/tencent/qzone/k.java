package cn.sharesdk.tencent.qzone;

import android.app.Instrumentation;
import cn.sharesdk.framework.PlatformActionListener;

class k
  extends Thread
{
  k(j paramj) {}
  
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
      this.a.a.finish();
      i.a(this.a.a).onCancel(null, 0);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\tencent\qzone\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */