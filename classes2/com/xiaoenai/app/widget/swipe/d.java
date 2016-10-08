package com.xiaoenai.app.widget.swipe;

import android.view.animation.Interpolator;

final class d
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\swipe\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */