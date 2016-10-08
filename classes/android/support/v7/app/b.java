package android.support.v7.app;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

class b
  implements View.OnClickListener
{
  b(a parama) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == a.a(this.a)) && (a.b(this.a) != null)) {
      paramView = Message.obtain(a.b(this.a));
    }
    for (;;)
    {
      if (paramView != null) {
        paramView.sendToTarget();
      }
      a.h(this.a).obtainMessage(1, a.g(this.a)).sendToTarget();
      return;
      if ((paramView == a.c(this.a)) && (a.d(this.a) != null)) {
        paramView = Message.obtain(a.d(this.a));
      } else if ((paramView == a.e(this.a)) && (a.f(this.a) != null)) {
        paramView = Message.obtain(a.f(this.a));
      } else {
        paramView = null;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\android\support\v7\app\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */