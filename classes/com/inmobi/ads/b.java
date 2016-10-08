package com.inmobi.ads;

import android.graphics.Color;
import com.inmobi.commons.core.configs.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends a
{
  private static final String a = b.class.getSimpleName();
  private static final String b;
  private static final Object c;
  private String d = b;
  private int e = 20;
  private int f = 60;
  private int g = 60;
  private a h;
  private Map<String, a> i;
  private b j = new b();
  private e k = new e();
  private c l = new c();
  private f m = new f();
  private JSONObject n;
  private d o = new d();
  
  static
  {
    if ("production".equals("staging")) {}
    for (;;)
    {
      b = "http://i.w.inmobi.com/showad.asm";
      c = new Object();
      return;
    }
  }
  
  public b()
  {
    try
    {
      b(p());
      this.n = q();
      return;
    }
    catch (JSONException localJSONException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Default config provided for ads is invalid.", localJSONException);
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.getJSONObject("base");
    this.h = new a();
    a.a(this.h, ((JSONObject)localObject).getInt("maxCacheSize"));
    a.b(this.h, ((JSONObject)localObject).getInt("fetchLimit"));
    a.c(this.h, ((JSONObject)localObject).getInt("minThreshold"));
    a.a(this.h, ((JSONObject)localObject).getLong("timeToLive"));
    paramJSONObject.remove("base");
    this.i = new HashMap();
    localObject = paramJSONObject.keys();
    if (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      JSONObject localJSONObject = paramJSONObject.getJSONObject(str);
      a locala = new a();
      int i1;
      if (localJSONObject.has("maxCacheSize"))
      {
        i1 = localJSONObject.getInt("maxCacheSize");
        label151:
        a.a(locala, i1);
        if (!localJSONObject.has("fetchLimit")) {
          break label269;
        }
        i1 = localJSONObject.getInt("fetchLimit");
        label178:
        a.b(locala, i1);
        if (!localJSONObject.has("minThreshold")) {
          break label281;
        }
        i1 = localJSONObject.getInt("minThreshold");
        label205:
        a.c(locala, i1);
        if (!localJSONObject.has("timeToLive")) {
          break label293;
        }
      }
      label269:
      label281:
      label293:
      for (long l1 = localJSONObject.getInt("timeToLive");; l1 = a.d(this.h))
      {
        a.a(locala, l1);
        this.i.put(str, locala);
        break;
        i1 = a.a(this.h);
        break label151;
        i1 = a.b(this.h);
        break label178;
        i1 = a.c(this.h);
        break label205;
      }
    }
  }
  
  private JSONObject p()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("maxCacheSize", 0);
    localJSONObject2.put("fetchLimit", 1);
    localJSONObject2.put("minThreshold", 0);
    localJSONObject2.put("timeToLive", 3300);
    localJSONObject1.put("base", localJSONObject2);
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("maxCacheSize", 100);
    localJSONObject2.put("fetchLimit", 5);
    localJSONObject2.put("minThreshold", 2);
    localJSONObject2.put("timeToLive", 3300);
    localJSONObject1.put("native", localJSONObject2);
    return localJSONObject1;
  }
  
  private JSONObject q()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("enabled", false);
    localJSONObject.put("samplingFactor", 0);
    localJSONObject.put("metricEnabled", false);
    return localJSONObject;
  }
  
  private JSONObject r()
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("maxCacheSize", this.h.b());
    ((JSONObject)localObject).put("fetchLimit", this.h.c());
    ((JSONObject)localObject).put("minThreshold", this.h.d());
    ((JSONObject)localObject).put("timeToLive", this.h.e());
    localJSONObject1.put("base", localObject);
    localObject = this.i.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      JSONObject localJSONObject2 = new JSONObject();
      a locala = (a)localEntry.getValue();
      localJSONObject2.put("maxCacheSize", locala.b());
      localJSONObject2.put("fetchLimit", locala.c());
      localJSONObject2.put("minThreshold", locala.d());
      localJSONObject2.put("timeToLive", locala.e());
      localJSONObject1.put((String)localEntry.getKey(), localJSONObject2);
    }
    return localJSONObject1;
  }
  
  public a a(String paramString)
  {
    a locala = (a)this.i.get(paramString);
    paramString = locala;
    if (locala == null) {
      paramString = this.h;
    }
    return paramString;
  }
  
  public String a()
  {
    return "ads";
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (paramJSONObject.has("url")) {
      this.d = paramJSONObject.getString("url");
    }
    this.e = paramJSONObject.getInt("minimumRefreshInterval");
    this.f = paramJSONObject.getInt("defaultRefreshInterval");
    this.g = paramJSONObject.getInt("fetchTimeout");
    b(paramJSONObject.getJSONObject("cache"));
    ??? = paramJSONObject.getJSONObject("imai");
    b.a(this.j, ((JSONObject)???).getInt("maxRetries"));
    b.b(this.j, ((JSONObject)???).getInt("pingInterval"));
    b.c(this.j, ((JSONObject)???).getInt("pingTimeout"));
    b.d(this.j, ((JSONObject)???).getInt("maxDbEvents"));
    b.e(this.j, ((JSONObject)???).getInt("maxEventBatch"));
    b.a(this.j, ((JSONObject)???).getLong("pingCacheExpiry"));
    Object localObject2 = paramJSONObject.getJSONObject("rendering");
    e.a(this.k, ((JSONObject)localObject2).getInt("renderTimeout"));
    e.b(this.k, ((JSONObject)localObject2).getInt("picHeight"));
    e.c(this.k, ((JSONObject)localObject2).getInt("picWidth"));
    e.d(this.k, ((JSONObject)localObject2).getInt("picQuality"));
    e.a(this.k, ((JSONObject)localObject2).getString("webviewBackground"));
    e.e(this.k, ((JSONObject)localObject2).getInt("maxVibrationDuration"));
    e.f(this.k, ((JSONObject)localObject2).getInt("maxVibrationPatternLength"));
    e.a(this.k, ((JSONObject)localObject2).getJSONObject("savecontent").getInt("maxSaveSize"));
    synchronized (c)
    {
      e.a(this.k).clear();
      localObject2 = ((JSONObject)localObject2).getJSONObject("savecontent").getJSONArray("allowedContentType");
      int i1 = 0;
      while (i1 < ((JSONArray)localObject2).length())
      {
        e.a(this.k).add(((JSONArray)localObject2).getString(i1));
        i1 += 1;
      }
      ??? = paramJSONObject.getJSONObject("mraid");
      c.a(this.l, ((JSONObject)???).getLong("expiry"));
      c.a(this.l, ((JSONObject)???).getInt("maxRetries"));
      c.b(this.l, ((JSONObject)???).getInt("retryInterval"));
      c.a(this.l, ((JSONObject)???).getString("url"));
      if (paramJSONObject.has("telemetry")) {
        this.n = paramJSONObject.getJSONObject("telemetry");
      }
      ??? = paramJSONObject.getJSONObject("viewability");
      f.a(this.m, ((JSONObject)???).getInt("impressionMinPercentageViewed"));
      f.b(this.m, ((JSONObject)???).getInt("impressionMinTimeViewed"));
      f.c(this.m, ((JSONObject)???).optInt("visibilityThrottleMillis", 100));
      f.d(this.m, ((JSONObject)???).optInt("impressionPollIntervalMillis", 250));
      paramJSONObject = paramJSONObject.getJSONObject("preload").getJSONObject("base");
      d.a(this.o, paramJSONObject.getBoolean("enabled"));
      d.a(this.o, paramJSONObject.getLong("placementExpiry"));
      d.a(this.o, paramJSONObject.getInt("maxPreloadedAds"));
      return;
    }
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject1 = super.b();
    localJSONObject1.put("url", this.d);
    localJSONObject1.put("minimumRefreshInterval", this.e);
    localJSONObject1.put("defaultRefreshInterval", this.f);
    localJSONObject1.put("fetchTimeout", this.g);
    localJSONObject1.put("cache", r());
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("maxRetries", this.j.a());
    localJSONObject2.put("pingInterval", this.j.b());
    localJSONObject2.put("pingTimeout", this.j.c());
    localJSONObject2.put("maxDbEvents", this.j.d());
    localJSONObject2.put("maxEventBatch", this.j.e());
    localJSONObject2.put("pingCacheExpiry", this.j.f());
    localJSONObject1.put("imai", localJSONObject2);
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("renderTimeout", this.k.i());
    localJSONObject2.put("picWidth", this.k.a());
    localJSONObject2.put("picHeight", this.k.b());
    localJSONObject2.put("picQuality", this.k.c());
    localJSONObject2.put("webviewBackground", e.b(this.k));
    localJSONObject2.put("maxVibrationDuration", this.k.e());
    localJSONObject2.put("maxVibrationPatternLength", this.k.f());
    JSONObject localJSONObject3 = new JSONObject();
    localJSONObject3.put("maxSaveSize", this.k.g());
    localJSONObject3.put("allowedContentType", new JSONArray(this.k.h()));
    localJSONObject2.put("savecontent", localJSONObject3);
    localJSONObject1.put("rendering", localJSONObject2);
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("expiry", this.l.a());
    localJSONObject2.put("maxRetries", this.l.b());
    localJSONObject2.put("retryInterval", this.l.c());
    localJSONObject2.put("url", this.l.d());
    localJSONObject1.put("mraid", localJSONObject2);
    localJSONObject2 = new JSONObject();
    localJSONObject2.put("impressionMinPercentageViewed", this.m.a());
    localJSONObject2.put("impressionMinTimeViewed", this.m.b());
    localJSONObject2.put("visibilityThrottleMillis", this.m.c());
    localJSONObject2.put("impressionPollIntervalMillis", this.m.d());
    localJSONObject1.put("viewability", localJSONObject2);
    localJSONObject2 = new JSONObject();
    localJSONObject3 = new JSONObject();
    localJSONObject3.put("enabled", this.o.b());
    localJSONObject3.put("placementExpiry", this.o.a());
    localJSONObject3.put("maxPreloadedAds", this.o.c());
    localJSONObject2.put("base", localJSONObject3);
    localJSONObject1.put("preload", localJSONObject2);
    if (this.n != null) {
      localJSONObject1.put("telemetry", this.n);
    }
    return localJSONObject1;
  }
  
  public boolean c()
  {
    if (((!this.d.startsWith("http://")) && (!this.d.startsWith("https://"))) || (this.e < 0) || (this.f < 0) || (this.g <= 0)) {
      return false;
    }
    if ((this.h == null) || (!this.h.a())) {
      return false;
    }
    Iterator localIterator = this.i.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (!((a)((Map.Entry)localIterator.next()).getValue()).a()) {
        return false;
      }
    }
    if ((this.j.d() < 0) || (this.j.e() < 0) || (this.j.a() < 0) || (this.j.b() < 0) || (this.j.c() <= 0) || (this.j.f() <= 0L)) {
      return false;
    }
    if ((this.l.a() < 0L) || (this.l.c() < 0) || (this.l.b() < 0) || ((!this.l.d().startsWith("http://")) && (!this.l.d().startsWith("https://")))) {
      return false;
    }
    if ((this.k.i() < 0) || (this.k.b() < 0) || (this.k.a() < 0) || (this.k.c() < 0) || (this.k.e() < 0) || (this.k.f() < 0) || (this.k.g() < 0L) || (e.b(this.k) == null) || (e.b(this.k).trim().length() == 0)) {
      return false;
    }
    try
    {
      e.g(this.k, Color.parseColor(e.b(this.k)));
      if ((this.l.b() < 0) || (this.l.c() < 0) || (this.l.d() == null) || (this.l.d().trim().length() == 0)) {
        return false;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Webview color specified in config is invalid.", localIllegalArgumentException);
      return false;
    }
    if ((this.m.a() <= 0) || (this.m.a() > 100) || (this.m.b() < 0) || (this.m.c() < 50) || (this.m.c() * 5 > this.m.b()) || (this.m.d() < 50) || (this.m.d() * 4 > this.m.b())) {
      return false;
    }
    return (d.a(this.o) >= 0L) && (d.b(this.o) > 0);
  }
  
  public a d()
  {
    return new b();
  }
  
  public String e()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.e;
  }
  
  public int g()
  {
    return this.f;
  }
  
  public int h()
  {
    return this.g;
  }
  
  public b i()
  {
    return this.j;
  }
  
  public e j()
  {
    return this.k;
  }
  
  public c k()
  {
    return this.l;
  }
  
  public f l()
  {
    return this.m;
  }
  
  public JSONObject m()
  {
    return this.n;
  }
  
  public d n()
  {
    return this.o;
  }
  
  static final class a
  {
    private int a;
    private int b;
    private int c;
    private long d;
    
    public boolean a()
    {
      return (this.b > 0) && (this.a >= 0) && (this.c >= 0) && (this.d >= 0L);
    }
    
    public int b()
    {
      return this.a;
    }
    
    public int c()
    {
      return this.b;
    }
    
    public int d()
    {
      return this.c;
    }
    
    public long e()
    {
      return this.d;
    }
  }
  
  public static final class b
  {
    private int a = 3;
    private int b = 60;
    private int c = 120;
    private int d = 500;
    private int e = 10;
    private long f = 10800L;
    
    public int a()
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
    
    public int e()
    {
      return this.e;
    }
    
    public long f()
    {
      return this.f;
    }
  }
  
  public static final class c
  {
    private long a = 432000L;
    private int b = 3;
    private int c = 60;
    private String d = "https://i.l.inmobicdn.net/sdk/sdk/500/android/mraid.js";
    
    public long a()
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
    
    public String d()
    {
      return this.d;
    }
  }
  
  public static final class d
  {
    private boolean a = false;
    private long b = 259200L;
    private int c = 5;
    
    public long a()
    {
      return this.b;
    }
    
    public boolean b()
    {
      return this.a;
    }
    
    public int c()
    {
      return this.c;
    }
  }
  
  public static final class e
  {
    private int a = 60;
    private int b = 320;
    private int c = 480;
    private int d = 100;
    private String e = "#00000000";
    private int f = Color.parseColor("#00000000");
    private int g = 5;
    private int h = 20;
    private long i = 5242880L;
    private ArrayList<String> j = new ArrayList(Arrays.asList(new String[] { "video/mp4" }));
    
    public int a()
    {
      return this.b;
    }
    
    public int b()
    {
      return this.c;
    }
    
    public int c()
    {
      return this.d;
    }
    
    public int d()
    {
      return this.f;
    }
    
    public int e()
    {
      return this.g;
    }
    
    public int f()
    {
      return this.h;
    }
    
    public long g()
    {
      return this.i;
    }
    
    public List<String> h()
    {
      return this.j;
    }
    
    public int i()
    {
      return this.a;
    }
  }
  
  public static final class f
  {
    private int a = 50;
    private int b = 1000;
    private int c = 100;
    private int d = 250;
    
    public int a()
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
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */