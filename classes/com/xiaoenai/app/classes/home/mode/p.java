package com.xiaoenai.app.classes.home.mode;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.xiaoenai.app.utils.h.a;

class p
  implements View.OnClickListener
{
  p(ModeWakeActivity paramModeWakeActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.d();
    a.a().d(1);
    this.a.a.removeCallbacks(this.a.b);
    ModeWakeActivity.f(this.a).setEnabled(false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\mode\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */