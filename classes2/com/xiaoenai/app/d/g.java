package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.chat.messagelist.message.a.a;

class g
  implements Runnable
{
  g(f paramf, a parama) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("f_content", this.a.c());
    localContentValues.put("f_ts", Integer.valueOf(this.a.d()));
    localContentValues.put("f_sender", Integer.valueOf(this.a.g()));
    localContentValues.put("f_state", this.a.f());
    int i;
    if (this.a.g() == 2)
    {
      i = 1;
      localContentValues.put("f_isavater", Integer.valueOf(i));
      if (this.a.a() == -1L) {
        break label148;
      }
      localSQLiteDatabase.update("feeds", localContentValues, "_id=?", new String[] { String.valueOf(this.a.a()) });
    }
    for (;;)
    {
      localSQLiteDatabase.close();
      return;
      i = 0;
      break;
      label148:
      long l = localSQLiteDatabase.insert("feeds", null, localContentValues);
      this.a.a(l);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */