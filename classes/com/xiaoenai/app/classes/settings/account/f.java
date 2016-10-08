package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class f
  extends m
{
  f(ResetByEmailActivity paramResetByEmailActivity, Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.b.a(null, false);
  }
  
  public void a(int paramInt)
  {
    this.b.l_();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.b.l_();
    ResetByEmailActivity.a(this.b, String.format(this.b.getString(2131100665), new Object[] { this.a }), true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */