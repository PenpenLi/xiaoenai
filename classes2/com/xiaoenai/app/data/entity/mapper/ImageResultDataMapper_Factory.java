package com.xiaoenai.app.data.entity.mapper;

import dagger.internal.b;

public enum ImageResultDataMapper_Factory
  implements b<ImageResultDataMapper>
{
  INSTANCE;
  
  private ImageResultDataMapper_Factory() {}
  
  public static b<ImageResultDataMapper> create()
  {
    return INSTANCE;
  }
  
  public ImageResultDataMapper get()
  {
    return new ImageResultDataMapper();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\entity\mapper\ImageResultDataMapper_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */