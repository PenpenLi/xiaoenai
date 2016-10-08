package com.xiaoenai.app.classes.street;

import android.content.Context;
import com.xiaoenai.app.classes.settings.feedback.h;
import com.xiaoenai.app.d.f;
import com.xiaoenai.app.net.m;
import java.util.Vector;
import org.json.JSONObject;

class bk
  extends m
{
  bk(StreetFeedbackActivity paramStreetFeedbackActivity, Context paramContext, h paramh, String paramString)
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
    StreetFeedbackActivity.a(this.c, this.b);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.c.l_();
    this.a.b(Integer.valueOf(1));
    StreetFeedbackActivity.d(this.c).a(this.a, StreetFeedbackActivity.c(this.c));
    StreetFeedbackActivity.a(this.c).add(this.a);
    StreetFeedbackActivity.a(this.c, StreetFeedbackActivity.a(this.c).toArray());
    StreetFeedbackActivity.e(this.c);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */