package com.xiaoenai.app.classes.register;

import android.content.Context;
import com.f.a.b;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.n;
import org.json.JSONObject;

class e
  extends m
{
  e(RegisterActivity paramRegisterActivity, Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (RegisterActivity.f(this.b) == null) {
      RegisterActivity.a(this.b, h.a(this.b));
    }
    if (!RegisterActivity.f(this.b).isShowing())
    {
      RegisterActivity.f(this.b).a(2131101048);
      RegisterActivity.f(this.b).show();
    }
    RegisterActivity.f(this.b).setCancelable(false);
  }
  
  public void a(int paramInt)
  {
    if (RegisterActivity.f(this.b).isShowing()) {
      RegisterActivity.f(this.b).dismiss();
    }
    b.b(this.b, "RegisterFailure");
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    paramJSONObject = com.xiaoenai.app.utils.b.a.b(paramJSONObject);
    if (paramJSONObject == null) {}
    while (this.b.isFinishing()) {
      return;
    }
    this.b.setResult(-1);
    n.a().a(paramJSONObject, this.a, this.b, "RegisterSuccess");
    if (RegisterActivity.h(this.b) != null) {
      RegisterActivity.i(this.b);
    }
    for (;;)
    {
      this.b.b.d();
      return;
      if (RegisterActivity.f(this.b).isShowing()) {
        RegisterActivity.f(this.b).dismiss();
      }
      RegisterActivity.g(this.b);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\register\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */