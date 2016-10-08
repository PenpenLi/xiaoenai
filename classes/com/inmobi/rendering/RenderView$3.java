package com.inmobi.rendering;

import android.os.Build.VERSION;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.concurrent.atomic.AtomicBoolean;

class RenderView$3
  implements Runnable
{
  RenderView$3(RenderView paramRenderView, String paramString) {}
  
  public void run()
  {
    String str;
    if (!RenderView.a(this.b).get())
    {
      str = "javascript:try{" + this.a + "}catch(e){}";
      Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "Injecting javascript:" + str);
      if (Build.VERSION.SDK_INT < 19) {
        RenderView.a(this.b, str);
      }
    }
    else
    {
      return;
    }
    RenderView.b(this.b, str);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\RenderView$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */