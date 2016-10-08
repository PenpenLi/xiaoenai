package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.d.a.b.a;
import com.xiaoenai.app.net.socket.f;

class ah
  implements Runnable
{
  ah(ag paramag, f paramf, b.a parama) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("priority", Integer.valueOf(0));
    localContentValues.put("retry", Integer.valueOf(5));
    localContentValues.put("body", this.a.e());
    long l = localSQLiteDatabase.insert("queue", null, localContentValues);
    localSQLiteDatabase.close();
    if (l == -1L)
    {
      this.b.a();
      return;
    }
    this.b.a(l);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */