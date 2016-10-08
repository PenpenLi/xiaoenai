package com.xiaoenai.app.classes.common;

import android.view.View;
import android.widget.TextView;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.widget.wheel.WheelView;
import com.xiaoenai.app.widget.wheel.d;

class j
  implements d
{
  j(DebugActivity paramDebugActivity) {}
  
  public void a(WheelView paramWheelView) {}
  
  public void b(WheelView paramWheelView)
  {
    ((TextView)this.a.findViewById(2131558627)).setText(this.a.getResources().getStringArray(2131427329)[this.a.mEnvWheel.getCurrentItem()]);
    AppSettings.setString("setting_environment", this.a.getResources().getStringArray(2131427329)[this.a.mEnvWheel.getCurrentItem()]);
    this.a.findViewById(2131558629).setVisibility(0);
    DebugActivity.a(this.a, this.a.mEnvWheel.getCurrentItem());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */