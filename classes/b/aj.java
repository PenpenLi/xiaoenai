package b;

import b.a.b.j;
import b.a.f;
import java.util.List;

final class aj
  implements g
{
  volatile boolean a;
  al b;
  j c;
  private final ag d;
  private boolean e;
  
  protected aj(ag paramag, al paramal)
  {
    this.d = paramag;
    this.b = paramal;
  }
  
  private aq a(boolean paramBoolean)
  {
    return new a(0, this.b, paramBoolean).a(this.b);
  }
  
  private String c()
  {
    if (this.a) {}
    for (String str = "canceled call";; str = "call")
    {
      ab localab = this.b.a().c("/...");
      return str + " to " + localab;
    }
  }
  
  public al a()
  {
    return this.b;
  }
  
  /* Error */
  aq a(al paramal, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 90	b/al:d	()Lb/an;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +382 -> 388
    //   9: aload_1
    //   10: invokevirtual 93	b/al:e	()Lb/al$a;
    //   13: astore_1
    //   14: aload_3
    //   15: invokevirtual 98	b/an:a	()Lb/ae;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull +15 -> 37
    //   25: aload_1
    //   26: ldc 100
    //   28: aload 4
    //   30: invokevirtual 103	b/ae:toString	()Ljava/lang/String;
    //   33: invokevirtual 108	b/al$a:a	(Ljava/lang/String;Ljava/lang/String;)Lb/al$a;
    //   36: pop
    //   37: aload_3
    //   38: invokevirtual 111	b/an:b	()J
    //   41: lstore 7
    //   43: lload 7
    //   45: ldc2_w 112
    //   48: lcmp
    //   49: ifeq +76 -> 125
    //   52: aload_1
    //   53: ldc 115
    //   55: lload 7
    //   57: invokestatic 120	java/lang/Long:toString	(J)Ljava/lang/String;
    //   60: invokevirtual 108	b/al$a:a	(Ljava/lang/String;Ljava/lang/String;)Lb/al$a;
    //   63: pop
    //   64: aload_1
    //   65: ldc 122
    //   67: invokevirtual 125	b/al$a:b	(Ljava/lang/String;)Lb/al$a;
    //   70: pop
    //   71: aload_1
    //   72: invokevirtual 127	b/al$a:b	()Lb/al;
    //   75: astore_1
    //   76: aload_0
    //   77: new 129	b/a/b/j
    //   80: dup
    //   81: aload_0
    //   82: getfield 26	b/aj:d	Lb/ag;
    //   85: aload_1
    //   86: iconst_0
    //   87: iconst_0
    //   88: iload_2
    //   89: aconst_null
    //   90: aconst_null
    //   91: aconst_null
    //   92: invokespecial 132	b/a/b/j:<init>	(Lb/ag;Lb/al;ZZZLb/a/b/w;Lb/a/b/s;Lb/aq;)V
    //   95: putfield 134	b/aj:c	Lb/a/b/j;
    //   98: iconst_0
    //   99: istore 6
    //   101: aload_0
    //   102: getfield 48	b/aj:a	Z
    //   105: ifeq +39 -> 144
    //   108: aload_0
    //   109: getfield 134	b/aj:c	Lb/a/b/j;
    //   112: invokevirtual 136	b/a/b/j:e	()V
    //   115: new 87	java/io/IOException
    //   118: dup
    //   119: ldc -118
    //   121: invokespecial 141	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   124: athrow
    //   125: aload_1
    //   126: ldc 122
    //   128: ldc -113
    //   130: invokevirtual 108	b/al$a:a	(Ljava/lang/String;Ljava/lang/String;)Lb/al$a;
    //   133: pop
    //   134: aload_1
    //   135: ldc 115
    //   137: invokevirtual 125	b/al$a:b	(Ljava/lang/String;)Lb/al$a;
    //   140: pop
    //   141: goto -70 -> 71
    //   144: aload_0
    //   145: getfield 134	b/aj:c	Lb/a/b/j;
    //   148: invokevirtual 145	b/a/b/j:a	()V
    //   151: aload_0
    //   152: getfield 134	b/aj:c	Lb/a/b/j;
    //   155: invokevirtual 148	b/a/b/j:g	()V
    //   158: aload_0
    //   159: getfield 134	b/aj:c	Lb/a/b/j;
    //   162: invokevirtual 151	b/a/b/j:c	()Lb/aq;
    //   165: astore 4
    //   167: aload_0
    //   168: getfield 134	b/aj:c	Lb/a/b/j;
    //   171: invokevirtual 154	b/a/b/j:h	()Lb/al;
    //   174: astore 5
    //   176: aload 5
    //   178: ifnonnull +107 -> 285
    //   181: iload_2
    //   182: ifne +10 -> 192
    //   185: aload_0
    //   186: getfield 134	b/aj:c	Lb/a/b/j;
    //   189: invokevirtual 136	b/a/b/j:e	()V
    //   192: aload 4
    //   194: areturn
    //   195: astore_1
    //   196: aload_1
    //   197: invokevirtual 157	b/a/b/q:a	()Ljava/io/IOException;
    //   200: athrow
    //   201: astore_1
    //   202: iconst_1
    //   203: istore 6
    //   205: iload 6
    //   207: ifeq +13 -> 220
    //   210: aload_0
    //   211: getfield 134	b/aj:c	Lb/a/b/j;
    //   214: invokevirtual 161	b/a/b/j:f	()Lb/a/b/w;
    //   217: invokevirtual 165	b/a/b/w:b	()V
    //   220: aload_1
    //   221: athrow
    //   222: astore_1
    //   223: aload_0
    //   224: getfield 134	b/aj:c	Lb/a/b/j;
    //   227: aload_1
    //   228: invokevirtual 166	b/a/b/t:a	()Ljava/io/IOException;
    //   231: aconst_null
    //   232: invokevirtual 169	b/a/b/j:a	(Ljava/io/IOException;Lc/y;)Lb/a/b/j;
    //   235: astore_3
    //   236: aload_3
    //   237: ifnull +18 -> 255
    //   240: aload_0
    //   241: aload_3
    //   242: putfield 134	b/aj:c	Lb/a/b/j;
    //   245: goto -144 -> 101
    //   248: iconst_0
    //   249: istore 6
    //   251: astore_1
    //   252: goto -47 -> 205
    //   255: aload_1
    //   256: invokevirtual 166	b/a/b/t:a	()Ljava/io/IOException;
    //   259: athrow
    //   260: astore_1
    //   261: aload_0
    //   262: getfield 134	b/aj:c	Lb/a/b/j;
    //   265: aload_1
    //   266: aconst_null
    //   267: invokevirtual 169	b/a/b/j:a	(Ljava/io/IOException;Lc/y;)Lb/a/b/j;
    //   270: astore_3
    //   271: aload_3
    //   272: ifnull +11 -> 283
    //   275: aload_0
    //   276: aload_3
    //   277: putfield 134	b/aj:c	Lb/a/b/j;
    //   280: goto -179 -> 101
    //   283: aload_1
    //   284: athrow
    //   285: aload_0
    //   286: getfield 134	b/aj:c	Lb/a/b/j;
    //   289: invokevirtual 161	b/a/b/j:f	()Lb/a/b/w;
    //   292: astore_3
    //   293: iload 6
    //   295: iconst_1
    //   296: iadd
    //   297: istore 6
    //   299: iload 6
    //   301: bipush 20
    //   303: if_icmple +35 -> 338
    //   306: aload_3
    //   307: invokevirtual 165	b/a/b/w:b	()V
    //   310: new 171	java/net/ProtocolException
    //   313: dup
    //   314: new 64	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   321: ldc -83
    //   323: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: iload 6
    //   328: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokespecial 177	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   337: athrow
    //   338: aload_3
    //   339: astore_1
    //   340: aload_0
    //   341: getfield 134	b/aj:c	Lb/a/b/j;
    //   344: aload 5
    //   346: invokevirtual 55	b/al:a	()Lb/ab;
    //   349: invokevirtual 180	b/a/b/j:a	(Lb/ab;)Z
    //   352: ifne +9 -> 361
    //   355: aload_3
    //   356: invokevirtual 165	b/a/b/w:b	()V
    //   359: aconst_null
    //   360: astore_1
    //   361: aload_0
    //   362: new 129	b/a/b/j
    //   365: dup
    //   366: aload_0
    //   367: getfield 26	b/aj:d	Lb/ag;
    //   370: aload 5
    //   372: iconst_0
    //   373: iconst_0
    //   374: iload_2
    //   375: aload_1
    //   376: aconst_null
    //   377: aload 4
    //   379: invokespecial 132	b/a/b/j:<init>	(Lb/ag;Lb/al;ZZZLb/a/b/w;Lb/a/b/s;Lb/aq;)V
    //   382: putfield 134	b/aj:c	Lb/a/b/j;
    //   385: goto -284 -> 101
    //   388: goto -312 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	aj
    //   0	391	1	paramal	al
    //   0	391	2	paramBoolean	boolean
    //   4	352	3	localObject1	Object
    //   18	360	4	localObject2	Object
    //   174	197	5	localal	al
    //   99	228	6	i	int
    //   41	15	7	l	long
    // Exception table:
    //   from	to	target	type
    //   144	158	195	b/a/b/q
    //   144	158	201	finally
    //   196	201	201	finally
    //   223	236	201	finally
    //   255	260	201	finally
    //   261	271	201	finally
    //   283	285	201	finally
    //   144	158	222	b/a/b/t
    //   240	245	248	finally
    //   275	280	248	finally
    //   144	158	260	java/io/IOException
  }
  
  public void a(h paramh)
  {
    a(paramh, false);
  }
  
  void a(h paramh, boolean paramBoolean)
  {
    try
    {
      if (this.e) {
        throw new IllegalStateException("Already Executed");
      }
    }
    finally {}
    this.e = true;
    this.d.s().a(new b(paramh, paramBoolean, null));
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  class a
    implements ad.a
  {
    private final int b;
    private final al c;
    private final boolean d;
    
    a(int paramInt, al paramal, boolean paramBoolean)
    {
      this.b = paramInt;
      this.c = paramal;
      this.d = paramBoolean;
    }
    
    public aq a(al paramal)
    {
      if (this.b < aj.b(aj.this).v().size())
      {
        Object localObject = new a(aj.this, this.b + 1, paramal, this.d);
        paramal = (ad)aj.b(aj.this).v().get(this.b);
        localObject = paramal.a((ad.a)localObject);
        if (localObject == null) {
          throw new NullPointerException("application interceptor " + paramal + " returned null");
        }
        return (aq)localObject;
      }
      return aj.this.a(paramal, this.d);
    }
  }
  
  final class b
    extends f
  {
    private final h c;
    private final boolean d;
    
    private b(h paramh, boolean paramBoolean)
    {
      super(new Object[] { aj.this.b.a().toString() });
      this.c = paramh;
      this.d = paramBoolean;
    }
    
    String a()
    {
      return aj.this.b.a().f();
    }
    
    /* Error */
    protected void b()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: aload_0
      //   3: getfield 17	b/aj$b:a	Lb/aj;
      //   6: aload_0
      //   7: getfield 42	b/aj$b:d	Z
      //   10: invokestatic 55	b/aj:a	(Lb/aj;Z)Lb/aq;
      //   13: astore_1
      //   14: aload_0
      //   15: getfield 17	b/aj$b:a	Lb/aj;
      //   18: getfield 57	b/aj:a	Z
      //   21: istore_3
      //   22: iload_3
      //   23: ifeq +40 -> 63
      //   26: aload_0
      //   27: getfield 40	b/aj$b:c	Lb/h;
      //   30: aload_0
      //   31: getfield 17	b/aj$b:a	Lb/aj;
      //   34: new 52	java/io/IOException
      //   37: dup
      //   38: ldc 59
      //   40: invokespecial 62	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   43: invokeinterface 67 3 0
      //   48: aload_0
      //   49: getfield 17	b/aj$b:a	Lb/aj;
      //   52: invokestatic 70	b/aj:b	(Lb/aj;)Lb/ag;
      //   55: invokevirtual 76	b/ag:s	()Lb/t;
      //   58: aload_0
      //   59: invokevirtual 81	b/t:b	(Lb/aj$b;)V
      //   62: return
      //   63: aload_0
      //   64: getfield 40	b/aj$b:c	Lb/h;
      //   67: aload_0
      //   68: getfield 17	b/aj$b:a	Lb/aj;
      //   71: aload_1
      //   72: invokeinterface 84 3 0
      //   77: goto -29 -> 48
      //   80: astore_1
      //   81: iload_2
      //   82: ifeq +53 -> 135
      //   85: getstatic 89	b/a/d:a	Ljava/util/logging/Logger;
      //   88: getstatic 95	java/util/logging/Level:INFO	Ljava/util/logging/Level;
      //   91: new 97	java/lang/StringBuilder
      //   94: dup
      //   95: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   98: ldc 101
      //   100: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   103: aload_0
      //   104: getfield 17	b/aj$b:a	Lb/aj;
      //   107: invokestatic 108	b/aj:a	(Lb/aj;)Ljava/lang/String;
      //   110: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   113: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   116: aload_1
      //   117: invokevirtual 115	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   120: aload_0
      //   121: getfield 17	b/aj$b:a	Lb/aj;
      //   124: invokestatic 70	b/aj:b	(Lb/aj;)Lb/ag;
      //   127: invokevirtual 76	b/ag:s	()Lb/t;
      //   130: aload_0
      //   131: invokevirtual 81	b/t:b	(Lb/aj$b;)V
      //   134: return
      //   135: aload_0
      //   136: getfield 40	b/aj$b:c	Lb/h;
      //   139: aload_0
      //   140: getfield 17	b/aj$b:a	Lb/aj;
      //   143: aload_1
      //   144: invokeinterface 67 3 0
      //   149: goto -29 -> 120
      //   152: astore_1
      //   153: aload_0
      //   154: getfield 17	b/aj$b:a	Lb/aj;
      //   157: invokestatic 70	b/aj:b	(Lb/aj;)Lb/ag;
      //   160: invokevirtual 76	b/ag:s	()Lb/t;
      //   163: aload_0
      //   164: invokevirtual 81	b/t:b	(Lb/aj$b;)V
      //   167: aload_1
      //   168: athrow
      //   169: astore_1
      //   170: iconst_0
      //   171: istore_2
      //   172: goto -91 -> 81
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	175	0	this	b
      //   13	59	1	localaq	aq
      //   80	64	1	localIOException1	java.io.IOException
      //   152	16	1	localObject	Object
      //   169	1	1	localIOException2	java.io.IOException
      //   1	171	2	i	int
      //   21	2	3	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   26	48	80	java/io/IOException
      //   63	77	80	java/io/IOException
      //   2	22	152	finally
      //   26	48	152	finally
      //   63	77	152	finally
      //   85	120	152	finally
      //   135	149	152	finally
      //   2	22	169	java/io/IOException
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */