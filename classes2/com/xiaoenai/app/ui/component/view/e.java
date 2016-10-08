package com.xiaoenai.app.ui.component.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class e
  extends Animation
{
  e(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = SwipeRefreshLayout.d(this.a);
    float f2 = SwipeRefreshLayout.d(this.a);
    SwipeRefreshLayout.f(this.a).a(f1 + (0.0F - f2) * paramFloat);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\component\view\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */