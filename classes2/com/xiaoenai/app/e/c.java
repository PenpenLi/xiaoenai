package com.xiaoenai.app.e;

import com.d.a.a.f;
import com.d.a.a.k;
import com.xiaoenai.app.Xiaoenai;

public class c
{
  private static c a;
  
  public static c a()
  {
    try
    {
      if (a == null) {
        a = new c();
      }
      c localc = a;
      return localc;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, a.a parama)
  {
    com.xiaoenai.app.utils.f.a.c("{} {}", new Object[] { paramString1, paramString2 });
    k localk = new k(5);
    localk.b(false).a(false);
    Xiaoenai.j().a().a(new a(localk, paramString1, paramString2, parama));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */