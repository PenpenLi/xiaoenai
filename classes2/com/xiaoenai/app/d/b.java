package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.model.album.Photo;

class b
  implements Runnable
{
  b(a parama, Photo paramPhoto) {}
  
  public void run()
  {
    if (this.b.a(this.a.getId()) != null)
    {
      this.b.b(this.a);
      return;
    }
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("photo_id", Integer.valueOf(this.a.getId()));
    localContentValues.put("url", this.a.getUrl());
    localContentValues.put("created_at", Integer.valueOf(this.a.getCreateAt()));
    localContentValues.put("is_original", Integer.valueOf(this.a.isOriginal()));
    if (localSQLiteDatabase.insert("photos", null, localContentValues) == -1L) {}
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */