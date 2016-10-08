package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

class ah
  extends DefaultItemAnimator.c
{
  ah(DefaultItemAnimator paramDefaultItemAnimator, DefaultItemAnimator.a parama, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat, View paramView)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.b.setListener(null);
    ViewCompat.setAlpha(this.c, 1.0F);
    ViewCompat.setTranslationX(this.c, 0.0F);
    ViewCompat.setTranslationY(this.c, 0.0F);
    this.d.dispatchChangeFinished(this.a.b, false);
    DefaultItemAnimator.access$1300(this.d).remove(this.a.b);
    DefaultItemAnimator.access$800(this.d);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.d.dispatchChangeStarting(this.a.b, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */