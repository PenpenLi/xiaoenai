package com.xiaoenai.app.classes.street;

import android.content.Context;
import com.xiaoenai.app.classes.settings.feedback.FeedbackPhoto;
import com.xiaoenai.app.d.f;
import com.xiaoenai.app.net.m;
import java.util.Vector;
import org.json.JSONObject;

class bu
  extends m
{
  bu(StreetFeedbackActivity paramStreetFeedbackActivity, Context paramContext, FeedbackPhoto paramFeedbackPhoto)
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
    StreetFeedbackActivity.a(this.b, null);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.b.l_();
    this.a.b(Integer.valueOf(1));
    StreetFeedbackActivity.d(this.b).a(this.a, StreetFeedbackActivity.c(this.b));
    StreetFeedbackActivity.a(this.b).add(this.a);
    StreetFeedbackActivity.a(this.b, StreetFeedbackActivity.a(this.b).toArray());
    StreetFeedbackActivity.e(this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */