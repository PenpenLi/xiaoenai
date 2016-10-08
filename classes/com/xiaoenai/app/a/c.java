package com.xiaoenai.app.a;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

public class c
{
  private static c b;
  public boolean a = true;
  private d c;
  
  private c(Context paramContext, boolean paramBoolean)
  {
    this.c = new d(paramContext, 1, paramContext.getPackageName());
    this.a = paramBoolean;
  }
  
  public static b a(long paramLong)
  {
    b localb = new b();
    localb.a(paramLong);
    return localb;
  }
  
  private void a(ContentValues paramContentValues)
  {
    this.c.a(paramContentValues);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new c(paramContext, paramBoolean);
        }
        return;
      }
      finally {}
    }
  }
  
  public static void a(b paramb)
  {
    if (b != null)
    {
      if (b.a) {
        Log.d("xiaoenai", "HttpAnalyticsEntity: " + paramb);
      }
      if (paramb != null)
      {
        paramb = paramb.a();
        b.a(paramb);
      }
    }
  }
  
  public static boolean a()
  {
    return b != null;
  }
  
  public static void b()
  {
    try
    {
      if ((b != null) && (b.c != null))
      {
        b.c.close();
        b.c = null;
        b = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */