package com.xiaoenai.app.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.Vector;

public class av
  extends com.xiaoenai.app.d.a.b
{
  private static String a = "CREATE TABLE todo (todo_id INTEGER,content TEXT,modifier_Id INT,is_sync INT,created_at BIGINT,finished INT );";
  
  public av()
  {
    super("todo.db", b, 2);
  }
  
  public com.xiaoenai.app.classes.extentions.todo.a.b a(int paramInt)
  {
    com.xiaoenai.app.classes.extentions.todo.a.b localb = null;
    boolean bool2 = true;
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("todo", null, "todo_id=?", new String[] { String.valueOf(paramInt) }, null, null, "todo_id DESC");
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      localb = new com.xiaoenai.app.classes.extentions.todo.a.b();
      localb.c(localCursor.getInt(localCursor.getColumnIndex("todo_id")));
      localb.a(localCursor.getString(localCursor.getColumnIndex("content")));
      localb.a(localCursor.getLong(localCursor.getColumnIndex("created_at")));
      localb.b(localCursor.getInt(localCursor.getColumnIndex("modifier_Id")));
      if (localCursor.getInt(localCursor.getColumnIndex("is_sync")) != 1) {
        break label217;
      }
      bool1 = true;
      localb.b(bool1);
      if (localCursor.getInt(localCursor.getColumnIndex("finished")) != 1) {
        break label223;
      }
    }
    label217:
    label223:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localb.a(Boolean.valueOf(bool1));
      localCursor.close();
      localSQLiteDatabase.close();
      return localb;
      bool1 = false;
      break;
    }
  }
  
  public List<com.xiaoenai.app.classes.extentions.todo.a.b> a()
  {
    Vector localVector = new Vector();
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("todo", null, null, null, null, null, "created_at DESC");
    com.xiaoenai.app.classes.extentions.todo.a.b localb;
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      localb = new com.xiaoenai.app.classes.extentions.todo.a.b();
      localb.c(localCursor.getInt(localCursor.getColumnIndex("todo_id")));
      localb.a(localCursor.getString(localCursor.getColumnIndex("content")));
      localb.a(localCursor.getLong(localCursor.getColumnIndex("created_at")));
      localb.b(localCursor.getInt(localCursor.getColumnIndex("modifier_Id")));
      if (localCursor.getInt(localCursor.getColumnIndex("is_sync")) != 1) {
        break label217;
      }
      bool = true;
      label149:
      localb.b(bool);
      if (localCursor.getInt(localCursor.getColumnIndex("finished")) != 1) {
        break label223;
      }
    }
    label217:
    label223:
    for (boolean bool = true;; bool = false)
    {
      localb.a(Boolean.valueOf(bool));
      localVector.add(localb);
      if (localCursor.moveToNext()) {
        break;
      }
      localCursor.close();
      localSQLiteDatabase.close();
      return localVector;
      bool = false;
      break label149;
    }
  }
  
  public void a(com.xiaoenai.app.classes.extentions.todo.a.b paramb)
  {
    a(new aw(this, paramb));
  }
  
  public void b()
  {
    a(new az(this));
  }
  
  public void b(com.xiaoenai.app.classes.extentions.todo.a.b paramb)
  {
    a(new ax(this, paramb));
  }
  
  public void c(com.xiaoenai.app.classes.extentions.todo.a.b paramb)
  {
    a(new ay(this, paramb));
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
    if (paramInt2 > paramInt1)
    {
      paramSQLiteDatabase.beginTransaction();
      paramInt2 = 0;
      switch (paramInt1)
      {
      }
      for (paramInt1 = paramInt2;; paramInt1 = 1)
      {
        if (paramInt1 != 0) {
          paramSQLiteDatabase.setTransactionSuccessful();
        }
        paramSQLiteDatabase.endTransaction();
        return;
        paramSQLiteDatabase.execSQL("ALTER TABLE todo ADD COLUMN finished INT DEFAULT 0");
      }
    }
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */