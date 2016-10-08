package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import java.util.ArrayList;

class ad
  extends DefaultItemAnimator.c
{
  ad(DefaultItemAnimator paramDefaultItemAnimator, RecyclerView.ViewHolder paramViewHolder, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat)
  {
    super(null);
  }
  
  public void onAnimationEnd(View paramView)
  {
    this.b.setListener(null);
    ViewCompat.setAlpha(paramView, 1.0F);
    this.c.dispatchRemoveFinished(this.a);
    DefaultItemAnimator.access$700(this.c).remove(this.a);
    DefaultItemAnimator.access$800(this.c);
  }
  
  public void onAnimationStart(View paramView)
  {
    this.c.dispatchRemoveStarting(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */