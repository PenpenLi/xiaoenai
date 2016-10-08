package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SwipeRefreshLayout$1
  implements Animation.AnimationListener
{
  SwipeRefreshLayout$1(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (SwipeRefreshLayout.access$000(this.this$0))
    {
      SwipeRefreshLayout.access$100(this.this$0).setAlpha(255);
      SwipeRefreshLayout.access$100(this.this$0).start();
      if ((SwipeRefreshLayout.access$200(this.this$0)) && (SwipeRefreshLayout.access$300(this.this$0) != null)) {
        SwipeRefreshLayout.access$300(this.this$0).onRefresh();
      }
      SwipeRefreshLayout.access$402(this.this$0, SwipeRefreshLayout.access$500(this.this$0).getTop());
      return;
    }
    SwipeRefreshLayout.access$600(this.this$0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\widget\SwipeRefreshLayout$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */