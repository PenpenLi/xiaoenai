package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.d.f;
import org.json.JSONObject;

class bf
  extends m
{
  bf(SettingPersonalActivity paramSettingPersonalActivity, Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (this.a) {
      this.b.a(null, false);
    }
  }
  
  public void a(int paramInt)
  {
    this.b.l_();
    if (this.a) {
      super.a(paramInt);
    }
  }
  
  public void a(k paramk)
  {
    this.b.l_();
    if (this.a) {
      super.a(paramk);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.b.l_();
    SettingPersonalActivity.a(this.b, paramJSONObject);
    SettingPersonalActivity.o(this.b);
    f.b(paramJSONObject, f.a(Xiaoenai.j(), UserConfig.getUserBindedInfo()));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */