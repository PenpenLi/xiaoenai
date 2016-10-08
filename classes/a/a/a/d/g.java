package a.a.a.d;

import a.a.a.a;
import a.a.a.f;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;

public class g<T>
  extends c<T>
{
  private final a<T> h;
  
  private g(a<T> parama, a<T, ?> parama1, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    super(parama1, paramString, paramArrayOfString, paramInt1, paramInt2);
    this.h = parama;
  }
  
  public static <T2> g<T2> a(a<T2, ?> parama, String paramString, Object[] paramArrayOfObject)
  {
    return a(parama, paramString, paramArrayOfObject, -1, -1);
  }
  
  static <T2> g<T2> a(a<T2, ?> parama, String paramString, Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    return (g)new a(parama, paramString, a(paramArrayOfObject), paramInt1, paramInt2).a();
  }
  
  public g<T> b()
  {
    return (g)this.h.a(this);
  }
  
  public List<T> c()
  {
    a();
    Cursor localCursor = this.a.getDatabase().rawQuery(this.c, this.d);
    return this.b.a(localCursor);
  }
  
  public T d()
  {
    a();
    Cursor localCursor = this.a.getDatabase().rawQuery(this.c, this.d);
    return (T)this.b.b(localCursor);
  }
  
  private static final class a<T2>
    extends b<T2, g<T2>>
  {
    private final int e;
    private final int f;
    
    a(a<T2, ?> parama, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
    {
      super(paramString, paramArrayOfString);
      this.e = paramInt1;
      this.f = paramInt2;
    }
    
    protected g<T2> d()
    {
      return new g(this, this.b, this.a, (String[])this.c.clone(), this.e, this.f, null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */