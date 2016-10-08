package com.taobao.dp.c;

import android.content.Context;
import java.lang.reflect.Method;

public final class h
{
  public static String a(Context paramContext)
  {
    for (;;)
    {
      String str;
      try
      {
        str = (String)Class.forName("com.ut.device.UTDevice").getMethod("getUtdid", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
        paramContext = str;
        if (str != null) {
          paramContext = str;
        }
      }
      catch (Exception paramContext)
      {
        paramContext = null;
        continue;
      }
      try
      {
        if (str.contains("?")) {
          paramContext = "";
        }
      }
      catch (Exception paramContext)
      {
        paramContext = str;
      }
    }
    if (paramContext != null) {
      return paramContext;
    }
    return "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */