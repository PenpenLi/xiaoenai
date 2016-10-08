package com.inmobi.rendering;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

class RenderView$5
  implements InMobiAdActivity.b
{
  RenderView$5(RenderView paramRenderView) {}
  
  public void a()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "onAdScreenDisplayed");
    if (RenderingProperties.PlacementType.INLINE == RenderView.b(this.a).a())
    {
      if (RenderView.c(this.a) == null) {
        break label86;
      }
      RenderView.c(this.a).setAndUpdateViewState(RenderView.RenderViewState.EXPANDED);
    }
    for (;;)
    {
      RenderView.a(this.a, false);
      if (RenderView.d(this.a) != null) {
        RenderView.d(this.a).e(this.a);
      }
      return;
      label86:
      this.a.setAndUpdateViewState(RenderView.RenderViewState.EXPANDED);
    }
  }
  
  public void b()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, RenderView.p(), "onAdScreenDismissed");
    if (RenderingProperties.PlacementType.INLINE == RenderView.b(this.a).a())
    {
      this.a.setAndUpdateViewState(RenderView.RenderViewState.DEFAULT);
      if (RenderView.c(this.a) != null) {
        RenderView.c(this.a).setAndUpdateViewState(RenderView.RenderViewState.DEFAULT);
      }
    }
    for (;;)
    {
      if (RenderView.d(this.a) != null) {
        RenderView.d(this.a).f(this.a);
      }
      return;
      if (RenderView.RenderViewState.DEFAULT == RenderView.e(this.a)) {
        this.a.setAndUpdateViewState(RenderView.RenderViewState.HIDDEN);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\RenderView$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */