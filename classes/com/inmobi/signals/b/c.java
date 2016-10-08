package com.inmobi.signals.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.List;

public class c
{
  private static final String a = c.class.getSimpleName();
  private static Context b = null;
  private static a c = null;
  private static Handler d = null;
  private static boolean e = false;
  private static final IntentFilter f = new IntentFilter("android.net.wifi.SCAN_RESULTS");
  private static List<a> g;
  private static Runnable h = new c.1();
  private static final BroadcastReceiver i = new c.2();
  
  public static List<a> a()
  {
    return g;
  }
  
  /* Error */
  private static boolean a(Looper paramLooper, a parama, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 41	com/inmobi/signals/b/c:d	Landroid/os/Handler;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnull +12 -> 22
    //   13: iconst_0
    //   14: istore 4
    //   16: ldc 2
    //   18: monitorexit
    //   19: iload 4
    //   21: ireturn
    //   22: invokestatic 78	com/inmobi/commons/a/a:b	()Landroid/content/Context;
    //   25: ldc 80
    //   27: invokevirtual 86	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast 88	android/net/wifi/WifiManager
    //   33: astore 5
    //   35: aload 5
    //   37: invokevirtual 92	android/net/wifi/WifiManager:isWifiEnabled	()Z
    //   40: ifne +9 -> 49
    //   43: iconst_0
    //   44: istore 4
    //   46: goto -30 -> 16
    //   49: aload_1
    //   50: putstatic 39	com/inmobi/signals/b/c:c	Lcom/inmobi/signals/b/c$a;
    //   53: new 94	android/os/Handler
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 97	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   61: putstatic 41	com/inmobi/signals/b/c:d	Landroid/os/Handler;
    //   64: getstatic 41	com/inmobi/signals/b/c:d	Landroid/os/Handler;
    //   67: getstatic 59	com/inmobi/signals/b/c:h	Ljava/lang/Runnable;
    //   70: lload_2
    //   71: invokevirtual 101	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   74: pop
    //   75: invokestatic 103	com/inmobi/signals/b/c:h	()V
    //   78: aload 5
    //   80: invokevirtual 106	android/net/wifi/WifiManager:startScan	()Z
    //   83: istore 4
    //   85: goto -69 -> 16
    //   88: astore_0
    //   89: ldc 2
    //   91: monitorexit
    //   92: aload_0
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramLooper	Looper
    //   0	94	1	parama	a
    //   0	94	2	paramLong	long
    //   0	94	4	paramBoolean	boolean
    //   6	73	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	8	88	finally
    //   22	43	88	finally
    //   49	85	88	finally
  }
  
  public static boolean a(a parama)
  {
    b = com.inmobi.commons.a.a.b();
    return a(Looper.myLooper(), parama, 10000L, false);
  }
  
  /* Error */
  private static void f()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 41	com/inmobi/signals/b/c:d	Landroid/os/Handler;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 41	com/inmobi/signals/b/c:d	Landroid/os/Handler;
    //   18: getstatic 59	com/inmobi/signals/b/c:h	Ljava/lang/Runnable;
    //   21: invokevirtual 124	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   24: invokestatic 126	com/inmobi/signals/b/c:g	()V
    //   27: aconst_null
    //   28: putstatic 41	com/inmobi/signals/b/c:d	Landroid/os/Handler;
    //   31: aconst_null
    //   32: putstatic 39	com/inmobi/signals/b/c:c	Lcom/inmobi/signals/b/c$a;
    //   35: aconst_null
    //   36: putstatic 37	com/inmobi/signals/b/c:b	Landroid/content/Context;
    //   39: goto -28 -> 11
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	localHandler	Handler
    //   42	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	42	finally
    //   15	39	42	finally
  }
  
  private static void g()
  {
    if (!e) {
      return;
    }
    e = false;
    try
    {
      b.unregisterReceiver(i);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Failed to register for Wifi scanning.");
    }
  }
  
  private static void h()
  {
    if (e) {
      return;
    }
    e = true;
    b.registerReceiver(i, f, null, d);
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(List<a> paramList);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */