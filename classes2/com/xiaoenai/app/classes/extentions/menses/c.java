package com.xiaoenai.app.classes.extentions.menses;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

final class c
  extends m
{
  c(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt) {}
  
  public void a(k paramk) {}
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    a.c("data = {}", new Object[] { paramJSONObject });
    if (paramJSONObject.optBoolean("success", false))
    {
      paramJSONObject = paramJSONObject.optString("sex");
      if (ae.a(paramJSONObject)) {
        ac.a(-1);
      }
    }
    else
    {
      return;
    }
    ac.a(Integer.parseInt(paramJSONObject));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */