package com.xiaoenai.app.classes.extentions.menses;

import android.widget.TextView;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.widget.wheel.WheelView;
import com.xiaoenai.app.widget.wheel.d;

class af
  implements d
{
  af(MensesSettingActivity paramMensesSettingActivity) {}
  
  public void a(WheelView paramWheelView) {}
  
  public void b(WheelView paramWheelView)
  {
    MensesSettingActivity.j(this.a).setText(String.format(as.a(2131100833), new Object[] { Integer.valueOf(paramWheelView.getCurrentItem() + 6) }));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */