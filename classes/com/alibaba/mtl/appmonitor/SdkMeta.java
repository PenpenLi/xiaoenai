package com.alibaba.mtl.appmonitor;

import android.content.Context;
import android.content.res.Resources;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.e.i;
import java.util.HashMap;
import java.util.Map;

public class SdkMeta
{
  public static final String SDK_VERSION = "2.4.8_for_bc";
  private static final Map<String, String> b = new HashMap();
  
  static
  {
    b.put("sdk-version", "2.4.8_for_bc");
  }
  
  public static Map<String, String> getSDKMetaData()
  {
    if ((a.getContext() == null) || (!b.containsKey("sdk-version"))) {
      b.put("sdk-version", "2.4.8_for_bc");
    }
    return b;
  }
  
  public static String getString(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return null;
      try
      {
        i = paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
        if (i == 0) {
          continue;
        }
        return paramContext.getString(i);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          i.a("SdkMeta", "getString Id error", paramString);
          int i = 0;
        }
      }
    }
  }
  
  public static void setExtra(Map<String, String> paramMap)
  {
    if (paramMap != null) {
      b.putAll(paramMap);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\SdkMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */