package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.ActionBarContainer;
import android.view.View;

class ag
  extends ViewPropertyAnimatorListenerAdapter
{
  ag(af paramaf) {}
  
  public void onAnimationEnd(View paramView)
  {
    if ((af.a(this.a)) && (af.b(this.a) != null))
    {
      ViewCompat.setTranslationY(af.b(this.a), 0.0F);
      ViewCompat.setTranslationY(af.c(this.a), 0.0F);
    }
    af.c(this.a).setVisibility(8);
    af.c(this.a).setTransitioning(false);
    af.a(this.a, null);
    this.a.i();
    if (af.d(this.a) != null) {
      ViewCompat.requestApplyInsets(af.d(this.a));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */