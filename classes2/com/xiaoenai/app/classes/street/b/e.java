package com.xiaoenai.app.classes.street.b;

import android.database.sqlite.SQLiteDatabase;

class e
  implements Runnable
{
  e(a parama, long paramLong) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    localSQLiteDatabase.delete("subscribes", "close_time<=?", new String[] { String.valueOf(this.a) });
    com.xiaoenai.app.utils.f.a.c("delete ts = {}", new Object[] { Long.valueOf(this.a) });
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */