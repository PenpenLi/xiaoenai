package com.bumptech.glide;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.manager.c.a;
import com.bumptech.glide.manager.d;
import com.bumptech.glide.manager.i;
import com.bumptech.glide.manager.m;

public class f
  implements i
{
  private final Context a;
  private final com.bumptech.glide.manager.h b;
  private final com.bumptech.glide.manager.l c;
  private final m d;
  private final Glide e;
  private final c f;
  private a g;
  
  public f(Context paramContext, com.bumptech.glide.manager.h paramh, com.bumptech.glide.manager.l paraml)
  {
    this(paramContext, paramh, paraml, new m(), new d());
  }
  
  f(Context paramContext, com.bumptech.glide.manager.h paramh, com.bumptech.glide.manager.l paraml, m paramm, d paramd)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramh;
    this.c = paraml;
    this.d = paramm;
    this.e = Glide.get(paramContext);
    this.f = new c();
    paramContext = paramd.a(paramContext, new d(paramm));
    if (com.bumptech.glide.i.h.d()) {
      new Handler(Looper.getMainLooper()).post(new g(this, paramh));
    }
    for (;;)
    {
      paramh.a(paramContext);
      return;
      paramh.a(this);
    }
  }
  
  private static <T> Class<T> b(T paramT)
  {
    if (paramT != null) {
      return paramT.getClass();
    }
    return null;
  }
  
  public <A, T> b<A, T> a(com.bumptech.glide.d.c.l<A, T> paraml, Class<T> paramClass)
  {
    return new b(paraml, paramClass);
  }
  
  public void a()
  {
    this.e.clearMemory();
  }
  
  public void a(int paramInt)
  {
    this.e.trimMemory(paramInt);
  }
  
  public void b()
  {
    com.bumptech.glide.i.h.a();
    this.d.a();
  }
  
  public void c()
  {
    com.bumptech.glide.i.h.a();
    this.d.b();
  }
  
  public void d()
  {
    c();
  }
  
  public void e()
  {
    b();
  }
  
  public void f()
  {
    this.d.c();
  }
  
  public static abstract interface a
  {
    public abstract <T> void a(a<T, ?, ?, ?> parama);
  }
  
  public final class b<A, T>
  {
    private final com.bumptech.glide.d.c.l<A, T> b;
    private final Class<T> c;
    
    b(Class<T> paramClass)
    {
      this.b = paramClass;
      Class localClass;
      this.c = localClass;
    }
    
    public b<A, T>.a a(A paramA)
    {
      return new a(paramA);
    }
    
    public final class a
    {
      private final A b;
      private final Class<A> c;
      private final boolean d = true;
      
      a()
      {
        Object localObject;
        this.b = localObject;
        this.c = f.a(localObject);
      }
      
      public <Z> b<A, T, Z> a(Class<Z> paramClass)
      {
        paramClass = (b)f.e(f.this).a(new b(f.a(f.this), f.b(f.this), this.c, f.b.a(f.b.this), f.b.b(f.b.this), paramClass, f.c(f.this), f.d(f.this), f.e(f.this)));
        if (this.d) {
          paramClass.a(this.b);
        }
        return paramClass;
      }
    }
  }
  
  class c
  {
    c() {}
    
    public <A, X extends a<A, ?, ?, ?>> X a(X paramX)
    {
      if (f.f(f.this) != null) {
        f.f(f.this).a(paramX);
      }
      return paramX;
    }
  }
  
  private static class d
    implements c.a
  {
    private final m a;
    
    public d(m paramm)
    {
      this.a = paramm;
    }
    
    public void a(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.a.d();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */