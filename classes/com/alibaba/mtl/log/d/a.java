package com.alibaba.mtl.log.d;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import java.util.Random;

public class a
{
  static a a = new a();
  private int A;
  private boolean E = false;
  protected long z = com.alibaba.mtl.log.a.a.a();
  
  public static a a()
  {
    return a;
  }
  
  private long c()
  {
    boolean bool = true;
    i.a("UploadEngine", new Object[] { "UTDC.bBackground:", Boolean.valueOf(com.alibaba.mtl.log.a.o), "AppInfoUtil.isForeground(UTDC.getContext()) ", Boolean.valueOf(com.alibaba.mtl.log.e.b.b(com.alibaba.mtl.log.a.getContext())) });
    if (!com.alibaba.mtl.log.e.b.b(com.alibaba.mtl.log.a.getContext()))
    {
      com.alibaba.mtl.log.a.o = bool;
      bool = com.alibaba.mtl.log.a.o;
      com.alibaba.mtl.log.a.a.a();
      if (!bool) {
        break label105;
      }
    }
    label105:
    for (long l = com.alibaba.mtl.log.a.a.b() + this.A;; l = com.alibaba.mtl.log.a.a.a() + this.A)
    {
      this.z = l;
      if (com.alibaba.mtl.log.a.a.g()) {
        this.z = 3000L;
      }
      return this.z;
      bool = false;
      break;
    }
  }
  
  public void H()
  {
    if (this.A == 0)
    {
      this.A = 7000;
      return;
    }
    this.A = 0;
  }
  
  public void start()
  {
    try
    {
      this.E = true;
      if (r.a().b(2)) {
        r.a().f(2);
      }
      c();
      Random localRandom = new Random();
      if (!b.isRunning()) {
        r.a().a(2, new a.1(this), localRandom.nextInt((int)this.z));
      }
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      this.E = false;
      r.a().f(2);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */