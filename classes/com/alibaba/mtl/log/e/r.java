package com.alibaba.mtl.log.e;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.alibaba.mtl.appmonitor.b.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class r
{
  private static int F = 1;
  private static int G = 2;
  private static int H = 10;
  private static int I = 60;
  public static r a;
  private static ThreadPoolExecutor a;
  private static final AtomicInteger f = new AtomicInteger();
  private HandlerThread b = new HandlerThread("AppMonitor");
  private Handler mHandler;
  
  private r()
  {
    this.b.start();
    this.mHandler = new r.1(this, this.b.getLooper());
  }
  
  public static r a()
  {
    try
    {
      if (jdField_a_of_type_ComAlibabaMtlLogER == null) {
        jdField_a_of_type_ComAlibabaMtlLogER = new r();
      }
      r localr = jdField_a_of_type_ComAlibabaMtlLogER;
      return localr;
    }
    finally {}
  }
  
  private static ThreadPoolExecutor a()
  {
    try
    {
      if (jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null) {
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = a(F, G, H, I, 500);
      }
      ThreadPoolExecutor localThreadPoolExecutor = jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
      return localThreadPoolExecutor;
    }
    finally {}
  }
  
  @TargetApi(9)
  private static ThreadPoolExecutor a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 > 0) {}
    for (LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue(paramInt5);; localLinkedBlockingQueue = new LinkedBlockingQueue())
    {
      a locala = new a(paramInt1);
      return new ThreadPoolExecutor(paramInt2, paramInt3, paramInt4, TimeUnit.SECONDS, localLinkedBlockingQueue, locala, new ThreadPoolExecutor.DiscardOldestPolicy());
    }
  }
  
  public final void a(int paramInt, Runnable paramRunnable, long paramLong)
  {
    try
    {
      Message localMessage = Message.obtain(this.mHandler, paramInt);
      localMessage.obj = paramRunnable;
      this.mHandler.sendMessageDelayed(localMessage, paramLong);
      return;
    }
    catch (Exception paramRunnable)
    {
      b.a(paramRunnable);
    }
  }
  
  public void b(Runnable paramRunnable)
  {
    try
    {
      a().submit(paramRunnable);
      return;
    }
    catch (Throwable paramRunnable) {}
  }
  
  public final boolean b(int paramInt)
  {
    return this.mHandler.hasMessages(paramInt);
  }
  
  public final void f(int paramInt)
  {
    this.mHandler.removeMessages(paramInt);
  }
  
  static class a
    implements ThreadFactory
  {
    private int priority;
    
    public a(int paramInt)
    {
      this.priority = paramInt;
    }
    
    public Thread newThread(Runnable paramRunnable)
    {
      int i = r.a().getAndIncrement();
      paramRunnable = new Thread(paramRunnable, "AppMonitor:" + i);
      paramRunnable.setPriority(this.priority);
      return paramRunnable;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */