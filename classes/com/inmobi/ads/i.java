package com.inmobi.ads;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import com.inmobi.commons.core.configs.b.b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class i
  implements b.b
{
  private static final String a = i.class.getSimpleName();
  private static final Object b = new Object();
  private static volatile i c;
  private static ConcurrentHashMap<ak, AdUnit> d;
  private static b e;
  
  private i()
  {
    d = new ConcurrentHashMap(8, 0.9F, 3);
    e = new b();
    com.inmobi.commons.core.configs.b.a().a(e, this);
    f();
    com.inmobi.commons.core.c.a.a().a(e.a(), e.m());
  }
  
  public static i a()
  {
    Object localObject1 = c;
    if (localObject1 == null) {
      synchronized (b)
      {
        i locali2 = c;
        localObject1 = locali2;
        if (locali2 == null)
        {
          localObject1 = new i();
          c = (i)localObject1;
        }
        return (i)localObject1;
      }
    }
    return locali1;
  }
  
  public static String a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    return (String)paramMap.get("tp");
  }
  
  private void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", paramString);
    com.inmobi.commons.core.c.a.a().a("ads", "PreLoadCacheHit", localHashMap);
  }
  
  private void a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode", paramString1);
    localHashMap.put("type", paramString2);
    com.inmobi.commons.core.c.a.a().a("ads", "PreLoadCacheMiss", localHashMap);
  }
  
  private boolean a(AdUnit paramAdUnit)
  {
    if (paramAdUnit.g() == AdUnit.AdState.STATE_LOADING) {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "hasAdUnitExpired. Ad unit in loading state.");
    }
    while (System.currentTimeMillis() - paramAdUnit.i() <= e.a(paramAdUnit.a()).e() * 1000L) {
      return false;
    }
    return true;
  }
  
  private void c(ak paramak)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramak);
    int i = al.a().a(localArrayList, e.n().c());
    if (i > 0)
    {
      paramak = new HashMap();
      paramak.put("count", Integer.valueOf(i));
      com.inmobi.commons.core.c.a.a().a("ads", "PreLoadPidOverflow", paramak);
    }
  }
  
  @TargetApi(14)
  private void f()
  {
    Application localApplication = (Application)com.inmobi.commons.a.a.b();
    if (Build.VERSION.SDK_INT >= 14)
    {
      localApplication.registerComponentCallbacks(new i.1(this));
      return;
    }
    localApplication.registerComponentCallbacks(new i.2(this));
  }
  
  private void g()
  {
    new Handler(com.inmobi.commons.a.a.b().getMainLooper()).post(new i.3(this));
  }
  
  private void h()
  {
    if (!e.n().b()) {}
    int i;
    do
    {
      return;
      i = al.a().a(e.n().a());
    } while (i <= 0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("count", Integer.valueOf(i));
    com.inmobi.commons.core.c.a.a().a("ads", "PreLoadPidExpiry", localHashMap);
  }
  
  private void i()
  {
    Iterator localIterator = d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      AdUnit localAdUnit = (AdUnit)localEntry.getValue();
      if (a(localAdUnit))
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "cleanUpExpiredCachedAdUnits. pid:" + ((ak)localEntry.getKey()).c() + " tp:" + ((ak)localEntry.getKey()).d());
        localAdUnit.t();
        localIterator.remove();
      }
    }
  }
  
  private void j()
  {
    if (!e.n().b()) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = (ArrayList)l();
      int i = 0;
      while (i < localArrayList.size())
      {
        b((ak)localArrayList.get(i));
        i += 1;
      }
    }
  }
  
  private void k()
  {
    if (d.size() >= e.n().c())
    {
      ArrayList localArrayList = (ArrayList)al.a().b();
      Iterator localIterator = d.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!localArrayList.contains(localEntry.getKey()))
        {
          ((AdUnit)localEntry.getValue()).t();
          localIterator.remove();
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Removing extra ad unit from ad unit cache. Pid:" + ((ak)localEntry.getKey()).c() + " tp:" + ((ak)localEntry.getKey()).d());
        }
      }
    }
  }
  
  private List<ak> l()
  {
    return al.a().b();
  }
  
  AdUnit a(ak paramak)
  {
    if (!e.n().b())
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "No cached ad unit found as config is disabled. pid:" + paramak.c() + " tp:" + paramak.d());
      return null;
    }
    c(paramak);
    AdUnit localAdUnit = (AdUnit)d.get(paramak);
    if (localAdUnit == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "No cached ad unit found for pid:" + paramak.c() + " tp:" + paramak.d());
      a("Other", paramak.e());
      return null;
    }
    if (a(localAdUnit))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Expired cached ad unit found for pid:" + paramak.c() + " tp:" + paramak.d());
      localAdUnit.t();
      d.remove(paramak);
      a("AdUnitExpired", paramak.e());
      return null;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Cached ad unit found for pid:" + paramak.c() + " tp:" + paramak.d());
    d.remove(paramak);
    a(paramak.e());
    return localAdUnit;
  }
  
  public void a(com.inmobi.commons.core.configs.a parama)
  {
    e = (b)parama;
    com.inmobi.commons.core.c.a.a().a(e.a(), e.m());
  }
  
  public void b()
  {
    h();
    i();
    j();
  }
  
  public void b(ak paramak)
  {
    k();
    if ((e.n().b()) && (!d.containsKey(paramak)))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "preLoadAdUnit. pid:" + paramak.c() + " tp:" + paramak.d());
      if ((paramak.a() == null) && (paramak.d() != null))
      {
        localObject = new HashMap();
        ((Map)localObject).put("tp", paramak.d());
        paramak.a((Map)localObject);
      }
      Object localObject = new o(com.inmobi.commons.a.a.b(), paramak.c(), new a(paramak));
      ((o)localObject).a(paramak.b());
      ((o)localObject).a(paramak.a());
      ((o)localObject).a(true);
      d.put(paramak, localObject);
      ((o)localObject).o();
      paramak = new HashMap();
      paramak.put("type", ((o)localObject).a());
      com.inmobi.commons.core.c.a.a().a("ads", "AdPreLoadRequested", paramak);
    }
  }
  
  public void c()
  {
    h();
    i();
  }
  
  private class a
    implements AdUnit.a
  {
    private ak b;
    
    a(ak paramak)
    {
      this.b = paramak;
    }
    
    public void a()
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, i.d(), "onAdLoadSucceeded called");
    }
    
    public void a(InMobiAdRequestStatus paramInMobiAdRequestStatus)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, i.d(), "onAdLoadFailed called. Status:" + paramInMobiAdRequestStatus.getMessage());
      i.e().remove(this.b);
      if (paramInMobiAdRequestStatus.getStatusCode() == InMobiAdRequestStatus.StatusCode.NO_FILL)
      {
        paramInMobiAdRequestStatus = new HashMap();
        paramInMobiAdRequestStatus.put("type", this.b.e());
        com.inmobi.commons.core.c.a.a().a("ads", "PreLoadServerNoFill", paramInMobiAdRequestStatus);
      }
    }
    
    public void a(Map<Object, Object> paramMap) {}
    
    public void b() {}
    
    public void b(Map<Object, Object> paramMap) {}
    
    public void c() {}
    
    public void d() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */