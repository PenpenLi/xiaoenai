package com.xiaoenai.app.d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.model.RedHintsInfo;

class af
  implements Runnable
{
  af(ae paramae, RedHintsInfo paramRedHintsInfo) {}
  
  public void run()
  {
    String str = this.a.getModule() + "_" + this.a.getId();
    int i = this.b.a(str);
    SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("redhintkey", str);
    localContentValues.put("module", this.a.getModule());
    localContentValues.put("redhintid", Integer.valueOf(this.a.getId()));
    if (i == -1) {
      localSQLiteDatabase.insert("redHints", null, localContentValues);
    }
    for (;;)
    {
      localSQLiteDatabase.close();
      return;
      localSQLiteDatabase.update("redHints", localContentValues, "redhintkey=?", new String[] { str });
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */