package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

class af
  extends DefaultItemAnimator.c
{
  af(DefaultItemAnimator paramDefaultItemAnimator, RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationCancel(View paramView)
  {
    if (this.b != 0) {
      ViewCompat.setTranslationX(paramView, 0.0F);
    }
    if (this.c != 0) {
      ViewCompat.setTranslationY(paramView, 0.0F);
    }
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.d.setListener(null);
    this.e.dispatchMoveFinished(this.a);
    DefaultItemAnimator.access$1100(this.e).remove(this.a);
    DefaultItemAnimator.access$800(this.e);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.e.dispatchMoveStarting(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */