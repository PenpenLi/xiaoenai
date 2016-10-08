package com.xiaoenai.app.classes.chat.input.faces;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.HorizontalScrollView;

class n
  implements Animation.AnimationListener
{
  n(FaceFragmentBottomBar paramFaceFragmentBottomBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FaceFragmentBottomBar.b(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    FaceFragmentBottomBar.c(this.a).rightMargin = 0;
    FaceFragmentBottomBar.d(this.a).setLayoutParams(FaceFragmentBottomBar.c(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */