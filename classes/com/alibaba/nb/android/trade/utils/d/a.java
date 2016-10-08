package com.alibaba.nb.android.trade.utils.d;

import android.util.Log;
import com.alibaba.nb.android.trade.AliTradeContext;
import java.text.DateFormat;
import java.util.Date;

public class a
{
  public static void a(String paramString, com.alibaba.nb.android.trade.utils.a.a parama)
  {
    StringBuilder localStringBuilder;
    if (AliTradeContext.isDebugable())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("***********************************************************\n");
      localStringBuilder.append("错误编码 = ").append(parama.a).append("\n");
      localStringBuilder.append("错误消息 = ").append(parama.c).append("\n");
      localStringBuilder.append("解决建议 = ").append(parama.d).append("\n");
      localStringBuilder.append("***********************************************************\n");
      parama = parama.b;
      if ("D".equals(parama)) {
        b(paramString, localStringBuilder.toString());
      }
    }
    else
    {
      return;
    }
    if ("E".equals(parama))
    {
      d(paramString, localStringBuilder.toString());
      return;
    }
    if ("W".equals(parama))
    {
      c(paramString, localStringBuilder.toString());
      return;
    }
    a(paramString, localStringBuilder.toString());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    com.alibaba.nb.android.trade.service.log.a.a.a.a(paramString1, 4, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    com.alibaba.nb.android.trade.service.log.a.a.a.a(paramString1, 6, paramString2 + '\n' + Log.getStackTraceString(paramThrowable));
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    com.alibaba.nb.android.trade.service.log.a.a.a.a(paramString, 6, Log.getStackTraceString(paramThrowable));
  }
  
  public static void a(Throwable paramThrowable)
  {
    com.alibaba.nb.android.trade.service.log.a.a.a.a(2, 6, null, null, Log.getStackTraceString(paramThrowable));
  }
  
  public static boolean a()
  {
    return AliTradeContext.isDebugable();
  }
  
  public static void b()
  {
    a(a.class.getName(), "-----" + DateFormat.getDateTimeInstance().format(new Date()) + "-----");
    com.alibaba.nb.android.trade.service.log.a.a().e();
  }
  
  public static void b(String paramString1, String paramString2)
  {
    com.alibaba.nb.android.trade.service.log.a.a.a.a(paramString1, 3, paramString2);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    com.alibaba.nb.android.trade.service.log.a.a.a.a(paramString1, 5, paramString2);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    com.alibaba.nb.android.trade.service.log.a.a.a.a(paramString1, 6, paramString2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */