package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.model.RecentFace;

class ac
  implements Runnable
{
  ac(ab paramab, RecentFace paramRecentFace) {}
  
  public void run()
  {
    if (this.b.a(this.a.url) != null)
    {
      this.b.b(this.a);
      return;
    }
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("url", this.a.url);
    localContentValues.put("used_at", Long.valueOf(this.a.lastUsedTime));
    localContentValues.put("use_count", Integer.valueOf(this.a.usedCount));
    localContentValues.put("face_type", this.a.faceType);
    if (localSQLiteDatabase.insert("recent_face", null, localContentValues) == -1L) {}
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */