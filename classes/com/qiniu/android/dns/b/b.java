package com.qiniu.android.dns.b;

import com.qiniu.android.dns.c;
import com.qiniu.android.dns.h;
import java.io.IOException;
import java.net.InetAddress;

final class b
  implements com.qiniu.android.dns.d
{
  public h[] a(c paramc, com.qiniu.android.dns.g paramg)
  {
    InetAddress[] arrayOfInetAddress = a.b();
    if (arrayOfInetAddress == null) {
      arrayOfInetAddress = a.a();
    }
    for (;;)
    {
      if (arrayOfInetAddress == null) {
        throw new IOException("cant get local dns server");
      }
      paramg = new e(new g(arrayOfInetAddress[0])).a(paramc, paramg);
      int j;
      if (paramc.b)
      {
        j = paramg.length;
        i = 0;
        if (i >= j) {
          break label198;
        }
        if (!paramg[i].a()) {}
      }
      label198:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          throw new d(paramc.a, arrayOfInetAddress[0].getHostAddress());
          i += 1;
          break;
        }
        if (paramc.c != 0)
        {
          j = paramg.length;
          i = 0;
          while (i < j)
          {
            Object localObject = paramg[i];
            if ((!((h)localObject).a()) && (((h)localObject).c > paramc.c)) {
              throw new d(paramc.a, arrayOfInetAddress[0].getHostAddress(), ((h)localObject).c);
            }
            i += 1;
          }
        }
        return paramg;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\qiniu\android\dns\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */