package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.core.a.e;
import com.nostra13.universalimageloader.core.a.g;
import java.io.InputStream;
import java.util.concurrent.Executor;

public final class d
{
  final Resources a;
  final int b;
  final int c;
  final int d;
  final int e;
  final com.nostra13.universalimageloader.core.g.a f;
  final Executor g;
  final Executor h;
  final boolean i;
  final boolean j;
  final int k;
  final int l;
  final g m;
  final com.nostra13.universalimageloader.a.b.a n;
  final com.nostra13.universalimageloader.a.a.a o;
  final com.nostra13.universalimageloader.core.d.b p;
  final com.nostra13.universalimageloader.core.b.b q;
  final c r;
  final com.nostra13.universalimageloader.core.d.b s;
  final com.nostra13.universalimageloader.core.d.b t;
  
  private d(a parama)
  {
    this.a = a.a(parama).getResources();
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.g = a.g(parama);
    this.h = a.h(parama);
    this.k = a.i(parama);
    this.l = a.j(parama);
    this.m = a.k(parama);
    this.o = a.l(parama);
    this.n = a.m(parama);
    this.r = a.n(parama);
    this.p = a.o(parama);
    this.q = a.p(parama);
    this.i = a.q(parama);
    this.j = a.r(parama);
    this.s = new b(this.p);
    this.t = new c(this.p);
    com.nostra13.universalimageloader.b.c.a(a.s(parama));
  }
  
  e a()
  {
    DisplayMetrics localDisplayMetrics = this.a.getDisplayMetrics();
    int i2 = this.b;
    int i1 = i2;
    if (i2 <= 0) {
      i1 = localDisplayMetrics.widthPixels;
    }
    int i3 = this.c;
    i2 = i3;
    if (i3 <= 0) {
      i2 = localDisplayMetrics.heightPixels;
    }
    return new e(i1, i2);
  }
  
  public static class a
  {
    public static final g a = g.a;
    private Context b;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private com.nostra13.universalimageloader.core.g.a g = null;
    private Executor h = null;
    private Executor i = null;
    private boolean j = false;
    private boolean k = false;
    private int l = 3;
    private int m = 3;
    private boolean n = false;
    private g o = a;
    private int p = 0;
    private long q = 0L;
    private int r = 0;
    private com.nostra13.universalimageloader.a.b.a s = null;
    private com.nostra13.universalimageloader.a.a.a t = null;
    private com.nostra13.universalimageloader.a.a.b.a u = null;
    private com.nostra13.universalimageloader.core.d.b v = null;
    private com.nostra13.universalimageloader.core.b.b w;
    private c x = null;
    private boolean y = false;
    
    public a(Context paramContext)
    {
      this.b = paramContext.getApplicationContext();
    }
    
    private void c()
    {
      if (this.h == null)
      {
        this.h = a.a(this.l, this.m, this.o);
        if (this.i != null) {
          break label202;
        }
        this.i = a.a(this.l, this.m, this.o);
      }
      for (;;)
      {
        if (this.t == null)
        {
          if (this.u == null) {
            this.u = a.b();
          }
          this.t = a.a(this.b, this.u, this.q, this.r);
        }
        if (this.s == null) {
          this.s = a.a(this.b, this.p);
        }
        if (this.n) {
          this.s = new com.nostra13.universalimageloader.a.b.a.a(this.s, com.nostra13.universalimageloader.b.d.a());
        }
        if (this.v == null) {
          this.v = a.a(this.b);
        }
        if (this.w == null) {
          this.w = a.a(this.y);
        }
        if (this.x == null) {
          this.x = c.t();
        }
        return;
        this.j = true;
        break;
        label202:
        this.k = true;
      }
    }
    
    public a a()
    {
      this.n = true;
      return this;
    }
    
    public a a(int paramInt)
    {
      if ((this.h != null) || (this.i != null)) {
        com.nostra13.universalimageloader.b.c.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      }
      this.l = paramInt;
      return this;
    }
    
    public a a(com.nostra13.universalimageloader.a.a.b.a parama)
    {
      if (this.t != null) {
        com.nostra13.universalimageloader.b.c.c("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
      }
      this.u = parama;
      return this;
    }
    
    public a a(g paramg)
    {
      if ((this.h != null) || (this.i != null)) {
        com.nostra13.universalimageloader.b.c.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      }
      this.o = paramg;
      return this;
    }
    
    public a a(c paramc)
    {
      this.x = paramc;
      return this;
    }
    
    public a a(com.nostra13.universalimageloader.core.d.b paramb)
    {
      this.v = paramb;
      return this;
    }
    
    public a b(int paramInt)
    {
      if ((this.h != null) || (this.i != null)) {
        com.nostra13.universalimageloader.b.c.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      }
      if (paramInt < 1)
      {
        this.m = 1;
        return this;
      }
      if (paramInt > 10)
      {
        this.m = 10;
        return this;
      }
      this.m = paramInt;
      return this;
    }
    
    public d b()
    {
      c();
      return new d(this, null);
    }
    
    public a c(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("memoryCacheSize must be a positive number");
      }
      if (this.s != null) {
        com.nostra13.universalimageloader.b.c.c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
      }
      this.p = paramInt;
      return this;
    }
    
    public a d(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("maxCacheSize must be a positive number");
      }
      if (this.t != null) {
        com.nostra13.universalimageloader.b.c.c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
      }
      this.q = paramInt;
      return this;
    }
    
    public a e(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("maxFileCount must be a positive number");
      }
      if (this.t != null) {
        com.nostra13.universalimageloader.b.c.c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
      }
      this.r = paramInt;
      return this;
    }
  }
  
  private static class b
    implements com.nostra13.universalimageloader.core.d.b
  {
    private final com.nostra13.universalimageloader.core.d.b a;
    
    public b(com.nostra13.universalimageloader.core.d.b paramb)
    {
      this.a = paramb;
    }
    
    public InputStream a(String paramString, Object paramObject)
    {
      switch (d.1.a[com.nostra13.universalimageloader.core.d.b.a.a(paramString).ordinal()])
      {
      default: 
        return this.a.a(paramString, paramObject);
      }
      throw new IllegalStateException();
    }
  }
  
  private static class c
    implements com.nostra13.universalimageloader.core.d.b
  {
    private final com.nostra13.universalimageloader.core.d.b a;
    
    public c(com.nostra13.universalimageloader.core.d.b paramb)
    {
      this.a = paramb;
    }
    
    public InputStream a(String paramString, Object paramObject)
    {
      paramObject = this.a.a(paramString, paramObject);
      switch (d.1.a[com.nostra13.universalimageloader.core.d.b.a.a(paramString).ordinal()])
      {
      default: 
        return (InputStream)paramObject;
      }
      return new com.nostra13.universalimageloader.core.a.c((InputStream)paramObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */