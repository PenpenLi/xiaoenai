package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.d.f;
import org.json.JSONObject;

class ct
  extends m
{
  h a = h.a(this.c);
  
  ct(SettingPhoneInputActivity paramSettingPhoneInputActivity, Context paramContext, String paramString)
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
    this.a.dismiss();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a.dismiss();
    f.b(paramJSONObject, f.a(Xiaoenai.j(), "bind_info"));
    User.getInstance().setPhoneNum(this.b);
    User.getInstance().save();
    SettingPhoneInputActivity.b(this.c, 9);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */