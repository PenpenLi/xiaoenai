package com.xiaoenai.app.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.File;

public class d
  extends SQLiteOpenHelper
{
  public static final String a = Environment.getExternalStorageDirectory() + File.separator + ".com.xiaoenai";
  public static String b = "com.xiaoenai.http.analytics.db";
  private Handler c;
  
  public d(Context paramContext, int paramInt, String paramString)
  {
    super(new a(paramContext, a), b, null, paramInt);
    paramContext = new HandlerThread(paramString);
    paramContext.start();
    this.c = new Handler(paramContext.getLooper());
  }
  
  public int a()
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.rawQuery("select _id from analytics desc limit 0,1", null);
    int i = -1;
    int j = i;
    if (localCursor != null)
    {
      if (localCursor.moveToNext()) {
        i = localCursor.getInt(localCursor.getColumnIndex("_id"));
      }
      localCursor.close();
      j = i;
    }
    localSQLiteDatabase.close();
    return j;
  }
  
  public void a(int paramInt)
  {
    paramInt -= 10000;
    if (paramInt > 0)
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localSQLiteDatabase.delete("analytics", "_id < ?", new String[] { String.valueOf(paramInt) });
      localSQLiteDatabase.close();
    }
  }
  
  public void a(ContentValues paramContentValues)
  {
    if (paramContentValues != null) {
      try
      {
        a(new e(this, paramContentValues));
        return;
      }
      finally {}
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.c.post(paramRunnable);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS analytics(_id INTEGER PRIMARY KEY autoincrement, request_url TEXT, request_parameters TEXT, request_method INTEGER, request_time INTEGER, response_time INTEGER, response_code INTEGER, response_result TEXT, request_size INTEGER, response_size INTEGER )");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */