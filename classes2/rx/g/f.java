package rx.g;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.a.a;
import rx.b.c;
import rx.h.d;
import rx.k;

final class f<T>
  implements a.a<T>
{
  static final AtomicReferenceFieldUpdater<f, a> b = AtomicReferenceFieldUpdater.newUpdater(f.class, a.class, "a");
  static final AtomicReferenceFieldUpdater<f, Object> d = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "c");
  volatile a<T> a = a.e;
  volatile Object c;
  boolean e = true;
  rx.b.b<b<T>> f = c.a();
  rx.b.b<b<T>> g = c.a();
  rx.b.b<b<T>> h = c.a();
  public final rx.c.a.b<T> i = rx.c.a.b.a();
  
  Object a()
  {
    return this.c;
  }
  
  public void a(k<? super T> paramk)
  {
    b localb = new b(paramk);
    a(paramk, localb);
    this.f.a(localb);
    if ((!paramk.d()) && (a(localb)) && (paramk.d())) {
      b(localb);
    }
  }
  
  void a(k<? super T> paramk, b<T> paramb)
  {
    paramk.a(d.a(new g(this, paramb)));
  }
  
  boolean a(b<T> paramb)
  {
    a locala1;
    a locala2;
    do
    {
      locala1 = this.a;
      if (locala1.a)
      {
        this.h.a(paramb);
        return false;
      }
      locala2 = locala1.a(paramb);
    } while (!b.compareAndSet(this, locala1, locala2));
    this.g.a(paramb);
    return true;
  }
  
  void b(Object paramObject)
  {
    this.c = paramObject;
  }
  
  void b(b<T> paramb)
  {
    a locala1;
    a locala2;
    do
    {
      locala1 = this.a;
      if (locala1.a) {}
      do
      {
        return;
        locala2 = locala1.b(paramb);
      } while (locala2 == locala1);
    } while (!b.compareAndSet(this, locala1, locala2));
  }
  
  b<T>[] b()
  {
    return this.a.b;
  }
  
  b<T>[] c(Object paramObject)
  {
    b(paramObject);
    this.e = false;
    if (this.a.a) {
      return a.c;
    }
    return ((a)b.getAndSet(this, a.d)).b;
  }
  
  protected static final class a<T>
  {
    static final f.b[] c = new f.b[0];
    static final a d = new a(true, c);
    static final a e = new a(false, c);
    final boolean a;
    final f.b[] b;
    
    public a(boolean paramBoolean, f.b[] paramArrayOfb)
    {
      this.a = paramBoolean;
      this.b = paramArrayOfb;
    }
    
    public a a(f.b paramb)
    {
      int i = this.b.length;
      f.b[] arrayOfb = new f.b[i + 1];
      System.arraycopy(this.b, 0, arrayOfb, 0, i);
      arrayOfb[i] = paramb;
      return new a(this.a, arrayOfb);
    }
    
    public a b(f.b paramb)
    {
      f.b[] arrayOfb2 = this.b;
      int m = arrayOfb2.length;
      a locala;
      if ((m == 1) && (arrayOfb2[0] == paramb)) {
        locala = e;
      }
      f.b[] arrayOfb1;
      int j;
      f.b localb;
      do
      {
        do
        {
          return locala;
          locala = this;
        } while (m == 0);
        arrayOfb1 = new f.b[m - 1];
        j = 0;
        i = 0;
        if (j >= m) {
          break;
        }
        localb = arrayOfb2[j];
        if (localb == paramb) {
          break label159;
        }
        locala = this;
      } while (i == m - 1);
      int k = i + 1;
      arrayOfb1[i] = localb;
      int i = k;
      label159:
      for (;;)
      {
        j += 1;
        break;
        if (i == 0) {
          return e;
        }
        if (i < m - 1)
        {
          paramb = new f.b[i];
          System.arraycopy(arrayOfb1, 0, paramb, 0, i);
        }
        for (;;)
        {
          return new a(this.a, paramb);
          paramb = arrayOfb1;
        }
      }
    }
  }
  
  protected static final class b<T>
    implements rx.g<T>
  {
    final rx.g<? super T> a;
    boolean b = true;
    boolean c;
    List<Object> d;
    boolean e;
    
    public b(rx.g<? super T> paramg)
    {
      this.a = paramg;
    }
    
    public void a()
    {
      this.a.a();
    }
    
    public void a(T paramT)
    {
      this.a.a(paramT);
    }
    
    protected void a(Object paramObject, rx.c.a.b<T> paramb)
    {
      if (!this.e) {}
      try
      {
        this.b = false;
        if (this.c)
        {
          if (this.d == null) {
            this.d = new ArrayList();
          }
          this.d.add(paramObject);
          return;
        }
        this.e = true;
        paramb.a(this.a, paramObject);
        return;
      }
      finally {}
    }
    
    public void a(Throwable paramThrowable)
    {
      this.a.a(paramThrowable);
    }
    
    /* Error */
    protected void a(List<Object> paramList, Object paramObject, rx.c.a.b<T> paramb)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 6
      //   3: iconst_0
      //   4: istore 7
      //   6: iconst_1
      //   7: istore 4
      //   9: aload_1
      //   10: ifnull +54 -> 64
      //   13: aload_1
      //   14: invokeinterface 67 1 0
      //   19: astore_1
      //   20: aload_1
      //   21: invokeinterface 73 1 0
      //   26: ifeq +38 -> 64
      //   29: aload_0
      //   30: aload_1
      //   31: invokeinterface 77 1 0
      //   36: aload_3
      //   37: invokevirtual 79	rx/g/f$b:c	(Ljava/lang/Object;Lrx/c/a/b;)V
      //   40: goto -20 -> 20
      //   43: astore_1
      //   44: iload 7
      //   46: istore 4
      //   48: iload 4
      //   50: ifne +12 -> 62
      //   53: aload_0
      //   54: monitorenter
      //   55: aload_0
      //   56: iconst_0
      //   57: putfield 42	rx/g/f$b:c	Z
      //   60: aload_0
      //   61: monitorexit
      //   62: aload_1
      //   63: athrow
      //   64: iload 4
      //   66: istore 5
      //   68: iload 4
      //   70: ifeq +12 -> 82
      //   73: aload_0
      //   74: aload_2
      //   75: aload_3
      //   76: invokevirtual 79	rx/g/f$b:c	(Ljava/lang/Object;Lrx/c/a/b;)V
      //   79: iconst_0
      //   80: istore 5
      //   82: aload_0
      //   83: monitorenter
      //   84: aload_0
      //   85: getfield 44	rx/g/f$b:d	Ljava/util/List;
      //   88: astore_1
      //   89: aload_0
      //   90: aconst_null
      //   91: putfield 44	rx/g/f$b:d	Ljava/util/List;
      //   94: aload_1
      //   95: ifnonnull +15 -> 110
      //   98: aload_0
      //   99: iconst_0
      //   100: putfield 42	rx/g/f$b:c	Z
      //   103: iload 6
      //   105: istore 5
      //   107: aload_0
      //   108: monitorexit
      //   109: return
      //   110: aload_0
      //   111: monitorexit
      //   112: iload 5
      //   114: istore 4
      //   116: goto -107 -> 9
      //   119: astore_1
      //   120: iconst_0
      //   121: istore 4
      //   123: iload 4
      //   125: istore 5
      //   127: aload_0
      //   128: monitorexit
      //   129: aload_1
      //   130: athrow
      //   131: astore_1
      //   132: goto -84 -> 48
      //   135: astore_1
      //   136: aload_0
      //   137: monitorexit
      //   138: aload_1
      //   139: athrow
      //   140: astore_1
      //   141: iload 5
      //   143: istore 4
      //   145: goto -22 -> 123
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	148	0	this	b
      //   0	148	1	paramList	List<Object>
      //   0	148	2	paramObject	Object
      //   0	148	3	paramb	rx.c.a.b<T>
      //   7	137	4	i	int
      //   66	76	5	j	int
      //   1	103	6	k	int
      //   4	41	7	m	int
      // Exception table:
      //   from	to	target	type
      //   13	20	43	finally
      //   20	40	43	finally
      //   73	79	43	finally
      //   82	84	43	finally
      //   84	94	119	finally
      //   98	103	119	finally
      //   110	112	119	finally
      //   129	131	131	finally
      //   55	62	135	finally
      //   136	138	135	finally
      //   107	109	140	finally
      //   127	129	140	finally
    }
    
    protected void b(Object paramObject, rx.c.a.b<T> paramb)
    {
      boolean bool = false;
      try
      {
        if ((!this.b) || (this.c)) {
          return;
        }
        this.b = false;
        if (paramObject != null) {
          bool = true;
        }
        this.c = bool;
        if (paramObject != null)
        {
          a(null, paramObject, paramb);
          return;
        }
      }
      finally {}
    }
    
    protected void c(Object paramObject, rx.c.a.b<T> paramb)
    {
      if (paramObject != null) {
        paramb.a(this.a, paramObject);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\g\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */