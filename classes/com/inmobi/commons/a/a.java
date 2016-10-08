package com.inmobi.commons.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.webkit.WebSettings;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.b;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  private static final String a = a.class.getSimpleName();
  private static Context b;
  private static String c = "";
  private static String d = "";
  private static AtomicBoolean e = new AtomicBoolean();
  
  public static File a(Context paramContext)
  {
    return new File(paramContext.getCacheDir(), "im_cached_content");
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    if (!(paramContext instanceof Activity)) {
      paramIntent.setFlags(268435456);
    }
    paramContext.startActivity(paramIntent);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (!a())
    {
      b = paramContext.getApplicationContext();
      d = paramString;
      e.set(true);
      b(paramContext);
      c(paramContext);
    }
  }
  
  public static void a(File paramFile, String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() != 0))
    {
      b.a(new File(paramFile, paramString));
      return;
    }
    b.a(paramFile);
  }
  
  public static void a(boolean paramBoolean)
  {
    e.set(paramBoolean);
  }
  
  public static boolean a()
  {
    return b != null;
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = b();
    if (localObject == null) {}
    do
    {
      return false;
      localObject = ((Context)localObject).getPackageManager();
      if (Build.VERSION.SDK_INT >= 23) {
        break;
      }
    } while (((PackageManager)localObject).checkPermission(paramString, ((PackageManager)localObject).getNameForUid(Binder.getCallingUid())) != 0);
    return true;
    return b(paramString);
  }
  
  public static Context b()
  {
    return b;
  }
  
  public static void b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      c = d(paramContext);
      return;
    }
    new Handler(paramContext.getMainLooper()).post(new a.1(paramContext));
  }
  
  public static boolean b(String paramString)
  {
    Object localObject = b();
    if (localObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 4096);
        if (((PackageInfo)localObject).requestedPermissions == null) {
          continue;
        }
        localObject = ((PackageInfo)localObject).requestedPermissions;
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = localObject[i].equals(paramString);
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Could not check manifest for permission:" + paramString + " Error:" + localNameNotFoundException.getLocalizedMessage());
      }
    }
  }
  
  public static String c()
  {
    return d;
  }
  
  private static void c(Context paramContext)
  {
    paramContext = a(paramContext);
    a(paramContext, null);
    if ((!paramContext.mkdir()) && (!paramContext.isDirectory())) {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Cannot create media cache directory");
    }
  }
  
  public static String d()
  {
    return c;
  }
  
  @TargetApi(17)
  private static String d(Context paramContext)
  {
    return WebSettings.getDefaultUserAgent(paramContext.getApplicationContext());
  }
  
  public static boolean e()
  {
    return e.get();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */