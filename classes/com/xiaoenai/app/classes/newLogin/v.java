package com.xiaoenai.app.classes.newLogin;

import android.content.Context;
import com.f.a.b;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.b.a;
import org.json.JSONObject;

class v
  extends m
{
  v(LoginActivity paramLoginActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (!this.a.isFinishing()) {
      this.a.a(null);
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.a.isFinishing())
    {
      this.a.l_();
      super.a(paramInt);
      b.b(this.a, "LoginFailure");
    }
  }
  
  public void a(k paramk)
  {
    if (!this.a.isFinishing())
    {
      AppModel.getInstance().setUserId(paramk.c);
      this.a.l_();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (!this.a.isFinishing())
    {
      paramJSONObject = a.b(paramJSONObject);
      if (paramJSONObject == null)
      {
        this.a.l_();
        paramJSONObject = new h(this.a);
        paramJSONObject.a(2131100887);
        paramJSONObject.a(3000L);
      }
    }
    else
    {
      return;
    }
    LoginActivity.a(this.a, paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newLogin\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */