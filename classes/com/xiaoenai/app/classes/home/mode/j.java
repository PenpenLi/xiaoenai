package com.xiaoenai.app.classes.home.mode;

import android.content.Context;
import com.xiaoenai.app.classes.chat.messagelist.message.model.k;
import com.xiaoenai.app.model.HomeModeSettings;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.h.a;
import org.json.JSONObject;

class j
  extends m
{
  j(ModeSleepActivity paramModeSleepActivity, Context paramContext)
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
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (!this.a.isFinishing())
    {
      this.a.l_();
      a.a().d(1);
      k.e(ModeSleepActivity.a(this.a)).j();
      HomeModeSettings.removeMessage("home_mode.msg");
      this.a.b("sleep_state_change_action");
      ModeSleepActivity.g(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\mode\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */