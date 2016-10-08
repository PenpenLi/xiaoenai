package com.xiaoenai.app.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.classes.gameCenter.model.GameEntry;
import com.xiaoenai.app.d.a.b;
import java.util.Vector;

public class k
  extends b
{
  public static String a = "CREATE TABLE gamelist (id INTEGER PRIMARY KEY,name TEXT,appKey TEXT,intro TEXT,icon_url TEXT,package TEXT,start_type INTEGER,login_url TEXT);";
  
  public k()
  {
    super("gameNewList.db", b);
  }
  
  public Vector<GameEntry> a()
  {
    Vector localVector = new Vector();
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("gamelist", null, null, null, null, null, null);
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      do
      {
        a(null, localCursor);
        localVector.add(null);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    localSQLiteDatabase.close();
    return localVector;
  }
  
  public void a(GameEntry paramGameEntry)
  {
    a(new l(this, paramGameEntry));
  }
  
  public void a(GameEntry paramGameEntry, Cursor paramCursor)
  {
    paramGameEntry.setId(paramCursor.getInt(paramCursor.getColumnIndex("id")));
    paramGameEntry.setName(paramCursor.getString(paramCursor.getColumnIndex("name")));
    paramGameEntry.setAppKey(paramCursor.getString(paramCursor.getColumnIndex("appKey")));
    paramGameEntry.setMpackage(paramCursor.getString(paramCursor.getColumnIndex("package")));
    paramGameEntry.setIntro(paramCursor.getString(paramCursor.getColumnIndex("intro")));
    paramGameEntry.setIcon_url(paramCursor.getString(paramCursor.getColumnIndex("icon_url")));
    paramGameEntry.setStartType(paramCursor.getInt(paramCursor.getColumnIndex("start_type")));
    paramGameEntry.setLoginUrl(paramCursor.getString(paramCursor.getColumnIndex("login_url")));
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL(a);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */