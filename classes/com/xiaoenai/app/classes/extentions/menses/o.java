package com.xiaoenai.app.classes.extentions.menses;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

class o
  extends m
{
  o(MensesActivity paramMensesActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    MensesActivity.j(this.a);
    MensesActivity.k(this.a);
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    MensesActivity.j(this.a);
    MensesActivity.k(this.a);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    a.c("data = {}", new Object[] { paramJSONObject });
    if (paramJSONObject.optBoolean("success", false))
    {
      int i = Integer.parseInt(paramJSONObject.optString("sex", String.valueOf(-1)));
      if (i != ac.l())
      {
        ac.a(i);
        MensesActivity.j(this.a);
      }
    }
    MensesActivity.k(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */