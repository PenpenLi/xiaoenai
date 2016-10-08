package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class ao
  extends m
{
  ao(SettingNameOrMailActivity paramSettingNameOrMailActivity, Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.b.a(this.b.getString(2131101181), false);
  }
  
  public void a(int paramInt)
  {
    this.b.l_();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.b.l_();
    if (SettingNameOrMailActivity.l(this.b) == 0)
    {
      User.getInstance().setNickName(this.a);
      User.getInstance().save();
      h.a(this.b, 2131101180, 1500L, new ap(this));
    }
    while (SettingNameOrMailActivity.l(this.b) != 1) {
      return;
    }
    SettingNameOrMailActivity.a(this.b, false);
    UserConfig.setLong("last_verify_email_time", System.currentTimeMillis());
    User.getInstance().setEmail(this.a);
    User.getInstance().save();
    SettingNameOrMailActivity.a(this.b, this.a);
    SettingNameOrMailActivity.j(this.b);
    SettingNameOrMailActivity.f(this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */