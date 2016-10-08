package com.xiaoenai.app.utils.d;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class aa
  extends Animation
{
  aa(View paramView, int paramInt) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.a.getLayoutParams();
    if (paramFloat == 1.0F) {}
    for (int i = this.b;; i = (int)(this.b * paramFloat))
    {
      paramTransformation.height = i;
      this.a.invalidate();
      this.a.requestLayout();
      return;
    }
  }
  
  public boolean willChangeBounds()
  {
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\d\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */