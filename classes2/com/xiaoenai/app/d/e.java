package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;

class e
  implements Runnable
{
  e(a parama) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    localSQLiteDatabase.delete("photos", null, null);
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */