package com.xiaoenai.app.data.entity.mapper;

import com.xiaoenai.app.data.entity.UserEntity;
import com.xiaoenai.app.domain.e;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserEntityDataMapper
{
  public e transform(UserEntity paramUserEntity)
  {
    e locale = new e();
    if (paramUserEntity != null)
    {
      locale.a(paramUserEntity.getUserId());
      locale.a(paramUserEntity.getUserName());
      locale.b(paramUserEntity.getNickname());
      locale.e(paramUserEntity.getAvatar());
      locale.c(paramUserEntity.getEmail());
      locale.d(paramUserEntity.getPhoneNum());
      locale.b(paramUserEntity.getOnlineTime());
      locale.e(paramUserEntity.getLoverId());
      locale.f(paramUserEntity.getLoverUserName());
      locale.g(paramUserEntity.getLoverNickname());
      locale.j(paramUserEntity.getLoverAvatar());
      locale.h(paramUserEntity.getLoverEmail());
      locale.i(paramUserEntity.getLoverPhoneNum());
      locale.f(paramUserEntity.getLoverOnlineTime());
      locale.k(paramUserEntity.getCouplePhotoUrl());
      locale.a(paramUserEntity.getLovedTime());
      locale.c(paramUserEntity.getDiamonds());
      locale.d(paramUserEntity.getCoin());
      locale.m(paramUserEntity.getQQNickname());
      locale.n(paramUserEntity.getSinaNickname());
      locale.l(paramUserEntity.getWXNickname());
      locale.o(paramUserEntity.getLoverQQNickname());
      locale.p(paramUserEntity.getLoverSinaNickname());
      locale.q(paramUserEntity.getLoverWXNickname());
      locale.r(paramUserEntity.getEmUsername());
      locale.s(paramUserEntity.getEmPassword());
      locale.t(paramUserEntity.getEmLoverUsername());
      locale.b(paramUserEntity.getFirstTogetherTs());
      locale.u(paramUserEntity.getIp());
      locale.v(paramUserEntity.getLoverIp());
      locale.c(paramUserEntity.getRegistTs());
      locale.d(paramUserEntity.getLoverRegistTs());
      locale.x(paramUserEntity.getLoverDeviceJb());
      locale.y(paramUserEntity.getLoverDeviceOs());
      locale.z(paramUserEntity.getLoverDeviceVer());
      locale.w(paramUserEntity.getLoverAppChannel());
      locale.A(paramUserEntity.getLoverAppVer());
    }
    return locale;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\entity\mapper\UserEntityDataMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */