package com.xiaoenai.app.widget;

import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class h
{
  private WeakReference<Context> a = null;
  private Timer b = null;
  private Lock c = new ReentrantLock();
  private Handler d = new Handler();
  private List<b> e = new ArrayList();
  private long f = 0L;
  
  public h(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
    this.f = 1000L;
  }
  
  public void a()
  {
    if (this.b == null)
    {
      this.b = new Timer();
      this.b.schedule(new i(this), 0L, this.f);
    }
  }
  
  public void a(a parama)
  {
    this.c.lock();
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.e.iterator();
        if (localIterator.hasNext())
        {
          a locala = ((b)localIterator.next()).a();
          if ((locala != null) && (locala.equals(parama))) {
            i = 1;
          }
        }
        else
        {
          if (i == 0) {
            this.e.add(new b(parama));
          }
          return;
        }
      }
      finally
      {
        this.c.unlock();
      }
    }
  }
  
  public void b()
  {
    if (this.b != null)
    {
      this.b.cancel();
      this.b = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void b();
    
    public abstract long getPeriod();
  }
  
  private class b
  {
    private WeakReference<h.a> b;
    private long c = 0L;
    
    public b(h.a parama)
    {
      a(parama.getPeriod());
      a(parama);
    }
    
    public h.a a()
    {
      return (h.a)this.b.get();
    }
    
    public void a(long paramLong)
    {
      this.c = paramLong;
    }
    
    public void a(h.a parama)
    {
      this.b = new WeakReference(parama);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */