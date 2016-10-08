package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.model.album.Photo;

class c
  implements Runnable
{
  c(a parama, Photo paramPhoto) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("url", this.a.getUrl());
    localContentValues.put("created_at", Integer.valueOf(this.a.getCreateAt()));
    localContentValues.put("is_original", Integer.valueOf(this.a.isOriginal()));
    localSQLiteDatabase.update("photos", localContentValues, "photo_id=?", new String[] { String.valueOf(this.a.getId()) });
    localSQLiteDatabase.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */