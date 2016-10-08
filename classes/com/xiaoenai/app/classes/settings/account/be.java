package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.e.b;
import org.json.JSONException;
import org.json.JSONObject;

class be
  extends m
{
  be(SettingPersonalActivity paramSettingPersonalActivity, Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.b.a(this.b.getString(2131101154), false);
  }
  
  public void a(int paramInt)
  {
    this.b.l_();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      this.b.l_();
      if (!this.b.isFinishing()) {
        h.a(this.b, 2131101153, 1500L);
      }
      str = "file://" + this.a;
    }
    catch (Exception localException)
    {
      try
      {
        String str;
        new User(paramJSONObject.getJSONObject("user_info")).save();
        User.release();
        if (!this.b.isFinishing()) {
          b.a(SettingPersonalActivity.n(this.b), str);
        }
        b.b(User.getInstance().getAvatar(), this.a);
        return;
        localException = localException;
        localException.printStackTrace();
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
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */