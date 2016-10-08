package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

class s
  implements Runnable
{
  s(q paramq, Integer paramInteger, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.d.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    if (this.a != null)
    {
      localContentValues.put("status", this.a);
      localContentValues.put("read_ts", Long.valueOf(this.b));
      if (1 == this.a.intValue()) {
        localContentValues.put("played", Integer.valueOf(1));
      }
      localSQLiteDatabase.update("messages", localContentValues, "message_id=?", new String[] { String.valueOf(this.c) });
    }
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */