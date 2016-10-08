package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.extentions.todo.a.b;

class ax
  implements Runnable
{
  ax(av paramav, b paramb) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("created_at", Long.valueOf(this.a.b()));
    localContentValues.put("content", this.a.f());
    localContentValues.put("modifier_Id", Integer.valueOf(this.a.d()));
    if (this.a.g())
    {
      i = 1;
      localContentValues.put("is_sync", Integer.valueOf(i));
      if (!this.a.h().booleanValue()) {
        break label145;
      }
    }
    label145:
    for (int i = 1;; i = 0)
    {
      localContentValues.put("finished", Integer.valueOf(i));
      localSQLiteDatabase.update("todo", localContentValues, "todo_id=?", new String[] { String.valueOf(this.a.e()) });
      localSQLiteDatabase.close();
      return;
      i = 0;
      break;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */