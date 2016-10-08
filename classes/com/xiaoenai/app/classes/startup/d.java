package com.xiaoenai.app.classes.startup;

import android.content.Context;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.net.socket.SocketManager;
import org.json.JSONObject;

class d
  extends m
{
  d(LauncherActivity paramLauncherActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt) {}
  
  public void a(JSONObject paramJSONObject)
  {
    AppSettings.setInt("client_server_adjust", Integer.valueOf(paramJSONObject.getInt("adjust")));
    AppSettings.setInt("last_adjust_time", Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
    SocketManager.a().a(paramJSONObject.getInt("adjust"));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\startup\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */