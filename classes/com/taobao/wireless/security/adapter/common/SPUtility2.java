package com.taobao.wireless.security.adapter.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.provider.Settings.System;

public class SPUtility2
{
  private static Context a = null;
  private static e b = null;
  
  private static SharedPreferences a(Context paramContext, String paramString)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 11) {
      i = 4;
    }
    return paramContext.getSharedPreferences(paramString, i);
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    Context localContext = a;
    String str = paramString3;
    if (localContext != null)
    {
      str = paramString3;
      if (paramString2 != null)
      {
        str = paramString3;
        if (paramString2.length() > 0)
        {
          str = paramString3;
          if (paramString1 != null)
          {
            str = paramString3;
            if (paramString1.length() > 0)
            {
              paramString1 = a(localContext, paramString1);
              str = paramString3;
              if (paramString1 == null) {}
            }
          }
        }
      }
    }
    try
    {
      str = paramString1.getString(paramString2, paramString3);
      return str;
    }
    catch (Exception paramString1) {}
    return paramString3;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    Context localContext = a;
    boolean bool1 = bool2;
    if (localContext != null)
    {
      bool1 = bool2;
      if (paramString2 != null)
      {
        bool1 = bool2;
        if (paramString2.length() > 0)
        {
          bool1 = bool2;
          if (paramString1 != null)
          {
            bool1 = bool2;
            if (paramString1.length() > 0)
            {
              paramString1 = a(localContext, paramString1);
              bool1 = bool2;
              if (paramString1 != null)
              {
                paramString1 = paramString1.edit();
                paramString1.remove(paramString2);
                bool1 = paramString1.commit();
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static void init(Context paramContext)
  {
    if (paramContext != null)
    {
      a = paramContext.getApplicationContext();
      b = new e(paramContext, "sp.lock");
    }
  }
  
  public static String readFromSPUnified(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    String str = paramString3;
    if (paramString2 != null)
    {
      str = paramString3;
      if (paramString2.length() > 0)
      {
        str = paramString3;
        if (paramString1 != null)
        {
          str = paramString3;
          if (paramString1.length() > 0) {
            str = paramString3;
          }
        }
      }
    }
    label152:
    for (;;)
    {
      try
      {
        if (b.a() == true)
        {
          str = a("SGMANAGER_DATA", paramString1 + "_" + paramString2, paramString3);
          if ((str != null) || (paramString3 != null)) {
            continue;
          }
          if (i == 0) {
            break label152;
          }
          str = a(paramString1, paramString2, paramString3);
        }
      }
      finally
      {
        boolean bool;
        b.b();
      }
      try
      {
        b.b();
        return str;
      }
      finally {}
      if ((str != null) && (paramString3 != null))
      {
        bool = str.equals(paramString3);
        if (bool) {}
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public static String readSS(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      try
      {
        if (((Build.VERSION.SDK_INT < 23) || (paramContext.getApplicationInfo().targetSdkVersion < 23)) && (paramString != null) && (paramString.length() > 0))
        {
          paramContext = Settings.System.getString(paramContext.getContentResolver(), paramString);
          return paramContext;
        }
      }
      catch (Throwable paramContext) {}
    }
    return null;
  }
  
  public static boolean removeFromSPUnified(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    paramBoolean = bool2;
    if (paramString2 != null)
    {
      paramBoolean = bool2;
      if (paramString2.length() > 0)
      {
        paramBoolean = bool2;
        if (paramString1 != null)
        {
          paramBoolean = bool2;
          if (paramString1.length() > 0) {
            paramBoolean = bool1;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        if (b.a() == true)
        {
          String str = paramString1 + "_" + paramString2;
          if (a("SGMANAGER_DATA", str, null) == null) {
            continue;
          }
          paramBoolean = a("SGMANAGER_DATA", str);
        }
      }
      finally
      {
        b.b();
      }
      try
      {
        b.b();
        return paramBoolean;
      }
      finally {}
      paramBoolean = bool1;
      if (a(paramString1, paramString2, null) != null) {
        paramBoolean = a(paramString1, paramString2);
      }
    }
  }
  
  public static boolean saveToSPUnified(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramString1 != null) && (paramString1.length() > 0))
    {
      paramBoolean = bool;
      try
      {
        if (b.a() == true)
        {
          paramString1 = paramString1 + "_" + paramString2;
          paramString2 = a;
          paramBoolean = bool;
          if (paramString2 != null)
          {
            paramBoolean = bool;
            if (paramString1 != null)
            {
              paramBoolean = bool;
              if (paramString1.length() > 0)
              {
                paramBoolean = bool;
                if ("SGMANAGER_DATA".length() > 0)
                {
                  paramString2 = a(paramString2, "SGMANAGER_DATA");
                  paramBoolean = bool;
                  if (paramString2 != null)
                  {
                    paramString2 = paramString2.edit();
                    paramString2.putString(paramString1, paramString3);
                    paramBoolean = paramString2.commit();
                  }
                }
              }
            }
          }
        }
        return false;
      }
      finally
      {
        try
        {
          b.b();
          return paramBoolean;
        }
        finally {}
        paramString1 = finally;
        b.b();
      }
    }
  }
  
  public static boolean writeSS(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext != null) {
      try
      {
        if (((Build.VERSION.SDK_INT < 23) || (paramContext.getApplicationInfo().targetSdkVersion < 23)) && (paramString1 != null) && (paramString1.length() > 0))
        {
          boolean bool = Settings.System.putString(paramContext.getContentResolver(), paramString1, paramString2);
          return bool;
        }
      }
      catch (Throwable paramContext) {}
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\common\SPUtility2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */