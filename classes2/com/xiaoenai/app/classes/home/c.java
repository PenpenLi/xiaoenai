package com.xiaoenai.app.classes.home;

import android.content.Context;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.d.o;
import org.json.JSONObject;

class c
  extends m
{
  c(a parama, Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }
  
  public void a(int paramInt) {}
  
  public void a(k paramk) {}
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    a.a(this.b, a.a(this.b, paramJSONObject));
    if ((ConfigCenter.isShowLauncher()) && (!o.c(this.a))) {
      a.b(this.b, a.a(this.b));
    }
    a.b(this.b, paramJSONObject);
    UserConfig.setInt("ads_req_interval", (int)ak.b());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */