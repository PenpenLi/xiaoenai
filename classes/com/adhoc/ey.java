package com.adhoc;

import java.io.OutputStream;

final class ey
  implements ff
{
  ey(fh paramfh, OutputStream paramOutputStream) {}
  
  public fh a()
  {
    return this.a;
  }
  
  public void a_(eo parameo, long paramLong)
  {
    fj.a(parameo.b, 0L, paramLong);
    while (paramLong > 0L)
    {
      this.a.g();
      fd localfd = parameo.a;
      int i = (int)Math.min(paramLong, localfd.c - localfd.b);
      this.b.write(localfd.a, localfd.b, i);
      localfd.b += i;
      long l = paramLong - i;
      parameo.b -= i;
      paramLong = l;
      if (localfd.b == localfd.c)
      {
        parameo.a = localfd.a();
        fe.a(localfd);
        paramLong = l;
      }
    }
  }
  
  public void close()
  {
    this.b.close();
  }
  
  public void flush()
  {
    this.b.flush();
  }
  
  public String toString()
  {
    return "sink(" + this.b + ")";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */