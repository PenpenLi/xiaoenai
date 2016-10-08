package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;

class at
  implements Runnable
{
  at(ar paramar, BaseSticker paramBaseSticker) {}
  
  public void run()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    if (this.a.getName() != null) {
      localContentValues.put("name", this.a.getName());
    }
    if ((this.a.getType() != 0) || (this.a.getType() != -1)) {
      localContentValues.put("type", Integer.valueOf(this.a.getType()));
    }
    if (this.a.isDownload())
    {
      i = 1;
      localContentValues.put("isDownload", Integer.valueOf(i));
      if (!this.a.isNew()) {
        break label179;
      }
      i = 1;
      label110:
      localContentValues.put("isNew", Integer.valueOf(i));
      if (!this.a.isPurchased()) {
        break label184;
      }
    }
    label179:
    label184:
    for (int i = 1;; i = 0)
    {
      localContentValues.put("purchased", Integer.valueOf(i));
      localSQLiteDatabase.update("sticker", localContentValues, "id = ? ", new String[] { String.valueOf(this.a.getId()) });
      localSQLiteDatabase.close();
      return;
      i = 0;
      break;
      i = 0;
      break label110;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */