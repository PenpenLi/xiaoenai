package android.support.v7.widget.helper;

import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.List;

class c
  extends ItemTouchHelper.b
{
  c(ItemTouchHelper paramItemTouchHelper, RecyclerView.ViewHolder paramViewHolder1, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt3, RecyclerView.ViewHolder paramViewHolder2)
  {
    super(paramItemTouchHelper, paramViewHolder1, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat)
  {
    super.onAnimationEnd(paramValueAnimatorCompat);
    if (this.m) {}
    for (;;)
    {
      return;
      if (this.a <= 0) {
        this.c.mCallback.clearView(ItemTouchHelper.access$300(this.c), this.b);
      }
      while (ItemTouchHelper.access$1600(this.c) == this.b.itemView)
      {
        ItemTouchHelper.access$1700(this.c, this.b.itemView);
        return;
        this.c.mPendingCleanup.add(this.b.itemView);
        this.j = true;
        if (this.a > 0) {
          ItemTouchHelper.access$1500(this.c, this, this.a);
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\helper\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */