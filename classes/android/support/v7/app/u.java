package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.widget.PopupWindow;

class u
  implements Runnable
{
  u(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7) {}
  
  public void run()
  {
    this.a.o.showAtLocation(this.a.n, 55, 0, 0);
    AppCompatDelegateImplV7.c(this.a);
    ViewCompat.setAlpha(this.a.n, 0.0F);
    this.a.q = ViewCompat.animate(this.a.n).alpha(1.0F);
    this.a.q.setListener(new v(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */