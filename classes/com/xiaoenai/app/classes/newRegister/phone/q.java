package com.xiaoenai.app.classes.newRegister.phone;

import android.content.Context;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import org.json.JSONException;
import org.json.JSONObject;

class q
  extends m
{
  q(PhoneRegisterSettingPWActivity paramPhoneRegisterSettingPWActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    if (!this.a.isFinishing())
    {
      this.a.l_();
      PhoneRegisterSettingPWActivity.f(this.a);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (!this.a.isFinishing()) {
      this.a.l_();
    }
    try
    {
      new User(paramJSONObject.getJSONObject("user_info")).save();
      User.release();
      PhoneRegisterSettingPWActivity.f(this.a);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */