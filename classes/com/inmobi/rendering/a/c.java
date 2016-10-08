package com.inmobi.rendering.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.support.annotation.VisibleForTesting;
import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.network.NetworkError.ErrorCode;
import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.network.d;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@VisibleForTesting
public class c
  implements com.inmobi.commons.core.configs.b.b
{
  @VisibleForTesting
  public static com.inmobi.ads.b.b a;
  private static final String b = c.class.getSimpleName();
  private static c c;
  private static final Object d = new Object();
  private static ExecutorService e;
  private static a f;
  private static HandlerThread g;
  private static List<a> h = new ArrayList();
  private static b i;
  private static AtomicBoolean j = new AtomicBoolean(false);
  private static final Object k = new Object();
  private boolean l = false;
  private PowerManager m;
  private final d n = new c.4(this);
  
  @VisibleForTesting
  public c()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Creating a new instance ...");
    d();
  }
  
  public static c a()
  {
    Object localObject1 = c;
    if (localObject1 == null) {
      synchronized (d)
      {
        c localc2 = c;
        localObject1 = localc2;
        if (localc2 == null)
        {
          localObject1 = new c();
          c = (c)localObject1;
        }
        return (c)localObject1;
      }
    }
    return localc1;
  }
  
  private void b(a parama)
  {
    if (parama.f > 0)
    {
      parama.f -= 1;
      parama.d = System.currentTimeMillis();
      i.a(parama);
    }
  }
  
  @TargetApi(23)
  private void i()
  {
    e.a().a("android.net.conn.CONNECTIVITY_CHANGE", new c.2(this));
    if (Build.VERSION.SDK_INT >= 23) {
      e.a().a("android.os.action.DEVICE_IDLE_MODE_CHANGED", new c.3(this));
    }
  }
  
  public void a(com.inmobi.commons.core.configs.a parama)
  {
    a = ((com.inmobi.ads.b)parama).i();
  }
  
  @VisibleForTesting
  protected void a(a parama)
  {
    i.a(parama, a.d());
    if (!com.inmobi.commons.core.utilities.c.a())
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, b, "No network available. Saving click for later processing ...");
      j.set(false);
      c();
      return;
    }
    e.submit(new c.1(this, parama));
  }
  
  public void a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    paramString = new a(paramString, paramMap, paramBoolean, false, a.a() + 1);
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Received click (" + paramString.a + ") for pinging over HTTP");
    a(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    paramString = new a(paramString, paramBoolean, false, a.a() + 1);
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Received click (" + paramString.a + ") for pinging over HTTP");
    a(paramString);
  }
  
  public void b()
  {
    if (!com.inmobi.commons.core.utilities.c.a()) {
      return;
    }
    for (;;)
    {
      synchronized (k)
      {
        if (j.compareAndSet(false, true))
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Resume processing clicks ...");
          if (g == null)
          {
            g = new HandlerThread("pingHandlerThread");
            g.start();
          }
          if (f == null) {
            f = new a(g.getLooper());
          }
          if (i.a())
          {
            Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Done processing all clicks!");
            j.set(false);
            c();
          }
        }
        else
        {
          return;
        }
      }
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      f.sendMessage(localMessage);
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    paramString = new a(paramString, paramBoolean, true, a.a() + 1);
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Received click (" + paramString.a + ") for pinging in WebView");
    a(paramString);
  }
  
  public void c()
  {
    j.set(false);
    synchronized (k)
    {
      if (!j.get())
      {
        if (g != null)
        {
          g.getLooper().quit();
          g.interrupt();
          g = null;
          f = null;
        }
        h.clear();
      }
      return;
    }
  }
  
  @VisibleForTesting
  public void d()
  {
    e = Executors.newFixedThreadPool(5);
    g = new HandlerThread("pingHandlerThread");
    g.start();
    f = new a(g.getLooper());
    com.inmobi.ads.b localb = new com.inmobi.ads.b();
    com.inmobi.commons.core.configs.b.a().a(localb, this);
    a = localb.i();
    i = new b();
    this.m = ((PowerManager)com.inmobi.commons.a.a.b().getSystemService("power"));
    i();
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    private void a(a parama)
    {
      Message localMessage = Message.obtain();
      if (parama.h) {}
      for (int i = 3;; i = 2)
      {
        localMessage.what = i;
        localMessage.obj = parama;
        sendMessage(localMessage);
        return;
      }
    }
    
    private void a(a parama, int paramInt)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 5;
      localMessage.obj = parama;
      localMessage.arg1 = paramInt;
      sendMessage(localMessage);
    }
    
    private void b(a parama)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      localMessage.obj = parama;
      sendMessage(localMessage);
    }
    
    private void c(a parama)
    {
      int i = c.g().indexOf(parama);
      Message localMessage;
      if (-1 != i)
      {
        if (i != c.g().size() - 1) {
          break label108;
        }
        i = 0;
        parama = (a)c.g().get(i);
        localMessage = Message.obtain();
        if (!parama.h) {
          break label115;
        }
      }
      label108:
      label115:
      for (i = 3;; i = 2)
      {
        localMessage.what = i;
        localMessage.obj = parama;
        if (System.currentTimeMillis() - parama.d >= c.a.b() * 1000) {
          break label120;
        }
        sendMessageDelayed(localMessage, c.a.b() * 1000);
        return;
        i += 1;
        break;
      }
      label120:
      sendMessage(localMessage);
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = 2;
      Object localObject;
      HashMap localHashMap;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        c.a(c.f().a(c.a.e(), c.a.b()));
        if (c.g().isEmpty())
        {
          if (c.f().a())
          {
            c.h().set(false);
            return;
          }
          paramMessage = Message.obtain();
          paramMessage.what = 1;
          sendMessageDelayed(paramMessage, c.a.b() * 1000);
          return;
        }
        paramMessage = (a)c.g().get(0);
        localObject = Message.obtain();
        if (paramMessage.h) {
          i = 3;
        }
        ((Message)localObject).what = i;
        ((Message)localObject).obj = paramMessage;
        long l = System.currentTimeMillis() - paramMessage.d;
        if (l < c.a.b() * 1000)
        {
          sendMessageDelayed((Message)localObject, c.a.b() * 1000 - l);
          return;
        }
        sendMessage((Message)localObject);
        return;
      case 2: 
        if (!com.inmobi.commons.core.utilities.c.a())
        {
          c.h().set(false);
          c.this.c();
          return;
        }
        paramMessage = (a)paramMessage.obj;
        if (paramMessage.f == 0)
        {
          a(paramMessage, 1);
          return;
        }
        if (paramMessage.a(c.a.f()))
        {
          a(paramMessage, 2);
          return;
        }
        i = c.a.a() - paramMessage.f + 1;
        if (i == 0) {
          Logger.a(Logger.InternalLogLevel.INTERNAL, c.e(), "Pinging click (" + paramMessage.a + ") over HTTP");
        }
        for (;;)
        {
          new c.c(new c.a.1(this)).a(paramMessage);
          return;
          Logger.a(Logger.InternalLogLevel.INTERNAL, c.e(), "Retry attempt #" + i + " for click (" + paramMessage.a + ") over HTTP");
        }
      case 3: 
        if (!com.inmobi.commons.core.utilities.c.a())
        {
          c.h().set(false);
          c.this.c();
          return;
        }
        paramMessage = (a)paramMessage.obj;
        if (paramMessage.f == 0)
        {
          a(paramMessage, 1);
          return;
        }
        if (paramMessage.a(c.a.f()))
        {
          a(paramMessage, 2);
          return;
        }
        i = c.a.a() - paramMessage.f + 1;
        if (i == 0) {
          Logger.a(Logger.InternalLogLevel.INTERNAL, c.e(), "Pinging click (" + paramMessage.a + ") in WebView");
        }
        for (;;)
        {
          new c.b(new c.a.2(this)).a(paramMessage);
          return;
          Logger.a(Logger.InternalLogLevel.INTERNAL, c.e(), "Retry attempt #" + i + " for click (" + paramMessage.a + ") using WebView");
        }
      case 5: 
        localObject = (a)paramMessage.obj;
        localHashMap = new HashMap();
        localHashMap.put("pingUrl", ((a)localObject).b);
        switch (paramMessage.arg1)
        {
        }
        break;
      }
      for (;;)
      {
        com.inmobi.commons.core.c.a.a().a("ads", "PingDiscarded", localHashMap);
        paramMessage = (a)paramMessage.obj;
        Logger.a(Logger.InternalLogLevel.INTERNAL, c.e(), "Processing click (" + paramMessage.a + ") completed");
        c.f().b(paramMessage);
        c.g().remove(paramMessage);
        if (!c.g().isEmpty()) {
          break label799;
        }
        if (!c.f().a()) {
          break;
        }
        Logger.a(Logger.InternalLogLevel.INTERNAL, c.e(), "Done processing all clicks!");
        c.h().set(false);
        return;
        localHashMap.put("errorCode", "MaxRetryCountReached");
        continue;
        localHashMap.put("errorCode", "ExpiredClick");
      }
      paramMessage = Message.obtain();
      paramMessage.what = 1;
      sendMessage(paramMessage);
      return;
      label799:
      a((a)c.g().get(0));
    }
  }
  
  static final class b
  {
    private c.d a;
    
    public b(c.d paramd)
    {
      this.a = paramd;
    }
    
    public void a(a parama)
    {
      parama.g.set(false);
      Handler localHandler = new Handler(Looper.getMainLooper());
      localHandler.post(new c.b.1(this, parama, localHandler));
    }
  }
  
  static final class c
  {
    private c.d a;
    
    public c(c.d paramd)
    {
      this.a = paramd;
    }
    
    public void a(a parama)
    {
      Object localObject = new NetworkRequest(NetworkRequest.RequestType.GET, parama.b, false, null);
      ((NetworkRequest)localObject).a(false);
      ((NetworkRequest)localObject).c(parama.c);
      ((NetworkRequest)localObject).b(parama.i);
      ((NetworkRequest)localObject).b(c.a.c() * 1000);
      ((NetworkRequest)localObject).c(c.a.c() * 1000);
      localObject = new d((NetworkRequest)localObject).a();
      if (((com.inmobi.commons.core.network.c)localObject).a())
      {
        NetworkError.ErrorCode localErrorCode = ((com.inmobi.commons.core.network.c)localObject).c().a();
        if ((!parama.i) && ((NetworkError.ErrorCode.HTTP_SEE_OTHER == localErrorCode) || (NetworkError.ErrorCode.HTTP_MOVED_TEMP == localErrorCode)))
        {
          this.a.a(parama);
          return;
        }
        this.a.a(parama, ((com.inmobi.commons.core.network.c)localObject).c().a());
        return;
      }
      this.a.a(parama);
    }
  }
  
  static abstract interface d
  {
    public abstract void a(a parama);
    
    public abstract void a(a parama, NetworkError.ErrorCode paramErrorCode);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */