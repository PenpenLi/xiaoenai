package android.support.v7.app;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.ActionBarContainer;
import android.view.View;

class ah
  extends ViewPropertyAnimatorListenerAdapter
{
  ah(af paramaf) {}
  
  public void onAnimationEnd(View paramView)
  {
    af.a(this.a, null);
    af.c(this.a).requestLayout();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */