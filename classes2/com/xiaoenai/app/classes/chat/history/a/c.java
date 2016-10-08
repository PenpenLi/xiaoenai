package com.xiaoenai.app.classes.chat.history.a;

import android.os.Handler;
import com.xiaoenai.app.widget.wheel.WheelView;
import java.util.List;

class c
  implements com.xiaoenai.app.widget.wheel.d
{
  c(b paramb, List paramList1, List paramList2, WheelView paramWheelView1, WheelView paramWheelView2) {}
  
  public void a(WheelView paramWheelView) {}
  
  public void b(WheelView paramWheelView)
  {
    b.a(this.e, paramWheelView.getCurrentItem() + b.b());
    b.a(this.e, b.a(this.e), b.b(this.e), this.a, this.b, this.c);
    if (paramWheelView.getCurrentItem() + b.b() > b.c(this.e))
    {
      b.d(this.e).postDelayed(new d(this), 200L);
      b.a(this.e, true);
    }
    while (paramWheelView.getCurrentItem() + b.b() < b.e(this.e))
    {
      b.d(this.e).postDelayed(new e(this), 200L);
      b.b(this.e, true);
      return;
      if (paramWheelView.getCurrentItem() + b.b() == b.c(this.e)) {
        b.a(this.e, true);
      } else {
        b.a(this.e, false);
      }
    }
    if (paramWheelView.getCurrentItem() + b.b() == b.e(this.e))
    {
      b.b(this.e, true);
      return;
    }
    b.b(this.e, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */