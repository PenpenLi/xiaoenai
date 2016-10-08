package android.support.v7.widget.helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;

class e
  implements RecyclerView.ChildDrawingOrderCallback
{
  e(ItemTouchHelper paramItemTouchHelper) {}
  
  public int onGetChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (ItemTouchHelper.access$1600(this.a) == null) {}
    int i;
    do
    {
      return paramInt2;
      int j = ItemTouchHelper.access$2300(this.a);
      i = j;
      if (j == -1)
      {
        i = ItemTouchHelper.access$300(this.a).indexOfChild(ItemTouchHelper.access$1600(this.a));
        ItemTouchHelper.access$2302(this.a, i);
      }
      if (paramInt2 == paramInt1 - 1) {
        return i;
      }
    } while (paramInt2 < i);
    return paramInt2 + 1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\helper\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */