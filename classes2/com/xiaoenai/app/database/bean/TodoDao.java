package com.xiaoenai.app.database.bean;

import a.a.a.g;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class TodoDao
  extends a.a.a.a<Todo, Void>
{
  public static final String TABLENAME = "TODO";
  
  public TodoDao(a.a.a.c.a parama)
  {
    super(parama);
  }
  
  public TodoDao(a.a.a.c.a parama, DaoSession paramDaoSession)
  {
    super(parama, paramDaoSession);
  }
  
  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "IF NOT EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "\"TODO\" (" + "\"TODO_ID\" INTEGER," + "\"CONTENT\" TEXT," + "\"MODIFIER__ID\" INTEGER," + "\"IS_SYNC\" INTEGER," + "\"CREATED_AT\" INTEGER," + "\"FINISHED\" INTEGER);");
      return;
    }
  }
  
  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("DROP TABLE ");
    if (paramBoolean) {}
    for (String str = "IF EXISTS ";; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "\"TODO\"");
      return;
    }
  }
  
  protected void bindValues(SQLiteStatement paramSQLiteStatement, Todo paramTodo)
  {
    paramSQLiteStatement.clearBindings();
    Object localObject = paramTodo.getTodo_id();
    if (localObject != null) {
      paramSQLiteStatement.bindLong(1, ((Integer)localObject).intValue());
    }
    localObject = paramTodo.getContent();
    if (localObject != null) {
      paramSQLiteStatement.bindString(2, (String)localObject);
    }
    localObject = paramTodo.getModifier_Id();
    if (localObject != null) {
      paramSQLiteStatement.bindLong(3, ((Integer)localObject).intValue());
    }
    localObject = paramTodo.getIs_sync();
    if (localObject != null) {
      paramSQLiteStatement.bindLong(4, ((Integer)localObject).intValue());
    }
    localObject = paramTodo.getCreated_at();
    if (localObject != null) {
      paramSQLiteStatement.bindLong(5, ((Long)localObject).longValue());
    }
    paramTodo = paramTodo.getFinished();
    if (paramTodo != null) {
      paramSQLiteStatement.bindLong(6, paramTodo.intValue());
    }
  }
  
  public Void getKey(Todo paramTodo)
  {
    return null;
  }
  
  protected boolean isEntityUpdateable()
  {
    return true;
  }
  
  public Todo readEntity(Cursor paramCursor, int paramInt)
  {
    Object localObject = null;
    Integer localInteger1;
    String str;
    label32:
    Integer localInteger2;
    label47:
    Integer localInteger3;
    label62:
    Long localLong;
    if (paramCursor.isNull(paramInt + 0))
    {
      localInteger1 = null;
      if (!paramCursor.isNull(paramInt + 1)) {
        break label126;
      }
      str = null;
      if (!paramCursor.isNull(paramInt + 2)) {
        break label140;
      }
      localInteger2 = null;
      if (!paramCursor.isNull(paramInt + 3)) {
        break label157;
      }
      localInteger3 = null;
      if (!paramCursor.isNull(paramInt + 4)) {
        break label174;
      }
      localLong = null;
      label77:
      if (!paramCursor.isNull(paramInt + 5)) {
        break label191;
      }
    }
    label126:
    label140:
    label157:
    label174:
    label191:
    for (paramCursor = (Cursor)localObject;; paramCursor = Integer.valueOf(paramCursor.getInt(paramInt + 5)))
    {
      return new Todo(localInteger1, str, localInteger2, localInteger3, localLong, paramCursor);
      localInteger1 = Integer.valueOf(paramCursor.getInt(paramInt + 0));
      break;
      str = paramCursor.getString(paramInt + 1);
      break label32;
      localInteger2 = Integer.valueOf(paramCursor.getInt(paramInt + 2));
      break label47;
      localInteger3 = Integer.valueOf(paramCursor.getInt(paramInt + 3));
      break label62;
      localLong = Long.valueOf(paramCursor.getLong(paramInt + 4));
      break label77;
    }
  }
  
  public void readEntity(Cursor paramCursor, Todo paramTodo, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramCursor.isNull(paramInt + 0))
    {
      localObject1 = null;
      paramTodo.setTodo_id((Integer)localObject1);
      if (!paramCursor.isNull(paramInt + 1)) {
        break label146;
      }
      localObject1 = null;
      label39:
      paramTodo.setContent((String)localObject1);
      if (!paramCursor.isNull(paramInt + 2)) {
        break label160;
      }
      localObject1 = null;
      label60:
      paramTodo.setModifier_Id((Integer)localObject1);
      if (!paramCursor.isNull(paramInt + 3)) {
        break label177;
      }
      localObject1 = null;
      label81:
      paramTodo.setIs_sync((Integer)localObject1);
      if (!paramCursor.isNull(paramInt + 4)) {
        break label194;
      }
      localObject1 = null;
      label102:
      paramTodo.setCreated_at((Long)localObject1);
      if (!paramCursor.isNull(paramInt + 5)) {
        break label211;
      }
    }
    label146:
    label160:
    label177:
    label194:
    label211:
    for (paramCursor = (Cursor)localObject2;; paramCursor = Integer.valueOf(paramCursor.getInt(paramInt + 5)))
    {
      paramTodo.setFinished(paramCursor);
      return;
      localObject1 = Integer.valueOf(paramCursor.getInt(paramInt + 0));
      break;
      localObject1 = paramCursor.getString(paramInt + 1);
      break label39;
      localObject1 = Integer.valueOf(paramCursor.getInt(paramInt + 2));
      break label60;
      localObject1 = Integer.valueOf(paramCursor.getInt(paramInt + 3));
      break label81;
      localObject1 = Long.valueOf(paramCursor.getLong(paramInt + 4));
      break label102;
    }
  }
  
  public Void readKey(Cursor paramCursor, int paramInt)
  {
    return null;
  }
  
  protected Void updateKeyAfterInsert(Todo paramTodo, long paramLong)
  {
    return null;
  }
  
  public static class Properties
  {
    public static final g Content;
    public static final g Created_at = new g(4, Long.class, "created_at", false, "CREATED_AT");
    public static final g Finished = new g(5, Integer.class, "finished", false, "FINISHED");
    public static final g Is_sync;
    public static final g Modifier_Id;
    public static final g Todo_id = new g(0, Integer.class, "todo_id", false, "TODO_ID");
    
    static
    {
      Content = new g(1, String.class, "content", false, "CONTENT");
      Modifier_Id = new g(2, Integer.class, "modifier_Id", false, "MODIFIER__ID");
      Is_sync = new g(3, Integer.class, "is_sync", false, "IS_SYNC");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\database\bean\TodoDao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */