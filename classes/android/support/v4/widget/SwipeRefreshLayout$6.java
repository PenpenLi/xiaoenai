package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$6
  extends Animation
{
  SwipeRefreshLayout$6(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (!SwipeRefreshLayout.access$1000(this.this$0)) {}
    for (int i = (int)(SwipeRefreshLayout.access$1100(this.this$0) - Math.abs(this.this$0.mOriginalOffsetTop));; i = (int)SwipeRefreshLayout.access$1100(this.this$0))
    {
      int j = this.this$0.mFrom;
      i = (int)((i - this.this$0.mFrom) * paramFloat);
      int k = SwipeRefreshLayout.access$500(this.this$0).getTop();
      SwipeRefreshLayout.access$1200(this.this$0, i + j - k, false);
      SwipeRefreshLayout.access$100(this.this$0).setArrowScale(1.0F - paramFloat);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\widget\SwipeRefreshLayout$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */