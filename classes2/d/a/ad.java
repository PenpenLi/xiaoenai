package d.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

public class ad
{
  private static ad c;
  private static SQLiteOpenHelper d;
  private AtomicInteger a = new AtomicInteger();
  private AtomicInteger b = new AtomicInteger();
  private SQLiteDatabase e;
  
  public static ad a(Context paramContext)
  {
    try
    {
      if (c == null) {
        b(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  private static void b(Context paramContext)
  {
    try
    {
      if (c == null)
      {
        c = new ad();
        d = bg.a(paramContext);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public SQLiteDatabase a()
  {
    try
    {
      if (this.a.incrementAndGet() == 1) {
        this.e = d.getReadableDatabase();
      }
      SQLiteDatabase localSQLiteDatabase = this.e;
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public SQLiteDatabase b()
  {
    try
    {
      if (this.a.incrementAndGet() == 1) {
        this.e = d.getWritableDatabase();
      }
      SQLiteDatabase localSQLiteDatabase = this.e;
      return localSQLiteDatabase;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      if (this.a.decrementAndGet() == 0) {
        this.e.close();
      }
      if (this.b.decrementAndGet() == 0) {
        this.e.close();
      }
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */