package com.xiaoenai.app.data.entity.mapper;

import com.xiaoenai.app.data.entity.AppModelEntity;
import com.xiaoenai.app.domain.a;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppModelEntityDataMapper
{
  public a transform(AppModelEntity paramAppModelEntity)
  {
    a locala = new a();
    if (paramAppModelEntity != null)
    {
      locala.a(paramAppModelEntity.getUserId());
      locala.c(paramAppModelEntity.getAccount());
      locala.e(paramAppModelEntity.getAudioKey());
      locala.b(paramAppModelEntity.getImageKey());
      locala.f(paramAppModelEntity.getRegisterPhone());
      locala.d(paramAppModelEntity.getSigKey());
      locala.a(paramAppModelEntity.getToken());
    }
    return locala;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\entity\mapper\AppModelEntityDataMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */