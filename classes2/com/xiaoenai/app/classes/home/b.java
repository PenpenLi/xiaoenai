package com.xiaoenai.app.classes.home;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class b
  extends m
{
  b(a parama, Context paramContext, String paramString, m paramm)
  {
    super(paramContext);
  }
  
  public void a(int paramInt) {}
  
  public void a(k paramk) {}
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.c.a(paramJSONObject, this.a);
    if (this.b != null) {
      this.b.a(paramJSONObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */