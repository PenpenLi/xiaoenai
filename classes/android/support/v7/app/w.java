package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.ActionBarContextView;
import android.view.View;

class w
  extends ViewPropertyAnimatorListenerAdapter
{
  w(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7) {}
  
  public void onAnimationEnd(View paramView)
  {
    ViewCompat.setAlpha(this.a.n, 1.0F);
    this.a.q.setListener(null);
    this.a.q = null;
  }
  
  public void onAnimationStart(View paramView)
  {
    this.a.n.setVisibility(0);
    this.a.n.sendAccessibilityEvent(32);
    if (this.a.n.getParent() != null) {
      ViewCompat.requestApplyInsets((View)this.a.n.getParent());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */