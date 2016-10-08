package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class o
{
  private static o a = null;
  private static p b = null;
  private static boolean c = false;
  
  private o(Context paramContext, List<com.tencent.bugly.a> paramList)
  {
    b = new p(paramContext, paramList);
  }
  
  /* Error */
  private int a(String paramString1, String paramString2, String[] paramArrayOfString, n paramn)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: getstatic 18	com/tencent/bugly/proguard/o:b	Lcom/tencent/bugly/proguard/p;
    //   11: invokevirtual 41	com/tencent/bugly/proguard/p:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 5
    //   16: aload 5
    //   18: ifnull +13 -> 31
    //   21: aload 5
    //   23: aload_1
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual 47	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   29: istore 6
    //   31: iload 6
    //   33: istore 7
    //   35: aload 4
    //   37: ifnull +7 -> 44
    //   40: iload 6
    //   42: istore 7
    //   44: aload_0
    //   45: monitorexit
    //   46: iload 7
    //   48: ireturn
    //   49: astore_1
    //   50: aload_1
    //   51: invokestatic 52	com/tencent/bugly/proguard/w:a	(Ljava/lang/Throwable;)Z
    //   54: ifne +7 -> 61
    //   57: aload_1
    //   58: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   61: iload 8
    //   63: istore 7
    //   65: aload 4
    //   67: ifnull -23 -> 44
    //   70: iload 8
    //   72: istore 7
    //   74: goto -30 -> 44
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: aload 4
    //   85: ifnull +3 -> 88
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	o
    //   0	90	1	paramString1	String
    //   0	90	2	paramString2	String
    //   0	90	3	paramArrayOfString	String[]
    //   0	90	4	paramn	n
    //   14	8	5	localSQLiteDatabase	SQLiteDatabase
    //   4	37	6	i	int
    //   33	40	7	j	int
    //   1	70	8	k	int
    // Exception table:
    //   from	to	target	type
    //   8	16	49	java/lang/Throwable
    //   21	31	49	java/lang/Throwable
    //   88	90	77	finally
    //   8	16	82	finally
    //   21	31	82	finally
    //   50	61	82	finally
  }
  
  /* Error */
  private long a(String paramString, ContentValues paramContentValues, n paramn)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: getstatic 18	com/tencent/bugly/proguard/o:b	Lcom/tencent/bugly/proguard/p;
    //   8: invokevirtual 41	com/tencent/bugly/proguard/p:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore 4
    //   13: lload 7
    //   15: lstore 5
    //   17: aload 4
    //   19: ifnull +43 -> 62
    //   22: lload 7
    //   24: lstore 5
    //   26: aload_2
    //   27: ifnull +35 -> 62
    //   30: aload 4
    //   32: aload_1
    //   33: ldc 61
    //   35: aload_2
    //   36: invokevirtual 65	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   39: lstore 5
    //   41: lload 5
    //   43: lconst_0
    //   44: lcmp
    //   45: iflt +34 -> 79
    //   48: ldc 67
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_1
    //   57: aastore
    //   58: invokestatic 70	com/tencent/bugly/proguard/w:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   61: pop
    //   62: lload 5
    //   64: lstore 9
    //   66: aload_3
    //   67: ifnull +7 -> 74
    //   70: lload 5
    //   72: lstore 9
    //   74: aload_0
    //   75: monitorexit
    //   76: lload 9
    //   78: lreturn
    //   79: ldc 72
    //   81: iconst_1
    //   82: anewarray 4	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_1
    //   88: aastore
    //   89: invokestatic 75	com/tencent/bugly/proguard/w:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   92: pop
    //   93: goto -31 -> 62
    //   96: astore_1
    //   97: aload_1
    //   98: invokestatic 52	com/tencent/bugly/proguard/w:a	(Ljava/lang/Throwable;)Z
    //   101: ifne +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   108: lload 7
    //   110: lstore 9
    //   112: aload_3
    //   113: ifnull -39 -> 74
    //   116: lload 7
    //   118: lstore 9
    //   120: goto -46 -> 74
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload_3
    //   130: ifnull +3 -> 133
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	o
    //   0	135	1	paramString	String
    //   0	135	2	paramContentValues	ContentValues
    //   0	135	3	paramn	n
    //   11	20	4	localSQLiteDatabase	SQLiteDatabase
    //   15	56	5	l1	long
    //   1	116	7	l2	long
    //   64	55	9	l3	long
    // Exception table:
    //   from	to	target	type
    //   5	13	96	java/lang/Throwable
    //   30	41	96	java/lang/Throwable
    //   48	62	96	java/lang/Throwable
    //   79	93	96	java/lang/Throwable
    //   133	135	123	finally
    //   5	13	128	finally
    //   30	41	128	finally
    //   48	62	128	finally
    //   79	93	128	finally
    //   97	108	128	finally
  }
  
  private Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, n paramn)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
      if (localSQLiteDatabase == null) {
        break label80;
      }
      paramString1 = localSQLiteDatabase.query(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        if (!w.a(paramString1)) {
          paramString1.printStackTrace();
        }
        if (paramn == null) {
          break;
        }
        paramString1 = null;
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          throw paramString1;
        }
        finally {}
        paramString1 = null;
        continue;
        label80:
        paramString1 = null;
      }
    }
    if (paramn != null) {}
    return paramString1;
  }
  
  public static o a()
  {
    try
    {
      o localo = a;
      return localo;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static o a(Context paramContext, List<com.tencent.bugly.a> paramList)
  {
    try
    {
      if (a == null) {
        a = new o(paramContext, paramList);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private static q a(Cursor paramCursor)
  {
    if (paramCursor == null) {}
    do
    {
      return null;
      try
      {
        q localq = new q();
        localq.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        localq.b = paramCursor.getInt(paramCursor.getColumnIndex("_tp"));
        localq.c = paramCursor.getString(paramCursor.getColumnIndex("_pc"));
        localq.d = paramCursor.getString(paramCursor.getColumnIndex("_th"));
        localq.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
        localq.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
        return localq;
      }
      catch (Throwable paramCursor) {}
    } while (w.a(paramCursor));
    paramCursor.printStackTrace();
    return null;
  }
  
  /* Error */
  private Map<String, byte[]> a(int paramInt, n paramn)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 145	com/tencent/bugly/proguard/o:c	(I)Ljava/util/List;
    //   5: astore 4
    //   7: new 147	java/util/HashMap
    //   10: dup
    //   11: invokespecial 148	java/util/HashMap:<init>	()V
    //   14: astore_3
    //   15: aload 4
    //   17: invokeinterface 154 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 160 1 0
    //   31: ifeq +65 -> 96
    //   34: aload 4
    //   36: invokeinterface 164 1 0
    //   41: checkcast 90	com/tencent/bugly/proguard/q
    //   44: astore 5
    //   46: aload 5
    //   48: getfield 141	com/tencent/bugly/proguard/q:g	[B
    //   51: astore 6
    //   53: aload 6
    //   55: ifnull -31 -> 24
    //   58: aload_3
    //   59: aload 5
    //   61: getfield 167	com/tencent/bugly/proguard/q:f	Ljava/lang/String;
    //   64: aload 6
    //   66: invokeinterface 173 3 0
    //   71: pop
    //   72: goto -48 -> 24
    //   75: astore 4
    //   77: aload 4
    //   79: invokestatic 52	com/tencent/bugly/proguard/w:a	(Ljava/lang/Throwable;)Z
    //   82: ifne +8 -> 90
    //   85: aload 4
    //   87: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   90: aload_2
    //   91: ifnull +3 -> 94
    //   94: aload_3
    //   95: areturn
    //   96: aload_2
    //   97: ifnull +15 -> 112
    //   100: aload_3
    //   101: areturn
    //   102: astore_2
    //   103: aload_2
    //   104: athrow
    //   105: astore 4
    //   107: aconst_null
    //   108: astore_3
    //   109: goto -32 -> 77
    //   112: aload_3
    //   113: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	o
    //   0	114	1	paramInt	int
    //   0	114	2	paramn	n
    //   14	99	3	localHashMap	java.util.HashMap
    //   5	30	4	localObject	Object
    //   75	11	4	localThrowable1	Throwable
    //   105	1	4	localThrowable2	Throwable
    //   44	16	5	localq	q
    //   51	14	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   15	24	75	java/lang/Throwable
    //   24	53	75	java/lang/Throwable
    //   58	72	75	java/lang/Throwable
    //   0	15	102	finally
    //   15	24	102	finally
    //   24	53	102	finally
    //   58	72	102	finally
    //   77	90	102	finally
    //   0	15	105	java/lang/Throwable
  }
  
  public static void a(List<q> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
      if (localSQLiteDatabase == null) {
        continue;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (q)paramList.next();
        localStringBuilder.append(" or _id").append(" = ").append(((q)localObject).a);
      }
      Object localObject = localStringBuilder.toString();
      paramList = (List<q>)localObject;
      if (((String)localObject).length() > 0) {
        paramList = ((String)localObject).substring(4);
      }
      localStringBuilder.setLength(0);
      try
      {
        w.c("deleted %s data %d", new Object[] { "t_lr", Integer.valueOf(localSQLiteDatabase.delete("t_lr", paramList, null)) });
        return;
      }
      catch (Throwable paramList)
      {
        paramList = paramList;
        if (w.a(paramList)) {
          continue;
        }
        paramList.printStackTrace();
        return;
      }
      finally {}
    }
  }
  
  public static boolean a(int paramInt, String paramString, n paramn)
  {
    boolean bool2 = true;
    bool3 = false;
    bool1 = false;
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
        if (localSQLiteDatabase != null)
        {
          if ((paramString == null) || (paramString.trim().length() <= 0)) {
            continue;
          }
          i = 0;
          if (i == 0) {
            continue;
          }
          paramString = "_id = " + paramInt;
          paramInt = localSQLiteDatabase.delete("t_pf", paramString, null);
          w.c("deleted %s data %d", new Object[] { "t_pf", Integer.valueOf(paramInt) });
          if (paramInt <= 0) {
            continue;
          }
          bool1 = bool2;
        }
      }
      catch (Throwable paramString)
      {
        int i;
        if (w.a(paramString)) {
          continue;
        }
        paramString.printStackTrace();
        bool1 = bool3;
        return false;
      }
      finally
      {
        if (paramn == null) {
          continue;
        }
      }
      return bool1;
      i = 1;
      continue;
      paramString = "_id = " + paramInt + " and _tp" + " = \"" + paramString + "\"";
      continue;
      bool1 = false;
    }
  }
  
  private boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, n paramn)
  {
    boolean bool1 = false;
    try
    {
      q localq = new q();
      localq.a = paramInt;
      localq.f = paramString;
      localq.e = System.currentTimeMillis();
      localq.g = paramArrayOfByte;
      boolean bool2 = b(localq);
      bool1 = bool2;
    }
    catch (Throwable paramString)
    {
      if (w.a(paramString)) {
        break label71;
      }
      paramString.printStackTrace();
      return false;
    }
    finally
    {
      if (paramn == null) {
        break label84;
      }
    }
    return bool1;
  }
  
  private static ContentValues b(l paraml)
  {
    if (paraml == null) {}
    do
    {
      for (;;)
      {
        return null;
        try
        {
          ContentValues localContentValues = new ContentValues();
          if ((paraml.a > 0L) && (!TextUtils.isEmpty(paraml.b)))
          {
            localContentValues.put("_id", Long.valueOf(paraml.a));
            localContentValues.put("_pc", paraml.b);
            localContentValues.put("_tm", Long.valueOf(paraml.c));
            localContentValues.put("_fl", Integer.valueOf(paraml.d));
            localContentValues.put("_av", paraml.f);
            localContentValues.put("_sv", paraml.e);
            localContentValues.put("_uid", Long.valueOf(paraml.g));
            return localContentValues;
          }
        }
        catch (Throwable paraml) {}
      }
    } while (w.a(paraml));
    paraml.printStackTrace();
    return null;
  }
  
  private static q b(Cursor paramCursor)
  {
    if (paramCursor == null) {}
    do
    {
      return null;
      try
      {
        q localq = new q();
        localq.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        localq.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
        localq.f = paramCursor.getString(paramCursor.getColumnIndex("_tp"));
        localq.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
        return localq;
      }
      catch (Throwable paramCursor) {}
    } while (w.a(paramCursor));
    paramCursor.printStackTrace();
    return null;
  }
  
  public static void b(int paramInt)
  {
    String str = null;
    SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
    if ((localSQLiteDatabase == null) || (paramInt >= 0)) {}
    try
    {
      str = "_tp = " + paramInt;
      w.c("deleted %s data %d", new Object[] { "t_lr", Integer.valueOf(localSQLiteDatabase.delete("t_lr", str, null)) });
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        localThrowable = localThrowable;
      } while (w.a(localThrowable));
      localThrowable.printStackTrace();
      return;
    }
    finally {}
  }
  
  private boolean b(q paramq)
  {
    if (paramq == null) {}
    for (;;)
    {
      return false;
      try
      {
        SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
        if (localSQLiteDatabase == null) {
          continue;
        }
        ContentValues localContentValues = d(paramq);
        if (localContentValues == null) {
          continue;
        }
        long l = localSQLiteDatabase.replace("t_pf", "_id", localContentValues);
        if (l < 0L) {
          continue;
        }
        w.c("insert %s success!", new Object[] { "t_pf" });
        paramq.a = l;
        return true;
      }
      catch (Throwable paramq)
      {
        paramq = paramq;
        if (w.a(paramq)) {
          continue;
        }
        paramq.printStackTrace();
        return false;
      }
      finally {}
    }
  }
  
  private static ContentValues c(q paramq)
  {
    if (paramq == null) {}
    do
    {
      return null;
      try
      {
        ContentValues localContentValues = new ContentValues();
        if (paramq.a > 0L) {
          localContentValues.put("_id", Long.valueOf(paramq.a));
        }
        localContentValues.put("_tp", Integer.valueOf(paramq.b));
        localContentValues.put("_pc", paramq.c);
        localContentValues.put("_th", paramq.d);
        localContentValues.put("_tm", Long.valueOf(paramq.e));
        if (paramq.g != null) {
          localContentValues.put("_dt", paramq.g);
        }
        return localContentValues;
      }
      catch (Throwable paramq) {}
    } while (w.a(paramq));
    paramq.printStackTrace();
    return null;
  }
  
  private static l c(Cursor paramCursor)
  {
    if (paramCursor == null) {}
    do
    {
      return null;
      try
      {
        l locall = new l();
        locall.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        locall.b = paramCursor.getString(paramCursor.getColumnIndex("_pc"));
        locall.e = paramCursor.getString(paramCursor.getColumnIndex("_sv"));
        locall.f = paramCursor.getString(paramCursor.getColumnIndex("_av"));
        locall.c = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
        locall.d = paramCursor.getInt(paramCursor.getColumnIndex("_fl"));
        locall.g = paramCursor.getLong(paramCursor.getColumnIndex("_uid"));
        return locall;
      }
      catch (Throwable paramCursor) {}
    } while (w.a(paramCursor));
    paramCursor.printStackTrace();
    return null;
  }
  
  /* Error */
  private List<q> c(int paramInt)
  {
    // Byte code:
    //   0: getstatic 18	com/tencent/bugly/proguard/o:b	Lcom/tencent/bugly/proguard/p;
    //   3: invokevirtual 41	com/tencent/bugly/proguard/p:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +142 -> 150
    //   11: new 184	java/lang/StringBuilder
    //   14: dup
    //   15: ldc -27
    //   17: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: iload_1
    //   21: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 4
    //   29: aload_3
    //   30: ldc -19
    //   32: aconst_null
    //   33: aload 4
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: invokevirtual 317	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnonnull +24 -> 68
    //   47: aload_2
    //   48: ifnull +18 -> 66
    //   51: aload_2
    //   52: invokeinterface 320 1 0
    //   57: ifne +9 -> 66
    //   60: aload_2
    //   61: invokeinterface 323 1 0
    //   66: aconst_null
    //   67: areturn
    //   68: new 184	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   75: astore 5
    //   77: new 325	java/util/ArrayList
    //   80: dup
    //   81: invokespecial 326	java/util/ArrayList:<init>	()V
    //   84: astore 6
    //   86: aload_2
    //   87: invokeinterface 329 1 0
    //   92: ifeq +142 -> 234
    //   95: aload_2
    //   96: invokestatic 331	com/tencent/bugly/proguard/o:b	(Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/q;
    //   99: astore 7
    //   101: aload 7
    //   103: ifnull +49 -> 152
    //   106: aload 6
    //   108: aload 7
    //   110: invokeinterface 335 2 0
    //   115: pop
    //   116: goto -30 -> 86
    //   119: astore_3
    //   120: aload_3
    //   121: invokestatic 52	com/tencent/bugly/proguard/w:a	(Ljava/lang/Throwable;)Z
    //   124: ifne +7 -> 131
    //   127: aload_3
    //   128: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   131: aload_2
    //   132: ifnull +18 -> 150
    //   135: aload_2
    //   136: invokeinterface 320 1 0
    //   141: ifne +9 -> 150
    //   144: aload_2
    //   145: invokeinterface 323 1 0
    //   150: aconst_null
    //   151: areturn
    //   152: aload_2
    //   153: aload_2
    //   154: ldc 106
    //   156: invokeinterface 97 2 0
    //   161: invokeinterface 119 2 0
    //   166: astore 7
    //   168: aload 5
    //   170: ldc_w 337
    //   173: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc -63
    //   178: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 7
    //   183: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: goto -101 -> 86
    //   190: astore 7
    //   192: ldc_w 339
    //   195: iconst_0
    //   196: anewarray 4	java/lang/Object
    //   199: invokestatic 75	com/tencent/bugly/proguard/w:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   202: pop
    //   203: goto -117 -> 86
    //   206: astore 4
    //   208: aload_2
    //   209: astore_3
    //   210: aload 4
    //   212: astore_2
    //   213: aload_3
    //   214: ifnull +18 -> 232
    //   217: aload_3
    //   218: invokeinterface 320 1 0
    //   223: ifne +9 -> 232
    //   226: aload_3
    //   227: invokeinterface 323 1 0
    //   232: aload_2
    //   233: athrow
    //   234: aload 5
    //   236: invokevirtual 340	java/lang/StringBuilder:length	()I
    //   239: ifle +56 -> 295
    //   242: aload 5
    //   244: ldc_w 342
    //   247: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc -63
    //   252: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: iload_1
    //   256: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: ldc_w 344
    //   263: iconst_2
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: ldc -19
    //   271: aastore
    //   272: dup
    //   273: iconst_1
    //   274: aload_3
    //   275: ldc -19
    //   277: aload 4
    //   279: iconst_4
    //   280: invokevirtual 208	java/lang/String:substring	(I)Ljava/lang/String;
    //   283: aconst_null
    //   284: invokevirtual 47	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   287: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   290: aastore
    //   291: invokestatic 75	com/tencent/bugly/proguard/w:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   294: pop
    //   295: aload_2
    //   296: ifnull +18 -> 314
    //   299: aload_2
    //   300: invokeinterface 320 1 0
    //   305: ifne +9 -> 314
    //   308: aload_2
    //   309: invokeinterface 323 1 0
    //   314: aload 6
    //   316: areturn
    //   317: astore_2
    //   318: aconst_null
    //   319: astore_3
    //   320: goto -107 -> 213
    //   323: astore 4
    //   325: aload_2
    //   326: astore_3
    //   327: aload 4
    //   329: astore_2
    //   330: goto -117 -> 213
    //   333: astore_3
    //   334: aconst_null
    //   335: astore_2
    //   336: goto -216 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	o
    //   0	339	1	paramInt	int
    //   42	267	2	localObject1	Object
    //   317	9	2	localObject2	Object
    //   329	7	2	localObject3	Object
    //   6	24	3	localSQLiteDatabase	SQLiteDatabase
    //   119	9	3	localThrowable1	Throwable
    //   209	118	3	localObject4	Object
    //   333	1	3	localThrowable2	Throwable
    //   27	7	4	str	String
    //   206	72	4	localObject5	Object
    //   323	5	4	localObject6	Object
    //   75	168	5	localStringBuilder	StringBuilder
    //   84	231	6	localArrayList	java.util.ArrayList
    //   99	83	7	localObject7	Object
    //   190	1	7	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   68	86	119	java/lang/Throwable
    //   86	101	119	java/lang/Throwable
    //   106	116	119	java/lang/Throwable
    //   192	203	119	java/lang/Throwable
    //   234	295	119	java/lang/Throwable
    //   152	187	190	java/lang/Throwable
    //   68	86	206	finally
    //   86	101	206	finally
    //   106	116	206	finally
    //   152	187	206	finally
    //   192	203	206	finally
    //   234	295	206	finally
    //   0	7	317	finally
    //   11	43	317	finally
    //   120	131	323	finally
    //   0	7	333	java/lang/Throwable
    //   11	43	333	java/lang/Throwable
  }
  
  private static ContentValues d(q paramq)
  {
    Object localObject;
    int i;
    if (paramq != null)
    {
      localObject = paramq.f;
      if ((localObject != null) && (((String)localObject).trim().length() > 0))
      {
        i = 0;
        if (i == 0) {
          break label38;
        }
      }
    }
    else
    {
      localObject = null;
    }
    for (;;)
    {
      return (ContentValues)localObject;
      i = 1;
      break;
      try
      {
        label38:
        ContentValues localContentValues = new ContentValues();
        if (paramq.a > 0L) {
          localContentValues.put("_id", Long.valueOf(paramq.a));
        }
        localContentValues.put("_tp", paramq.f);
        localContentValues.put("_tm", Long.valueOf(paramq.e));
        localObject = localContentValues;
        if (paramq.g != null)
        {
          localContentValues.put("_dt", paramq.g);
          return localContentValues;
        }
      }
      catch (Throwable paramq)
      {
        if (!w.a(paramq)) {
          paramq.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public final int a(int paramInt, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder("_id = ").append(paramInt).append(" and _pc").append(" = '").append(paramString).append("' ");
    if (paramLong == 0L) {}
    for (paramString = "";; paramString = " and _tm < " + paramLong) {
      return a("t_crd", paramString, null, null);
    }
  }
  
  public final int a(String paramString1, String paramString2, String[] paramArrayOfString, n paramn, boolean paramBoolean)
  {
    return a(paramString1, paramString2, null, null);
  }
  
  public final long a(String paramString, ContentValues paramContentValues, n paramn, boolean paramBoolean)
  {
    return a(paramString, paramContentValues, null);
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, n paramn, boolean paramBoolean)
  {
    return a(false, paramString1, paramArrayOfString1, paramString2, null, null, null, null, null, null);
  }
  
  /* Error */
  public final l a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 18	com/tencent/bugly/proguard/o:b	Lcom/tencent/bugly/proguard/p;
    //   5: invokevirtual 41	com/tencent/bugly/proguard/p:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore 4
    //   10: aload 4
    //   12: ifnull +86 -> 98
    //   15: aload 4
    //   17: ldc_w 356
    //   20: aconst_null
    //   21: new 184	java/lang/StringBuilder
    //   24: dup
    //   25: ldc -27
    //   27: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: iload_1
    //   31: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: ldc_w 348
    //   37: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 350
    //   43: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_2
    //   47: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 364
    //   53: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 366
    //   59: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: ldc_w 368
    //   71: invokevirtual 317	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore_2
    //   75: aload_2
    //   76: ifnonnull +24 -> 100
    //   79: aload_2
    //   80: ifnull +18 -> 98
    //   83: aload_2
    //   84: invokeinterface 320 1 0
    //   89: ifne +9 -> 98
    //   92: aload_2
    //   93: invokeinterface 323 1 0
    //   98: aconst_null
    //   99: areturn
    //   100: aload_2
    //   101: ifnull +119 -> 220
    //   104: aload_2
    //   105: astore_3
    //   106: aload_2
    //   107: invokeinterface 371 1 0
    //   112: ifeq +108 -> 220
    //   115: aload_2
    //   116: astore_3
    //   117: aload_2
    //   118: invokestatic 373	com/tencent/bugly/proguard/o:c	(Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/l;
    //   121: astore 4
    //   123: aload 4
    //   125: astore_3
    //   126: aload_2
    //   127: ifnull +18 -> 145
    //   130: aload_2
    //   131: invokeinterface 320 1 0
    //   136: ifne +9 -> 145
    //   139: aload_2
    //   140: invokeinterface 323 1 0
    //   145: aload_3
    //   146: areturn
    //   147: astore 4
    //   149: aconst_null
    //   150: astore_2
    //   151: aload_2
    //   152: astore_3
    //   153: aload 4
    //   155: invokestatic 52	com/tencent/bugly/proguard/w:a	(Ljava/lang/Throwable;)Z
    //   158: ifne +10 -> 168
    //   161: aload_2
    //   162: astore_3
    //   163: aload 4
    //   165: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   168: aload_2
    //   169: ifnull -71 -> 98
    //   172: aload_2
    //   173: invokeinterface 320 1 0
    //   178: ifne -80 -> 98
    //   181: aload_2
    //   182: invokeinterface 323 1 0
    //   187: aconst_null
    //   188: areturn
    //   189: astore_2
    //   190: aload_3
    //   191: ifnull +18 -> 209
    //   194: aload_3
    //   195: invokeinterface 320 1 0
    //   200: ifne +9 -> 209
    //   203: aload_3
    //   204: invokeinterface 323 1 0
    //   209: aload_2
    //   210: athrow
    //   211: astore_2
    //   212: goto -22 -> 190
    //   215: astore 4
    //   217: goto -66 -> 151
    //   220: aconst_null
    //   221: astore_3
    //   222: goto -96 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	o
    //   0	225	1	paramInt	int
    //   0	225	2	paramString	String
    //   1	221	3	localObject1	Object
    //   8	116	4	localObject2	Object
    //   147	17	4	localThrowable1	Throwable
    //   215	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   15	75	147	java/lang/Throwable
    //   15	75	189	finally
    //   106	115	211	finally
    //   117	123	211	finally
    //   153	161	211	finally
    //   163	168	211	finally
    //   106	115	215	java/lang/Throwable
    //   117	123	215	java/lang/Throwable
  }
  
  /* Error */
  public final List<q> a(int paramInt)
  {
    // Byte code:
    //   0: getstatic 18	com/tencent/bugly/proguard/o:b	Lcom/tencent/bugly/proguard/p;
    //   3: invokevirtual 41	com/tencent/bugly/proguard/p:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +150 -> 158
    //   11: iload_1
    //   12: iflt +59 -> 71
    //   15: new 184	java/lang/StringBuilder
    //   18: dup
    //   19: ldc_w 304
    //   22: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: iload_1
    //   26: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_2
    //   33: aload_3
    //   34: ldc -40
    //   36: aconst_null
    //   37: aload_2
    //   38: aconst_null
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: invokevirtual 317	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_2
    //   46: aload_2
    //   47: ifnonnull +29 -> 76
    //   50: aload_2
    //   51: ifnull +18 -> 69
    //   54: aload_2
    //   55: invokeinterface 320 1 0
    //   60: ifne +9 -> 69
    //   63: aload_2
    //   64: invokeinterface 323 1 0
    //   69: aconst_null
    //   70: areturn
    //   71: aconst_null
    //   72: astore_2
    //   73: goto -40 -> 33
    //   76: new 184	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   83: astore 5
    //   85: new 325	java/util/ArrayList
    //   88: dup
    //   89: invokespecial 326	java/util/ArrayList:<init>	()V
    //   92: astore 4
    //   94: aload_2
    //   95: invokeinterface 329 1 0
    //   100: ifeq +141 -> 241
    //   103: aload_2
    //   104: invokestatic 375	com/tencent/bugly/proguard/o:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/q;
    //   107: astore 6
    //   109: aload 6
    //   111: ifnull +49 -> 160
    //   114: aload 4
    //   116: aload 6
    //   118: invokeinterface 335 2 0
    //   123: pop
    //   124: goto -30 -> 94
    //   127: astore_3
    //   128: aload_3
    //   129: invokestatic 52	com/tencent/bugly/proguard/w:a	(Ljava/lang/Throwable;)Z
    //   132: ifne +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   139: aload_2
    //   140: ifnull +18 -> 158
    //   143: aload_2
    //   144: invokeinterface 320 1 0
    //   149: ifne +9 -> 158
    //   152: aload_2
    //   153: invokeinterface 323 1 0
    //   158: aconst_null
    //   159: areturn
    //   160: aload_2
    //   161: aload_2
    //   162: ldc 61
    //   164: invokeinterface 97 2 0
    //   169: invokeinterface 101 2 0
    //   174: lstore 7
    //   176: aload 5
    //   178: ldc -69
    //   180: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc -63
    //   185: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: lload 7
    //   190: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: goto -100 -> 94
    //   197: astore 6
    //   199: ldc_w 339
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 75	com/tencent/bugly/proguard/w:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   209: pop
    //   210: goto -116 -> 94
    //   213: astore 4
    //   215: aload_2
    //   216: astore_3
    //   217: aload 4
    //   219: astore_2
    //   220: aload_3
    //   221: ifnull +18 -> 239
    //   224: aload_3
    //   225: invokeinterface 320 1 0
    //   230: ifne +9 -> 239
    //   233: aload_3
    //   234: invokeinterface 323 1 0
    //   239: aload_2
    //   240: athrow
    //   241: aload 5
    //   243: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: astore 5
    //   248: aload 5
    //   250: invokevirtual 205	java/lang/String:length	()I
    //   253: ifle +38 -> 291
    //   256: ldc_w 344
    //   259: iconst_2
    //   260: anewarray 4	java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: ldc -40
    //   267: aastore
    //   268: dup
    //   269: iconst_1
    //   270: aload_3
    //   271: ldc -40
    //   273: aload 5
    //   275: iconst_4
    //   276: invokevirtual 208	java/lang/String:substring	(I)Ljava/lang/String;
    //   279: aconst_null
    //   280: invokevirtual 47	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   283: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   286: aastore
    //   287: invokestatic 75	com/tencent/bugly/proguard/w:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   290: pop
    //   291: aload_2
    //   292: ifnull +18 -> 310
    //   295: aload_2
    //   296: invokeinterface 320 1 0
    //   301: ifne +9 -> 310
    //   304: aload_2
    //   305: invokeinterface 323 1 0
    //   310: aload 4
    //   312: areturn
    //   313: astore_2
    //   314: aconst_null
    //   315: astore_3
    //   316: goto -96 -> 220
    //   319: astore 4
    //   321: aload_2
    //   322: astore_3
    //   323: aload 4
    //   325: astore_2
    //   326: goto -106 -> 220
    //   329: astore_3
    //   330: aconst_null
    //   331: astore_2
    //   332: goto -204 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	o
    //   0	335	1	paramInt	int
    //   32	273	2	localObject1	Object
    //   313	9	2	localObject2	Object
    //   325	7	2	localObject3	Object
    //   6	28	3	localSQLiteDatabase	SQLiteDatabase
    //   127	9	3	localThrowable1	Throwable
    //   216	107	3	localObject4	Object
    //   329	1	3	localThrowable2	Throwable
    //   92	23	4	localArrayList	java.util.ArrayList
    //   213	98	4	localList	List<q>
    //   319	5	4	localObject5	Object
    //   83	191	5	localObject6	Object
    //   107	10	6	localq	q
    //   197	1	6	localThrowable3	Throwable
    //   174	15	7	l	long
    // Exception table:
    //   from	to	target	type
    //   76	94	127	java/lang/Throwable
    //   94	109	127	java/lang/Throwable
    //   114	124	127	java/lang/Throwable
    //   199	210	127	java/lang/Throwable
    //   241	291	127	java/lang/Throwable
    //   160	194	197	java/lang/Throwable
    //   76	94	213	finally
    //   94	109	213	finally
    //   114	124	213	finally
    //   160	194	213	finally
    //   199	210	213	finally
    //   241	291	213	finally
    //   15	33	313	finally
    //   33	46	313	finally
    //   128	139	319	finally
    //   15	33	329	java/lang/Throwable
    //   33	46	329	java/lang/Throwable
  }
  
  /* Error */
  public final List<l> a(int paramInt, String paramString1, long paramLong, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: getstatic 18	com/tencent/bugly/proguard/o:b	Lcom/tencent/bugly/proguard/p;
    //   6: invokevirtual 41	com/tencent/bugly/proguard/p:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore 7
    //   11: aload 7
    //   13: ifnull +250 -> 263
    //   16: new 184	java/lang/StringBuilder
    //   19: dup
    //   20: ldc -27
    //   22: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: iload_1
    //   26: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   29: ldc_w 348
    //   32: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc_w 350
    //   38: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_2
    //   42: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc_w 364
    //   48: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc_w 378
    //   54: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 380
    //   60: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload 5
    //   65: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc_w 352
    //   71: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: astore 5
    //   76: lload_3
    //   77: lconst_0
    //   78: lcmp
    //   79: ifeq +78 -> 157
    //   82: new 184	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 382
    //   89: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: lload_3
    //   93: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   96: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore_2
    //   100: aload 7
    //   102: ldc_w 356
    //   105: aconst_null
    //   106: aload 5
    //   108: aload_2
    //   109: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: aconst_null
    //   116: aconst_null
    //   117: aconst_null
    //   118: ldc_w 384
    //   121: invokevirtual 317	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   124: astore 5
    //   126: aload 5
    //   128: ifnonnull +36 -> 164
    //   131: aload 5
    //   133: ifnull +20 -> 153
    //   136: aload 5
    //   138: invokeinterface 320 1 0
    //   143: ifne +10 -> 153
    //   146: aload 5
    //   148: invokeinterface 323 1 0
    //   153: aconst_null
    //   154: astore_2
    //   155: aload_2
    //   156: areturn
    //   157: ldc_w 354
    //   160: astore_2
    //   161: goto -61 -> 100
    //   164: aload 5
    //   166: astore_2
    //   167: new 325	java/util/ArrayList
    //   170: dup
    //   171: invokespecial 326	java/util/ArrayList:<init>	()V
    //   174: astore 6
    //   176: aload 5
    //   178: astore_2
    //   179: aload 5
    //   181: invokeinterface 329 1 0
    //   186: ifeq +79 -> 265
    //   189: aload 5
    //   191: astore_2
    //   192: aload 5
    //   194: invokestatic 373	com/tencent/bugly/proguard/o:c	(Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/l;
    //   197: astore 7
    //   199: aload 7
    //   201: ifnull -25 -> 176
    //   204: aload 5
    //   206: astore_2
    //   207: aload 6
    //   209: aload 7
    //   211: invokeinterface 335 2 0
    //   216: pop
    //   217: goto -41 -> 176
    //   220: astore 6
    //   222: aload 5
    //   224: astore_2
    //   225: aload 6
    //   227: invokestatic 52	com/tencent/bugly/proguard/w:a	(Ljava/lang/Throwable;)Z
    //   230: ifne +11 -> 241
    //   233: aload 5
    //   235: astore_2
    //   236: aload 6
    //   238: invokevirtual 55	java/lang/Throwable:printStackTrace	()V
    //   241: aload 5
    //   243: ifnull +20 -> 263
    //   246: aload 5
    //   248: invokeinterface 320 1 0
    //   253: ifne +10 -> 263
    //   256: aload 5
    //   258: invokeinterface 323 1 0
    //   263: aconst_null
    //   264: areturn
    //   265: aload 6
    //   267: astore_2
    //   268: aload 5
    //   270: ifnull -115 -> 155
    //   273: aload 6
    //   275: astore_2
    //   276: aload 5
    //   278: invokeinterface 320 1 0
    //   283: ifne -128 -> 155
    //   286: aload 5
    //   288: invokeinterface 323 1 0
    //   293: aload 6
    //   295: areturn
    //   296: astore_2
    //   297: aload 6
    //   299: astore 5
    //   301: aload 5
    //   303: ifnull +20 -> 323
    //   306: aload 5
    //   308: invokeinterface 320 1 0
    //   313: ifne +10 -> 323
    //   316: aload 5
    //   318: invokeinterface 323 1 0
    //   323: aload_2
    //   324: athrow
    //   325: astore 6
    //   327: aload_2
    //   328: astore 5
    //   330: aload 6
    //   332: astore_2
    //   333: goto -32 -> 301
    //   336: astore 6
    //   338: aconst_null
    //   339: astore 5
    //   341: goto -119 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	o
    //   0	344	1	paramInt	int
    //   0	344	2	paramString1	String
    //   0	344	3	paramLong	long
    //   0	344	5	paramString2	String
    //   1	207	6	localArrayList	java.util.ArrayList
    //   220	78	6	localThrowable1	Throwable
    //   325	6	6	localObject1	Object
    //   336	1	6	localThrowable2	Throwable
    //   9	201	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   167	176	220	java/lang/Throwable
    //   179	189	220	java/lang/Throwable
    //   192	199	220	java/lang/Throwable
    //   207	217	220	java/lang/Throwable
    //   16	76	296	finally
    //   82	100	296	finally
    //   100	126	296	finally
    //   167	176	325	finally
    //   179	189	325	finally
    //   192	199	325	finally
    //   207	217	325	finally
    //   225	233	325	finally
    //   236	241	325	finally
    //   16	76	336	java/lang/Throwable
    //   82	100	336	java/lang/Throwable
    //   100	126	336	java/lang/Throwable
  }
  
  public final Map<String, byte[]> a(int paramInt, n paramn, boolean paramBoolean)
  {
    return a(paramInt, null);
  }
  
  public final boolean a(int paramInt, String paramString, n paramn, boolean paramBoolean)
  {
    return a(555, paramString, null);
  }
  
  public final boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, n paramn, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      paramn = new a(4, null);
      paramn.a(paramInt, paramString, paramArrayOfByte);
      v.a().b(paramn);
      return true;
    }
    return a(paramInt, paramString, paramArrayOfByte, null);
  }
  
  public final boolean a(l paraml)
  {
    if (paraml == null) {}
    for (;;)
    {
      return false;
      try
      {
        SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
        if (localSQLiteDatabase == null) {
          continue;
        }
        ContentValues localContentValues = b(paraml);
        if (localContentValues == null) {
          continue;
        }
        long l = localSQLiteDatabase.replace("t_crd", "_id", localContentValues);
        if (l < 0L) {
          continue;
        }
        w.c("insert %s success!", new Object[] { "t_crd" });
        paraml.a = l;
        return true;
      }
      catch (Throwable paraml)
      {
        paraml = paraml;
        if (w.a(paraml)) {
          continue;
        }
        paraml.printStackTrace();
        return false;
      }
      finally {}
    }
  }
  
  public final boolean a(q paramq)
  {
    if (paramq == null) {}
    for (;;)
    {
      return false;
      try
      {
        SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
        if (localSQLiteDatabase == null) {
          continue;
        }
        ContentValues localContentValues = c(paramq);
        if (localContentValues == null) {
          continue;
        }
        long l = localSQLiteDatabase.replace("t_lr", "_id", localContentValues);
        if (l < 0L) {
          continue;
        }
        w.c("insert %s success!", new Object[] { "t_lr" });
        paramq.a = l;
        return true;
      }
      catch (Throwable paramq)
      {
        paramq = paramq;
        if (w.a(paramq)) {
          continue;
        }
        paramq.printStackTrace();
        return false;
      }
      finally {}
    }
  }
  
  public final int b()
  {
    StringBuilder localStringBuilder = new StringBuilder("_fl = 0 or _sv <> '");
    com.tencent.bugly.crashreport.common.info.a.a().getClass();
    return a("t_crd", "2.1.9'", null, null);
  }
  
  final class a
    extends Thread
  {
    private int a;
    private n b;
    private String c;
    private ContentValues d;
    private boolean e;
    private String[] f;
    private String g;
    private String[] h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String[] n;
    private int o;
    private String p;
    private byte[] q;
    
    public a(int paramInt, n paramn)
    {
      this.a = paramInt;
      this.b = paramn;
    }
    
    public final void a(int paramInt, String paramString, byte[] paramArrayOfByte)
    {
      this.o = paramInt;
      this.p = paramString;
      this.q = paramArrayOfByte;
    }
    
    public final void a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.e = paramBoolean;
      this.c = paramString1;
      this.f = paramArrayOfString1;
      this.g = paramString2;
      this.h = paramArrayOfString2;
      this.i = paramString3;
      this.j = paramString4;
      this.k = paramString5;
      this.l = paramString6;
    }
    
    public final void run()
    {
      switch (this.a)
      {
      default: 
        return;
      case 1: 
        o.a(o.this, this.c, this.d, this.b);
        return;
      case 2: 
        o.a(o.this, this.c, this.m, this.n, this.b);
        return;
      case 3: 
        o.a(o.this, this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
        return;
      case 4: 
        o.a(o.this, this.o, this.p, this.q, this.b);
        return;
      case 5: 
        o.a(o.this, this.o, this.b);
        return;
      }
      o localo = o.this;
      o.a(this.o, this.p, this.b);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\bugly\proguard\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */