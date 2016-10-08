package uk.co.senab.photoview;

import android.support.v4.view.MotionEventCompat;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;

class e
  extends GestureDetector.SimpleOnGestureListener
{
  e(d paramd) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((d.b(this.a) == null) || (this.a.g() > 1.0F)) {}
    while ((MotionEventCompat.getPointerCount(paramMotionEvent1) > d.c) || (MotionEventCompat.getPointerCount(paramMotionEvent2) > d.c)) {
      return false;
    }
    return d.b(this.a).a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (d.a(this.a) != null) {
      d.a(this.a).onLongClick(this.a.c());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\uk\co\senab\photoview\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */