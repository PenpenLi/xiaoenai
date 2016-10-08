package com.alibaba.sdk.android.executor.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ExecutorServiceImpl
  implements com.alibaba.sdk.android.executor.ExecutorService, java.util.concurrent.ExecutorService
{
  public static final String TAG = "ExecutorServiceImpl";
  private final Handler handler;
  private final HandlerThread handlerThread = new HandlerThread("SDK Looper Thread");
  private ThreadPoolExecutor mExecutor;
  private final BlockingQueue<Runnable> mPoolWorkQueue = new LinkedBlockingQueue(128);
  private final Handler mainHandler = new Handler(Looper.getMainLooper());
  
  public ExecutorServiceImpl()
  {
    this.handlerThread.start();
    synchronized (this.handlerThread)
    {
      for (;;)
      {
        Looper localLooper = this.handlerThread.getLooper();
        if (localLooper != null) {
          break;
        }
        try
        {
          this.handlerThread.wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      this.handler = new Handler(this.handlerThread.getLooper());
      ??? = new ExecutorServiceImpl.1(this);
      this.mExecutor = new ThreadPoolExecutor(8, 16, 1, TimeUnit.SECONDS, this.mPoolWorkQueue, (ThreadFactory)???, new CoordinatorRejectHandler(this.mPoolWorkQueue));
      return;
    }
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.mExecutor.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.mExecutor.execute(paramRunnable);
  }
  
  public Looper getDefaultLooper()
  {
    return this.handlerThread.getLooper();
  }
  
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection)
  {
    return this.mExecutor.invokeAll(paramCollection);
  }
  
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.mExecutor.invokeAll(paramCollection, paramLong, paramTimeUnit);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection)
  {
    return (T)this.mExecutor.invokeAny(paramCollection);
  }
  
  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
  {
    return (T)this.mExecutor.invokeAny(paramCollection, paramLong, paramTimeUnit);
  }
  
  public boolean isShutdown()
  {
    return this.mExecutor.isShutdown();
  }
  
  public boolean isTerminated()
  {
    return this.mExecutor.isTerminated();
  }
  
  public void postHandlerTask(Runnable paramRunnable)
  {
    this.handler.post(paramRunnable);
  }
  
  public void postTask(Runnable paramRunnable)
  {
    this.mExecutor.execute(paramRunnable);
  }
  
  public void postUITask(Runnable paramRunnable)
  {
    this.mainHandler.post(new ExecutorServiceImpl.2(this, paramRunnable));
  }
  
  public void shutdown()
  {
    this.mExecutor.shutdown();
  }
  
  public List<Runnable> shutdownNow()
  {
    return this.mExecutor.shutdownNow();
  }
  
  public Future<?> submit(Runnable paramRunnable)
  {
    return this.mExecutor.submit(paramRunnable);
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    return this.mExecutor.submit(paramRunnable, paramT);
  }
  
  public <T> Future<T> submit(Callable<T> paramCallable)
  {
    return this.mExecutor.submit(paramCallable);
  }
  
  public static class CoordinatorRejectHandler
    implements RejectedExecutionHandler
  {
    private BlockingQueue<Runnable> mPoolWorkQueue;
    
    public CoordinatorRejectHandler(BlockingQueue<Runnable> paramBlockingQueue)
    {
      this.mPoolWorkQueue = paramBlockingQueue;
    }
    
    private Object getOuterClass(Object paramObject)
    {
      try
      {
        Object localObject = paramObject.getClass().getDeclaredField("this$0");
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(paramObject);
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return paramObject;
    }
    
    public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
    {
      Object[] arrayOfObject = this.mPoolWorkQueue.toArray();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('[');
      int j = arrayOfObject.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = arrayOfObject[i];
        if (localObject.getClass().isAnonymousClass())
        {
          localStringBuilder.append(getOuterClass(localObject));
          localStringBuilder.append(',').append(' ');
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append(localObject.getClass());
          localStringBuilder.append(',').append(' ');
        }
      }
      localStringBuilder.append(']');
      throw new RejectedExecutionException("Task " + paramRunnable.toString() + " rejected from " + paramThreadPoolExecutor.toString() + " in " + localStringBuilder.toString());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\executor\impl\ExecutorServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */