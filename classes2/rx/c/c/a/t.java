package rx.c.c.a;

import sun.misc.Unsafe;

abstract class t<E>
  extends v<E>
{
  protected static final long f;
  protected long e;
  
  static
  {
    try
    {
      f = y.a.objectFieldOffset(t.class.getDeclaredField("e"));
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
  }
  
  public t(int paramInt)
  {
    super(paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */