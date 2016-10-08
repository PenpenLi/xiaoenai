package com.xiaoenai.app.classes.settings;

import android.content.Context;
import com.xiaoenai.app.classes.settings.feedback.h;
import com.xiaoenai.app.d.f;
import com.xiaoenai.app.net.m;
import java.util.Vector;
import org.json.JSONObject;

class r
  extends m
{
  r(SettingFeedbackActivity paramSettingFeedbackActivity, Context paramContext, h paramh, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.c.a(this.c.getString(2131101072), false);
    super.a();
  }
  
  public void a(int paramInt)
  {
    this.c.l_();
    SettingFeedbackActivity.a(this.c, this.b);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.c.l_();
    this.a.b(Integer.valueOf(1));
    SettingFeedbackActivity.e(this.c).a(this.a);
    SettingFeedbackActivity.a(this.c).add(this.a);
    SettingFeedbackActivity.a(this.c, SettingFeedbackActivity.a(this.c).toArray());
    SettingFeedbackActivity.f(this.c);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */