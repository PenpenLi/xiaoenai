package com.inmobi.commons.core.c;

import com.inmobi.commons.core.configs.a;
import org.json.JSONObject;

class c
  extends a
{
  private b a = new b();
  private String b = "https://sdkm.w.inmobi.com/metrics/e.asm?v=1&";
  private int c = 300;
  private int d = 60;
  private int e = 50;
  private int f = 3;
  private int g = 1000;
  private int h = 10;
  
  private void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  private void a(String paramString)
  {
    this.b = paramString;
  }
  
  private void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  private void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  private void d(int paramInt)
  {
    this.g = paramInt;
  }
  
  private void e(int paramInt)
  {
    this.h = paramInt;
  }
  
  private void f(int paramInt)
  {
    this.d = paramInt;
  }
  
  public String a()
  {
    return "telemetry";
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    JSONObject localJSONObject = paramJSONObject.getJSONObject("base");
    this.a.b(localJSONObject.getBoolean("enabled"));
    this.a.a(localJSONObject.getInt("samplingFactor"));
    this.a.a(localJSONObject.getBoolean("metricEnabled"));
    a(paramJSONObject.getString("url"));
    a(paramJSONObject.getInt("processingInterval"));
    f(paramJSONObject.getInt("retryInterval"));
    c(paramJSONObject.getInt("maxBatchSize"));
    b(paramJSONObject.getInt("maxRetryCount"));
    d(paramJSONObject.getInt("maxEventsToPersist"));
    e(paramJSONObject.getInt("memoryThreshold"));
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject1 = super.b();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("enabled", this.a.b());
    localJSONObject2.put("samplingFactor", this.a.c());
    localJSONObject2.put("metricEnabled", this.a.d());
    localJSONObject1.put("base", localJSONObject2);
    localJSONObject1.put("url", f());
    localJSONObject1.put("processingInterval", k());
    localJSONObject1.put("retryInterval", g());
    localJSONObject1.put("maxBatchSize", i());
    localJSONObject1.put("maxRetryCount", j());
    localJSONObject1.put("maxEventsToPersist", l());
    localJSONObject1.put("memoryThreshold", h());
    return localJSONObject1;
  }
  
  public boolean c()
  {
    if ((this.a == null) || (this.a.c() < 0)) {}
    while ((this.b.trim().length() == 0) || ((!this.b.startsWith("http://")) && (!this.b.startsWith("https://"))) || (this.d < 0) || (this.c < 0) || (this.f < 0) || (this.h <= 0) || (this.e <= 0) || (this.g <= 0)) {
      return false;
    }
    return true;
  }
  
  public a d()
  {
    return new c();
  }
  
  public boolean e()
  {
    return this.a.b();
  }
  
  public String f()
  {
    return this.b;
  }
  
  public int g()
  {
    return this.d;
  }
  
  public int h()
  {
    return this.h;
  }
  
  public int i()
  {
    return this.e;
  }
  
  public int j()
  {
    return this.f;
  }
  
  public int k()
  {
    return this.c;
  }
  
  public int l()
  {
    return this.g;
  }
  
  public b m()
  {
    return this.a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */