package com.xiaoenai.app.classes.newRegister.phone;

import android.content.Context;
import android.content.res.Resources;
import com.f.a.b;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.n;
import org.json.JSONObject;

class p
  extends m
{
  p(PhoneRegisterSettingPWActivity paramPhoneRegisterSettingPWActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (!this.a.isFinishing()) {
      this.a.a(this.a.getResources().getString(2131101048), false);
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.a.isFinishing()) {
      this.a.l_();
    }
    b.b(this.a, "RegisterFailure");
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    paramJSONObject = com.xiaoenai.app.utils.b.a.b(paramJSONObject);
    if (paramJSONObject == null) {}
    while (this.a.isFinishing()) {
      return;
    }
    this.a.setResult(-1);
    n.a().a(paramJSONObject, null, this.a, "RegisterSuccess");
    try
    {
      com.xiaoenai.app.utils.f.a.c("avatarPath == {}", new Object[] { PhoneRegisterSettingPWActivity.d(this.a) });
      if (PhoneRegisterSettingPWActivity.d(this.a) != null) {
        PhoneRegisterSettingPWActivity.e(this.a);
      }
      for (;;)
      {
        PhoneRegisterSettingPWActivity.g(this.a).d();
        return;
        if (!this.a.isFinishing())
        {
          this.a.l_();
          PhoneRegisterSettingPWActivity.f(this.a);
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */