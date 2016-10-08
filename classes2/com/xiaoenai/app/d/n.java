package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.common.b.b;

class n
  implements Runnable
{
  n(m paramm, b paramb) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("url", this.a.a());
    localContentValues.put("priority", Integer.valueOf(this.a.b()));
    localContentValues.put("type", Integer.valueOf(this.a.c()));
    if (this.a.d()) {}
    for (int i = 1;; i = 0)
    {
      localContentValues.put("is_original", Integer.valueOf(i));
      localSQLiteDatabase.insert("jobs", null, localContentValues);
      localSQLiteDatabase.close();
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */