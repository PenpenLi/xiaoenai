package rx.c.c.a;

import sun.misc.Unsafe;

abstract class p<E>
  extends l<E>
{
  protected static final long e;
  private volatile long d;
  
  static
  {
    try
    {
      e = y.a.objectFieldOffset(p.class.getDeclaredField("d"));
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
  }
  
  public p(int paramInt)
  {
    super(paramInt);
  }
  
  protected final long b()
  {
    return this.d;
  }
  
  protected final void d(long paramLong)
  {
    y.a.putOrderedLong(this, e, paramLong);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */