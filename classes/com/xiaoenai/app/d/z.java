package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;

class z
  implements Runnable
{
  z(v paramv, long paramLong) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    localSQLiteDatabase.delete("notify", "created_at=?", new String[] { String.valueOf(this.a) });
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\d\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */