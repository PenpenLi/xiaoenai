package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class c
{
  private static c b;
  private String a;
  private ArrayList c = new ArrayList();
  
  private c()
  {
    this.c.add("libsecuritysdk-3.1.27.so");
  }
  
  public static c a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new c();
      }
      return b;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    Object localObject = null;
    ClassLoader localClassLoader = getClass().getClassLoader();
    if (localClassLoader != null) {}
    for (;;)
    {
      try
      {
        localObject = localClassLoader.getClass().getMethod("findLibrary", new Class[] { String.class });
        if (localObject != null)
        {
          paramString = ((Method)localObject).invoke(localClassLoader, new Object[] { paramString });
          if ((paramString != null) && ((paramString instanceof String)))
          {
            paramString = (String)paramString;
            localObject = paramString;
            return (String)localObject;
          }
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      catch (InvocationTargetException paramString)
      {
        return null;
      }
      catch (IllegalArgumentException paramString)
      {
        return null;
      }
      catch (IllegalAccessException paramString)
      {
        return null;
      }
      catch (NoSuchMethodException paramString)
      {
        return null;
      }
      paramString = null;
    }
  }
  
  private String b(String paramString)
  {
    Object localObject = null;
    ClassLoader localClassLoader = getClass().getClassLoader();
    if (localClassLoader != null) {}
    for (;;)
    {
      try
      {
        localObject = localClassLoader.getClass().getDeclaredMethod("findLibrary", new Class[] { String.class });
        if (localObject != null)
        {
          if (!((Method)localObject).isAccessible()) {
            ((Method)localObject).setAccessible(true);
          }
          paramString = ((Method)localObject).invoke(localClassLoader, new Object[] { paramString });
          if ((paramString != null) && ((paramString instanceof String)))
          {
            paramString = (String)paramString;
            localObject = paramString;
            return (String)localObject;
          }
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      catch (InvocationTargetException paramString)
      {
        return null;
      }
      catch (IllegalArgumentException paramString)
      {
        return null;
      }
      catch (IllegalAccessException paramString)
      {
        return null;
      }
      catch (NoSuchMethodException paramString)
      {
        return null;
      }
      paramString = null;
    }
  }
  
  public final int a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null)) {}
    File localFile;
    try
    {
      if (paramString.length() == 0) {
        return 2;
      }
      localFile = new File(paramString);
      if (!localFile.exists()) {
        return 3;
      }
    }
    finally {}
    if (!localFile.canRead()) {
      return 4;
    }
    if (this.c.contains(localFile.getName() + "x")) {
      return 5;
    }
    int i = new Bitmap().loadBitmap(paramContext, paramString, true);
    if (i == 0)
    {
      this.c.add(localFile.getName() + "x");
      return 1;
    }
    if (i == Bitmap.a) {
      throw new SecException(107);
    }
    if (i == Bitmap.b) {
      throw new SecException(108);
    }
    if (i == Bitmap.c) {
      throw new SecException(109);
    }
    throw new SecException(i + 100);
  }
  
  public final String b()
  {
    if (this.a == null) {}
    try
    {
      if (this.a == null)
      {
        this.a = a("securitysdk-3.1.27");
        if (this.a == null) {
          this.a = b("securitysdk-3.1.27");
        }
      }
      return this.a;
    }
    finally {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\initialize\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */