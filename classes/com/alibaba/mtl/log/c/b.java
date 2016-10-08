package com.alibaba.mtl.log.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alibaba.mtl.log.e.i;
import java.util.concurrent.atomic.AtomicInteger;

class b
  implements a
{
  a a;
  String ab = "SELECT * FROM %s ORDER BY %s ASC LIMIT %d";
  String ac = "SELECT count(*) FROM %s";
  String ad = "DELETE FROM log where _id in ( select _id from log  ORDER BY _id ASC LIMIT %d )";
  
  protected b(Context paramContext)
  {
    this.a = new a(paramContext);
  }
  
  private void a(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    try
    {
      paramCursor.close();
      return;
    }
    catch (Throwable paramCursor) {}
  }
  
  /* Error */
  public int a(java.util.List<com.alibaba.mtl.log.model.a> paramList)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_0
    //   10: monitorenter
    //   11: iload 5
    //   13: istore 4
    //   15: aload_1
    //   16: ifnull +20 -> 36
    //   19: aload_1
    //   20: invokeinterface 55 1 0
    //   25: istore 4
    //   27: iload 4
    //   29: ifne +12 -> 41
    //   32: iload 5
    //   34: istore 4
    //   36: aload_0
    //   37: monitorexit
    //   38: iload 4
    //   40: ireturn
    //   41: aload_0
    //   42: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   45: invokevirtual 59	com/alibaba/mtl/log/c/b$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +251 -> 301
    //   53: aload_2
    //   54: invokevirtual 64	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   57: iconst_0
    //   58: istore 5
    //   60: iconst_0
    //   61: istore 4
    //   63: iload 5
    //   65: aload_1
    //   66: invokeinterface 55 1 0
    //   71: if_icmpge +148 -> 219
    //   74: aload_2
    //   75: ldc 66
    //   77: ldc 68
    //   79: iconst_1
    //   80: anewarray 70	java/lang/String
    //   83: dup
    //   84: iconst_0
    //   85: new 72	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   92: aload_1
    //   93: iload 5
    //   95: invokeinterface 77 2 0
    //   100: checkcast 79	com/alibaba/mtl/log/model/a
    //   103: getfield 83	com/alibaba/mtl/log/model/a:id	I
    //   106: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: ldc 89
    //   111: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: aastore
    //   118: invokevirtual 100	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   121: i2l
    //   122: lstore 7
    //   124: lload 7
    //   126: lconst_0
    //   127: lcmp
    //   128: ifgt +56 -> 184
    //   131: ldc 102
    //   133: iconst_4
    //   134: anewarray 4	java/lang/Object
    //   137: dup
    //   138: iconst_0
    //   139: ldc 104
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: aload_1
    //   145: iload 5
    //   147: invokeinterface 77 2 0
    //   152: checkcast 79	com/alibaba/mtl/log/model/a
    //   155: getfield 83	com/alibaba/mtl/log/model/a:id	I
    //   158: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: aastore
    //   162: dup
    //   163: iconst_2
    //   164: ldc 112
    //   166: aastore
    //   167: dup
    //   168: iconst_3
    //   169: lload 7
    //   171: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   174: aastore
    //   175: invokestatic 122	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: iconst_0
    //   179: istore 9
    //   181: goto +160 -> 341
    //   184: ldc 124
    //   186: aload_1
    //   187: iload 5
    //   189: invokeinterface 77 2 0
    //   194: checkcast 79	com/alibaba/mtl/log/model/a
    //   197: getfield 127	com/alibaba/mtl/log/model/a:U	Ljava/lang/String;
    //   200: invokevirtual 131	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   203: istore 10
    //   205: iload 10
    //   207: ifne +134 -> 341
    //   210: iload 4
    //   212: iconst_1
    //   213: iadd
    //   214: istore 4
    //   216: goto +125 -> 341
    //   219: aload_2
    //   220: invokevirtual 134	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   223: aload_2
    //   224: invokevirtual 137	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   227: aload_0
    //   228: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   231: aload_2
    //   232: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   235: ldc 102
    //   237: iconst_4
    //   238: anewarray 4	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: ldc -114
    //   245: aastore
    //   246: dup
    //   247: iconst_1
    //   248: aload_1
    //   249: invokeinterface 55 1 0
    //   254: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: dup
    //   259: iconst_2
    //   260: ldc -112
    //   262: aastore
    //   263: dup
    //   264: iconst_3
    //   265: iload 9
    //   267: invokestatic 149	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   270: aastore
    //   271: invokestatic 122	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: goto -238 -> 36
    //   277: astore_1
    //   278: aload_0
    //   279: monitorexit
    //   280: aload_1
    //   281: athrow
    //   282: astore_1
    //   283: aload_2
    //   284: invokevirtual 134	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   287: aload_2
    //   288: invokevirtual 137	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   291: aload_0
    //   292: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   295: aload_2
    //   296: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   299: aload_1
    //   300: athrow
    //   301: ldc 102
    //   303: iconst_1
    //   304: anewarray 4	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: ldc -105
    //   311: aastore
    //   312: invokestatic 122	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: iconst_0
    //   316: istore 9
    //   318: iload 6
    //   320: istore 4
    //   322: goto -87 -> 235
    //   325: astore_3
    //   326: goto -103 -> 223
    //   329: astore_3
    //   330: goto -103 -> 227
    //   333: astore_3
    //   334: goto -47 -> 287
    //   337: astore_3
    //   338: goto -47 -> 291
    //   341: iload 5
    //   343: iconst_1
    //   344: iadd
    //   345: istore 5
    //   347: goto -284 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	b
    //   0	350	1	paramList	java.util.List<com.alibaba.mtl.log.model.a>
    //   48	248	2	localSQLiteDatabase	SQLiteDatabase
    //   325	1	3	localThrowable1	Throwable
    //   329	1	3	localThrowable2	Throwable
    //   333	1	3	localThrowable3	Throwable
    //   337	1	3	localThrowable4	Throwable
    //   13	308	4	i	int
    //   7	339	5	j	int
    //   4	315	6	k	int
    //   122	48	7	l	long
    //   1	316	9	bool1	boolean
    //   203	3	10	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   19	27	277	finally
    //   41	49	277	finally
    //   219	223	277	finally
    //   223	227	277	finally
    //   227	235	277	finally
    //   235	274	277	finally
    //   283	287	277	finally
    //   287	291	277	finally
    //   291	301	277	finally
    //   301	315	277	finally
    //   53	57	282	finally
    //   63	124	282	finally
    //   131	178	282	finally
    //   184	205	282	finally
    //   219	223	325	java/lang/Throwable
    //   223	227	329	java/lang/Throwable
    //   283	287	333	java/lang/Throwable
    //   287	291	337	java/lang/Throwable
  }
  
  /* Error */
  public java.util.ArrayList<com.alibaba.mtl.log.model.a> a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: monitorenter
    //   6: iload_1
    //   7: ifgt +14 -> 21
    //   10: getstatic 160	java/util/Collections:EMPTY_LIST	Ljava/util/List;
    //   13: checkcast 162	java/util/ArrayList
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: areturn
    //   21: new 162	java/util/ArrayList
    //   24: dup
    //   25: iload_1
    //   26: invokespecial 165	java/util/ArrayList:<init>	(I)V
    //   29: astore 5
    //   31: aload_0
    //   32: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   35: invokevirtual 59	com/alibaba/mtl/log/c/b$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   38: astore 6
    //   40: aload 6
    //   42: ifnull +331 -> 373
    //   45: aload_0
    //   46: getfield 23	com/alibaba/mtl/log/c/b:ab	Ljava/lang/String;
    //   49: iconst_3
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: ldc 66
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: ldc -89
    //   62: aastore
    //   63: dup
    //   64: iconst_2
    //   65: iload_1
    //   66: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aastore
    //   70: invokestatic 171	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   73: astore 4
    //   75: aload 6
    //   77: aload 4
    //   79: aconst_null
    //   80: invokevirtual 175	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 4
    //   85: aload 4
    //   87: ifnull +243 -> 330
    //   90: aload 4
    //   92: astore_2
    //   93: aload 4
    //   95: astore_3
    //   96: aload 4
    //   98: invokeinterface 179 1 0
    //   103: ifeq +227 -> 330
    //   106: aload 4
    //   108: astore_2
    //   109: aload 4
    //   111: astore_3
    //   112: new 79	com/alibaba/mtl/log/model/a
    //   115: dup
    //   116: invokespecial 180	com/alibaba/mtl/log/model/a:<init>	()V
    //   119: astore 7
    //   121: aload 4
    //   123: astore_2
    //   124: aload 4
    //   126: astore_3
    //   127: aload 7
    //   129: aload 4
    //   131: aload 4
    //   133: ldc -74
    //   135: invokeinterface 186 2 0
    //   140: invokeinterface 190 2 0
    //   145: putfield 83	com/alibaba/mtl/log/model/a:id	I
    //   148: aload 4
    //   150: astore_2
    //   151: aload 4
    //   153: astore_3
    //   154: aload 7
    //   156: aload 4
    //   158: aload 4
    //   160: ldc -64
    //   162: invokeinterface 186 2 0
    //   167: invokeinterface 196 2 0
    //   172: putfield 127	com/alibaba/mtl/log/model/a:U	Ljava/lang/String;
    //   175: aload 4
    //   177: astore_2
    //   178: aload 4
    //   180: astore_3
    //   181: aload 7
    //   183: aload 4
    //   185: aload 4
    //   187: ldc -58
    //   189: invokeinterface 186 2 0
    //   194: invokeinterface 196 2 0
    //   199: putfield 201	com/alibaba/mtl/log/model/a:V	Ljava/lang/String;
    //   202: aload 4
    //   204: astore_2
    //   205: aload 4
    //   207: astore_3
    //   208: aload 7
    //   210: aload 4
    //   212: aload 4
    //   214: ldc -53
    //   216: invokeinterface 186 2 0
    //   221: invokeinterface 196 2 0
    //   226: invokevirtual 207	com/alibaba/mtl/log/model/a:n	(Ljava/lang/String;)V
    //   229: aload 4
    //   231: astore_2
    //   232: aload 4
    //   234: astore_3
    //   235: aload 7
    //   237: aload 4
    //   239: aload 4
    //   241: ldc -89
    //   243: invokeinterface 186 2 0
    //   248: invokeinterface 196 2 0
    //   253: putfield 210	com/alibaba/mtl/log/model/a:X	Ljava/lang/String;
    //   256: aload 4
    //   258: astore_3
    //   259: aload 7
    //   261: aload 4
    //   263: aload 4
    //   265: ldc -44
    //   267: invokeinterface 186 2 0
    //   272: invokeinterface 196 2 0
    //   277: putfield 215	com/alibaba/mtl/log/model/a:Y	Ljava/lang/String;
    //   280: aload 4
    //   282: astore_2
    //   283: aload 4
    //   285: astore_3
    //   286: aload 5
    //   288: aload 7
    //   290: invokevirtual 219	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   293: pop
    //   294: goto -209 -> 85
    //   297: astore 4
    //   299: aload_2
    //   300: astore_3
    //   301: ldc 102
    //   303: ldc -35
    //   305: aload 4
    //   307: invokestatic 224	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   310: aload_0
    //   311: aload_2
    //   312: invokespecial 48	com/alibaba/mtl/log/c/b:a	(Landroid/database/Cursor;)V
    //   315: aload_0
    //   316: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   319: aload 6
    //   321: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   324: aload 5
    //   326: astore_2
    //   327: goto -310 -> 17
    //   330: aload_0
    //   331: aload 4
    //   333: invokespecial 48	com/alibaba/mtl/log/c/b:a	(Landroid/database/Cursor;)V
    //   336: aload_0
    //   337: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   340: aload 6
    //   342: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   345: aload 5
    //   347: astore_2
    //   348: goto -331 -> 17
    //   351: astore_2
    //   352: aload_0
    //   353: monitorexit
    //   354: aload_2
    //   355: athrow
    //   356: astore_2
    //   357: aload_0
    //   358: aload_3
    //   359: invokespecial 48	com/alibaba/mtl/log/c/b:a	(Landroid/database/Cursor;)V
    //   362: aload_0
    //   363: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   366: aload 6
    //   368: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   371: aload_2
    //   372: athrow
    //   373: ldc 102
    //   375: iconst_1
    //   376: anewarray 4	java/lang/Object
    //   379: dup
    //   380: iconst_0
    //   381: ldc -105
    //   383: aastore
    //   384: invokestatic 122	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: aload 5
    //   389: astore_2
    //   390: goto -373 -> 17
    //   393: astore_2
    //   394: aconst_null
    //   395: astore_2
    //   396: goto -379 -> 17
    //   399: astore_2
    //   400: goto -120 -> 280
    //   403: astore_2
    //   404: aload 5
    //   406: astore_2
    //   407: goto -390 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	b
    //   0	410	1	paramInt	int
    //   3	345	2	localObject1	Object
    //   351	4	2	localObject2	Object
    //   356	16	2	localObject3	Object
    //   389	1	2	localObject4	Object
    //   393	1	2	localThrowable1	Throwable
    //   395	1	2	localObject5	Object
    //   399	1	2	localThrowable2	Throwable
    //   403	1	2	localThrowable3	Throwable
    //   406	1	2	localObject6	Object
    //   1	358	3	localObject7	Object
    //   73	211	4	localObject8	Object
    //   297	35	4	localThrowable4	Throwable
    //   29	376	5	localArrayList	java.util.ArrayList
    //   38	329	6	localSQLiteDatabase	SQLiteDatabase
    //   119	170	7	locala	com.alibaba.mtl.log.model.a
    // Exception table:
    //   from	to	target	type
    //   75	85	297	java/lang/Throwable
    //   96	106	297	java/lang/Throwable
    //   112	121	297	java/lang/Throwable
    //   127	148	297	java/lang/Throwable
    //   154	175	297	java/lang/Throwable
    //   181	202	297	java/lang/Throwable
    //   208	229	297	java/lang/Throwable
    //   235	256	297	java/lang/Throwable
    //   286	294	297	java/lang/Throwable
    //   10	17	351	finally
    //   21	31	351	finally
    //   31	40	351	finally
    //   45	75	351	finally
    //   310	324	351	finally
    //   330	345	351	finally
    //   357	373	351	finally
    //   373	387	351	finally
    //   75	85	356	finally
    //   96	106	356	finally
    //   112	121	356	finally
    //   127	148	356	finally
    //   154	175	356	finally
    //   181	202	356	finally
    //   208	229	356	finally
    //   235	256	356	finally
    //   259	280	356	finally
    //   286	294	356	finally
    //   301	310	356	finally
    //   10	17	393	java/lang/Throwable
    //   21	31	393	java/lang/Throwable
    //   259	280	399	java/lang/Throwable
    //   31	40	403	java/lang/Throwable
    //   45	75	403	java/lang/Throwable
    //   310	324	403	java/lang/Throwable
    //   330	345	403	java/lang/Throwable
    //   357	373	403	java/lang/Throwable
    //   373	387	403	java/lang/Throwable
  }
  
  /* Error */
  public boolean a(java.util.List<com.alibaba.mtl.log.model.a> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +16 -> 19
    //   6: aload_1
    //   7: invokeinterface 55 1 0
    //   12: istore 6
    //   14: iload 6
    //   16: ifne +11 -> 27
    //   19: iconst_1
    //   20: istore 9
    //   22: aload_0
    //   23: monitorexit
    //   24: iload 9
    //   26: ireturn
    //   27: aconst_null
    //   28: astore_3
    //   29: aload_0
    //   30: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   33: invokevirtual 59	com/alibaba/mtl/log/c/b$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +225 -> 263
    //   41: aload_2
    //   42: astore_3
    //   43: aload_2
    //   44: invokevirtual 64	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   47: iconst_0
    //   48: istore 6
    //   50: aload_2
    //   51: astore_3
    //   52: iload 6
    //   54: aload_1
    //   55: invokeinterface 55 1 0
    //   60: if_icmpge +345 -> 405
    //   63: aload_2
    //   64: astore_3
    //   65: aload_1
    //   66: iload 6
    //   68: invokeinterface 77 2 0
    //   73: checkcast 79	com/alibaba/mtl/log/model/a
    //   76: astore 4
    //   78: aload 4
    //   80: ifnull +174 -> 254
    //   83: aload_2
    //   84: astore_3
    //   85: new 231	android/content/ContentValues
    //   88: dup
    //   89: invokespecial 232	android/content/ContentValues:<init>	()V
    //   92: astore 5
    //   94: aload_2
    //   95: astore_3
    //   96: aload 5
    //   98: ldc -64
    //   100: aload 4
    //   102: getfield 127	com/alibaba/mtl/log/model/a:U	Ljava/lang/String;
    //   105: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_2
    //   109: astore_3
    //   110: aload 5
    //   112: ldc -58
    //   114: aload 4
    //   116: getfield 201	com/alibaba/mtl/log/model/a:V	Ljava/lang/String;
    //   119: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_2
    //   123: astore_3
    //   124: aload 5
    //   126: ldc -53
    //   128: aload 4
    //   130: invokevirtual 239	com/alibaba/mtl/log/model/a:i	()Ljava/lang/String;
    //   133: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_2
    //   137: astore_3
    //   138: aload 5
    //   140: ldc -89
    //   142: aload 4
    //   144: getfield 210	com/alibaba/mtl/log/model/a:X	Ljava/lang/String;
    //   147: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_2
    //   151: astore_3
    //   152: aload 5
    //   154: ldc -44
    //   156: aload 4
    //   158: getfield 215	com/alibaba/mtl/log/model/a:Y	Ljava/lang/String;
    //   161: invokevirtual 236	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload_2
    //   165: astore_3
    //   166: aload_2
    //   167: ldc 66
    //   169: ldc 89
    //   171: aload 5
    //   173: invokevirtual 243	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   176: lstore 7
    //   178: lload 7
    //   180: ldc2_w 244
    //   183: lcmp
    //   184: ifne +34 -> 218
    //   187: iconst_0
    //   188: istore 9
    //   190: aload_2
    //   191: ifnull +11 -> 202
    //   194: aload_2
    //   195: invokevirtual 134	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   198: aload_2
    //   199: invokevirtual 137	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   202: aload_0
    //   203: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   206: aload_2
    //   207: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   210: goto -188 -> 22
    //   213: astore_1
    //   214: aload_0
    //   215: monitorexit
    //   216: aload_1
    //   217: athrow
    //   218: aload_2
    //   219: astore_3
    //   220: ldc 102
    //   222: iconst_4
    //   223: anewarray 4	java/lang/Object
    //   226: dup
    //   227: iconst_0
    //   228: ldc -9
    //   230: aastore
    //   231: dup
    //   232: iconst_1
    //   233: aload 4
    //   235: getfield 215	com/alibaba/mtl/log/model/a:Y	Ljava/lang/String;
    //   238: aastore
    //   239: dup
    //   240: iconst_2
    //   241: ldc -112
    //   243: aastore
    //   244: dup
    //   245: iconst_3
    //   246: iconst_1
    //   247: invokestatic 149	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   250: aastore
    //   251: invokestatic 122	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: iload 6
    //   256: iconst_1
    //   257: iadd
    //   258: istore 6
    //   260: goto -210 -> 50
    //   263: aload_2
    //   264: astore_3
    //   265: ldc 102
    //   267: iconst_1
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: ldc -105
    //   275: aastore
    //   276: invokestatic 122	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: iconst_0
    //   280: istore 9
    //   282: goto -92 -> 190
    //   285: astore_2
    //   286: aconst_null
    //   287: astore_1
    //   288: iconst_0
    //   289: istore 9
    //   291: ldc 102
    //   293: ldc -7
    //   295: aload_2
    //   296: invokestatic 224	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   299: aload_2
    //   300: invokestatic 254	com/alibaba/mtl/appmonitor/b/b:a	(Ljava/lang/Throwable;)V
    //   303: aload_1
    //   304: ifnull +11 -> 315
    //   307: aload_1
    //   308: invokevirtual 134	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   311: aload_1
    //   312: invokevirtual 137	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   315: aload_0
    //   316: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   319: aload_1
    //   320: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   323: goto -301 -> 22
    //   326: astore_1
    //   327: aload_3
    //   328: ifnull +11 -> 339
    //   331: aload_3
    //   332: invokevirtual 134	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   335: aload_3
    //   336: invokevirtual 137	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   339: aload_0
    //   340: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   343: aload_3
    //   344: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   347: aload_1
    //   348: athrow
    //   349: astore_1
    //   350: goto -152 -> 198
    //   353: astore_1
    //   354: goto -152 -> 202
    //   357: astore_2
    //   358: goto -47 -> 311
    //   361: astore_2
    //   362: goto -47 -> 315
    //   365: astore_2
    //   366: goto -31 -> 335
    //   369: astore_2
    //   370: goto -31 -> 339
    //   373: astore_2
    //   374: aload_1
    //   375: astore_3
    //   376: aload_2
    //   377: astore_1
    //   378: goto -51 -> 327
    //   381: astore_3
    //   382: aload_2
    //   383: astore_1
    //   384: aload_3
    //   385: astore_2
    //   386: iconst_0
    //   387: istore 9
    //   389: goto -98 -> 291
    //   392: astore_1
    //   393: iconst_1
    //   394: istore 9
    //   396: aload_2
    //   397: astore_3
    //   398: aload_1
    //   399: astore_2
    //   400: aload_3
    //   401: astore_1
    //   402: goto -111 -> 291
    //   405: iconst_1
    //   406: istore 9
    //   408: goto -218 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	b
    //   0	411	1	paramList	java.util.List<com.alibaba.mtl.log.model.a>
    //   36	228	2	localSQLiteDatabase	SQLiteDatabase
    //   285	15	2	localThrowable1	Throwable
    //   357	1	2	localThrowable2	Throwable
    //   361	1	2	localThrowable3	Throwable
    //   365	1	2	localThrowable4	Throwable
    //   369	1	2	localThrowable5	Throwable
    //   373	10	2	localObject1	Object
    //   385	15	2	localObject2	Object
    //   28	348	3	localObject3	Object
    //   381	4	3	localThrowable6	Throwable
    //   397	4	3	localObject4	Object
    //   76	158	4	locala	com.alibaba.mtl.log.model.a
    //   92	80	5	localContentValues	android.content.ContentValues
    //   12	247	6	i	int
    //   176	3	7	l	long
    //   20	387	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	14	213	finally
    //   194	198	213	finally
    //   198	202	213	finally
    //   202	210	213	finally
    //   307	311	213	finally
    //   311	315	213	finally
    //   315	323	213	finally
    //   331	335	213	finally
    //   335	339	213	finally
    //   339	349	213	finally
    //   29	37	285	java/lang/Throwable
    //   29	37	326	finally
    //   43	47	326	finally
    //   52	63	326	finally
    //   65	78	326	finally
    //   85	94	326	finally
    //   96	108	326	finally
    //   110	122	326	finally
    //   124	136	326	finally
    //   138	150	326	finally
    //   152	164	326	finally
    //   166	178	326	finally
    //   220	254	326	finally
    //   265	279	326	finally
    //   194	198	349	java/lang/Throwable
    //   198	202	353	java/lang/Throwable
    //   307	311	357	java/lang/Throwable
    //   311	315	361	java/lang/Throwable
    //   331	335	365	java/lang/Throwable
    //   335	339	369	java/lang/Throwable
    //   291	303	373	finally
    //   43	47	381	java/lang/Throwable
    //   265	279	381	java/lang/Throwable
    //   52	63	392	java/lang/Throwable
    //   65	78	392	java/lang/Throwable
    //   85	94	392	java/lang/Throwable
    //   96	108	392	java/lang/Throwable
    //   110	122	392	java/lang/Throwable
    //   124	136	392	java/lang/Throwable
    //   138	150	392	java/lang/Throwable
    //   152	164	392	java/lang/Throwable
    //   166	178	392	java/lang/Throwable
    //   220	254	392	java/lang/Throwable
  }
  
  /* Error */
  public void c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   6: invokevirtual 59	com/alibaba/mtl/log/c/b$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +80 -> 91
    //   14: aload_3
    //   15: ldc 66
    //   17: new 72	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   24: aload_1
    //   25: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 258
    //   31: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: iconst_1
    //   38: anewarray 70	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: aload_2
    //   44: invokestatic 261	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   47: aastore
    //   48: invokevirtual 100	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   51: pop
    //   52: aload_0
    //   53: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   56: aload_3
    //   57: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   68: aload_3
    //   69: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   72: goto -12 -> 60
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    //   80: astore_1
    //   81: aload_0
    //   82: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   85: aload_3
    //   86: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   89: aload_1
    //   90: athrow
    //   91: ldc 102
    //   93: iconst_1
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: ldc -105
    //   101: aastore
    //   102: invokestatic 122	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: goto -45 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	b
    //   0	108	1	paramString1	String
    //   0	108	2	paramString2	String
    //   9	77	3	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   14	52	63	java/lang/Throwable
    //   2	10	75	finally
    //   52	60	75	finally
    //   64	72	75	finally
    //   81	91	75	finally
    //   91	105	75	finally
    //   14	52	80	finally
  }
  
  public void clear()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
      if (localSQLiteDatabase != null)
      {
        localSQLiteDatabase.delete("log", null, null);
        this.a.a(localSQLiteDatabase);
      }
      return;
    }
    finally {}
  }
  
  public void e(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    if (localSQLiteDatabase != null) {
      try
      {
        localSQLiteDatabase.execSQL(String.format(this.ad, new Object[] { Integer.valueOf(paramInt) }));
        this.a.a(localSQLiteDatabase);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable = localThrowable;
        this.a.a(localSQLiteDatabase);
        return;
      }
      finally
      {
        localObject = finally;
        this.a.a(localSQLiteDatabase);
        throw ((Throwable)localObject);
      }
    }
    i.a("UTSqliteLogStore", new Object[] { "db is null" });
  }
  
  /* Error */
  public int g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: iconst_0
    //   5: istore 6
    //   7: iconst_0
    //   8: istore 5
    //   10: aload_0
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   16: invokevirtual 59	com/alibaba/mtl/log/c/b$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnull +117 -> 140
    //   26: aload 4
    //   28: aload_0
    //   29: getfield 27	com/alibaba/mtl/log/c/b:ac	Ljava/lang/String;
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc 66
    //   40: aastore
    //   41: invokestatic 171	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   44: aconst_null
    //   45: invokevirtual 175	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +27 -> 77
    //   53: aload_3
    //   54: astore_1
    //   55: aload_3
    //   56: astore_2
    //   57: aload_3
    //   58: invokeinterface 270 1 0
    //   63: pop
    //   64: aload_3
    //   65: astore_1
    //   66: aload_3
    //   67: astore_2
    //   68: aload_3
    //   69: iconst_0
    //   70: invokeinterface 190 2 0
    //   75: istore 5
    //   77: aload_0
    //   78: aload_3
    //   79: invokespecial 48	com/alibaba/mtl/log/c/b:a	(Landroid/database/Cursor;)V
    //   82: aload_0
    //   83: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   86: aload 4
    //   88: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: iload 5
    //   95: ireturn
    //   96: astore_2
    //   97: aload_0
    //   98: aload_1
    //   99: invokespecial 48	com/alibaba/mtl/log/c/b:a	(Landroid/database/Cursor;)V
    //   102: aload_0
    //   103: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   106: aload 4
    //   108: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   111: iload 6
    //   113: istore 5
    //   115: goto -24 -> 91
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: aload_0
    //   125: aload_2
    //   126: invokespecial 48	com/alibaba/mtl/log/c/b:a	(Landroid/database/Cursor;)V
    //   129: aload_0
    //   130: getfield 36	com/alibaba/mtl/log/c/b:a	Lcom/alibaba/mtl/log/c/b$a;
    //   133: aload 4
    //   135: invokevirtual 140	com/alibaba/mtl/log/c/b$a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   138: aload_1
    //   139: athrow
    //   140: ldc 102
    //   142: iconst_1
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: ldc -105
    //   150: aastore
    //   151: invokestatic 122	com/alibaba/mtl/log/e/i:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: iload 6
    //   156: istore 5
    //   158: goto -67 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	b
    //   3	96	1	localObject1	Object
    //   118	4	1	localObject2	Object
    //   123	16	1	localObject3	Object
    //   1	67	2	localObject4	Object
    //   96	30	2	localThrowable	Throwable
    //   48	31	3	localCursor	Cursor
    //   19	115	4	localSQLiteDatabase	SQLiteDatabase
    //   8	149	5	i	int
    //   5	150	6	j	int
    // Exception table:
    //   from	to	target	type
    //   26	49	96	java/lang/Throwable
    //   57	64	96	java/lang/Throwable
    //   68	77	96	java/lang/Throwable
    //   12	21	118	finally
    //   77	91	118	finally
    //   97	111	118	finally
    //   124	140	118	finally
    //   140	154	118	finally
    //   26	49	123	finally
    //   57	64	123	finally
    //   68	77	123	finally
  }
  
  class a
    extends SQLiteOpenHelper
  {
    private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
    private AtomicInteger e = new AtomicInteger();
    
    a(Context paramContext)
    {
      super("ut.db", null, 2);
    }
    
    /* Error */
    public void a(SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: ifnonnull +6 -> 9
      //   6: aload_0
      //   7: monitorexit
      //   8: return
      //   9: aload_0
      //   10: getfield 27	com/alibaba/mtl/log/c/b$a:e	Ljava/util/concurrent/atomic/AtomicInteger;
      //   13: invokevirtual 35	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
      //   16: ifne -10 -> 6
      //   19: aload_0
      //   20: getfield 37	com/alibaba/mtl/log/c/b$a:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
      //   23: ifnull -17 -> 6
      //   26: aload_0
      //   27: getfield 37	com/alibaba/mtl/log/c/b$a:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
      //   30: invokevirtual 42	android/database/sqlite/SQLiteDatabase:close	()V
      //   33: aload_0
      //   34: aconst_null
      //   35: putfield 37	com/alibaba/mtl/log/c/b$a:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
      //   38: goto -32 -> 6
      //   41: astore_1
      //   42: goto -36 -> 6
      //   45: astore_1
      //   46: aload_0
      //   47: monitorexit
      //   48: aload_1
      //   49: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	50	0	this	a
      //   0	50	1	paramSQLiteDatabase	SQLiteDatabase
      // Exception table:
      //   from	to	target	type
      //   9	38	41	java/lang/Throwable
      //   9	38	45	finally
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      try
      {
        if (this.e.incrementAndGet() == 1) {
          this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = super.getWritableDatabase();
        }
        SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
        return localSQLiteDatabase;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          i.a("TAG", "e", localThrowable);
          com.alibaba.mtl.appmonitor.b.b.a(localThrowable);
        }
      }
      finally {}
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS log (_id INTEGER PRIMARY KEY AUTOINCREMENT, eventId TEXT,priority TEXT, streamId TEXT, time TEXT, content TEXT, _index TEXT )");
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        Cursor localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=DELETE", null);
        b.a(b.this, localCursor);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable = localThrowable;
          b.a(b.this, null);
        }
      }
      finally
      {
        paramSQLiteDatabase = finally;
        b.a(b.this, null);
        throw paramSQLiteDatabase;
      }
      super.onOpen(paramSQLiteDatabase);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      if ((paramInt1 == 1) && (paramInt2 == 2)) {}
      try
      {
        paramSQLiteDatabase.execSQL("ALTER TABLE log ADD COLUMN _index TEXT ");
        return;
      }
      catch (Throwable paramSQLiteDatabase)
      {
        i.a("UTSqliteLogStore", "DB Upgrade Error", paramSQLiteDatabase);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */