package com.inmobi.ads;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.a;
import com.inmobi.commons.core.utilities.a.b;
import com.inmobi.commons.core.utilities.c;
import com.inmobi.commons.core.utilities.e;
import com.inmobi.commons.core.utilities.e.b;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class r
  implements AdUnit.a, a.b, e.b
{
  private static final String a = r.class.getSimpleName();
  @NonNull
  private s b;
  @NonNull
  private List<q> c = new LinkedList();
  @NonNull
  private b d;
  private boolean e;
  private boolean f;
  @NonNull
  private final Handler g;
  private int h = 0;
  private boolean i = false;
  @NonNull
  private a j;
  
  r(@NonNull Context paramContext, long paramLong, @NonNull InMobiStrandPositioning.InMobiClientPositioning paramInMobiClientPositioning, @NonNull a parama)
  {
    int k = paramInMobiClientPositioning.getFixedPositions().size();
    Integer[] arrayOfInteger1;
    if (k == 0)
    {
      Integer[] arrayOfInteger2 = new Integer[0];
      arrayOfInteger1 = arrayOfInteger2;
      if (paramInMobiClientPositioning.getRepeatingInterval() != Integer.MAX_VALUE)
      {
        this.i = true;
        arrayOfInteger1 = arrayOfInteger2;
      }
    }
    for (;;)
    {
      this.b = new s(paramContext, paramLong, arrayOfInteger1, this);
      this.g = new Handler(paramContext.getMainLooper());
      this.j = parama;
      this.e = c.a();
      this.f = true;
      b.c.a(this);
      l();
      return;
      this.i = true;
      arrayOfInteger1 = new Integer[k];
      paramInMobiClientPositioning.getFixedPositions().toArray(arrayOfInteger1);
    }
  }
  
  private void l()
  {
    a.a().a(this);
    e.a().a("android.net.conn.CONNECTIVITY_CHANGE", this);
  }
  
  private void m()
  {
    a.a().b(this);
    e.a().a(this, "android.net.conn.CONNECTIVITY_CHANGE");
  }
  
  private long n()
  {
    return 20000L;
  }
  
  public void a()
  {
    q localq = this.b.x();
    if (localq != null) {
      this.c.add(localq);
    }
    this.d.g(this);
  }
  
  public void a(InMobiAdRequestStatus paramInMobiAdRequestStatus)
  {
    this.d.h(this);
  }
  
  public void a(String paramString)
  {
    this.b.a(paramString);
  }
  
  public void a(Map<Object, Object> paramMap) {}
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    this.d.a(this, paramBoolean);
  }
  
  public void b() {}
  
  public void b(Map<Object, Object> paramMap) {}
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.d.b(this, paramBoolean);
  }
  
  public void c() {}
  
  public void c(Map<String, String> paramMap)
  {
    this.b.a(paramMap);
  }
  
  public void d() {}
  
  public void e()
  {
    this.d.b(this);
  }
  
  public void f()
  {
    this.d.c(this);
  }
  
  @Nullable
  public q g()
  {
    return this.d.f(this);
  }
  
  public void h()
  {
    this.d.d(this);
  }
  
  public b.f i()
  {
    return this.b.l().l();
  }
  
  void j()
  {
    this.g.removeCallbacksAndMessages(null);
    this.h = 0;
  }
  
  static abstract interface a
  {
    public abstract void a();
  }
  
  private static abstract enum b
  {
    private String e;
    
    private b(String paramString)
    {
      this.e = paramString;
    }
    
    abstract void a(r paramr);
    
    void a(r paramr, long paramLong, boolean paramBoolean) {}
    
    void a(r paramr, boolean paramBoolean) {}
    
    void b(r paramr)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "Cannot be started from current state:" + r.h(paramr).toString());
    }
    
    void b(r paramr, boolean paramBoolean) {}
    
    void c(r paramr)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "Cannot be stopped from current state:" + r.h(paramr).toString());
    }
    
    void d(r paramr)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "Cannot be destroyed from current state:" + r.h(paramr).toString());
    }
    
    void e(r paramr) {}
    
    q f(r paramr)
    {
      return null;
    }
    
    void g(r paramr) {}
    
    void h(r paramr)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "AdLoad failed not handled for state:" + r.h(paramr).toString());
    }
    
    public String toString()
    {
      return this.e;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */