package c;

final class w
{
  final byte[] a;
  int b;
  int c;
  boolean d;
  boolean e;
  w f;
  w g;
  
  w()
  {
    this.a = new byte['ࠀ'];
    this.e = true;
    this.d = false;
  }
  
  w(w paramw)
  {
    this(paramw.a, paramw.b, paramw.c);
    paramw.d = true;
  }
  
  w(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.e = false;
    this.d = true;
  }
  
  public w a()
  {
    if (this.f != this) {}
    for (w localw = this.f;; localw = null)
    {
      this.g.f = this.f;
      this.f.g = this.g;
      this.f = null;
      this.g = null;
      return localw;
    }
  }
  
  public w a(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.c - this.b)) {
      throw new IllegalArgumentException();
    }
    w localw = new w(this);
    localw.c = (localw.b + paramInt);
    this.b += paramInt;
    this.g.a(localw);
    return localw;
  }
  
  public w a(w paramw)
  {
    paramw.g = this;
    paramw.f = this.f;
    this.f.g = paramw;
    this.f = paramw;
    return paramw;
  }
  
  public void a(w paramw, int paramInt)
  {
    if (!paramw.e) {
      throw new IllegalArgumentException();
    }
    if (paramw.c + paramInt > 2048)
    {
      if (paramw.d) {
        throw new IllegalArgumentException();
      }
      if (paramw.c + paramInt - paramw.b > 2048) {
        throw new IllegalArgumentException();
      }
      System.arraycopy(paramw.a, paramw.b, paramw.a, 0, paramw.c - paramw.b);
      paramw.c -= paramw.b;
      paramw.b = 0;
    }
    System.arraycopy(this.a, this.b, paramw.a, paramw.c, paramInt);
    paramw.c += paramInt;
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
        x.a(this);
        return;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */