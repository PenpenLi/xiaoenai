package com.xiaoenai.app.classes.chat.history.a;

import android.os.Handler;
import com.xiaoenai.app.widget.wheel.WheelView;
import com.xiaoenai.app.widget.wheel.d;
import java.util.List;

class f
  implements d
{
  f(b paramb, List paramList1, List paramList2, WheelView paramWheelView1, WheelView paramWheelView2, WheelView paramWheelView3) {}
  
  public void a(WheelView paramWheelView) {}
  
  public void b(WheelView paramWheelView)
  {
    b.b(this.f, paramWheelView.getCurrentItem());
    b.a(this.f, b.a(this.f), b.b(this.f), this.a, this.b, this.c);
    if (this.d.getCurrentItem() + b.b() == b.c(this.f)) {
      b.a(this.f, true);
    }
    if (b.f(this.f)) {
      if (paramWheelView.getCurrentItem() + 1 > b.g(this.f))
      {
        b.d(this.f).postDelayed(new g(this), 200L);
        b.c(this.f, true);
      }
    }
    while (b.h(this.f)) {
      if (paramWheelView.getCurrentItem() + 1 < b.i(this.f))
      {
        b.d(this.f).postDelayed(new h(this), 200L);
        b.d(this.f, true);
        return;
        if (paramWheelView.getCurrentItem() + 1 == b.g(this.f))
        {
          b.c(this.f, true);
        }
        else
        {
          b.c(this.f, false);
          continue;
          b.c(this.f, false);
        }
      }
      else
      {
        if (paramWheelView.getCurrentItem() + 1 == b.i(this.f))
        {
          b.d(this.f, true);
          return;
        }
        b.d(this.f, false);
        return;
      }
    }
    b.d(this.f, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */