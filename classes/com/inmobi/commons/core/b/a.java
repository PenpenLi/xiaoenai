package com.inmobi.commons.core.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.inmobi.commons.a.b;

public class a
  extends SQLiteOpenHelper
{
  public static final String a = "com.im_" + b.c() + ".db";
  
  public a(Context paramContext)
  {
    super(paramContext, a, null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */