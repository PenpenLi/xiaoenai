package com.xiaoenai.app.ui.component.view;

import android.view.animation.Animation;

class f
  extends SwipeRefreshLayout.a
{
  f(SwipeRefreshLayout paramSwipeRefreshLayout)
  {
    super(paramSwipeRefreshLayout, null);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    SwipeRefreshLayout.b(this.a, 0);
    SwipeRefreshLayout.a(this.a, SwipeRefreshLayout.b.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\component\view\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */