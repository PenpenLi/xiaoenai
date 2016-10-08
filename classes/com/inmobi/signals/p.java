package com.inmobi.signals;

import com.inmobi.commons.core.configs.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import org.json.JSONException;
import org.json.JSONObject;

public class p
  extends a
{
  private static final String a = a.class.getSimpleName();
  private b b = new b();
  private a c = new a();
  private JSONObject d;
  
  public p()
  {
    try
    {
      this.d = h();
      return;
    }
    catch (JSONException localJSONException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Default telemetry config provided for ads is invalid.", localJSONException);
    }
  }
  
  private JSONObject h()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("enabled", false);
    localJSONObject.put("samplingFactor", 0);
    localJSONObject.put("metricEnabled", false);
    return localJSONObject;
  }
  
  public String a()
  {
    return "signals";
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject("ice");
    b.a(this.b, localJSONObject1.getInt("sampleInterval"));
    b.b(this.b, localJSONObject1.getInt("sampleHistorySize"));
    b.c(this.b, localJSONObject1.getInt("stopRequestTimeout"));
    b.a(this.b, localJSONObject1.getBoolean("enabled"));
    b.a(this.b, localJSONObject1.getString("endPoint"));
    b.d(this.b, localJSONObject1.getInt("maxRetries"));
    b.e(this.b, localJSONObject1.getInt("retryInterval"));
    b.b(this.b, localJSONObject1.getBoolean("locationEnabled"));
    b.c(this.b, localJSONObject1.getBoolean("sessionEnabled"));
    JSONObject localJSONObject2 = localJSONObject1.getJSONObject("w");
    b.f(this.b, localJSONObject2.getInt("wf"));
    b.d(this.b, localJSONObject2.getBoolean("cwe"));
    b.e(this.b, localJSONObject2.getBoolean("vwe"));
    localJSONObject2 = localJSONObject1.getJSONObject("c");
    b.f(this.b, localJSONObject2.getBoolean("oe"));
    b.g(this.b, localJSONObject2.getBoolean("cce"));
    b.h(this.b, localJSONObject2.getBoolean("vce"));
    b.g(this.b, localJSONObject2.getInt("cof"));
    localJSONObject1 = localJSONObject1.getJSONObject("ar");
    b.i(this.b, localJSONObject1.getBoolean("e"));
    b.h(this.b, localJSONObject1.getInt("sampleInterval"));
    b.i(this.b, localJSONObject1.getInt("maxHistorySize"));
    localJSONObject1 = paramJSONObject.getJSONObject("carb");
    a.a(this.c, localJSONObject1.getBoolean("enabled"));
    a.a(this.c, localJSONObject1.getString("getEndPoint"));
    a.b(this.c, localJSONObject1.getString("postEndPoint"));
    a.a(this.c, localJSONObject1.getInt("retrieveFrequency"));
    a.b(this.c, localJSONObject1.getInt("maxRetries"));
    a.c(this.c, localJSONObject1.getInt("retryInterval"));
    a.d(this.c, localJSONObject1.getInt("timeoutInterval"));
    a.a(this.c, localJSONObject1.getLong("maxGetResponseSize"));
    this.d = paramJSONObject.optJSONObject("telemetry");
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject1 = super.b();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("sampleInterval", b.a(this.b));
    localJSONObject2.put("stopRequestTimeout", b.b(this.b));
    localJSONObject2.put("sampleHistorySize", b.c(this.b));
    localJSONObject2.put("enabled", b.d(this.b));
    localJSONObject2.put("endPoint", b.e(this.b));
    localJSONObject2.put("maxRetries", b.f(this.b));
    localJSONObject2.put("retryInterval", b.g(this.b));
    localJSONObject2.put("locationEnabled", b.h(this.b));
    localJSONObject2.put("sessionEnabled", b.i(this.b));
    JSONObject localJSONObject3 = new JSONObject();
    localJSONObject3.put("wf", b.j(this.b));
    localJSONObject3.put("vwe", b.k(this.b));
    localJSONObject3.put("cwe", b.l(this.b));
    localJSONObject2.put("w", localJSONObject3);
    localJSONObject3 = new JSONObject();
    localJSONObject3.put("cof", b.m(this.b));
    localJSONObject3.put("vce", b.n(this.b));
    localJSONObject3.put("cce", b.o(this.b));
    localJSONObject3.put("oe", b.p(this.b));
    localJSONObject2.put("c", localJSONObject3);
    localJSONObject3 = new JSONObject();
    localJSONObject3.put("e", b.q(this.b));
    localJSONObject3.put("sampleInterval", b.r(this.b));
    localJSONObject3.put("maxHistorySize", b.s(this.b));
    localJSONObject2.put("ar", localJSONObject3);
    localJSONObject1.put("ice", localJSONObject2);
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("enabled", a.a(this.c));
    localJSONObject2.put("getEndPoint", a.b(this.c));
    localJSONObject2.put("postEndPoint", a.c(this.c));
    localJSONObject2.put("retrieveFrequency", a.d(this.c));
    localJSONObject2.put("maxRetries", a.e(this.c));
    localJSONObject2.put("retryInterval", a.f(this.c));
    localJSONObject2.put("timeoutInterval", a.g(this.c));
    localJSONObject2.put("maxGetResponseSize", this.c.h());
    localJSONObject1.put("carb", localJSONObject2);
    localJSONObject1.put("telemetry", this.d);
    return localJSONObject1;
  }
  
  public boolean c()
  {
    if ((b.a(this.b) < 0) || (b.c(this.b) < 0) || (b.b(this.b) < 0) || (b.e(this.b).trim().length() == 0) || (b.f(this.b) < 0) || (b.g(this.b) < 0) || (this.b.j() < 0) || (this.b.m() < 0) || (b.s(this.b) < 0) || (b.r(this.b) < 0)) {}
    while ((a.b(this.c).trim().length() == 0) || (a.c(this.c).trim().length() == 0) || ((!a.b(this.c).startsWith("http://")) && (!a.b(this.c).startsWith("https://"))) || ((!a.c(this.c).startsWith("http://")) && (!a.c(this.c).startsWith("https://"))) || (a.d(this.c) < 0) || (a.e(this.c) < 0) || (a.f(this.c) < 0) || (a.g(this.c) < 0) || (a.h(this.c) < 0L)) {
      return false;
    }
    return true;
  }
  
  public a d()
  {
    return new p();
  }
  
  public JSONObject e()
  {
    return this.d;
  }
  
  public b f()
  {
    return this.b;
  }
  
  public a g()
  {
    return this.c;
  }
  
  public static class a
  {
    private boolean a = false;
    private String b = "http://dock.inmobi.com/carb/v1/i";
    private String c = "http://dock.inmobi.com/carb/v1/o";
    private int d = 86400;
    private int e = 3;
    private int f = 60;
    private int g = 60;
    private long h = 307200L;
    
    public boolean a()
    {
      return this.a;
    }
    
    public String b()
    {
      return this.b;
    }
    
    public String c()
    {
      return this.c;
    }
    
    public int d()
    {
      return this.d;
    }
    
    public int e()
    {
      return this.e;
    }
    
    public int f()
    {
      return this.f;
    }
    
    public int g()
    {
      return this.g;
    }
    
    public long h()
    {
      return this.h;
    }
  }
  
  public static class b
  {
    private boolean a = false;
    private int b = 300;
    private int c = 3;
    private int d = 50;
    private String e = "https://sdkm.w.inmobi.com/user/e.asm";
    private int f = 3;
    private int g = 60;
    private boolean h = false;
    private boolean i = false;
    private int j = 0;
    private boolean k = false;
    private boolean l = false;
    private int m = 0;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private int r = 180;
    private int s = 50;
    
    public boolean a()
    {
      return this.a;
    }
    
    public int b()
    {
      return this.b;
    }
    
    public int c()
    {
      return this.c;
    }
    
    public int d()
    {
      return this.d;
    }
    
    public String e()
    {
      return this.e;
    }
    
    public int f()
    {
      return this.f;
    }
    
    public int g()
    {
      return this.g;
    }
    
    public boolean h()
    {
      return (this.h) && (this.a);
    }
    
    public boolean i()
    {
      return (this.i) && (this.a);
    }
    
    public int j()
    {
      return this.j;
    }
    
    public boolean k()
    {
      return (this.k) && (this.a);
    }
    
    public boolean l()
    {
      return (this.l) && (this.a);
    }
    
    public int m()
    {
      return this.m;
    }
    
    public boolean n()
    {
      return (this.n) && (this.a);
    }
    
    public boolean o()
    {
      return (this.o) && (this.a);
    }
    
    public boolean p()
    {
      return (this.p) && (this.a);
    }
    
    public boolean q()
    {
      return (this.q) && (this.a);
    }
    
    public int r()
    {
      return this.r;
    }
    
    public int s()
    {
      return this.s;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */