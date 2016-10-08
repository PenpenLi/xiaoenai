package com.xiaoenai.app.classes.home;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.widget.remindButton.b;
import org.json.JSONObject;

class n
  extends m
{
  n(HomeActivity paramHomeActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    HomeActivity.g(this.a);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    b localb;
    if (!this.a.isFinishing())
    {
      UserConfig.setLong("key_red_hints_last_get_time", ak.a());
      localb = new b(HomeActivity.f(this.a));
      if (Build.VERSION.SDK_INT >= 11) {
        localb.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { paramJSONObject });
      }
    }
    else
    {
      return;
    }
    localb.execute(new JSONObject[] { paramJSONObject });
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */