package com.xiaoenai.app.classes.lock;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

class l
  implements Animation.AnimationListener
{
  l(LockSettingOpenActivity paramLockSettingOpenActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (RelativeLayout.LayoutParams)LockSettingOpenActivity.f(this.a).getLayoutParams();
    paramAnimation.bottomMargin = 0;
    LockSettingOpenActivity.f(this.a).setLayoutParams(paramAnimation);
    LockSettingOpenActivity.f(this.a).clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\lock\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */