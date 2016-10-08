package com.xiaoenai.app.service;

import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.net.socket.SocketManager;
import com.xiaoenai.app.utils.f.a;
import org.cocos2dx.cpp.k;
import org.json.JSONObject;

class e
  extends m
{
  e(MessageService paramMessageService, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    a.c("data = {}", new Object[] { paramJSONObject });
    AppSettings.setInt("client_server_adjust", Integer.valueOf(paramJSONObject.optInt("adjust", 0)));
    AppSettings.setInt("last_adjust_time", Integer.valueOf((int)(System.currentTimeMillis() / 1000L)));
    SocketManager.a().a(paramJSONObject.getInt("adjust"));
    Intent localIntent = new Intent("com.xiaoenai.app.COCOS_ON_PUSH_RECIEVED");
    localIntent.putExtra("Command", "sync_ts");
    localIntent.putExtra("adjust", paramJSONObject.optInt("adjust", 0));
    this.a.sendBroadcast(localIntent, this.a.getString(2131101650));
    if (!User.isSingle())
    {
      k.a("xiaoenai.lovepet.index");
      k.a("xiaoenai.wishtree.index");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */