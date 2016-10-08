package com.ecloud.pulltozoomview;

import android.view.animation.Interpolator;

final class c
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return paramFloat * (paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ecloud\pulltozoomview\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */