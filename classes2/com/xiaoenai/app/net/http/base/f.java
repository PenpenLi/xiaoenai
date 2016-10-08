package com.xiaoenai.app.net.http.base;

import android.content.Context;

public final class f
{
  private static f b;
  private a a;
  
  public f(Context paramContext)
  {
    a(paramContext);
  }
  
  public static f a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new f(null);
      }
      return b;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    this.a = new com.xiaoenai.app.net.http.a.a();
  }
  
  public a b()
  {
    return this.a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\base\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */