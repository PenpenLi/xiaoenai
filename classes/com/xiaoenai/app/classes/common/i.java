package com.xiaoenai.app.classes.common;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.widget.wheel.WheelView;

class i
  implements View.OnClickListener
{
  i(DebugActivity paramDebugActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mEnvWheel.getVisibility() == 8)
    {
      this.a.mEnvWheel.setVisibility(0);
      return;
    }
    this.a.mEnvWheel.setVisibility(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */