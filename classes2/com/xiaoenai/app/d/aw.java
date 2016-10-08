package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.extentions.todo.a.b;

class aw
  implements Runnable
{
  aw(av paramav, b paramb) {}
  
  public void run()
  {
    int j = 1;
    if (this.b.a(this.a.e()) != null)
    {
      this.b.b(this.a);
      return;
    }
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("created_at", Long.valueOf(this.a.b()));
    localContentValues.put("content", this.a.f());
    localContentValues.put("modifier_Id", Integer.valueOf(this.a.d()));
    localContentValues.put("todo_id", Integer.valueOf(this.a.e()));
    if (this.a.g())
    {
      i = 1;
      localContentValues.put("is_sync", Integer.valueOf(i));
      if (!this.a.h().booleanValue()) {
        break label182;
      }
    }
    label182:
    for (int i = j;; i = 0)
    {
      localContentValues.put("finished", Integer.valueOf(i));
      if (localSQLiteDatabase.insert("todo", null, localContentValues) == -1L) {}
      localSQLiteDatabase.close();
      return;
      i = 0;
      break;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */