package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

class az
  extends AccessibilityDelegateCompat
{
  az(RecyclerViewAccessibilityDelegate paramRecyclerViewAccessibilityDelegate) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if ((!RecyclerViewAccessibilityDelegate.access$000(this.a)) && (this.a.mRecyclerView.getLayoutManager() != null)) {
      this.a.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
    }
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    if ((!RecyclerViewAccessibilityDelegate.access$000(this.a)) && (this.a.mRecyclerView.getLayoutManager() != null)) {
      return this.a.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(paramView, paramInt, paramBundle);
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */