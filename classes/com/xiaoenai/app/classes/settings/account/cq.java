package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.d.f;
import org.json.JSONObject;

class cq
  extends m
{
  cq(SettingPhoneInputActivity paramSettingPhoneInputActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.a(null, false);
  }
  
  public void a(int paramInt)
  {
    this.a.l_();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.l_();
    User.getInstance().setPhoneNum("");
    User.getInstance().save();
    f.b(paramJSONObject, f.a(Xiaoenai.j(), UserConfig.getUserBindedInfo()));
    if (!paramJSONObject.optBoolean("phone"))
    {
      SettingPhoneInputActivity.b(this.a, 16);
      return;
    }
    SettingPhoneInputActivity.b(this.a, 9);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */