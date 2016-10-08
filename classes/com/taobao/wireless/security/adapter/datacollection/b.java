package com.taobao.wireless.security.adapter.datacollection;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.lang.reflect.Method;

public final class b
{
  private static Context a = null;
  
  public static String a()
  {
    try
    {
      Object localObject = a;
      if (localObject != null)
      {
        localObject = (WindowManager)((Context)localObject).getSystemService("window");
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
        localObject = localDisplayMetrics.heightPixels + "*" + localDisplayMetrics.widthPixels;
        return (String)localObject;
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static String a(File paramFile)
  {
    if (paramFile != null)
    {
      paramFile = new StatFs(paramFile.getPath());
      if (Build.VERSION.SDK_INT >= 18) {
        try
        {
          paramFile = (Long)paramFile.getClass().getDeclaredMethod("getTotalBytes", new Class[0]).invoke(paramFile, new Object[0]);
          if (paramFile != null)
          {
            paramFile = paramFile.toString();
            return paramFile;
          }
          return null;
        }
        catch (Throwable paramFile)
        {
          return null;
        }
      }
      long l1 = paramFile.getBlockSize();
      long l2 = paramFile.getBlockCount();
      return l2 * l1;
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    if ((paramContext != null) && (a == null)) {
      a = paramContext;
    }
  }
  
  public static String b()
  {
    try
    {
      Object localObject = Environment.getDataDirectory();
      if (localObject != null)
      {
        if (((File)localObject).getAbsolutePath().length() == 0) {
          return null;
        }
        localObject = a((File)localObject);
        return (String)localObject;
      }
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static String c()
  {
    try
    {
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        Object localObject = Environment.getExternalStorageDirectory();
        if (localObject != null)
        {
          if (((File)localObject).getAbsolutePath().length() == 0) {
            return null;
          }
          localObject = a((File)localObject);
          return (String)localObject;
        }
      }
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static String d()
  {
    try
    {
      Object localObject = a;
      if (localObject != null)
      {
        localObject = ((Context)localObject).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (localObject != null)
        {
          localObject = ((Intent)localObject).getIntExtra("level", -1);
          return (String)localObject;
        }
      }
    }
    catch (Exception localException) {}
    return "-1";
  }
  
  public static String e()
  {
    try
    {
      Object localObject = a;
      if (localObject != null)
      {
        localObject = ((Context)localObject).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (localObject != null)
        {
          localObject = ((Intent)localObject).getIntExtra("voltage", -1);
          return (String)localObject;
        }
      }
    }
    catch (Exception localException) {}
    return "-1";
  }
  
  public static String f()
  {
    try
    {
      Object localObject = a;
      if (localObject != null)
      {
        localObject = ((Context)localObject).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (localObject != null)
        {
          localObject = ((Intent)localObject).getIntExtra("temperature", -1);
          return (String)localObject;
        }
      }
    }
    catch (Exception localException) {}
    return "-1";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\datacollection\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */