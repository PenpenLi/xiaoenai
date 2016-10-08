package com.alibaba.nb.android.trade.service.a.a;

import android.content.Context;
import com.alibaba.nb.android.trade.AliTradeContext;
import java.util.HashMap;
import java.util.Map;

public class a
  implements com.alibaba.nb.android.trade.service.a.a
{
  private static String a = "group1";
  private static volatile a d;
  private Context b = AliTradeContext.context;
  private Map<String, Map<String, Object>> c = new HashMap();
  
  public static a a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new a();
      }
      return d;
    }
    finally {}
  }
  
  public final Object a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramString1 = (Map)this.c.get(paramString1);
    if ((paramString1 != null) && (paramString1.get(paramString2) != null)) {
      return paramString1.get(paramString2);
    }
    return null;
  }
  
  public final boolean a(String paramString1, String paramString2, Object paramObject)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramObject == null)) {
      return false;
    }
    Map localMap = (Map)this.c.get(paramString1);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.c.put(paramString1, localObject);
    }
    ((Map)localObject).put(paramString2, paramObject);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\service\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */