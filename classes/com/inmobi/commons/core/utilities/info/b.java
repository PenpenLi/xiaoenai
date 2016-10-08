package com.inmobi.commons.core.utilities.info;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.d;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class b
{
  public static Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("d-netType", c());
    localHashMap.put("d-localization", b());
    return localHashMap;
  }
  
  private static String b()
  {
    return Locale.getDefault().toString();
  }
  
  private static String c()
  {
    Object localObject = a.b();
    if (d.a("root", "android.permission.ACCESS_NETWORK_STATE"))
    {
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if (localObject != null)
        {
          int i = ((NetworkInfo)localObject).getType();
          int j = ((NetworkInfo)localObject).getSubtype();
          if (i == 1) {
            localObject = "wifi";
          }
          do
          {
            return (String)localObject;
            if (i != 0) {
              break;
            }
            localObject = "carrier";
            if (j == 1) {
              return "gprs";
            }
            if (j == 2) {
              return "edge";
            }
            if (j == 3) {
              return "umts";
            }
          } while (j != 0);
          return "carrier";
        }
      }
    }
    return "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\info\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */