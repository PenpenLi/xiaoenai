package com.alibaba.nb.android.trade.web.register;

import java.util.Map;

public abstract interface AliTradeServiceRegistry
{
  public abstract <T> T getService(Class<T> paramClass, Map<String, String> paramMap);
  
  public abstract <T> T[] getServices(Class<T> paramClass, Map<String, String> paramMap);
  
  public abstract a registerService(Class<?>[] paramArrayOfClass, Object paramObject, Map<String, String> paramMap);
  
  public abstract Object unregisterService(a parama);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\register\AliTradeServiceRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */