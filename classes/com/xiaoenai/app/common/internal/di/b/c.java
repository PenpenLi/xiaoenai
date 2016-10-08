package com.xiaoenai.app.common.internal.di.b;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.xiaoenai.app.common.application.BaseApplication;
import com.xiaoenai.app.common.view.b.a.d;
import com.xiaoenai.app.data.d.j;
import com.xiaoenai.app.data.d.k;
import com.xiaoenai.app.data.e.q;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class c
{
  private final BaseApplication a;
  private final Handler b;
  private final com.xiaoenai.app.common.application.a.a.b c;
  private final com.xiaoenai.app.common.view.b.a.a d;
  private final d e;
  private final com.xiaoenai.app.common.application.a.a.a f;
  private final com.xiaoenai.app.domain.d.a.b g;
  private final com.xiaoenai.app.data.d.a.e h;
  private final com.xiaoenai.app.data.d.a i;
  
  public c(a parama)
  {
    this.a = a.a(parama);
    this.b = new Handler();
    this.c = a.b(parama);
    this.d = a.c(parama);
    this.e = a.d(parama);
    this.f = a.e(parama);
    this.g = a.f(parama);
    this.h = a.g(parama);
    this.i = a.h(parama);
  }
  
  @Provides
  @Singleton
  Context a()
  {
    return this.a;
  }
  
  @Provides
  @Singleton
  com.xiaoenai.app.data.a.a a(com.xiaoenai.app.data.a.a.a parama)
  {
    return parama;
  }
  
  @Provides
  @Singleton
  com.xiaoenai.app.data.a.b a(com.xiaoenai.app.data.a.a.c paramc)
  {
    return paramc;
  }
  
  @Provides
  @Singleton
  com.xiaoenai.app.data.b.a.a a(com.xiaoenai.app.data.b.a.a.a parama)
  {
    return parama;
  }
  
  @Provides
  @Singleton
  j a(k paramk)
  {
    return paramk;
  }
  
  @Provides
  @Singleton
  com.xiaoenai.app.domain.e.a a(com.xiaoenai.app.data.e.a parama)
  {
    return parama;
  }
  
  @Provides
  @Singleton
  com.xiaoenai.app.domain.e.c a(com.xiaoenai.app.data.e.e parame)
  {
    return parame;
  }
  
  @Provides
  @Singleton
  com.xiaoenai.app.domain.e.e a(q paramq)
  {
    return paramq;
  }
  
  @Provides
  @Singleton
  BaseApplication b()
  {
    return this.a;
  }
  
  @Provides
  @Singleton
  LocationManager c()
  {
    return (LocationManager)this.a.getSystemService("location");
  }
  
  @Provides
  @Singleton
  Handler d()
  {
    return this.b;
  }
  
  @Provides
  @Singleton
  com.xiaoenai.app.common.application.a.a.b e()
  {
    return this.c;
  }
  
  @Provides
  @Singleton
  com.xiaoenai.app.common.view.b.a.a f()
  {
    return this.d;
  }
  
  @Provides
  @Singleton
  d g()
  {
    return this.e;
  }
  
  @Provides
  @Singleton
  com.xiaoenai.app.common.application.a.a.a h()
  {
    return this.f;
  }
  
  @Provides
  @Singleton
  com.xiaoenai.app.domain.d.a.b i()
  {
    return this.g;
  }
  
  @Provides
  com.xiaoenai.app.data.d.a.e j()
  {
    return this.h;
  }
  
  @Provides
  com.xiaoenai.app.data.d.a k()
  {
    return this.i;
  }
  
  public static class a
  {
    private com.xiaoenai.app.common.application.a.a.b a;
    private com.xiaoenai.app.common.view.b.a.a b;
    private d c;
    private com.xiaoenai.app.common.application.a.a.a d;
    private com.xiaoenai.app.domain.d.a.b e;
    private BaseApplication f;
    private com.xiaoenai.app.data.d.a.e g;
    private com.xiaoenai.app.data.d.a h;
    
    private void b()
    {
      if (this.b == null) {
        this.b = new com.xiaoenai.app.common.view.b.a.b();
      }
      if (this.c == null) {
        this.c = new com.xiaoenai.app.common.view.b.a.c();
      }
      if (this.g == null) {
        this.g = new com.xiaoenai.app.data.d.a.e();
      }
    }
    
    public a a(@NonNull BaseApplication paramBaseApplication)
    {
      this.f = paramBaseApplication;
      return this;
    }
    
    public a a(com.xiaoenai.app.common.application.a.a.a parama)
    {
      this.d = parama;
      return this;
    }
    
    public a a(com.xiaoenai.app.common.application.a.a.b paramb)
    {
      this.a = paramb;
      return this;
    }
    
    public a a(com.xiaoenai.app.common.view.b.a.a parama)
    {
      this.b = parama;
      return this;
    }
    
    public a a(d paramd)
    {
      this.c = paramd;
      return this;
    }
    
    public a a(com.xiaoenai.app.data.d.a.e parame)
    {
      this.g = parame;
      return this;
    }
    
    public a a(com.xiaoenai.app.data.d.a parama)
    {
      this.h = parama;
      return this;
    }
    
    public a a(com.xiaoenai.app.domain.d.a.b paramb)
    {
      this.e = paramb;
      return this;
    }
    
    public c a()
    {
      b();
      return new c(this);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\common\internal\di\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */