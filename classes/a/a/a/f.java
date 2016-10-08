package a.a.a;

import android.database.Cursor;
import java.util.List;

public final class f<T>
{
  private final a<T, ?> a;
  
  public f(a<T, ?> parama)
  {
    this.a = parama;
  }
  
  public List<T> a(Cursor paramCursor)
  {
    return this.a.loadAllAndCloseCursor(paramCursor);
  }
  
  public T b(Cursor paramCursor)
  {
    return (T)this.a.loadUniqueAndCloseCursor(paramCursor);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */