package uk.co.senab.photoview;

import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.widget.ImageView;

public class b
  implements GestureDetector.OnDoubleTapListener
{
  private d a;
  
  public b(d paramd)
  {
    a(paramd);
  }
  
  public void a(d paramd)
  {
    this.a = paramd;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a == null) {
      return false;
    }
    try
    {
      float f1 = this.a.g();
      float f2 = paramMotionEvent.getX();
      float f3 = paramMotionEvent.getY();
      if (f1 < this.a.e())
      {
        this.a.a(this.a.e(), f2, f3, true);
        return true;
      }
      if ((f1 >= this.a.e()) && (f1 < this.a.f()))
      {
        this.a.a(this.a.f(), f2, f3, true);
        return true;
      }
      this.a.a(this.a.d(), f2, f3, true);
      return true;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent) {}
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.a == null) {}
    ImageView localImageView;
    do
    {
      return false;
      localImageView = this.a.c();
      if (this.a.i() != null)
      {
        RectF localRectF = this.a.b();
        if (localRectF != null)
        {
          float f2 = paramMotionEvent.getX();
          float f1 = paramMotionEvent.getY();
          if (localRectF.contains(f2, f1))
          {
            f2 = (f2 - localRectF.left) / localRectF.width();
            f1 = (f1 - localRectF.top) / localRectF.height();
            this.a.i().a(localImageView, f2, f1);
            return true;
          }
          this.a.i().a();
        }
      }
    } while (this.a.j() == null);
    this.a.j().a(localImageView, paramMotionEvent.getX(), paramMotionEvent.getY());
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\uk\co\senab\photoview\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */