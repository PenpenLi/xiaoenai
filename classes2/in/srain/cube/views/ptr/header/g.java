package in.srain.cube.views.ptr.header;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class g
  implements Animation.AnimationListener
{
  g(d paramd, d.c paramc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a();
    this.a.j();
    this.a.a(false);
    d.b(this.b).startAnimation(d.a(this.b));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\header\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */