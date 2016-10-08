package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.utils.f.a;

class t
  implements Runnable
{
  t(q paramq, long paramLong) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    a.c("delete id = {}", new Object[] { Long.valueOf(this.a) });
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("deleted", Integer.valueOf(1));
    localSQLiteDatabase.update("messages", localContentValues, "_id=?", new String[] { String.valueOf(this.a) });
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */