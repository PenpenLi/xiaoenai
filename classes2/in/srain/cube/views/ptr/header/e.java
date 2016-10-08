package in.srain.cube.views.ptr.header;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class e
  implements Drawable.Callback
{
  e(d paramd) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.a.invalidateSelf();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    this.a.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.a.unscheduleSelf(paramRunnable);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\header\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */