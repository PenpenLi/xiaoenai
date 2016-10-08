package com.xiaoenai.app.classes.home;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import org.json.JSONObject;

class l
  extends com.xiaoenai.app.net.m
{
  l(HomeActivity paramHomeActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    HomeActivity.e(this.a);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    com.xiaoenai.app.classes.home.a.l locall = new com.xiaoenai.app.classes.home.a.l(new m(this));
    if (Build.VERSION.SDK_INT >= 11)
    {
      locall.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { paramJSONObject });
      return;
    }
    locall.execute(new JSONObject[] { paramJSONObject });
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */