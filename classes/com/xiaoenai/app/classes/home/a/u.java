package com.xiaoenai.app.classes.home.a;

import android.content.Context;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ak;
import org.json.JSONObject;

class u
  extends m
{
  u(o paramo, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    o.j(this.a);
    UserConfig.setLong("key_notification_ads_last_req_time", ak.a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */