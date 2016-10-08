package com.xiaoenai.app.classes.chat.input.faces;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.HorizontalScrollView;
import com.xiaoenai.app.utils.ab;

class m
  implements Animation.AnimationListener
{
  m(FaceFragmentBottomBar paramFaceFragmentBottomBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FaceFragmentBottomBar.b(this.a).setVisibility(0);
    FaceFragmentBottomBar.c(this.a).rightMargin = ab.a(68.0F);
    FaceFragmentBottomBar.d(this.a).setLayoutParams(FaceFragmentBottomBar.c(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    FaceFragmentBottomBar.b(this.a).setVisibility(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */