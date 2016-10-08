package com.inmobi.signals;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class g
{
  private static final String a = g.class.getSimpleName();
  private p.a b;
  private boolean c = false;
  private a d = new a();
  private e e = new e();
  
  private List<d> a(List<d> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (!a(((d)paramList.get(i)).a())) {
        localArrayList.add(paramList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(c paramc, List<d> paramList)
  {
    paramc = new f(this.b.c(), this.b.e(), this.b.f(), o.a().d(), paramList, paramc);
    paramc.b(this.b.g() * 1000);
    paramc.c(this.b.g() * 1000);
    this.e.a(paramc);
  }
  
  private boolean a()
  {
    long l = this.d.b();
    if (l == 0L) {}
    while (System.currentTimeMillis() - l >= this.b.d() * 1000) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    PackageManager localPackageManager = com.inmobi.commons.a.a.b().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo(paramString, 256);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return false;
  }
  
  private void b()
  {
    new Thread(new g.1(this)).start();
  }
  
  private c c()
  {
    b localb = new b(this.b.b(), this.b.e(), this.b.f(), o.a().d());
    localb.a(this.b.h());
    localb.b(this.b.g() * 1000);
    localb.c(this.b.g() * 1000);
    return this.e.a(localb);
  }
  
  /* Error */
  public void a(p.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield 79	com/inmobi/signals/g:b	Lcom/inmobi/signals/p$a;
    //   7: aload_0
    //   8: getfield 30	com/inmobi/signals/g:c	Z
    //   11: ifne +33 -> 44
    //   14: aload_0
    //   15: invokespecial 180	com/inmobi/signals/g:a	()Z
    //   18: ifeq +26 -> 44
    //   21: getstatic 186	com/inmobi/commons/core/utilities/Logger$InternalLogLevel:INTERNAL	Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;
    //   24: getstatic 24	com/inmobi/signals/g:a	Ljava/lang/String;
    //   27: ldc -68
    //   29: invokestatic 193	com/inmobi/commons/core/utilities/Logger:a	(Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: iconst_1
    //   34: putfield 30	com/inmobi/signals/g:c	Z
    //   37: aload_0
    //   38: invokespecial 195	com/inmobi/signals/g:b	()V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: getstatic 186	com/inmobi/commons/core/utilities/Logger$InternalLogLevel:INTERNAL	Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;
    //   47: getstatic 24	com/inmobi/signals/g:a	Ljava/lang/String;
    //   50: ldc -59
    //   52: invokestatic 193	com/inmobi/commons/core/utilities/Logger:a	(Lcom/inmobi/commons/core/utilities/Logger$InternalLogLevel;Ljava/lang/String;Ljava/lang/String;)V
    //   55: goto -14 -> 41
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	g
    //   0	63	1	parama	p.a
    // Exception table:
    //   from	to	target	type
    //   2	41	58	finally
    //   44	55	58	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */