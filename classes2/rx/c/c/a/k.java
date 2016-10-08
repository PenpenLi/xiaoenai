package rx.c.c.a;

import sun.misc.Unsafe;

abstract class k<E>
  extends m<E>
{
  protected static final long d;
  private volatile long f;
  
  static
  {
    try
    {
      d = y.a.objectFieldOffset(k.class.getDeclaredField("f"));
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
  }
  
  public k(int paramInt)
  {
    super(paramInt);
  }
  
  protected final long a()
  {
    return this.f;
  }
  
  protected final boolean b(long paramLong1, long paramLong2)
  {
    return y.a.compareAndSwapLong(this, d, paramLong1, paramLong2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */