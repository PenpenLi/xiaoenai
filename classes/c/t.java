package c;

final class t
  implements g
{
  public final e a;
  public final y b;
  private boolean c;
  
  public t(y paramy)
  {
    this(paramy, new e());
  }
  
  public t(y paramy, e parame)
  {
    if (paramy == null) {
      throw new IllegalArgumentException("sink == null");
    }
    this.a = parame;
    this.b = paramy;
  }
  
  public long a(z paramz)
  {
    if (paramz == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l1 = 0L;
    for (;;)
    {
      long l2 = paramz.a(this.a, 2048L);
      if (l2 == -1L) {
        break;
      }
      l1 += l2;
      u();
    }
    return l1;
  }
  
  public aa a()
  {
    return this.b.a();
  }
  
  public void a_(e parame, long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a_(parame, paramLong);
    u();
  }
  
  public g b(i parami)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(parami);
    return u();
  }
  
  public g b(String paramString)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(paramString);
    return u();
  }
  
  public e c()
  {
    return this.a;
  }
  
  public g c(byte[] paramArrayOfByte)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramArrayOfByte);
    return u();
  }
  
  public g c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramArrayOfByte, paramInt1, paramInt2);
    return u();
  }
  
  public void close()
  {
    if (this.c) {}
    do
    {
      return;
      localObject2 = null;
      localObject1 = localObject2;
      for (;;)
      {
        try
        {
          if (this.a.b > 0L)
          {
            this.b.a_(this.a, this.a.b);
            localObject1 = localObject2;
          }
        }
        catch (Throwable localThrowable1)
        {
          continue;
        }
        try
        {
          this.b.close();
          localObject2 = localObject1;
        }
        catch (Throwable localThrowable2)
        {
          localObject2 = localObject1;
          if (localObject1 != null) {
            continue;
          }
          localObject2 = localThrowable2;
        }
      }
      this.c = true;
    } while (localObject2 == null);
    ac.a((Throwable)localObject2);
  }
  
  public g e()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    long l = this.a.b();
    if (l > 0L) {
      this.b.a_(this.a, l);
    }
    return this;
  }
  
  public g f(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.d(paramInt);
    return u();
  }
  
  public void flush()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    if (this.a.b > 0L) {
      this.b.a_(this.a, this.a.b);
    }
    this.b.flush();
  }
  
  public g g(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.c(paramInt);
    return u();
  }
  
  public g h(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramInt);
    return u();
  }
  
  public g j(long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.i(paramLong);
    return u();
  }
  
  public g k(long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.h(paramLong);
    return u();
  }
  
  public String toString()
  {
    return "buffer(" + this.b + ")";
  }
  
  public g u()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    long l = this.a.h();
    if (l > 0L) {
      this.b.a_(this.a, l);
    }
    return this;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */