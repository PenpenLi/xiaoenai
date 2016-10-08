package d.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.Map;

public class a
{
  private static ContentValues a(cl paramcl)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramcl.a());
    localContentValues.put("label", paramcl.b());
    localContentValues.put("count", Long.valueOf(paramcl.f()));
    localContentValues.put("value", Long.valueOf(paramcl.e()));
    localContentValues.put("totalTimestamp", Long.valueOf(paramcl.d()));
    localContentValues.put("timeWindowNum", paramcl.g());
    return localContentValues;
  }
  
  /* Error */
  public static String a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 67	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   4: aload_0
    //   5: ldc 69
    //   7: invokestatic 72	d/a/a:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   10: ifgt +24 -> 34
    //   13: iconst_0
    //   14: ifeq +11 -> 25
    //   17: new 74	java/lang/NullPointerException
    //   20: dup
    //   21: invokespecial 75	java/lang/NullPointerException:<init>	()V
    //   24: athrow
    //   25: aload_0
    //   26: invokevirtual 78	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   29: iconst_0
    //   30: invokestatic 83	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   33: areturn
    //   34: aload_0
    //   35: ldc 85
    //   37: aconst_null
    //   38: invokevirtual 89	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore_1
    //   42: aload_1
    //   43: astore_2
    //   44: aload_1
    //   45: invokeinterface 95 1 0
    //   50: ifeq +127 -> 177
    //   53: aload_1
    //   54: astore_2
    //   55: aload_1
    //   56: aload_1
    //   57: ldc 55
    //   59: invokeinterface 99 2 0
    //   64: invokeinterface 102 2 0
    //   69: astore_3
    //   70: aload_1
    //   71: astore_2
    //   72: aload_0
    //   73: invokevirtual 105	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   76: aload_1
    //   77: ifnull +9 -> 86
    //   80: aload_1
    //   81: invokeinterface 108 1 0
    //   86: aload_0
    //   87: invokevirtual 78	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   90: aload_3
    //   91: areturn
    //   92: astore 4
    //   94: aconst_null
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_1
    //   99: astore_2
    //   100: new 110	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   107: ldc 113
    //   109: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 4
    //   114: invokevirtual 120	android/database/SQLException:toString	()Ljava/lang/String;
    //   117: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 126	d/a/ax:d	(Ljava/lang/String;)V
    //   126: aload_1
    //   127: ifnull +9 -> 136
    //   130: aload_1
    //   131: invokeinterface 108 1 0
    //   136: aload_0
    //   137: invokevirtual 78	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   140: aload_3
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 108 1 0
    //   155: aload_0
    //   156: invokevirtual 78	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_1
    //   162: goto -17 -> 145
    //   165: astore 4
    //   167: aconst_null
    //   168: astore_3
    //   169: goto -71 -> 98
    //   172: astore 4
    //   174: goto -76 -> 98
    //   177: aconst_null
    //   178: astore_3
    //   179: goto -109 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramSQLiteDatabase	SQLiteDatabase
    //   41	90	1	localCursor1	Cursor
    //   142	18	1	localObject1	Object
    //   161	1	1	localObject2	Object
    //   43	107	2	localCursor2	Cursor
    //   69	110	3	str	String
    //   92	21	4	localSQLException1	SQLException
    //   165	1	4	localSQLException2	SQLException
    //   172	1	4	localSQLException3	SQLException
    // Exception table:
    //   from	to	target	type
    //   0	13	92	android/database/SQLException
    //   34	42	92	android/database/SQLException
    //   0	13	142	finally
    //   34	42	142	finally
    //   44	53	161	finally
    //   55	70	161	finally
    //   72	76	161	finally
    //   100	126	161	finally
    //   44	53	165	android/database/SQLException
    //   55	70	165	android/database/SQLException
    //   72	76	172	android/database/SQLException
  }
  
  /* Error */
  public static Map<String, java.util.List<z.e>> a(cj paramcj, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: new 129	java/util/HashMap
    //   3: dup
    //   4: invokespecial 130	java/util/HashMap:<init>	()V
    //   7: astore 4
    //   9: aload_1
    //   10: ldc -124
    //   12: invokestatic 72	d/a/a:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   15: ifle +262 -> 277
    //   18: aload_1
    //   19: ldc -122
    //   21: aconst_null
    //   22: invokevirtual 89	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_1
    //   26: aload_1
    //   27: astore_2
    //   28: aload_1
    //   29: invokeinterface 137 1 0
    //   34: ifeq +218 -> 252
    //   37: aload_1
    //   38: astore_2
    //   39: aload_1
    //   40: aload_1
    //   41: ldc 14
    //   43: invokeinterface 99 2 0
    //   48: invokeinterface 102 2 0
    //   53: astore 5
    //   55: aload_1
    //   56: astore_2
    //   57: aload 4
    //   59: aload 5
    //   61: invokeinterface 143 2 0
    //   66: ifeq +160 -> 226
    //   69: aload_1
    //   70: astore_2
    //   71: aload 4
    //   73: aload 5
    //   75: invokeinterface 147 2 0
    //   80: checkcast 149	java/util/List
    //   83: astore_3
    //   84: aload_1
    //   85: astore_2
    //   86: aload 4
    //   88: aload 5
    //   90: invokeinterface 152 2 0
    //   95: pop
    //   96: aload_1
    //   97: astore_2
    //   98: new 154	d/a/z$e
    //   101: dup
    //   102: invokespecial 155	d/a/z$e:<init>	()V
    //   105: astore 6
    //   107: aload_1
    //   108: astore_2
    //   109: aload 6
    //   111: aload_1
    //   112: aload_1
    //   113: ldc -99
    //   115: invokeinterface 99 2 0
    //   120: invokeinterface 161 2 0
    //   125: putfield 164	d/a/z$e:b	J
    //   128: aload_1
    //   129: astore_2
    //   130: aload 6
    //   132: aload_1
    //   133: aload_1
    //   134: ldc 30
    //   136: invokeinterface 99 2 0
    //   141: invokeinterface 161 2 0
    //   146: l2i
    //   147: putfield 167	d/a/z$e:a	I
    //   150: aload_1
    //   151: astore_2
    //   152: aload_3
    //   153: aload 6
    //   155: invokeinterface 170 2 0
    //   160: pop
    //   161: aload_1
    //   162: astore_2
    //   163: aload 4
    //   165: aload 5
    //   167: aload_3
    //   168: invokeinterface 173 3 0
    //   173: pop
    //   174: goto -148 -> 26
    //   177: astore_3
    //   178: aload_1
    //   179: astore_2
    //   180: aload_0
    //   181: ldc -81
    //   183: iconst_0
    //   184: invokevirtual 180	d/a/cj:a	(Ljava/lang/Object;Z)V
    //   187: aload_1
    //   188: astore_2
    //   189: new 110	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   196: ldc -74
    //   198: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_3
    //   202: invokevirtual 120	android/database/SQLException:toString	()Ljava/lang/String;
    //   205: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 126	d/a/ax:d	(Ljava/lang/String;)V
    //   214: aload_1
    //   215: ifnull +9 -> 224
    //   218: aload_1
    //   219: invokeinterface 108 1 0
    //   224: aconst_null
    //   225: areturn
    //   226: aload_1
    //   227: astore_2
    //   228: new 184	java/util/ArrayList
    //   231: dup
    //   232: invokespecial 185	java/util/ArrayList:<init>	()V
    //   235: astore_3
    //   236: goto -140 -> 96
    //   239: astore_0
    //   240: aload_2
    //   241: ifnull +9 -> 250
    //   244: aload_2
    //   245: invokeinterface 108 1 0
    //   250: aload_0
    //   251: athrow
    //   252: aload_1
    //   253: ifnull +9 -> 262
    //   256: aload_1
    //   257: invokeinterface 108 1 0
    //   262: aload 4
    //   264: areturn
    //   265: astore_0
    //   266: aconst_null
    //   267: astore_2
    //   268: goto -28 -> 240
    //   271: astore_3
    //   272: aconst_null
    //   273: astore_1
    //   274: goto -96 -> 178
    //   277: aconst_null
    //   278: astore_1
    //   279: goto -27 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramcj	cj
    //   0	282	1	paramSQLiteDatabase	SQLiteDatabase
    //   27	241	2	localSQLiteDatabase	SQLiteDatabase
    //   83	85	3	localList	java.util.List
    //   177	25	3	localSQLException1	SQLException
    //   235	1	3	localArrayList	java.util.ArrayList
    //   271	1	3	localSQLException2	SQLException
    //   7	256	4	localHashMap	java.util.HashMap
    //   53	113	5	str	String
    //   105	49	6	locale	z.e
    // Exception table:
    //   from	to	target	type
    //   28	37	177	android/database/SQLException
    //   39	55	177	android/database/SQLException
    //   57	69	177	android/database/SQLException
    //   71	84	177	android/database/SQLException
    //   86	96	177	android/database/SQLException
    //   98	107	177	android/database/SQLException
    //   109	128	177	android/database/SQLException
    //   130	150	177	android/database/SQLException
    //   152	161	177	android/database/SQLException
    //   163	174	177	android/database/SQLException
    //   228	236	177	android/database/SQLException
    //   28	37	239	finally
    //   39	55	239	finally
    //   57	69	239	finally
    //   71	84	239	finally
    //   86	96	239	finally
    //   98	107	239	finally
    //   109	128	239	finally
    //   130	150	239	finally
    //   152	161	239	finally
    //   163	174	239	finally
    //   180	187	239	finally
    //   189	214	239	finally
    //   228	236	239	finally
    //   0	26	265	finally
    //   0	26	271	android/database/SQLException
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      int i = b(paramSQLiteDatabase, "system");
      int j = cy.a().c();
      if (i < j)
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("key", paramString);
        localContentValues.put("timeStamp", Long.valueOf(paramLong2));
        localContentValues.put("count", Long.valueOf(paramLong1));
        paramSQLiteDatabase.insert("system", null, localContentValues);
        return;
      }
      if (i == j)
      {
        paramString = new ContentValues();
        paramString.put("key", "__meta_ve_of");
        paramString.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        paramString.put("count", Integer.valueOf(1));
        paramSQLiteDatabase.insert("system", null, paramString);
        return;
      }
      c(paramSQLiteDatabase, "__meta_ve_of");
      return;
    }
    catch (SQLException paramSQLiteDatabase) {}
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, Map<String, cm> paramMap, cj paramcj)
  {
    i = 0;
    localContentValues = null;
    Object localObject3 = null;
    localObject2 = localObject3;
    localObject1 = localContentValues;
    try
    {
      localcm = (cm)paramMap.get("__ag_of");
      if (localcm != null) {
        break label47;
      }
      if (0 != 0) {
        throw new NullPointerException();
      }
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cm localcm;
      long l1;
      localObject1 = localObject2;
      ax.d("save to system table error " + paramSQLiteDatabase.toString());
      return;
      localObject2 = paramMap;
      localObject1 = paramMap;
      localContentValues = new ContentValues();
      localObject2 = paramMap;
      localObject1 = paramMap;
      localContentValues.put("key", localcm.a());
      if (i != 0) {
        break label394;
      }
      localObject2 = paramMap;
      localObject1 = paramMap;
      long l3;
      for (long l2 = localcm.c();; l2 = l3 + l2)
      {
        localObject2 = paramMap;
        localObject1 = paramMap;
        localContentValues.put("count", Long.valueOf(l2));
        l2 = l1;
        if (l1 == 0L)
        {
          localObject2 = paramMap;
          localObject1 = paramMap;
          l2 = localcm.b();
        }
        localObject2 = paramMap;
        localObject1 = paramMap;
        localContentValues.put("timeStamp", Long.valueOf(l2));
        localObject2 = paramMap;
        localObject1 = paramMap;
        paramSQLiteDatabase.insert("system", null, localContentValues);
        localObject2 = paramMap;
        localObject1 = paramMap;
        paramcj.a("success", false);
        if (paramMap == null) {
          break;
        }
        paramMap.close();
        return;
        l3 = i;
        localObject2 = paramMap;
        localObject1 = paramMap;
        l2 = localcm.c();
      }
    }
    finally
    {
      if (localObject1 == null) {
        break label432;
      }
      ((Cursor)localObject1).close();
    }
    return;
    label47:
    localObject2 = localObject3;
    localObject1 = localContentValues;
    paramMap = paramSQLiteDatabase.rawQuery("select * from " + "system where key=\"__ag_of\"", null);
    localObject2 = paramMap;
    localObject1 = paramMap;
    paramMap.moveToFirst();
    l1 = 0L;
    for (;;)
    {
      localObject2 = paramMap;
      localObject1 = paramMap;
      if (paramMap.isAfterLast()) {
        break;
      }
      localObject2 = paramMap;
      localObject1 = paramMap;
      if (paramMap.getCount() > 0)
      {
        localObject2 = paramMap;
        localObject1 = paramMap;
        i = paramMap.getInt(paramMap.getColumnIndex("count"));
        localObject2 = paramMap;
        localObject1 = paramMap;
        l1 = paramMap.getLong(paramMap.getColumnIndex("timeStamp"));
        localObject2 = paramMap;
        localObject1 = paramMap;
        paramSQLiteDatabase.execSQL("delete from " + "system where key=\"__ag_of\"");
      }
      localObject2 = paramMap;
      localObject1 = paramMap;
      paramMap.moveToNext();
    }
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean, cj paramcj)
  {
    a(paramSQLiteDatabase, "system");
    a(paramSQLiteDatabase, "aggregated");
    if (!paramBoolean)
    {
      a(paramSQLiteDatabase, "limitedck");
      paramcj.a("success", false);
    }
  }
  
  /* Error */
  public static void a(cj paramcj, SQLiteDatabase paramSQLiteDatabase, java.util.List<String> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 67	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   4: aload_1
    //   5: ldc_w 264
    //   8: invokestatic 72	d/a/a:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   11: ifle +11 -> 22
    //   14: aload_1
    //   15: ldc_w 264
    //   18: invokestatic 260	d/a/a:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   21: pop
    //   22: aload_2
    //   23: invokeinterface 269 1 0
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface 274 1 0
    //   35: ifeq +77 -> 112
    //   38: aload_2
    //   39: invokeinterface 278 1 0
    //   44: checkcast 80	java/lang/String
    //   47: astore_3
    //   48: new 8	android/content/ContentValues
    //   51: dup
    //   52: invokespecial 12	android/content/ContentValues:<init>	()V
    //   55: astore 4
    //   57: aload 4
    //   59: ldc_w 280
    //   62: aload_3
    //   63: invokevirtual 23	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_1
    //   67: ldc_w 264
    //   70: aconst_null
    //   71: aload 4
    //   73: invokevirtual 201	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   76: pop2
    //   77: goto -48 -> 29
    //   80: astore_0
    //   81: new 110	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 282
    //   91: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: invokevirtual 120	android/database/SQLException:toString	()Ljava/lang/String;
    //   98: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 126	d/a/ax:d	(Ljava/lang/String;)V
    //   107: aload_1
    //   108: invokevirtual 78	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   111: return
    //   112: aload_1
    //   113: invokevirtual 105	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   116: aload_0
    //   117: ldc -1
    //   119: iconst_0
    //   120: invokevirtual 180	d/a/cj:a	(Ljava/lang/Object;Z)V
    //   123: aload_1
    //   124: invokevirtual 78	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   127: return
    //   128: astore_0
    //   129: aload_1
    //   130: invokevirtual 78	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   133: aload_0
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramcj	cj
    //   0	135	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	135	2	paramList	java.util.List<String>
    //   47	16	3	str	String
    //   55	17	4	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   0	22	80	android/database/SQLException
    //   22	29	80	android/database/SQLException
    //   29	77	80	android/database/SQLException
    //   112	123	80	android/database/SQLException
    //   0	22	128	finally
    //   22	29	128	finally
    //   29	77	128	finally
    //   81	107	128	finally
    //   112	123	128	finally
  }
  
  public static boolean a(SQLiteDatabase paramSQLiteDatabase, cj paramcj)
  {
    try
    {
      paramSQLiteDatabase.beginTransaction();
      if (b(paramSQLiteDatabase, "aggregated_cache") <= 0)
      {
        paramcj.a("faild", false);
        return false;
      }
      paramSQLiteDatabase.execSQL("insert into aggregated(key, count, value, totalTimestamp, timeWindowNum, label) select key, count, value, totalTimestamp, timeWindowNum, label from aggregated_cache");
      paramSQLiteDatabase.setTransactionSuccessful();
      a(paramSQLiteDatabase, "aggregated_cache");
      paramcj.a("success", false);
      return true;
    }
    catch (SQLException localSQLException)
    {
      paramcj.a(Boolean.valueOf(false), false);
      ax.d("cacheToAggregatedTable happen " + localSQLException.toString());
      return false;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public static boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      if (b(paramSQLiteDatabase, paramString) >= 0) {
        paramSQLiteDatabase.execSQL("delete from " + paramString);
      }
      return true;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      ax.d("cleanTableData faild!" + paramSQLiteDatabase.toString());
    }
    return false;
  }
  
  /* Error */
  public static boolean a(SQLiteDatabase paramSQLiteDatabase, java.util.Collection<cl> paramCollection)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 67	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   4: aload_0
    //   5: ldc 69
    //   7: invokestatic 72	d/a/a:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   10: ifle +10 -> 20
    //   13: aload_0
    //   14: ldc 69
    //   16: invokestatic 260	d/a/a:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   19: pop
    //   20: aload_1
    //   21: invokeinterface 299 1 0
    //   26: astore_1
    //   27: aload_1
    //   28: invokeinterface 274 1 0
    //   33: ifeq +39 -> 72
    //   36: aload_0
    //   37: ldc 69
    //   39: aconst_null
    //   40: aload_1
    //   41: invokeinterface 278 1 0
    //   46: checkcast 16	d/a/cl
    //   49: invokestatic 301	d/a/a:a	(Ld/a/cl;)Landroid/content/ContentValues;
    //   52: invokevirtual 201	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   55: pop2
    //   56: goto -29 -> 27
    //   59: astore_1
    //   60: ldc_w 303
    //   63: invokestatic 126	d/a/ax:d	(Ljava/lang/String;)V
    //   66: aload_0
    //   67: invokevirtual 78	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   70: iconst_0
    //   71: ireturn
    //   72: aload_0
    //   73: invokevirtual 105	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   76: aload_0
    //   77: invokevirtual 78	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   80: iconst_1
    //   81: ireturn
    //   82: astore_1
    //   83: aload_0
    //   84: invokevirtual 78	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	89	1	paramCollection	java.util.Collection<cl>
    // Exception table:
    //   from	to	target	type
    //   0	20	59	android/database/SQLException
    //   20	27	59	android/database/SQLException
    //   27	56	59	android/database/SQLException
    //   72	76	59	android/database/SQLException
    //   0	20	82	finally
    //   20	27	82	finally
    //   27	56	82	finally
    //   60	66	82	finally
    //   72	76	82	finally
  }
  
  /* Error */
  public static boolean a(cj paramcj, SQLiteDatabase paramSQLiteDatabase, java.util.Collection<cl> paramCollection)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 67	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   4: aload_2
    //   5: invokeinterface 299 1 0
    //   10: astore_2
    //   11: aload_2
    //   12: invokeinterface 274 1 0
    //   17: ifeq +40 -> 57
    //   20: aload_1
    //   21: ldc_w 262
    //   24: aconst_null
    //   25: aload_2
    //   26: invokeinterface 278 1 0
    //   31: checkcast 16	d/a/cl
    //   34: invokestatic 301	d/a/a:a	(Ld/a/cl;)Landroid/content/ContentValues;
    //   37: invokevirtual 201	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   40: pop2
    //   41: goto -30 -> 11
    //   44: astore_0
    //   45: ldc_w 303
    //   48: invokestatic 126	d/a/ax:d	(Ljava/lang/String;)V
    //   51: aload_1
    //   52: invokevirtual 78	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   55: iconst_0
    //   56: ireturn
    //   57: aload_1
    //   58: invokevirtual 105	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   61: aload_1
    //   62: ldc 69
    //   64: invokestatic 260	d/a/a:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   67: pop
    //   68: aload_0
    //   69: ldc -1
    //   71: iconst_0
    //   72: invokevirtual 180	d/a/cj:a	(Ljava/lang/Object;Z)V
    //   75: aload_1
    //   76: invokevirtual 78	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   79: iconst_1
    //   80: ireturn
    //   81: astore_0
    //   82: aload_1
    //   83: invokevirtual 78	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   86: aload_0
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramcj	cj
    //   0	88	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	88	2	paramCollection	java.util.Collection<cl>
    // Exception table:
    //   from	to	target	type
    //   0	11	44	android/database/SQLException
    //   11	41	44	android/database/SQLException
    //   57	75	44	android/database/SQLException
    //   0	11	81	finally
    //   11	41	81	finally
    //   45	51	81	finally
    //   57	75	81	finally
  }
  
  public static int b(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    localObject = null;
    localSQLiteDatabase = null;
    int j = 0;
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select * from " + paramString, null);
      localSQLiteDatabase = paramSQLiteDatabase;
      localObject = paramSQLiteDatabase;
      int i = paramSQLiteDatabase.getCount();
      j = i;
      if (paramSQLiteDatabase != null)
      {
        paramSQLiteDatabase.close();
        j = i;
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      do
      {
        localObject = localSQLiteDatabase;
        ax.d("count error " + paramSQLiteDatabase.toString());
      } while (localSQLiteDatabase == null);
      localSQLiteDatabase.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label117;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  /* Error */
  public static Map<String, java.util.List<z.d>> b(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 262
    //   4: invokestatic 72	d/a/a:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   7: ifle +284 -> 291
    //   10: aload_0
    //   11: ldc_w 314
    //   14: aconst_null
    //   15: invokevirtual 89	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore_0
    //   19: new 129	java/util/HashMap
    //   22: dup
    //   23: invokespecial 130	java/util/HashMap:<init>	()V
    //   26: astore_2
    //   27: aload_0
    //   28: invokeinterface 137 1 0
    //   33: ifeq +246 -> 279
    //   36: aload_0
    //   37: aload_0
    //   38: ldc 14
    //   40: invokeinterface 99 2 0
    //   45: invokeinterface 102 2 0
    //   50: astore_3
    //   51: aload_2
    //   52: aload_3
    //   53: invokeinterface 143 2 0
    //   58: ifeq +193 -> 251
    //   61: aload_2
    //   62: aload_3
    //   63: invokeinterface 147 2 0
    //   68: checkcast 149	java/util/List
    //   71: astore_1
    //   72: aload_2
    //   73: aload_3
    //   74: invokeinterface 152 2 0
    //   79: pop
    //   80: new 316	d/a/z$d
    //   83: dup
    //   84: invokespecial 317	d/a/z$d:<init>	()V
    //   87: astore 4
    //   89: aload 4
    //   91: aload_0
    //   92: aload_0
    //   93: ldc 25
    //   95: invokeinterface 99 2 0
    //   100: invokeinterface 102 2 0
    //   105: invokestatic 322	d/a/cd:a	(Ljava/lang/String;)Ljava/util/List;
    //   108: putfield 325	d/a/z$d:e	Ljava/util/List;
    //   111: aload 4
    //   113: aload_0
    //   114: aload_0
    //   115: ldc 45
    //   117: invokeinterface 99 2 0
    //   122: invokeinterface 161 2 0
    //   127: putfield 327	d/a/z$d:a	J
    //   130: aload 4
    //   132: aload_0
    //   133: aload_0
    //   134: ldc 50
    //   136: invokeinterface 99 2 0
    //   141: invokeinterface 161 2 0
    //   146: putfield 328	d/a/z$d:b	J
    //   149: aload 4
    //   151: aload_0
    //   152: aload_0
    //   153: ldc 55
    //   155: invokeinterface 99 2 0
    //   160: invokeinterface 102 2 0
    //   165: invokestatic 331	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   168: putfield 333	d/a/z$d:c	I
    //   171: aload 4
    //   173: aload_0
    //   174: aload_0
    //   175: ldc 30
    //   177: invokeinterface 99 2 0
    //   182: invokeinterface 161 2 0
    //   187: l2i
    //   188: putfield 335	d/a/z$d:d	I
    //   191: aload_1
    //   192: aload 4
    //   194: invokeinterface 170 2 0
    //   199: pop
    //   200: aload_2
    //   201: aload_3
    //   202: aload_1
    //   203: invokeinterface 173 3 0
    //   208: pop
    //   209: goto -182 -> 27
    //   212: astore_1
    //   213: new 110	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 337
    //   223: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_1
    //   227: invokevirtual 120	android/database/SQLException:toString	()Ljava/lang/String;
    //   230: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 126	d/a/ax:d	(Ljava/lang/String;)V
    //   239: aload_0
    //   240: ifnull +9 -> 249
    //   243: aload_0
    //   244: invokeinterface 108 1 0
    //   249: aconst_null
    //   250: areturn
    //   251: new 184	java/util/ArrayList
    //   254: dup
    //   255: invokespecial 185	java/util/ArrayList:<init>	()V
    //   258: astore_1
    //   259: goto -179 -> 80
    //   262: astore_2
    //   263: aload_0
    //   264: astore_1
    //   265: aload_2
    //   266: astore_0
    //   267: aload_1
    //   268: ifnull +9 -> 277
    //   271: aload_1
    //   272: invokeinterface 108 1 0
    //   277: aload_0
    //   278: athrow
    //   279: aload_0
    //   280: ifnull +9 -> 289
    //   283: aload_0
    //   284: invokeinterface 108 1 0
    //   289: aload_2
    //   290: areturn
    //   291: iconst_0
    //   292: ifeq -43 -> 249
    //   295: new 74	java/lang/NullPointerException
    //   298: dup
    //   299: invokespecial 75	java/lang/NullPointerException:<init>	()V
    //   302: athrow
    //   303: astore_0
    //   304: aconst_null
    //   305: astore_1
    //   306: goto -39 -> 267
    //   309: astore_2
    //   310: aload_0
    //   311: astore_1
    //   312: aload_2
    //   313: astore_0
    //   314: goto -47 -> 267
    //   317: astore_1
    //   318: aconst_null
    //   319: astore_0
    //   320: goto -107 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramSQLiteDatabase	SQLiteDatabase
    //   71	132	1	localList	java.util.List
    //   212	15	1	localSQLException1	SQLException
    //   258	54	1	localObject1	Object
    //   317	1	1	localSQLException2	SQLException
    //   26	175	2	localHashMap	java.util.HashMap
    //   262	28	2	localMap	Map<String, java.util.List<z.d>>
    //   309	4	2	localObject2	Object
    //   50	152	3	str	String
    //   87	106	4	locald	z.d
    // Exception table:
    //   from	to	target	type
    //   19	27	212	android/database/SQLException
    //   27	80	212	android/database/SQLException
    //   80	209	212	android/database/SQLException
    //   251	259	212	android/database/SQLException
    //   19	27	262	finally
    //   27	80	262	finally
    //   80	209	262	finally
    //   251	259	262	finally
    //   0	19	303	finally
    //   213	239	309	finally
    //   0	19	317	android/database/SQLException
  }
  
  /* Error */
  public static boolean b(SQLiteDatabase paramSQLiteDatabase, cj paramcj)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_3
    //   9: aload 5
    //   11: astore_2
    //   12: new 129	java/util/HashMap
    //   15: dup
    //   16: invokespecial 130	java/util/HashMap:<init>	()V
    //   19: astore 6
    //   21: aload 4
    //   23: astore_3
    //   24: aload 5
    //   26: astore_2
    //   27: aload_0
    //   28: ldc 85
    //   30: aconst_null
    //   31: invokevirtual 89	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore_0
    //   35: aload_0
    //   36: astore_3
    //   37: aload_0
    //   38: astore_2
    //   39: aload_0
    //   40: invokeinterface 137 1 0
    //   45: ifeq +251 -> 296
    //   48: aload_0
    //   49: astore_3
    //   50: aload_0
    //   51: astore_2
    //   52: new 16	d/a/cl
    //   55: dup
    //   56: invokespecial 339	d/a/cl:<init>	()V
    //   59: astore 4
    //   61: aload_0
    //   62: astore_3
    //   63: aload_0
    //   64: astore_2
    //   65: aload 4
    //   67: aload_0
    //   68: aload_0
    //   69: ldc 14
    //   71: invokeinterface 99 2 0
    //   76: invokeinterface 102 2 0
    //   81: invokestatic 322	d/a/cd:a	(Ljava/lang/String;)Ljava/util/List;
    //   84: invokevirtual 342	d/a/cl:a	(Ljava/util/List;)V
    //   87: aload_0
    //   88: astore_3
    //   89: aload_0
    //   90: astore_2
    //   91: aload 4
    //   93: aload_0
    //   94: aload_0
    //   95: ldc 25
    //   97: invokeinterface 99 2 0
    //   102: invokeinterface 102 2 0
    //   107: invokestatic 322	d/a/cd:a	(Ljava/lang/String;)Ljava/util/List;
    //   110: invokevirtual 344	d/a/cl:b	(Ljava/util/List;)V
    //   113: aload_0
    //   114: astore_3
    //   115: aload_0
    //   116: astore_2
    //   117: aload 4
    //   119: aload_0
    //   120: aload_0
    //   121: ldc 30
    //   123: invokeinterface 99 2 0
    //   128: invokeinterface 241 2 0
    //   133: i2l
    //   134: invokevirtual 347	d/a/cl:c	(J)V
    //   137: aload_0
    //   138: astore_3
    //   139: aload_0
    //   140: astore_2
    //   141: aload 4
    //   143: aload_0
    //   144: aload_0
    //   145: ldc 45
    //   147: invokeinterface 99 2 0
    //   152: invokeinterface 241 2 0
    //   157: i2l
    //   158: invokevirtual 349	d/a/cl:b	(J)V
    //   161: aload_0
    //   162: astore_3
    //   163: aload_0
    //   164: astore_2
    //   165: aload 4
    //   167: aload_0
    //   168: aload_0
    //   169: ldc 55
    //   171: invokeinterface 99 2 0
    //   176: invokeinterface 102 2 0
    //   181: invokevirtual 351	d/a/cl:b	(Ljava/lang/String;)V
    //   184: aload_0
    //   185: astore_3
    //   186: aload_0
    //   187: astore_2
    //   188: aload 4
    //   190: aload_0
    //   191: aload_0
    //   192: ldc 50
    //   194: invokeinterface 99 2 0
    //   199: invokeinterface 102 2 0
    //   204: invokestatic 355	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   207: invokevirtual 357	d/a/cl:a	(J)V
    //   210: aload_0
    //   211: astore_3
    //   212: aload_0
    //   213: astore_2
    //   214: aload 6
    //   216: aload_0
    //   217: aload_0
    //   218: ldc 14
    //   220: invokeinterface 99 2 0
    //   225: invokeinterface 102 2 0
    //   230: invokestatic 322	d/a/cd:a	(Ljava/lang/String;)Ljava/util/List;
    //   233: aload 4
    //   235: invokeinterface 173 3 0
    //   240: pop
    //   241: goto -206 -> 35
    //   244: astore_0
    //   245: aload_3
    //   246: astore_2
    //   247: aload_1
    //   248: iconst_0
    //   249: invokestatic 291	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   252: iconst_0
    //   253: invokevirtual 180	d/a/cj:a	(Ljava/lang/Object;Z)V
    //   256: aload_3
    //   257: astore_2
    //   258: new 110	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   265: ldc_w 359
    //   268: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_0
    //   272: invokevirtual 120	android/database/SQLException:toString	()Ljava/lang/String;
    //   275: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 126	d/a/ax:d	(Ljava/lang/String;)V
    //   284: aload_3
    //   285: ifnull +9 -> 294
    //   288: aload_3
    //   289: invokeinterface 108 1 0
    //   294: iconst_0
    //   295: ireturn
    //   296: aload_0
    //   297: astore_3
    //   298: aload_0
    //   299: astore_2
    //   300: aload 6
    //   302: invokeinterface 362 1 0
    //   307: ifle +26 -> 333
    //   310: aload_0
    //   311: astore_3
    //   312: aload_0
    //   313: astore_2
    //   314: aload_1
    //   315: aload 6
    //   317: iconst_0
    //   318: invokevirtual 180	d/a/cj:a	(Ljava/lang/Object;Z)V
    //   321: aload_0
    //   322: ifnull -28 -> 294
    //   325: aload_0
    //   326: invokeinterface 108 1 0
    //   331: iconst_0
    //   332: ireturn
    //   333: aload_0
    //   334: astore_3
    //   335: aload_0
    //   336: astore_2
    //   337: aload_1
    //   338: ldc -81
    //   340: iconst_0
    //   341: invokevirtual 180	d/a/cj:a	(Ljava/lang/Object;Z)V
    //   344: goto -23 -> 321
    //   347: astore_0
    //   348: aload_2
    //   349: ifnull +9 -> 358
    //   352: aload_2
    //   353: invokeinterface 108 1 0
    //   358: aload_0
    //   359: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	360	1	paramcj	cj
    //   11	342	2	localObject1	Object
    //   8	327	3	localObject2	Object
    //   4	230	4	localcl	cl
    //   1	24	5	localObject3	Object
    //   19	297	6	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   12	21	244	android/database/SQLException
    //   27	35	244	android/database/SQLException
    //   39	48	244	android/database/SQLException
    //   52	61	244	android/database/SQLException
    //   65	87	244	android/database/SQLException
    //   91	113	244	android/database/SQLException
    //   117	137	244	android/database/SQLException
    //   141	161	244	android/database/SQLException
    //   165	184	244	android/database/SQLException
    //   188	210	244	android/database/SQLException
    //   214	241	244	android/database/SQLException
    //   300	310	244	android/database/SQLException
    //   314	321	244	android/database/SQLException
    //   337	344	244	android/database/SQLException
    //   12	21	347	finally
    //   27	35	347	finally
    //   39	48	347	finally
    //   52	61	347	finally
    //   65	87	347	finally
    //   91	113	347	finally
    //   117	137	347	finally
    //   141	161	347	finally
    //   165	184	347	finally
    //   188	210	347	finally
    //   214	241	347	finally
    //   247	256	347	finally
    //   258	284	347	finally
    //   300	310	347	finally
    //   314	321	347	finally
    //   337	344	347	finally
  }
  
  /* Error */
  public static java.util.List<String> c(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 264
    //   4: invokestatic 72	d/a/a:b	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)I
    //   7: ifle +117 -> 124
    //   10: aload_0
    //   11: ldc_w 365
    //   14: aconst_null
    //   15: invokevirtual 89	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore_1
    //   19: aload_1
    //   20: astore_0
    //   21: new 184	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 185	java/util/ArrayList:<init>	()V
    //   28: astore_2
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: invokeinterface 137 1 0
    //   37: ifeq +73 -> 110
    //   40: aload_1
    //   41: astore_0
    //   42: aload_2
    //   43: aload_1
    //   44: aload_1
    //   45: ldc_w 280
    //   48: invokeinterface 99 2 0
    //   53: invokeinterface 102 2 0
    //   58: invokeinterface 170 2 0
    //   63: pop
    //   64: goto -35 -> 29
    //   67: astore_2
    //   68: aload_1
    //   69: astore_0
    //   70: new 110	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 367
    //   80: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_2
    //   84: invokevirtual 120	android/database/SQLException:toString	()Ljava/lang/String;
    //   87: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 126	d/a/ax:d	(Ljava/lang/String;)V
    //   96: aload_1
    //   97: ifnull +9 -> 106
    //   100: aload_1
    //   101: invokeinterface 108 1 0
    //   106: aconst_null
    //   107: astore_0
    //   108: aload_0
    //   109: areturn
    //   110: aload_2
    //   111: astore_0
    //   112: aload_1
    //   113: ifnull -5 -> 108
    //   116: aload_1
    //   117: invokeinterface 108 1 0
    //   122: aload_2
    //   123: areturn
    //   124: iconst_0
    //   125: ifeq -19 -> 106
    //   128: new 74	java/lang/NullPointerException
    //   131: dup
    //   132: invokespecial 75	java/lang/NullPointerException:<init>	()V
    //   135: athrow
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_0
    //   140: ifnull +9 -> 149
    //   143: aload_0
    //   144: invokeinterface 108 1 0
    //   149: aload_1
    //   150: athrow
    //   151: astore_1
    //   152: goto -13 -> 139
    //   155: astore_2
    //   156: aconst_null
    //   157: astore_1
    //   158: goto -90 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramSQLiteDatabase	SQLiteDatabase
    //   18	99	1	localCursor	Cursor
    //   136	14	1	localObject1	Object
    //   151	1	1	localObject2	Object
    //   157	1	1	localObject3	Object
    //   28	15	2	localArrayList	java.util.ArrayList
    //   67	56	2	localSQLException1	SQLException
    //   155	1	2	localSQLException2	SQLException
    // Exception table:
    //   from	to	target	type
    //   21	29	67	android/database/SQLException
    //   31	40	67	android/database/SQLException
    //   42	64	67	android/database/SQLException
    //   0	19	136	finally
    //   21	29	151	finally
    //   31	40	151	finally
    //   42	64	151	finally
    //   70	96	151	finally
    //   0	19	155	android/database/SQLException
  }
  
  private static void c(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL("update system set count=count+1 where key like '" + paramString + "'");
      paramSQLiteDatabase.setTransactionSuccessful();
      if (paramSQLiteDatabase != null) {
        paramSQLiteDatabase.endTransaction();
      }
      return;
    }
    catch (SQLException paramString)
    {
      do
      {
        paramString = paramString;
      } while (paramSQLiteDatabase == null);
      paramSQLiteDatabase.endTransaction();
      return;
    }
    finally
    {
      paramString = finally;
      if (paramSQLiteDatabase != null) {
        paramSQLiteDatabase.endTransaction();
      }
      throw paramString;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */