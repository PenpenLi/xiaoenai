package com.inmobi.commons.core.c;

import android.content.ContentValues;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.configs.b.b;
import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements b.b
{
  private static final String a = a.class.getSimpleName();
  private static final Object b = new Object();
  private static volatile a c;
  private static boolean d = false;
  private static final AtomicBoolean e = new AtomicBoolean(false);
  private static Map<String, b> f;
  private static c h;
  private static final Random o = new Random(System.currentTimeMillis());
  private List<e> g = new ArrayList();
  private HandlerThread i;
  private a j;
  private Map<String, Integer> k;
  private final Object l = new Object();
  private final Object m = new Object();
  private final Object n = new Object();
  
  private a()
  {
    f = new HashMap();
    this.k = new HashMap();
    h = new c();
    e.set(com.inmobi.commons.core.utilities.c.a());
    com.inmobi.commons.core.configs.b.a().a(h, this);
    a(h.a(), h.m());
    a.1 local1 = new a.1(this);
    com.inmobi.commons.core.utilities.e.a().a("android.net.conn.CONNECTIVITY_CHANGE", local1);
  }
  
  public static a a()
  {
    Object localObject1 = c;
    if (localObject1 == null) {
      synchronized (b)
      {
        a locala2 = c;
        localObject1 = locala2;
        if (locala2 == null)
        {
          localObject1 = new a();
          c = (a)localObject1;
        }
        return (a)localObject1;
      }
    }
    return locala1;
  }
  
  private String a(String paramString1, String paramString2)
  {
    return paramString1 + "@$#$@" + paramString2;
  }
  
  private void a(int paramInt)
  {
    if ((!com.inmobi.commons.a.a.e()) || (!com.inmobi.commons.core.utilities.c.a())) {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "App not in foreground or No Network available");
    }
    while (this.j == null) {
      return;
    }
    if (paramInt > 0)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Begin reporting after " + paramInt + " seconds");
      this.j.sendEmptyMessageDelayed(1, paramInt * 1000);
      return;
    }
    this.j.sendEmptyMessage(1);
  }
  
  private void a(String paramString, b paramb)
  {
    if ((paramString == null) || (paramString.trim().equals("")))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Component type provided while registering is null or empty!");
      return;
    }
    if (paramb != null)
    {
      f.put(paramString, paramb);
      return;
    }
    f.put(paramString, new b(paramString, null, h.m()));
  }
  
  private String[] b(String paramString)
  {
    return paramString.split("\\@\\$\\#\\$\\@");
  }
  
  private void c(e parame)
  {
    b localb = g(parame);
    if ((localb == null) || (!localb.b()) || (!h.e()))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Telemetry service is not enabled or registered for component: " + parame.a());
      return;
    }
    d(parame);
    e(parame);
  }
  
  private void d(e parame)
  {
    if (h(parame).c()) {
      b(parame);
    }
  }
  
  private void e(e parame)
  {
    int i1 = h(parame).b();
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Event Sampling factor: " + i1);
    if (i1 <= 0)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Sampling factor is <=0 for this event!");
      return;
    }
    if (o.nextInt(i1) != 0)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Event " + parame.b() + " is not lucky enough to be processed further");
      return;
    }
    f(parame);
  }
  
  private void f(e parame)
  {
    if ((parame instanceof com.inmobi.commons.core.a.b))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Got a crash event, will save it right away!");
      new d().a(parame);
    }
    for (;;)
    {
      return;
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Caching event " + parame.b() + " in memory");
      int i1 = h.h();
      synchronized (this.n)
      {
        this.g.add(parame);
        if (this.g.size() < i1) {
          continue;
        }
        g();
        i1 = new d().c();
        int i2 = h.l();
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Current event count: " + i1 + " Upper cap: " + i2);
        if (i1 <= i2 * 3 / 4) {
          continue;
        }
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Telemetry is more than 75% full. Begin reporting ");
        h();
        return;
      }
    }
  }
  
  private b g(e parame)
  {
    return a().a(parame.a());
  }
  
  private void g()
  {
    for (;;)
    {
      int i1;
      synchronized (this.n)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Adding events " + this.g.toString() + "to persistence");
        d locald = new d();
        i1 = h.l();
        int i2 = locald.c();
        if (this.g.size() + i2 - i1 <= 0)
        {
          locald.a(this.g);
          this.g.clear();
          return;
        }
        i1 -= i2;
        if (i1 <= 0) {
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Persistence is full, won't add events");
        }
      }
      ((d)localObject2).a(this.g.subList(0, i1));
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Persistence will overflow, will add " + i1 + " events to persistence");
    }
  }
  
  private b.a h(e parame)
  {
    return g(parame).a(parame.b());
  }
  
  private void h()
  {
    a(0);
  }
  
  private void i()
  {
    synchronized (this.m)
    {
      if (this.i != null)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Deiniting telemetry");
        this.i.getLooper().quit();
        this.i.interrupt();
        this.i = null;
        this.j = null;
        d = false;
      }
      return;
    }
  }
  
  private void j()
  {
    synchronized (this.l)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Saving metric to persistence");
      d locald = new d();
      locald.b();
      Iterator localIterator = this.k.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String[] arrayOfString = b((String)localEntry.getKey());
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("count", localEntry.getValue());
            locald.a(arrayOfString[0], arrayOfString[1], localJSONObject.toString());
          }
          catch (JSONException localJSONException)
          {
            Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error forming metric payload");
          }
        }
      }
    }
    this.k.clear();
  }
  
  b a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals("")))
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Request null or empty Component type!");
      return null;
    }
    return (b)f.get(paramString);
  }
  
  public void a(e parame)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Event submitted to telemetry: " + parame.b() + " - " + parame.a());
    if (this.j != null)
    {
      Message localMessage = this.j.obtainMessage();
      localMessage.what = 0;
      localMessage.obj = parame;
      this.j.sendMessage(localMessage);
    }
  }
  
  public void a(com.inmobi.commons.core.configs.a parama)
  {
    h = (c)parama;
  }
  
  public void a(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    paramString1 = new e(paramString1, paramString2);
    JSONObject localJSONObject;
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      try
      {
        localJSONObject = new JSONObject();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          localJSONObject.put(localEntry.getKey().toString(), localEntry.getValue());
          continue;
          a().a(paramString1);
        }
      }
      catch (JSONException paramMap)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error forming JSON payload for " + paramString2 + " Error: " + paramMap);
      }
    }
    for (;;)
    {
      return;
      paramString1.a(localJSONObject.toString());
    }
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    a(paramString, new b(paramString, paramJSONObject, h.m()));
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 165	com/inmobi/commons/core/utilities/Logger$InternalLogLevel:INTERNAL	Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;
    //   5: getstatic 47	com/inmobi/commons/core/c/a:a	Ljava/lang/String;
    //   8: ldc_w 462
    //   11: invokestatic 172	com/inmobi/commons/core/utilities/Logger:a	(Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 79	com/inmobi/commons/core/c/a:m	Ljava/lang/Object;
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: getstatic 54	com/inmobi/commons/core/c/a:d	Z
    //   24: ifne +47 -> 71
    //   27: iconst_1
    //   28: putstatic 54	com/inmobi/commons/core/c/a:d	Z
    //   31: aload_0
    //   32: new 347	android/os/HandlerThread
    //   35: dup
    //   36: ldc_w 464
    //   39: invokespecial 466	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   42: putfield 343	com/inmobi/commons/core/c/a:i	Landroid/os/HandlerThread;
    //   45: aload_0
    //   46: getfield 343	com/inmobi/commons/core/c/a:i	Landroid/os/HandlerThread;
    //   49: invokevirtual 469	android/os/HandlerThread:start	()V
    //   52: aload_0
    //   53: new 8	com/inmobi/commons/core/c/a$a
    //   56: dup
    //   57: aload_0
    //   58: aload_0
    //   59: getfield 343	com/inmobi/commons/core/c/a:i	Landroid/os/HandlerThread;
    //   62: invokevirtual 351	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   65: invokespecial 472	com/inmobi/commons/core/c/a$a:<init>	(Lcom/inmobi/commons/core/c/a;Landroid/os/Looper;)V
    //   68: putfield 174	com/inmobi/commons/core/c/a:j	Lcom/inmobi/commons/core/c/a$a;
    //   71: aload_1
    //   72: monitorexit
    //   73: invokestatic 314	com/inmobi/commons/core/c/a:a	()Lcom/inmobi/commons/core/c/a;
    //   76: invokespecial 312	com/inmobi/commons/core/c/a:h	()V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: astore_2
    //   83: aload_1
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	a
    //   87	4	1	localObject2	Object
    //   82	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   21	71	82	finally
    //   71	73	82	finally
    //   83	85	82	finally
    //   2	21	87	finally
    //   73	79	87	finally
    //   85	87	87	finally
  }
  
  void b(e arg1)
  {
    String str = ???.a();
    ??? = ???.b();
    Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Metric collected: " + ??? + " - " + str);
    str = a(str, ???);
    synchronized (this.l)
    {
      if (this.k.containsKey(str))
      {
        int i1 = ((Integer)this.k.get(str)).intValue();
        this.k.put(str, Integer.valueOf(i1 + 1));
        return;
      }
      this.k.put(str, Integer.valueOf(1));
    }
  }
  
  public void c()
  {
    try
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "stop called");
      if (this.j != null) {
        this.j.sendEmptyMessage(4);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private final class a
    extends Handler
  {
    private String b;
    private String c = null;
    private d d;
    private int e;
    private int f;
    private int g;
    private AtomicBoolean h = new AtomicBoolean(false);
    private int i = 0;
    private int j;
    private boolean k;
    private List<e> l = new ArrayList();
    
    public a(Looper paramLooper)
    {
      super();
      a();
    }
    
    private String a(List<e> paramList)
    {
      JSONArray localJSONArray = new JSONArray();
      int m = 0;
      try
      {
        while (m < paramList.size())
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("componentType", ((e)paramList.get(m)).a());
          localJSONObject.put("eventType", ((e)paramList.get(m)).b());
          if (!((e)paramList.get(m)).c().trim().isEmpty()) {
            localJSONObject.put("payload", ((e)paramList.get(m)).c());
          }
          localJSONObject.put("ts", ((e)paramList.get(m)).d());
          localJSONArray.put(localJSONObject);
          m += 1;
        }
        paramList = localJSONArray.toString();
        return paramList;
      }
      catch (JSONException paramList) {}
      return "";
    }
    
    private void a()
    {
      this.e = a.f().i();
      this.b = a.f().f();
      this.f = (a.f().k() * 1000);
      this.g = (a.f().g() * 1000);
      this.j = a.f().j();
    }
    
    private String b(List<ContentValues> paramList)
    {
      JSONArray localJSONArray = new JSONArray();
      int m = 0;
      try
      {
        while (m < paramList.size())
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("componentType", ((ContentValues)paramList.get(m)).getAsString("componentType"));
          localJSONObject.put("eventType", ((ContentValues)paramList.get(m)).getAsString("eventType"));
          localJSONObject.put("payload", ((ContentValues)paramList.get(m)).getAsString("payload"));
          localJSONArray.put(localJSONObject);
          m += 1;
        }
        paramList = localJSONArray.toString();
        return paramList;
      }
      catch (JSONException paramList) {}
      return "";
    }
    
    private void b()
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a.d(), "Begin reporting");
      this.d = new d();
      List localList = this.d.a();
      if (!localList.isEmpty()) {
        this.k = true;
      }
      for (this.c = b(localList);; this.c = a(this.l))
      {
        do
        {
          sendEmptyMessage(2);
          return;
        } while (((this.c != null) && (this.c.length() != 0)) || ((this.c != null) && (!this.c.equals(""))));
        this.k = false;
        if (this.l.isEmpty()) {
          this.l = this.d.a(this.e);
        }
        if (this.l.isEmpty())
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, a.d(), "No events to report");
          sendEmptyMessage(3);
          return;
        }
      }
    }
    
    private void c()
    {
      Object localObject = new com.inmobi.commons.core.utilities.uid.d(a.f().o().a());
      localObject = new NetworkRequest(NetworkRequest.RequestType.POST, this.b, true, (com.inmobi.commons.core.utilities.uid.d)localObject);
      HashMap localHashMap = new HashMap();
      if (this.k) {
        localHashMap.put("metric", this.c);
      }
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, a.d(), "Telemetry Payload: " + this.c);
        ((NetworkRequest)localObject).d(localHashMap);
        localObject = new com.inmobi.commons.core.network.d((NetworkRequest)localObject).a();
        if (!((com.inmobi.commons.core.network.c)localObject).a()) {
          break label277;
        }
        this.i += 1;
        if (this.i <= this.j) {
          break;
        }
        this.i = 0;
        Logger.a(Logger.InternalLogLevel.INTERNAL, a.d(), "Unable to send telemetry events to server: " + ((com.inmobi.commons.core.network.c)localObject).b() + " . And retry count exhausted. Will Discard Events");
        this.l.clear();
        this.c = null;
        sendEmptyMessage(3);
        return;
        localHashMap.put("telemetry", this.c);
      }
      Logger.a(Logger.InternalLogLevel.INTERNAL, a.d(), "Unable to send telemetry events to server: " + ((com.inmobi.commons.core.network.c)localObject).b() + ". Will retry");
      this.h.set(false);
      sendEmptyMessageDelayed(1, this.g);
      return;
      label277:
      Logger.a(Logger.InternalLogLevel.INTERNAL, a.d(), "Successfully sent events to server: " + ((com.inmobi.commons.core.network.c)localObject).b());
      this.c = null;
      this.l.clear();
      if (this.d.c() > this.e)
      {
        this.h.set(false);
        sendEmptyMessage(1);
        return;
      }
      sendEmptyMessage(3);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 0: 
      case 1: 
        do
        {
          return;
          paramMessage = (e)paramMessage.obj;
          a.a(a.this, paramMessage);
          return;
          removeMessages(1);
        } while (!this.h.compareAndSet(false, true));
        if ((!com.inmobi.commons.a.a.e()) || (!com.inmobi.commons.core.utilities.c.a()))
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, a.d(), "App not in foreground or No Network available ");
          this.h.set(false);
          return;
        }
        a();
        b();
        return;
      case 2: 
        c();
        return;
      case 3: 
        this.h.set(false);
        sendEmptyMessageDelayed(1, this.f);
        return;
      }
      a.a(a.a());
      a.b(a.a());
      a.c(a.a());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */