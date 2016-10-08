package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import cn.sharesdk.framework.Platform;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.c.a.j;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.d.f;
import org.json.JSONObject;

class bq
  extends m
{
  bq(SettingPersonalActivity paramSettingPersonalActivity, Context paramContext, Platform paramPlatform)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.b.a(null);
  }
  
  public void a(int paramInt)
  {
    this.b.l_();
    if (paramInt == 10055)
    {
      this.a.removeAccount();
      SettingPersonalActivity.a(this.b, j.a(paramInt), 0);
      return;
    }
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.b.l_();
    f.b(paramJSONObject, f.a(Xiaoenai.j(), UserConfig.getUserBindedInfo()));
    SettingPersonalActivity.a(this.b, paramJSONObject);
    if (!this.b.isFinishing())
    {
      h.a(this.b, 2131101172, 1500L);
      SettingPersonalActivity.o(this.b);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */