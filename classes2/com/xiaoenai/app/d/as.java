package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;

class as
  implements Runnable
{
  as(ar paramar, BaseSticker paramBaseSticker) {}
  
  public void run()
  {
    int j = 1;
    for (;;)
    {
      try
      {
        if (this.b.a(this.a.getId()) != null)
        {
          this.b.b(this.a);
          return;
        }
        SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("id", Integer.valueOf(this.a.getId()));
        localContentValues.put("name", this.a.getName());
        localContentValues.put("type", Integer.valueOf(this.a.getType()));
        if (this.a.isDownload())
        {
          i = 1;
          localContentValues.put("isDownload", Integer.valueOf(i));
          if (!this.a.isNew()) {
            break label338;
          }
          i = 1;
          localContentValues.put("isNew", Integer.valueOf(i));
          localContentValues.put("thumb_url", this.a.getThumb_url());
          localContentValues.put("cover_url", this.a.getCover_url());
          localContentValues.put("cover_bg_url", this.a.getCover_bg_url());
          localContentValues.put("free", Integer.valueOf(this.a.getFree()));
          localContentValues.put("sort", Integer.valueOf(this.a.getSort()));
          localContentValues.put("intro", this.a.getIntro());
          localContentValues.put("price", Integer.valueOf(this.a.getPrice()));
          localContentValues.put("vip_price", Integer.valueOf(this.a.getVip_price()));
          if (!this.a.isPurchased()) {
            break label343;
          }
          i = j;
          localContentValues.put("purchased", Integer.valueOf(i));
          if (this.a.getZipUrl() != null) {
            localContentValues.put("zipUrl", this.a.getZipUrl());
          }
          if (localSQLiteDatabase.insert("sticker", null, localContentValues) == -1L) {}
          localSQLiteDatabase.close();
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label338:
      int i = 0;
      continue;
      label343:
      i = 0;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */