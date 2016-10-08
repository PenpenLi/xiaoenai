package com.xiaoenai.app.classes.chat.history.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.widget.wheel.WheelView;

class l
  implements View.OnClickListener
{
  l(b paramb, WheelView paramWheelView1, WheelView paramWheelView2, WheelView paramWheelView3) {}
  
  public void onClick(View paramView)
  {
    b.n(this.d).a(b.c(this.d, this.a.getCurrentItem() + b.b()), b.c(this.d, this.b.getCurrentItem()), b.c(this.d, this.c.getCurrentItem() + 1));
    this.d.dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */