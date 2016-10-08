package rx.c.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.a.b;
import rx.a.c;
import rx.c.c.e;
import rx.c.c.i;
import rx.h;
import rx.k;

public final class g<T>
  implements a.b<T, rx.a<? extends T>>
{
  final boolean a;
  final int b;
  
  private g(boolean paramBoolean, int paramInt)
  {
    this.a = paramBoolean;
    this.b = paramInt;
  }
  
  public static <T> g<T> a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a.a;
    }
    return b.a;
  }
  
  public k<rx.a<? extends T>> a(k<? super T> paramk)
  {
    e locale = new e(paramk, this.a, this.b);
    d locald = new d(locale);
    locale.d = locald;
    paramk.a(locale);
    paramk.a(locald);
    return locale;
  }
  
  private static final class a
  {
    static final g<Object> a = new g(true, Integer.MAX_VALUE, null);
  }
  
  private static final class b
  {
    static final g<Object> a = new g(false, Integer.MAX_VALUE, null);
  }
  
  static final class c<T>
    extends k<T>
  {
    static final int f = e.c / 4;
    final g.e<T> a;
    final long b;
    volatile boolean c;
    volatile e d;
    int e;
    
    public c(g.e<T> parame, long paramLong)
    {
      this.a = parame;
      this.b = paramLong;
    }
    
    public void a()
    {
      this.c = true;
      this.a.g();
    }
    
    public void a(T paramT)
    {
      this.a.a(this, paramT);
    }
    
    public void a(Throwable paramThrowable)
    {
      this.c = true;
      this.a.e().offer(paramThrowable);
      this.a.g();
    }
    
    public void b()
    {
      this.e = e.c;
      a(e.c);
    }
    
    public void b(long paramLong)
    {
      int i = this.e - (int)paramLong;
      if (i > f) {
        this.e = i;
      }
      do
      {
        return;
        this.e = e.c;
        i = e.c - i;
      } while (i <= 0);
      a(i);
    }
  }
  
  static final class d<T>
    extends AtomicLong
    implements h
  {
    private static final long serialVersionUID = -1214379189873595503L;
    final g.e<T> a;
    
    public d(g.e<T> parame)
    {
      this.a = parame;
    }
    
    public long a(int paramInt)
    {
      return addAndGet(-paramInt);
    }
    
    public void a(long paramLong)
    {
      if (paramLong > 0L) {
        if (get() != Long.MAX_VALUE) {}
      }
      while (paramLong >= 0L)
      {
        return;
        a.a(this, paramLong);
        this.a.g();
        return;
      }
      throw new IllegalArgumentException("n >= 0 required");
    }
  }
  
  static final class e<T>
    extends k<rx.a<? extends T>>
  {
    static final g.c<?>[] q = new g.c[0];
    final k<? super T> a;
    final boolean b;
    final int c;
    g.d<T> d;
    volatile e e;
    volatile rx.h.b f;
    volatile ConcurrentLinkedQueue<Throwable> g;
    final b<T> h;
    volatile boolean i;
    boolean j;
    boolean k;
    final Object l;
    volatile g.c<?>[] m;
    long n;
    long o;
    int p;
    
    public e(k<? super T> paramk, boolean paramBoolean, int paramInt)
    {
      this.a = paramk;
      this.b = paramBoolean;
      this.c = paramInt;
      this.h = b.a();
      this.l = new Object();
      this.m = q;
      a(Math.min(paramInt, e.c));
    }
    
    private void j()
    {
      ArrayList localArrayList = new ArrayList(this.g);
      if (localArrayList.size() == 1)
      {
        this.a.a((Throwable)localArrayList.get(0));
        return;
      }
      this.a.a(new rx.a.a(localArrayList));
    }
    
    public void a()
    {
      this.i = true;
      g();
    }
    
    /* Error */
    protected void a(T paramT, long paramLong)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 4
      //   3: aload_0
      //   4: getfield 53	rx/c/a/g$e:a	Lrx/k;
      //   7: aload_1
      //   8: invokevirtual 123	rx/k:a	(Ljava/lang/Object;)V
      //   11: lload_2
      //   12: ldc2_w 124
      //   15: lcmp
      //   16: ifeq +12 -> 28
      //   19: aload_0
      //   20: getfield 127	rx/c/a/g$e:d	Lrx/c/a/g$d;
      //   23: iconst_1
      //   24: invokevirtual 132	rx/c/a/g$d:a	(I)J
      //   27: pop2
      //   28: aload_0
      //   29: lconst_1
      //   30: invokevirtual 134	rx/c/a/g$e:b	(J)V
      //   33: aload_0
      //   34: monitorenter
      //   35: aload_0
      //   36: getfield 136	rx/c/a/g$e:k	Z
      //   39: ifne +71 -> 110
      //   42: aload_0
      //   43: iconst_0
      //   44: putfield 138	rx/c/a/g$e:j	Z
      //   47: aload_0
      //   48: monitorexit
      //   49: return
      //   50: astore_1
      //   51: aload_0
      //   52: getfield 55	rx/c/a/g$e:b	Z
      //   55: ifne +37 -> 92
      //   58: aload_1
      //   59: invokestatic 141	rx/a/b:a	(Ljava/lang/Throwable;)V
      //   62: aload_0
      //   63: invokevirtual 143	rx/c/a/g$e:c	()V
      //   66: aload_0
      //   67: aload_1
      //   68: invokevirtual 144	rx/c/a/g$e:a	(Ljava/lang/Throwable;)V
      //   71: return
      //   72: astore_1
      //   73: iconst_1
      //   74: istore 4
      //   76: iload 4
      //   78: ifne +12 -> 90
      //   81: aload_0
      //   82: monitorenter
      //   83: aload_0
      //   84: iconst_0
      //   85: putfield 138	rx/c/a/g$e:j	Z
      //   88: aload_0
      //   89: monitorexit
      //   90: aload_1
      //   91: athrow
      //   92: aload_0
      //   93: invokevirtual 147	rx/c/a/g$e:e	()Ljava/util/Queue;
      //   96: aload_1
      //   97: invokeinterface 153 2 0
      //   102: pop
      //   103: goto -92 -> 11
      //   106: astore_1
      //   107: goto -31 -> 76
      //   110: aload_0
      //   111: iconst_0
      //   112: putfield 136	rx/c/a/g$e:k	Z
      //   115: aload_0
      //   116: monitorexit
      //   117: aload_0
      //   118: invokevirtual 155	rx/c/a/g$e:h	()V
      //   121: return
      //   122: astore_1
      //   123: aload_0
      //   124: monitorexit
      //   125: aload_1
      //   126: athrow
      //   127: astore_1
      //   128: aload_0
      //   129: monitorexit
      //   130: aload_1
      //   131: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	132	0	this	e
      //   0	132	1	paramT	T
      //   0	132	2	paramLong	long
      //   1	76	4	i1	int
      // Exception table:
      //   from	to	target	type
      //   3	11	50	java/lang/Throwable
      //   62	71	72	finally
      //   125	127	72	finally
      //   3	11	106	finally
      //   19	28	106	finally
      //   28	35	106	finally
      //   51	62	106	finally
      //   92	103	106	finally
      //   35	49	122	finally
      //   110	117	122	finally
      //   123	125	122	finally
      //   83	90	127	finally
      //   128	130	127	finally
    }
    
    public void a(Throwable paramThrowable)
    {
      e().offer(paramThrowable);
      this.i = true;
      g();
    }
    
    public void a(rx.a<? extends T> parama)
    {
      if (parama == null) {
        return;
      }
      if ((parama instanceof i))
      {
        b(((i)parama).a());
        return;
      }
      long l1 = this.n;
      this.n = (1L + l1);
      g.c localc = new g.c(this, l1);
      a(localc);
      parama.a(localc);
      g();
    }
    
    void a(g.c<T> paramc)
    {
      f().a(paramc);
      synchronized (this.l)
      {
        g.c[] arrayOfc1 = this.m;
        int i1 = arrayOfc1.length;
        g.c[] arrayOfc2 = new g.c[i1 + 1];
        System.arraycopy(arrayOfc1, 0, arrayOfc2, 0, i1);
        arrayOfc2[i1] = paramc;
        this.m = arrayOfc2;
        return;
      }
    }
    
    void a(g.c<T> paramc, T paramT)
    {
      int i1 = 0;
      int i2 = 0;
      long l1 = this.d.get();
      if (l1 != 0L) {
        i1 = i2;
      }
      try
      {
        if (!this.j)
        {
          this.j = true;
          i1 = 1;
        }
        if (i1 != 0)
        {
          a(paramc, paramT, l1);
          return;
        }
      }
      finally {}
      b(paramc, paramT);
    }
    
    /* Error */
    protected void a(g.c<T> paramc, T paramT, long paramLong)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 5
      //   3: aload_0
      //   4: getfield 53	rx/c/a/g$e:a	Lrx/k;
      //   7: aload_2
      //   8: invokevirtual 123	rx/k:a	(Ljava/lang/Object;)V
      //   11: lload_3
      //   12: ldc2_w 124
      //   15: lcmp
      //   16: ifeq +12 -> 28
      //   19: aload_0
      //   20: getfield 127	rx/c/a/g$e:d	Lrx/c/a/g$d;
      //   23: iconst_1
      //   24: invokevirtual 132	rx/c/a/g$d:a	(I)J
      //   27: pop2
      //   28: aload_1
      //   29: lconst_1
      //   30: invokevirtual 201	rx/c/a/g$c:b	(J)V
      //   33: aload_0
      //   34: monitorenter
      //   35: aload_0
      //   36: getfield 136	rx/c/a/g$e:k	Z
      //   39: ifne +71 -> 110
      //   42: aload_0
      //   43: iconst_0
      //   44: putfield 138	rx/c/a/g$e:j	Z
      //   47: aload_0
      //   48: monitorexit
      //   49: return
      //   50: astore_2
      //   51: aload_0
      //   52: getfield 55	rx/c/a/g$e:b	Z
      //   55: ifne +37 -> 92
      //   58: aload_2
      //   59: invokestatic 141	rx/a/b:a	(Ljava/lang/Throwable;)V
      //   62: aload_1
      //   63: invokevirtual 202	rx/c/a/g$c:c	()V
      //   66: aload_1
      //   67: aload_2
      //   68: invokevirtual 203	rx/c/a/g$c:a	(Ljava/lang/Throwable;)V
      //   71: return
      //   72: astore_1
      //   73: iconst_1
      //   74: istore 5
      //   76: iload 5
      //   78: ifne +12 -> 90
      //   81: aload_0
      //   82: monitorenter
      //   83: aload_0
      //   84: iconst_0
      //   85: putfield 138	rx/c/a/g$e:j	Z
      //   88: aload_0
      //   89: monitorexit
      //   90: aload_1
      //   91: athrow
      //   92: aload_0
      //   93: invokevirtual 147	rx/c/a/g$e:e	()Ljava/util/Queue;
      //   96: aload_2
      //   97: invokeinterface 153 2 0
      //   102: pop
      //   103: goto -92 -> 11
      //   106: astore_1
      //   107: goto -31 -> 76
      //   110: aload_0
      //   111: iconst_0
      //   112: putfield 136	rx/c/a/g$e:k	Z
      //   115: aload_0
      //   116: monitorexit
      //   117: aload_0
      //   118: invokevirtual 155	rx/c/a/g$e:h	()V
      //   121: return
      //   122: astore_1
      //   123: aload_0
      //   124: monitorexit
      //   125: aload_1
      //   126: athrow
      //   127: astore_1
      //   128: aload_0
      //   129: monitorexit
      //   130: aload_1
      //   131: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	132	0	this	e
      //   0	132	1	paramc	g.c<T>
      //   0	132	2	paramT	T
      //   0	132	3	paramLong	long
      //   1	76	5	i1	int
      // Exception table:
      //   from	to	target	type
      //   3	11	50	java/lang/Throwable
      //   62	71	72	finally
      //   125	127	72	finally
      //   3	11	106	finally
      //   19	28	106	finally
      //   28	35	106	finally
      //   51	62	106	finally
      //   92	103	106	finally
      //   35	49	122	finally
      //   110	117	122	finally
      //   123	125	122	finally
      //   83	90	127	finally
      //   128	130	127	finally
    }
    
    public void b(long paramLong)
    {
      a(paramLong);
    }
    
    void b(T paramT)
    {
      int i1 = 0;
      int i2 = 0;
      long l1 = this.d.get();
      if (l1 != 0L) {
        i1 = i2;
      }
      try
      {
        if (!this.j)
        {
          this.j = true;
          i1 = 1;
        }
        if (i1 != 0)
        {
          a(paramT, l1);
          return;
        }
      }
      finally {}
      c(paramT);
    }
    
    void b(g.c<T> paramc)
    {
      int i1 = 0;
      ??? = paramc.d;
      if (??? != null) {
        ((e)???).b();
      }
      this.f.b(paramc);
      for (;;)
      {
        g.c[] arrayOfc;
        int i2;
        synchronized (this.l)
        {
          arrayOfc = this.m;
          i2 = arrayOfc.length;
          if (i1 >= i2) {
            break label130;
          }
          if (!paramc.equals(arrayOfc[i1])) {
            break label136;
          }
          if (i1 < 0) {
            return;
          }
          if (i2 == 1)
          {
            this.m = q;
            return;
          }
        }
        paramc = new g.c[i2 - 1];
        System.arraycopy(arrayOfc, 0, paramc, 0, i1);
        System.arraycopy(arrayOfc, i1 + 1, paramc, i1, i2 - i1 - 1);
        this.m = paramc;
        return;
        label130:
        i1 = -1;
        continue;
        label136:
        i1 += 1;
      }
    }
    
    protected void b(g.c<T> paramc, T paramT)
    {
      e locale2 = paramc.d;
      e locale1 = locale2;
      if (locale2 == null)
      {
        locale1 = e.a();
        paramc.a(locale1);
        paramc.d = locale1;
      }
      try
      {
        locale1.a(this.h.a(paramT));
        g();
        return;
      }
      catch (c paramT)
      {
        paramc.c();
        paramc.a(paramT);
        return;
      }
      catch (IllegalStateException paramT)
      {
        while (paramc.d()) {}
        paramc.c();
        paramc.a(paramT);
      }
    }
    
    protected void c(T paramT)
    {
      e locale2 = this.e;
      e locale1 = locale2;
      if (locale2 == null)
      {
        locale1 = e.a();
        a(locale1);
        this.e = locale1;
      }
      try
      {
        locale1.a(this.h.a(paramT));
        g();
        return;
      }
      catch (c paramT)
      {
        c();
        a(paramT);
        return;
      }
      catch (IllegalStateException paramT)
      {
        while (d()) {}
        c();
        a(paramT);
      }
    }
    
    Queue<Throwable> e()
    {
      Object localObject = this.g;
      if (localObject == null) {
        try
        {
          ConcurrentLinkedQueue localConcurrentLinkedQueue = this.g;
          localObject = localConcurrentLinkedQueue;
          if (localConcurrentLinkedQueue == null)
          {
            localObject = new ConcurrentLinkedQueue();
            this.g = ((ConcurrentLinkedQueue)localObject);
          }
          return (Queue<Throwable>)localObject;
        }
        finally {}
      }
      return localQueue;
    }
    
    rx.h.b f()
    {
      rx.h.b localb1 = this.f;
      rx.h.b localb2 = localb1;
      if (localb1 == null) {}
      for (;;)
      {
        try
        {
          localb1 = this.f;
          if (localb1 == null)
          {
            localb1 = new rx.h.b();
            this.f = localb1;
            i1 = 1;
            localb2 = localb1;
            if (i1 != 0)
            {
              a(localb1);
              localb2 = localb1;
            }
            return localb2;
          }
        }
        finally {}
        int i1 = 0;
      }
    }
    
    void g()
    {
      try
      {
        if (this.j)
        {
          this.k = true;
          return;
        }
        this.j = true;
        h();
        return;
      }
      finally {}
    }
    
    void h()
    {
      int i10 = 0;
      int i9 = 0;
      int i1 = i9;
      for (;;)
      {
        k localk;
        Object localObject9;
        long l1;
        int i6;
        label98:
        boolean bool;
        Object localObject10;
        int i11;
        try
        {
          localk = this.a;
          i1 = i9;
          if (i()) {
            return;
          }
          i1 = i9;
          localObject9 = this.e;
          i1 = i9;
          l1 = this.d.get();
          if (l1 != Long.MAX_VALUE) {
            break label225;
          }
          i6 = 1;
        }
        finally
        {
          Object localObject1;
          if (i1 != 0) {
            break label223;
          }
        }
        if (l1 > 0L)
        {
          i1 = i9;
          localObject1 = ((e)localObject9).f();
          i1 = i9;
          if (!i()) {
            if (localObject1 == null)
            {
              break label999;
              i1 = i9;
              bool = this.i;
              i1 = i9;
              localObject1 = this.e;
              i1 = i9;
              localObject10 = this.m;
              i1 = i9;
              i11 = localObject10.length;
              if (!bool) {
                break label368;
              }
              if (localObject1 != null)
              {
                i1 = i9;
                if (!((e)localObject1).e()) {
                  break label368;
                }
              }
              if (i11 != 0) {
                break label368;
              }
              i1 = i9;
              localObject9 = this.g;
              if (localObject9 != null)
              {
                i1 = i9;
                if (!((Queue)localObject9).isEmpty()) {
                  break label357;
                }
              }
              i1 = i9;
              localk.a();
              if (localObject1 == null) {
                break label960;
              }
              i1 = i9;
              ((e)localObject1).b();
            }
          }
        }
        label223:
        label225:
        label339:
        label357:
        label368:
        int i4;
        try
        {
          this.j = false;
          throw ((Throwable)localObject2);
          i6 = 0;
          break label961;
          i1 = i9;
          localObject10 = this.h.b(localObject2);
          i1 = i9;
          try
          {
            localk.a(localObject10);
            l1 -= 1L;
            i3 += 1;
            i2 += 1;
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              i1 = i9;
              if (!this.b)
              {
                i1 = i9;
                rx.a.b.a(localThrowable2);
                i2 = 1;
                i1 = i2;
                c();
                i1 = i2;
                localk.a(localThrowable2);
                return;
              }
              i1 = i9;
              e().offer(localThrowable2);
            }
          }
          i1 = i9;
          l1 = this.d.a(i3);
          break label1014;
          i1 = i9;
          j();
          continue;
          if (i11 > 0)
          {
            i1 = i9;
            l2 = this.o;
            i1 = i9;
            i4 = this.p;
            if (i11 <= i4) {
              break label1044;
            }
            i1 = i9;
            i3 = i4;
            if (localThrowable2[i4].b == l2) {
              break label1064;
            }
            break label1044;
            if (i4 < i11)
            {
              i1 = i9;
              if (localThrowable2[i3].b != l2) {
                break label1129;
              }
            }
            i1 = i9;
            this.p = i3;
            i1 = i9;
            this.o = localThrowable2[i3].b;
            break label1064;
            for (;;)
            {
              if (i8 >= i11) {
                break label932;
              }
              i1 = i9;
              if (i()) {
                break label960;
              }
              g.c localc = localThrowable2[i7];
              localObject9 = null;
              l2 = l1;
              break label1081;
              Object localObject3 = localObject9;
              if (l1 > 0L)
              {
                i1 = i9;
                if (i()) {
                  break label960;
                }
                i1 = i9;
                localObject3 = localc.d;
                if (localObject3 == null) {
                  localObject3 = localObject9;
                }
              }
              else
              {
                label549:
                if (i4 <= 0) {
                  break label1091;
                }
                if (i6 != 0) {
                  break label860;
                }
                i1 = i9;
              }
              label589:
              label860:
              for (l1 = this.d.a(i4);; l1 = Long.MAX_VALUE)
              {
                i1 = i9;
                localc.b(i4);
                break label1091;
                i1 = i9;
                bool = localc.c;
                i1 = i9;
                localObject3 = localc.d;
                i4 = i2;
                i5 = i3;
                if (!bool) {
                  break label1111;
                }
                if (localObject3 != null)
                {
                  i1 = i9;
                  i4 = i2;
                  i5 = i3;
                  if (!((e)localObject3).e()) {
                    break label1111;
                  }
                }
                i1 = i9;
                b(localc);
                i1 = i9;
                if (i()) {
                  break label960;
                }
                i5 = i3 + 1;
                i4 = 1;
                break label1111;
                i1 = i9;
                this.p = i7;
                i1 = i9;
                this.o = localThrowable2[i7].b;
                if (i3 > 0)
                {
                  i1 = i9;
                  a(i3);
                }
                if (i2 != 0) {
                  break;
                }
                i1 = i9;
                i1 = i10;
                try
                {
                  if (this.k) {
                    break label909;
                  }
                  i2 = 1;
                  i1 = i2;
                  this.j = false;
                  i1 = i2;
                  return;
                }
                finally {}
                i1 = i9;
                localObject9 = ((e)localObject4).f();
                Object localObject5 = localObject9;
                if (localObject9 == null) {
                  break label549;
                }
                i1 = i9;
                localObject5 = this.h.b(localObject9);
                i1 = i9;
                try
                {
                  localk.a(localObject5);
                  i4 += 1;
                  l1 -= 1L;
                }
                catch (Throwable localThrowable1)
                {
                  i2 = 1;
                  i1 = i2;
                  rx.a.b.a(localThrowable1);
                  try
                  {
                    localk.a(localThrowable1);
                    i1 = i2;
                    c();
                    return;
                  }
                  finally
                  {
                    i1 = i2;
                    c();
                    i1 = i2;
                  }
                }
              }
              i2 = i7 + 1;
              i1 = i2;
              if (i2 == i11) {
                i1 = 0;
              }
              i8 += 1;
              i2 = i4;
              i3 = i5;
              i7 = i1;
            }
            label909:
            i1 = i10;
            this.k = false;
            i1 = i10;
          }
        }
        finally
        {
          for (;;)
          {
            int i5;
            throw ((Throwable)localObject7);
            label932:
            continue;
            i1 = 0;
            i3 = i2;
            int i2 = i1;
            continue;
            label949:
            label960:
            label961:
            do
            {
              l1 = l2;
              i2 = i1;
              break;
              return;
              i2 = 0;
              i1 = 0;
              l2 = l1;
            } while (localObject9 == null);
            long l2 = l1;
            i1 = i2;
            Object localObject8;
            label999:
            label1014:
            do
            {
              i3 = 0;
              localObject8 = null;
              i2 = i1;
              l1 = l2;
              break;
              if (i3 > 0)
              {
                if (i6 == 0) {
                  break label339;
                }
                l1 = Long.MAX_VALUE;
              }
              i1 = i2;
              l2 = l1;
              if (l1 == 0L) {
                break label949;
              }
              i1 = i2;
              l2 = l1;
            } while (localObject8 != null);
            break label98;
            label1044:
            i3 = i4;
            if (i11 <= i4) {
              i3 = 0;
            }
            i4 = 0;
            continue;
            label1064:
            int i7 = i3;
            i3 = i2;
            int i8 = 0;
            i2 = 0;
            continue;
            label1081:
            label1091:
            do
            {
              i4 = 0;
              l1 = l2;
              break;
              if (l1 == 0L) {
                break label589;
              }
              localObject9 = localObject8;
              l2 = l1;
            } while (localObject8 != null);
            continue;
            label1111:
            if (l1 == 0L)
            {
              i2 = i4;
              i3 = i5;
            }
          }
          label1129:
          i1 = i3 + 1;
          int i3 = i1;
          if (i1 == i11) {
            i3 = 0;
          }
        }
      }
    }
    
    boolean i()
    {
      if (this.a.d()) {
        return true;
      }
      ConcurrentLinkedQueue localConcurrentLinkedQueue = this.g;
      if ((!this.b) && (localConcurrentLinkedQueue != null) && (!localConcurrentLinkedQueue.isEmpty())) {
        try
        {
          j();
          return true;
        }
        finally
        {
          c();
        }
      }
      return false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */