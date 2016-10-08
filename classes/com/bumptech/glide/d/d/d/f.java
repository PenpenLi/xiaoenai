package com.bumptech.glide.d.d.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.f.b.a;
import java.security.MessageDigest;
import java.util.UUID;

class f
{
  private final b a;
  private final com.bumptech.glide.b.a b;
  private final Handler c;
  private boolean d = false;
  private boolean e = false;
  private com.bumptech.glide.a<com.bumptech.glide.b.a, com.bumptech.glide.b.a, Bitmap, Bitmap> f;
  private a g;
  private boolean h;
  
  public f(Context paramContext, b paramb, com.bumptech.glide.b.a parama, int paramInt1, int paramInt2)
  {
    this(paramb, parama, null, a(paramContext, parama, paramInt1, paramInt2, Glide.get(paramContext).getBitmapPool()));
  }
  
  f(b paramb, com.bumptech.glide.b.a parama, Handler paramHandler, com.bumptech.glide.a<com.bumptech.glide.b.a, com.bumptech.glide.b.a, Bitmap, Bitmap> parama1)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper(), new c(null));
    }
    this.a = paramb;
    this.b = parama;
    this.c = localHandler;
    this.f = parama1;
  }
  
  private static com.bumptech.glide.a<com.bumptech.glide.b.a, com.bumptech.glide.b.a, Bitmap, Bitmap> a(Context paramContext, com.bumptech.glide.b.a parama, int paramInt1, int paramInt2, com.bumptech.glide.d.b.a.c paramc)
  {
    paramc = new h(paramc);
    g localg = new g();
    com.bumptech.glide.d.b localb = com.bumptech.glide.d.d.a.b();
    return Glide.with(paramContext).a(localg, com.bumptech.glide.b.a.class).a(parama).a(Bitmap.class).a(localb).a(paramc).a(true).a(com.bumptech.glide.d.b.b.b).a(paramInt1, paramInt2);
  }
  
  private void e()
  {
    if ((!this.d) || (this.e)) {
      return;
    }
    this.e = true;
    this.b.a();
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.b.b();
    a locala = new a(this.c, this.b.d(), l1 + l2);
    this.f.a(new d()).a(locala);
  }
  
  public void a()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.h = false;
    e();
  }
  
  void a(a parama)
  {
    if (this.h)
    {
      this.c.obtainMessage(2, parama).sendToTarget();
      return;
    }
    a locala = this.g;
    this.g = parama;
    this.a.b(a.a(parama));
    if (locala != null) {
      this.c.obtainMessage(2, locala).sendToTarget();
    }
    this.e = false;
    e();
  }
  
  public void a(com.bumptech.glide.d.g<Bitmap> paramg)
  {
    if (paramg == null) {
      throw new NullPointerException("Transformation must not be null");
    }
    this.f = this.f.a(new com.bumptech.glide.d.g[] { paramg });
  }
  
  public void b()
  {
    this.d = false;
  }
  
  public void c()
  {
    b();
    if (this.g != null)
    {
      Glide.clear(this.g);
      this.g = null;
    }
    this.h = true;
  }
  
  public Bitmap d()
  {
    if (this.g != null) {
      return this.g.a();
    }
    return null;
  }
  
  static class a
    extends com.bumptech.glide.g.b.g<Bitmap>
  {
    private final Handler a;
    private final int b;
    private final long c;
    private Bitmap d;
    
    public a(Handler paramHandler, int paramInt, long paramLong)
    {
      this.a = paramHandler;
      this.b = paramInt;
      this.c = paramLong;
    }
    
    public Bitmap a()
    {
      return this.d;
    }
    
    public void a(Bitmap paramBitmap, com.bumptech.glide.g.a.a<? super Bitmap> parama)
    {
      this.d = paramBitmap;
      paramBitmap = this.a.obtainMessage(1, this);
      this.a.sendMessageAtTime(paramBitmap, this.c);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(int paramInt);
  }
  
  private class c
    implements Handler.Callback
  {
    private c() {}
    
    public boolean handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1)
      {
        paramMessage = (f.a)paramMessage.obj;
        f.this.a(paramMessage);
        return true;
      }
      if (paramMessage.what == 2) {
        Glide.clear((f.a)paramMessage.obj);
      }
      return false;
    }
  }
  
  static class d
    implements com.bumptech.glide.d.c
  {
    private final UUID a;
    
    public d()
    {
      this(UUID.randomUUID());
    }
    
    d(UUID paramUUID)
    {
      this.a = paramUUID;
    }
    
    public void a(MessageDigest paramMessageDigest)
    {
      throw new UnsupportedOperationException("Not implemented");
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof d)) {
        return ((d)paramObject).a.equals(this.a);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\d\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */