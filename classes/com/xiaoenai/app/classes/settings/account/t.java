package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class t
  extends m
{
  t(SettingChangePasswordActivity paramSettingChangePasswordActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    SettingChangePasswordActivity.a(this.a, h.a(this.a));
    if ((SettingChangePasswordActivity.a(this.a) != null) && (!SettingChangePasswordActivity.a(this.a).isShowing())) {
      SettingChangePasswordActivity.a(this.a).show();
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if ((SettingChangePasswordActivity.a(this.a) != null) && (SettingChangePasswordActivity.a(this.a).isShowing())) {
      SettingChangePasswordActivity.a(this.a).dismiss();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((SettingChangePasswordActivity.a(this.a) != null) && (SettingChangePasswordActivity.a(this.a).isShowing())) {
      SettingChangePasswordActivity.a(this.a).dismiss();
    }
    h.a(this.a, 2131099986, 1500L, new u(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */