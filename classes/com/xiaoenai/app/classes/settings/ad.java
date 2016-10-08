package com.xiaoenai.app.classes.settings;

import android.content.Context;
import com.xiaoenai.app.classes.settings.feedback.FeedbackPhoto;
import com.xiaoenai.app.d.f;
import com.xiaoenai.app.net.m;
import java.util.Vector;
import org.json.JSONObject;

class ad
  extends m
{
  ad(SettingFeedbackActivity paramSettingFeedbackActivity, Context paramContext, FeedbackPhoto paramFeedbackPhoto)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.b.a(this.b.getString(2131101072), false);
  }
  
  public void a(int paramInt)
  {
    this.b.l_();
    super.a(paramInt);
    SettingFeedbackActivity.a(this.b, null);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.b.l_();
    this.a.b(Integer.valueOf(1));
    SettingFeedbackActivity.e(this.b).a(this.a);
    SettingFeedbackActivity.a(this.b).add(this.a);
    SettingFeedbackActivity.a(this.b, SettingFeedbackActivity.a(this.b).toArray());
    SettingFeedbackActivity.f(this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */