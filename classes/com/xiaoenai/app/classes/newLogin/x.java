package com.xiaoenai.app.classes.newLogin;

import android.content.Context;
import android.widget.Button;
import com.f.a.b;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.n;
import org.json.JSONObject;

class x
  extends m
{
  x(LoginActivity paramLoginActivity, Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    if (!this.b.isFinishing())
    {
      this.b.l_();
      this.b.mLoginBtn.setEnabled(true);
      if (paramInt != 10006) {
        break label79;
      }
      LoginActivity.e(this.b);
      if (LoginActivity.f(this.b) < 3) {
        break label71;
      }
      LoginActivity.g(this.b);
    }
    for (;;)
    {
      b.b(this.b, "LoginFailure");
      return;
      label71:
      super.a(paramInt);
      continue;
      label79:
      super.a(paramInt);
    }
  }
  
  public void a(k paramk)
  {
    if (!this.b.isFinishing())
    {
      AppModel.getInstance().setUserId(paramk.c);
      this.b.l_();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (!this.b.isFinishing())
    {
      paramJSONObject = com.xiaoenai.app.utils.b.a.b(paramJSONObject);
      if (paramJSONObject == null) {
        this.b.l_();
      }
    }
    else
    {
      return;
    }
    n.a().a(paramJSONObject, this.a, this.b, "LoginSuccess");
    this.b.l_();
    if (UserConfig.getString("cur_version", "").equals("v5.6.0")) {
      LoginActivity.b(this.b);
    }
    for (;;)
    {
      LoginActivity.d(this.b).d();
      return;
      LoginActivity.c(this.b);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newLogin\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */