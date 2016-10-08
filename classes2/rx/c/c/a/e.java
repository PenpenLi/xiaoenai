package rx.c.c.a;

import sun.misc.Unsafe;

abstract class e<E>
  extends g<E>
{
  private static final long e;
  private volatile long f;
  
  static
  {
    try
    {
      e = y.a.objectFieldOffset(e.class.getDeclaredField("f"));
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
  }
  
  public e(int paramInt)
  {
    super(paramInt);
  }
  
  protected final long a()
  {
    return this.f;
  }
  
  protected final boolean b(long paramLong1, long paramLong2)
  {
    return y.a.compareAndSwapLong(this, e, paramLong1, paramLong2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */