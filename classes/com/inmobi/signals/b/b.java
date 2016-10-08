package com.inmobi.signals.b;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.inmobi.commons.core.utilities.d;
import com.inmobi.signals.o;
import com.inmobi.signals.p.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class b
{
  private static long a(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  private static long a(String paramString)
  {
    paramString = paramString.split("\\:");
    byte[] arrayOfByte = new byte[6];
    int i = 0;
    while (i < 6) {
      try
      {
        arrayOfByte[i] = ((byte)Integer.parseInt(paramString[i], 16));
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        return 0L;
      }
    }
    return a(arrayOfByte);
  }
  
  private static long a(byte[] paramArrayOfByte)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramArrayOfByte != null)
    {
      l1 = l2;
      if (paramArrayOfByte.length == 6) {
        l1 = a(paramArrayOfByte[5]) | a(paramArrayOfByte[4]) << 8 | a(paramArrayOfByte[3]) << 16 | a(paramArrayOfByte[2]) << 24 | a(paramArrayOfByte[1]) << 32 | a(paramArrayOfByte[0]) << 40;
      }
    }
    return l1;
  }
  
  public static a a()
  {
    if ((!e()) || (!o.a().e().l())) {
      return null;
    }
    int i = o.a().e().j();
    return a(a(i), b(i));
  }
  
  private static a a(ScanResult paramScanResult, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    a locala;
    if (paramScanResult != null)
    {
      locala = new a();
      locala.a(a(paramScanResult.BSSID));
      if (!paramBoolean) {
        break label55;
      }
    }
    label55:
    for (localObject1 = localObject2;; localObject1 = paramScanResult.SSID)
    {
      locala.a((String)localObject1);
      locala.a(paramScanResult.level);
      localObject1 = locala;
      return (a)localObject1;
    }
  }
  
  private static a a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a locala = null;
    WifiInfo localWifiInfo = ((WifiManager)com.inmobi.commons.a.a.b().getSystemService("wifi")).getConnectionInfo();
    Object localObject = locala;
    if (localWifiInfo != null)
    {
      String str2 = localWifiInfo.getBSSID();
      String str1 = localWifiInfo.getSSID();
      localObject = locala;
      if (str2 != null)
      {
        localObject = locala;
        if (!a(paramBoolean1, str1))
        {
          locala = new a();
          locala.a(a(str2));
          localObject = str1;
          if (str1 != null)
          {
            localObject = str1;
            if (str1.startsWith("\""))
            {
              localObject = str1;
              if (str1.endsWith("\"")) {
                localObject = str1.substring(1, str1.length() - 1);
              }
            }
          }
          if (paramBoolean2) {
            localObject = null;
          }
          locala.a((String)localObject);
          locala.a(localWifiInfo.getRssi());
          locala.b(localWifiInfo.getIpAddress());
          localObject = locala;
        }
      }
    }
    return (a)localObject;
  }
  
  public static List<a> a(List<ScanResult> paramList)
  {
    int i = o.a().e().j();
    boolean bool1 = a(i);
    boolean bool2 = b(i);
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ScanResult localScanResult = (ScanResult)paramList.next();
        if (!a(bool1, localScanResult.SSID)) {
          localArrayList.add(a(localScanResult, bool2));
        }
      }
    }
    return localArrayList;
  }
  
  private static boolean a(int paramInt)
  {
    return !a(paramInt, 2);
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private static boolean a(boolean paramBoolean, String paramString)
  {
    return (paramBoolean) && (paramString != null) && (paramString.endsWith("_nomap"));
  }
  
  public static Map<String, String> b()
  {
    a locala = a();
    HashMap localHashMap = new HashMap();
    if (locala != null) {
      localHashMap.put("c-ap-bssid", String.valueOf(locala.a()));
    }
    return localHashMap;
  }
  
  private static boolean b(int paramInt)
  {
    return a(paramInt, 1);
  }
  
  public static boolean c()
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "android.permission.ACCESS_WIFI_STATE";
    arrayOfString[1] = "android.permission.CHANGE_WIFI_STATE";
    arrayOfString[2] = "android.permission.ACCESS_COARSE_LOCATION";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (!d.a("signals", arrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static Map<String, String> d()
  {
    ArrayList localArrayList = (ArrayList)c.a();
    HashMap localHashMap = new HashMap();
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      localHashMap.put("v-ap-bssid", String.valueOf(((a)localArrayList.get(localArrayList.size() - 1)).a()));
    }
    return localHashMap;
  }
  
  private static boolean e()
  {
    return d.a("signals", "android.permission.ACCESS_WIFI_STATE");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */