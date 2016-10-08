package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bw
  implements Animation.AnimationListener
{
  bw(SwitchCompat paramSwitchCompat, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (SwitchCompat.access$100(this.b) == paramAnimation)
    {
      paramAnimation = this.b;
      if (!this.a) {
        break label40;
      }
    }
    label40:
    for (float f = 1.0F;; f = 0.0F)
    {
      SwitchCompat.access$200(paramAnimation, f);
      SwitchCompat.access$102(this.b, null);
      return;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */