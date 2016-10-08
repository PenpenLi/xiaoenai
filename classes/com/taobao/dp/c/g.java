package com.taobao.dp.c;

import java.lang.reflect.Method;

public final class g
{
  private static Class a = null;
  private static Method b = null;
  private static Object c = new Object();
  
  public static String a(String paramString1, String paramString2)
  {
    if ((a == null) && (b == null)) {}
    synchronized (c)
    {
      Object localObject2;
      if (a == null)
      {
        localObject2 = b;
        if (localObject2 != null) {}
      }
      try
      {
        localObject2 = Class.forName("android.os.SystemProperties");
        a = (Class)localObject2;
        b = ((Class)localObject2).getMethod("get", new Class[] { String.class, String.class });
        paramString1 = finally;
      }
      catch (Exception paramString1)
      {
        try
        {
          paramString1 = (String)b.invoke(null, new Object[] { paramString1, paramString2 });
          return paramString1;
        }
        catch (Exception paramString1) {}
        paramString1 = paramString1;
        return paramString2;
      }
    }
    return paramString2;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */