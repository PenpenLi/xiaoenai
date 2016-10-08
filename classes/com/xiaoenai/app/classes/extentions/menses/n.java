package com.xiaoenai.app.classes.extentions.menses;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class n
  extends m
{
  n(MensesActivity paramMensesActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    MensesActivity.h(this.a).dismiss();
    h.c(this.a, 2131100868, 1500L);
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    MensesActivity.i(this.a).dismiss();
    h.c(this.a, 2131100868, 1500L);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    long l = paramJSONObject.getLong("last_menstruation_ts");
    int i = paramJSONObject.optInt("cycle_day");
    if (paramJSONObject.optInt("is_open") == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.a(bool);
      ac.a(l, paramJSONObject.optInt("internal_day"), i, paramJSONObject.optLong("noti_ts"), paramJSONObject.optLong("leave_ts"), paramJSONObject.optString("mens_help"));
      MensesActivity.g(this.a).dismiss();
      h.a(this.a, 2131100869, 1500L);
      MensesActivity.c(this.a, MensesActivity.a(this.a));
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */