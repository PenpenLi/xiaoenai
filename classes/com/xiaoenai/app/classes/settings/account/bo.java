package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.c.a.j;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.d.f;
import org.json.JSONObject;

class bo
  extends m
{
  bo(SettingPersonalActivity paramSettingPersonalActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.a(null);
  }
  
  public void a(int paramInt)
  {
    this.a.l_();
    if (paramInt == 10055)
    {
      SettingPersonalActivity.a(this.a, j.a(paramInt), 0);
      return;
    }
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a.l_();
    f.b(paramJSONObject, f.a(Xiaoenai.j(), UserConfig.getUserBindedInfo()));
    SettingPersonalActivity.a(this.a, paramJSONObject);
    if (!this.a.isFinishing())
    {
      h.a(this.a, 2131101172, 1500L);
      SettingPersonalActivity.o(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */