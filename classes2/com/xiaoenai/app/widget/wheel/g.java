package com.xiaoenai.app.widget.wheel;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class g
  extends GestureDetector.SimpleOnGestureListener
{
  g(f paramf) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    f.a(this.a, 0);
    f.b(this.a).fling(0, f.a(this.a), 0, (int)-paramFloat2, 0, 0, -2147483647, Integer.MAX_VALUE);
    f.b(this.a, 0);
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\wheel\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */