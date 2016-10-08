package com.xiaoenai.app.classes.home.a;

import android.content.Context;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ak;
import org.json.JSONObject;

class ae
  extends m
{
  ae(z paramz, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    String str1 = User.getInstance().getEmail();
    String str2 = User.getInstance().getPhoneNum();
    if ((str1 != null) && (!str1.equals("")) && (str2 != null) && (!str2.equals("")))
    {
      z.a(this.a, true, true);
      return;
    }
    if (((str1 != null) && (!str1.equals(""))) || ((str2 != null) && (!str2.equals(""))))
    {
      z.a(this.a, true, false);
      return;
    }
    z.a(this.a, false, false);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    boolean bool1 = paramJSONObject.getBoolean("email");
    boolean bool2 = paramJSONObject.getBoolean("phone");
    z.a(this.a, bool1, bool2);
    UserConfig.setLong("key_setting_update_user_info", ak.a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */