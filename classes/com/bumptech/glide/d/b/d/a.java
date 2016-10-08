package com.bumptech.glide.d.b.d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.d.b.b.i;
import com.bumptech.glide.i.h;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

final class a
  implements Runnable
{
  static final long a = TimeUnit.SECONDS.toMillis(1L);
  private static final a b = new a();
  private final com.bumptech.glide.d.b.a.c c;
  private final i d;
  private final c e;
  private final a f;
  private final Set<d> g = new HashSet();
  private final Handler h;
  private long i = 40L;
  private boolean j;
  
  public a(com.bumptech.glide.d.b.a.c paramc, i parami, c paramc1)
  {
    this(paramc, parami, paramc1, b, new Handler(Looper.getMainLooper()));
  }
  
  a(com.bumptech.glide.d.b.a.c paramc, i parami, c paramc1, a parama, Handler paramHandler)
  {
    this.c = paramc;
    this.d = parami;
    this.e = paramc1;
    this.f = parama;
    this.h = paramHandler;
  }
  
  private void a(d paramd, Bitmap paramBitmap)
  {
    if (this.g.add(paramd))
    {
      paramd = this.c.a(paramd.a(), paramd.b(), paramd.c());
      if (paramd != null) {
        this.c.a(paramd);
      }
    }
    this.c.a(paramBitmap);
  }
  
  private boolean a(long paramLong)
  {
    return this.f.a() - paramLong >= 32L;
  }
  
  private boolean b()
  {
    long l = this.f.a();
    label170:
    while ((!this.e.b()) && (!a(l)))
    {
      d locald = this.e.a();
      Bitmap localBitmap = Bitmap.createBitmap(locald.a(), locald.b(), locald.c());
      if (c() >= h.a(localBitmap)) {
        this.d.b(new b(null), com.bumptech.glide.d.d.a.c.a(localBitmap, this.c));
      }
      for (;;)
      {
        if (!Log.isLoggable("PreFillRunner", 3)) {
          break label170;
        }
        Log.d("PreFillRunner", "allocated [" + locald.a() + "x" + locald.b() + "] " + locald.c() + " size: " + h.a(localBitmap));
        break;
        a(locald, localBitmap);
      }
    }
    return (!this.j) && (!this.e.b());
  }
  
  private int c()
  {
    return this.d.b() - this.d.a();
  }
  
  private long d()
  {
    long l = this.i;
    this.i = Math.min(this.i * 4L, a);
    return l;
  }
  
  public void a()
  {
    this.j = true;
  }
  
  public void run()
  {
    if (b()) {
      this.h.postDelayed(this, d());
    }
  }
  
  static class a
  {
    public long a()
    {
      return SystemClock.currentThreadTimeMillis();
    }
  }
  
  private static class b
    implements com.bumptech.glide.d.c
  {
    public void a(MessageDigest paramMessageDigest) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */