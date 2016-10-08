package rx.c.c.a;

import sun.misc.Unsafe;

public final class r<E>
  extends w<E>
{
  public r(int paramInt)
  {
    super(paramInt);
  }
  
  private long a()
  {
    return y.a.getLongVolatile(this, g);
  }
  
  private long b()
  {
    return y.a.getLongVolatile(this, f);
  }
  
  private void d(long paramLong)
  {
    y.a.putOrderedLong(this, g, paramLong);
  }
  
  private void e(long paramLong)
  {
    y.a.putOrderedLong(this, f, paramLong);
  }
  
  public boolean offer(E paramE)
  {
    Object[] arrayOfObject = this.c;
    long l1 = this.h;
    long l2 = a(l1);
    if (b(arrayOfObject, l2) != null) {
      return false;
    }
    d(l1 + 1L);
    b(arrayOfObject, l2, paramE);
    return true;
  }
  
  public E peek()
  {
    return (E)c(a(this.e));
  }
  
  public E poll()
  {
    long l1 = this.e;
    long l2 = a(l1);
    Object[] arrayOfObject = this.c;
    Object localObject = b(arrayOfObject, l2);
    if (localObject == null) {
      return null;
    }
    e(l1 + 1L);
    b(arrayOfObject, l2, null);
    return (E)localObject;
  }
  
  public int size()
  {
    long l2;
    for (long l1 = b();; l1 = l2)
    {
      long l3 = a();
      l2 = b();
      if (l1 == l2) {
        return (int)(l3 - l2);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */