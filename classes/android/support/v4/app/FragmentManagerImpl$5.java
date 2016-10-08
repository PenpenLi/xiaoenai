package android.support.v4.app;

import android.view.View;
import android.view.animation.Animation;

class FragmentManagerImpl$5
  extends FragmentManagerImpl.AnimateOnHWLayerIfNeededListener
{
  FragmentManagerImpl$5(FragmentManagerImpl paramFragmentManagerImpl, View paramView, Animation paramAnimation, Fragment paramFragment)
  {
    super(paramView, paramAnimation);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (this.val$fragment.mAnimatingAway != null)
    {
      this.val$fragment.mAnimatingAway = null;
      this.this$0.moveToState(this.val$fragment, this.val$fragment.mStateAfterAnimating, 0, 0, false);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\app\FragmentManagerImpl$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */