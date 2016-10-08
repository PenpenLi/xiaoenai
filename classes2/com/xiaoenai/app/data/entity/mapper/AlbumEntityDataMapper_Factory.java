package com.xiaoenai.app.data.entity.mapper;

import dagger.internal.b;

public enum AlbumEntityDataMapper_Factory
  implements b<AlbumEntityDataMapper>
{
  INSTANCE;
  
  private AlbumEntityDataMapper_Factory() {}
  
  public static b<AlbumEntityDataMapper> create()
  {
    return INSTANCE;
  }
  
  public AlbumEntityDataMapper get()
  {
    return new AlbumEntityDataMapper();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\entity\mapper\AlbumEntityDataMapper_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */