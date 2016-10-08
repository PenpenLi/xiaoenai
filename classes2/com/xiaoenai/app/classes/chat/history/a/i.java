package com.xiaoenai.app.classes.chat.history.a;

import android.os.Handler;
import com.xiaoenai.app.widget.wheel.WheelView;
import com.xiaoenai.app.widget.wheel.d;

class i
  implements d
{
  i(b paramb, WheelView paramWheelView) {}
  
  public void a(WheelView paramWheelView) {}
  
  public void b(WheelView paramWheelView)
  {
    if ((b.j(this.b)) && (paramWheelView.getCurrentItem() + 1 > b.k(this.b))) {
      b.d(this.b).postDelayed(new j(this), 200L);
    }
    if ((b.l(this.b)) && (paramWheelView.getCurrentItem() + 1 < b.m(this.b))) {
      b.d(this.b).postDelayed(new k(this), 200L);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */