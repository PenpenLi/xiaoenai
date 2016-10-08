package com.xiaoenai.app.stat;

import android.content.Context;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class e
  extends m
{
  e(c paramc, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    UserConfig.setLong("last_upload_stat_time", System.currentTimeMillis());
    c.a(this.a, false);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    UserConfig.setLong("last_upload_stat_time", System.currentTimeMillis());
    c.a(this.a, false);
    g.c();
    g.d();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\stat\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */