package com.inmobi.commons.core.utilities.uid;

import android.content.Context;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class c$1
  implements Runnable
{
  c$1(c paramc, b paramb) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
      Object localObject1 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
      localObject2 = ((Class)localObject2).getDeclaredMethod("getAdvertisingIdInfo", new Class[] { Context.class }).invoke(null, new Object[] { com.inmobi.commons.a.a.b() });
      String str = (String)((Class)localObject1).getDeclaredMethod("getId", (Class[])null).invoke(localObject2, (Object[])null);
      c.o().a(str);
      this.a.a(str);
      localObject1 = (Boolean)((Class)localObject1).getDeclaredMethod("isLimitAdTrackingEnabled", (Class[])null).invoke(localObject2, (Object[])null);
      c.o().a(((Boolean)localObject1).booleanValue());
      this.a.a(((Boolean)localObject1).booleanValue());
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, c.p(), "Failed to fetch advertising id.", localNoSuchMethodException);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, c.p(), "Failed to fetch advertising id.", localInvocationTargetException);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, c.p(), "Failed to fetch advertising id.", localClassNotFoundException);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, c.p(), "Failed to fetch advertising id.", localIllegalAccessException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\uid\c$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */