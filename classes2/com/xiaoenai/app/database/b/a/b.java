package com.xiaoenai.app.database.b.a;

import a.a.a.a;
import a.a.a.d.d;
import a.a.a.d.i;
import a.a.a.d.k;
import a.a.a.g;
import com.xiaoenai.app.database.bean.DaoSession;
import java.util.List;

public class b<T>
  implements com.xiaoenai.app.database.a.b<T>
{
  private DaoSession a;
  
  public b(DaoSession paramDaoSession)
  {
    this.a = paramDaoSession;
  }
  
  public long a(T paramT)
  {
    return this.a.insert(paramT);
  }
  
  public List a(Class<?> paramClass, int paramInt, g[] paramArrayOfg)
  {
    return this.a.queryBuilder(paramClass).a(paramArrayOfg).a(paramInt).c();
  }
  
  public List a(Class<?> paramClass, g... paramVarArgs)
  {
    return this.a.queryBuilder(paramClass).a(paramVarArgs).c();
  }
  
  public void a(Class<?> paramClass)
  {
    this.a.deleteAll(paramClass);
  }
  
  public void a(Class<?> paramClass, long paramLong, g paramg)
  {
    this.a.queryBuilder(paramClass).a(paramg.a(Long.valueOf(paramLong)), new k[0]).b().b();
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    this.a.getDao(paramList.get(0).getClass()).insertOrReplaceInTx(paramList);
  }
  
  public long b(Class<?> paramClass)
  {
    return this.a.getDao(paramClass).count();
  }
  
  public void b(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    this.a.getDao(paramList.get(0).getClass()).deleteInTx(paramList);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\database\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */