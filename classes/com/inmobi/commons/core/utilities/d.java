package com.inmobi.commons.core.utilities;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class d
{
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    Object localObject = com.inmobi.commons.a.a.b();
    try
    {
      int i = ((Context)localObject).checkCallingOrSelfPermission(paramString2);
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (RuntimeException paramString2)
    {
      localObject = new HashMap();
      ((Map)localObject).put("type", "RuntimeException");
      ((Map)localObject).put("message", paramString2.getMessage());
      com.inmobi.commons.core.c.a.a().a(paramString1, "ExceptionCaught", (Map)localObject);
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */