package com.xiaoenai.app.classes.home;

import android.content.Context;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ak;
import org.json.JSONObject;

class j
  extends m
{
  j(HomeActivity paramHomeActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(JSONObject paramJSONObject)
  {
    UserConfig.setLong("key_notify_last_get_time", ak.a());
    HomeActivity.a(this.a, HomeActivity.c(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */