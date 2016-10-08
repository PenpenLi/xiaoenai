package com.bumptech.glide.d.b;

import android.util.Log;
import com.bumptech.glide.g.f;

class i
  implements com.bumptech.glide.d.b.c.e, Runnable
{
  private final com.bumptech.glide.e a;
  private final a b;
  private final a<?, ?, ?> c;
  private b d;
  private volatile boolean e;
  
  public i(a parama, a<?, ?, ?> parama1, com.bumptech.glide.e parame)
  {
    this.b = parama;
    this.c = parama1;
    this.d = b.a;
    this.a = parame;
  }
  
  private void a(k paramk)
  {
    this.b.a(paramk);
  }
  
  private void a(Exception paramException)
  {
    if (c())
    {
      this.d = b.b;
      this.b.b(this);
      return;
    }
    this.b.a(paramException);
  }
  
  private boolean c()
  {
    return this.d == b.a;
  }
  
  private k<?> d()
  {
    if (c()) {
      return e();
    }
    return f();
  }
  
  private k<?> e()
  {
    try
    {
      k localk1 = this.c.a();
      k localk2 = localk1;
      if (localk1 == null) {
        localk2 = this.c.b();
      }
      return localk2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (Log.isLoggable("EngineRunnable", 3)) {
          Log.d("EngineRunnable", "Exception decoding result from cache: " + localException);
        }
        Object localObject = null;
      }
    }
  }
  
  private k<?> f()
  {
    return this.c.c();
  }
  
  public void a()
  {
    this.e = true;
    this.c.d();
  }
  
  public int b()
  {
    return this.a.ordinal();
  }
  
  public void run()
  {
    Object localObject = null;
    if (this.e) {}
    for (;;)
    {
      return;
      try
      {
        localk = d();
        if (this.e)
        {
          if (localk == null) {
            continue;
          }
          localk.d();
        }
      }
      catch (Exception localException)
      {
        k localk;
        for (;;)
        {
          if (Log.isLoggable("EngineRunnable", 2)) {
            Log.v("EngineRunnable", "Exception decoding", localException);
          }
          localk = null;
        }
        if (localk == null)
        {
          a(localException);
          return;
        }
        a(localk);
      }
    }
  }
  
  static abstract interface a
    extends f
  {
    public abstract void b(i parami);
  }
  
  private static enum b
  {
    private b() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */