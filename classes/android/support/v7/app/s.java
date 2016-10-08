package android.support.v7.app;

import android.graphics.Rect;
import android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;

class s
  implements FitWindowsViewGroup.OnFitSystemWindowsListener
{
  s(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7) {}
  
  public void onFitSystemWindows(Rect paramRect)
  {
    paramRect.top = AppCompatDelegateImplV7.c(this.a, paramRect.top);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */