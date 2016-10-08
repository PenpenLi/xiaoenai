package com.xiaoenai.app.utils.h;

import com.xiaoenai.app.classes.chat.messagelist.message.model.o;
import com.xiaoenai.app.e.a.a;
import com.xiaoenai.app.utils.a.d;
import java.io.File;

public class g
{
  private static g b;
  private c a;
  
  private g()
  {
    if (this.a == null) {
      this.a = new c();
    }
  }
  
  public static g a()
  {
    if (b == null) {
      b = new g();
    }
    return b;
  }
  
  public void a(o paramo)
  {
    com.xiaoenai.app.utils.f.a.c("auto download voice {}", new Object[] { paramo.c() });
    com.xiaoenai.app.e.c.a().a(paramo.v(), paramo.t(), new h(this, paramo));
  }
  
  public void a(o paramo, c.a parama, boolean paramBoolean)
  {
    if ((paramo.u() != null) && (new File(paramo.u()).exists()))
    {
      this.a.a(paramo, parama, paramBoolean);
      return;
    }
    if (paramo.s())
    {
      paramo.c(d.c(paramo.t()).getAbsolutePath());
      this.a.a(paramo, parama, paramBoolean);
      return;
    }
    a(paramo.v(), paramo.t(), new i(this, paramo, parama, paramBoolean));
  }
  
  public void a(String paramString1, String paramString2, a.a parama)
  {
    com.xiaoenai.app.e.c.a().a(paramString1, paramString2, parama);
  }
  
  public com.xiaoenai.app.classes.chat.messagelist.message.a.a b()
  {
    if (this.a != null) {
      return this.a.f();
    }
    return null;
  }
  
  public void c()
  {
    this.a.a();
  }
  
  public boolean d()
  {
    boolean bool = false;
    if (this.a != null) {
      bool = this.a.g();
    }
    return bool;
  }
  
  public void e()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public void f()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void g()
  {
    this.a.e();
    this.a = null;
    b = null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\h\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */