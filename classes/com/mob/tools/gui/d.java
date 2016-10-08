package com.mob.tools.gui;

public class d<K, V>
{
  private int a;
  private int b;
  private a<K, V> c;
  private a<K, V> d;
  
  public d(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a()
  {
    return this.b;
  }
  
  /* Error */
  public V a(K paramK)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 30	com/mob/tools/gui/d:c	Lcom/mob/tools/gui/d$a;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +14 -> 24
    //   13: aload_2
    //   14: getfield 33	com/mob/tools/gui/d$a:a	Ljava/lang/Object;
    //   17: aload_1
    //   18: invokevirtual 37	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   21: ifeq +77 -> 98
    //   24: aload_3
    //   25: astore_1
    //   26: aload_2
    //   27: ifnull +67 -> 94
    //   30: aload_2
    //   31: getfield 38	com/mob/tools/gui/d$a:c	Lcom/mob/tools/gui/d$a;
    //   34: ifnull +55 -> 89
    //   37: aload_2
    //   38: getfield 40	com/mob/tools/gui/d$a:d	Lcom/mob/tools/gui/d$a;
    //   41: ifnonnull +65 -> 106
    //   44: aload_2
    //   45: getfield 38	com/mob/tools/gui/d$a:c	Lcom/mob/tools/gui/d$a;
    //   48: aconst_null
    //   49: putfield 40	com/mob/tools/gui/d$a:d	Lcom/mob/tools/gui/d$a;
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 41	com/mob/tools/gui/d:d	Lcom/mob/tools/gui/d$a;
    //   57: getfield 38	com/mob/tools/gui/d$a:c	Lcom/mob/tools/gui/d$a;
    //   60: putfield 41	com/mob/tools/gui/d:d	Lcom/mob/tools/gui/d$a;
    //   63: aload_2
    //   64: aconst_null
    //   65: putfield 38	com/mob/tools/gui/d$a:c	Lcom/mob/tools/gui/d$a;
    //   68: aload_2
    //   69: aload_0
    //   70: getfield 30	com/mob/tools/gui/d:c	Lcom/mob/tools/gui/d$a;
    //   73: putfield 40	com/mob/tools/gui/d$a:d	Lcom/mob/tools/gui/d$a;
    //   76: aload_0
    //   77: getfield 30	com/mob/tools/gui/d:c	Lcom/mob/tools/gui/d$a;
    //   80: aload_2
    //   81: putfield 38	com/mob/tools/gui/d$a:c	Lcom/mob/tools/gui/d$a;
    //   84: aload_0
    //   85: aload_2
    //   86: putfield 30	com/mob/tools/gui/d:c	Lcom/mob/tools/gui/d$a;
    //   89: aload_2
    //   90: getfield 43	com/mob/tools/gui/d$a:b	Ljava/lang/Object;
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: areturn
    //   98: aload_2
    //   99: getfield 40	com/mob/tools/gui/d$a:d	Lcom/mob/tools/gui/d$a;
    //   102: astore_2
    //   103: goto -94 -> 9
    //   106: aload_2
    //   107: getfield 38	com/mob/tools/gui/d$a:c	Lcom/mob/tools/gui/d$a;
    //   110: aload_2
    //   111: getfield 40	com/mob/tools/gui/d$a:d	Lcom/mob/tools/gui/d$a;
    //   114: putfield 40	com/mob/tools/gui/d$a:d	Lcom/mob/tools/gui/d$a;
    //   117: aload_2
    //   118: getfield 40	com/mob/tools/gui/d$a:d	Lcom/mob/tools/gui/d$a;
    //   121: aload_2
    //   122: getfield 38	com/mob/tools/gui/d$a:c	Lcom/mob/tools/gui/d$a;
    //   125: putfield 38	com/mob/tools/gui/d$a:c	Lcom/mob/tools/gui/d$a;
    //   128: goto -65 -> 63
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	d
    //   0	136	1	paramK	K
    //   8	114	2	locala	a
    //   1	24	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	131	finally
    //   13	24	131	finally
    //   30	63	131	finally
    //   63	89	131	finally
    //   89	94	131	finally
    //   98	103	131	finally
    //   106	128	131	finally
  }
  
  /* Error */
  public void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/mob/tools/gui/d:a	I
    //   6: istore 4
    //   8: iload 4
    //   10: ifgt +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 30	com/mob/tools/gui/d:c	Lcom/mob/tools/gui/d$a;
    //   20: astore_3
    //   21: aload_3
    //   22: ifnull -9 -> 13
    //   25: aload_3
    //   26: invokestatic 49	com/mob/tools/gui/d$a:a	(Lcom/mob/tools/gui/d$a;)J
    //   29: lload_1
    //   30: lcmp
    //   31: ifge +71 -> 102
    //   34: aload_3
    //   35: getfield 38	com/mob/tools/gui/d$a:c	Lcom/mob/tools/gui/d$a;
    //   38: ifnull +14 -> 52
    //   41: aload_3
    //   42: getfield 38	com/mob/tools/gui/d$a:c	Lcom/mob/tools/gui/d$a;
    //   45: aload_3
    //   46: getfield 40	com/mob/tools/gui/d$a:d	Lcom/mob/tools/gui/d$a;
    //   49: putfield 40	com/mob/tools/gui/d$a:d	Lcom/mob/tools/gui/d$a;
    //   52: aload_3
    //   53: getfield 40	com/mob/tools/gui/d$a:d	Lcom/mob/tools/gui/d$a;
    //   56: ifnull +14 -> 70
    //   59: aload_3
    //   60: getfield 40	com/mob/tools/gui/d$a:d	Lcom/mob/tools/gui/d$a;
    //   63: aload_3
    //   64: getfield 38	com/mob/tools/gui/d$a:c	Lcom/mob/tools/gui/d$a;
    //   67: putfield 38	com/mob/tools/gui/d$a:c	Lcom/mob/tools/gui/d$a;
    //   70: aload_3
    //   71: aload_0
    //   72: getfield 30	com/mob/tools/gui/d:c	Lcom/mob/tools/gui/d$a;
    //   75: invokevirtual 37	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +14 -> 92
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 30	com/mob/tools/gui/d:c	Lcom/mob/tools/gui/d$a;
    //   86: getfield 40	com/mob/tools/gui/d$a:d	Lcom/mob/tools/gui/d$a;
    //   89: putfield 30	com/mob/tools/gui/d:c	Lcom/mob/tools/gui/d$a;
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 27	com/mob/tools/gui/d:b	I
    //   97: iconst_1
    //   98: isub
    //   99: putfield 27	com/mob/tools/gui/d:b	I
    //   102: aload_3
    //   103: getfield 40	com/mob/tools/gui/d$a:d	Lcom/mob/tools/gui/d$a;
    //   106: astore_3
    //   107: goto -86 -> 21
    //   110: astore_3
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_3
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	d
    //   0	115	1	paramLong	long
    //   20	87	3	locala	a
    //   110	4	3	localObject	Object
    //   6	3	4	i	int
    // Exception table:
    //   from	to	target	type
    //   2	8	110	finally
    //   16	21	110	finally
    //   25	52	110	finally
    //   52	70	110	finally
    //   70	92	110	finally
    //   92	102	110	finally
    //   102	107	110	finally
  }
  
  public boolean a(K paramK, V paramV)
  {
    a locala1 = null;
    if (paramK != null) {}
    boolean bool;
    try
    {
      int i = this.a;
      if (i <= 0)
      {
        bool = false;
        return bool;
      }
      while (this.b >= this.a)
      {
        locala1 = this.d;
        this.d = this.d.c;
        this.d.d = null;
        this.b -= 1;
      }
      locala2 = locala1;
    }
    finally {}
    a locala2;
    if (locala1 == null) {
      locala2 = new a(null);
    }
    a.a(locala2, System.currentTimeMillis());
    locala2.a = paramK;
    locala2.b = paramV;
    locala2.c = null;
    locala2.d = this.c;
    if (this.b == 0) {
      this.d = locala2;
    }
    for (;;)
    {
      this.c = locala2;
      this.b += 1;
      bool = true;
      break;
      this.c.c = locala2;
    }
  }
  
  private static class a<K, V>
  {
    public K a;
    public V b;
    public a<K, V> c;
    public a<K, V> d;
    private long e;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\gui\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */