package a.a.a;

import a.a.a.b.d;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public abstract class b
{
  protected final Map<Class<? extends a<?, ?>>, a.a.a.c.a> daoConfigMap;
  protected final SQLiteDatabase db;
  protected final int schemaVersion;
  
  public b(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    this.db = paramSQLiteDatabase;
    this.schemaVersion = paramInt;
    this.daoConfigMap = new HashMap();
  }
  
  public SQLiteDatabase getDatabase()
  {
    return this.db;
  }
  
  public int getSchemaVersion()
  {
    return this.schemaVersion;
  }
  
  public abstract c newSession();
  
  public abstract c newSession(d paramd);
  
  protected void registerDaoClass(Class<? extends a<?, ?>> paramClass)
  {
    a.a.a.c.a locala = new a.a.a.c.a(this.db, paramClass);
    this.daoConfigMap.put(paramClass, locala);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */