package com.nostra13.universalimageloader.core;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.a.a.a.a.d;
import com.nostra13.universalimageloader.b.f;
import com.nostra13.universalimageloader.core.a.g;
import com.nostra13.universalimageloader.core.c.e;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class a
{
  @TargetApi(11)
  private static int a(ActivityManager paramActivityManager)
  {
    return paramActivityManager.getLargeMemoryClass();
  }
  
  public static com.nostra13.universalimageloader.a.a.a a(Context paramContext, com.nostra13.universalimageloader.a.a.b.a parama, long paramLong, int paramInt)
  {
    File localFile = b(paramContext);
    if ((paramLong > 0L) || (paramInt > 0))
    {
      Object localObject = f.b(paramContext);
      try
      {
        localObject = new d((File)localObject, localFile, parama, paramLong, paramInt);
        return (com.nostra13.universalimageloader.a.a.a)localObject;
      }
      catch (IOException localIOException)
      {
        com.nostra13.universalimageloader.b.c.a(localIOException);
      }
    }
    return new com.nostra13.universalimageloader.a.a.a.b(f.a(paramContext), localFile, parama);
  }
  
  public static com.nostra13.universalimageloader.a.b.a a(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      paramInt = localActivityManager.getMemoryClass();
      if ((!d()) || (!c(paramContext))) {
        break label56;
      }
      paramInt = a(localActivityManager);
    }
    label56:
    for (;;)
    {
      i = paramInt * 1048576 / 8;
      return new com.nostra13.universalimageloader.a.b.a.b(i);
    }
  }
  
  public static com.nostra13.universalimageloader.core.b.b a(boolean paramBoolean)
  {
    return new com.nostra13.universalimageloader.core.b.a(paramBoolean);
  }
  
  public static com.nostra13.universalimageloader.core.d.b a(Context paramContext)
  {
    return new com.nostra13.universalimageloader.core.d.a(paramContext);
  }
  
  public static Executor a()
  {
    return Executors.newCachedThreadPool(a(5, "uil-pool-d-"));
  }
  
  public static Executor a(int paramInt1, int paramInt2, g paramg)
  {
    int i;
    if (paramg == g.b)
    {
      i = 1;
      if (i == 0) {
        break label52;
      }
    }
    label52:
    for (paramg = new com.nostra13.universalimageloader.core.a.a.c();; paramg = new LinkedBlockingQueue())
    {
      paramg = (BlockingQueue)paramg;
      return new ThreadPoolExecutor(paramInt1, paramInt1, 0L, TimeUnit.MILLISECONDS, paramg, a(paramInt2, "uil-pool-"));
      i = 0;
      break;
    }
  }
  
  private static ThreadFactory a(int paramInt, String paramString)
  {
    return new a(paramInt, paramString);
  }
  
  public static com.nostra13.universalimageloader.a.a.b.a b()
  {
    return new com.nostra13.universalimageloader.a.a.b.b();
  }
  
  private static File b(Context paramContext)
  {
    paramContext = f.a(paramContext, false);
    File localFile = new File(paramContext, "uil-images");
    if ((localFile.exists()) || (localFile.mkdir())) {
      paramContext = localFile;
    }
    return paramContext;
  }
  
  public static com.nostra13.universalimageloader.core.c.a c()
  {
    return new e();
  }
  
  @TargetApi(11)
  private static boolean c(Context paramContext)
  {
    return (paramContext.getApplicationInfo().flags & 0x100000) != 0;
  }
  
  private static boolean d()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private static class a
    implements ThreadFactory
  {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c = new AtomicInteger(1);
    private final String d;
    private final int e;
    
    a(int paramInt, String paramString)
    {
      this.e = paramInt;
      this.b = Thread.currentThread().getThreadGroup();
      this.d = (paramString + a.getAndIncrement() + "-thread-");
    }
    
    public Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      paramRunnable.setPriority(this.e);
      return paramRunnable;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */