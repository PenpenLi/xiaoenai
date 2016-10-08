package com.xiaoenai.app.classes.newLogin;

import android.content.Context;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONException;
import org.json.JSONObject;

class p
  extends m
{
  p(LoginActivity paramLoginActivity, Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    if (!this.b.isFinishing())
    {
      this.b.l_();
      LoginActivity.j(this.b);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (!this.b.isFinishing())
    {
      this.b.l_();
      a.a(paramJSONObject.toString(), new Object[0]);
    }
    try
    {
      new User(paramJSONObject.getJSONObject("user_info")).save();
      User.release();
      b.b(User.getInstance().getAvatar(), this.a);
      LoginActivity.j(this.b);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newLogin\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */