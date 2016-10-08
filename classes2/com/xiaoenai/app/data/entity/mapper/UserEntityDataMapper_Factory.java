package com.xiaoenai.app.data.entity.mapper;

import dagger.internal.b;

public enum UserEntityDataMapper_Factory
  implements b<UserEntityDataMapper>
{
  INSTANCE;
  
  private UserEntityDataMapper_Factory() {}
  
  public static b<UserEntityDataMapper> create()
  {
    return INSTANCE;
  }
  
  public UserEntityDataMapper get()
  {
    return new UserEntityDataMapper();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\entity\mapper\UserEntityDataMapper_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */