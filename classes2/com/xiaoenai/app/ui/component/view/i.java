package com.xiaoenai.app.ui.component.view;

import android.view.animation.Animation;

class i
  implements Runnable
{
  i(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void run()
  {
    SwipeRefreshLayout.a(this.a, true);
    if ((SwipeRefreshLayout.e(this.a) != null) || (SwipeRefreshLayout.f(this.a) != null))
    {
      SwipeRefreshLayout.b(this.a, SwipeRefreshLayout.i(this.a));
      if ((SwipeRefreshLayout.j(this.a) <= 0) || ((SwipeRefreshLayout.k(this.a) != SwipeRefreshLayout.b.b) && (SwipeRefreshLayout.k(this.a) != SwipeRefreshLayout.b.d))) {
        break label195;
      }
      SwipeRefreshLayout.m(this.a).setDuration(SwipeRefreshLayout.l(this.a));
      SwipeRefreshLayout.m(this.a).setAnimationListener(SwipeRefreshLayout.n(this.a));
      SwipeRefreshLayout.m(this.a).reset();
      SwipeRefreshLayout.m(this.a).setInterpolator(SwipeRefreshLayout.o(this.a));
      this.a.startAnimation(SwipeRefreshLayout.m(this.a));
    }
    for (;;)
    {
      SwipeRefreshLayout.c(this.a, 0);
      SwipeRefreshLayout.a(this.a, SwipeRefreshLayout.g(this.a) + this.a.getPaddingTop(), SwipeRefreshLayout.h(this.a));
      return;
      label195:
      if ((SwipeRefreshLayout.j(this.a) < 0) && ((SwipeRefreshLayout.k(this.a) == SwipeRefreshLayout.b.c) || (SwipeRefreshLayout.k(this.a) == SwipeRefreshLayout.b.d)))
      {
        SwipeRefreshLayout.p(this.a).setDuration(SwipeRefreshLayout.l(this.a));
        SwipeRefreshLayout.p(this.a).setAnimationListener(SwipeRefreshLayout.n(this.a));
        SwipeRefreshLayout.p(this.a).reset();
        SwipeRefreshLayout.p(this.a).setInterpolator(SwipeRefreshLayout.o(this.a));
        this.a.startAnimation(SwipeRefreshLayout.p(this.a));
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\component\view\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */