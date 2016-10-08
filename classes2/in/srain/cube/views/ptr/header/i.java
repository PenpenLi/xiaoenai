package in.srain.cube.views.ptr.header;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class i
  implements Animation.AnimationListener
{
  i(d paramd, d.c paramc) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    this.a.j();
    this.a.a();
    this.a.b(this.a.g());
    d.a(this.b, (d.c(this.b) + 1.0F) % 5.0F);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    d.a(this.b, 0.0F);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\header\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */