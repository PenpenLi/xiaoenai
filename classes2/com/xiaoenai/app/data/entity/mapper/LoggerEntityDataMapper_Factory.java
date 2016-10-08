package com.xiaoenai.app.data.entity.mapper;

import dagger.internal.b;

public enum LoggerEntityDataMapper_Factory
  implements b<LoggerEntityDataMapper>
{
  INSTANCE;
  
  private LoggerEntityDataMapper_Factory() {}
  
  public static b<LoggerEntityDataMapper> create()
  {
    return INSTANCE;
  }
  
  public LoggerEntityDataMapper get()
  {
    return new LoggerEntityDataMapper();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\entity\mapper\LoggerEntityDataMapper_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */