package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.model.RecentFace;

class ad
  implements Runnable
{
  ad(ab paramab, RecentFace paramRecentFace) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("used_at", Long.valueOf(this.a.lastUsedTime));
    localContentValues.put("use_count", Integer.valueOf(this.a.usedCount + 1));
    localSQLiteDatabase.update("recent_face", localContentValues, "url=?", new String[] { this.a.url });
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */