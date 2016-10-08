package com.xiaoenai.app.classes.register;

import android.content.Context;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONException;
import org.json.JSONObject;

class d
  extends m
{
  d(RegisterActivity paramRegisterActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    if (RegisterActivity.f(this.a).isShowing()) {
      RegisterActivity.f(this.a).dismiss();
    }
    RegisterActivity.g(this.a);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (RegisterActivity.f(this.a).isShowing()) {
      RegisterActivity.f(this.a).dismiss();
    }
    try
    {
      new User(paramJSONObject.getJSONObject("user_info")).save();
      User.release();
      RegisterActivity.g(this.a);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\register\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */