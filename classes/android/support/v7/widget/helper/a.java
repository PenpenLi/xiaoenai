package android.support.v7.widget.helper;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;

class a
  implements Runnable
{
  a(ItemTouchHelper paramItemTouchHelper) {}
  
  public void run()
  {
    if ((this.a.mSelected != null) && (ItemTouchHelper.access$000(this.a)))
    {
      if (this.a.mSelected != null) {
        ItemTouchHelper.access$100(this.a, this.a.mSelected);
      }
      ItemTouchHelper.access$300(this.a).removeCallbacks(ItemTouchHelper.access$200(this.a));
      ViewCompat.postOnAnimation(ItemTouchHelper.access$300(this.a), this);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\helper\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */