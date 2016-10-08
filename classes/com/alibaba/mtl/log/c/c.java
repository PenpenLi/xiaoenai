package com.alibaba.mtl.log.c;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class c
{
  private static c jdField_a_of_type_ComAlibabaMtlLogCC;
  private a jdField_a_of_type_ComAlibabaMtlLogCA = new b(com.alibaba.mtl.log.a.getContext());
  private Runnable b = new c.1(this);
  private List<com.alibaba.mtl.log.model.a> l = new CopyOnWriteArrayList();
  
  private c()
  {
    com.alibaba.mtl.log.d.a.a().start();
    r.a().b(new a());
  }
  
  private void F()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, -3);
    long l1 = localCalendar.getTimeInMillis();
    this.jdField_a_of_type_ComAlibabaMtlLogCA.c("time", String.valueOf(l1));
  }
  
  private void G()
  {
    this.jdField_a_of_type_ComAlibabaMtlLogCA.e(1000);
  }
  
  public static c a()
  {
    try
    {
      if (jdField_a_of_type_ComAlibabaMtlLogCC == null) {
        jdField_a_of_type_ComAlibabaMtlLogCC = new c();
      }
      c localc = jdField_a_of_type_ComAlibabaMtlLogCC;
      return localc;
    }
    finally {}
  }
  
  /* Error */
  public void E()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 109
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc 111
    //   12: aastore
    //   13: invokestatic 116	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aconst_null
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 23	com/alibaba/mtl/log/c/c:l	Ljava/util/List;
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 23	com/alibaba/mtl/log/c/c:l	Ljava/util/List;
    //   29: invokeinterface 122 1 0
    //   34: ifle +24 -> 58
    //   37: new 124	java/util/ArrayList
    //   40: dup
    //   41: aload_0
    //   42: getfield 23	com/alibaba/mtl/log/c/c:l	Ljava/util/List;
    //   45: invokespecial 127	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   48: astore_1
    //   49: aload_0
    //   50: getfield 23	com/alibaba/mtl/log/c/c:l	Ljava/util/List;
    //   53: invokeinterface 130 1 0
    //   58: aload_2
    //   59: monitorexit
    //   60: aload_1
    //   61: ifnull +23 -> 84
    //   64: aload_1
    //   65: invokeinterface 122 1 0
    //   70: ifle +14 -> 84
    //   73: aload_0
    //   74: getfield 43	com/alibaba/mtl/log/c/c:jdField_a_of_type_ComAlibabaMtlLogCA	Lcom/alibaba/mtl/log/c/a;
    //   77: aload_1
    //   78: invokeinterface 133 2 0
    //   83: pop
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: astore_1
    //   88: aload_2
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    //   92: astore_1
    //   93: goto -9 -> 84
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	c
    //   17	61	1	localArrayList	java.util.ArrayList
    //   87	4	1	localObject1	Object
    //   92	1	1	localThrowable	Throwable
    //   96	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	58	87	finally
    //   58	60	87	finally
    //   88	90	87	finally
    //   18	25	92	java/lang/Throwable
    //   64	84	92	java/lang/Throwable
    //   90	92	92	java/lang/Throwable
    //   2	16	96	finally
    //   18	25	96	finally
    //   64	84	96	finally
    //   90	92	96	finally
  }
  
  public int a(List<com.alibaba.mtl.log.model.a> paramList)
  {
    i.a("LogStoreMgr", new Object[] { paramList });
    return this.jdField_a_of_type_ComAlibabaMtlLogCA.a(paramList);
  }
  
  public List<com.alibaba.mtl.log.model.a> a(int paramInt)
  {
    List localList = this.jdField_a_of_type_ComAlibabaMtlLogCA.a(paramInt);
    i.a("LogStoreMgr", new Object[] { "[get]", localList });
    return localList;
  }
  
  public void a(com.alibaba.mtl.log.model.a parama)
  {
    i.a("LogStoreMgr", new Object[] { "[add] :", parama.Y });
    com.alibaba.mtl.log.b.a.p(parama.U);
    this.l.add(parama);
    if (this.l.size() >= 100)
    {
      r.a().f(1);
      r.a().a(1, this.b, 0L);
    }
    while (r.a().b(1)) {
      return;
    }
    r.a().a(1, this.b, 5000L);
  }
  
  public void clear()
  {
    i.a("LogStoreMgr", new Object[] { "[clear]" });
    this.jdField_a_of_type_ComAlibabaMtlLogCA.clear();
    this.l.clear();
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      c.a(c.this);
      if (c.a(c.this).g() > 9000) {
        c.b(c.this);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */