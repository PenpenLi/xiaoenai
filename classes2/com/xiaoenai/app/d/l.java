package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.gameCenter.model.GameEntry;
import com.xiaoenai.app.utils.f.a;

class l
  implements Runnable
{
  l(k paramk, GameEntry paramGameEntry) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("id", Integer.valueOf(this.a.getId()));
    localContentValues.put("name", this.a.getName());
    localContentValues.put("appKey", this.a.getAppKey());
    localContentValues.put("intro", this.a.getIntro());
    localContentValues.put("icon_url", this.a.getIcon_url());
    localContentValues.put("package", this.a.getMpackage());
    localContentValues.put("start_type", Integer.valueOf(this.a.getStartType()));
    localContentValues.put("login_url", this.a.getLoginUrl());
    if (this.a.getId() != -1)
    {
      a.c("更新: messageId{}", new Object[] { Integer.valueOf(this.a.getId()) });
      localSQLiteDatabase.update("gamelist", localContentValues, "id=?", new String[] { String.valueOf(this.a.getId()) });
    }
    for (;;)
    {
      localSQLiteDatabase.close();
      return;
      a.c("插入", new Object[0]);
      localSQLiteDatabase.insert("gamelist", null, localContentValues);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */