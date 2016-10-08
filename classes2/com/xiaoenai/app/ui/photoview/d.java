package com.xiaoenai.app.ui.photoview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;

class d
  extends GestureDetector.SimpleOnGestureListener
{
  d(c paramc) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (c.a(this.a) != null) {
      c.a(this.a).onLongClick(this.a.c());
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\photoview\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */