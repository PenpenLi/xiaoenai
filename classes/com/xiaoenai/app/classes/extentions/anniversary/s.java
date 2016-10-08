package com.xiaoenai.app.classes.extentions.anniversary;

import android.content.Context;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import java.util.Calendar;
import org.json.JSONObject;

class s
  extends m
{
  s(AnniversaryAddActivity paramAnniversaryAddActivity, Context paramContext, Calendar paramCalendar)
  {
    super(paramContext);
  }
  
  public void a()
  {
    AnniversaryAddActivity.a(this.b, h.a(this.b));
    AnniversaryAddActivity.q(this.b).a(2131099950);
    AnniversaryAddActivity.q(this.b).setCancelable(false);
    if (!AnniversaryAddActivity.q(this.b).isShowing()) {
      AnniversaryAddActivity.q(this.b).show();
    }
  }
  
  public void a(int paramInt)
  {
    AnniversaryAddActivity.q(this.b).dismiss();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    AnniversaryAddActivity.s(this.b);
    User.getInstance().setLovedTime(this.a.getTimeInMillis() / 1000L);
    User.getInstance().save();
    AnniversaryAddActivity.i(this.b).a(this.a.getTimeInMillis() / 1000L);
    ai.a().e();
    AnniversaryAddActivity.q(this.b).dismiss();
    this.b.setResult(0);
    this.b.r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */