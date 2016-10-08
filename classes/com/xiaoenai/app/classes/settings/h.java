package com.xiaoenai.app.classes.settings;

import android.content.Context;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class h
  extends m
{
  h(AboutActivity paramAboutActivity, Context paramContext, com.xiaoenai.app.ui.a.h paramh)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.show();
  }
  
  public void a(int paramInt)
  {
    this.a.dismiss();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.dismiss();
    AboutActivity.a(this.b, paramJSONObject);
    AboutActivity.b(this.b, AboutActivity.a(this.b));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */