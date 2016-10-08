package com.xiaoenai.app.model;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.d.o;
import org.json.JSONObject;

final class a
  extends m
{
  a(Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }
  
  public void a(int paramInt) {}
  
  public void a(k paramk) {}
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    ConfigCenter.access$000(paramJSONObject);
    if ((ConfigCenter.isShowLauncher()) && (!o.c(this.a))) {
      com.xiaoenai.app.classes.home.a.a().a(this.a);
    }
    if (ConfigCenter.isShowHomeBanner()) {
      com.xiaoenai.app.classes.home.a.a().a(this.a, "index", new b(this, this.a));
    }
    UserConfig.setLong("key_config_last_req_time", ak.a());
    UserConfig.setString("street_topic_page_title", paramJSONObject.optString("street_topic_page_title", ""));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */