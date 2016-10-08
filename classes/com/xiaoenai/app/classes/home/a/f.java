package com.xiaoenai.app.classes.home.a;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class f
  extends m
{
  f(a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt) {}
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    l locall = new l(new g(this));
    if (Build.VERSION.SDK_INT >= 11)
    {
      locall.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { paramJSONObject });
      return;
    }
    locall.execute(new JSONObject[] { paramJSONObject });
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */