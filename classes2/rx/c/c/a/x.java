package rx.c.c.a;

import sun.misc.Unsafe;

abstract class x<E>
  extends u<E>
{
  protected static final long g;
  protected long h;
  
  static
  {
    try
    {
      g = y.a.objectFieldOffset(x.class.getDeclaredField("h"));
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
  }
  
  public x(int paramInt)
  {
    super(paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\a\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */