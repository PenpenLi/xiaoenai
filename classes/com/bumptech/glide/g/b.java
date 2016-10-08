package com.bumptech.glide.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.d.b.c.c;
import com.bumptech.glide.d.b.k;
import com.bumptech.glide.d.c.l;
import com.bumptech.glide.d.g;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.b.j;
import java.util.Queue;

public final class b<A, T, Z, R>
  implements com.bumptech.glide.g.b.h, c, f
{
  private static final Queue<b<?, ?, ?, ?>> a = com.bumptech.glide.i.h.a(0);
  private k<?> A;
  private c.c B;
  private long C;
  private a D;
  private final String b = String.valueOf(hashCode());
  private com.bumptech.glide.d.c c;
  private Drawable d;
  private int e;
  private int f;
  private int g;
  private Context h;
  private g<Z> i;
  private com.bumptech.glide.f.f<A, T, Z, R> j;
  private d k;
  private A l;
  private Class<R> m;
  private boolean n;
  private com.bumptech.glide.e o;
  private j<R> p;
  private e<? super A, R> q;
  private float r;
  private com.bumptech.glide.d.b.c s;
  private com.bumptech.glide.g.a.b<R> t;
  private int u;
  private int v;
  private com.bumptech.glide.d.b.b w;
  private Drawable x;
  private Drawable y;
  private boolean z;
  
  public static <A, T, Z, R> b<A, T, Z, R> a(com.bumptech.glide.f.f<A, T, Z, R> paramf, A paramA, com.bumptech.glide.d.c paramc, Context paramContext, com.bumptech.glide.e parame, j<R> paramj, float paramFloat, Drawable paramDrawable1, int paramInt1, Drawable paramDrawable2, int paramInt2, Drawable paramDrawable3, int paramInt3, e<? super A, R> parame1, d paramd, com.bumptech.glide.d.b.c paramc1, g<Z> paramg, Class<R> paramClass, boolean paramBoolean, com.bumptech.glide.g.a.b<R> paramb, int paramInt4, int paramInt5, com.bumptech.glide.d.b.b paramb1)
  {
    b localb2 = (b)a.poll();
    b localb1 = localb2;
    if (localb2 == null) {
      localb1 = new b();
    }
    localb1.b(paramf, paramA, paramc, paramContext, parame, paramj, paramFloat, paramDrawable1, paramInt1, paramDrawable2, paramInt2, paramDrawable3, paramInt3, parame1, paramd, paramc1, paramg, paramClass, paramBoolean, paramb, paramInt4, paramInt5, paramb1);
    return localb1;
  }
  
  private void a(k<?> paramk, R paramR)
  {
    boolean bool = p();
    this.D = a.d;
    this.A = paramk;
    if ((this.q == null) || (!this.q.a(paramR, this.l, this.p, this.z, bool)))
    {
      a locala = this.t.a(this.z, bool);
      this.p.a(paramR, locala);
    }
    q();
    if (Log.isLoggable("GenericRequest", 2)) {
      a("Resource ready in " + com.bumptech.glide.i.d.a(this.C) + " size: " + paramk.c() * 9.5367431640625E-7D + " fromCache: " + this.z);
    }
  }
  
  private void a(String paramString)
  {
    Log.v("GenericRequest", paramString + " this: " + this.b);
  }
  
  private static void a(String paramString1, Object paramObject, String paramString2)
  {
    if (paramObject == null)
    {
      paramString1 = new StringBuilder(paramString1);
      paramString1.append(" must not be null");
      if (paramString2 != null)
      {
        paramString1.append(", ");
        paramString1.append(paramString2);
      }
      throw new NullPointerException(paramString1.toString());
    }
  }
  
  private void b(k paramk)
  {
    this.s.a(paramk);
    this.A = null;
  }
  
  private void b(com.bumptech.glide.f.f<A, T, Z, R> paramf, A paramA, com.bumptech.glide.d.c paramc, Context paramContext, com.bumptech.glide.e parame, j<R> paramj, float paramFloat, Drawable paramDrawable1, int paramInt1, Drawable paramDrawable2, int paramInt2, Drawable paramDrawable3, int paramInt3, e<? super A, R> parame1, d paramd, com.bumptech.glide.d.b.c paramc1, g<Z> paramg, Class<R> paramClass, boolean paramBoolean, com.bumptech.glide.g.a.b<R> paramb, int paramInt4, int paramInt5, com.bumptech.glide.d.b.b paramb1)
  {
    this.j = paramf;
    this.l = paramA;
    this.c = paramc;
    this.d = paramDrawable3;
    this.e = paramInt3;
    this.h = paramContext.getApplicationContext();
    this.o = parame;
    this.p = paramj;
    this.r = paramFloat;
    this.x = paramDrawable1;
    this.f = paramInt1;
    this.y = paramDrawable2;
    this.g = paramInt2;
    this.q = parame1;
    this.k = paramd;
    this.s = paramc1;
    this.i = paramg;
    this.m = paramClass;
    this.n = paramBoolean;
    this.t = paramb;
    this.u = paramInt4;
    this.v = paramInt5;
    this.w = paramb1;
    this.D = a.a;
    if (paramA != null)
    {
      a("ModelLoader", paramf.e(), "try .using(ModelLoader)");
      a("Transcoder", paramf.f(), "try .as*(Class).transcode(ResourceTranscoder)");
      a("Transformation", paramg, "try .transform(UnitTransformation.get())");
      if (!paramb1.a()) {
        break label268;
      }
      a("SourceEncoder", paramf.c(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
    }
    for (;;)
    {
      if ((paramb1.a()) || (paramb1.b())) {
        a("CacheDecoder", paramf.a(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
      }
      if (paramb1.b()) {
        a("Encoder", paramf.d(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
      }
      return;
      label268:
      a("SourceDecoder", paramf.b(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
    }
  }
  
  private void b(Exception paramException)
  {
    if (!o()) {
      return;
    }
    if (this.l == null) {}
    for (Object localObject2 = k();; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = l();
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = m();
      }
      this.p.a(paramException, (Drawable)localObject2);
      return;
    }
  }
  
  private Drawable k()
  {
    if ((this.d == null) && (this.e > 0)) {
      this.d = this.h.getResources().getDrawable(this.e);
    }
    return this.d;
  }
  
  private Drawable l()
  {
    if ((this.y == null) && (this.g > 0)) {
      this.y = this.h.getResources().getDrawable(this.g);
    }
    return this.y;
  }
  
  private Drawable m()
  {
    if ((this.x == null) && (this.f > 0)) {
      this.x = this.h.getResources().getDrawable(this.f);
    }
    return this.x;
  }
  
  private boolean n()
  {
    return (this.k == null) || (this.k.a(this));
  }
  
  private boolean o()
  {
    return (this.k == null) || (this.k.b(this));
  }
  
  private boolean p()
  {
    return (this.k == null) || (!this.k.c());
  }
  
  private void q()
  {
    if (this.k != null) {
      this.k.c(this);
    }
  }
  
  public void a()
  {
    this.j = null;
    this.l = null;
    this.h = null;
    this.p = null;
    this.x = null;
    this.y = null;
    this.d = null;
    this.q = null;
    this.k = null;
    this.i = null;
    this.t = null;
    this.z = false;
    this.B = null;
    a.offer(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (Log.isLoggable("GenericRequest", 2)) {
      a("Got onSizeReady in " + com.bumptech.glide.i.d.a(this.C));
    }
    if (this.D != a.c) {
      return;
    }
    this.D = a.b;
    paramInt1 = Math.round(this.r * paramInt1);
    paramInt2 = Math.round(this.r * paramInt2);
    com.bumptech.glide.d.a.c localc = this.j.e().a(this.l, paramInt1, paramInt2);
    if (localc == null)
    {
      a(new Exception("Failed to load model: '" + this.l + "'"));
      return;
    }
    com.bumptech.glide.d.d.f.c localc1 = this.j.f();
    if (Log.isLoggable("GenericRequest", 2)) {
      a("finished setup for calling load in " + com.bumptech.glide.i.d.a(this.C));
    }
    this.z = true;
    this.B = this.s.a(this.c, paramInt1, paramInt2, localc, this.j, this.i, localc1, this.o, this.n, this.w, this);
    if (this.A != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.z = bool;
      if (!Log.isLoggable("GenericRequest", 2)) {
        break;
      }
      a("finished onSizeReady in " + com.bumptech.glide.i.d.a(this.C));
      return;
    }
  }
  
  public void a(k<?> paramk)
  {
    if (paramk == null)
    {
      a(new Exception("Expected to receive a Resource<R> with an object of " + this.m + " inside, but instead got null."));
      return;
    }
    Object localObject2 = paramk.b();
    if ((localObject2 == null) || (!this.m.isAssignableFrom(localObject2.getClass())))
    {
      b(paramk);
      StringBuilder localStringBuilder = new StringBuilder().append("Expected to receive an object of ").append(this.m).append(" but instead got ");
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = localObject2.getClass();
        localObject1 = localStringBuilder.append(localObject1).append("{").append(localObject2).append("}").append(" inside Resource{").append(paramk).append("}.");
        if (localObject2 == null) {
          break label186;
        }
      }
      label186:
      for (paramk = "";; paramk = " To indicate failure return a null Resource object, rather than a Resource object containing null data.")
      {
        a(new Exception(paramk));
        return;
        localObject1 = "";
        break;
      }
    }
    if (!n())
    {
      b(paramk);
      this.D = a.d;
      return;
    }
    a(paramk, localObject2);
  }
  
  public void a(Exception paramException)
  {
    if (Log.isLoggable("GenericRequest", 3)) {
      Log.d("GenericRequest", "load failed", paramException);
    }
    this.D = a.e;
    if ((this.q == null) || (!this.q.a(paramException, this.l, this.p, p()))) {
      b(paramException);
    }
  }
  
  public void b()
  {
    this.C = com.bumptech.glide.i.d.a();
    if (this.l == null)
    {
      a(null);
      return;
    }
    this.D = a.c;
    if (com.bumptech.glide.i.h.a(this.u, this.v)) {
      a(this.u, this.v);
    }
    for (;;)
    {
      if ((!g()) && (!j()) && (o())) {
        this.p.a(m());
      }
      if (!Log.isLoggable("GenericRequest", 2)) {
        break;
      }
      a("finished run method in " + com.bumptech.glide.i.d.a(this.C));
      return;
      this.p.a(this);
    }
  }
  
  void c()
  {
    this.D = a.f;
    if (this.B != null)
    {
      this.B.a();
      this.B = null;
    }
  }
  
  public void d()
  {
    
    if (this.D == a.g) {
      return;
    }
    c();
    if (this.A != null) {
      b(this.A);
    }
    if (o()) {
      this.p.b(m());
    }
    this.D = a.g;
  }
  
  public void e()
  {
    d();
    this.D = a.h;
  }
  
  public boolean f()
  {
    return (this.D == a.b) || (this.D == a.c);
  }
  
  public boolean g()
  {
    return this.D == a.d;
  }
  
  public boolean h()
  {
    return g();
  }
  
  public boolean i()
  {
    return (this.D == a.f) || (this.D == a.g);
  }
  
  public boolean j()
  {
    return this.D == a.e;
  }
  
  private static enum a
  {
    private a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */