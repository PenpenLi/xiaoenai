package com.xiaoenai.app.net.http.a;

import android.os.Handler;
import b.ab;
import b.ag;
import b.ag.a;
import b.al;
import b.al.a;
import b.aq;
import b.u;
import java.util.concurrent.TimeUnit;

public class a
  extends com.xiaoenai.app.net.http.base.a
{
  u a = new b(this);
  private ag b = new ag();
  
  private al a(com.xiaoenai.app.net.http.base.a.c paramc, com.xiaoenai.app.net.http.base.b.a parama)
  {
    al localal = new al.a().a(paramc.a()).b();
    String str = paramc.f();
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return localal;
        if (str.equals("GET"))
        {
          i = 0;
          continue;
          if (str.equals("POST")) {
            i = 1;
          }
        }
        break;
      }
    }
    return new com.xiaoenai.app.net.http.a.b.a(paramc).a(parama);
    return new com.xiaoenai.app.net.http.a.b.c(parama.c(), paramc).a(parama);
  }
  
  public void a(long paramLong, TimeUnit paramTimeUnit)
  {
    this.b = this.b.x().a(paramLong, paramTimeUnit).a();
  }
  
  public void a(aq paramaq, Exception paramException, com.xiaoenai.app.net.http.base.b.a parama)
  {
    com.xiaoenai.app.utils.f.a.a(true, "Http requestUrl:{}\n statusCode={}\n exceptionMessage:{}", new Object[] { paramaq.a().a().toString(), Integer.valueOf(paramaq.b()), paramException.getMessage() });
    if (parama == null) {
      return;
    }
    parama.c().post(new e(this, parama, paramaq, paramException));
  }
  
  public void a(b.g paramg, Exception paramException, com.xiaoenai.app.net.http.base.b.a parama)
  {
    com.xiaoenai.app.utils.f.a.a(true, "Http requestUrl:{}\n isCanceled={}\n exceptionMessage:{}", new Object[] { paramg.a().a().toString(), Boolean.valueOf(paramg.b()), paramException.getMessage() });
    if (parama == null) {
      return;
    }
    parama.c().post(new d(this, parama, paramException));
  }
  
  public void a(com.xiaoenai.app.net.http.base.a.c paramc, com.xiaoenai.app.net.http.base.b.a parama, com.xiaoenai.app.net.http.base.b paramb)
  {
    g.a(this, paramb);
    paramb = a(paramc, parama);
    com.xiaoenai.app.utils.f.a.c("Http requestUrl : {} ", new Object[] { paramb.a().toString() });
    this.b.a(paramb).a(new c(this, parama, paramc));
  }
  
  public void a(Object paramObject, com.xiaoenai.app.net.http.base.a.c paramc, com.xiaoenai.app.net.http.base.b.a parama)
  {
    if (parama == null) {
      return;
    }
    parama.c().post(new f(this, parama, paramc, paramObject));
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = this.b.x().a(paramBoolean).a();
  }
  
  public void b(long paramLong, TimeUnit paramTimeUnit)
  {
    this.b = this.b.x().b(paramLong, paramTimeUnit).a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b = this.b.x().a(this.a).a();
    }
  }
  
  public void c(long paramLong, TimeUnit paramTimeUnit)
  {
    this.b = this.b.x().c(paramLong, paramTimeUnit).a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */