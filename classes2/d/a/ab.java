package d.a;

import android.content.Context;
import java.util.List;

public class ab
  implements s
{
  private static ab c = null;
  private int a = 0;
  private final long b = 60000L;
  
  public static ab a(Context paramContext)
  {
    try
    {
      if (c == null)
      {
        c = new ab();
        int i = dk.a(paramContext).b().a(0);
        c.a(i);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public long a()
  {
    switch (this.a)
    {
    default: 
      return 0L;
    case 1: 
      return 14400000L;
    case 2: 
      return 28800000L;
    }
    return 86400000L;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 3)) {
      this.a = paramInt;
    }
  }
  
  public void a(dk.a parama)
  {
    a(parama.a(0));
  }
  
  public void a(z paramz, Context paramContext)
  {
    if (this.a == 1)
    {
      paramz.b.i = null;
      paramz.b.a = null;
      paramz.b.b = null;
      paramz.b.h = null;
    }
    do
    {
      return;
      if (this.a == 2)
      {
        paramz.b.c.clear();
        paramz.b.c.add(b(paramContext));
        paramz.b.i = null;
        paramz.b.a = null;
        paramz.b.b = null;
        paramz.b.h = null;
        return;
      }
    } while (this.a != 3);
    paramz.b.c = null;
    paramz.b.i = null;
    paramz.b.a = null;
    paramz.b.b = null;
    paramz.b.h = null;
  }
  
  public z.n b(Context paramContext)
  {
    z.n localn = new z.n();
    localn.b = w.g(paramContext);
    long l = System.currentTimeMillis();
    localn.c = l;
    localn.d = (l + 60000L);
    localn.e = 60000L;
    return localn;
  }
  
  public boolean b()
  {
    return this.a != 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */