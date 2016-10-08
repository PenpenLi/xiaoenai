package rx.c.c.a;

import sun.misc.Unsafe;

abstract class h<E>
  extends f<E>
{
  private static final long e;
  private volatile long f;
  
  static
  {
    try
    {
      e = y.a.objectFieldOffset(h.class.getDeclaredField("f"));
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
  }
  
  public h(int paramInt)
  {
    super(paramInt);
  }
  
  protected final long b()
  {
    return this.f;
  }
  
  protected final boolean c(long paramLong1, long paramLong2)
  {
    return y.a.compareAndSwapLong(this, e, paramLong1, paramLong2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */