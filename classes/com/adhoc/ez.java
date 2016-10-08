package com.adhoc;

import java.io.InputStream;

final class ez
  implements fg
{
  ez(fh paramfh, InputStream paramInputStream) {}
  
  public long a(eo parameo, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (paramLong == 0L) {
      return 0L;
    }
    this.a.g();
    fd localfd = parameo.e(1);
    int i = (int)Math.min(paramLong, 2048 - localfd.c);
    i = this.b.read(localfd.a, localfd.c, i);
    if (i == -1) {
      return -1L;
    }
    localfd.c += i;
    parameo.b += i;
    return i;
  }
  
  public fh a()
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */