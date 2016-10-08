package cn.sharesdk.framework.statistics;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.statistics.b.g;
import com.mob.tools.f;
import java.io.File;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Random;

public class d
  extends f
{
  private static d a;
  private Context b;
  private com.mob.tools.b.c c;
  private a d;
  private String e;
  private Handler f;
  private boolean g;
  private int h;
  private boolean i;
  private long j;
  private boolean k;
  private File l;
  private com.mob.tools.b.d m;
  
  private d(Context paramContext, String paramString)
  {
    super("Thread-" + Math.abs(15802));
    this.b = paramContext;
    this.e = paramString;
    this.c = com.mob.tools.b.c.a(paramContext);
    this.d = a.a(paramContext, paramString);
    this.m = new com.mob.tools.b.d();
    this.l = new File(paramContext.getFilesDir(), ".statistics");
    if (!this.l.exists()) {}
    try
    {
      this.l.createNewFile();
      return;
    }
    catch (Exception paramContext)
    {
      cn.sharesdk.framework.utils.d.a().d(paramContext);
    }
  }
  
  /* Error */
  public static d a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 118	cn/sharesdk/framework/statistics/d:a	Lcn/sharesdk/framework/statistics/d;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +34 -> 44
    //   13: aload_0
    //   14: ifnonnull +8 -> 22
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_2
    //   21: areturn
    //   22: aload_1
    //   23: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne -9 -> 17
    //   29: new 2	cn/sharesdk/framework/statistics/d
    //   32: dup
    //   33: aload_0
    //   34: invokevirtual 128	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   37: aload_1
    //   38: invokespecial 130	cn/sharesdk/framework/statistics/d:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   41: putstatic 118	cn/sharesdk/framework/statistics/d:a	Lcn/sharesdk/framework/statistics/d;
    //   44: getstatic 118	cn/sharesdk/framework/statistics/d:a	Lcn/sharesdk/framework/statistics/d;
    //   47: astore_2
    //   48: goto -31 -> 17
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramContext	Context
    //   0	57	1	paramString	String
    //   1	47	2	locald1	d
    //   8	2	3	locald2	d
    // Exception table:
    //   from	to	target	type
    //   5	9	51	finally
    //   22	44	51	finally
    //   44	48	51	finally
  }
  
  private void a()
  {
    boolean bool = b();
    if (bool) {
      if (!this.k)
      {
        this.k = bool;
        this.j = System.currentTimeMillis();
        a(new g());
      }
    }
    while (!this.k) {
      return;
    }
    this.k = bool;
    long l1 = System.currentTimeMillis();
    long l2 = this.j;
    cn.sharesdk.framework.statistics.b.e locale = new cn.sharesdk.framework.statistics.b.e();
    locale.a = (l1 - l2);
    a(locale);
  }
  
  private void b(cn.sharesdk.framework.statistics.b.c paramc)
  {
    paramc.f = this.c.w();
    paramc.g = this.e;
    paramc.h = this.c.x();
    paramc.i = this.c.z();
    paramc.j = String.valueOf(60000 + this.h);
    paramc.k = this.c.v();
    paramc.l = this.c.u();
    if (TextUtils.isEmpty(this.e)) {
      System.err.println("Your appKey of ShareSDK is null , this will cause its data won't be count!");
    }
    for (;;)
    {
      paramc.m = this.c.i();
      return;
      if ((!"cn.sharesdk.demo".equals(paramc.h)) && (("api20".equals(this.e)) || ("androidv1101".equals(this.e)))) {
        System.err.println("Your app is using the appkey of ShareSDK Demo, this will cause its data won't be count!");
      }
    }
  }
  
  private boolean b()
  {
    Object localObject = com.mob.tools.b.c.a(this.b);
    String str = ((com.mob.tools.b.c)localObject).B();
    localObject = ((com.mob.tools.b.c)localObject).x();
    return (localObject != null) && (((String)localObject).equals(str));
  }
  
  private void c()
  {
    try
    {
      this.d.e();
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
    }
  }
  
  private void c(cn.sharesdk.framework.statistics.b.c paramc)
  {
    try
    {
      this.d.a(paramc);
      paramc.b(this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
      cn.sharesdk.framework.utils.d.a().w(paramc.toString(), new Object[0]);
    }
  }
  
  private void d()
  {
    int n = new Random().nextInt(120) + 60;
    cn.sharesdk.framework.utils.d.a().d("sendUploadCellInfoMsg deley second == " + n, new Object[0]);
    this.handler.sendEmptyMessageDelayed(5, n * 1000);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(Handler paramHandler)
  {
    this.f = paramHandler;
  }
  
  public void a(cn.sharesdk.framework.statistics.b.c paramc)
  {
    Message localMessage;
    if (this.i)
    {
      b(paramc);
      if (paramc.a(this.b))
      {
        localMessage = new Message();
        localMessage.what = 3;
        localMessage.obj = paramc;
      }
    }
    else
    {
      try
      {
        this.handler.sendMessage(localMessage);
        return;
      }
      catch (Throwable paramc)
      {
        cn.sharesdk.framework.utils.d.a().w(paramc);
        return;
      }
    }
    cn.sharesdk.framework.utils.d.a().d("Drop event: " + paramc.toString(), new Object[0]);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  protected void onMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int n;
    int i1;
    String str1;
    String str2;
    do
    {
      do
      {
        long l1;
        long l2;
        do
        {
          do
          {
            return;
          } while (paramMessage.obj == null);
          c((cn.sharesdk.framework.statistics.b.c)paramMessage.obj);
          return;
          a();
          try
          {
            this.handler.sendEmptyMessageDelayed(1, 1000L);
            return;
          }
          catch (Throwable paramMessage)
          {
            cn.sharesdk.framework.utils.d.a().w(paramMessage);
            return;
          }
          c();
          try
          {
            this.handler.sendEmptyMessageDelayed(2, 10000L);
            return;
          }
          catch (Throwable paramMessage)
          {
            cn.sharesdk.framework.utils.d.a().w(paramMessage);
            return;
          }
          l1 = cn.sharesdk.framework.statistics.a.e.a(this.b).h().longValue();
          paramMessage = Calendar.getInstance();
          paramMessage.setTimeInMillis(l1);
          n = paramMessage.get(1);
          i1 = paramMessage.get(2);
          int i2 = paramMessage.get(5);
          paramMessage.setTimeInMillis(System.currentTimeMillis());
          int i3 = paramMessage.get(1);
          int i4 = paramMessage.get(2);
          int i5 = paramMessage.get(5);
          if ((n != i3) || (i1 != i4) || (i2 != i5)) {
            this.d.b();
          }
          for (;;)
          {
            this.handler.sendEmptyMessageDelayed(4, 3600000L);
            return;
            this.d.c();
          }
          paramMessage = cn.sharesdk.framework.statistics.a.e.a(this.b);
          l1 = paramMessage.i("appFirstInitSDKTime");
          l2 = System.currentTimeMillis();
          if (l1 == 0L)
          {
            paramMessage.a("appFirstInitSDKTime", Long.valueOf(l2));
            return;
          }
        } while (l2 - l1 < 259200000L);
        str1 = paramMessage.h("appCellIdAndLacInfo");
        n = this.c.G();
        i1 = this.c.H();
      } while ((n == -1) || (i1 == -1));
      str2 = n + "_" + i1;
      cn.sharesdk.framework.utils.d.a().d("curCellInfo == " + str2, new Object[0]);
    } while ((str2.equals(str1)) || (!this.d.a(n, i1)));
    paramMessage.b("appCellIdAndLacInfo", str2);
  }
  
  protected void onStart(Message paramMessage)
  {
    if (!this.i) {
      this.i = true;
    }
    try
    {
      this.m.a(this.l.getAbsolutePath());
      if (this.m.a(false))
      {
        this.d.a();
        this.d.b();
        this.d.c();
        this.d.d();
        this.handler.sendEmptyMessageDelayed(4, 3600000L);
        this.d.a(this.g);
        this.handler.sendEmptyMessage(1);
        this.handler.sendEmptyMessage(2);
        d();
        NewAppReceiver.a(this.b, this.e);
      }
      return;
    }
    catch (Throwable paramMessage)
    {
      cn.sharesdk.framework.utils.d.a().w(paramMessage);
    }
  }
  
  protected void onStop(Message paramMessage)
  {
    if (this.i)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.j;
      paramMessage = new cn.sharesdk.framework.statistics.b.e();
      paramMessage.a = (l1 - l2);
      a(paramMessage);
      this.i = false;
    }
    try
    {
      this.f.sendEmptyMessage(1);
      a = null;
      this.handler.getLooper().quit();
      return;
    }
    catch (Throwable paramMessage)
    {
      for (;;)
      {
        cn.sharesdk.framework.utils.d.a().w(paramMessage);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\statistics\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */