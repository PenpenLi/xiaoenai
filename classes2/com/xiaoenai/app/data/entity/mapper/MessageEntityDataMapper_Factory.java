package com.xiaoenai.app.data.entity.mapper;

import dagger.internal.b;

public enum MessageEntityDataMapper_Factory
  implements b<MessageEntityDataMapper>
{
  INSTANCE;
  
  private MessageEntityDataMapper_Factory() {}
  
  public static b<MessageEntityDataMapper> create()
  {
    return INSTANCE;
  }
  
  public MessageEntityDataMapper get()
  {
    return new MessageEntityDataMapper();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\entity\mapper\MessageEntityDataMapper_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */