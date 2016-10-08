package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

class ae
  extends DefaultItemAnimator.c
{
  ae(DefaultItemAnimator paramDefaultItemAnimator, RecyclerView.ViewHolder paramViewHolder, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationCancel(View paramView)
  {
    ViewCompat.setAlpha(paramView, 1.0F);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.b.setListener(null);
    this.c.dispatchAddFinished(this.a);
    DefaultItemAnimator.access$900(this.c).remove(this.a);
    DefaultItemAnimator.access$800(this.c);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.c.dispatchAddStarting(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */