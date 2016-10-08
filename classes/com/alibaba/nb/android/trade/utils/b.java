package com.alibaba.nb.android.trade.utils;

import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.callback.AliTradeFailureCallback;
import com.alibaba.nb.android.trade.utils.a.a;

public final class b
{
  private static String a = "\\u";
  
  public static void a(AliTradeFailureCallback paramAliTradeFailureCallback, int paramInt, String paramString)
  {
    if (paramAliTradeFailureCallback == null) {
      return;
    }
    AliTradeContext.executorService.b(new d(paramAliTradeFailureCallback, paramInt, paramString));
  }
  
  public static void a(AliTradeFailureCallback paramAliTradeFailureCallback, a parama)
  {
    if (paramAliTradeFailureCallback == null) {
      return;
    }
    AliTradeContext.executorService.b(new c(paramAliTradeFailureCallback, parama));
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */