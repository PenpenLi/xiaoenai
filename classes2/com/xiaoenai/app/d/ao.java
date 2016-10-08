package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.model.status.Status;

class ao
  implements Runnable
{
  ao(an paraman, Status paramStatus) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
    localContentValues.put("content", this.a.getContent());
    long l = localSQLiteDatabase.insert("status", null, localContentValues);
    if (l == -1L) {}
    for (;;)
    {
      localSQLiteDatabase.close();
      return;
      this.a.setId((int)l);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */