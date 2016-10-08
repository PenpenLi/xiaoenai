package com.xiaoenai.app.classes.extentions.menses;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

final class b
  extends m
{
  b(Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }
  
  public void a(int paramInt)
  {
    a.a("get menses info error", new Object[0]);
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    a.a("get menses info error", new Object[0]);
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
        if (ac.a(l1, i, j, l2, l3, paramJSONObject)) {
          ac.b(true);
        }
        t.b(this.a);
        ac.a(ac.i() * 1000L);
      }
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */