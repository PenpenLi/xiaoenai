package com.xiaoenai.app.classes.extentions.menses;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class an
  extends m
{
  an(MensesSettingActivity paramMensesSettingActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    MensesSettingActivity.o(this.a).dismiss();
    h.c(this.a, 2131100859, 1500L);
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    MensesSettingActivity.p(this.a).dismiss();
    h.c(this.a, 2131100859, 1500L);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    MensesSettingActivity.l(this.a).dismiss();
    long l1 = paramJSONObject.optLong("last_menstruation_ts");
    int i = paramJSONObject.optInt("cycle_day");
    int j = paramJSONObject.optInt("internal_day");
    long l2 = paramJSONObject.optLong("leave_ts");
    long l3 = paramJSONObject.optLong("noti_ts");
    paramJSONObject = paramJSONObject.getString("mens_help");
    MensesSettingActivity.a(this.a, this.a.getApplicationContext(), l1, j, i, l3, l2, paramJSONObject);
    MensesSettingActivity.n(this.a).post(MensesSettingActivity.m(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */