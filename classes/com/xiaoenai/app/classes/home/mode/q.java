package com.xiaoenai.app.classes.home.mode;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import com.xiaoenai.app.classes.chat.messagelist.message.model.k;
import com.xiaoenai.app.model.HomeModeSettings;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class q
  extends m
{
  q(ModeWakeActivity paramModeWakeActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.a(null, false);
  }
  
  public void a(int paramInt)
  {
    this.a.l_();
    super.a(paramInt);
    ModeWakeActivity.f(this.a).setEnabled(true);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.l_();
    HomeModeSettings.removeMessage("home_mode.msg");
    k.e(ModeWakeActivity.g(this.a)).j();
    paramJSONObject = new Intent("sleep_state_change_action");
    this.a.sendBroadcast(paramJSONObject);
    this.a.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\mode\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */