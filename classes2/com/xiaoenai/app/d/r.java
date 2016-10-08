package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

class r
  implements Runnable
{
  r(q paramq, com.xiaoenai.app.classes.chat.messagelist.message.a.a parama) {}
  
  public void run()
  {
    com.xiaoenai.app.classes.chat.messagelist.message.a.a locala = this.b.b(this.a.h());
    String str = com.xiaoenai.app.utils.b.a.b(this.a.c());
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("message_id", Long.valueOf(this.a.h()));
    localContentValues.put("sender_id", this.a.e());
    localContentValues.put("types", this.a.b());
    localContentValues.put("content", str);
    localContentValues.put("status", this.a.f());
    localContentValues.put("ts", Integer.valueOf(this.a.d()));
    localContentValues.put("read_ts", Long.valueOf(this.a.i()));
    int i;
    if (this.a.p())
    {
      i = 1;
      localContentValues.put("played", Integer.valueOf(i));
      if (this.a.a() == -1L) {
        break label244;
      }
      com.xiaoenai.app.utils.f.a.c("更新1: messageId = {}", new Object[] { Long.valueOf(this.a.a()) });
      localSQLiteDatabase.update("messages", localContentValues, "_id=?", new String[] { String.valueOf(this.a.a()) });
    }
    for (;;)
    {
      localSQLiteDatabase.close();
      return;
      i = 0;
      break;
      label244:
      if ((locala != null) && (this.a.h() != -1L))
      {
        com.xiaoenai.app.utils.f.a.c("更新2: messageId = {}", new Object[] { Long.valueOf(this.a.a()) });
        localSQLiteDatabase.update("messages", localContentValues, "message_id=?", new String[] { String.valueOf(locala.h()) });
      }
      else
      {
        com.xiaoenai.app.utils.f.a.c("插入 {}", new Object[] { locala });
        long l = localSQLiteDatabase.insert("messages", null, localContentValues);
        this.a.a(l);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */