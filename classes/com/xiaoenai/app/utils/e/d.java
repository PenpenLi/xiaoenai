package com.xiaoenai.app.utils.e;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap.Config;
import com.xiaoenai.app.utils.e.a.c;
import com.xiaoenai.app.utils.e.c.d.a;
import com.xiaoenai.app.utils.e.c.e;
import com.xiaoenai.app.utils.e.c.f;
import com.xiaoenai.app.utils.e.c.f.a;

public final class d
{
  private static com.xiaoenai.app.utils.e.c.a a = null;
  
  private static int a(Context paramContext)
  {
    return ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
  }
  
  public static void a()
  {
    if (a != null) {
      a.c();
    }
  }
  
  public static void a(Context paramContext, com.xiaoenai.app.utils.e.e.a parama)
  {
    int i = 2097152;
    int j = 3;
    int k = Math.round(0.16666667F * a(paramContext) * 1024.0F * 1024.0F);
    com.xiaoenai.app.utils.f.a.c("1/6 cacheSize = {}", new Object[] { Integer.valueOf(k) });
    if (k < 2097152) {
      j = 1;
    }
    for (;;)
    {
      com.xiaoenai.app.utils.f.a.c("cacheSize = {} maxThreadSize = {}", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      a(new f.a(paramContext).b(1).c(268435456).a(j).d(2048).e(i).a(parama).a(new d.a().a(false).b(true).c(true).a(Bitmap.Config.RGB_565).a(c.c).a()).a());
      return;
      i = 16777216;
    }
  }
  
  public static void a(f paramf)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = e.a(paramf);
        }
        return;
      }
      finally {}
    }
  }
  
  public static com.xiaoenai.app.utils.e.c.a b()
  {
    if (a == null) {
      a(null);
    }
    return a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */