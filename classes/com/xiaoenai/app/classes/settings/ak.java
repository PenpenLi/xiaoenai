package com.xiaoenai.app.classes.settings;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class ak
  extends m
{
  ak(SettingReleaseActivity paramSettingReleaseActivity, Context paramContext, boolean paramBoolean)
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
    SettingReleaseActivity.a(this.b, paramJSONObject);
    if (SettingReleaseActivity.b(this.b))
    {
      this.b.c();
      return;
    }
    SettingReleaseActivity.c(this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */