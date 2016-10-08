package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.model.status.Status;

class ap
  implements Runnable
{
  ap(an paraman, Status paramStatus) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    localSQLiteDatabase.delete("status", "_id=?", new String[] { String.valueOf(this.a.getId()) });
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */