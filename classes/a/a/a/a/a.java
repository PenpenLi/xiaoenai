package a.a.a.a;

import android.database.sqlite.SQLiteDatabase;

public class a
{
  final a a;
  final a.a.a.a<Object, Object> b;
  final Object c;
  final int d;
  volatile long e;
  volatile long f;
  volatile Throwable g;
  volatile Object h;
  volatile int i;
  private final SQLiteDatabase j;
  private volatile boolean k;
  
  public boolean a()
  {
    return (this.d & 0x1) != 0;
  }
  
  boolean a(a parama)
  {
    return (parama != null) && (a()) && (parama.a()) && (b() == parama.b());
  }
  
  SQLiteDatabase b()
  {
    if (this.j != null) {
      return this.j;
    }
    return this.b.getDatabase();
  }
  
  public boolean c()
  {
    return this.g != null;
  }
  
  void d()
  {
    try
    {
      this.k = true;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void e()
  {
    this.e = 0L;
    this.f = 0L;
    this.k = false;
    this.g = null;
    this.h = null;
    this.i = 0;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */