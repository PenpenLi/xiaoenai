package com.xiaoenai.app.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.d.a.b.b;
import com.xiaoenai.app.net.socket.f;

class ai
  implements Runnable
{
  ai(ag paramag, b.b paramb) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    Cursor localCursor = localSQLiteDatabase.rawQuery("SELECT * FROM queue WHERE retry>=0 ORDER BY priority ASC Limit 1", null);
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      long l = localCursor.getLong(localCursor.getColumnIndex("_id"));
      f localf = new f();
      localf.c(localCursor.getString(localCursor.getColumnIndex("body")));
      localSQLiteDatabase.execSQL("UPDATE queue SET retry=retry-1 WHERE _id=" + l);
      localSQLiteDatabase.execSQL("UPDATE queue SET priority=priority+1 WHERE _id=" + l);
      localCursor.close();
      localSQLiteDatabase.close();
      this.a.a(l, localf);
      return;
    }
    localCursor.close();
    localSQLiteDatabase.close();
    this.a.a(-1L, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */