package com.xiaoenai.app.data.entity.mapper;

import com.xiaoenai.app.data.entity.ImageEntity;
import com.xiaoenai.app.data.entity.ImageResultEntity;
import com.xiaoenai.app.domain.b;
import com.xiaoenai.app.domain.c;
import javax.inject.Inject;

public class ImageResultDataMapper
{
  private b transformImageModel(ImageEntity paramImageEntity)
  {
    b localb = new b();
    localb.a(paramImageEntity.getBase_url());
    localb.b(paramImageEntity.getKey());
    localb.b(paramImageEntity.getHeight());
    localb.a(paramImageEntity.getWidth());
    return localb;
  }
  
  public c transform(ImageResultEntity paramImageResultEntity)
  {
    c localc = new c();
    localc.a(paramImageResultEntity.getImagePath());
    localc.a(paramImageResultEntity.getProgress());
    if (paramImageResultEntity.getImageEntity() != null) {
      localc.a(transformImageModel(paramImageResultEntity.getImageEntity()));
    }
    return localc;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\entity\mapper\ImageResultDataMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */