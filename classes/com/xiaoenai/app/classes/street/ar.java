package com.xiaoenai.app.classes.street;

import android.content.Context;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class ar
  extends m
{
  ar(StreetCommentsAvtivity paramStreetCommentsAvtivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.a(null);
    super.a();
  }
  
  public void a(int paramInt)
  {
    this.a.l_();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.l_();
    if (paramJSONObject.optBoolean("success"))
    {
      StreetCommentsAvtivity.d(this.a);
      return;
    }
    super.a(paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */