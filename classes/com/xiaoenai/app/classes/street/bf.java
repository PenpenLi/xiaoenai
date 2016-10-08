package com.xiaoenai.app.classes.street;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONArray;
import org.json.JSONObject;

class bf
  extends m
{
  bf(StreetCustomerServiceActivity paramStreetCustomerServiceActivity, Context paramContext)
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
  
  public void a(k paramk)
  {
    this.a.l_();
    super.a(paramk);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.l_();
    super.a(paramJSONObject);
    if (paramJSONObject.optBoolean("success"))
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("data");
      StreetCustomerServiceActivity.a(this.a, localJSONArray);
      StreetCustomerServiceActivity.a(this.a, paramJSONObject);
      return;
    }
    h.c(b(), paramJSONObject.optString("error"), 15000L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */