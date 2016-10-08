package c;

import java.io.InputStream;

final class r
  implements z
{
  r(aa paramaa, InputStream paramInputStream) {}
  
  public long a(e parame, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (paramLong == 0L) {
      return 0L;
    }
    this.a.g();
    w localw = parame.e(1);
    int i = (int)Math.min(paramLong, 2048 - localw.c);
    i = this.b.read(localw.a, localw.c, i);
    if (i == -1) {
      return -1L;
    }
    localw.c += i;
    parame.b += i;
    return i;
  }
  
  public aa a()
  {
    return this.a;
  }
  
  public void close()
  {
    this.b.close();
  }
  
  public String toString()
  {
    return "source(" + this.b + ")";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */