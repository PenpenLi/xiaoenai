package com.xiaoenai.app.utils.d;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class ab
  extends Animation
{
  ab(View paramView, int paramInt) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (paramFloat == 1.0F)
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.getLayoutParams().height = (this.b - (int)(this.b * paramFloat));
    this.a.requestLayout();
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\d\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */