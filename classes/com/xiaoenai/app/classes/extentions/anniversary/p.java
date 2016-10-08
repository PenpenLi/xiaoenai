package com.xiaoenai.app.classes.extentions.anniversary;

import android.content.Context;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import java.util.ArrayList;
import org.json.JSONObject;

class p
  extends m
{
  p(AnniversaryAddActivity paramAnniversaryAddActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    AnniversaryAddActivity.a(this.a, h.a(this.a));
    AnniversaryAddActivity.q(this.a).a(2131099950);
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
    int i = paramJSONObject.getInt("id");
    AnniversaryAddActivity.i(this.a).a(Integer.valueOf(i));
    AnniversaryAddActivity.i(this.a).b(AnniversaryAddActivity.r(this.a));
    AnniversaryAddActivity.i(this.a).a(AnniversaryAddActivity.m(this.a));
    AnniversaryAddActivity.i(this.a).a(AnniversaryAddActivity.j(this.a));
    paramJSONObject = AnniversaryAddActivity.i(this.a);
    if (AnniversaryAddActivity.k(this.a) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramJSONObject.a(bool);
      ai.a().b().add(AnniversaryAddActivity.i(this.a));
      ai.a().e();
      ad.c(this.a);
      this.a.setResult(0);
      this.a.r();
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */