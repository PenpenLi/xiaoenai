package com.alibaba.mtl.log.e;

import java.util.Map;

public class s
{
  public static void send(Map<String, String> paramMap)
  {
    try
    {
      Object localObject = o.a("com.ut.mini.UTAnalytics", "getInstance");
      if (localObject != null)
      {
        localObject = o.a(localObject, "getDefaultTracker");
        if (localObject != null) {
          o.a(localObject, "send", new Object[] { paramMap }, new Class[] { Map.class });
        }
      }
      return;
    }
    catch (Exception paramMap) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */