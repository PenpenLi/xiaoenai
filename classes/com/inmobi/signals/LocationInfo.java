package com.inmobi.signals;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.d;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LocationInfo
  implements LocationListener
{
  private static final String a = LocationInfo.class.getSimpleName();
  private static LocationInfo b;
  private static Object c = new Object();
  private static boolean d = false;
  private static LocationManager e;
  private static Object f = null;
  private static a g = null;
  private static boolean h = false;
  
  private LocationInfo()
  {
    e = (LocationManager)com.inmobi.commons.a.a.b().getSystemService("location");
  }
  
  public static LocationInfo a()
  {
    Object localObject1 = b;
    if (localObject1 == null) {
      synchronized (c)
      {
        LocationInfo localLocationInfo2 = b;
        localObject1 = localLocationInfo2;
        if (localLocationInfo2 == null)
        {
          b = new LocationInfo();
          localObject1 = b;
        }
        return (LocationInfo)localObject1;
      }
    }
    return localLocationInfo1;
  }
  
  private String a(Location paramLocation)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocation.getLatitude());
    localStringBuilder.append(",");
    localStringBuilder.append(paramLocation.getLongitude());
    localStringBuilder.append(",");
    localStringBuilder.append((int)paramLocation.getAccuracy());
    return localStringBuilder.toString();
  }
  
  private HashMap<String, Object> a(Location paramLocation, boolean paramBoolean)
  {
    int j = 1;
    HashMap localHashMap = new HashMap();
    if (paramLocation != null)
    {
      if (paramLocation.getTime() > 0L) {
        localHashMap.put("u-ll-ts", Long.valueOf(paramLocation.getTime()));
      }
      localHashMap.put("u-latlong-accu", a(paramLocation));
      if (paramBoolean)
      {
        i = 1;
        localHashMap.put("sdk-collected", Integer.valueOf(i));
      }
    }
    else if (d)
    {
      if (!k()) {
        break label158;
      }
    }
    label158:
    for (int i = j;; i = 0)
    {
      localHashMap.put("loc-allowed", Integer.valueOf(i));
      if ((!k()) || (!i())) {
        break label164;
      }
      if (d.a("signals", "android.permission.ACCESS_COARSE_LOCATION")) {
        localHashMap.put("loc-granularity", "coarse");
      }
      if (d.a("signals", "android.permission.ACCESS_FINE_LOCATION")) {
        localHashMap.put("loc-granularity", "fine");
      }
      return localHashMap;
      i = 0;
      break;
    }
    label164:
    localHashMap.put("loc-granularity", "none");
    return localHashMap;
  }
  
  private void a(Context paramContext)
  {
    if (f == null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Connecting Google API client for location.");
      g = new a(null);
      f = h.a(paramContext, g, g, "com.google.android.gms.location.LocationServices");
      h.a(f);
    }
  }
  
  private boolean i()
  {
    return (d.a("signals", "android.permission.ACCESS_FINE_LOCATION")) || (d.a("signals", "android.permission.ACCESS_COARSE_LOCATION"));
  }
  
  private LocationConsentStatus j()
  {
    if (i())
    {
      if (k()) {
        return LocationConsentStatus.AUTHORISED;
      }
      return LocationConsentStatus.DENIED;
    }
    return LocationConsentStatus.DENIED;
  }
  
  @TargetApi(19)
  private boolean k()
  {
    Context localContext = com.inmobi.commons.a.a.b();
    if (Build.VERSION.SDK_INT >= 19) {}
    for (;;)
    {
      try
      {
        i = Settings.Secure.getInt(localContext.getContentResolver(), "location_mode");
        if (i != 0) {
          return true;
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        localSettingNotFoundException.printStackTrace();
        int i = 0;
        continue;
      }
      return false;
      boolean bool1;
      boolean bool2;
      if (e != null)
      {
        if (!d.a("signals", "android.permission.ACCESS_FINE_LOCATION")) {
          break label79;
        }
        bool1 = e.isProviderEnabled("gps");
        bool2 = false;
      }
      while ((!bool2) && (!bool1))
      {
        return false;
        label79:
        if (d.a("signals", "android.permission.ACCESS_COARSE_LOCATION"))
        {
          bool2 = e.isProviderEnabled("network");
          bool1 = false;
        }
        else
        {
          bool1 = false;
          bool2 = false;
        }
      }
    }
  }
  
  private Location l()
  {
    boolean bool2 = true;
    localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject3;
    StringBuilder localStringBuilder;
    if (d)
    {
      localObject2 = localObject3;
      if (k())
      {
        if (h)
        {
          localObject1 = m();
          localObject2 = Logger.InternalLogLevel.INTERNAL;
          localObject3 = a;
          localStringBuilder = new StringBuilder().append("Location info provided by Google Api client:");
          if (localObject1 == null) {
            break label227;
          }
          bool1 = true;
          Logger.a((Logger.InternalLogLevel)localObject2, (String)localObject3, bool1);
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (e != null)
          {
            localObject2 = new Criteria();
            if (!d.a("signals", "android.permission.ACCESS_FINE_LOCATION")) {
              break label233;
            }
            ((Criteria)localObject2).setAccuracy(1);
          }
        }
      }
    }
    for (;;)
    {
      ((Criteria)localObject2).setCostAllowed(false);
      localObject3 = e.getBestProvider((Criteria)localObject2, true);
      localObject2 = localObject1;
      if (localObject3 != null) {}
      try
      {
        localObject2 = e.getLastKnownLocation((String)localObject3);
        localObject1 = localObject2;
      }
      catch (SecurityException localSecurityException)
      {
        for (;;)
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to acquire a location fix; access seems to be disabled");
          localObject3 = new HashMap();
          ((Map)localObject3).put("type", "SecurityException");
          ((Map)localObject3).put("message", localSecurityException.getMessage());
          com.inmobi.commons.core.c.a.a().a("signals", "ExceptionCaught", (Map)localObject3);
          continue;
          bool1 = false;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = n();
      }
      localObject1 = Logger.InternalLogLevel.INTERNAL;
      localObject3 = a;
      localStringBuilder = new StringBuilder().append("Location info provided by Location manager:");
      if (localObject2 == null) {
        break label314;
      }
      bool1 = bool2;
      Logger.a((Logger.InternalLogLevel)localObject1, (String)localObject3, bool1);
      if (localObject2 == null) {
        com.inmobi.commons.core.c.a.a().a(new com.inmobi.commons.core.c.e("signals", "LocationFixFailed"));
      }
      return (Location)localObject2;
      label227:
      bool1 = false;
      break;
      label233:
      if (d.a("signals", "android.permission.ACCESS_COARSE_LOCATION")) {
        ((Criteria)localObject2).setAccuracy(2);
      }
    }
  }
  
  private Location m()
  {
    try
    {
      Object localObject = Class.forName("com.google.android.gms.location.LocationServices").getDeclaredField("FusedLocationApi");
      Class localClass = Class.forName("com.google.android.gms.common.api.GoogleApiClient");
      localObject = (Location)Class.forName("com.google.android.gms.location.FusedLocationProviderApi").getMethod("getLastLocation", new Class[] { localClass }).invoke(((Field)localObject).get(null), new Object[] { f });
      return (Location)localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Unable to request activity updates from ActivityRecognition client", localInvocationTargetException);
      return null;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Unable to request activity updates from ActivityRecognition client", localClassNotFoundException);
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Unable to request activity updates from ActivityRecognition client", localIllegalAccessException);
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Unable to request activity updates from ActivityRecognition client", localNoSuchMethodException);
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Unable to request activity updates from ActivityRecognition client", localNoSuchFieldException);
    }
    return null;
  }
  
  private Location n()
  {
    Object localObject1 = null;
    List localList;
    int i;
    if (e != null)
    {
      localList = e.getProviders(true);
      i = localList.size() - 1;
    }
    Object localObject3;
    for (localObject1 = null; i >= 0; localObject1 = localObject3)
    {
      Object localObject2 = (String)localList.get(i);
      if (e.isProviderEnabled((String)localObject2))
      {
        try
        {
          localObject2 = e.getLastKnownLocation((String)localObject2);
          localObject1 = localObject2;
        }
        catch (SecurityException localSecurityException)
        {
          for (;;)
          {
            Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to acquire a location fix; access seems to be disabled");
            HashMap localHashMap = new HashMap();
            localHashMap.put("type", "SecurityException");
            localHashMap.put("message", localSecurityException.getMessage());
            com.inmobi.commons.core.c.a.a().a("signals", "ExceptionCaught", localHashMap);
          }
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          break label142;
        }
        return (Location)localObject1;
      }
      localObject3 = localObject1;
      label142:
      i -= 1;
    }
    return (Location)localObject1;
  }
  
  public void a(boolean paramBoolean)
  {
    d = paramBoolean;
  }
  
  void b()
  {
    if ((d) && (h.a())) {
      a(com.inmobi.commons.a.a.b());
    }
    d();
  }
  
  void c()
  {
    if ((d) && (i()) && (k()) && (e != null)) {
      e.removeUpdates(this);
    }
  }
  
  public void d()
  {
    if ((d) && (i()) && (k()) && (e != null))
    {
      Object localObject = new Criteria();
      ((Criteria)localObject).setBearingAccuracy(2);
      ((Criteria)localObject).setPowerRequirement(2);
      ((Criteria)localObject).setCostAllowed(false);
      localObject = e.getBestProvider((Criteria)localObject, true);
      if (localObject != null)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Trying to get location fix. Provider being used:" + (String)localObject);
        e.requestSingleUpdate((String)localObject, this, null);
      }
    }
    else
    {
      return;
    }
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "No enabled providers found matching the supplied criteria");
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Skipping the location fix");
  }
  
  public HashMap<String, Object> e()
  {
    try
    {
      HashMap localHashMap = a(l(), true);
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public HashMap<String, String> f()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("loc-consent-status", j().toString().toLowerCase(Locale.ENGLISH));
    return localHashMap;
  }
  
  public HashMap<String, String> g()
  {
    HashMap localHashMap2;
    for (;;)
    {
      try
      {
        localHashMap2 = new HashMap();
        Object localObject1 = l();
        if (localObject1 != null)
        {
          localObject1 = a((Location)localObject1, true);
          localObject1 = ((HashMap)localObject1).entrySet().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
          localHashMap2.put(localEntry.getKey(), localEntry.getValue().toString());
          continue;
        }
        HashMap localHashMap1 = a(com.inmobi.commons.core.utilities.info.e.f(), false);
      }
      finally {}
    }
    return localHashMap2;
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "location changed. ts:" + paramLocation.getTime() + " lat:" + paramLocation.getLatitude() + ":" + paramLocation.getLongitude() + " accu:" + paramLocation.getAccuracy());
    if (i()) {
      e.removeUpdates(this);
    }
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  public static enum LocationConsentStatus
  {
    AUTHORISED,  DENIED,  UNDETERMINED;
    
    private LocationConsentStatus() {}
  }
  
  private static class a
    implements InvocationHandler
  {
    public void a(int paramInt)
    {
      LocationInfo.b(false);
      Logger.a(Logger.InternalLogLevel.INTERNAL, LocationInfo.h(), "Google API client connection suspended");
    }
    
    public void a(Bundle paramBundle)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, LocationInfo.h(), "Successfully connected to Google API client.");
      LocationInfo.b(true);
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      if (paramArrayOfObject != null)
      {
        if (paramMethod.getName().equals("onConnected"))
        {
          a((Bundle)paramArrayOfObject[0]);
          return null;
        }
        if (paramMethod.getName().equals("onConnectionSuspended"))
        {
          a(((Integer)paramArrayOfObject[0]).intValue());
          return null;
        }
      }
      return paramMethod.invoke(this, paramArrayOfObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\LocationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */