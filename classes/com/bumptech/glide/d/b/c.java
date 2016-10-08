package com.bumptech.glide.d.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.Log;
import com.bumptech.glide.g.f;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class c
  implements com.bumptech.glide.d.b.b.i.a, e, h.a
{
  private final Map<com.bumptech.glide.d.c, d> a;
  private final g b;
  private final com.bumptech.glide.d.b.b.i c;
  private final a d;
  private final Map<com.bumptech.glide.d.c, WeakReference<h<?>>> e;
  private final l f;
  private final b g;
  private ReferenceQueue<h<?>> h;
  
  public c(com.bumptech.glide.d.b.b.i parami, com.bumptech.glide.d.b.b.a.a parama, ExecutorService paramExecutorService1, ExecutorService paramExecutorService2)
  {
    this(parami, parama, paramExecutorService1, paramExecutorService2, null, null, null, null, null);
  }
  
  c(com.bumptech.glide.d.b.b.i parami, com.bumptech.glide.d.b.b.a.a parama, ExecutorService paramExecutorService1, ExecutorService paramExecutorService2, Map<com.bumptech.glide.d.c, d> paramMap, g paramg, Map<com.bumptech.glide.d.c, WeakReference<h<?>>> paramMap1, a parama1, l paraml)
  {
    this.c = parami;
    this.g = new b(parama);
    parama = paramMap1;
    if (paramMap1 == null) {
      parama = new HashMap();
    }
    this.e = parama;
    parama = paramg;
    if (paramg == null) {
      parama = new g();
    }
    this.b = parama;
    parama = paramMap;
    if (paramMap == null) {
      parama = new HashMap();
    }
    this.a = parama;
    parama = parama1;
    if (parama1 == null) {
      parama = new a(paramExecutorService1, paramExecutorService2, this);
    }
    this.d = parama;
    parama = paraml;
    if (paraml == null) {
      parama = new l();
    }
    this.f = parama;
    parami.a(this);
  }
  
  private h<?> a(com.bumptech.glide.d.c paramc)
  {
    paramc = this.c.a(paramc);
    if (paramc == null) {
      return null;
    }
    if ((paramc instanceof h)) {
      return (h)paramc;
    }
    return new h(paramc, true);
  }
  
  private h<?> a(com.bumptech.glide.d.c paramc, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return null;
    }
    Object localObject = (WeakReference)this.e.get(paramc);
    if (localObject != null)
    {
      localObject = (h)((WeakReference)localObject).get();
      if (localObject != null)
      {
        ((h)localObject).e();
        paramc = (com.bumptech.glide.d.c)localObject;
      }
    }
    for (;;)
    {
      return paramc;
      this.e.remove(paramc);
      paramc = (com.bumptech.glide.d.c)localObject;
      continue;
      paramc = null;
    }
  }
  
  private static void a(String paramString, long paramLong, com.bumptech.glide.d.c paramc)
  {
    Log.v("Engine", paramString + " in " + com.bumptech.glide.i.d.a(paramLong) + "ms, key: " + paramc);
  }
  
  private h<?> b(com.bumptech.glide.d.c paramc, boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean) {
      localObject = null;
    }
    h localh;
    do
    {
      return (h<?>)localObject;
      localh = a(paramc);
      localObject = localh;
    } while (localh == null);
    localh.e();
    this.e.put(paramc, new e(paramc, localh, b()));
    return localh;
  }
  
  private ReferenceQueue<h<?>> b()
  {
    if (this.h == null)
    {
      this.h = new ReferenceQueue();
      Looper.myQueue().addIdleHandler(new d(this.e, this.h));
    }
    return this.h;
  }
  
  public <T, Z, R> c a(com.bumptech.glide.d.c paramc, int paramInt1, int paramInt2, com.bumptech.glide.d.a.c<T> paramc1, com.bumptech.glide.f.b<T, Z> paramb, com.bumptech.glide.d.g<Z> paramg, com.bumptech.glide.d.d.f.c<Z, R> paramc2, com.bumptech.glide.e parame, boolean paramBoolean, b paramb1, f paramf)
  {
    com.bumptech.glide.i.h.a();
    long l = com.bumptech.glide.i.d.a();
    Object localObject = paramc1.b();
    paramc = this.b.a((String)localObject, paramc, paramInt1, paramInt2, paramb.a(), paramb.b(), paramg, paramb.d(), paramc2, paramb.c());
    localObject = b(paramc, paramBoolean);
    if (localObject != null)
    {
      paramf.a((k)localObject);
      if (Log.isLoggable("Engine", 2)) {
        a("Loaded resource from cache", l, paramc);
      }
      return null;
    }
    localObject = a(paramc, paramBoolean);
    if (localObject != null)
    {
      paramf.a((k)localObject);
      if (Log.isLoggable("Engine", 2)) {
        a("Loaded resource from active resources", l, paramc);
      }
      return null;
    }
    localObject = (d)this.a.get(paramc);
    if (localObject != null)
    {
      ((d)localObject).a(paramf);
      if (Log.isLoggable("Engine", 2)) {
        a("Added to existing load", l, paramc);
      }
      return new c(paramf, (d)localObject);
    }
    localObject = this.d.a(paramc, paramBoolean);
    paramc1 = new i((i.a)localObject, new a(paramc, paramInt1, paramInt2, paramc1, paramb, paramg, paramc2, this.g, paramb1, parame), parame);
    this.a.put(paramc, localObject);
    ((d)localObject).a(paramf);
    ((d)localObject).a(paramc1);
    if (Log.isLoggable("Engine", 2)) {
      a("Started new load", l, paramc);
    }
    return new c(paramf, (d)localObject);
  }
  
  public void a()
  {
    this.g.a().a();
  }
  
  public void a(d paramd, com.bumptech.glide.d.c paramc)
  {
    
    if (paramd.equals((d)this.a.get(paramc))) {
      this.a.remove(paramc);
    }
  }
  
  public void a(k paramk)
  {
    
    if ((paramk instanceof h))
    {
      ((h)paramk).f();
      return;
    }
    throw new IllegalArgumentException("Cannot release anything but an EngineResource");
  }
  
  public void a(com.bumptech.glide.d.c paramc, h<?> paramh)
  {
    
    if (paramh != null)
    {
      paramh.a(paramc, this);
      if (paramh.a()) {
        this.e.put(paramc, new e(paramc, paramh, b()));
      }
    }
    this.a.remove(paramc);
  }
  
  public void b(k<?> paramk)
  {
    com.bumptech.glide.i.h.a();
    this.f.a(paramk);
  }
  
  public void b(com.bumptech.glide.d.c paramc, h paramh)
  {
    com.bumptech.glide.i.h.a();
    this.e.remove(paramc);
    if (paramh.a())
    {
      this.c.b(paramc, paramh);
      return;
    }
    this.f.a(paramh);
  }
  
  static class a
  {
    private final ExecutorService a;
    private final ExecutorService b;
    private final e c;
    
    public a(ExecutorService paramExecutorService1, ExecutorService paramExecutorService2, e parame)
    {
      this.a = paramExecutorService1;
      this.b = paramExecutorService2;
      this.c = parame;
    }
    
    public d a(com.bumptech.glide.d.c paramc, boolean paramBoolean)
    {
      return new d(paramc, this.a, this.b, paramBoolean, this.c);
    }
  }
  
  private static class b
    implements a.a
  {
    private final com.bumptech.glide.d.b.b.a.a a;
    private volatile com.bumptech.glide.d.b.b.a b;
    
    public b(com.bumptech.glide.d.b.b.a.a parama)
    {
      this.a = parama;
    }
    
    public com.bumptech.glide.d.b.b.a a()
    {
      if (this.b == null) {}
      try
      {
        if (this.b == null) {
          this.b = this.a.a();
        }
        if (this.b == null) {
          this.b = new com.bumptech.glide.d.b.b.b();
        }
        return this.b;
      }
      finally {}
    }
  }
  
  public static class c
  {
    private final d a;
    private final f b;
    
    public c(f paramf, d paramd)
    {
      this.b = paramf;
      this.a = paramd;
    }
    
    public void a()
    {
      this.a.b(this.b);
    }
  }
  
  private static class d
    implements MessageQueue.IdleHandler
  {
    private final Map<com.bumptech.glide.d.c, WeakReference<h<?>>> a;
    private final ReferenceQueue<h<?>> b;
    
    public d(Map<com.bumptech.glide.d.c, WeakReference<h<?>>> paramMap, ReferenceQueue<h<?>> paramReferenceQueue)
    {
      this.a = paramMap;
      this.b = paramReferenceQueue;
    }
    
    public boolean queueIdle()
    {
      c.e locale = (c.e)this.b.poll();
      if (locale != null) {
        this.a.remove(c.e.a(locale));
      }
      return true;
    }
  }
  
  private static class e
    extends WeakReference<h<?>>
  {
    private final com.bumptech.glide.d.c a;
    
    public e(com.bumptech.glide.d.c paramc, h<?> paramh, ReferenceQueue<? super h<?>> paramReferenceQueue)
    {
      super(paramReferenceQueue);
      this.a = paramc;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */