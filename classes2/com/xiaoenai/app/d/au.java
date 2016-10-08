package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;

class au
  implements Runnable
{
  au(ar paramar) {}
  
  public void run()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
      localSQLiteDatabase.delete("sticker", null, null);
      localSQLiteDatabase.close();
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */