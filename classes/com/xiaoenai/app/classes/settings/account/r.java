package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class r
  extends m
{
  h a = h.a(this.c);
  
  r(ResetPasswordByPhoneNumActivity paramResetPasswordByPhoneNumActivity, Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.show();
    ResetPasswordByPhoneNumActivity.c(this.c, this.b);
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
    if (paramJSONObject.optBoolean("success")) {
      ResetPasswordByPhoneNumActivity.d(this.c);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */