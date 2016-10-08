package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.d.a.b.a;

class aj
  implements Runnable
{
  aj(ag paramag, long paramLong, b.a parama) {}
  
  public void run()
  {
    String str = "DELETE FROM queue WHERE _id=" + this.a + " OR " + "retry" + "<0";
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    localSQLiteDatabase.execSQL(str);
    localSQLiteDatabase.close();
    this.b.a(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */