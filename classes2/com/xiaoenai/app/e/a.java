package com.xiaoenai.app.e;

import com.d.a.a.k;
import java.io.InputStream;
import java.io.Serializable;

public class a
  extends com.d.a.a.d
{
  private String a;
  private String b;
  private a c;
  private int d = 0;
  
  public a(k paramk, String paramString1, String paramString2, a parama)
  {
    super(paramk);
    this.a = paramString1;
    this.b = paramString2;
    this.c = parama;
    com.xiaoenai.app.utils.f.a.c("init", new Object[0]);
  }
  
  protected boolean a(Throwable paramThrowable)
  {
    com.xiaoenai.app.utils.f.a.b(true, "shouldReRunOnThrowable: {}", new Object[] { paramThrowable.getMessage() });
    com.xiaoenai.app.utils.a.d.e(this.b);
    return this.d <= 1;
  }
  
  public void b()
  {
    this.c.a();
  }
  
  public void c()
  {
    com.xiaoenai.app.utils.f.a.c("run", new Object[0]);
    InputStream localInputStream = new com.xiaoenai.app.e.a.a().a(this.a, null);
    com.xiaoenai.app.utils.a.d.a(this.b, localInputStream, new b(this));
    this.c.b();
    this.d += 1;
  }
  
  protected void d()
  {
    com.xiaoenai.app.utils.f.a.a(true, "onCancel fileUrl = {} fileName = {}", new Object[] { this.a, this.b });
    this.c.c();
  }
  
  protected int g()
  {
    return 2;
  }
  
  public static abstract interface a
    extends Serializable
  {
    public abstract void a();
    
    public abstract void a(int paramInt1, int paramInt2);
    
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */