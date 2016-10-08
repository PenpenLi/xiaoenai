package com.xiaoenai.app.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xiaoenai.app.model.album.Photo;
import java.util.List;
import java.util.Vector;

public class a
  extends com.xiaoenai.app.d.a.b
{
  private static String a = "CREATE TABLE photos (photo_id INTEGER PRIMARY KEY,url TEXT,created_at INTEGER,is_original INT );";
  private static String d = "ALTER TABLE photos ADD COLUMN is_original INT ";
  
  public a()
  {
    super("photo.db", b, 2);
  }
  
  public Photo a(int paramInt)
  {
    Photo localPhoto = null;
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("photos", null, "photo_id=?", new String[] { String.valueOf(paramInt) }, null, null, "photo_id DESC");
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      localPhoto = new Photo();
      localPhoto.setId(localCursor.getInt(localCursor.getColumnIndex("photo_id")));
      localPhoto.setUrl(localCursor.getString(localCursor.getColumnIndex("url")));
      localPhoto.setCreateAt(localCursor.getInt(localCursor.getColumnIndex("created_at")));
      localPhoto.setIsOriginal(localCursor.getInt(localCursor.getColumnIndex("is_original")));
    }
    localCursor.close();
    localSQLiteDatabase.close();
    return localPhoto;
  }
  
  public void a()
  {
    a(new e(this));
  }
  
  public void a(Photo paramPhoto)
  {
    a(new b(this, paramPhoto));
  }
  
  public List<Photo> b()
  {
    Vector localVector = new Vector();
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("photos", null, null, null, null, null, "photo_id DESC");
    if (localCursor.getCount() > 0)
    {
      localCursor.moveToFirst();
      do
      {
        Photo localPhoto = new Photo();
        localPhoto.setId(localCursor.getInt(localCursor.getColumnIndex("photo_id")));
        localPhoto.setUrl(localCursor.getString(localCursor.getColumnIndex("url")));
        localPhoto.setCreateAt(localCursor.getInt(localCursor.getColumnIndex("created_at")));
        localPhoto.setIsOriginal(localCursor.getInt(localCursor.getColumnIndex("is_original")));
        localVector.add(localPhoto);
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    localSQLiteDatabase.close();
    return localVector;
  }
  
  public void b(Photo paramPhoto)
  {
    a(new c(this, paramPhoto));
  }
  
  public void c(Photo paramPhoto)
  {
    a(new d(this, paramPhoto));
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
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if ((paramInt2 > paramInt1) && (paramInt1 == 1)) {
      paramSQLiteDatabase.execSQL(d);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */