package com.ecloud.pulltozoomview;

import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ScrollView;

class h
  implements PullToZoomScrollViewEx.b
{
  h(PullToZoomScrollViewEx paramPullToZoomScrollViewEx) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.a.a()) && (this.a.c()))
    {
      Log.d(PullToZoomScrollViewEx.g(), "onScrollChanged --> getScrollY() = " + ((ScrollView)this.a.a).getScrollY());
      paramInt1 = PullToZoomScrollViewEx.a(this.a);
      paramInt2 = PullToZoomScrollViewEx.b(this.a).getBottom();
      float f = ((ScrollView)this.a.a).getScrollY() + (paramInt1 - paramInt2);
      Log.d(PullToZoomScrollViewEx.g(), "onScrollChanged --> f = " + f);
      if ((f <= 0.0F) || (f >= PullToZoomScrollViewEx.a(this.a))) {
        break label168;
      }
      paramInt1 = (int)(f * 0.65D);
      PullToZoomScrollViewEx.b(this.a).scrollTo(0, -paramInt1);
    }
    label168:
    while (PullToZoomScrollViewEx.b(this.a).getScrollY() == 0) {
      return;
    }
    PullToZoomScrollViewEx.b(this.a).scrollTo(0, 0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ecloud\pulltozoomview\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */