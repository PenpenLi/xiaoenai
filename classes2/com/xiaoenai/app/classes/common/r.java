package com.xiaoenai.app.classes.common;

import android.content.Context;
import android.text.TextUtils;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class r
  extends m
{
  r(q paramq, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    UserConfig.setBoolean("is_getting_invite", Boolean.valueOf(true));
  }
  
  public void a(int paramInt)
  {
    UserConfig.setBoolean("is_getting_invite", Boolean.valueOf(false));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    UserConfig.setBoolean("is_getting_invite", Boolean.valueOf(false));
    UserConfig.setString("home_inviter", paramJSONObject.toString());
    String str4 = paramJSONObject.optString("lover_avatar");
    String str1 = paramJSONObject.optString("lover_nickname");
    String str2 = paramJSONObject.optString("lover_email");
    String str3 = paramJSONObject.optString("lover_phone");
    paramJSONObject = paramJSONObject.optString("lover_username");
    if (!TextUtils.isEmpty(str1)) {
      paramJSONObject = str1;
    }
    for (;;)
    {
      q.a(this.a, paramJSONObject, str4);
      UserConfig.setBoolean("home_has_invite", Boolean.valueOf(false));
      return;
      if (!TextUtils.isEmpty(str3)) {
        paramJSONObject = str3;
      } else if (!TextUtils.isEmpty(str2)) {
        paramJSONObject = str2;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */