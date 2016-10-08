package com.inmobi.signals;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class h
{
  private static final String a = h.class.getSimpleName();
  
  public static Object a(Context paramContext, InvocationHandler paramInvocationHandler1, InvocationHandler paramInvocationHandler2, String paramString)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Build object for GoogleApiClient");
    localObject2 = null;
    localObject3 = null;
    try
    {
      localObject4 = Class.forName("com.google.android.gms.common.api.GoogleApiClient");
      localObject1 = null;
      arrayOfClass = ((Class)localObject4).getDeclaredClasses();
      j = arrayOfClass.length;
      i = 0;
    }
    catch (ClassCastException paramContext)
    {
      Object localObject1;
      Class[] arrayOfClass;
      int j;
      Class localClass;
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", paramContext);
      return null;
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", paramContext);
      }
    }
    catch (InstantiationException paramContext)
    {
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", paramContext);
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", paramContext);
      }
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", paramContext);
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", paramContext);
      }
    }
    catch (NoSuchFieldException paramContext)
    {
      for (;;)
      {
        int i;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", paramContext);
        continue;
        Object localObject4 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject4;
        i += 1;
        localObject4 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject4;
      }
    }
    if (i < j)
    {
      localClass = arrayOfClass[i];
      if (localClass.getSimpleName().equalsIgnoreCase("ConnectionCallbacks"))
      {
        localObject4 = Proxy.newProxyInstance(localClass.getClassLoader(), new Class[] { localClass }, paramInvocationHandler1);
        localObject2 = localObject3;
        localObject3 = localObject4;
        break label482;
      }
      if (localClass.getSimpleName().equalsIgnoreCase("OnConnectionFailedListener"))
      {
        localObject4 = Proxy.newProxyInstance(localClass.getClassLoader(), new Class[] { localClass }, paramInvocationHandler2);
        localObject3 = localObject2;
        localObject2 = localObject4;
        break label482;
      }
      if (localClass.getSimpleName().equalsIgnoreCase("Builder"))
      {
        localObject4 = localObject2;
        localObject1 = localClass;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break label482;
      }
    }
    else if (localObject1 != null)
    {
      paramContext = ((Class)localObject1).getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
      paramInvocationHandler1 = Class.forName("com.google.android.gms.common.api.Api");
      localObject4 = Class.forName("com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks");
      paramInvocationHandler2 = Class.forName("com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener");
      paramInvocationHandler1 = ((Class)localObject1).getMethod("addApi", new Class[] { paramInvocationHandler1 });
      localObject4 = ((Class)localObject1).getMethod("addConnectionCallbacks", new Class[] { localObject4 });
      paramInvocationHandler2 = ((Class)localObject1).getMethod("addOnConnectionFailedListener", new Class[] { paramInvocationHandler2 });
      localObject1 = ((Class)localObject1).getMethod("build", (Class[])null);
      paramInvocationHandler1.invoke(paramContext, new Object[] { Class.forName(paramString).getDeclaredField("API").get(null) });
      ((Method)localObject4).invoke(paramContext, new Object[] { localObject2 });
      paramInvocationHandler2.invoke(paramContext, new Object[] { localObject3 });
      paramContext = ((Method)localObject1).invoke(paramContext, (Object[])null);
      return paramContext;
    }
  }
  
  public static void a(Object paramObject)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Connecting Google API client.");
    if (paramObject == null) {
      return;
    }
    try
    {
      Class.forName("com.google.android.gms.common.api.GoogleApiClient").getMethod("connect", (Class[])null).invoke(paramObject, (Object[])null);
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to call connect on GoogleApiClient", (Throwable)paramObject);
      return;
    }
    catch (NoSuchMethodException paramObject)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to call connect on GoogleApiClient", (Throwable)paramObject);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to call connect on GoogleApiClient", (Throwable)paramObject);
      return;
    }
    catch (InvocationTargetException paramObject)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to call connect on GoogleApiClient", (Throwable)paramObject);
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    try
    {
      int i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(com.inmobi.commons.a.a.b());
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Google Play Services is not installed!");
      return false;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException.printStackTrace();
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", "RuntimeException");
      localHashMap.put("message", localRuntimeException.getMessage());
      com.inmobi.commons.core.c.a.a().a("signals", "ExceptionCaught", localHashMap);
    }
    return false;
  }
  
  public static void b(Object paramObject)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Disconnecting Google API client.");
    if (paramObject == null) {
      return;
    }
    try
    {
      Class.forName("com.google.android.gms.common.api.GoogleApiClient").getMethod("disconnect", (Class[])null).invoke(paramObject, (Object[])null);
      return;
    }
    catch (NoSuchMethodException paramObject)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to call disconnect on GoogleApiClient", (Throwable)paramObject);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to call disconnect on GoogleApiClient", (Throwable)paramObject);
      return;
    }
    catch (InvocationTargetException paramObject)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to call disconnect on GoogleApiClient", (Throwable)paramObject);
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to call disconnect on GoogleApiClient", (Throwable)paramObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */