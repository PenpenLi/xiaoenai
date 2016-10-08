package com.xiaoenai.app.classes.home.a;

import android.content.Context;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ak;
import org.json.JSONObject;

class c
  extends m
{
  c(a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a.a();
    UserConfig.setLong("key_discover_ads_last_req_time", ak.a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */