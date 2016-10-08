package com.xiaoenai.app.classes.extentions.anniversary;

import android.content.Context;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import java.util.ArrayList;
import org.json.JSONObject;

class n
  extends m
{
  n(AnniversaryAddActivity paramAnniversaryAddActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    AnniversaryAddActivity.a(this.a, h.a(this.a));
    AnniversaryAddActivity.q(this.a).a(2131099926);
    AnniversaryAddActivity.q(this.a).setCancelable(false);
    if (!AnniversaryAddActivity.q(this.a).isShowing()) {
      AnniversaryAddActivity.q(this.a).show();
    }
  }
  
  public void a(int paramInt)
  {
    AnniversaryAddActivity.q(this.a).dismiss();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    AnniversaryAddActivity.q(this.a).dismiss();
    ai.a().b().remove(AnniversaryAddActivity.f(this.a));
    ai.a().e();
    this.a.setResult(0);
    this.a.r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */