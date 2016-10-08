package com.xiaoenai.app.classes.newRegister.phone;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class d
  extends m
{
  d(PhoneRegisterActivity paramPhoneRegisterActivity, Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (!this.b.isFinishing()) {
      this.b.a(null);
    }
    PhoneRegisterActivity.b(this.b, this.a);
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
      if (paramJSONObject.optBoolean("success")) {
        PhoneRegisterActivity.a(this.b);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */