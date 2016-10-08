package com.alibaba.nb.android.trade.service.log;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.constants.AliTradeLogConstant;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public final class a
{
  private static a e = new a();
  private static SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd");
  private static String l = "Log.txt";
  private volatile boolean a = false;
  private long b = 0L;
  private HandlerThread c;
  private Handler d;
  private long f = 512000L;
  private StringBuilder h = new StringBuilder(512);
  private StringBuilder i = new StringBuilder(512);
  private Formatter j = new Formatter(this.i, Locale.getDefault());
  private int k = 19;
  
  public static a a()
  {
    return e;
  }
  
  private String b(c paramc)
  {
    int m = 0;
    if (paramc == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        this.h.setLength(0);
        if (paramc.a != null) {
          this.h.append(paramc.a.getName());
        }
        this.h.append('\001');
        this.h.append(paramc.f);
        this.h.append('\001');
        this.h.append(paramc.c);
        this.h.append('\001');
        this.h.append(paramc.d);
        this.h.append(",");
        this.h.append(paramc.e);
        this.h.append('\001');
        this.h.append(paramc.b);
        this.h.append('\001');
        if (TextUtils.isEmpty(paramc.i))
        {
          if ((paramc.g != null) && (m < paramc.g.length))
          {
            this.h.append(paramc.g[m]);
            if (m == paramc.g.length - 1) {
              break label295;
            }
            this.h.append(" ");
            break label295;
          }
        }
        else
        {
          this.h.append(String.format(paramc.i, paramc.g));
          this.i.setLength(0);
          this.h.append(this.j.format(paramc.i, paramc.g).toString());
        }
        this.h.append(AliTradeLogConstant.SEPARATOR);
        paramc = this.h.substring(0);
        return paramc;
      }
      catch (Exception paramc)
      {
        return null;
      }
      label295:
      m += 1;
    }
  }
  
  public static File c()
  {
    String str = g.format(new Date()) + ".log";
    return new File(g(), str);
  }
  
  public static void d()
  {
    Object localObject1 = g();
    if (localObject1 != null) {}
    for (localObject1 = ((File)localObject1).listFiles(); localObject1 != null; localObject1 = null)
    {
      int n = localObject1.length;
      int m = 0;
      while (m < n)
      {
        Object localObject2 = localObject1[m];
        if (new Date().getTime() - ((File)localObject2).lastModified() > 604800000L) {
          ((File)localObject2).delete();
        }
        m += 1;
      }
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/alibaba/nb/android/trade/service/log/a:a	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: new 234	android/os/HandlerThread
    //   18: dup
    //   19: ldc -20
    //   21: aload_0
    //   22: getfield 80	com/alibaba/nb/android/trade/service/log/a:k	I
    //   25: invokespecial 239	android/os/HandlerThread:<init>	(Ljava/lang/String;I)V
    //   28: putfield 241	com/alibaba/nb/android/trade/service/log/a:c	Landroid/os/HandlerThread;
    //   31: aload_0
    //   32: getfield 241	com/alibaba/nb/android/trade/service/log/a:c	Landroid/os/HandlerThread;
    //   35: invokevirtual 244	android/os/HandlerThread:start	()V
    //   38: aload_0
    //   39: new 246	com/alibaba/nb/android/trade/service/log/b
    //   42: dup
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 241	com/alibaba/nb/android/trade/service/log/a:c	Landroid/os/HandlerThread;
    //   48: invokevirtual 250	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   51: invokespecial 253	com/alibaba/nb/android/trade/service/log/b:<init>	(Lcom/alibaba/nb/android/trade/service/log/a;Landroid/os/Looper;)V
    //   54: putfield 255	com/alibaba/nb/android/trade/service/log/a:d	Landroid/os/Handler;
    //   57: aload_0
    //   58: iconst_1
    //   59: putfield 50	com/alibaba/nb/android/trade/service/log/a:a	Z
    //   62: goto -51 -> 11
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	a
    //   65	4	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	65	finally
    //   14	62	65	finally
  }
  
  private static File g()
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (File localFile = new File(AliTradeContext.context.getExternalFilesDir(null) + "/baichuan/log");; localFile = new File(AliTradeContext.context.getFilesDir() + "/baichuan/log"))
    {
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return localFile;
    }
  }
  
  public final void a(c paramc)
  {
    if (!this.a) {
      f();
    }
    if ((!this.a) || (paramc == null) || (this.d == null)) {}
    Message localMessage;
    do
    {
      return;
      localMessage = this.d.obtainMessage();
      localMessage.obj = paramc;
      this.b += paramc.h;
      if (AliTradeContext.isDebugable()) {
        Log.v("TLog.AliTradeLogCache", "the message length is : " + paramc.h + "   and the messageQueue size is : " + this.b);
      }
    } while (!this.d.getLooper().getThread().isAlive());
    localMessage.what = 1;
    this.d.sendMessage(localMessage);
  }
  
  public final boolean b()
  {
    return this.b > this.f;
  }
  
  public final void e()
  {
    if (this.d == null) {
      return;
    }
    Message localMessage = this.d.obtainMessage(7);
    this.d.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\service\log\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */