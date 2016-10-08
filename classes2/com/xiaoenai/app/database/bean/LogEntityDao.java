package com.xiaoenai.app.database.bean;

import a.a.a.g;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class LogEntityDao
  extends a.a.a.a<LogEntity, Long>
{
  public static final String TABLENAME = "LOG_ENTITY";
  
  public LogEntityDao(a.a.a.c.a parama)
  {
    super(parama);
  }
  
  public LogEntityDao(a.a.a.c.a parama, DaoSession paramDaoSession)
  {
    super(parama, paramDaoSession);
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "IF NOT EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "\"LOG_ENTITY\" (" + "\"ID\" INTEGER PRIMARY KEY AUTOINCREMENT ," + "\"TS\" INTEGER," + "\"PRIORITY\" INTEGER," + "\"MESSAGE\" TEXT);");
      return;
    }
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("DROP TABLE ");
    if (paramBoolean) {}
    for (String str = "IF EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "\"LOG_ENTITY\"");
      return;
    }
  }
  
  protected void bindValues(SQLiteStatement paramSQLiteStatement, LogEntity paramLogEntity)
  {
    paramSQLiteStatement.clearBindings();
    Object localObject = paramLogEntity.getId();
    if (localObject != null) {
      paramSQLiteStatement.bindLong(1, ((Long)localObject).longValue());
    }
    localObject = paramLogEntity.getTs();
    if (localObject != null) {
      paramSQLiteStatement.bindLong(2, ((Long)localObject).longValue());
    }
    localObject = paramLogEntity.getPriority();
    if (localObject != null) {
      paramSQLiteStatement.bindLong(3, ((Integer)localObject).intValue());
    }
    paramLogEntity = paramLogEntity.getMessage();
    if (paramLogEntity != null) {
      paramSQLiteStatement.bindString(4, paramLogEntity);
    }
  }
  
  public Long getKey(LogEntity paramLogEntity)
  {
    if (paramLogEntity != null) {
      return paramLogEntity.getId();
    }
    return null;
  }
  
  protected boolean isEntityUpdateable()
  {
    return true;
  }
  
  public LogEntity readEntity(Cursor paramCursor, int paramInt)
  {
    Object localObject = null;
    Long localLong1;
    Long localLong2;
    label32:
    Integer localInteger;
    if (paramCursor.isNull(paramInt + 0))
    {
      localLong1 = null;
      if (!paramCursor.isNull(paramInt + 1)) {
        break label92;
      }
      localLong2 = null;
      if (!paramCursor.isNull(paramInt + 2)) {
        break label109;
      }
      localInteger = null;
      label47:
      if (!paramCursor.isNull(paramInt + 3)) {
        break label126;
      }
    }
    label92:
    label109:
    label126:
    for (paramCursor = (Cursor)localObject;; paramCursor = paramCursor.getString(paramInt + 3))
    {
      return new LogEntity(localLong1, localLong2, localInteger, paramCursor);
      localLong1 = Long.valueOf(paramCursor.getLong(paramInt + 0));
      break;
      localLong2 = Long.valueOf(paramCursor.getLong(paramInt + 1));
      break label32;
      localInteger = Integer.valueOf(paramCursor.getInt(paramInt + 2));
      break label47;
    }
  }
  
  public void readEntity(Cursor paramCursor, LogEntity paramLogEntity, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramCursor.isNull(paramInt + 0))
    {
      localObject1 = null;
      paramLogEntity.setId((Long)localObject1);
      if (!paramCursor.isNull(paramInt + 1)) {
        break label104;
      }
      localObject1 = null;
      label39:
      paramLogEntity.setTs((Long)localObject1);
      if (!paramCursor.isNull(paramInt + 2)) {
        break label121;
      }
      localObject1 = null;
      label60:
      paramLogEntity.setPriority((Integer)localObject1);
      if (!paramCursor.isNull(paramInt + 3)) {
        break label138;
      }
    }
    label104:
    label121:
    label138:
    for (paramCursor = (Cursor)localObject2;; paramCursor = paramCursor.getString(paramInt + 3))
    {
      paramLogEntity.setMessage(paramCursor);
      return;
      localObject1 = Long.valueOf(paramCursor.getLong(paramInt + 0));
      break;
      localObject1 = Long.valueOf(paramCursor.getLong(paramInt + 1));
      break label39;
      localObject1 = Integer.valueOf(paramCursor.getInt(paramInt + 2));
      break label60;
    }
  }
  
  public Long readKey(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt + 0)) {
      return null;
    }
    return Long.valueOf(paramCursor.getLong(paramInt + 0));
  }
  
  protected Long updateKeyAfterInsert(LogEntity paramLogEntity, long paramLong)
  {
    paramLogEntity.setId(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }
  
  public static class Properties
  {
    public static final g Id = new g(0, Long.class, "id", true, "ID");
    public static final g Message = new g(3, String.class, "message", false, "MESSAGE");
    public static final g Priority;
    public static final g Ts = new g(1, Long.class, "ts", false, "TS");
    
    static
    {
      Priority = new g(2, Integer.class, "priority", false, "PRIORITY");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\database\bean\LogEntityDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */