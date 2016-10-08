package com.xiaoenai.app.model;

import android.content.Context;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ak;
import org.json.JSONObject;

class b
  extends m
{
  b(a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if ((this.a.a != null) && ((this.a.a instanceof HomeActivity)))
    {
      paramJSONObject = (HomeActivity)this.a.a;
      if (paramJSONObject != null) {
        paramJSONObject.f();
      }
    }
    UserConfig.setLong("key_home_ads_last_req_time", ak.a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */