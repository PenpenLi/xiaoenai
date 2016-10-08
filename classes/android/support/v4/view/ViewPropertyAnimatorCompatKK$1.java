package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class ViewPropertyAnimatorCompatKK$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ViewPropertyAnimatorCompatKK$1(ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.val$listener.onAnimationUpdate(this.val$view);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\view\ViewPropertyAnimatorCompatKK$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */