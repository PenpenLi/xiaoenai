package com.xiaoenai.app.widget;

import android.view.animation.Interpolator;

final class n
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */