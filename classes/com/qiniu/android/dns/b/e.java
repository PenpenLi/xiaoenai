package com.qiniu.android.dns.b;

import com.qiniu.android.dns.c;
import com.qiniu.android.dns.h;
import java.net.InetAddress;

public final class e
  implements com.qiniu.android.dns.d
{
  private final g a;
  
  public e(g paramg)
  {
    this.a = paramg;
  }
  
  public h[] a(c paramc, com.qiniu.android.dns.g paramg)
  {
    int j = 0;
    paramg = this.a.a(paramc, paramg);
    int k;
    if (paramc.b)
    {
      k = paramg.length;
      i = 0;
      if (i >= k) {
        break label165;
      }
      if (!paramg[i].a()) {}
    }
    label165:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        throw new d(paramc.a, this.a.a.getHostAddress());
        i += 1;
        break;
      }
      if (paramc.c != 0)
      {
        k = paramg.length;
        i = j;
        while (i < k)
        {
          Object localObject = paramg[i];
          if ((!((h)localObject).a()) && (((h)localObject).c > paramc.c)) {
            throw new d(paramc.a, this.a.a.getHostAddress(), ((h)localObject).c);
          }
          i += 1;
        }
      }
      return paramg;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\qiniu\android\dns\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */