package com.inmobi.commons.core.utilities.info;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static final String a = a.class.getSimpleName();
  private static a b;
  private static Object c = new Object();
  private String d;
  private String e;
  private String f;
  private String g;
  private Map<String, String> h = new HashMap();
  
  private a()
  {
    a(com.inmobi.commons.a.a.b());
    d();
  }
  
  public static a a()
  {
    Object localObject1 = b;
    if (localObject1 == null) {
      synchronized (c)
      {
        a locala2 = b;
        localObject1 = locala2;
        if (locala2 == null)
        {
          b = new a();
          localObject1 = b;
        }
        return (a)localObject1;
      }
    }
    return locala1;
  }
  
  private void a(Context paramContext)
  {
    try
    {
      Object localObject1 = paramContext.getPackageManager();
      Object localObject2 = ((PackageManager)localObject1).getApplicationInfo(paramContext.getPackageName(), 128);
      if (localObject2 != null)
      {
        this.d = ((ApplicationInfo)localObject2).packageName;
        this.e = ((ApplicationInfo)localObject2).loadLabel((PackageManager)localObject1).toString();
        this.g = ((PackageManager)localObject1).getInstallerPackageName(this.d);
      }
      localObject2 = ((PackageManager)localObject1).getPackageInfo(paramContext.getPackageName(), 128);
      paramContext = null;
      if (localObject2 != null)
      {
        localObject1 = ((PackageInfo)localObject2).versionName;
        if (localObject1 != null)
        {
          paramContext = (Context)localObject1;
          if (!((String)localObject1).equals("")) {}
        }
        else
        {
          paramContext = ((PackageInfo)localObject2).versionCode + "";
        }
      }
      if ((paramContext != null) && (!paramContext.equals(""))) {
        this.f = paramContext;
      }
      return;
    }
    catch (Exception paramContext)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to fetch app info completely", paramContext);
    }
  }
  
  private void d()
  {
    this.h.put("u-appbid", this.d);
    this.h.put("u-appdnm", this.e);
    this.h.put("u-appver", this.f);
  }
  
  public String b()
  {
    return this.g;
  }
  
  public Map<String, String> c()
  {
    return this.h;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\info\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */