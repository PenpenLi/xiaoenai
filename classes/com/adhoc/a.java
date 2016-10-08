package com.adhoc;

import android.content.Context;
import android.content.pm.PackageManager;
import com.adhoc.adhocsdk.AdhocTracker;
import java.util.Locale;
import java.util.UUID;

public class a
{
  private static a a = null;
  private String b;
  private Context c;
  
  private a(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {
      a = new a(paramContext);
    }
    return a;
  }
  
  private String c()
  {
    String str = UUID.randomUUID().toString().toLowerCase(Locale.ENGLISH);
    try
    {
      a(str);
      this.b = str;
      fl.a("生成新的clientid " + str);
      return str;
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
    }
    return str;
  }
  
  private void d()
  {
    if (this.c.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.c.getPackageName()) != 0) {
      fl.b("请注册SDCARD读写权限");
    }
  }
  
  public String a()
  {
    if ((AdhocTracker.client_id != null) && (!AdhocTracker.client_id.equals("")))
    {
      fl.a("get Client_Id from custom" + AdhocTracker.client_id);
      return AdhocTracker.client_id;
    }
    if ((this.b != null) && (!this.b.equals("")))
    {
      fl.a("内存中取到clientid:" + this.b);
      return this.b;
    }
    try
    {
      String str = b();
      if ((str != null) && (!str.equals("")))
      {
        this.b = str;
        fl.a("SDCARD取到clientid:" + str);
        return this.b;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fl.b("get client from sdcard error");
        Object localObject = null;
      }
    }
    return c();
  }
  
  public void a(String paramString)
  {
    if (ad.a(this.c).a(paramString)) {
      fl.a("写ClientID成功");
    }
  }
  
  public String b()
  {
    try
    {
      d();
      return ad.a(this.c).a();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fl.a(localThrowable);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */