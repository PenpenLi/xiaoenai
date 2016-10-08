package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.security.mobile.module.a.a;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  public static Map<String, String> a(Context paramContext, Map<String, String> paramMap)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      String str1 = a.a(paramMap, "tid", "");
      String str2 = a.a(paramMap, "utdid", "");
      paramContext = com.alipay.apmobilesecuritysdk.e.b.a(paramContext);
      paramMap = a.a(paramMap, "userId", "");
      localHashMap.put("AC1", str1);
      localHashMap.put("AC2", str2);
      localHashMap.put("AC3", "");
      localHashMap.put("AC4", paramContext);
      localHashMap.put("AC5", paramMap);
      return localHashMap;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */