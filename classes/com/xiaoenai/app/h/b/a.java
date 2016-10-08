package com.xiaoenai.app.h.b;

import android.app.Activity;
import android.app.Application;

public final class a
{
  public static final String[] a = { "62054852", "61888880", "62086728", "62088567" };
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, com.xiaoenai.app.h.b.b.a parama)
  {
    if ((paramInt1 >= 0) && (paramInt1 < a.length))
    {
      com.xiaoenai.app.utils.f.a.c("index {} slotId = {}", new Object[] { Integer.valueOf(paramInt1), a[paramInt1] });
      com.xiaoenai.app.h.b.c.a.a(paramActivity, a[paramInt1], paramInt2, paramInt3, parama);
      return;
    }
    if (paramInt1 >= a.length) {
      paramInt1 %= a.length;
    }
    for (;;)
    {
      String str = a[paramInt1];
      com.xiaoenai.app.utils.f.a.c("index {} slotId = {}", new Object[] { Integer.valueOf(paramInt1), str });
      com.xiaoenai.app.h.b.c.a.a(paramActivity, str, paramInt2, paramInt3, parama);
      return;
      paramInt1 = 0;
    }
  }
  
  public static void a(Application paramApplication)
  {
    com.xiaoenai.app.h.b.c.a.a(paramApplication);
  }
  
  public static void a(Class<? extends Activity> paramClass)
  {
    com.xiaoenai.app.h.b.c.a.a(paramClass);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\h\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */