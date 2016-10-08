package com.xiaoenai.app.net.http.a;

import b.ae;
import b.an;
import c.e;
import c.g;
import c.k;
import c.p;
import c.y;
import com.xiaoenai.app.net.http.base.a.b;
import java.io.IOException;

public class h
  extends an
{
  protected an a;
  protected b b;
  protected a c;
  
  public h(an paraman, b paramb)
  {
    this.a = paraman;
    this.b = paramb;
  }
  
  public ae a()
  {
    return this.a.a();
  }
  
  public void a(g paramg)
  {
    this.c = new a(paramg);
    paramg = p.a(this.c);
    this.a.a(paramg);
    paramg.flush();
  }
  
  public long b()
  {
    try
    {
      long l = this.a.b();
      return l;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return -1L;
  }
  
  protected final class a
    extends k
  {
    long a = 0L;
    private long c = 0L;
    
    public a(y paramy)
    {
      super();
    }
    
    public void a_(e parame, long paramLong)
    {
      super.a_(parame, paramLong);
      if (this.a == 0L) {
        this.a = h.this.b();
      }
      this.c += paramLong;
      if (h.this.b != null) {
        h.this.b.a(this.c, this.a);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */