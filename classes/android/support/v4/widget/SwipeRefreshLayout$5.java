package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SwipeRefreshLayout$5
  implements Animation.AnimationListener
{
  SwipeRefreshLayout$5(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!SwipeRefreshLayout.access$800(this.this$0)) {
      SwipeRefreshLayout.access$900(this.this$0, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\widget\SwipeRefreshLayout$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */