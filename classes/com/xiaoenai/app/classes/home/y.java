package com.xiaoenai.app.classes.home;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class y
  extends m
{
  y(v paramv, Context paramContext, h paramh)
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
    h.c(b(), 2131101257, 1500L);
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    this.a.dismiss();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.dismiss();
    v.b(this.b, paramJSONObject);
    v.g(this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */