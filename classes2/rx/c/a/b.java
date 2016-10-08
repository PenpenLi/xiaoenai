package rx.c.a;

import java.io.Serializable;
import rx.g;

public final class b<T>
{
  private static final b a = new b();
  private static final Object b = new c();
  private static final Object c = new d();
  
  public static <T> b<T> a()
  {
    return a;
  }
  
  public Object a(T paramT)
  {
    Object localObject = paramT;
    if (paramT == null) {
      localObject = c;
    }
    return localObject;
  }
  
  public Object a(Throwable paramThrowable)
  {
    return new a(paramThrowable);
  }
  
  public boolean a(g<? super T> paramg, Object paramObject)
  {
    if (paramObject == b)
    {
      paramg.a();
      return true;
    }
    if (paramObject == c)
    {
      paramg.a(null);
      return false;
    }
    if (paramObject != null)
    {
      if (paramObject.getClass() == a.class)
      {
        paramg.a(a.a((a)paramObject));
        return true;
      }
      paramg.a(paramObject);
      return false;
    }
    throw new IllegalArgumentException("The lite notification can not be null");
  }
  
  public Object b()
  {
    return b;
  }
  
  public T b(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == c) {
      localObject = null;
    }
    return (T)localObject;
  }
  
  private static class a
    implements Serializable
  {
    private static final long serialVersionUID = 3L;
    private final Throwable a;
    
    public a(Throwable paramThrowable)
    {
      this.a = paramThrowable;
    }
    
    public String toString()
    {
      return "Notification=>Error:" + this.a;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */