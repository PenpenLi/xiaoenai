package com.xiaoenai.app.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.d.a.b;
import com.xiaoenai.app.model.RedHintsInfo;
import com.xiaoenai.app.utils.f.a;

public class ae
  extends b
{
  public ae()
  {
    super("redHintsDB", b);
  }
  
  public int a(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    paramString = localSQLiteDatabase.query("redHints", null, "redhintkey = ?", new String[] { paramString }, null, null, null);
    int i = -1;
    if (paramString.getCount() > 0)
    {
      paramString.moveToFirst();
      do
      {
        i = paramString.getInt(paramString.getColumnIndex("redhintid"));
      } while (paramString.moveToNext());
    }
    paramString.close();
    localSQLiteDatabase.close();
    return i;
  }
  
  public void a(RedHintsInfo paramRedHintsInfo)
  {
    a(new af(this, paramRedHintsInfo));
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a.c("RedHintsDB : {}", new Object[] { "CREATE TABLE redHints ( id INTEGER PRIMARY KEY, redhintkey TEXT,module TEXT,redhintid INTEGER NOT NULL DEFAULT 0 );" });
    paramSQLiteDatabase.execSQL("CREATE TABLE redHints ( id INTEGER PRIMARY KEY, redhintkey TEXT,module TEXT,redhintid INTEGER NOT NULL DEFAULT 0 );");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */