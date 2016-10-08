package com.xiaoenai.app.classes.street.pay.a;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.json.JSONException;
import org.json.JSONObject;

class h
  extends m
{
  h(g paramg, Context paramContext, f paramf)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    this.a.a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      this.a.a(false, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    this.a.a(false, null);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a.a(paramJSONObject.optBoolean("success", false), paramJSONObject);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\pay\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */