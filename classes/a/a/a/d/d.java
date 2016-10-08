package a.a.a.d;

import android.database.sqlite.SQLiteDatabase;

public class d<T>
  extends a<T>
{
  private final a<T> f;
  
  private d(a<T> parama, a.a.a.a<T, ?> parama1, String paramString, String[] paramArrayOfString)
  {
    super(parama1, paramString, paramArrayOfString);
    this.f = parama;
  }
  
  static <T2> d<T2> a(a.a.a.a<T2, ?> parama, String paramString, Object[] paramArrayOfObject)
  {
    return (d)new a(parama, paramString, a(paramArrayOfObject), null).a();
  }
  
  public void b()
  {
    a();
    SQLiteDatabase localSQLiteDatabase = this.a.getDatabase();
    if (localSQLiteDatabase.isDbLockedByCurrentThread())
    {
      this.a.getDatabase().execSQL(this.c, this.d);
      return;
    }
    localSQLiteDatabase.beginTransaction();
    try
    {
      this.a.getDatabase().execSQL(this.c, this.d);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  private static final class a<T2>
    extends b<T2, d<T2>>
  {
    private a(a.a.a.a<T2, ?> parama, String paramString, String[] paramArrayOfString)
    {
      super(paramString, paramArrayOfString);
    }
    
    protected d<T2> d()
    {
      return new d(this, this.b, this.a, (String[])this.c.clone(), null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */