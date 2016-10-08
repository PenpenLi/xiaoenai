package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;

class p
  implements Runnable
{
  p(m paramm, String paramString) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    localSQLiteDatabase.delete("jobs", "url=?", new String[] { String.valueOf(this.a) });
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */