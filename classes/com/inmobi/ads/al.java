package com.inmobi.ads;

import android.content.ContentValues;
import com.inmobi.commons.core.b.b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class al
{
  public static final String[] a = { "id", "placement_id", "tp_key", "last_accessed_ts" };
  private static final String b = al.class.getSimpleName();
  private static al c;
  private static Object d = new Object();
  
  private al()
  {
    b localb = b.a();
    localb.a("placement", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, placement_id INTEGER NOT NULL,tp_key TEXT,last_accessed_ts INTEGER NOT NULL,UNIQUE(placement_id,tp_key))");
    localb.b();
  }
  
  public static al a()
  {
    Object localObject1 = c;
    if (localObject1 == null) {
      synchronized (d)
      {
        al localal2 = c;
        localObject1 = localal2;
        if (localal2 == null)
        {
          c = new al();
          localObject1 = c;
        }
        return (al)localObject1;
      }
    }
    return localal1;
  }
  
  public int a(long paramLong)
  {
    b localb = b.a();
    int i = localb.a("placement", "last_accessed_ts<?", new String[] { String.valueOf(System.currentTimeMillis() - 1000L * paramLong) });
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Deleted " + i + " expired pids from cache");
    localb.b();
    return i;
  }
  
  /* Error */
  public int a(List<ak> paramList, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: ifnull +16 -> 22
    //   9: aload_1
    //   10: invokeinterface 111 1 0
    //   15: istore 5
    //   17: iload 5
    //   19: ifne +9 -> 28
    //   22: iconst_0
    //   23: istore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: invokestatic 45	com/inmobi/commons/core/b/b:a	()Lcom/inmobi/commons/core/b/b;
    //   31: astore_3
    //   32: iconst_0
    //   33: istore 5
    //   35: iload 5
    //   37: aload_1
    //   38: invokeinterface 111 1 0
    //   43: if_icmpge +83 -> 126
    //   46: aload_1
    //   47: iload 5
    //   49: invokeinterface 115 2 0
    //   54: checkcast 117	com/inmobi/ads/ak
    //   57: invokevirtual 119	com/inmobi/ads/ak:c	()J
    //   60: lstore 7
    //   62: aload_1
    //   63: iload 5
    //   65: invokeinterface 115 2 0
    //   70: checkcast 117	com/inmobi/ads/ak
    //   73: invokevirtual 121	com/inmobi/ads/ak:d	()Ljava/lang/String;
    //   76: astore 4
    //   78: aload_3
    //   79: ldc 47
    //   81: aload_1
    //   82: iload 5
    //   84: invokeinterface 115 2 0
    //   89: checkcast 117	com/inmobi/ads/ak
    //   92: invokevirtual 125	com/inmobi/ads/ak:f	()Landroid/content/ContentValues;
    //   95: ldc 127
    //   97: iconst_2
    //   98: anewarray 29	java/lang/String
    //   101: dup
    //   102: iconst_0
    //   103: lload 7
    //   105: invokestatic 73	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: aload 4
    //   113: aastore
    //   114: invokevirtual 130	com/inmobi/commons/core/b/b:a	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)V
    //   117: iload 5
    //   119: iconst_1
    //   120: iadd
    //   121: istore 5
    //   123: goto -88 -> 35
    //   126: aload_3
    //   127: ldc 47
    //   129: invokevirtual 133	com/inmobi/commons/core/b/b:a	(Ljava/lang/String;)I
    //   132: iload_2
    //   133: isub
    //   134: istore 5
    //   136: iload 5
    //   138: ifle +130 -> 268
    //   141: aload_3
    //   142: ldc 47
    //   144: iconst_1
    //   145: anewarray 29	java/lang/String
    //   148: dup
    //   149: iconst_0
    //   150: ldc 31
    //   152: aastore
    //   153: aconst_null
    //   154: aconst_null
    //   155: aconst_null
    //   156: aconst_null
    //   157: ldc -121
    //   159: iload 5
    //   161: invokestatic 138	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   164: invokevirtual 141	com/inmobi/commons/core/b/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   167: astore_1
    //   168: aload_1
    //   169: invokeinterface 111 1 0
    //   174: anewarray 29	java/lang/String
    //   177: astore 4
    //   179: iload 6
    //   181: istore_2
    //   182: iload_2
    //   183: aload_1
    //   184: invokeinterface 111 1 0
    //   189: if_icmpge +32 -> 221
    //   192: aload 4
    //   194: iload_2
    //   195: aload_1
    //   196: iload_2
    //   197: invokeinterface 115 2 0
    //   202: checkcast 143	android/content/ContentValues
    //   205: ldc 31
    //   207: invokevirtual 147	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   210: invokestatic 150	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   213: aastore
    //   214: iload_2
    //   215: iconst_1
    //   216: iadd
    //   217: istore_2
    //   218: goto -36 -> 182
    //   221: aload 4
    //   223: invokestatic 155	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   226: ldc -99
    //   228: ldc -97
    //   230: invokevirtual 163	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   233: ldc -91
    //   235: ldc -89
    //   237: invokevirtual 163	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   240: astore_1
    //   241: aload_3
    //   242: ldc 47
    //   244: new 84	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   251: ldc -87
    //   253: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_1
    //   257: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: aconst_null
    //   264: invokevirtual 76	com/inmobi/commons/core/b/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   267: pop
    //   268: aload_3
    //   269: invokevirtual 54	com/inmobi/commons/core/b/b:b	()V
    //   272: iload 5
    //   274: istore_2
    //   275: goto -251 -> 24
    //   278: astore_1
    //   279: aload_0
    //   280: monitorexit
    //   281: aload_1
    //   282: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	al
    //   0	283	1	paramList	List<ak>
    //   0	283	2	paramInt	int
    //   31	238	3	localb	b
    //   76	146	4	localObject	Object
    //   15	258	5	i	int
    //   1	179	6	j	int
    //   60	44	7	l	long
    // Exception table:
    //   from	to	target	type
    //   9	17	278	finally
    //   28	32	278	finally
    //   35	117	278	finally
    //   126	136	278	finally
    //   141	179	278	finally
    //   182	214	278	finally
    //   221	268	278	finally
    //   268	272	278	finally
  }
  
  public List<ak> b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = b.a();
    List localList = ((b)localObject).a("placement", a, null, null, null, null, null, null);
    ((b)localObject).b();
    localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new ak((ContentValues)((Iterator)localObject).next()));
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */