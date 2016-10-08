package com.xiaoenai.app.classes.newRegister.phone;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class af
  extends m
{
  af(PhoneRegisterVerifyActivity paramPhoneRegisterVerifyActivity, Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (!this.b.isFinishing()) {
      this.b.a(null);
    }
    super.a();
  }
  
  public void a(int paramInt)
  {
    if (!this.b.isFinishing()) {
      this.b.l_();
    }
    super.a(paramInt);
  }
  
  public void a(k paramk)
  {
    if (!this.b.isFinishing()) {
      this.b.l_();
    }
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (!this.b.isFinishing())
    {
      this.b.l_();
      if (paramJSONObject.optBoolean("success"))
      {
        PhoneRegisterVerifyActivity.a(this.b, this.a);
        if (PhoneRegisterVerifyActivity.f(this.b) != 1) {
          break label62;
        }
        PhoneRegisterVerifyActivity.g(this.b);
      }
    }
    label62:
    while ((PhoneRegisterVerifyActivity.f(this.b) != 2) && (PhoneRegisterVerifyActivity.f(this.b) != 3)) {
      return;
    }
    PhoneRegisterVerifyActivity.h(this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */