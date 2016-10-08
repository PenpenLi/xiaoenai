package com.inmobi.signals.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.CellInfo;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.d;
import com.inmobi.signals.o;
import com.inmobi.signals.p.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@TargetApi(17)
public class c
{
  private static final String a = c.class.getSimpleName();
  
  public static Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (!o.a().e().n()) {
      return localHashMap;
    }
    int i = o.a().e().m();
    boolean bool1 = a(i, 2);
    boolean bool2 = a(i, 1);
    a locala = new a();
    Object localObject = (TelephonyManager)com.inmobi.commons.a.a.b().getSystemService("phone");
    if (!bool1)
    {
      int[] arrayOfInt = a(((TelephonyManager)localObject).getNetworkOperator());
      locala.a(arrayOfInt[0]);
      locala.b(arrayOfInt[1]);
      locala.a(((TelephonyManager)localObject).getNetworkCountryIso());
    }
    if (!bool2)
    {
      localObject = a(((TelephonyManager)localObject).getSimOperator());
      locala.c(localObject[0]);
      locala.d(localObject[1]);
    }
    localHashMap.put("s-ho", locala.b());
    localHashMap.put("s-co", locala.a());
    localHashMap.put("s-iso", locala.c());
    return localHashMap;
  }
  
  private static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private static int[] a(String paramString)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = -1;
    arrayOfInt[1] = -1;
    if ((paramString == null) || (paramString.equals(""))) {
      return arrayOfInt;
    }
    try
    {
      int i = Integer.parseInt(paramString.substring(0, 3));
      int j = Integer.parseInt(paramString.substring(3));
      arrayOfInt[0] = i;
      arrayOfInt[1] = j;
      return arrayOfInt;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while collecting cell info.", paramString);
      return arrayOfInt;
    }
    catch (NumberFormatException paramString)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while collecting cell info.", paramString);
    }
    return arrayOfInt;
  }
  
  public static b b()
  {
    if ((!o.a().e().p()) || (!f())) {
      return null;
    }
    return g();
  }
  
  public static Map<String, String> c()
  {
    b localb = b();
    HashMap localHashMap = new HashMap();
    if (localb != null) {
      localHashMap.put("c-sc", localb.a().toString());
    }
    return localHashMap;
  }
  
  public static Map<String, String> d()
  {
    List localList = e();
    HashMap localHashMap = new HashMap();
    if ((localList != null) && (!localList.isEmpty()))
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(((b)localList.get(localList.size() - 1)).a());
      localHashMap.put("v-sc", localJSONArray.toString());
    }
    return localHashMap;
  }
  
  public static List<b> e()
  {
    if ((!h()) || (!o.a().e().o())) {
      return null;
    }
    Object localObject2 = (TelephonyManager)com.inmobi.commons.a.a.b().getSystemService("phone");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = a(((TelephonyManager)localObject2).getNetworkOperator());
    String str = String.valueOf(localObject1[0]);
    localObject1 = String.valueOf(localObject1[1]);
    Object localObject3;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject3 = ((TelephonyManager)localObject2).getAllCellInfo();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          CellInfo localCellInfo = (CellInfo)((Iterator)localObject3).next();
          if (!localCellInfo.isRegistered()) {
            localArrayList.add(new b(localCellInfo, str, (String)localObject1, ((TelephonyManager)localObject2).getNetworkType()));
          }
        }
        return localArrayList;
      }
    }
    localObject2 = ((TelephonyManager)localObject2).getNeighboringCellInfo();
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      return null;
    }
    localObject2 = ((List)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject2 = (NeighboringCellInfo)((Iterator)localObject2).next();
      localObject3 = new b();
      int i = ((NeighboringCellInfo)localObject2).getNetworkType();
      ((b)localObject3).a(i);
      if (((NeighboringCellInfo)localObject2).getRssi() == 99) {
        ((b)localObject3).b(Integer.MAX_VALUE);
      }
      for (;;)
      {
        ((b)localObject3).a(((b)localObject3).a(str, (String)localObject1, ((NeighboringCellInfo)localObject2).getLac(), ((NeighboringCellInfo)localObject2).getCid(), -1, Integer.MAX_VALUE));
        localArrayList.add(localObject3);
        return localArrayList;
        if (a(i)) {
          ((b)localObject3).b(((NeighboringCellInfo)localObject2).getRssi() - 116);
        } else {
          ((b)localObject3).b(((NeighboringCellInfo)localObject2).getRssi() * 2 - 113);
        }
      }
    }
    return null;
  }
  
  private static boolean f()
  {
    boolean bool = false;
    if (!d.a("signals", "android.permission.ACCESS_COARSE_LOCATION")) {}
    for (int i = 0;; i = 1)
    {
      if (!d.a("signals", "android.permission.ACCESS_FINE_LOCATION")) {}
      for (int j = 0;; j = 1)
      {
        if ((i != 0) || (j != 0)) {
          bool = true;
        }
        return bool;
      }
    }
  }
  
  private static b g()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)com.inmobi.commons.a.a.b().getSystemService("phone");
    Object localObject3 = a(localTelephonyManager.getNetworkOperator());
    String str = String.valueOf(localObject3[0]);
    Object localObject2 = String.valueOf(localObject3[1]);
    Object localObject4;
    int i;
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject4 = localTelephonyManager.getAllCellInfo();
      if (localObject4 != null)
      {
        i = 0;
        localObject1 = null;
        if (i >= ((List)localObject4).size()) {
          break label254;
        }
        localObject1 = (CellInfo)((List)localObject4).get(i);
        if (!((CellInfo)localObject1).isRegistered()) {}
      }
    }
    label254:
    for (;;)
    {
      if (localObject1 != null)
      {
        return new b((CellInfo)localObject1, str, (String)localObject2, localTelephonyManager.getNetworkType());
        i += 1;
        break;
      }
      localObject4 = localTelephonyManager.getCellLocation();
      if ((localObject4 == null) || (localObject3[0] == -1)) {
        return null;
      }
      localObject1 = new b();
      if ((localObject4 instanceof CdmaCellLocation))
      {
        localObject2 = (CdmaCellLocation)localObject4;
        ((b)localObject1).b(Integer.MAX_VALUE);
        ((b)localObject1).a(localTelephonyManager.getNetworkType());
        ((b)localObject1).a(((b)localObject1).a(str, ((CdmaCellLocation)localObject2).getSystemId(), ((CdmaCellLocation)localObject2).getNetworkId(), ((CdmaCellLocation)localObject2).getBaseStationId()));
        return (b)localObject1;
      }
      localObject3 = (GsmCellLocation)localObject4;
      ((b)localObject1).b(Integer.MAX_VALUE);
      ((b)localObject1).a(localTelephonyManager.getNetworkType());
      ((b)localObject1).a(((b)localObject1).a(str, (String)localObject2, ((GsmCellLocation)localObject3).getLac(), ((GsmCellLocation)localObject3).getCid(), ((GsmCellLocation)localObject3).getPsc(), Integer.MAX_VALUE));
      return (b)localObject1;
    }
  }
  
  private static boolean h()
  {
    return d.a("signals", "android.permission.ACCESS_COARSE_LOCATION");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */