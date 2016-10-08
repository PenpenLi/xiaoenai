package rx.g;

import rx.d.b;

public class c<T, R>
  extends e<T, R>
{
  private final b<T> b;
  private final e<T, R> c;
  
  public c(e<T, R> parame)
  {
    super(new d(parame));
    this.c = parame;
    this.b = new b(parame);
  }
  
  public void a()
  {
    this.b.a();
  }
  
  public void a(T paramT)
  {
    this.b.a(paramT);
  }
  
  public void a(Throwable paramThrowable)
  {
    this.b.a(paramThrowable);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */