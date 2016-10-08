package android.support.v7.widget.helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;

class d
  implements Runnable
{
  d(ItemTouchHelper paramItemTouchHelper, ItemTouchHelper.b paramb, int paramInt) {}
  
  public void run()
  {
    if ((ItemTouchHelper.access$300(this.c) != null) && (ItemTouchHelper.access$300(this.c).isAttachedToWindow()) && (!this.a.m) && (this.a.h.getAdapterPosition() != -1))
    {
      RecyclerView.ItemAnimator localItemAnimator = ItemTouchHelper.access$300(this.c).getItemAnimator();
      if (((localItemAnimator == null) || (!localItemAnimator.isRunning(null))) && (!ItemTouchHelper.access$1800(this.c))) {
        this.c.mCallback.onSwiped(this.a.h, this.b);
      }
    }
    else
    {
      return;
    }
    ItemTouchHelper.access$300(this.c).post(this);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\helper\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */