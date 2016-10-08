package com.xiaoenai.app.classes.chat;

import android.content.Context;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class f
  extends m
{
  f(AddStatusActivity paramAddStatusActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    AddStatusActivity.a(this.a, h.a(this.a));
    if (!AddStatusActivity.d(this.a).isShowing()) {
      AddStatusActivity.d(this.a).show();
    }
  }
  
  public void a(int paramInt)
  {
    AddStatusActivity.d(this.a).dismiss();
    this.a.setResult(-1);
    this.a.finish();
    this.a.overridePendingTransition(2130968606, 2130968607);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    AddStatusActivity.d(this.a).dismiss();
    this.a.setResult(-1);
    this.a.finish();
    this.a.overridePendingTransition(2130968606, 2130968607);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */