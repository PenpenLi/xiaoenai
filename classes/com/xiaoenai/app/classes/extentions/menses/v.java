package com.xiaoenai.app.classes.extentions.menses;

import android.content.Context;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

class v
  extends m
{
  v(MensesEditSexActivity paramMensesEditSexActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (!this.a.isFinishing())
    {
      a.c("data = {}", new Object[] { paramJSONObject });
      MensesEditSexActivity.a(this.a, Integer.parseInt(paramJSONObject.optString("sex", String.valueOf(-1))));
      if (MensesEditSexActivity.a(this.a) != ac.l()) {
        h.a(this.a, 2131100834, 700L);
      }
      ac.a(MensesEditSexActivity.a(this.a));
      MensesEditSexActivity.b(this.a, MensesEditSexActivity.a(this.a));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */