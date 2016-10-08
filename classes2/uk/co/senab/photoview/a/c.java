package uk.co.senab.photoview.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

@TargetApi(8)
public class c
  extends b
{
  protected final ScaleGestureDetector f = new ScaleGestureDetector(paramContext, new d(this));
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean a()
  {
    return this.f.isInProgress();
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    try
    {
      this.f.onTouchEvent(paramMotionEvent);
      boolean bool = super.c(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent) {}
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\uk\co\senab\photoview\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */