package com.xiaoenai.app.net;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.c.a.l;
import org.json.JSONObject;

public class ad
  extends l
{
  public ad(m paramm)
  {
    super(paramm);
  }
  
  public String a(String paramString)
  {
    return Xiaoenai.t + paramString;
  }
  
  public void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("product_id", paramInt);
      a("penguin/v1/product/click", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("scene_id", paramInt1);
      localJSONObject.put("offset", paramInt2);
      localJSONObject.put("limit", paramInt3);
      b("penguin/v1/scene/index", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("scene_id", paramInt);
      localJSONObject.put("last_ts", paramLong);
      b("penguin/v1/scene/newest_count", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void a(JSONObject paramJSONObject) {}
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("special_id", paramInt1);
      localJSONObject.put("offset", paramInt2);
      localJSONObject.put("limit", paramInt3);
      b("penguin/v1/scene/special", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("activity_id", paramInt1);
      localJSONObject.put("offset", paramInt2);
      localJSONObject.put("limit", paramInt3);
      b("penguin/v1/activity/index", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.a(0);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */