package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class cp
  extends m
{
  h a = h.a(this.c);
  
  cp(SettingPhoneInputActivity paramSettingPhoneInputActivity, Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.show();
    super.a();
  }
  
  public void a(int paramInt)
  {
    if ((!this.c.isFinishing()) && (this.a != null)) {
      this.a.dismiss();
    }
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    if ((!this.c.isFinishing()) && (this.a != null)) {
      this.a.dismiss();
    }
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if ((!this.c.isFinishing()) && (this.a != null)) {
      this.a.dismiss();
    }
    if (paramJSONObject.optBoolean("success"))
    {
      SettingPhoneInputActivity.a(this.c, this.b);
      UserConfig.setString("phone_code_num", SettingPhoneInputActivity.e(this.c));
      SettingPhoneInputActivity.g(this.c);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */