package com.xiaoenai.app.classes.home;

import android.view.View;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.stat.f;

class u
  extends f
{
  u(HomeBottomBar paramHomeBottomBar, String paramString)
  {
    super(paramString);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    this.a.a(4);
    UserConfig.setBoolean("v_wechat_entered_app", Boolean.valueOf(true));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */