package com.inmobi.ads;

import com.inmobi.commons.core.b.b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

public class c
{
  public static final String[] a = { "id", "ad_content", "ad_type", "ad_size", "placement_id", "insertion_ts", "imp_id" };
  private static final String b = c.class.getSimpleName();
  private static c c;
  private static Object d = new Object();
  
  private c()
  {
    b localb = b.a();
    localb.a("ad", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, placement_id INTEGER NOT NULL, ad_content TEXT NOT NULL, ad_type TEXT NOT NULL, ad_size TEXT, insertion_ts INTEGER NOT NULL, imp_id TEXT NOT NULL)");
    localb.b();
  }
  
  public static c a()
  {
    Object localObject1 = c;
    if (localObject1 == null) {
      synchronized (d)
      {
        c localc2 = c;
        localObject1 = localc2;
        if (localc2 == null)
        {
          c = new c();
          localObject1 = c;
        }
        return (c)localObject1;
      }
    }
    return localc1;
  }
  
  public int a(long paramLong, String paramString)
  {
    b localb = b.a();
    if ((paramString != null) && (paramString.trim().length() != 0)) {}
    for (int i = localb.b("ad", "placement_id=? AND ad_size=?", new String[] { String.valueOf(paramLong), paramString });; i = localb.b("ad", "placement_id=?", new String[] { String.valueOf(paramLong) }))
    {
      localb.b();
      return i;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    b localb = b.a();
    int i = localb.a("ad", "ad_type=? AND insertion_ts<?", new String[] { paramString, String.valueOf(System.currentTimeMillis() - 1000L * paramLong) });
    Logger.a(Logger.InternalLogLevel.INTERNAL, b, "Deleted " + i + " expired ads from cache of type:" + paramString);
    localb.b();
  }
  
  /* Error */
  public void a(java.util.List<a> paramList, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_2
    //   3: ifeq +16 -> 19
    //   6: aload_1
    //   7: invokeinterface 130 1 0
    //   12: istore 5
    //   14: iload 5
    //   16: ifne +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 51	com/inmobi/commons/core/b/b:a	()Lcom/inmobi/commons/core/b/b;
    //   25: astore 4
    //   27: iconst_0
    //   28: istore 5
    //   30: iload 5
    //   32: aload_1
    //   33: invokeinterface 130 1 0
    //   38: if_icmpge +34 -> 72
    //   41: aload 4
    //   43: ldc 53
    //   45: aload_1
    //   46: iload 5
    //   48: invokeinterface 134 2 0
    //   53: checkcast 136	com/inmobi/ads/a
    //   56: invokevirtual 139	com/inmobi/ads/a:a	()Landroid/content/ContentValues;
    //   59: invokevirtual 142	com/inmobi/commons/core/b/b:a	(Ljava/lang/String;Landroid/content/ContentValues;)Z
    //   62: pop
    //   63: iload 5
    //   65: iconst_1
    //   66: iadd
    //   67: istore 5
    //   69: goto -39 -> 30
    //   72: aload 4
    //   74: ldc 53
    //   76: ldc -112
    //   78: iconst_1
    //   79: anewarray 29	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: aload_3
    //   85: aastore
    //   86: invokevirtual 81	com/inmobi/commons/core/b/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   89: iload_2
    //   90: isub
    //   91: istore_2
    //   92: iload_2
    //   93: ifle +177 -> 270
    //   96: new 146	java/util/HashMap
    //   99: dup
    //   100: invokespecial 147	java/util/HashMap:<init>	()V
    //   103: astore_1
    //   104: aload_1
    //   105: ldc -107
    //   107: aload_3
    //   108: invokeinterface 155 3 0
    //   113: pop
    //   114: aload_1
    //   115: ldc -99
    //   117: iload_2
    //   118: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: invokeinterface 155 3 0
    //   126: pop
    //   127: invokestatic 167	com/inmobi/commons/core/c/a:a	()Lcom/inmobi/commons/core/c/a;
    //   130: ldc -87
    //   132: ldc -85
    //   134: aload_1
    //   135: invokevirtual 174	com/inmobi/commons/core/c/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   138: aload 4
    //   140: ldc 53
    //   142: iconst_1
    //   143: anewarray 29	java/lang/String
    //   146: dup
    //   147: iconst_0
    //   148: ldc 31
    //   150: aastore
    //   151: ldc -112
    //   153: iconst_1
    //   154: anewarray 29	java/lang/String
    //   157: dup
    //   158: iconst_0
    //   159: aload_3
    //   160: aastore
    //   161: aconst_null
    //   162: aconst_null
    //   163: ldc -80
    //   165: iload_2
    //   166: invokestatic 179	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   169: invokevirtual 182	com/inmobi/commons/core/b/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   172: astore_1
    //   173: aload_1
    //   174: invokeinterface 130 1 0
    //   179: anewarray 29	java/lang/String
    //   182: astore_3
    //   183: iconst_0
    //   184: istore_2
    //   185: iload_2
    //   186: aload_1
    //   187: invokeinterface 130 1 0
    //   192: if_icmpge +31 -> 223
    //   195: aload_3
    //   196: iload_2
    //   197: aload_1
    //   198: iload_2
    //   199: invokeinterface 134 2 0
    //   204: checkcast 184	android/content/ContentValues
    //   207: ldc 31
    //   209: invokevirtual 188	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   212: invokestatic 191	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   215: aastore
    //   216: iload_2
    //   217: iconst_1
    //   218: iadd
    //   219: istore_2
    //   220: goto -35 -> 185
    //   223: aload_3
    //   224: invokestatic 196	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   227: ldc -58
    //   229: ldc -56
    //   231: invokevirtual 204	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   234: ldc -50
    //   236: ldc -48
    //   238: invokevirtual 204	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   241: astore_1
    //   242: aload 4
    //   244: ldc 53
    //   246: new 104	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   253: ldc -46
    //   255: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_1
    //   259: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: aconst_null
    //   266: invokevirtual 96	com/inmobi/commons/core/b/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   269: pop
    //   270: aload 4
    //   272: invokevirtual 60	com/inmobi/commons/core/b/b:b	()V
    //   275: goto -256 -> 19
    //   278: astore_1
    //   279: aload_0
    //   280: monitorexit
    //   281: aload_1
    //   282: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	c
    //   0	283	1	paramList	java.util.List<a>
    //   0	283	2	paramInt	int
    //   0	283	3	paramString	String
    //   25	246	4	localb	b
    //   12	56	5	i	int
    // Exception table:
    //   from	to	target	type
    //   6	14	278	finally
    //   22	27	278	finally
    //   30	63	278	finally
    //   72	92	278	finally
    //   96	183	278	finally
    //   185	216	278	finally
    //   223	270	278	finally
    //   270	275	278	finally
  }
  
  /* Error */
  public a b(long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 51	com/inmobi/commons/core/b/b:a	()Lcom/inmobi/commons/core/b/b;
    //   5: astore 4
    //   7: aload_3
    //   8: ifnull +100 -> 108
    //   11: aload_3
    //   12: invokevirtual 68	java/lang/String:trim	()Ljava/lang/String;
    //   15: invokevirtual 72	java/lang/String:length	()I
    //   18: ifeq +90 -> 108
    //   21: aload 4
    //   23: ldc 53
    //   25: getstatic 45	com/inmobi/ads/c:a	[Ljava/lang/String;
    //   28: ldc 74
    //   30: iconst_2
    //   31: anewarray 29	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: lload_1
    //   37: invokestatic 78	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aload_3
    //   44: aastore
    //   45: aconst_null
    //   46: aconst_null
    //   47: ldc 41
    //   49: ldc -41
    //   51: invokevirtual 182	com/inmobi/commons/core/b/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   54: astore_3
    //   55: aload_3
    //   56: iconst_0
    //   57: invokeinterface 134 2 0
    //   62: checkcast 184	android/content/ContentValues
    //   65: astore_3
    //   66: aload 4
    //   68: ldc 53
    //   70: ldc -39
    //   72: iconst_1
    //   73: anewarray 29	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: aload_3
    //   79: ldc 31
    //   81: invokevirtual 188	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   84: invokevirtual 220	java/lang/Integer:intValue	()I
    //   87: invokestatic 179	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   90: aastore
    //   91: invokevirtual 96	com/inmobi/commons/core/b/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   94: pop
    //   95: new 136	com/inmobi/ads/a
    //   98: dup
    //   99: aload_3
    //   100: invokespecial 223	com/inmobi/ads/a:<init>	(Landroid/content/ContentValues;)V
    //   103: astore_3
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_3
    //   107: areturn
    //   108: aload 4
    //   110: ldc 53
    //   112: getstatic 45	com/inmobi/ads/c:a	[Ljava/lang/String;
    //   115: ldc 83
    //   117: iconst_1
    //   118: anewarray 29	java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: lload_1
    //   124: invokestatic 78	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   127: aastore
    //   128: aconst_null
    //   129: aconst_null
    //   130: ldc 41
    //   132: ldc -41
    //   134: invokevirtual 182	com/inmobi/commons/core/b/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   137: astore_3
    //   138: goto -83 -> 55
    //   141: astore_3
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_3
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	c
    //   0	146	1	paramLong	long
    //   0	146	3	paramString	String
    //   5	104	4	localb	b
    // Exception table:
    //   from	to	target	type
    //   2	7	141	finally
    //   11	55	141	finally
    //   55	104	141	finally
    //   108	138	141	finally
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */