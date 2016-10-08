package android.support.v7.app;

import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

class r
  implements OnApplyWindowInsetsListener
{
  r(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    int i = paramWindowInsetsCompat.getSystemWindowInsetTop();
    int j = AppCompatDelegateImplV7.c(this.a, i);
    WindowInsetsCompat localWindowInsetsCompat = paramWindowInsetsCompat;
    if (i != j) {
      localWindowInsetsCompat = paramWindowInsetsCompat.replaceSystemWindowInsets(paramWindowInsetsCompat.getSystemWindowInsetLeft(), j, paramWindowInsetsCompat.getSystemWindowInsetRight(), paramWindowInsetsCompat.getSystemWindowInsetBottom());
    }
    return ViewCompat.onApplyWindowInsets(paramView, localWindowInsetsCompat);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */