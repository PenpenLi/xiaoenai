package rx.c.c.a;

import java.util.Iterator;
import sun.misc.Unsafe;

public abstract class a<E>
  extends b<E>
{
  protected static final int a = Integer.getInteger("sparse.shift", 0).intValue();
  private static final long d;
  private static final int e;
  protected final long b;
  protected final E[] c;
  
  static
  {
    int i = y.a.arrayIndexScale(Object[].class);
    if (4 == i) {}
    for (e = a + 2;; e = a + 3)
    {
      d = y.a.arrayBaseOffset(Object[].class) + (32 << e - a);
      return;
      if (8 != i) {
        break;
      }
    }
    throw new IllegalStateException("Unknown pointer size");
  }
  
  public a(int paramInt)
  {
    paramInt = i.a(paramInt);
    this.b = (paramInt - 1);
    this.c = ((Object[])new Object[(paramInt << a) + 64]);
  }
  
  protected final long a(long paramLong)
  {
    return a(paramLong, this.b);
  }
  
  protected final long a(long paramLong1, long paramLong2)
  {
    return d + ((paramLong1 & paramLong2) << e);
  }
  
  protected final E a(E[] paramArrayOfE, long paramLong)
  {
    return (E)y.a.getObject(paramArrayOfE, paramLong);
  }
  
  protected final void a(long paramLong, E paramE)
  {
    a(this.c, paramLong, paramE);
  }
  
  protected final void a(E[] paramArrayOfE, long paramLong, E paramE)
  {
    y.a.putObject(paramArrayOfE, paramLong, paramE);
  }
  
  protected final E b(long paramLong)
  {
    return (E)a(this.c, paramLong);
  }
  
  protected final E b(E[] paramArrayOfE, long paramLong)
  {
    return (E)y.a.getObjectVolatile(paramArrayOfE, paramLong);
  }
  
  protected final void b(E[] paramArrayOfE, long paramLong, E paramE)
  {
    y.a.putOrderedObject(paramArrayOfE, paramLong, paramE);
  }
  
  protected final E c(long paramLong)
  {
    return (E)b(this.c, paramLong);
  }
  
  public void clear()
  {
    while ((poll() != null) || (!isEmpty())) {}
  }
  
  public Iterator<E> iterator()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */