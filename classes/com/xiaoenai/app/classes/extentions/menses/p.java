package com.xiaoenai.app.classes.extentions.menses;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class p
  extends m
{
  p(MensesActivity paramMensesActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    MensesActivity.a(this.a, ac.n());
    MensesActivity.l(this.a);
  }
  
  public void a(k paramk)
  {
    MensesActivity.a(this.a, ac.n());
    MensesActivity.l(this.a);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    long l1 = paramJSONObject.optLong("last_menstruation_ts");
    int i = paramJSONObject.optInt("internal_day");
    if (paramJSONObject.optInt("is_open") == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.a(bool);
      int j = paramJSONObject.optInt("cycle_day");
      long l2 = paramJSONObject.optLong("noti_ts");
      long l3 = paramJSONObject.optLong("leave_ts");
      paramJSONObject = paramJSONObject.optString("mens_help");
      if (l1 > 0L)
      {
        ac.a(l1, i, j, l2, l3, paramJSONObject);
        ac.a(ac.i() * 1000L);
        t.b(this.a);
      }
      MensesActivity.a(this.a, ac.n());
      MensesActivity.l(this.a);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */