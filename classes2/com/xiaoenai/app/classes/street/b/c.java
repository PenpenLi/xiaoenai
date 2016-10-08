package com.xiaoenai.app.classes.street.b;

import android.database.sqlite.SQLiteDatabase;

class c
  implements Runnable
{
  c(a parama, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
      localSQLiteDatabase.delete("subscribes", "product_id=? AND rush_id=?", new String[] { String.valueOf(this.a), String.valueOf(this.b) });
      com.xiaoenai.app.utils.f.a.c("delete id = {}", new Object[] { Integer.valueOf(this.a) });
      localSQLiteDatabase.close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */