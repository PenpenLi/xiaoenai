package d.a;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

class bg
  extends SQLiteOpenHelper
{
  private static Context b;
  private String a;
  
  private bg(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, str, paramCursorFactory, paramInt);
    b();
  }
  
  private bg(Context paramContext, String paramString1, String paramString2, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    this(new ci(paramContext, paramString1), paramString2, paramCursorFactory, paramInt);
  }
  
  public static bg a(Context paramContext)
  {
    try
    {
      b = paramContext;
      paramContext = a.a();
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      this.a = "create table if not exists limitedck(Id INTEGER primary key autoincrement, ck TEXT unique)";
      paramSQLiteDatabase.execSQL(this.a);
      return true;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      ax.d("create reference table error!");
    }
    return false;
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 71	d/a/bg:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore_1
    //   5: aload_0
    //   6: ldc 73
    //   8: aload_1
    //   9: invokevirtual 76	d/a/bg:a	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z
    //   12: ifeq +13 -> 25
    //   15: aload_0
    //   16: ldc 78
    //   18: aload_1
    //   19: invokevirtual 76	d/a/bg:a	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z
    //   22: ifne +9 -> 31
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 81	d/a/bg:c	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   30: pop
    //   31: aload_0
    //   32: ldc 83
    //   34: aload_1
    //   35: invokevirtual 76	d/a/bg:a	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z
    //   38: ifne +9 -> 47
    //   41: aload_0
    //   42: aload_1
    //   43: invokespecial 85	d/a/bg:b	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   46: pop
    //   47: aload_0
    //   48: ldc 87
    //   50: aload_1
    //   51: invokevirtual 76	d/a/bg:a	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)Z
    //   54: ifne +9 -> 63
    //   57: aload_0
    //   58: aload_1
    //   59: invokespecial 89	d/a/bg:a	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   62: pop
    //   63: return
    //   64: astore_1
    //   65: aload_1
    //   66: athrow
    //   67: astore_1
    //   68: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	bg
    //   4	55	1	localSQLiteDatabase	SQLiteDatabase
    //   64	2	1	localObject	Object
    //   67	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	25	64	finally
    //   25	31	64	finally
    //   31	47	64	finally
    //   47	63	64	finally
    //   0	25	67	java/lang/Exception
    //   25	31	67	java/lang/Exception
    //   31	47	67	java/lang/Exception
    //   47	63	67	java/lang/Exception
  }
  
  private boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      this.a = "create table if not exists system(Id INTEGER primary key autoincrement, key TEXT, timeStamp INTEGER, count INTEGER)";
      paramSQLiteDatabase.execSQL(this.a);
      return true;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      ax.d("create system table error!");
    }
    return false;
  }
  
  private boolean c(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      this.a = "create table if not exists aggregated_cache(Id INTEGER primary key autoincrement, key TEXT, totalTimestamp TEXT, value INTEGER, count INTEGER, label TEXT, timeWindowNum TEXT)";
      paramSQLiteDatabase.execSQL(this.a);
      this.a = "create table if not exists aggregated(Id INTEGER primary key autoincrement, key TEXT, totalTimestamp TEXT, value INTEGER, count INTEGER, label TEXT, timeWindowNum TEXT)";
      paramSQLiteDatabase.execSQL(this.a);
      return true;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      ax.d("create aggregated table error!");
    }
    return false;
  }
  
  public boolean a(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    String str2 = null;
    String str1 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramString == null) {}
    for (;;)
    {
      return bool2;
      try
      {
        paramString = paramSQLiteDatabase.rawQuery("select count(*) as c from sqlite_master where type ='table' and name ='" + paramString.trim() + "' ", null);
        boolean bool1 = bool3;
        str1 = paramString;
        str2 = paramString;
        if (paramString.moveToNext())
        {
          str1 = paramString;
          str2 = paramString;
          int i = paramString.getInt(0);
          bool1 = bool3;
          if (i > 0) {
            bool1 = true;
          }
        }
        bool2 = bool1;
        return bool1;
      }
      catch (Exception paramString)
      {
        return false;
      }
      finally
      {
        if (str2 != null) {
          str2.close();
        }
      }
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.beginTransaction();
      c(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
      a(paramSQLiteDatabase);
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  private static class a
  {
    private static final bg a = new bg(bg.a(), cd.a(bg.a()), "cc.db", null, 1, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */