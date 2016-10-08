package c;

import java.io.OutputStream;

final class q
  implements y
{
  q(aa paramaa, OutputStream paramOutputStream) {}
  
  public aa a()
  {
    return this.a;
  }
  
  public void a_(e parame, long paramLong)
  {
    ac.a(parame.b, 0L, paramLong);
    while (paramLong > 0L)
    {
      this.a.g();
      w localw = parame.a;
      int i = (int)Math.min(paramLong, localw.c - localw.b);
      this.b.write(localw.a, localw.b, i);
      localw.b += i;
      long l = paramLong - i;
      parame.b -= i;
      paramLong = l;
      if (localw.b == localw.c)
      {
        parame.a = localw.a();
        x.a(localw);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */