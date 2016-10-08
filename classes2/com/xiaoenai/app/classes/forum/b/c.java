package com.xiaoenai.app.classes.forum.b;

import android.database.sqlite.SQLiteDatabase;

class c
  implements Runnable
{
  c(a parama) {}
  
  public void run()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
      localSQLiteDatabase.delete("forum_notify", null, null);
      localSQLiteDatabase.close();
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */