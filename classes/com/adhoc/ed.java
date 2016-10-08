package com.adhoc;

import java.net.ProtocolException;

public final class ed
  implements ff
{
  private boolean a;
  private final int b;
  private final eo c = new eo();
  
  public ed()
  {
    this(-1);
  }
  
  public ed(int paramInt)
  {
    this.b = paramInt;
  }
  
  public fh a()
  {
    return fh.b;
  }
  
  public void a(ff paramff)
  {
    eo localeo = new eo();
    this.c.a(localeo, 0L, this.c.b());
    paramff.a_(localeo, localeo.b());
  }
  
  public void a_(eo parameo, long paramLong)
  {
    if (this.a) {
      throw new IllegalStateException("closed");
    }
    cb.a(parameo.b(), 0L, paramLong);
    if ((this.b != -1) && (this.c.b() > this.b - paramLong)) {
      throw new ProtocolException("exceeded content-length limit of " + this.b + " bytes");
    }
    this.c.a_(parameo, paramLong);
  }
  
  public long b()
  {
    return this.c.b();
  }
  
  public void close()
  {
    if (this.a) {}
    do
    {
      return;
      this.a = true;
    } while (this.c.b() >= this.b);
    throw new ProtocolException("content-length promised " + this.b + " bytes, but received " + this.c.b());
  }
  
  public void flush() {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */