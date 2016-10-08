package com.xiaoenai.app.data.e;

import com.xiaoenai.app.data.e.a.d.a;
import com.xiaoenai.app.data.e.a.d.b;
import com.xiaoenai.app.data.entity.mapper.UserEntityDataMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class q
  implements com.xiaoenai.app.domain.e.e
{
  private final b a;
  private final UserEntityDataMapper b;
  
  @Inject
  public q(b paramb, UserEntityDataMapper paramUserEntityDataMapper)
  {
    this.b = paramUserEntityDataMapper;
    this.a = paramb;
  }
  
  public com.xiaoenai.app.domain.e a()
  {
    return this.b.transform(this.a.a().a());
  }
  
  public void b()
  {
    this.a.a().b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\e\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */