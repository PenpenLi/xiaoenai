package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;

class aa
  implements Runnable
{
  aa(v paramv) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    localSQLiteDatabase.delete("notify", null, null);
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\d\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */