package com.mob.tools.a;

import java.io.InputStream;

public class a
  extends InputStream
{
  private InputStream a;
  private long b;
  private p c;
  
  public a(InputStream paramInputStream)
  {
    this.a = paramInputStream;
  }
  
  public void a(p paramp)
  {
    this.c = paramp;
  }
  
  public int available()
  {
    return this.a.available();
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void mark(int paramInt)
  {
    this.a.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.a.markSupported();
  }
  
  public int read()
  {
    int i = this.a.read();
    if (i >= 0)
    {
      this.b += 1L;
      if (this.c != null) {
        this.c.a(this.b);
      }
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 > 0)
    {
      this.b += paramInt1;
      if (this.c != null) {
        this.c.a(this.b);
      }
    }
    return paramInt1;
  }
  
  public void reset()
  {
    try
    {
      this.a.reset();
      this.b = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long skip(long paramLong)
  {
    return this.a.skip(paramLong);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */