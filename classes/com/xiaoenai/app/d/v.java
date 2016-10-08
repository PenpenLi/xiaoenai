package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.home.notification.DynamicNotification;
import com.xiaoenai.app.d.a.b;
import java.util.ArrayList;
import java.util.List;

public class v
  extends b
{
  private static String a = "CREATE TABLE notify (group_id VARCHAR(50) PRIMARY KEY,title TEXT,module_id VARCHAR(50),content TEXT,url TEXT,params TEXT,read_status INTEGER,count INTEGER,created_at BIGINT );";
  
  public v()
  {
    super("notify.db", b, 5);
  }
  
  /* Error */
  private void d(DynamicNotification paramDynamicNotification)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 34	com/xiaoenai/app/classes/home/notification/DynamicNotification:getGroup	()Ljava/lang/String;
    //   7: invokevirtual 37	com/xiaoenai/app/d/v:a	(Ljava/lang/String;)Lcom/xiaoenai/app/classes/home/notification/DynamicNotification;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +29 -> 41
    //   15: aload_1
    //   16: aload_2
    //   17: invokevirtual 41	com/xiaoenai/app/classes/home/notification/DynamicNotification:getCount	()I
    //   20: aload_1
    //   21: invokevirtual 41	com/xiaoenai/app/classes/home/notification/DynamicNotification:getCount	()I
    //   24: iadd
    //   25: invokevirtual 45	com/xiaoenai/app/classes/home/notification/DynamicNotification:setCount	(I)V
    //   28: aload_1
    //   29: iconst_0
    //   30: invokevirtual 48	com/xiaoenai/app/classes/home/notification/DynamicNotification:setReadStatus	(I)V
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual 50	com/xiaoenai/app/d/v:b	(Lcom/xiaoenai/app/classes/home/notification/DynamicNotification;)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: aload_0
    //   42: invokevirtual 54	com/xiaoenai/app/d/v:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: astore_2
    //   46: new 56	android/content/ContentValues
    //   49: dup
    //   50: invokespecial 58	android/content/ContentValues:<init>	()V
    //   53: astore_3
    //   54: aload_3
    //   55: ldc 60
    //   57: aload_1
    //   58: invokevirtual 63	com/xiaoenai/app/classes/home/notification/DynamicNotification:getTitle	()Ljava/lang/String;
    //   61: invokevirtual 67	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_3
    //   65: ldc 69
    //   67: aload_1
    //   68: invokevirtual 72	com/xiaoenai/app/classes/home/notification/DynamicNotification:getContent	()Ljava/lang/String;
    //   71: invokevirtual 67	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_3
    //   75: ldc 74
    //   77: aload_1
    //   78: invokevirtual 77	com/xiaoenai/app/classes/home/notification/DynamicNotification:getModule	()Ljava/lang/String;
    //   81: invokevirtual 67	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_3
    //   85: ldc 79
    //   87: aload_1
    //   88: invokevirtual 34	com/xiaoenai/app/classes/home/notification/DynamicNotification:getGroup	()Ljava/lang/String;
    //   91: invokevirtual 67	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_3
    //   95: ldc 81
    //   97: aload_1
    //   98: invokevirtual 41	com/xiaoenai/app/classes/home/notification/DynamicNotification:getCount	()I
    //   101: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: invokevirtual 90	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   107: aload_3
    //   108: ldc 92
    //   110: aload_1
    //   111: invokevirtual 95	com/xiaoenai/app/classes/home/notification/DynamicNotification:getUrl	()Ljava/lang/String;
    //   114: invokevirtual 67	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_3
    //   118: ldc 97
    //   120: aload_1
    //   121: invokevirtual 100	com/xiaoenai/app/classes/home/notification/DynamicNotification:getReadStatus	()I
    //   124: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: invokevirtual 90	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   130: aload_3
    //   131: ldc 102
    //   133: aload_1
    //   134: invokevirtual 106	com/xiaoenai/app/classes/home/notification/DynamicNotification:getUpdated_at	()J
    //   137: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   140: invokevirtual 114	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   143: aload_3
    //   144: ldc 116
    //   146: aload_1
    //   147: invokevirtual 119	com/xiaoenai/app/classes/home/notification/DynamicNotification:getParams	()Ljava/lang/String;
    //   150: invokevirtual 67	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_2
    //   154: ldc 121
    //   156: aconst_null
    //   157: aload_3
    //   158: invokevirtual 127	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   161: ldc2_w 128
    //   164: lcmp
    //   165: ifne +3 -> 168
    //   168: aload_2
    //   169: invokevirtual 132	android/database/sqlite/SQLiteDatabase:close	()V
    //   172: goto -134 -> 38
    //   175: astore_1
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	v
    //   0	180	1	paramDynamicNotification	DynamicNotification
    //   10	159	2	localObject	Object
    //   53	105	3	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   2	11	175	finally
    //   15	38	175	finally
    //   41	168	175	finally
    //   168	172	175	finally
  }
  
  public DynamicNotification a(String paramString)
  {
    Object localObject = null;
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("notify", null, "group_id=?", new String[] { paramString }, null, null, "created_at DESC");
    paramString = (String)localObject;
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      paramString = new DynamicNotification();
      paramString.setGroup(localCursor.getString(localCursor.getColumnIndex("group_id")));
      paramString.setTitle(localCursor.getString(localCursor.getColumnIndex("title")));
      paramString.setContent(localCursor.getString(localCursor.getColumnIndex("content")));
      paramString.setUrl(localCursor.getString(localCursor.getColumnIndex("url")));
      paramString.setParams(localCursor.getString(localCursor.getColumnIndex("params")));
      paramString.setModule(localCursor.getString(localCursor.getColumnIndex("module_id")));
      paramString.setCount(localCursor.getInt(localCursor.getColumnIndex("count")));
      paramString.setReadStatus(localCursor.getInt(localCursor.getColumnIndex("read_status")));
      paramString.setUpdated_at(localCursor.getLong(localCursor.getColumnIndex("created_at")));
    }
    localCursor.close();
    localSQLiteDatabase.close();
    return paramString;
  }
  
  public void a()
  {
    a(new aa(this));
  }
  
  public void a(long paramLong)
  {
    a(new z(this, paramLong));
  }
  
  public void a(DynamicNotification paramDynamicNotification)
  {
    a(new w(this, paramDynamicNotification));
  }
  
  public void a(List<DynamicNotification> paramList)
  {
    a(new x(this, paramList));
  }
  
  public List<DynamicNotification> b()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
      Cursor localCursor = localSQLiteDatabase.query("notify", null, null, null, null, null, "created_at DESC");
      ArrayList localArrayList = new ArrayList();
      if (localCursor.getCount() > 0)
      {
        localCursor.moveToFirst();
        do
        {
          DynamicNotification localDynamicNotification = new DynamicNotification();
          localDynamicNotification.setGroup(localCursor.getString(localCursor.getColumnIndex("group_id")));
          localDynamicNotification.setTitle(localCursor.getString(localCursor.getColumnIndex("title")));
          localDynamicNotification.setContent(localCursor.getString(localCursor.getColumnIndex("content")));
          localDynamicNotification.setUrl(localCursor.getString(localCursor.getColumnIndex("url")));
          localDynamicNotification.setParams(localCursor.getString(localCursor.getColumnIndex("params")));
          localDynamicNotification.setModule(localCursor.getString(localCursor.getColumnIndex("module_id")));
          localDynamicNotification.setCount(localCursor.getInt(localCursor.getColumnIndex("count")));
          localDynamicNotification.setReadStatus(localCursor.getInt(localCursor.getColumnIndex("read_status")));
          localDynamicNotification.setUpdated_at(localCursor.getLong(localCursor.getColumnIndex("created_at")));
          localArrayList.add(localDynamicNotification);
        } while (localCursor.moveToNext());
      }
      localCursor.close();
      localSQLiteDatabase.close();
      return localArrayList;
    }
    finally {}
  }
  
  public void b(DynamicNotification paramDynamicNotification)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("title", paramDynamicNotification.getTitle());
    localContentValues.put("content", paramDynamicNotification.getContent());
    localContentValues.put("module_id", paramDynamicNotification.getModule());
    localContentValues.put("group_id", paramDynamicNotification.getGroup());
    localContentValues.put("count", Integer.valueOf(paramDynamicNotification.getCount()));
    localContentValues.put("url", paramDynamicNotification.getUrl());
    localContentValues.put("read_status", Integer.valueOf(paramDynamicNotification.getReadStatus()));
    localContentValues.put("created_at", Long.valueOf(paramDynamicNotification.getUpdated_at()));
    localContentValues.put("params", paramDynamicNotification.getParams());
    localSQLiteDatabase.update("notify", localContentValues, "group_id=?", new String[] { paramDynamicNotification.getGroup() });
    localSQLiteDatabase.close();
  }
  
  public void c(DynamicNotification paramDynamicNotification)
  {
    a(new y(this, paramDynamicNotification));
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL(a);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if ((paramInt2 > paramInt1) && (3 == paramInt2))
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE notify ADD COLUMN product_id INTEGER DEFAULT 0");
      paramSQLiteDatabase.execSQL("ALTER TABLE notify ADD COLUMN sub_module_id TEXT");
    }
    do
    {
      return;
      if ((3 == paramInt1) && (4 == paramInt2))
      {
        paramSQLiteDatabase.execSQL("ALTER TABLE notify ADD COLUMN rush_id INTEGER");
        return;
      }
      if ((paramInt1 < 3) && (4 == paramInt2))
      {
        paramSQLiteDatabase.execSQL("ALTER TABLE notify ADD COLUMN product_id INTEGER DEFAULT 0");
        paramSQLiteDatabase.execSQL("ALTER TABLE notify ADD COLUMN sub_module_id TEXT");
        paramSQLiteDatabase.execSQL("ALTER TABLE notify ADD COLUMN rush_id INTEGER");
        return;
      }
    } while ((paramInt2 <= paramInt1) || (5 != paramInt2));
    paramSQLiteDatabase.execSQL("ALTER TABLE notify ADD COLUMN params TEXT");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\d\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */