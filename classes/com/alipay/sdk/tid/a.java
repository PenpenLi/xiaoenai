package com.alipay.sdk.tid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

public final class a
  extends SQLiteOpenHelper
{
  private static final String a = "msp.db";
  private static final int b = 1;
  private WeakReference<Context> c;
  
  public a(Context paramContext)
  {
    super(paramContext, "msp.db", null, 1);
    this.c = new WeakReference(paramContext);
  }
  
  /* Error */
  private java.util.List<String> a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 32	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 35	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: aload_0
    //   12: invokevirtual 39	com/alipay/sdk/tid/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore_1
    //   16: aload_1
    //   17: ldc 41
    //   19: aconst_null
    //   20: invokevirtual 47	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_3
    //   24: aload_3
    //   25: astore_2
    //   26: aload_2
    //   27: invokeinterface 53 1 0
    //   32: ifeq +76 -> 108
    //   35: aload_2
    //   36: iconst_0
    //   37: invokeinterface 57 2 0
    //   42: astore_3
    //   43: aload_3
    //   44: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifne -21 -> 26
    //   50: aload 4
    //   52: iconst_2
    //   53: aload_3
    //   54: aload_0
    //   55: getfield 26	com/alipay/sdk/tid/a:c	Ljava/lang/ref/WeakReference;
    //   58: invokevirtual 67	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   61: checkcast 69	android/content/Context
    //   64: invokestatic 74	com/alipay/sdk/util/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   67: invokestatic 79	com/alipay/sdk/encrypt/b:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   70: invokeinterface 85 2 0
    //   75: pop
    //   76: goto -50 -> 26
    //   79: astore_3
    //   80: aload_2
    //   81: ifnull +9 -> 90
    //   84: aload_2
    //   85: invokeinterface 88 1 0
    //   90: aload_1
    //   91: ifnull +14 -> 105
    //   94: aload_1
    //   95: invokevirtual 91	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   98: ifeq +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   105: aload 4
    //   107: areturn
    //   108: aload_2
    //   109: ifnull +9 -> 118
    //   112: aload_2
    //   113: invokeinterface 88 1 0
    //   118: aload_1
    //   119: ifnull -14 -> 105
    //   122: aload_1
    //   123: invokevirtual 91	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   126: ifeq -21 -> 105
    //   129: aload_1
    //   130: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   133: aload 4
    //   135: areturn
    //   136: astore_3
    //   137: aconst_null
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +9 -> 151
    //   145: aload_2
    //   146: invokeinterface 88 1 0
    //   151: aload_1
    //   152: ifnull +14 -> 166
    //   155: aload_1
    //   156: invokevirtual 91	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   159: ifeq +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   166: aload_3
    //   167: athrow
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_2
    //   171: goto -30 -> 141
    //   174: astore_3
    //   175: goto -34 -> 141
    //   178: astore_1
    //   179: aconst_null
    //   180: astore_1
    //   181: goto -101 -> 80
    //   184: astore_3
    //   185: goto -105 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	a
    //   15	148	1	localSQLiteDatabase	SQLiteDatabase
    //   178	1	1	localException1	Exception
    //   180	1	1	localObject1	Object
    //   1	170	2	localObject2	Object
    //   23	31	3	localObject3	Object
    //   79	1	3	localException2	Exception
    //   136	31	3	localObject4	Object
    //   168	1	3	localObject5	Object
    //   174	1	3	localObject6	Object
    //   184	1	3	localException3	Exception
    //   9	125	4	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   26	76	79	java/lang/Exception
    //   11	16	136	finally
    //   16	24	168	finally
    //   26	76	174	finally
    //   11	16	178	java/lang/Exception
    //   16	24	184	java/lang/Exception
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    int j = 0;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("select name from tb_tid where tid!='' order by dt asc", null);
    if (localCursor.getCount() <= 14) {
      localCursor.close();
    }
    for (;;)
    {
      return;
      int m = localCursor.getCount() - 14;
      String[] arrayOfString = new String[m];
      if (localCursor.moveToFirst())
      {
        i = 0;
        int k;
        do
        {
          arrayOfString[i] = localCursor.getString(0);
          k = i + 1;
          if (!localCursor.moveToNext()) {
            break;
          }
          i = k;
        } while (m > k);
      }
      localCursor.close();
      int i = j;
      while (i < arrayOfString.length)
      {
        if (!TextUtils.isEmpty(arrayOfString[i])) {
          a(paramSQLiteDatabase, arrayOfString[i]);
        }
        i += 1;
      }
    }
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      paramSQLiteDatabase.delete("tb_tid", "name=?", new String[] { paramString });
      return;
    }
    catch (Exception paramSQLiteDatabase) {}
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int j = 0;
    paramString3 = com.alipay.sdk.encrypt.b.a(1, paramString3, com.alipay.sdk.util.b.c((Context)this.c.get()));
    paramSQLiteDatabase.execSQL("insert into tb_tid (name, tid, key_tid, dt) values (?, ?, ?, datetime('now', 'localtime'))", new Object[] { e(paramString1, paramString2), paramString3, paramString4 });
    paramString1 = paramSQLiteDatabase.rawQuery("select name from tb_tid where tid!='' order by dt asc", null);
    if (paramString1.getCount() <= 14) {
      paramString1.close();
    }
    for (;;)
    {
      return;
      int m = paramString1.getCount() - 14;
      paramString2 = new String[m];
      if (paramString1.moveToFirst())
      {
        i = 0;
        int k;
        do
        {
          paramString2[i] = paramString1.getString(0);
          k = i + 1;
          if (!paramString1.moveToNext()) {
            break;
          }
          i = k;
        } while (m > k);
      }
      paramString1.close();
      int i = j;
      while (i < paramString2.length)
      {
        if (!TextUtils.isEmpty(paramString2[i])) {
          a(paramSQLiteDatabase, paramString2[i]);
        }
        i += 1;
      }
    }
  }
  
  private static boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase2 = null;
    SQLiteDatabase localSQLiteDatabase1 = null;
    for (;;)
    {
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select count(*) from tb_tid where name=?", new String[] { e(paramString1, paramString2) });
        localSQLiteDatabase1 = paramSQLiteDatabase;
        localSQLiteDatabase2 = paramSQLiteDatabase;
        if (!paramSQLiteDatabase.moveToFirst()) {
          break label112;
        }
        localSQLiteDatabase1 = paramSQLiteDatabase;
        localSQLiteDatabase2 = paramSQLiteDatabase;
        i = paramSQLiteDatabase.getInt(0);
      }
      catch (Exception paramSQLiteDatabase)
      {
        if (localSQLiteDatabase1 == null) {
          break label103;
        }
        localSQLiteDatabase1.close();
        i = 0;
        continue;
      }
      finally
      {
        if (localSQLiteDatabase2 == null) {
          continue;
        }
        localSQLiteDatabase2.close();
      }
      return i > 0;
      label103:
      int i = 0;
      continue;
      continue;
      label112:
      i = 0;
    }
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramSQLiteDatabase.execSQL("update tb_tid set tid=?, key_tid=?, dt=datetime('now', 'localtime') where name=?", new Object[] { com.alipay.sdk.encrypt.b.a(1, paramString3, com.alipay.sdk.util.b.c((Context)this.c.get())), paramString4, e(paramString1, paramString2) });
  }
  
  /* Error */
  private long d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 5
    //   12: lconst_0
    //   13: lstore 10
    //   15: aload_0
    //   16: invokevirtual 39	com/alipay/sdk/tid/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: astore_3
    //   20: aload 7
    //   22: astore 4
    //   24: aload 6
    //   26: astore 5
    //   28: aload_3
    //   29: ldc -113
    //   31: iconst_1
    //   32: anewarray 103	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: aload_1
    //   38: aload_2
    //   39: invokestatic 126	com/alipay/sdk/tid/a:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   42: aastore
    //   43: invokevirtual 47	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_1
    //   47: lload 10
    //   49: lstore 8
    //   51: aload_1
    //   52: astore 4
    //   54: aload_1
    //   55: astore 5
    //   57: aload_1
    //   58: invokeinterface 106 1 0
    //   63: ifeq +36 -> 99
    //   66: aload_1
    //   67: astore 4
    //   69: aload_1
    //   70: astore 5
    //   72: new 145	java/text/SimpleDateFormat
    //   75: dup
    //   76: ldc -109
    //   78: invokestatic 153	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   81: invokespecial 156	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   84: aload_1
    //   85: iconst_0
    //   86: invokeinterface 57 2 0
    //   91: invokevirtual 160	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   94: invokevirtual 166	java/util/Date:getTime	()J
    //   97: lstore 8
    //   99: aload_1
    //   100: ifnull +9 -> 109
    //   103: aload_1
    //   104: invokeinterface 88 1 0
    //   109: lload 8
    //   111: lstore 12
    //   113: aload_3
    //   114: ifnull +22 -> 136
    //   117: lload 8
    //   119: lstore 12
    //   121: aload_3
    //   122: invokevirtual 91	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   125: ifeq +11 -> 136
    //   128: aload_3
    //   129: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   132: lload 8
    //   134: lstore 12
    //   136: lload 12
    //   138: lreturn
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_3
    //   142: aload 5
    //   144: ifnull +10 -> 154
    //   147: aload 5
    //   149: invokeinterface 88 1 0
    //   154: lload 10
    //   156: lstore 12
    //   158: aload_3
    //   159: ifnull -23 -> 136
    //   162: lload 10
    //   164: lstore 12
    //   166: aload_3
    //   167: invokevirtual 91	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   170: ifeq -34 -> 136
    //   173: aload_3
    //   174: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   177: lconst_0
    //   178: lreturn
    //   179: astore_1
    //   180: aconst_null
    //   181: astore_3
    //   182: aload 4
    //   184: ifnull +10 -> 194
    //   187: aload 4
    //   189: invokeinterface 88 1 0
    //   194: aload_3
    //   195: ifnull +14 -> 209
    //   198: aload_3
    //   199: invokevirtual 91	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   202: ifeq +7 -> 209
    //   205: aload_3
    //   206: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   209: aload_1
    //   210: athrow
    //   211: astore_1
    //   212: goto -30 -> 182
    //   215: astore_1
    //   216: goto -74 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	a
    //   0	219	1	paramString1	String
    //   0	219	2	paramString2	String
    //   19	187	3	localSQLiteDatabase	SQLiteDatabase
    //   1	187	4	localObject1	Object
    //   10	138	5	localObject2	Object
    //   7	18	6	localObject3	Object
    //   4	17	7	localObject4	Object
    //   49	84	8	l1	long
    //   13	150	10	l2	long
    //   111	54	12	l3	long
    // Exception table:
    //   from	to	target	type
    //   15	20	139	java/lang/Exception
    //   15	20	179	finally
    //   28	47	211	finally
    //   57	66	211	finally
    //   72	99	211	finally
    //   28	47	215	java/lang/Exception
    //   57	66	215	java/lang/Exception
    //   72	99	215	java/lang/Exception
  }
  
  private static String e(String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      b(localSQLiteDatabase, paramString1, paramString2, "", "");
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      a(localSQLiteDatabase, e(paramString1, paramString2));
      if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen())) {
        localSQLiteDatabase.close();
      }
      return;
    }
    catch (Exception paramString1) {}finally
    {
      if ((localObject2 != null) && (((SQLiteDatabase)localObject2).isOpen())) {
        ((SQLiteDatabase)localObject2).close();
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    localObject2 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (!a(localSQLiteDatabase, paramString1, paramString2)) {
          continue;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        b(localSQLiteDatabase, paramString1, paramString2, paramString3, paramString4);
      }
      catch (Exception paramString1)
      {
        SQLiteDatabase localSQLiteDatabase;
        return;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        int k = paramString1.getCount() - 14;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        paramString2 = new String[k];
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (!paramString1.moveToFirst()) {
          continue;
        }
        int i = 0;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        paramString2[i] = paramString1.getString(0);
        int j = i + 1;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (!paramString1.moveToNext()) {
          continue;
        }
        i = j;
        if (k > j) {
          continue;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        paramString1.close();
        i = 0;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (i >= paramString2.length) {
          continue;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (TextUtils.isEmpty(paramString2[i])) {
          continue;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        a(localSQLiteDatabase, paramString2[i]);
        i += 1;
        continue;
      }
      finally
      {
        if ((localObject2 == null) || (!((SQLiteDatabase)localObject2).isOpen())) {
          continue;
        }
        ((SQLiteDatabase)localObject2).close();
      }
      if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen())) {
        localSQLiteDatabase.close();
      }
      return;
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      paramString3 = com.alipay.sdk.encrypt.b.a(1, paramString3, com.alipay.sdk.util.b.c((Context)this.c.get()));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localSQLiteDatabase.execSQL("insert into tb_tid (name, tid, key_tid, dt) values (?, ?, ?, datetime('now', 'localtime'))", new Object[] { e(paramString1, paramString2), paramString3, paramString4 });
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      paramString1 = localSQLiteDatabase.rawQuery("select name from tb_tid where tid!='' order by dt asc", null);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      if (paramString1.getCount() > 14) {
        continue;
      }
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      paramString1.close();
    }
  }
  
  /* Error */
  public final String b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 39	com/alipay/sdk/tid/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_3
    //   8: aload_3
    //   9: ldc -66
    //   11: iconst_1
    //   12: anewarray 103	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: aload_2
    //   19: invokestatic 126	com/alipay/sdk/tid/a:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   22: aastore
    //   23: invokevirtual 47	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore_2
    //   27: aload 4
    //   29: astore_1
    //   30: aload_2
    //   31: invokeinterface 106 1 0
    //   36: ifeq +11 -> 47
    //   39: aload_2
    //   40: iconst_0
    //   41: invokeinterface 57 2 0
    //   46: astore_1
    //   47: aload_2
    //   48: ifnull +9 -> 57
    //   51: aload_2
    //   52: invokeinterface 88 1 0
    //   57: aload_3
    //   58: ifnull +136 -> 194
    //   61: aload_3
    //   62: invokevirtual 91	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   65: ifeq +129 -> 194
    //   68: aload_3
    //   69: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   72: aload_1
    //   73: astore_2
    //   74: aload_1
    //   75: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +22 -> 100
    //   81: iconst_2
    //   82: aload_1
    //   83: aload_0
    //   84: getfield 26	com/alipay/sdk/tid/a:c	Ljava/lang/ref/WeakReference;
    //   87: invokevirtual 67	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   90: checkcast 69	android/content/Context
    //   93: invokestatic 74	com/alipay/sdk/util/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   96: invokestatic 79	com/alipay/sdk/encrypt/b:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   99: astore_2
    //   100: aload_2
    //   101: areturn
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_2
    //   105: aconst_null
    //   106: astore_3
    //   107: aload_2
    //   108: ifnull +9 -> 117
    //   111: aload_2
    //   112: invokeinterface 88 1 0
    //   117: aload_3
    //   118: ifnull +71 -> 189
    //   121: aload_3
    //   122: invokevirtual 91	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   125: ifeq +64 -> 189
    //   128: aload_3
    //   129: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   132: aconst_null
    //   133: astore_1
    //   134: goto -62 -> 72
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_3
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: ifnull +9 -> 152
    //   146: aload_2
    //   147: invokeinterface 88 1 0
    //   152: aload_3
    //   153: ifnull +14 -> 167
    //   156: aload_3
    //   157: invokevirtual 91	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   160: ifeq +7 -> 167
    //   163: aload_3
    //   164: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: aconst_null
    //   171: astore_2
    //   172: goto -30 -> 142
    //   175: astore_1
    //   176: goto -34 -> 142
    //   179: astore_1
    //   180: aconst_null
    //   181: astore_2
    //   182: goto -75 -> 107
    //   185: astore_1
    //   186: goto -79 -> 107
    //   189: aconst_null
    //   190: astore_1
    //   191: goto -119 -> 72
    //   194: goto -122 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	a
    //   0	197	1	paramString1	String
    //   0	197	2	paramString2	String
    //   7	157	3	localSQLiteDatabase	SQLiteDatabase
    //   1	27	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	8	102	java/lang/Exception
    //   3	8	137	finally
    //   8	27	169	finally
    //   30	47	175	finally
    //   8	27	179	java/lang/Exception
    //   30	47	185	java/lang/Exception
  }
  
  /* Error */
  public final String c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 39	com/alipay/sdk/tid/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore_3
    //   11: aload_3
    //   12: ldc -64
    //   14: iconst_1
    //   15: anewarray 103	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: aload_1
    //   21: aload_2
    //   22: invokestatic 126	com/alipay/sdk/tid/a:e	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   25: aastore
    //   26: invokevirtual 47	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload 5
    //   32: astore_2
    //   33: aload_1
    //   34: invokeinterface 106 1 0
    //   39: ifeq +11 -> 50
    //   42: aload_1
    //   43: iconst_0
    //   44: invokeinterface 57 2 0
    //   49: astore_2
    //   50: aload_1
    //   51: ifnull +9 -> 60
    //   54: aload_1
    //   55: invokeinterface 88 1 0
    //   60: aload_2
    //   61: astore_1
    //   62: aload_3
    //   63: ifnull +18 -> 81
    //   66: aload_2
    //   67: astore_1
    //   68: aload_3
    //   69: invokevirtual 91	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   72: ifeq +9 -> 81
    //   75: aload_3
    //   76: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   79: aload_2
    //   80: astore_1
    //   81: aload_1
    //   82: areturn
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_1
    //   86: aconst_null
    //   87: astore_3
    //   88: aload_1
    //   89: ifnull +9 -> 98
    //   92: aload_1
    //   93: invokeinterface 88 1 0
    //   98: aload 4
    //   100: astore_1
    //   101: aload_3
    //   102: ifnull -21 -> 81
    //   105: aload 4
    //   107: astore_1
    //   108: aload_3
    //   109: invokevirtual 91	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   112: ifeq -31 -> 81
    //   115: aload_3
    //   116: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_2
    //   122: aconst_null
    //   123: astore_3
    //   124: aconst_null
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +9 -> 136
    //   130: aload_1
    //   131: invokeinterface 88 1 0
    //   136: aload_3
    //   137: ifnull +14 -> 151
    //   140: aload_3
    //   141: invokevirtual 91	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   144: ifeq +7 -> 151
    //   147: aload_3
    //   148: invokevirtual 92	android/database/sqlite/SQLiteDatabase:close	()V
    //   151: aload_2
    //   152: athrow
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_1
    //   156: goto -30 -> 126
    //   159: astore_2
    //   160: goto -34 -> 126
    //   163: astore_1
    //   164: aconst_null
    //   165: astore_1
    //   166: goto -78 -> 88
    //   169: astore_2
    //   170: goto -82 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	a
    //   0	173	1	paramString1	String
    //   0	173	2	paramString2	String
    //   10	138	3	localSQLiteDatabase	SQLiteDatabase
    //   1	105	4	localObject1	Object
    //   4	27	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	11	83	java/lang/Exception
    //   6	11	121	finally
    //   11	30	153	finally
    //   33	50	159	finally
    //   11	30	163	java/lang/Exception
    //   33	50	169	java/lang/Exception
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("drop table if exists tb_tid");
    paramSQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\tid\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */