package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.chat.messagelist.message.a.a;
import com.xiaoenai.app.d.a.b;

public class f
  extends b
{
  public f()
  {
    super("feedsDB", b, 2);
  }
  
  /* Error */
  public java.util.Vector<a> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 22	java/util/Vector
    //   5: dup
    //   6: invokespecial 24	java/util/Vector:<init>	()V
    //   9: astore_2
    //   10: aload_0
    //   11: invokevirtual 28	com/xiaoenai/app/d/f:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore_3
    //   15: aload_3
    //   16: ldc 30
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 36	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 4
    //   29: aload 4
    //   31: invokeinterface 42 1 0
    //   36: ifle +160 -> 196
    //   39: aload 4
    //   41: invokeinterface 46 1 0
    //   46: pop
    //   47: aload 4
    //   49: aload 4
    //   51: ldc 48
    //   53: invokeinterface 52 2 0
    //   58: invokeinterface 56 2 0
    //   63: astore 5
    //   65: new 58	org/json/JSONObject
    //   68: dup
    //   69: aload 5
    //   71: invokespecial 61	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   74: ldc 63
    //   76: invokevirtual 67	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   79: ifeq +132 -> 211
    //   82: new 69	com/xiaoenai/app/classes/settings/feedback/FeedbackPhoto
    //   85: dup
    //   86: invokespecial 70	com/xiaoenai/app/classes/settings/feedback/FeedbackPhoto:<init>	()V
    //   89: astore_1
    //   90: aload_1
    //   91: aload 4
    //   93: aload 4
    //   95: ldc 72
    //   97: invokeinterface 52 2 0
    //   102: invokeinterface 76 2 0
    //   107: i2l
    //   108: invokevirtual 81	com/xiaoenai/app/classes/chat/messagelist/message/a/a:a	(J)V
    //   111: aload_1
    //   112: aload 5
    //   114: invokevirtual 83	com/xiaoenai/app/classes/chat/messagelist/message/a/a:b	(Ljava/lang/String;)V
    //   117: aload_1
    //   118: aload 4
    //   120: aload 4
    //   122: ldc 85
    //   124: invokeinterface 52 2 0
    //   129: invokeinterface 76 2 0
    //   134: invokevirtual 88	com/xiaoenai/app/classes/chat/messagelist/message/a/a:a	(I)V
    //   137: aload_1
    //   138: aload 4
    //   140: aload 4
    //   142: ldc 90
    //   144: invokeinterface 52 2 0
    //   149: invokeinterface 76 2 0
    //   154: invokevirtual 92	com/xiaoenai/app/classes/chat/messagelist/message/a/a:b	(I)V
    //   157: aload_1
    //   158: aload 4
    //   160: aload 4
    //   162: ldc 94
    //   164: invokeinterface 52 2 0
    //   169: invokeinterface 76 2 0
    //   174: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: invokevirtual 103	com/xiaoenai/app/classes/chat/messagelist/message/a/a:b	(Ljava/lang/Integer;)V
    //   180: aload_2
    //   181: aload_1
    //   182: invokevirtual 107	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   185: pop
    //   186: aload 4
    //   188: invokeinterface 110 1 0
    //   193: ifne -146 -> 47
    //   196: aload 4
    //   198: invokeinterface 113 1 0
    //   203: aload_3
    //   204: invokevirtual 114	android/database/sqlite/SQLiteDatabase:close	()V
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_2
    //   210: areturn
    //   211: new 116	com/xiaoenai/app/classes/settings/feedback/h
    //   214: dup
    //   215: invokespecial 117	com/xiaoenai/app/classes/settings/feedback/h:<init>	()V
    //   218: astore_1
    //   219: goto -129 -> 90
    //   222: astore_1
    //   223: new 116	com/xiaoenai/app/classes/settings/feedback/h
    //   226: dup
    //   227: invokespecial 117	com/xiaoenai/app/classes/settings/feedback/h:<init>	()V
    //   230: astore_1
    //   231: goto -141 -> 90
    //   234: astore_1
    //   235: aload_0
    //   236: monitorexit
    //   237: aload_1
    //   238: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	f
    //   89	130	1	localObject1	Object
    //   222	1	1	localJSONException	org.json.JSONException
    //   230	1	1	localh	com.xiaoenai.app.classes.settings.feedback.h
    //   234	4	1	localObject2	Object
    //   9	201	2	localVector	java.util.Vector
    //   14	190	3	localSQLiteDatabase	SQLiteDatabase
    //   27	170	4	localCursor	android.database.Cursor
    //   63	50	5	str	String
    // Exception table:
    //   from	to	target	type
    //   65	90	222	org/json/JSONException
    //   211	219	222	org/json/JSONException
    //   2	47	234	finally
    //   47	65	234	finally
    //   65	90	234	finally
    //   90	196	234	finally
    //   196	207	234	finally
    //   211	219	234	finally
    //   223	231	234	finally
  }
  
  /* Error */
  public java.util.Vector<a> a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 22	java/util/Vector
    //   5: dup
    //   6: invokespecial 24	java/util/Vector:<init>	()V
    //   9: astore 4
    //   11: aload_0
    //   12: invokevirtual 28	com/xiaoenai/app/d/f:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 5
    //   17: aload 5
    //   19: ldc 122
    //   21: aconst_null
    //   22: ldc 124
    //   24: iconst_1
    //   25: anewarray 126	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: lload_1
    //   31: invokestatic 129	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   34: aastore
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 36	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore 6
    //   43: aload 6
    //   45: invokeinterface 42 1 0
    //   50: ifle +161 -> 211
    //   53: aload 6
    //   55: invokeinterface 46 1 0
    //   60: pop
    //   61: aload 6
    //   63: aload 6
    //   65: ldc 48
    //   67: invokeinterface 52 2 0
    //   72: invokeinterface 56 2 0
    //   77: astore 7
    //   79: new 58	org/json/JSONObject
    //   82: dup
    //   83: aload 7
    //   85: invokespecial 61	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   88: ldc 63
    //   90: invokevirtual 67	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   93: ifeq +135 -> 228
    //   96: new 69	com/xiaoenai/app/classes/settings/feedback/FeedbackPhoto
    //   99: dup
    //   100: invokespecial 70	com/xiaoenai/app/classes/settings/feedback/FeedbackPhoto:<init>	()V
    //   103: astore_3
    //   104: aload_3
    //   105: aload 6
    //   107: aload 6
    //   109: ldc 72
    //   111: invokeinterface 52 2 0
    //   116: invokeinterface 76 2 0
    //   121: i2l
    //   122: invokevirtual 81	com/xiaoenai/app/classes/chat/messagelist/message/a/a:a	(J)V
    //   125: aload_3
    //   126: aload 7
    //   128: invokevirtual 83	com/xiaoenai/app/classes/chat/messagelist/message/a/a:b	(Ljava/lang/String;)V
    //   131: aload_3
    //   132: aload 6
    //   134: aload 6
    //   136: ldc 85
    //   138: invokeinterface 52 2 0
    //   143: invokeinterface 76 2 0
    //   148: invokevirtual 88	com/xiaoenai/app/classes/chat/messagelist/message/a/a:a	(I)V
    //   151: aload_3
    //   152: aload 6
    //   154: aload 6
    //   156: ldc 90
    //   158: invokeinterface 52 2 0
    //   163: invokeinterface 76 2 0
    //   168: invokevirtual 92	com/xiaoenai/app/classes/chat/messagelist/message/a/a:b	(I)V
    //   171: aload_3
    //   172: aload 6
    //   174: aload 6
    //   176: ldc 94
    //   178: invokeinterface 52 2 0
    //   183: invokeinterface 76 2 0
    //   188: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: invokevirtual 103	com/xiaoenai/app/classes/chat/messagelist/message/a/a:b	(Ljava/lang/Integer;)V
    //   194: aload 4
    //   196: aload_3
    //   197: invokevirtual 107	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   200: pop
    //   201: aload 6
    //   203: invokeinterface 110 1 0
    //   208: ifne -147 -> 61
    //   211: aload 6
    //   213: invokeinterface 113 1 0
    //   218: aload 5
    //   220: invokevirtual 114	android/database/sqlite/SQLiteDatabase:close	()V
    //   223: aload_0
    //   224: monitorexit
    //   225: aload 4
    //   227: areturn
    //   228: new 116	com/xiaoenai/app/classes/settings/feedback/h
    //   231: dup
    //   232: invokespecial 117	com/xiaoenai/app/classes/settings/feedback/h:<init>	()V
    //   235: astore_3
    //   236: goto -132 -> 104
    //   239: astore_3
    //   240: new 116	com/xiaoenai/app/classes/settings/feedback/h
    //   243: dup
    //   244: invokespecial 117	com/xiaoenai/app/classes/settings/feedback/h:<init>	()V
    //   247: astore_3
    //   248: goto -144 -> 104
    //   251: astore_3
    //   252: aload_0
    //   253: monitorexit
    //   254: aload_3
    //   255: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	f
    //   0	256	1	paramLong	long
    //   103	133	3	localObject1	Object
    //   239	1	3	localJSONException	org.json.JSONException
    //   247	1	3	localh	com.xiaoenai.app.classes.settings.feedback.h
    //   251	4	3	localObject2	Object
    //   9	217	4	localVector	java.util.Vector
    //   15	204	5	localSQLiteDatabase	SQLiteDatabase
    //   41	171	6	localCursor	android.database.Cursor
    //   77	50	7	str	String
    // Exception table:
    //   from	to	target	type
    //   79	104	239	org/json/JSONException
    //   228	236	239	org/json/JSONException
    //   2	61	251	finally
    //   61	79	251	finally
    //   79	104	251	finally
    //   104	211	251	finally
    //   211	223	251	finally
    //   228	236	251	finally
    //   240	248	251	finally
  }
  
  public void a(a parama)
  {
    a(new g(this, parama));
  }
  
  public void a(a parama, long paramLong)
  {
    a(new h(this, parama, paramLong));
  }
  
  public void b(a parama)
  {
    a(new i(this, parama));
  }
  
  public void c(a parama)
  {
    a(new j(this, parama));
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE feeds (_id INTEGER PRIMARY KEY AUTOINCREMENT,f_content TEXT, f_ts INT,f_sender INT,f_state INT,f_isavater INT);");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramSQLiteDatabase.execSQL("CREATE TABLE feeds_street (_id INTEGER PRIMARY KEY AUTOINCREMENT,f_content TEXT, f_ts INT,f_sender INT,f_state INT,f_isavater INT,order_id BIGINT);");
          return;
        }
        catch (Exception paramSQLiteDatabase)
        {
          paramSQLiteDatabase.printStackTrace();
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (2 == paramInt2) {}
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE feeds_street (_id INTEGER PRIMARY KEY AUTOINCREMENT,f_content TEXT, f_ts INT,f_sender INT,f_state INT,f_isavater INT,order_id BIGINT);");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */