package com.xiaoenai.app.data.e;

import com.xiaoenai.app.data.e.a.a.b;
import com.xiaoenai.app.data.entity.mapper.AppModelEntityDataMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class a
  implements com.xiaoenai.app.domain.e.a
{
  private final AppModelEntityDataMapper a;
  private final b b;
  
  @Inject
  public a(b paramb, AppModelEntityDataMapper paramAppModelEntityDataMapper)
  {
    this.a = paramAppModelEntityDataMapper;
    this.b = paramb;
  }
  
  public com.xiaoenai.app.domain.a a()
  {
    return this.a.transform(this.b.a().a());
  }
  
  public void b()
  {
    this.b.a().b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */