package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class dh
  extends m
{
  dh(SettingUserNameActivity paramSettingUserNameActivity, Context paramContext, String paramString)
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
    User.getInstance().setUserName(this.a);
    User.getInstance().save();
    h.a(this.b, 2131101180, 1500L, new di(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */