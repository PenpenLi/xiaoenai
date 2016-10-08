package com.xiaoenai.app.h.b;

import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private String a;
  private float b;
  private int c;
  private int d;
  
  public c() {}
  
  public c(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      a(paramJSONObject);
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    try
    {
      a(new JSONObject(paramString));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    b(paramJSONObject.optString("url"));
    a((float)paramJSONObject.optDouble("aspectRatio"));
    a(paramJSONObject.optInt("width"));
    b(paramJSONObject.optInt("height"));
    if ((0.0F == b()) && (c() != 0) && (d() != 0)) {
      a(c() / d());
    }
  }
  
  public float b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(String paramString)
  {
    this.a = paramString;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\h\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */