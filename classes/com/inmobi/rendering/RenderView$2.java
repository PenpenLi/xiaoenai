package com.inmobi.rendering;

import java.util.concurrent.atomic.AtomicBoolean;

class RenderView$2
  implements Runnable
{
  RenderView$2(RenderView paramRenderView, String paramString) {}
  
  public void run()
  {
    if (!RenderView.a(this.b).get()) {
      this.b.loadDataWithBaseURL("", this.a, "text/html", "UTF-8", null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\RenderView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */