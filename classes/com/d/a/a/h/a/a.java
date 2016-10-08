package com.d.a.a.h.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class a
  extends SQLiteOpenHelper
{
  static final c.b a = new c.b("_id", "integer", 0);
  static final c.b b = new c.b("priority", "integer", 1);
  static final c.b c = new c.b("group_id", "text", 2);
  static final c.b d = new c.b("run_count", "integer", 3);
  static final c.b e = new c.b("base_job", "byte", 4);
  static final c.b f = new c.b("created_ns", "long", 5);
  static final c.b g = new c.b("delay_until_ns", "long", 6);
  static final c.b h = new c.b("running_session_id", "long", 7);
  static final c.b i = new c.b("requires_network", "integer", 8);
  
  public a(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 3);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(c.a("job_holder", a, new c.b[] { b, c, d, e, f, g, h, i }));
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL(c.a("job_holder"));
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\h\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */