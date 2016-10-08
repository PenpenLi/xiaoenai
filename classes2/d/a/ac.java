package d.a;

import android.content.Context;
import com.f.a.a;
import com.f.a.e;
import com.f.a.o;

public class ac
  implements s
{
  private static ac l = null;
  private final long a = 1296000000L;
  private final long b = 129600000L;
  private final int c = 1800000;
  private final int d = 10000;
  private o e;
  private x f;
  private long g = 1296000000L;
  private int h = 10000;
  private long i = 0L;
  private long j = 0L;
  private Context k;
  
  private ac(Context paramContext, x paramx)
  {
    this.k = paramContext;
    this.e = o.a(paramContext);
    this.f = paramx;
  }
  
  public static ac a(Context paramContext, x paramx)
  {
    try
    {
      if (l == null)
      {
        l = new ac(paramContext, paramx);
        l.a(dk.a(paramContext).b());
      }
      paramContext = l;
      return paramContext;
    }
    finally {}
  }
  
  public void a(dk.a parama)
  {
    this.g = parama.a(1296000000L);
    int m = parama.b(0);
    if (m == 0)
    {
      if ((a.k <= 0) || (a.k > 1800000))
      {
        this.h = 10000;
        return;
      }
      this.h = a.k;
      return;
    }
    this.h = m;
  }
  
  public boolean a()
  {
    if (this.e.g()) {}
    long l1;
    do
    {
      do
      {
        return false;
      } while (this.f.e());
      l1 = System.currentTimeMillis() - this.f.n();
      if (l1 > this.g)
      {
        String str = dg.a(this.k);
        this.i = e.a(this.h, str);
        this.j = l1;
        return true;
      }
    } while (l1 <= 129600000L);
    this.i = 0L;
    this.j = l1;
    return true;
  }
  
  public long b()
  {
    return this.i;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */