package rx.c.a;

import java.util.concurrent.atomic.AtomicLong;

public final class a
{
  public static long a(AtomicLong paramAtomicLong, long paramLong)
  {
    long l3;
    long l1;
    do
    {
      l3 = paramAtomicLong.get();
      long l2 = l3 + paramLong;
      l1 = l2;
      if (l2 < 0L) {
        l1 = Long.MAX_VALUE;
      }
    } while (!paramAtomicLong.compareAndSet(l3, l1));
    return l3;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */