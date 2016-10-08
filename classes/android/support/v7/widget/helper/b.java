package android.support.v7.widget.helper;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.List;

class b
  implements RecyclerView.OnItemTouchListener
{
  b(ItemTouchHelper paramItemTouchHelper) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    ItemTouchHelper.access$400(this.a).onTouchEvent(paramMotionEvent);
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 0)
    {
      this.a.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      this.a.mInitialTouchX = paramMotionEvent.getX();
      this.a.mInitialTouchY = paramMotionEvent.getY();
      ItemTouchHelper.access$500(this.a);
      if (this.a.mSelected == null)
      {
        paramRecyclerView = ItemTouchHelper.access$600(this.a, paramMotionEvent);
        if (paramRecyclerView != null)
        {
          ItemTouchHelper localItemTouchHelper = this.a;
          localItemTouchHelper.mInitialTouchX -= paramRecyclerView.k;
          localItemTouchHelper = this.a;
          localItemTouchHelper.mInitialTouchY -= paramRecyclerView.l;
          ItemTouchHelper.access$700(this.a, paramRecyclerView.h, true);
          if (this.a.mPendingCleanup.remove(paramRecyclerView.h.itemView)) {
            this.a.mCallback.clearView(ItemTouchHelper.access$300(this.a), paramRecyclerView.h);
          }
          ItemTouchHelper.access$800(this.a, paramRecyclerView.h, paramRecyclerView.i);
          ItemTouchHelper.access$900(this.a, paramMotionEvent, this.a.mSelectedFlags, 0);
        }
      }
    }
    for (;;)
    {
      if (ItemTouchHelper.access$1100(this.a) != null) {
        ItemTouchHelper.access$1100(this.a).addMovement(paramMotionEvent);
      }
      if (this.a.mSelected == null) {
        break;
      }
      return true;
      if ((i == 3) || (i == 1))
      {
        this.a.mActivePointerId = -1;
        ItemTouchHelper.access$800(this.a, null, 0);
      }
      else if (this.a.mActivePointerId != -1)
      {
        int j = MotionEventCompat.findPointerIndex(paramMotionEvent, this.a.mActivePointerId);
        if (j >= 0) {
          ItemTouchHelper.access$1000(this.a, i, paramMotionEvent, j);
        }
      }
    }
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    ItemTouchHelper.access$800(this.a, null, 0);
  }
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = 0;
    ItemTouchHelper.access$400(this.a).onTouchEvent(paramMotionEvent);
    if (ItemTouchHelper.access$1100(this.a) != null) {
      ItemTouchHelper.access$1100(this.a).addMovement(paramMotionEvent);
    }
    if (this.a.mActivePointerId == -1) {}
    int j;
    do
    {
      int k;
      do
      {
        return;
        j = MotionEventCompat.getActionMasked(paramMotionEvent);
        k = MotionEventCompat.findPointerIndex(paramMotionEvent, this.a.mActivePointerId);
        if (k >= 0) {
          ItemTouchHelper.access$1000(this.a, j, paramMotionEvent, k);
        }
        paramRecyclerView = this.a.mSelected;
      } while (paramRecyclerView == null);
      switch (j)
      {
      case 4: 
      case 5: 
      default: 
        return;
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          ItemTouchHelper.access$800(this.a, null, 0);
          this.a.mActivePointerId = -1;
          return;
          if (k < 0) {
            break;
          }
          ItemTouchHelper.access$900(this.a, paramMotionEvent, this.a.mSelectedFlags, k);
          ItemTouchHelper.access$100(this.a, paramRecyclerView);
          ItemTouchHelper.access$300(this.a).removeCallbacks(ItemTouchHelper.access$200(this.a));
          ItemTouchHelper.access$200(this.a).run();
          ItemTouchHelper.access$300(this.a).invalidate();
          return;
          if (ItemTouchHelper.access$1100(this.a) != null) {
            ItemTouchHelper.access$1100(this.a).clear();
          }
        }
      }
      j = MotionEventCompat.getActionIndex(paramMotionEvent);
    } while (MotionEventCompat.getPointerId(paramMotionEvent, j) != this.a.mActivePointerId);
    if (j == 0) {
      i = 1;
    }
    this.a.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
    ItemTouchHelper.access$900(this.a, paramMotionEvent, this.a.mSelectedFlags, j);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\widget\helper\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */