package com.xiaoenai.app.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.h.a.a;
import java.util.UUID;

public final class v
{
  public static String a(String paramString)
  {
    int i = paramString.lastIndexOf('?');
    if (i > 1) {}
    for (paramString = paramString.substring(paramString.lastIndexOf('/') + 1, i);; paramString = paramString.substring(paramString.lastIndexOf('/') + 1))
    {
      String str;
      if (paramString != null)
      {
        str = paramString;
        if (!"".equals(paramString.trim())) {}
      }
      else
      {
        str = UUID.randomUUID() + ".apk";
      }
      return str;
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = Xiaoenai.j();
    }
    if (b(paramInt)) {
      a.a().a((Context)localObject, "https_error_5xx");
    }
    if (c(paramInt)) {
      a.a().a((Context)localObject, "https_error_4xx");
    }
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 404;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getNetworkInfo(1);
    if ((paramContext != null) && (paramContext.isConnected())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = Xiaoenai.j();
    }
    if (b(paramInt)) {
      a.a().a((Context)localObject, "mzd_http_dns_error_5xx_v2");
    }
    if (c(paramInt)) {
      a.a().a((Context)localObject, "mzd_http_dns_error_4xx_v2");
    }
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt > 0) && (paramInt / 100 == 5);
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramContext.length)
        {
          if ((paramContext[i].getState() == NetworkInfo.State.CONNECTED) || (paramContext[i].getState() == NetworkInfo.State.CONNECTING)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt > 0) && (paramInt / 100 == 4);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */