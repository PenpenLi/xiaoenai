package com.marshalchen.ultimaterecyclerview;

import android.view.MotionEvent;
import android.view.ViewGroup;

class q
  implements Runnable
{
  q(UltimateRecyclerView paramUltimateRecyclerView, ViewGroup paramViewGroup, MotionEvent paramMotionEvent) {}
  
  public void run()
  {
    this.a.dispatchTouchEvent(this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */