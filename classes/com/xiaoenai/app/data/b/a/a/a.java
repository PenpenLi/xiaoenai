package com.xiaoenai.app.data.b.a.a;

import a.a.a.g;
import com.xiaoenai.app.data.b.c;
import com.xiaoenai.app.database.b;
import com.xiaoenai.app.database.bean.LogEntity;
import com.xiaoenai.app.database.bean.LogEntityDao.Properties;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class a
  implements com.xiaoenai.app.data.b.a.a
{
  private final c a;
  
  @Inject
  public a(com.xiaoenai.app.data.b.a parama)
  {
    this.a = new c(parama);
  }
  
  public long a()
  {
    return this.a.b(LogEntity.class).b(LogEntity.class);
  }
  
  public long a(int paramInt, String paramString)
  {
    LogEntity localLogEntity = new LogEntity();
    localLogEntity.setMessage(paramString);
    localLogEntity.setPriority(Integer.valueOf(paramInt));
    localLogEntity.setTs(Long.valueOf(System.currentTimeMillis()));
    return this.a.b(LogEntity.class).a(localLogEntity);
  }
  
  public List<LogEntity> a(int paramInt)
  {
    return this.a.b(LogEntity.class).a(LogEntity.class, paramInt, new g[] { LogEntityDao.Properties.Id });
  }
  
  public void a(long paramLong)
  {
    this.a.b(LogEntity.class).a(LogEntity.class, paramLong, LogEntityDao.Properties.Id);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\b\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */