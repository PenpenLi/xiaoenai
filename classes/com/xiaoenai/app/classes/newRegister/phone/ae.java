package com.xiaoenai.app.classes.newRegister.phone;

import android.content.Context;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class ae
  extends m
{
  ae(PhoneRegisterVerifyActivity paramPhoneRegisterVerifyActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (!this.a.isFinishing()) {
      this.a.a(null);
    }
    super.a();
  }
  
  public void a(int paramInt)
  {
    if (!this.a.isFinishing()) {
      this.a.l_();
    }
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (!this.a.isFinishing())
    {
      this.a.l_();
      if (paramJSONObject.optBoolean("success"))
      {
        PhoneRegisterVerifyActivity.e(this.a);
        h.a(this.a, 2131100966, 1500L);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */