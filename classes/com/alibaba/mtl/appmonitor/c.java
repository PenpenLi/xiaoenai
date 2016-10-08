package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class c
  implements Runnable
{
  private static Map<Integer, c> c;
  private static boolean j = false;
  private int d = 180000;
  private int e;
  private long startTime;
  
  private c(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.d = paramInt2;
    this.startTime = System.currentTimeMillis();
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 65501: 
      return 6;
    case 65502: 
      return 9;
    case 65503: 
      return 10;
    }
    return 11;
  }
  
  static void a(int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    i.a("CommitTask", new Object[] { "[setStatisticsInterval] eventId" + paramInt1 + " statisticsInterval:" + paramInt2 });
    for (;;)
    {
      long l2;
      synchronized (c)
      {
        c localc = (c)c.get(Integer.valueOf(paramInt1));
        if (localc == null)
        {
          if (paramInt2 > 0)
          {
            localc = new c(paramInt1, paramInt2 * 1000);
            c.put(Integer.valueOf(paramInt1), localc);
            i.a("CommitTask", new Object[] { "post next eventId" + paramInt1 + ": uploadTask.interval " + localc.d });
            r.a().a(a(paramInt1), localc, localc.d);
          }
          return;
        }
        if (paramInt2 > 0)
        {
          if (localc.d == paramInt2 * 1000) {
            continue;
          }
          r.a().f(a(paramInt1));
          localc.d = (paramInt2 * 1000);
          long l3 = System.currentTimeMillis();
          l2 = localc.d - (l3 - localc.startTime);
          if (l2 >= 0L) {
            break label401;
          }
          i.a("CommitTask", new Object[] { localc + "post next eventId" + paramInt1 + " next:" + l1 + "  uploadTask.interval: " + localc.d });
          r.a().a(a(paramInt1), localc, l1);
          localc.startTime = l3;
        }
      }
      i.a("CommitTask", new Object[] { "uploadTasks.size:" + c.size() });
      c.remove(Integer.valueOf(paramInt1));
      i.a("CommitTask", new Object[] { "uploadTasks.size:" + c.size() });
      continue;
      label401:
      l1 = l2;
    }
  }
  
  static void destroy()
  {
    f[] arrayOff = f.a();
    int k = arrayOff.length;
    int i = 0;
    while (i < k)
    {
      f localf = arrayOff[i];
      r.a().f(a(localf.a()));
      i += 1;
    }
    j = false;
    c = null;
  }
  
  static void e()
  {
    f[] arrayOff = f.a();
    int k = arrayOff.length;
    int i = 0;
    while (i < k)
    {
      f localf = arrayOff[i];
      e.a().a(localf.a());
      i += 1;
    }
  }
  
  static void init()
  {
    int i = 0;
    if (!j)
    {
      i.a("CommitTask", new Object[] { "init StatisticsAlarmEvent" });
      c = new ConcurrentHashMap();
      f[] arrayOff = f.a();
      int k = arrayOff.length;
      while (i < k)
      {
        Object localObject = arrayOff[i];
        if (((f)localObject).isOpen())
        {
          int m = ((f)localObject).a();
          localObject = new c(m, ((f)localObject).c() * 1000);
          c.put(Integer.valueOf(m), localObject);
          r.a().a(a(m), (Runnable)localObject, ((c)localObject).d);
        }
        i += 1;
      }
      j = true;
    }
  }
  
  public void run()
  {
    i.a("CommitTask", new Object[] { "check&commit event:", Integer.valueOf(this.e) });
    e.a().a(this.e);
    if (c.containsValue(this))
    {
      this.startTime = System.currentTimeMillis();
      i.a("CommitTask", new Object[] { "next:" + this.e });
      r.a().a(a(this.e), this, this.d);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */