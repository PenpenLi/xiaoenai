package b.a.b;

import c.aa;
import c.e;
import c.g;
import c.h;
import c.z;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

class l
  implements z
{
  boolean a;
  
  l(j paramj, h paramh, a parama, g paramg) {}
  
  public long a(e parame, long paramLong)
  {
    try
    {
      paramLong = this.b.a(parame, paramLong);
      if (paramLong == -1L)
      {
        if (!this.a)
        {
          this.a = true;
          this.d.close();
        }
        return -1L;
      }
    }
    catch (IOException parame)
    {
      if (!this.a)
      {
        this.a = true;
        this.c.b();
      }
      throw parame;
    }
    parame.a(this.d.c(), parame.b() - paramLong, paramLong);
    this.d.u();
    return paramLong;
  }
  
  public aa a()
  {
    return this.b.a();
  }
  
  public void close()
  {
    if ((!this.a) && (!b.a.j.a(this, 100, TimeUnit.MILLISECONDS)))
    {
      this.a = true;
      this.c.b();
    }
    this.b.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */