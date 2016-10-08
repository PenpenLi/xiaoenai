package com.xiaoenai.app.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import java.util.Vector;

public class m
  extends com.xiaoenai.app.d.a.b
{
  public m()
  {
    super("jobDB.db", b, 2);
  }
  
  public List<com.xiaoenai.app.classes.common.b.b> a()
  {
    Vector localVector = new Vector();
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("jobs", null, null, null, null, null, null);
    String str;
    int i;
    int j;
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      str = localCursor.getString(localCursor.getColumnIndex("url"));
      i = localCursor.getInt(localCursor.getColumnIndex("priority"));
      j = localCursor.getInt(localCursor.getColumnIndex("type"));
      if (localCursor.getInt(localCursor.getColumnIndex("is_original")) != 1) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      localVector.add(new com.xiaoenai.app.classes.common.b.b(str, i, j, bool));
      if (localCursor.moveToNext()) {
        break;
      }
      localCursor.close();
      localSQLiteDatabase.close();
      return localVector;
    }
  }
  
  public void a(int paramInt)
  {
    a(new o(this, paramInt));
  }
  
  public void a(com.xiaoenai.app.classes.common.b.b paramb)
  {
    a(new n(this, paramb));
  }
  
  public void a(String paramString)
  {
    a(new p(this, paramString));
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE jobs (id INTEGER PRIMARY KEY AUTOINCREMENT,url TEXT, priority INT,type INT,is_original INT);");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if ((paramInt2 > paramInt1) && (paramInt1 == 1)) {
      paramSQLiteDatabase.execSQL("ALTER TABLE jobs ADD COLUMN is_original INT");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */