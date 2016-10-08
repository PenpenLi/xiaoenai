package a.a.a;

import a.a.a.a.e;
import a.a.a.d.i;
import android.database.sqlite.SQLiteDatabase;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class c
{
  private final SQLiteDatabase db;
  private final Map<Class<?>, a<?, ?>> entityToDao;
  
  public c(SQLiteDatabase paramSQLiteDatabase)
  {
    this.db = paramSQLiteDatabase;
    this.entityToDao = new HashMap();
  }
  
  public <V> V callInTx(Callable<V> paramCallable)
  {
    this.db.beginTransaction();
    try
    {
      paramCallable = paramCallable.call();
      this.db.setTransactionSuccessful();
      return paramCallable;
    }
    finally
    {
      this.db.endTransaction();
    }
  }
  
  public <V> V callInTxNoException(Callable<V> paramCallable)
  {
    this.db.beginTransaction();
    try
    {
      paramCallable = paramCallable.call();
      this.db.setTransactionSuccessful();
      return paramCallable;
    }
    catch (Exception paramCallable)
    {
      throw new d("Callable failed", paramCallable);
    }
    finally
    {
      this.db.endTransaction();
    }
  }
  
  public <T> void delete(T paramT)
  {
    getDao(paramT.getClass()).delete(paramT);
  }
  
  public <T> void deleteAll(Class<T> paramClass)
  {
    getDao(paramClass).deleteAll();
  }
  
  public Collection<a<?, ?>> getAllDaos()
  {
    return Collections.unmodifiableCollection(this.entityToDao.values());
  }
  
  public a<?, ?> getDao(Class<? extends Object> paramClass)
  {
    a locala = (a)this.entityToDao.get(paramClass);
    if (locala == null) {
      throw new d("No DAO registered for " + paramClass);
    }
    return locala;
  }
  
  public SQLiteDatabase getDatabase()
  {
    return this.db;
  }
  
  public <T> long insert(T paramT)
  {
    return getDao(paramT.getClass()).insert(paramT);
  }
  
  public <T> long insertOrReplace(T paramT)
  {
    return getDao(paramT.getClass()).insertOrReplace(paramT);
  }
  
  public <T, K> T load(Class<T> paramClass, K paramK)
  {
    return (T)getDao(paramClass).load(paramK);
  }
  
  public <T, K> List<T> loadAll(Class<T> paramClass)
  {
    return getDao(paramClass).loadAll();
  }
  
  public <T> i<T> queryBuilder(Class<T> paramClass)
  {
    return getDao(paramClass).queryBuilder();
  }
  
  public <T, K> List<T> queryRaw(Class<T> paramClass, String paramString, String... paramVarArgs)
  {
    return getDao(paramClass).queryRaw(paramString, paramVarArgs);
  }
  
  public <T> void refresh(T paramT)
  {
    getDao(paramT.getClass()).refresh(paramT);
  }
  
  protected <T> void registerDao(Class<T> paramClass, a<T, ?> parama)
  {
    this.entityToDao.put(paramClass, parama);
  }
  
  public void runInTx(Runnable paramRunnable)
  {
    this.db.beginTransaction();
    try
    {
      paramRunnable.run();
      this.db.setTransactionSuccessful();
      return;
    }
    finally
    {
      this.db.endTransaction();
    }
  }
  
  public e startAsyncSession()
  {
    return new e(this);
  }
  
  public <T> void update(T paramT)
  {
    getDao(paramT.getClass()).update(paramT);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */