package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.ActionBarContextView;
import android.view.View;

class v
  extends ViewPropertyAnimatorListenerAdapter
{
  v(u paramu) {}
  
  public void onAnimationEnd(View paramView)
  {
    ViewCompat.setAlpha(this.a.a.n, 1.0F);
    this.a.a.q.setListener(null);
    this.a.a.q = null;
  }
  
  public void onAnimationStart(View paramView)
  {
    this.a.a.n.setVisibility(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */