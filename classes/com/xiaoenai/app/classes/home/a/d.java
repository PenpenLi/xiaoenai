package com.xiaoenai.app.classes.home.a;

import android.content.Context;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.widget.remindButton.RemindButton;
import org.json.JSONObject;

class d
  extends m
{
  d(a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt) {}
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("result"))
    {
      if (paramJSONObject.optBoolean("result")) {
        a.a(this.a).a();
      }
    }
    else {
      return;
    }
    a.a(this.a).b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */