package com.xiaoenai.app.net.http.a;

import com.xiaoenai.app.net.http.base.b;
import java.util.concurrent.TimeUnit;

public final class g
{
  public static void a(a parama, b paramb)
  {
    long l2 = 10000L;
    if (paramb != null)
    {
      if (paramb.a() <= 0L) {
        break label95;
      }
      l1 = paramb.a();
      parama.a(l1, TimeUnit.MILLISECONDS);
      if (paramb.b() <= 0L) {
        break label102;
      }
    }
    label95:
    label102:
    for (long l1 = paramb.b();; l1 = 10000L)
    {
      parama.b(l1, TimeUnit.MILLISECONDS);
      l1 = l2;
      if (paramb.c() > 0L) {
        l1 = paramb.c();
      }
      parama.c(l1, TimeUnit.MILLISECONDS);
      parama.a(paramb.d());
      parama.b(paramb.d());
      return;
      l1 = 10000L;
      break;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */