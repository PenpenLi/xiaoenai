package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$4
  extends Animation
{
  SwipeRefreshLayout$4(SwipeRefreshLayout paramSwipeRefreshLayout, int paramInt1, int paramInt2) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    SwipeRefreshLayout.access$100(this.this$0).setAlpha((int)(this.val$startingAlpha + (this.val$endingAlpha - this.val$startingAlpha) * paramFloat));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\widget\SwipeRefreshLayout$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */