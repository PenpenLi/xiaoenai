package com.inmobi.ads;

import android.os.Handler;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.List;

 enum r$b$1
{
  r$b$1(String paramString1)
  {
    super(paramString, paramInt, paramString1, null);
  }
  
  void a(r paramr)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "Entering state:" + this);
    r.a(paramr, r.b.a);
    r.a(paramr, 0);
    e(paramr);
  }
  
  void a(r paramr, long paramLong, boolean paramBoolean)
  {
    if ((paramBoolean) && (r.f(paramr) >= 10)) {
      return;
    }
    r.i(paramr).postDelayed(new r.b.1.1(this, paramr), paramLong);
  }
  
  void a(r paramr, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      r.b.b.a(paramr);
      Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "App went to background; stopping cache replenish handler");
    }
  }
  
  void b(r paramr)
  {
    a.a(paramr);
  }
  
  void b(r paramr, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      r.b.b.a(paramr);
      Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "Connectivity lost; stopping cache replenish handler");
    }
  }
  
  void c(r paramr)
  {
    c.a(paramr);
  }
  
  void d(r paramr)
  {
    d.a(paramr);
  }
  
  void e(r paramr)
  {
    if (!r.a(paramr)) {
      Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "Ignoring Ad load as there are no ad positions");
    }
    do
    {
      return;
      if (r.b(paramr).size() > 0)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "Serving ad already in cache");
        g(paramr);
        return;
      }
    } while (!r.c(paramr).z());
    r.c(paramr).o();
  }
  
  q f(r paramr)
  {
    q localq = null;
    if (r.b(paramr).size() > 0) {
      localq = (q)r.b(paramr).remove(0);
    }
    a(paramr, 0L, false);
    return localq;
  }
  
  void g(r paramr)
  {
    r.a(paramr, 0);
    r.d(paramr).a();
  }
  
  void h(r paramr)
  {
    r.e(paramr);
    if (r.f(paramr) >= 10)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "Exhausted retries for ad response; giving up");
      return;
    }
    a(paramr, r.g(paramr), true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\r$b$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */