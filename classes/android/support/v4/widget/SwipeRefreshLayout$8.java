package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$8
  extends Animation
{
  SwipeRefreshLayout$8(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = SwipeRefreshLayout.access$1400(this.this$0);
    float f2 = -SwipeRefreshLayout.access$1400(this.this$0);
    SwipeRefreshLayout.access$700(this.this$0, f1 + f2 * paramFloat);
    SwipeRefreshLayout.access$1300(this.this$0, paramFloat);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\widget\SwipeRefreshLayout$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */