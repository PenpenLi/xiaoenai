package rx.d;

import rx.g;

public class b<T>
  implements g<T>
{
  private static final Object e = new Object();
  private static final Object f = new Object();
  private final g<? super T> a;
  private boolean b = false;
  private boolean c = false;
  private b d;
  
  public b(g<? super T> paramg)
  {
    this.a = paramg;
  }
  
  public void a()
  {
    try
    {
      if (this.c) {
        return;
      }
      this.c = true;
      if (this.b)
      {
        if (this.d == null) {
          this.d = new b();
        }
        this.d.a(f);
        return;
      }
    }
    finally {}
    this.b = true;
    b localb = this.d;
    this.d = null;
    a(localb);
    this.a.a();
  }
  
  /* Error */
  public void a(T paramT)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 37	rx/d/b:c	Z
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 35	rx/d/b:b	Z
    //   22: ifeq +50 -> 72
    //   25: aload_0
    //   26: getfield 43	rx/d/b:d	Lrx/d/b$b;
    //   29: ifnonnull +14 -> 43
    //   32: aload_0
    //   33: new 12	rx/d/b$b
    //   36: dup
    //   37: invokespecial 44	rx/d/b$b:<init>	()V
    //   40: putfield 43	rx/d/b:d	Lrx/d/b$b;
    //   43: aload_0
    //   44: getfield 43	rx/d/b:d	Lrx/d/b$b;
    //   47: astore_2
    //   48: aload_1
    //   49: ifnull +16 -> 65
    //   52: aload_2
    //   53: aload_1
    //   54: invokevirtual 47	rx/d/b$b:a	(Ljava/lang/Object;)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    //   65: getstatic 29	rx/d/b:e	Ljava/lang/Object;
    //   68: astore_1
    //   69: goto -17 -> 52
    //   72: aload_0
    //   73: iconst_1
    //   74: putfield 35	rx/d/b:b	Z
    //   77: aload_0
    //   78: getfield 43	rx/d/b:d	Lrx/d/b$b;
    //   81: astore_2
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 43	rx/d/b:d	Lrx/d/b$b;
    //   87: aload_0
    //   88: monitorexit
    //   89: ldc 53
    //   91: istore_3
    //   92: aload_0
    //   93: aload_2
    //   94: invokevirtual 50	rx/d/b:a	(Lrx/d/b$b;)V
    //   97: iload_3
    //   98: ldc 53
    //   100: if_icmpne +13 -> 113
    //   103: aload_0
    //   104: getfield 39	rx/d/b:a	Lrx/g;
    //   107: aload_1
    //   108: invokeinterface 54 2 0
    //   113: iload_3
    //   114: iconst_1
    //   115: isub
    //   116: istore 6
    //   118: iload 6
    //   120: ifle +64 -> 184
    //   123: aload_0
    //   124: monitorenter
    //   125: aload_0
    //   126: getfield 43	rx/d/b:d	Lrx/d/b$b;
    //   129: astore_2
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 43	rx/d/b:d	Lrx/d/b$b;
    //   135: aload_2
    //   136: ifnonnull +46 -> 182
    //   139: aload_0
    //   140: iconst_0
    //   141: putfield 35	rx/d/b:b	Z
    //   144: aload_0
    //   145: monitorexit
    //   146: return
    //   147: iload_3
    //   148: istore 4
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    //   154: astore_1
    //   155: iload_3
    //   156: ifne +24 -> 180
    //   159: aload_0
    //   160: monitorenter
    //   161: aload_0
    //   162: getfield 37	rx/d/b:c	Z
    //   165: ifeq +69 -> 234
    //   168: aload_0
    //   169: getfield 43	rx/d/b:d	Lrx/d/b$b;
    //   172: astore_2
    //   173: aload_0
    //   174: aconst_null
    //   175: putfield 43	rx/d/b:d	Lrx/d/b$b;
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    //   182: aload_0
    //   183: monitorexit
    //   184: iload 6
    //   186: istore_3
    //   187: iload 6
    //   189: ifgt -97 -> 92
    //   192: aload_0
    //   193: monitorenter
    //   194: aload_0
    //   195: getfield 37	rx/d/b:c	Z
    //   198: ifeq +21 -> 219
    //   201: aload_0
    //   202: getfield 43	rx/d/b:d	Lrx/d/b$b;
    //   205: astore_1
    //   206: aload_0
    //   207: aconst_null
    //   208: putfield 43	rx/d/b:d	Lrx/d/b$b;
    //   211: aload_0
    //   212: monitorexit
    //   213: aload_0
    //   214: aload_1
    //   215: invokevirtual 50	rx/d/b:a	(Lrx/d/b$b;)V
    //   218: return
    //   219: aload_0
    //   220: iconst_0
    //   221: putfield 35	rx/d/b:b	Z
    //   224: aconst_null
    //   225: astore_1
    //   226: goto -15 -> 211
    //   229: astore_1
    //   230: aload_0
    //   231: monitorexit
    //   232: aload_1
    //   233: athrow
    //   234: aload_0
    //   235: iconst_0
    //   236: putfield 35	rx/d/b:b	Z
    //   239: goto -61 -> 178
    //   242: astore_1
    //   243: aload_0
    //   244: monitorexit
    //   245: aload_1
    //   246: athrow
    //   247: astore_1
    //   248: iload 5
    //   250: istore_3
    //   251: goto -96 -> 155
    //   254: astore_1
    //   255: iconst_0
    //   256: istore_3
    //   257: goto -110 -> 147
    //   260: astore_1
    //   261: iload 4
    //   263: istore_3
    //   264: goto -117 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	b
    //   0	267	1	paramT	T
    //   47	126	2	localb	b
    //   91	173	3	i	int
    //   1	261	4	j	int
    //   4	245	5	k	int
    //   116	72	6	m	int
    // Exception table:
    //   from	to	target	type
    //   8	17	60	finally
    //   18	43	60	finally
    //   43	48	60	finally
    //   52	59	60	finally
    //   61	63	60	finally
    //   65	69	60	finally
    //   72	89	60	finally
    //   152	154	154	finally
    //   194	211	229	finally
    //   211	213	229	finally
    //   219	224	229	finally
    //   230	232	229	finally
    //   161	178	242	finally
    //   178	180	242	finally
    //   234	239	242	finally
    //   243	245	242	finally
    //   92	97	247	finally
    //   103	113	247	finally
    //   123	125	247	finally
    //   125	135	254	finally
    //   139	144	254	finally
    //   182	184	254	finally
    //   144	146	260	finally
    //   150	152	260	finally
  }
  
  public void a(Throwable paramThrowable)
  {
    rx.a.b.a(paramThrowable);
    try
    {
      if (this.c) {
        return;
      }
      if (this.b)
      {
        if (this.d == null) {
          this.d = new b();
        }
        this.d.a(new a(paramThrowable));
        return;
      }
    }
    finally {}
    this.b = true;
    b localb = this.d;
    this.d = null;
    a(localb);
    this.a.a(paramThrowable);
    try
    {
      this.b = false;
      return;
    }
    finally {}
  }
  
  void a(b paramb)
  {
    if ((paramb == null) || (paramb.b == 0)) {}
    int i;
    label23:
    Object localObject;
    do
    {
      return;
      paramb = paramb.a;
      int j = paramb.length;
      i = 0;
      if (i >= j) {
        break;
      }
      localObject = paramb[i];
    } while (localObject == null);
    if (localObject == e) {
      this.a.a(null);
    }
    for (;;)
    {
      i += 1;
      break label23;
      break;
      if (localObject == f) {
        this.a.a();
      } else if (localObject.getClass() == a.class) {
        this.a.a(((a)localObject).a);
      } else {
        this.a.a(localObject);
      }
    }
  }
  
  private static final class a
  {
    final Throwable a;
    
    a(Throwable paramThrowable)
    {
      this.a = paramThrowable;
    }
  }
  
  static final class b
  {
    Object[] a;
    int b;
    
    public void a(Object paramObject)
    {
      int i = this.b;
      Object localObject = this.a;
      if (localObject == null)
      {
        localObject = new Object[16];
        this.a = ((Object[])localObject);
      }
      for (;;)
      {
        localObject[i] = paramObject;
        this.b = (i + 1);
        return;
        if (i == localObject.length)
        {
          Object[] arrayOfObject = new Object[(i >> 2) + i];
          System.arraycopy(localObject, 0, arrayOfObject, 0, i);
          this.a = arrayOfObject;
          localObject = arrayOfObject;
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */