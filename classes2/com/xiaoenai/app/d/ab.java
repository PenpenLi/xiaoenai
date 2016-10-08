package com.xiaoenai.app.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.d.a.b;
import com.xiaoenai.app.model.RecentFace;
import java.util.ArrayList;
import java.util.List;

public class ab
  extends b
{
  private static String a = "CREATE TABLE recent_face (url TEXT PRIMARY KEY,use_count INT,face_type TEXT,used_at BIGINT );";
  
  public ab()
  {
    super("recent_face.db", b);
  }
  
  public RecentFace a(String paramString)
  {
    Object localObject = null;
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("recent_face", null, "url=?", new String[] { paramString }, null, null, "used_at DESC");
    paramString = (String)localObject;
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      paramString = new RecentFace();
      paramString.url = localCursor.getString(localCursor.getColumnIndex("url"));
      paramString.lastUsedTime = localCursor.getLong(localCursor.getColumnIndex("used_at"));
      paramString.usedCount = localCursor.getInt(localCursor.getColumnIndex("use_count"));
      paramString.faceType = localCursor.getString(localCursor.getColumnIndex("face_type"));
    }
    localCursor.close();
    localSQLiteDatabase.close();
    return paramString;
  }
  
  public List<RecentFace> a(int paramInt)
  {
    Object localObject = "used_at DESC LIMIT " + paramInt;
    ArrayList localArrayList = new ArrayList();
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    localObject = localSQLiteDatabase.query("recent_face", null, null, null, null, null, (String)localObject);
    if (((Cursor)localObject).getCount() > 0)
    {
      ((Cursor)localObject).moveToFirst();
      do
      {
        RecentFace localRecentFace = new RecentFace();
        localRecentFace.url = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("url"));
        localRecentFace.lastUsedTime = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("used_at"));
        localRecentFace.usedCount = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("use_count"));
        localRecentFace.faceType = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("face_type"));
        localArrayList.add(localRecentFace);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    localSQLiteDatabase.close();
    return localArrayList;
  }
  
  public void a(RecentFace paramRecentFace)
  {
    a(new ac(this, paramRecentFace));
  }
  
  public void b(RecentFace paramRecentFace)
  {
    a(new ad(this, paramRecentFace));
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


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */