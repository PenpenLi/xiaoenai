package com.inmobi.commons.core.utilities;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
{
  private static final String a = a.class.getSimpleName();
  private static List<b> b = new ArrayList();
  private static Object c;
  private static boolean d = false;
  private static HandlerThread e = null;
  private static final Object f = new Object();
  private static volatile a g;
  
  public static a a()
  {
    Object localObject1 = g;
    if (localObject1 == null) {
      synchronized (f)
      {
        a locala2 = g;
        localObject1 = locala2;
        if (locala2 == null)
        {
          localObject1 = new a();
          g = (a)localObject1;
        }
        return (a)localObject1;
      }
    }
    return locala1;
  }
  
  public static void b()
  {
    d = true;
  }
  
  private static void b(boolean paramBoolean)
  {
    new Handler(com.inmobi.commons.a.a.b().getMainLooper()).post(new a.2(paramBoolean));
  }
  
  public static void c()
  {
    d = false;
  }
  
  @TargetApi(14)
  private void h()
  {
    e = new HandlerThread("ApplicationFocusChangeObserverHandler");
    e.start();
    Object localObject3 = Application.class.getDeclaredClasses();
    Object localObject1 = null;
    int j = localObject3.length;
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      localObject2 = localObject3[i];
      if (!((Class)localObject2).getSimpleName().equalsIgnoreCase("ActivityLifecycleCallbacks")) {
        break label229;
      }
      localObject1 = localObject2;
    }
    label229:
    for (;;)
    {
      i += 1;
      break;
      localObject2 = ((Class)localObject1).getClassLoader();
      localObject3 = new a.1(this);
      c = Proxy.newProxyInstance((ClassLoader)localObject2, new Class[] { localObject1 }, (InvocationHandler)localObject3);
      localObject2 = (Application)com.inmobi.commons.a.a.b();
      if (c != null) {}
      try
      {
        Application.class.getMethod("registerActivityLifecycleCallbacks", new Class[] { localObject1 }).invoke(localObject2, new Object[] { c });
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while registering activity life cycle listener.", localNoSuchMethodException);
        return;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while registering activity life cycle listener.", localInvocationTargetException);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while registering activity life cycle listener.", localIllegalAccessException);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        localObject2 = new HashMap();
        ((Map)localObject2).put("type", "NullPointerException");
        ((Map)localObject2).put("message", localNullPointerException.getMessage());
        com.inmobi.commons.core.c.a.a().a("root", "ExceptionCaught", (Map)localObject2);
        return;
      }
    }
  }
  
  @TargetApi(14)
  private void i()
  {
    try
    {
      Application localApplication = (Application)com.inmobi.commons.a.a.b();
      if (c != null) {
        Application.class.getMethod("unregisterActivityLifecycleCallbacks", (Class[])null).invoke(localApplication, (Object[])c);
      }
      e.stop();
      e = null;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while unregistering activity life cycle listener.", localNoSuchMethodException);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while unregistering activity life cycle listener.", localInvocationTargetException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while unregistering activity life cycle listener.", localIllegalAccessException);
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("type", "NullPointerException");
        localHashMap.put("message", localNullPointerException.getMessage());
        com.inmobi.commons.core.c.a.a().a("root", "ExceptionCaught", localHashMap);
      }
    }
  }
  
  public void a(b paramb)
  {
    if (Build.VERSION.SDK_INT < 14) {}
    do
    {
      return;
      b.add(paramb);
    } while (b.size() != 1);
    h();
  }
  
  public void b(b paramb)
  {
    if (Build.VERSION.SDK_INT < 14) {}
    do
    {
      return;
      b.remove(paramb);
    } while (b.size() != 0);
    i();
  }
  
  static class a
    extends Handler
  {
    boolean a = true;
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (a.f()) {}
      do
      {
        return;
        if ((paramMessage.what == 1001) && (this.a))
        {
          this.a = false;
          a.a(false);
          Logger.a(Logger.InternalLogLevel.INTERNAL, a.g(), "App has gone to background.");
          return;
        }
      } while ((paramMessage.what != 1002) || (this.a));
      this.a = true;
      a.a(true);
      Logger.a(Logger.InternalLogLevel.INTERNAL, a.g(), "App has come to foreground.");
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */