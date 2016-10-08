package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ab;
import org.json.JSONObject;

class aq
  extends m
{
  aq(SettingNameOrMailActivity paramSettingNameOrMailActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.a(this.a.getString(2131101181), false);
  }
  
  public void a(int paramInt)
  {
    this.a.l_();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.l_();
    ab.b(this.a);
    SettingNameOrMailActivity.a(this.a, User.getInstance().getEmail());
    UserConfig.setLong("last_verify_email_time", System.currentTimeMillis());
    SettingNameOrMailActivity.f(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */