package uk.co.senab.photoview.a;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class d
  implements ScaleGestureDetector.OnScaleGestureListener
{
  d(c paramc) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if ((Float.isNaN(f)) || (Float.isInfinite(f))) {
      return false;
    }
    this.a.a.a(f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\uk\co\senab\photoview\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */