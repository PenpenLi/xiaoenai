package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;

class o
  implements Runnable
{
  o(m paramm, int paramInt) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    localSQLiteDatabase.delete("jobs", "type=?", new String[] { String.valueOf(this.a) });
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */