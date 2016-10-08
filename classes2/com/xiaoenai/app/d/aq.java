package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;

class aq
  implements Runnable
{
  aq(an paraman) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    localSQLiteDatabase.delete("status", null, null);
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */