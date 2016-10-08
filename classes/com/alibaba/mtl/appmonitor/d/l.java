package com.alibaba.mtl.appmonitor.d;

import android.content.Context;
import com.alibaba.mtl.log.a.a;

public class l
{
  private static boolean j = false;
  
  public static void a(Context paramContext)
  {
    if (c("com.taobao.orange.OrangeConfig"))
    {
      m.a().b(a.g());
      n.c(a.g());
    }
  }
  
  private static boolean c(String paramString)
  {
    try
    {
      Class.forName(paramString);
      return true;
    }
    catch (ClassNotFoundException paramString) {}
    return false;
  }
  
  public static void init(Context paramContext)
  {
    if (!j)
    {
      if (c("com.taobao.orange.OrangeConfig")) {
        k.init(paramContext);
      }
      if (c("com.taobao.wswitch.business.ConfigContainer")) {
        g.init(paramContext);
      }
      a(paramContext);
      j = true;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */