package com.adhoc;

final class fb
  implements ep
{
  public final eo a;
  public final ff b;
  private boolean c;
  
  public fb(ff paramff)
  {
    this(paramff, new eo());
  }
  
  public fb(ff paramff, eo parameo)
  {
    if (paramff == null) {
      throw new IllegalArgumentException("sink == null");
    }
    this.a = parameo;
    this.b = paramff;
  }
  
  public long a(fg paramfg)
  {
    if (paramfg == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l1 = 0L;
    for (;;)
    {
      long l2 = paramfg.a(this.a, 2048L);
      if (l2 == -1L) {
        break;
      }
      l1 += l2;
      t();
    }
    return l1;
  }
  
  public fh a()
  {
    return this.b.a();
  }
  
  public void a_(eo parameo, long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a_(parameo, paramLong);
    t();
  }
  
  public ep b(er paramer)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(paramer);
    return t();
  }
  
  public ep b(String paramString)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.a(paramString);
    return t();
  }
  
  public eo c()
  {
    return this.a;
  }
  
  public ep c(byte[] paramArrayOfByte)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramArrayOfByte);
    return t();
  }
  
  public ep c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramArrayOfByte, paramInt1, paramInt2);
    return t();
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
    fj.a((Throwable)localObject2);
  }
  
  public ep e()
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
  
  public ep f(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.d(paramInt);
    return t();
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
  
  public ep g(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.c(paramInt);
    return t();
  }
  
  public ep h(int paramInt)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.b(paramInt);
    return t();
  }
  
  public ep i(long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    this.a.h(paramLong);
    return t();
  }
  
  public ep t()
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    long l = this.a.g();
    if (l > 0L) {
      this.b.a_(this.a, l);
    }
    return this;
  }
  
  public String toString()
  {
    return "buffer(" + this.b + ")";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */