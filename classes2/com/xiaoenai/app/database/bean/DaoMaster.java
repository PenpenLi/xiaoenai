package com.xiaoenai.app.database.bean;

import a.a.a.b;
import a.a.a.b.d;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DaoMaster
  extends b
{
  public static final int SCHEMA_VERSION = 2;
  
  public DaoMaster(SQLiteDatabase paramSQLiteDatabase)
  {
    super(paramSQLiteDatabase, 2);
    registerDaoClass(AlbumDataDao.class);
    registerDaoClass(LogEntityDao.class);
  }
  
  public static void createAllTables(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    AlbumDataDao.createTable(paramSQLiteDatabase, paramBoolean);
    LogEntityDao.createTable(paramSQLiteDatabase, paramBoolean);
  }
  
  public static void dropAllTables(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    AlbumDataDao.dropTable(paramSQLiteDatabase, paramBoolean);
    LogEntityDao.dropTable(paramSQLiteDatabase, paramBoolean);
  }
  
  public DaoSession newSession()
  {
    return new DaoSession(this.db, d.a, this.daoConfigMap);
  }
  
  public DaoSession newSession(d paramd)
  {
    return new DaoSession(this.db, paramd, this.daoConfigMap);
  }
  
  public static class DevOpenHelper
    extends DaoMaster.OpenHelper
  {
    public DevOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory)
    {
      super(paramString, paramCursorFactory);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.i("greenDAO", "Upgrading schema from version " + paramInt1 + " to " + paramInt2 + " by dropping all tables");
      DaoMaster.dropAllTables(paramSQLiteDatabase, true);
      onCreate(paramSQLiteDatabase);
    }
  }
  
  public static abstract class OpenHelper
    extends SQLiteOpenHelper
  {
    public OpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory)
    {
      super(paramString, paramCursorFactory, 2);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      Log.i("greenDAO", "Creating tables for schema version 2");
      DaoMaster.createAllTables(paramSQLiteDatabase, false);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\database\bean\DaoMaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */