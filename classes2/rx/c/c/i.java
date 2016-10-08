package rx.c.c;

import rx.a.a;
import rx.b.f;

public final class i<T>
  extends rx.a<T>
{
  private final T b;
  
  protected i(T paramT)
  {
    super(new j(paramT));
    this.b = paramT;
  }
  
  public static final <T> i<T> a(T paramT)
  {
    return new i(paramT);
  }
  
  public T a()
  {
    return (T)this.b;
  }
  
  public rx.a<T> b(rx.i parami)
  {
    if ((parami instanceof rx.c.b.a)) {
      return a(new a((rx.c.b.a)parami, this.b));
    }
    return a(new b(parami, this.b));
  }
  
  public <R> rx.a<R> c(f<? super T, ? extends rx.a<? extends R>> paramf)
  {
    return a(new k(this, paramf));
  }
  
  static final class a<T>
    implements a.a<T>
  {
    private final rx.c.b.a a;
    private final T b;
    
    a(rx.c.b.a parama, T paramT)
    {
      this.a = parama;
      this.b = paramT;
    }
    
    public void a(rx.k<? super T> paramk)
    {
      paramk.a(this.a.a(new i.c(paramk, this.b, null)));
    }
  }
  
  static final class b<T>
    implements a.a<T>
  {
    private final rx.i a;
    private final T b;
    
    b(rx.i parami, T paramT)
    {
      this.a = parami;
      this.b = paramT;
    }
    
    public void a(rx.k<? super T> paramk)
    {
      rx.i.a locala = this.a.a();
      paramk.a(locala);
      locala.a(new i.c(paramk, this.b, null));
    }
  }
  
  static final class c<T>
    implements rx.b.a
  {
    private final rx.k<? super T> a;
    private final T b;
    
    private c(rx.k<? super T> paramk, T paramT)
    {
      this.a = paramk;
      this.b = paramT;
    }
    
    public void a()
    {
      try
      {
        this.a.a(this.b);
        this.a.a();
        return;
      }
      catch (Throwable localThrowable)
      {
        this.a.a(localThrowable);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */