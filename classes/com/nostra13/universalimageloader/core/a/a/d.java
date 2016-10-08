package com.nostra13.universalimageloader.core.a.a;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class d<E>
  extends AbstractQueue<E>
  implements a<E>, Serializable
{
  private static final long serialVersionUID = -387911632671998426L;
  transient c<E> a;
  transient c<E> b;
  final ReentrantLock c = new ReentrantLock();
  private transient int d;
  private final int e;
  private final Condition f = this.c.newCondition();
  private final Condition g = this.c.newCondition();
  
  public d()
  {
    this(Integer.MAX_VALUE);
  }
  
  public d(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    this.e = paramInt;
  }
  
  private boolean b(c<E> paramc)
  {
    if (this.d >= this.e) {
      return false;
    }
    c localc = this.a;
    paramc.c = localc;
    this.a = paramc;
    if (this.b == null) {
      this.b = paramc;
    }
    for (;;)
    {
      this.d += 1;
      this.f.signal();
      return true;
      localc.b = paramc;
    }
  }
  
  private boolean c(c<E> paramc)
  {
    if (this.d >= this.e) {
      return false;
    }
    c localc = this.b;
    paramc.b = localc;
    this.b = paramc;
    if (this.a == null) {
      this.a = paramc;
    }
    for (;;)
    {
      this.d += 1;
      this.f.signal();
      return true;
      localc.c = paramc;
    }
  }
  
  private E f()
  {
    c localc1 = this.a;
    if (localc1 == null) {
      return null;
    }
    c localc2 = localc1.c;
    Object localObject = localc1.a;
    localc1.a = null;
    localc1.c = localc1;
    this.a = localc2;
    if (localc2 == null) {
      this.b = null;
    }
    for (;;)
    {
      this.d -= 1;
      this.g.signal();
      return (E)localObject;
      localc2.b = null;
    }
  }
  
  private E g()
  {
    c localc1 = this.b;
    if (localc1 == null) {
      return null;
    }
    c localc2 = localc1.b;
    Object localObject = localc1.a;
    localc1.a = null;
    localc1.b = localc1;
    this.b = localc2;
    if (localc2 == null) {
      this.a = null;
    }
    for (;;)
    {
      this.d -= 1;
      this.g.signal();
      return (E)localObject;
      localc2.c = null;
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    this.d = 0;
    this.a = null;
    this.b = null;
    for (;;)
    {
      Object localObject = paramObjectInputStream.readObject();
      if (localObject == null) {
        return;
      }
      add(localObject);
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      paramObjectOutputStream.defaultWriteObject();
      for (c localc = this.a; localc != null; localc = localc.c) {
        paramObjectOutputStream.writeObject(localc.a);
      }
      paramObjectOutputStream.writeObject(null);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E a()
  {
    Object localObject = b();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return (E)localObject;
  }
  
  public E a(long paramLong, TimeUnit paramTimeUnit)
  {
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.c;
    paramTimeUnit.lockInterruptibly();
    try
    {
      Object localObject1;
      for (;;)
      {
        localObject1 = f();
        if (localObject1 != null) {
          break;
        }
        if (paramLong <= 0L) {
          return null;
        }
        paramLong = this.f.awaitNanos(paramLong);
      }
      return (E)localObject1;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  void a(c<E> paramc)
  {
    c localc1 = paramc.b;
    c localc2 = paramc.c;
    if (localc1 == null)
    {
      f();
      return;
    }
    if (localc2 == null)
    {
      g();
      return;
    }
    localc1.c = localc2;
    localc2.b = localc1;
    paramc.a = null;
    this.d -= 1;
    this.g.signal();
  }
  
  public void a(E paramE)
  {
    if (!c(paramE)) {
      throw new IllegalStateException("Deque full");
    }
  }
  
  public boolean a(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    paramE = new c(paramE);
    paramLong = paramTimeUnit.toNanos(paramLong);
    paramTimeUnit = this.c;
    paramTimeUnit.lockInterruptibly();
    try
    {
      for (;;)
      {
        boolean bool = c(paramE);
        if (bool) {
          break;
        }
        if (paramLong <= 0L) {
          return false;
        }
        paramLong = this.g.awaitNanos(paramLong);
      }
      return true;
    }
    finally
    {
      paramTimeUnit.unlock();
    }
  }
  
  public boolean add(E paramE)
  {
    a(paramE);
    return true;
  }
  
  public E b()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = f();
      return (E)localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean b(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    c localc = new c(paramE);
    paramE = this.c;
    paramE.lock();
    try
    {
      boolean bool = b(localc);
      return bool;
    }
    finally
    {
      paramE.unlock();
    }
  }
  
  public E c()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (;;)
      {
        Object localObject = f();
        if (localObject != null) {
          break;
        }
        this.f.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return ?;
  }
  
  public boolean c(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    c localc = new c(paramE);
    paramE = this.c;
    paramE.lock();
    try
    {
      boolean bool = c(localc);
      return bool;
    }
    finally
    {
      paramE.unlock();
    }
  }
  
  public void clear()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      c localc;
      for (Object localObject1 = this.a; localObject1 != null; localObject1 = localc)
      {
        ((c)localObject1).a = null;
        localc = ((c)localObject1).c;
        ((c)localObject1).b = null;
        ((c)localObject1).c = null;
      }
      this.b = null;
      this.a = null;
      this.d = 0;
      this.g.signalAll();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public boolean contains(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (c localc = this.a; localc != null; localc = localc.c)
      {
        boolean bool = paramObject.equals(localc.a);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E d()
  {
    Object localObject = e();
    if (localObject == null) {
      throw new NoSuchElementException();
    }
    return (E)localObject;
  }
  
  /* Error */
  public void d(E paramE)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 149	java/lang/NullPointerException
    //   7: dup
    //   8: invokespecial 150	java/lang/NullPointerException:<init>	()V
    //   11: athrow
    //   12: new 19	com/nostra13/universalimageloader/core/a/a/d$c
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 152	com/nostra13/universalimageloader/core/a/a/d$c:<init>	(Ljava/lang/Object;)V
    //   20: astore_2
    //   21: aload_0
    //   22: getfield 47	com/nostra13/universalimageloader/core/a/a/d:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 100	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial 154	com/nostra13/universalimageloader/core/a/a/d:c	(Lcom/nostra13/universalimageloader/core/a/a/d$c;)Z
    //   35: ifne +22 -> 57
    //   38: aload_0
    //   39: getfield 55	com/nostra13/universalimageloader/core/a/a/d:g	Ljava/util/concurrent/locks/Condition;
    //   42: invokeinterface 163 1 0
    //   47: goto -17 -> 30
    //   50: astore_2
    //   51: aload_1
    //   52: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   55: aload_2
    //   56: athrow
    //   57: aload_1
    //   58: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   61: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	d
    //   0	62	1	paramE	E
    //   20	12	2	localc	c
    //   50	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	47	50	finally
  }
  
  public int drainTo(Collection<? super E> paramCollection)
  {
    return drainTo(paramCollection, Integer.MAX_VALUE);
  }
  
  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    if (paramCollection == null) {
      throw new NullPointerException();
    }
    if (paramCollection == this) {
      throw new IllegalArgumentException();
    }
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int i = Math.min(paramInt, this.d);
      paramInt = 0;
      while (paramInt < i)
      {
        paramCollection.add(this.a.a);
        f();
        paramInt += 1;
      }
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  /* Error */
  public E e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/nostra13/universalimageloader/core/a/a/d:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 100	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   9: aload_0
    //   10: getfield 65	com/nostra13/universalimageloader/core/a/a/d:a	Lcom/nostra13/universalimageloader/core/a/a/d$c;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +11 -> 26
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 65	com/nostra13/universalimageloader/core/a/a/d:a	Lcom/nostra13/universalimageloader/core/a/a/d$c;
    //   30: getfield 81	com/nostra13/universalimageloader/core/a/a/d$c:a	Ljava/lang/Object;
    //   33: astore_1
    //   34: goto -14 -> 20
    //   37: astore_1
    //   38: aload_2
    //   39: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	d
    //   13	21	1	localObject1	Object
    //   37	6	1	localObject2	Object
    //   4	35	2	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   9	14	37	finally
    //   26	34	37	finally
  }
  
  public boolean e(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (c localc = this.a; localc != null; localc = localc.c) {
        if (paramObject.equals(localc.a))
        {
          a(localc);
          return true;
        }
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E element()
  {
    return (E)d();
  }
  
  public Iterator<E> iterator()
  {
    return new b(null);
  }
  
  public boolean offer(E paramE)
  {
    return c(paramE);
  }
  
  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramE, paramLong, paramTimeUnit);
  }
  
  public E peek()
  {
    return (E)e();
  }
  
  public E poll()
  {
    return (E)b();
  }
  
  public E poll(long paramLong, TimeUnit paramTimeUnit)
  {
    return (E)a(paramLong, paramTimeUnit);
  }
  
  public void put(E paramE)
  {
    d(paramE);
  }
  
  public int remainingCapacity()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int i = this.e;
      int j = this.d;
      return i - j;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E remove()
  {
    return (E)a();
  }
  
  public boolean remove(Object paramObject)
  {
    return e(paramObject);
  }
  
  public int size()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E take()
  {
    return (E)c();
  }
  
  public Object[] toArray()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object[] arrayOfObject = new Object[this.d];
      int i = 0;
      c localc = this.a;
      while (localc != null)
      {
        arrayOfObject[i] = localc.a;
        localc = localc.c;
        i += 1;
      }
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    Object localObject = paramArrayOfT;
    try
    {
      if (paramArrayOfT.length < this.d) {
        localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.d);
      }
      int i = 0;
      paramArrayOfT = this.a;
      while (paramArrayOfT != null)
      {
        localObject[i] = paramArrayOfT.a;
        paramArrayOfT = paramArrayOfT.c;
        i += 1;
      }
      if (localObject.length > i) {
        localObject[i] = null;
      }
      return (T[])localObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/nostra13/universalimageloader/core/a/a/d:c	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: astore 4
    //   6: aload 4
    //   8: invokevirtual 100	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   11: aload_0
    //   12: getfield 65	com/nostra13/universalimageloader/core/a/a/d:a	Lcom/nostra13/universalimageloader/core/a/a/d$c;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +11 -> 28
    //   20: aload 4
    //   22: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   25: ldc -8
    //   27: areturn
    //   28: new 250	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 251	java/lang/StringBuilder:<init>	()V
    //   35: astore 5
    //   37: aload 5
    //   39: bipush 91
    //   41: invokevirtual 255	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_1
    //   46: getfield 81	com/nostra13/universalimageloader/core/a/a/d$c:a	Ljava/lang/Object;
    //   49: astore_3
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: aload_0
    //   54: if_acmpne +7 -> 61
    //   57: ldc_w 257
    //   60: astore_2
    //   61: aload 5
    //   63: aload_2
    //   64: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_1
    //   69: getfield 67	com/nostra13/universalimageloader/core/a/a/d$c:c	Lcom/nostra13/universalimageloader/core/a/a/d$c;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnonnull +21 -> 95
    //   77: aload 5
    //   79: bipush 93
    //   81: invokevirtual 255	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   84: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore_1
    //   88: aload 4
    //   90: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   93: aload_1
    //   94: areturn
    //   95: aload 5
    //   97: bipush 44
    //   99: invokevirtual 255	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   102: bipush 32
    //   104: invokevirtual 255	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: goto -63 -> 45
    //   111: astore_1
    //   112: aload 4
    //   114: invokevirtual 111	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	d
    //   15	79	1	localObject1	Object
    //   111	7	1	localObject2	Object
    //   51	13	2	localObject3	Object
    //   49	4	3	localObject4	Object
    //   4	109	4	localReentrantLock	ReentrantLock
    //   35	61	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	16	111	finally
    //   28	45	111	finally
    //   45	50	111	finally
    //   61	73	111	finally
    //   77	88	111	finally
    //   95	108	111	finally
  }
  
  private abstract class a
    implements Iterator<E>
  {
    d.c<E> a;
    E b;
    private d.c<E> d;
    
    /* Error */
    a()
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 22	com/nostra13/universalimageloader/core/a/a/d$a:c	Lcom/nostra13/universalimageloader/core/a/a/d;
      //   5: aload_0
      //   6: invokespecial 25	java/lang/Object:<init>	()V
      //   9: aload_1
      //   10: getfield 28	com/nostra13/universalimageloader/core/a/a/d:c	Ljava/util/concurrent/locks/ReentrantLock;
      //   13: astore_2
      //   14: aload_2
      //   15: invokevirtual 33	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   18: aload_0
      //   19: aload_0
      //   20: invokevirtual 36	com/nostra13/universalimageloader/core/a/a/d$a:a	()Lcom/nostra13/universalimageloader/core/a/a/d$c;
      //   23: putfield 38	com/nostra13/universalimageloader/core/a/a/d$a:a	Lcom/nostra13/universalimageloader/core/a/a/d$c;
      //   26: aload_0
      //   27: getfield 38	com/nostra13/universalimageloader/core/a/a/d$a:a	Lcom/nostra13/universalimageloader/core/a/a/d$c;
      //   30: ifnonnull +15 -> 45
      //   33: aconst_null
      //   34: astore_1
      //   35: aload_0
      //   36: aload_1
      //   37: putfield 40	com/nostra13/universalimageloader/core/a/a/d$a:b	Ljava/lang/Object;
      //   40: aload_2
      //   41: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   44: return
      //   45: aload_0
      //   46: getfield 38	com/nostra13/universalimageloader/core/a/a/d$a:a	Lcom/nostra13/universalimageloader/core/a/a/d$c;
      //   49: getfield 47	com/nostra13/universalimageloader/core/a/a/d$c:a	Ljava/lang/Object;
      //   52: astore_1
      //   53: goto -18 -> 35
      //   56: astore_1
      //   57: aload_2
      //   58: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   61: aload_1
      //   62: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	63	0	this	a
      //   0	63	1	this$1	d
      //   13	45	2	localReentrantLock	ReentrantLock
      // Exception table:
      //   from	to	target	type
      //   18	33	56	finally
      //   35	40	56	finally
      //   45	53	56	finally
    }
    
    private d.c<E> b(d.c<E> paramc)
    {
      for (;;)
      {
        d.c localc = a(paramc);
        Object localObject;
        if (localc == null) {
          localObject = null;
        }
        do
        {
          return (d.c<E>)localObject;
          localObject = localc;
        } while (localc.a != null);
        if (localc == paramc) {
          return a();
        }
        paramc = localc;
      }
    }
    
    abstract d.c<E> a();
    
    abstract d.c<E> a(d.c<E> paramc);
    
    /* Error */
    void b()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 22	com/nostra13/universalimageloader/core/a/a/d$a:c	Lcom/nostra13/universalimageloader/core/a/a/d;
      //   4: getfield 28	com/nostra13/universalimageloader/core/a/a/d:c	Ljava/util/concurrent/locks/ReentrantLock;
      //   7: astore_2
      //   8: aload_2
      //   9: invokevirtual 33	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   12: aload_0
      //   13: aload_0
      //   14: aload_0
      //   15: getfield 38	com/nostra13/universalimageloader/core/a/a/d$a:a	Lcom/nostra13/universalimageloader/core/a/a/d$c;
      //   18: invokespecial 55	com/nostra13/universalimageloader/core/a/a/d$a:b	(Lcom/nostra13/universalimageloader/core/a/a/d$c;)Lcom/nostra13/universalimageloader/core/a/a/d$c;
      //   21: putfield 38	com/nostra13/universalimageloader/core/a/a/d$a:a	Lcom/nostra13/universalimageloader/core/a/a/d$c;
      //   24: aload_0
      //   25: getfield 38	com/nostra13/universalimageloader/core/a/a/d$a:a	Lcom/nostra13/universalimageloader/core/a/a/d$c;
      //   28: ifnonnull +15 -> 43
      //   31: aconst_null
      //   32: astore_1
      //   33: aload_0
      //   34: aload_1
      //   35: putfield 40	com/nostra13/universalimageloader/core/a/a/d$a:b	Ljava/lang/Object;
      //   38: aload_2
      //   39: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   42: return
      //   43: aload_0
      //   44: getfield 38	com/nostra13/universalimageloader/core/a/a/d$a:a	Lcom/nostra13/universalimageloader/core/a/a/d$c;
      //   47: getfield 47	com/nostra13/universalimageloader/core/a/a/d$c:a	Ljava/lang/Object;
      //   50: astore_1
      //   51: goto -18 -> 33
      //   54: astore_1
      //   55: aload_2
      //   56: invokevirtual 43	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   59: aload_1
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	a
      //   32	19	1	localObject1	Object
      //   54	6	1	localObject2	Object
      //   7	49	2	localReentrantLock	ReentrantLock
      // Exception table:
      //   from	to	target	type
      //   12	31	54	finally
      //   33	38	54	finally
      //   43	51	54	finally
    }
    
    public boolean hasNext()
    {
      return this.a != null;
    }
    
    public E next()
    {
      if (this.a == null) {
        throw new NoSuchElementException();
      }
      this.d = this.a;
      Object localObject = this.b;
      b();
      return (E)localObject;
    }
    
    public void remove()
    {
      d.c localc = this.d;
      if (localc == null) {
        throw new IllegalStateException();
      }
      this.d = null;
      ReentrantLock localReentrantLock = d.this.c;
      localReentrantLock.lock();
      try
      {
        if (localc.a != null) {
          d.this.a(localc);
        }
        return;
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
  }
  
  private class b
    extends d<E>.a
  {
    private b()
    {
      super();
    }
    
    d.c<E> a()
    {
      return d.this.a;
    }
    
    d.c<E> a(d.c<E> paramc)
    {
      return paramc.c;
    }
  }
  
  static final class c<E>
  {
    E a;
    c<E> b;
    c<E> c;
    
    c(E paramE)
    {
      this.a = paramE;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */