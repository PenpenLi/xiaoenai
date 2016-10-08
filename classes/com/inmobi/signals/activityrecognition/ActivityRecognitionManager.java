package com.inmobi.signals.activityrecognition;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.signals.h;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ActivityRecognitionManager
  extends IntentService
{
  private static final String a = ActivityRecognitionManager.class.getSimpleName();
  private static Object b = null;
  private static Object c = null;
  
  public ActivityRecognitionManager()
  {
    super("Activity service");
  }
  
  static void a()
  {
    if ((h.a()) && (c == null)) {
      a(a.b());
    }
  }
  
  private static void a(Context paramContext)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Connecting activity recognition manager.");
    c = h.a(paramContext, new a(null), new a(null), "com.google.android.gms.location.ActivityRecognition");
    h.a(c);
  }
  
  private static void a(Intent paramIntent)
  {
    try
    {
      Class localClass = Class.forName("com.google.android.gms.location.ActivityRecognitionResult");
      if (((Boolean)localClass.getMethod("hasResult", new Class[] { Intent.class }).invoke(null, new Object[] { paramIntent })).booleanValue())
      {
        paramIntent = localClass.getMethod("extractResult", new Class[] { Intent.class }).invoke(null, new Object[] { paramIntent });
        b = localClass.getMethod("getMostProbableActivity", (Class[])null).invoke(paramIntent, (Object[])null);
      }
      return;
    }
    catch (ClassNotFoundException paramIntent)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "HandleIntent: Google play services not included. Cannot get current activity.", paramIntent);
      return;
    }
    catch (NoSuchMethodException paramIntent)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "HandleIntent: Google play services not included. Cannot get current activity.", paramIntent);
      return;
    }
    catch (IllegalAccessException paramIntent)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "HandleIntent: Google play services not included. Cannot get current activity.", paramIntent);
      return;
    }
    catch (InvocationTargetException paramIntent)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "HandleIntent: Google play services not included. Cannot get current activity.", paramIntent);
    }
  }
  
  static void b()
  {
    if ((h.a()) && (c != null)) {
      f();
    }
  }
  
  public static int c()
  {
    if (b != null) {
      try
      {
        int i = ((Integer)Class.forName("com.google.android.gms.location.DetectedActivity").getMethod("getType", (Class[])null).invoke(b, (Object[])null)).intValue();
        return -1;
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        try
        {
          b = null;
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Getting detected activity:" + i);
          return i;
        }
        catch (IllegalAccessException localIllegalAccessException2)
        {
          for (;;) {}
        }
        catch (InvocationTargetException localInvocationTargetException2)
        {
          for (;;) {}
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          for (;;) {}
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          for (;;) {}
        }
        localClassNotFoundException1 = localClassNotFoundException1;
        i = -1;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "getDetectedActivity: Google play services not included. Returning null.", localClassNotFoundException1);
        return i;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        i = -1;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "getDetectedActivity: Google play services not included. Returning null.", localNoSuchMethodException1);
        return i;
      }
      catch (InvocationTargetException localInvocationTargetException1)
      {
        i = -1;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "getDetectedActivity: Google play services not included. Returning null.", localInvocationTargetException1);
        return i;
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        i = -1;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "getDetectedActivity: Google play services not included. Returning null.", localIllegalAccessException1);
        return i;
      }
    }
  }
  
  private static void f()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Disconnecting activity recognition manager.");
    h.b(c);
    b = null;
    c = null;
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (c != null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Got activity recognition intent.");
      a(paramIntent);
    }
  }
  
  private static class a
    implements InvocationHandler
  {
    public void a(int paramInt) {}
    
    public void a(Bundle paramBundle)
    {
      paramBundle = new Intent(a.b(), ActivityRecognitionManager.class);
      paramBundle = PendingIntent.getService(a.b(), 0, paramBundle, 134217728);
      try
      {
        Field localField = Class.forName("com.google.android.gms.location.ActivityRecognition").getDeclaredField("ActivityRecognitionApi");
        Class localClass = Class.forName("com.google.android.gms.common.api.GoogleApiClient");
        Class.forName("com.google.android.gms.location.ActivityRecognitionApi").getMethod("requestActivityUpdates", new Class[] { localClass, Long.TYPE, PendingIntent.class }).invoke(localField.get(null), new Object[] { ActivityRecognitionManager.d(), Integer.valueOf(1000), paramBundle });
        return;
      }
      catch (InvocationTargetException paramBundle)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", paramBundle);
        return;
      }
      catch (ClassNotFoundException paramBundle)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", paramBundle);
        return;
      }
      catch (IllegalAccessException paramBundle)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", paramBundle);
        return;
      }
      catch (NoSuchMethodException paramBundle)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", paramBundle);
        return;
      }
      catch (NoSuchFieldException paramBundle)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, ActivityRecognitionManager.e(), "Unable to request activity updates from ActivityRecognition client", paramBundle);
      }
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\activityrecognition\ActivityRecognitionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */