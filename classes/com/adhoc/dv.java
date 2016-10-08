package com.adhoc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

class dv
  implements fg
{
  boolean a;
  
  dv(dt paramdt, eq parameq, dk paramdk, ep paramep) {}
  
  public long a(eo parameo, long paramLong)
  {
    try
    {
      paramLong = this.b.a(parameo, paramLong);
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
    catch (IOException parameo)
    {
      if (!this.a)
      {
        this.a = true;
        this.c.b();
      }
      throw parameo;
    }
    parameo.a(this.d.c(), parameo.b() - paramLong, paramLong);
    this.d.t();
    return paramLong;
  }
  
  public fh a()
  {
    return this.b.a();
  }
  
  public void close()
  {
    if ((!this.a) && (!cb.a(this, 100, TimeUnit.MILLISECONDS)))
    {
      this.a = true;
      this.c.b();
    }
    this.b.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */