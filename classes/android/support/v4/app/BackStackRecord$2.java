package android.support.v4.app;

import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;

class BackStackRecord$2
  implements ViewTreeObserver.OnPreDrawListener
{
  BackStackRecord$2(BackStackRecord paramBackStackRecord, View paramView, Object paramObject, ArrayList paramArrayList, BackStackRecord.TransitionState paramTransitionState, boolean paramBoolean, Fragment paramFragment1, Fragment paramFragment2) {}
  
  public boolean onPreDraw()
  {
    this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.val$sharedElementTransition != null)
    {
      FragmentTransitionCompat21.removeTargets(this.val$sharedElementTransition, this.val$sharedElementTargets);
      this.val$sharedElementTargets.clear();
      ArrayMap localArrayMap = BackStackRecord.access$000(this.this$0, this.val$state, this.val$isBack, this.val$inFragment);
      FragmentTransitionCompat21.setSharedElementTargets(this.val$sharedElementTransition, this.val$state.nonExistentView, localArrayMap, this.val$sharedElementTargets);
      BackStackRecord.access$100(this.this$0, localArrayMap, this.val$state);
      BackStackRecord.access$200(this.this$0, this.val$state, this.val$inFragment, this.val$outFragment, this.val$isBack, localArrayMap);
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v4\app\BackStackRecord$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */