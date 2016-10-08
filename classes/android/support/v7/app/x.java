package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.ActionBarContextView;
import android.view.View;
import android.widget.PopupWindow;

class x
  extends ViewPropertyAnimatorListenerAdapter
{
  x(AppCompatDelegateImplV7.b paramb) {}
  
  public void onAnimationEnd(View paramView)
  {
    this.a.a.n.setVisibility(8);
    if (this.a.a.o != null) {
      this.a.a.o.dismiss();
    }
    for (;;)
    {
      this.a.a.n.removeAllViews();
      this.a.a.q.setListener(null);
      this.a.a.q = null;
      return;
      if ((this.a.a.n.getParent() instanceof View)) {
        ViewCompat.requestApplyInsets((View)this.a.a.n.getParent());
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */