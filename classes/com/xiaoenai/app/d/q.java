package com.xiaoenai.app.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.chat.messagelist.message.b.k;
import com.xiaoenai.app.classes.chat.messagelist.message.model.c;
import com.xiaoenai.app.d.a.b;

public class q
  extends b
{
  public q()
  {
    super("message.db", b, 4);
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where tbl_name = \"" + paramString1 + "\" and type = 'table'", null);
      bool = false;
      paramSQLiteDatabase.printStackTrace();
    }
    catch (Exception paramSQLiteDatabase)
    {
      try
      {
        while (paramSQLiteDatabase.moveToNext())
        {
          paramString1 = paramSQLiteDatabase.getString(0);
          if ((paramString1 != null) && (paramString1.contains(paramString2))) {
            bool = true;
          }
        }
        paramSQLiteDatabase.close();
        return bool;
      }
      catch (Exception paramSQLiteDatabase)
      {
        boolean bool;
        for (;;) {}
      }
      paramSQLiteDatabase = paramSQLiteDatabase;
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public long a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 69	com/xiaoenai/app/d/q:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore_1
    //   5: aload_1
    //   6: ldc 71
    //   8: aconst_null
    //   9: invokevirtual 42	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   12: astore_2
    //   13: lconst_0
    //   14: lstore_3
    //   15: aload_2
    //   16: invokeinterface 48 1 0
    //   21: ifeq +25 -> 46
    //   24: aload_2
    //   25: aload_2
    //   26: ldc 73
    //   28: invokeinterface 77 2 0
    //   33: invokeinterface 81 2 0
    //   38: lstore 5
    //   40: lload 5
    //   42: lstore_3
    //   43: goto -28 -> 15
    //   46: aload_2
    //   47: invokeinterface 61 1 0
    //   52: aload_1
    //   53: invokevirtual 82	android/database/sqlite/SQLiteDatabase:close	()V
    //   56: lload_3
    //   57: lreturn
    //   58: astore_1
    //   59: lconst_0
    //   60: lstore_3
    //   61: aload_1
    //   62: invokevirtual 64	java/lang/Exception:printStackTrace	()V
    //   65: lload_3
    //   66: lreturn
    //   67: astore_1
    //   68: goto -7 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	q
    //   4	49	1	localSQLiteDatabase	SQLiteDatabase
    //   58	4	1	localException1	Exception
    //   67	1	1	localException2	Exception
    //   12	35	2	localCursor	Cursor
    //   14	52	3	l1	long
    //   38	3	5	l2	long
    // Exception table:
    //   from	to	target	type
    //   0	13	58	java/lang/Exception
    //   15	40	67	java/lang/Exception
    //   46	56	67	java/lang/Exception
  }
  
  /* Error */
  public java.util.Vector<com.xiaoenai.app.classes.chat.messagelist.message.a.a> a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 22	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   9: ldc 85
    //   11: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: iload_1
    //   15: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18: ldc 90
    //   20: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_2
    //   24: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore 4
    //   32: aload_0
    //   33: invokevirtual 69	com/xiaoenai/app/d/q:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore_3
    //   37: aload_3
    //   38: ldc 92
    //   40: aconst_null
    //   41: ldc 94
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: aload 4
    //   48: invokevirtual 98	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore 4
    //   53: new 100	java/util/Vector
    //   56: dup
    //   57: invokespecial 101	java/util/Vector:<init>	()V
    //   60: astore 5
    //   62: aload 4
    //   64: invokeinterface 105 1 0
    //   69: ifle +282 -> 351
    //   72: aload 4
    //   74: invokeinterface 108 1 0
    //   79: pop
    //   80: aload 4
    //   82: aload 4
    //   84: ldc 110
    //   86: invokeinterface 77 2 0
    //   91: invokeinterface 52 2 0
    //   96: astore 6
    //   98: aload 4
    //   100: aload 4
    //   102: ldc 112
    //   104: invokeinterface 77 2 0
    //   109: invokeinterface 52 2 0
    //   114: invokestatic 118	com/xiaoenai/app/utils/b/a:d	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 7
    //   119: aload 6
    //   121: aload 6
    //   123: aload 7
    //   125: invokestatic 123	com/xiaoenai/app/classes/chat/messagelist/message/b/k:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   128: aload 6
    //   130: aload 7
    //   132: invokestatic 126	com/xiaoenai/app/classes/chat/messagelist/message/model/c:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   135: invokestatic 129	com/xiaoenai/app/classes/chat/messagelist/message/b/k:a	(Ljava/lang/String;ZZ)Lcom/xiaoenai/app/classes/chat/messagelist/message/a/a;
    //   138: astore 8
    //   140: aload 8
    //   142: ifnull +199 -> 341
    //   145: aload 8
    //   147: aload 4
    //   149: aload 4
    //   151: ldc -125
    //   153: invokeinterface 77 2 0
    //   158: invokeinterface 81 2 0
    //   163: invokevirtual 136	com/xiaoenai/app/classes/chat/messagelist/message/a/a:a	(J)V
    //   166: aload 8
    //   168: aload 4
    //   170: aload 4
    //   172: ldc -118
    //   174: invokeinterface 77 2 0
    //   179: invokeinterface 81 2 0
    //   184: invokevirtual 140	com/xiaoenai/app/classes/chat/messagelist/message/a/a:b	(J)V
    //   187: aload 8
    //   189: aload 7
    //   191: invokevirtual 143	com/xiaoenai/app/classes/chat/messagelist/message/a/a:b	(Ljava/lang/String;)V
    //   194: aload 8
    //   196: aload 4
    //   198: aload 4
    //   200: ldc -111
    //   202: invokeinterface 77 2 0
    //   207: invokeinterface 149 2 0
    //   212: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: invokevirtual 158	com/xiaoenai/app/classes/chat/messagelist/message/a/a:a	(Ljava/lang/Integer;)V
    //   218: aload 8
    //   220: aload 4
    //   222: aload 4
    //   224: ldc -96
    //   226: invokeinterface 77 2 0
    //   231: invokeinterface 149 2 0
    //   236: invokevirtual 163	com/xiaoenai/app/classes/chat/messagelist/message/a/a:a	(I)V
    //   239: aload 4
    //   241: aload 4
    //   243: ldc -91
    //   245: invokeinterface 77 2 0
    //   250: invokeinterface 149 2 0
    //   255: istore_2
    //   256: iload_2
    //   257: istore_1
    //   258: iload_2
    //   259: iconst_m1
    //   260: if_icmpne +6 -> 266
    //   263: bipush -2
    //   265: istore_1
    //   266: aload 8
    //   268: iload_1
    //   269: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: invokevirtual 167	com/xiaoenai/app/classes/chat/messagelist/message/a/a:b	(Ljava/lang/Integer;)V
    //   275: aload 8
    //   277: aload 6
    //   279: invokevirtual 169	com/xiaoenai/app/classes/chat/messagelist/message/a/a:a	(Ljava/lang/String;)V
    //   282: aload 8
    //   284: aload 4
    //   286: aload 4
    //   288: ldc 73
    //   290: invokeinterface 77 2 0
    //   295: invokeinterface 81 2 0
    //   300: invokevirtual 172	com/xiaoenai/app/classes/chat/messagelist/message/a/a:c	(J)V
    //   303: iconst_1
    //   304: aload 4
    //   306: aload 4
    //   308: ldc -82
    //   310: invokeinterface 77 2 0
    //   315: invokeinterface 149 2 0
    //   320: if_icmpne +47 -> 367
    //   323: iconst_1
    //   324: istore 9
    //   326: aload 8
    //   328: iload 9
    //   330: invokevirtual 177	com/xiaoenai/app/classes/chat/messagelist/message/a/a:a	(Z)V
    //   333: aload 5
    //   335: iconst_0
    //   336: aload 8
    //   338: invokevirtual 181	java/util/Vector:add	(ILjava/lang/Object;)V
    //   341: aload 4
    //   343: invokeinterface 48 1 0
    //   348: ifne -268 -> 80
    //   351: aload 4
    //   353: invokeinterface 61 1 0
    //   358: aload_3
    //   359: invokevirtual 82	android/database/sqlite/SQLiteDatabase:close	()V
    //   362: aload_0
    //   363: monitorexit
    //   364: aload 5
    //   366: areturn
    //   367: iconst_0
    //   368: istore 9
    //   370: goto -44 -> 326
    //   373: astore_3
    //   374: aload_0
    //   375: monitorexit
    //   376: aload_3
    //   377: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	this	q
    //   0	378	1	paramInt1	int
    //   0	378	2	paramInt2	int
    //   36	323	3	localSQLiteDatabase	SQLiteDatabase
    //   373	4	3	localObject1	Object
    //   30	322	4	localObject2	Object
    //   60	305	5	localVector	java.util.Vector
    //   96	182	6	str1	String
    //   117	73	7	str2	String
    //   138	199	8	locala	com.xiaoenai.app.classes.chat.messagelist.message.a.a
    //   324	45	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	80	373	finally
    //   80	140	373	finally
    //   145	256	373	finally
    //   266	323	373	finally
    //   326	341	373	finally
    //   341	351	373	finally
    //   351	362	373	finally
  }
  
  public void a(long paramLong)
  {
    a(new t(this, paramLong));
  }
  
  public void a(long paramLong1, Integer paramInteger, long paramLong2)
  {
    a(new s(this, paramInteger, paramLong2, paramLong1));
  }
  
  public void a(com.xiaoenai.app.classes.chat.messagelist.message.a.a parama)
  {
    a(new r(this, parama));
  }
  
  public com.xiaoenai.app.classes.chat.messagelist.message.a.a b(long paramLong)
  {
    Object localObject = null;
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("messages", null, "message_id=?", new String[] { String.valueOf(paramLong) }, null, null, "message_id DESC");
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      String str1 = localCursor.getString(localCursor.getColumnIndex("types"));
      String str2 = com.xiaoenai.app.utils.b.a.d(localCursor.getString(localCursor.getColumnIndex("content")));
      com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = k.a(str1, k.a(str1, str2), c.a(str1, str2));
      localObject = locala;
      if (locala != null)
      {
        locala.a(localCursor.getLong(localCursor.getColumnIndex("_id")));
        locala.b(localCursor.getLong(localCursor.getColumnIndex("message_id")));
        locala.b(str2);
        locala.a(Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex("sender_id"))));
        locala.a(localCursor.getInt(localCursor.getColumnIndex("ts")));
        int j = localCursor.getInt(localCursor.getColumnIndex("status"));
        int i = j;
        if (j == -1) {
          i = -2;
        }
        locala.b(Integer.valueOf(i));
        locala.a(str1);
        localObject = locala;
      }
    }
    localCursor.close();
    localSQLiteDatabase.close();
    return (com.xiaoenai.app.classes.chat.messagelist.message.a.a)localObject;
  }
  
  public void b()
  {
    a(new u(this));
  }
  
  /* Error */
  public long c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 69	com/xiaoenai/app/d/q:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore_1
    //   5: aload_1
    //   6: ldc -38
    //   8: aconst_null
    //   9: invokevirtual 42	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   12: astore_2
    //   13: lconst_0
    //   14: lstore_3
    //   15: aload_2
    //   16: invokeinterface 48 1 0
    //   21: ifeq +25 -> 46
    //   24: aload_2
    //   25: aload_2
    //   26: ldc -118
    //   28: invokeinterface 77 2 0
    //   33: invokeinterface 81 2 0
    //   38: lstore 5
    //   40: lload 5
    //   42: lstore_3
    //   43: goto -28 -> 15
    //   46: aload_2
    //   47: invokeinterface 61 1 0
    //   52: aload_1
    //   53: invokevirtual 82	android/database/sqlite/SQLiteDatabase:close	()V
    //   56: lload_3
    //   57: lreturn
    //   58: astore_1
    //   59: lconst_0
    //   60: lstore_3
    //   61: aload_1
    //   62: invokevirtual 64	java/lang/Exception:printStackTrace	()V
    //   65: lload_3
    //   66: lreturn
    //   67: astore_1
    //   68: goto -7 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	q
    //   4	49	1	localSQLiteDatabase	SQLiteDatabase
    //   58	4	1	localException1	Exception
    //   67	1	1	localException2	Exception
    //   12	35	2	localCursor	Cursor
    //   14	52	3	l1	long
    //   38	3	5	l2	long
    // Exception table:
    //   from	to	target	type
    //   0	13	58	java/lang/Exception
    //   15	40	67	java/lang/Exception
    //   46	56	67	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS messages (_id INTEGER PRIMARY KEY autoincrement,sender_id INTEGER,message_id BIGINT,types VARCHAR(10),content TEXT,status INTEGER,ts INTEGER,played INTEGER NOT NULL DEFAULT 0,read_ts BIGINT NOT NULL DEFAULT 0,deleted INTEGER NOT NULL DEFAULT 0);");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    com.xiaoenai.app.utils.f.a.c("oldVersion = {} newVersion = {} ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((2 == paramInt2) && (!a(paramSQLiteDatabase, "messages", "read_ts"))) {}
    for (;;)
    {
      try
      {
        paramSQLiteDatabase.execSQL("ALTER TABLE 'messages' ADD COLUMN read_ts BIGINT NOT NULL DEFAULT 0");
        com.xiaoenai.app.utils.f.a.c("oldVersion = {} newVersion = {} ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        paramSQLiteDatabase.printStackTrace();
        continue;
      }
      if (3 == paramInt2)
      {
        if (2 == paramInt1) {
          try
          {
            paramSQLiteDatabase.execSQL("ALTER TABLE 'messages' ADD COLUMN deleted INTEGER NOT NULL DEFAULT 0");
          }
          catch (Exception paramSQLiteDatabase)
          {
            paramSQLiteDatabase.printStackTrace();
          }
        } else if (1 == paramInt1) {
          try
          {
            paramSQLiteDatabase.execSQL("ALTER TABLE 'messages' ADD COLUMN read_ts BIGINT NOT NULL DEFAULT 0");
            paramSQLiteDatabase.execSQL("ALTER TABLE 'messages' ADD COLUMN deleted INTEGER NOT NULL DEFAULT 0");
          }
          catch (Exception paramSQLiteDatabase)
          {
            paramSQLiteDatabase.printStackTrace();
          }
        }
      }
      else if (4 == paramInt2) {
        if (3 == paramInt1) {
          try
          {
            paramSQLiteDatabase.execSQL("ALTER TABLE 'messages' ADD COLUMN played INTEGER NOT NULL DEFAULT 0");
          }
          catch (Exception paramSQLiteDatabase)
          {
            paramSQLiteDatabase.printStackTrace();
          }
        } else if (2 == paramInt1) {
          try
          {
            paramSQLiteDatabase.execSQL("ALTER TABLE 'messages' ADD COLUMN deleted INTEGER NOT NULL DEFAULT 0");
            paramSQLiteDatabase.execSQL("ALTER TABLE 'messages' ADD COLUMN played INTEGER NOT NULL DEFAULT 0");
          }
          catch (Exception paramSQLiteDatabase)
          {
            paramSQLiteDatabase.printStackTrace();
          }
        } else if (1 == paramInt1) {
          try
          {
            paramSQLiteDatabase.execSQL("ALTER TABLE 'messages' ADD COLUMN read_ts BIGINT NOT NULL DEFAULT 0");
            paramSQLiteDatabase.execSQL("ALTER TABLE 'messages' ADD COLUMN deleted INTEGER NOT NULL DEFAULT 0");
            paramSQLiteDatabase.execSQL("ALTER TABLE 'messages' ADD COLUMN played INTEGER NOT NULL DEFAULT 0");
          }
          catch (Exception paramSQLiteDatabase)
          {
            paramSQLiteDatabase.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\d\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */