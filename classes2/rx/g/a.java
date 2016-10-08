package rx.g;

import java.util.ArrayList;
import java.util.List;
import rx.a.a;

public final class a<T>
  extends e<T, T>
{
  final f<T> b;
  private final rx.c.a.b<T> c = rx.c.a.b.a();
  
  protected a(a.a<T> parama, f<T> paramf)
  {
    super(parama);
    this.b = paramf;
  }
  
  public static <T> a<T> e()
  {
    f localf = new f();
    localf.h = new b(localf);
    return new a(localf, localf);
  }
  
  public void a()
  {
    if (this.b.e)
    {
      Object localObject = this.c.b();
      f.b[] arrayOfb = this.b.c(localObject);
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        arrayOfb[i].a(localObject, this.b.i);
        i += 1;
      }
    }
  }
  
  public void a(T paramT)
  {
    f.b[] arrayOfb = this.b.b();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      arrayOfb[i].a(paramT);
      i += 1;
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    if (this.b.e)
    {
      Object localObject2 = this.c.a(paramThrowable);
      f.b[] arrayOfb = this.b.c(localObject2);
      int j = arrayOfb.length;
      int i = 0;
      paramThrowable = null;
      for (;;)
      {
        if (i < j)
        {
          Object localObject1 = arrayOfb[i];
          try
          {
            ((f.b)localObject1).a(localObject2, this.b.i);
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              localObject1 = paramThrowable;
              if (paramThrowable == null) {
                localObject1 = new ArrayList();
              }
              ((List)localObject1).add(localThrowable);
              paramThrowable = (Throwable)localObject1;
            }
          }
        }
      }
      rx.a.b.a(paramThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */