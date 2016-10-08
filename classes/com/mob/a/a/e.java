package com.mob.a.a;

import android.content.Context;
import com.mob.tools.b.i;

public class e
{
  private static e a;
  private i b;
  
  private e(Context paramContext)
  {
    this.b = new i(paramContext.getApplicationContext());
    this.b.a("mob_sdk_exception", 1);
  }
  
  public static e a(Context paramContext)
  {
    if (a == null) {
      a = new e(paramContext);
    }
    return a;
  }
  
  public long a()
  {
    return this.b.c("service_time");
  }
  
  public void a(long paramLong)
  {
    this.b.a("service_time", Long.valueOf(paramLong));
  }
  
  public void a(String paramString)
  {
    this.b.a("err_log_filter", paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    i locali = this.b;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      locali.a("is_upload_err_log", Integer.valueOf(i));
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.b.a("is_upload_crash", Boolean.valueOf(paramBoolean));
  }
  
  public boolean b()
  {
    return this.b.d("is_upload_err_log") == 0;
  }
  
  public void c(boolean paramBoolean)
  {
    this.b.a("is_upload_sdkerr", Boolean.valueOf(paramBoolean));
  }
  
  public boolean c()
  {
    return this.b.b("is_upload_crash");
  }
  
  public void d(boolean paramBoolean)
  {
    this.b.a("is_upload_apperr", Boolean.valueOf(paramBoolean));
  }
  
  public boolean d()
  {
    return this.b.b("is_upload_sdkerr");
  }
  
  public boolean e()
  {
    return this.b.b("is_upload_apperr");
  }
  
  public String f()
  {
    return this.b.a("err_log_filter");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */