package com.xiaoenai.app.ui.component.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class c
  extends Animation
{
  c(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = 0;
    if (SwipeRefreshLayout.a(this.a) != SwipeRefreshLayout.b(this.a)) {
      i = SwipeRefreshLayout.a(this.a) + (int)((SwipeRefreshLayout.b(this.a) - SwipeRefreshLayout.a(this.a)) * paramFloat);
    }
    int j = SwipeRefreshLayout.c(this.a).getTop();
    SwipeRefreshLayout.a(this.a, i - j);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\component\view\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */