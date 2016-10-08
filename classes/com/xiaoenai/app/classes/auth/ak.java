package com.xiaoenai.app.classes.auth;

import android.content.Context;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

class ak
  extends m
{
  ak(XeaAuthActivity paramXeaAuthActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.a(null, false);
  }
  
  public void a(int paramInt)
  {
    this.a.l_();
    if ((paramInt >= 10000) && (paramInt <= 10003))
    {
      XeaAuthActivity.e(this.a);
      return;
    }
    XeaAuthActivity.a(this.a, paramInt, null);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.l_();
    a.c("data={}", new Object[] { paramJSONObject.toString() });
    XeaAuthActivity.a(this.a, 0, paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\auth\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */