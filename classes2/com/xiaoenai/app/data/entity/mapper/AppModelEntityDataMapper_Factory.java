package com.xiaoenai.app.data.entity.mapper;

import dagger.internal.b;

public enum AppModelEntityDataMapper_Factory
  implements b<AppModelEntityDataMapper>
{
  INSTANCE;
  
  private AppModelEntityDataMapper_Factory() {}
  
  public static b<AppModelEntityDataMapper> create()
  {
    return INSTANCE;
  }
  
  public AppModelEntityDataMapper get()
  {
    return new AppModelEntityDataMapper();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\entity\mapper\AppModelEntityDataMapper_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */