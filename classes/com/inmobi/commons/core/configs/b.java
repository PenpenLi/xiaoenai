package com.inmobi.commons.core.configs;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static final String a = b.class.getSimpleName();
  private static final Object b = new Object();
  private static Map<a, ArrayList<WeakReference<b>>> c;
  private static g d;
  private static volatile b e;
  private static c f;
  private HandlerThread g;
  private a h;
  private boolean i = false;
  
  private b()
  {
    c = new HashMap();
    this.g = new HandlerThread("ConfigBootstrapHandler");
    this.g.start();
    this.h = new a(this.g.getLooper());
    d = new g();
  }
  
  public static b a()
  {
    Object localObject1 = e;
    if (localObject1 == null) {
      synchronized (b)
      {
        b localb2 = e;
        localObject1 = localb2;
        if (localb2 == null)
        {
          localObject1 = new b();
          e = (b)localObject1;
        }
        return (b)localObject1;
      }
    }
    return localb1;
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return System.currentTimeMillis() - paramLong1 > 1000L * paramLong2;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = true;
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int j = 0;
    for (;;)
    {
      int k;
      try
      {
        if (j >= paramString1.length) {
          break label167;
        }
        if (Integer.valueOf(paramString1[j]).intValue() >= 0) {
          break label160;
        }
        return false;
      }
      catch (NumberFormatException paramString1) {}
      if (j < paramString2.length)
      {
        k = Integer.valueOf(paramString2[j]).intValue();
        if (k >= 0) {
          j += 1;
        }
      }
      else
      {
        if (paramString1.length < paramString2.length)
        {
          j = paramString1.length;
          k = 0;
          if (k >= j) {
            continue;
          }
          if (paramString1[k].equals(paramString2[k])) {
            continue;
          }
          if (Integer.valueOf(paramString1[k]).intValue() < Integer.valueOf(paramString2[k]).intValue())
          {
            bool = true;
            return bool;
          }
        }
        else
        {
          j = paramString2.length;
          continue;
        }
        bool = false;
        continue;
        k += 1;
        continue;
        if (paramString1.length < paramString2.length) {
          return bool;
        }
        bool = false;
        continue;
      }
      return false;
      label160:
      j += 1;
      continue;
      label167:
      j = 0;
    }
  }
  
  private static void b(a parama)
  {
    ArrayList localArrayList = (ArrayList)c.get(parama);
    if (localArrayList != null)
    {
      int j = 0;
      while (j < localArrayList.size())
      {
        if ((localArrayList.get(j) != null) && (((WeakReference)localArrayList.get(j)).get() != null)) {
          ((b)((WeakReference)localArrayList.get(j)).get()).a(parama);
        }
        j += 1;
      }
    }
  }
  
  private void b(a parama, b paramb)
  {
    ArrayList localArrayList = (ArrayList)c.get(parama);
    if (localArrayList == null) {
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      if (paramb == null) {}
      for (paramb = null;; paramb = new WeakReference(paramb))
      {
        localArrayList.add(paramb);
        c.put(parama, localArrayList);
        return;
      }
    }
  }
  
  private final void c(a parama)
  {
    for (;;)
    {
      c localc;
      try
      {
        localc = new c();
        if (!localc.a(d.a()))
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "RootConfig not available. Fetching root and returning defaults for config type:" + parama.a());
          d(d.d());
          return;
        }
        localc.b(d);
        if (a(localc.b(d.a()), d.a(d.a())))
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "RootConfig expired. Fetching root.");
          d(d.d());
        }
        if (!localc.a(parama.a()))
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Requested config not present. Returning default and fetching. Config type:" + parama.a());
          d(parama.d());
          continue;
        }
        localc.b(parama);
      }
      finally {}
      if (a(localc.b(parama.a()), d.a(parama.a())))
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Requested config expired. Returning currently cached and fetching. Config type:" + parama.a());
        d(parama.d());
      }
      else
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Serving config from cache. Config:" + parama.a());
      }
    }
  }
  
  private void d(a parama)
  {
    Message localMessage = this.h.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = parama;
    this.h.sendMessage(localMessage);
  }
  
  private void g()
  {
    Iterator localIterator = c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getKey();
      c(locala);
      b(locala);
    }
  }
  
  /* Error */
  public final void a(a parama, b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/inmobi/commons/core/configs/b:i	Z
    //   6: ifne +37 -> 43
    //   9: getstatic 167	com/inmobi/commons/core/utilities/Logger$InternalLogLevel:INTERNAL	Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;
    //   12: getstatic 39	com/inmobi/commons/core/configs/b:a	Ljava/lang/String;
    //   15: new 169	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   22: ldc -1
    //   24: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 179	com/inmobi/commons/core/configs/a:a	()Ljava/lang/String;
    //   31: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 187	com/inmobi/commons/core/utilities/Logger:a	(Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: aload_0
    //   44: aload_1
    //   45: aload_2
    //   46: invokespecial 257	com/inmobi/commons/core/configs/b:b	(Lcom/inmobi/commons/core/configs/a;Lcom/inmobi/commons/core/configs/b$b;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 253	com/inmobi/commons/core/configs/b:c	(Lcom/inmobi/commons/core/configs/a;)V
    //   54: goto -14 -> 40
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	b
    //   0	62	1	parama	a
    //   0	62	2	paramb	b
    // Exception table:
    //   from	to	target	type
    //   2	40	57	finally
    //   43	54	57	finally
  }
  
  public void b()
  {
    try
    {
      if (!this.i)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Starting config component.");
        this.i = true;
        com.inmobi.commons.core.c.a.a().a("root", d.i());
        if (f == null)
        {
          f = new c();
          a(d, f);
        }
        g();
      }
      return;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      if (this.i)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Stopping config component.");
        this.i = false;
        this.h.sendEmptyMessage(5);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void d()
  {
    String str1 = d.h().a();
    String str2 = d.h().b();
    if ((str1.trim().length() != 0) && (a(com.inmobi.commons.a.b.c(), str1.trim()))) {
      Logger.a(Logger.InternalLogLevel.DEBUG, a, "A newer version (version " + str1 + ") of the InMobi SDK is available! " + "You are currently on an older version (Version " + com.inmobi.commons.a.b.c() + "). Please download the latest InMobi SDK from " + str2);
    }
  }
  
  static final class a
    extends Handler
    implements d.a
  {
    private List<a> a = new ArrayList();
    private Map<String, Map<String, a>> b = new HashMap();
    private Map<String, a> c = new HashMap();
    private ExecutorService d;
    
    a(Looper paramLooper)
    {
      super();
    }
    
    private void a(String paramString, Map<String, a> paramMap)
    {
      int i = b.f().f();
      int j = b.f().e();
      paramString = new d(this, new e(paramMap, new com.inmobi.commons.core.utilities.uid.d(b.f().o().a()), paramString, j, i));
      this.d.execute(paramString);
    }
    
    private void a(List<a> paramList)
    {
      int i = 0;
      while (i < paramList.size())
      {
        a locala = (a)paramList.get(i);
        HashMap localHashMap2 = (HashMap)this.b.get(b.f().b(locala.a()));
        HashMap localHashMap1 = localHashMap2;
        if (localHashMap2 == null) {
          localHashMap1 = new HashMap();
        }
        localHashMap1.put(locala.a(), locala);
        this.b.put(b.f().b(locala.a()), localHashMap1);
        i += 1;
      }
    }
    
    private boolean a(String paramString)
    {
      if ((this.b.get(b.f().b(paramString)) != null) && (((Map)this.b.get(b.f().b(paramString))).containsKey(paramString))) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (this.c != null)
        {
          bool2 = bool1;
          if (this.c.containsKey(paramString)) {
            bool2 = true;
          }
        }
        return bool2;
      }
    }
    
    public void a()
    {
      if ((this.d != null) && (!this.d.isShutdown()))
      {
        this.c = null;
        this.b.clear();
        removeMessages(3);
        this.d.shutdownNow();
      }
    }
    
    public void a(ConfigNetworkResponse.ConfigResponse paramConfigResponse)
    {
      c localc = new c();
      if (!paramConfigResponse.d())
      {
        if (paramConfigResponse.b() == ConfigNetworkResponse.ConfigResponse.ConfigResponseStatus.NOT_MODIFIED)
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, b.e(), "Config not modified status from server:" + paramConfigResponse.a().a());
          localc.a(paramConfigResponse.a().a(), System.currentTimeMillis());
          return;
        }
        localc.a(paramConfigResponse.a());
        try
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, b.e(), "Config cached successfully:" + paramConfigResponse.a().a());
          Logger.a(Logger.InternalLogLevel.INTERNAL, b.e(), "Config cached successfully:" + paramConfigResponse.a().b().toString());
          b.a(paramConfigResponse.a());
          return;
        }
        catch (JSONException paramConfigResponse)
        {
          paramConfigResponse.printStackTrace();
          return;
        }
      }
      Logger.a(Logger.InternalLogLevel.INTERNAL, b.e(), "Config fetching failed:" + paramConfigResponse.a().a() + ", Error code:" + paramConfigResponse.c().a());
    }
    
    public void b()
    {
      sendEmptyMessage(4);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 1: 
      case 2: 
      case 3: 
        do
        {
          do
          {
            return;
            paramMessage = (a)paramMessage.obj;
            Logger.a(Logger.InternalLogLevel.INTERNAL, b.e(), "Fetch requested for config:" + paramMessage.a() + ". IsAlreadyScheduled:" + a(paramMessage.a()));
            if (a(paramMessage.a())) {
              break;
            }
            this.a.add(paramMessage);
          } while (hasMessages(2));
          sendEmptyMessage(2);
          return;
          Logger.a(Logger.InternalLogLevel.INTERNAL, b.e(), "Config fetching already in progress:" + paramMessage.a());
          return;
          sendEmptyMessageDelayed(3, b.f().g() * 1000);
          return;
          a(this.a);
          this.a.clear();
        } while ((this.d != null) && (!this.d.isShutdown()));
        this.d = Executors.newFixedThreadPool(1);
        sendEmptyMessage(4);
        return;
      case 4: 
        if (this.b.isEmpty()) {
          break;
        }
      }
      for (paramMessage = (Map.Entry)this.b.entrySet().iterator().next();; paramMessage = null)
      {
        if (paramMessage != null)
        {
          this.c = ((Map)paramMessage.getValue());
          this.b.remove(paramMessage.getKey());
          a((String)paramMessage.getKey(), this.c);
          return;
        }
        Logger.a(Logger.InternalLogLevel.INTERNAL, b.e(), "Config fetching stopping as no more configs left to fetch.");
        sendEmptyMessage(5);
        return;
        a();
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(a parama);
  }
  
  static class c
    implements b.b
  {
    public void a(a parama)
    {
      b.a((g)parama);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\configs\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */