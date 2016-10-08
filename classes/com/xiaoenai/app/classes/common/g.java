package com.xiaoenai.app.classes.common;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.model.AppSettings;

class g
  implements View.OnClickListener
{
  g(DebugActivity paramDebugActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (!DebugActivity.b(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      DebugActivity.a(paramView, bool);
      AppSettings.setBoolean(AppSettings.getString("setting_environment", this.a.getResources().getStringArray(2131427329)[0]), Boolean.valueOf(DebugActivity.b(this.a)));
      DebugActivity.c(this.a);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */