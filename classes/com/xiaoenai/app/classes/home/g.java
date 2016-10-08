package com.xiaoenai.app.classes.home;

import android.view.View;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;

class g
  implements k.a
{
  g(HomeActivity paramHomeActivity) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    AppSettings.setString("abnormaliy_need_tip", Xiaoenai.j().B + ":0");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */