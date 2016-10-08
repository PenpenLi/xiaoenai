package com.mob.tools.a;

import java.io.InputStream;

public abstract class c
{
  private long a;
  private p b;
  
  protected abstract InputStream a();
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(p paramp)
  {
    this.b = paramp;
  }
  
  protected abstract long b();
  
  public InputStream c()
  {
    a locala = new a(a());
    locala.a(this.b);
    if (this.a > 0L) {
      locala.skip(this.a);
    }
    return locala;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */