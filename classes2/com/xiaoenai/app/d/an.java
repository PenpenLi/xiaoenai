package com.xiaoenai.app.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.d.a.b;
import com.xiaoenai.app.model.status.Status;
import java.util.List;
import java.util.Vector;

public class an
  extends b
{
  private static String a = "CREATE TABLE status (_id INTEGER PRIMARY KEY AUTOINCREMENT,content TEXT,created_at BIGINT );";
  
  public an()
  {
    super("status.db", b);
  }
  
  public void a()
  {
    a(new aq(this));
  }
  
  public void a(Status paramStatus)
  {
    a(new ao(this, paramStatus));
  }
  
  public List<Status> b()
  {
    Vector localVector = new Vector();
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("status", null, null, null, null, null, "_id ASC");
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      do
      {
        Status localStatus = new Status();
        localStatus.setId(localCursor.getInt(localCursor.getColumnIndex("_id")));
        localStatus.setContent(localCursor.getString(localCursor.getColumnIndex("content")));
        localStatus.setCreateAt(localCursor.getLong(localCursor.getColumnIndex("created_at")));
        localVector.add(localStatus);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    localSQLiteDatabase.close();
    return localVector;
  }
  
  public void b(Status paramStatus)
  {
    a(new ap(this, paramStatus));
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
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */