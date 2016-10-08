package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

class ag
  extends DefaultItemAnimator.c
{
  ag(DefaultItemAnimator paramDefaultItemAnimator, DefaultItemAnimator.a parama, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.b.setListener(null);
    ViewCompat.setAlpha(paramView, 1.0F);
    ViewCompat.setTranslationX(paramView, 0.0F);
    ViewCompat.setTranslationY(paramView, 0.0F);
    this.c.dispatchChangeFinished(this.a.a, true);
    DefaultItemAnimator.access$1300(this.c).remove(this.a.a);
    DefaultItemAnimator.access$800(this.c);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.c.dispatchChangeStarting(this.a.a, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */