package com.xiaoenai.app.classes.forum.presenter;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class v
  extends m
{
  h a = h.a(o.d(this.b));
  
  v(o paramo, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    this.a.show();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.a.hide();
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    this.a.hide();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    o.g(this.b).a(o.e(this.b), o.f(this.b));
    this.a.hide();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */