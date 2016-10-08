package com.xiaoenai.app.classes.common.dialog;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class n
  implements Animation.AnimationListener
{
  n(k paramk) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      k.b(this.a);
      return;
    }
    catch (Exception paramAnimation)
    {
      paramAnimation.printStackTrace();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */