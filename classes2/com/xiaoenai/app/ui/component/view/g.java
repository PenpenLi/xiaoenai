package com.xiaoenai.app.ui.component.view;

import android.view.animation.Animation;

class g
  extends SwipeRefreshLayout.a
{
  g(SwipeRefreshLayout paramSwipeRefreshLayout)
  {
    super(paramSwipeRefreshLayout, null);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    SwipeRefreshLayout.a(this.a, 0.0F);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\component\view\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */