package com.xiaoenai.app.ui.xrecyclerview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class c
  implements ValueAnimator.AnimatorUpdateListener
{
  c(ArrowRefreshHeader paramArrowRefreshHeader) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setVisibleHeight(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\xrecyclerview\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */