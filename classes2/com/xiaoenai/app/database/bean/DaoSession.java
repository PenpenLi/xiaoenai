package com.xiaoenai.app.database.bean;

import a.a.a.b.d;
import a.a.a.c;
import android.database.sqlite.SQLiteDatabase;
import java.util.Map;

public class DaoSession
  extends c
{
  private final AlbumDataDao albumDataDao;
  private final a.a.a.c.a albumDataDaoConfig;
  private final LogEntityDao logEntityDao;
  private final a.a.a.c.a logEntityDaoConfig;
  
  public DaoSession(SQLiteDatabase paramSQLiteDatabase, d paramd, Map<Class<? extends a.a.a.a<?, ?>>, a.a.a.c.a> paramMap)
  {
    super(paramSQLiteDatabase);
    this.albumDataDaoConfig = ((a.a.a.c.a)paramMap.get(AlbumDataDao.class)).a();
    this.albumDataDaoConfig.a(paramd);
    this.logEntityDaoConfig = ((a.a.a.c.a)paramMap.get(LogEntityDao.class)).a();
    this.logEntityDaoConfig.a(paramd);
    this.albumDataDao = new AlbumDataDao(this.albumDataDaoConfig, this);
    this.logEntityDao = new LogEntityDao(this.logEntityDaoConfig, this);
    registerDao(AlbumData.class, this.albumDataDao);
    registerDao(LogEntity.class, this.logEntityDao);
  }
  
  public void clear()
  {
    this.albumDataDaoConfig.b().a();
    this.logEntityDaoConfig.b().a();
  }
  
  public AlbumDataDao getAlbumDataDao()
  {
    return this.albumDataDao;
  }
  
  public LogEntityDao getLogEntityDao()
  {
    return this.logEntityDao;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\database\bean\DaoSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */