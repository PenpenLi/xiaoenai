package com.xiaoenai.app.d;

import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.extentions.todo.a.b;

class ay
  implements Runnable
{
  ay(av paramav, b paramb) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    localSQLiteDatabase.delete("todo", "todo_id=?", new String[] { String.valueOf(this.a.e()) });
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */