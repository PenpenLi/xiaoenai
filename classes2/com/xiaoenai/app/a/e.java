package com.xiaoenai.app.a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

class e
  implements Runnable
{
  e(d paramd, ContentValues paramContentValues) {}
  
  public void run()
  {
    try
    {
      int i = this.b.a();
      this.b.a(i);
      SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
      localSQLiteDatabase.insert("analytics", null, this.a);
      localSQLiteDatabase.close();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */