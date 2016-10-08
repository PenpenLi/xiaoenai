package com.adhoc;

final class fd
{
  final byte[] a;
  int b;
  int c;
  boolean d;
  boolean e;
  fd f;
  fd g;
  
  fd()
  {
    this.a = new byte['ࠀ'];
    this.e = true;
    this.d = false;
  }
  
  fd(fd paramfd)
  {
    this(paramfd.a, paramfd.b, paramfd.c);
    paramfd.d = true;
  }
  
  fd(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.e = false;
    this.d = true;
  }
  
  public fd a()
  {
    if (this.f != this) {}
    for (fd localfd = this.f;; localfd = null)
    {
      this.g.f = this.f;
      this.f.g = this.g;
      this.f = null;
      this.g = null;
      return localfd;
    }
  }
  
  public fd a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.c - this.b)) {
      throw new IllegalArgumentException();
    }
    fd localfd = new fd(this);
    localfd.c = (localfd.b + paramInt);
    this.b += paramInt;
    this.g.a(localfd);
    return localfd;
  }
  
  public fd a(fd paramfd)
  {
    paramfd.g = this;
    paramfd.f = this.f;
    this.f.g = paramfd;
    this.f = paramfd;
    return paramfd;
  }
  
  public void a(fd paramfd, int paramInt)
  {
    if (!paramfd.e) {
      throw new IllegalArgumentException();
    }
    if (paramfd.c + paramInt > 2048)
    {
      if (paramfd.d) {
        throw new IllegalArgumentException();
      }
      if (paramfd.c + paramInt - paramfd.b > 2048) {
        throw new IllegalArgumentException();
      }
      System.arraycopy(paramfd.a, paramfd.b, paramfd.a, 0, paramfd.c - paramfd.b);
      paramfd.c -= paramfd.b;
      paramfd.b = 0;
    }
    System.arraycopy(this.a, this.b, paramfd.a, paramfd.c, paramInt);
    paramfd.c += paramInt;
    this.b += paramInt;
  }
  
  public void b()
  {
    if (this.g == this) {
      throw new IllegalStateException();
    }
    if (!this.g.e) {}
    for (;;)
    {
      return;
      int j = this.c - this.b;
      int k = this.g.c;
      if (this.g.d) {}
      for (int i = 0; j <= i + (2048 - k); i = this.g.b)
      {
        a(this.g, j);
        a();
        fe.a(this);
        return;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\fd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */