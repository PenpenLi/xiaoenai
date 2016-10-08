package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;

class u
  implements Runnable
{
  u(q paramq) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    localSQLiteDatabase.delete("messages", null, null);
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */