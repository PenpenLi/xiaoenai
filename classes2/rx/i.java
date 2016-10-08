package rx;

import java.util.concurrent.TimeUnit;
import rx.b.a;
import rx.h.c;

public abstract class i
{
  public abstract a a();
  
  public static abstract class a
    implements l
  {
    public long a()
    {
      return System.currentTimeMillis();
    }
    
    public abstract l a(a parama);
    
    public l a(a parama, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      paramLong2 = paramTimeUnit.toNanos(paramLong2);
      long l1 = TimeUnit.MILLISECONDS.toNanos(a());
      long l2 = paramTimeUnit.toNanos(paramLong1);
      c localc1 = new c();
      parama = new j(this, localc1, parama, l1 + l2, paramLong2);
      c localc2 = new c();
      localc1.a(localc2);
      localc2.a(a(parama, paramLong1, paramTimeUnit));
      return localc1;
    }
    
    public abstract l a(a parama, long paramLong, TimeUnit paramTimeUnit);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */