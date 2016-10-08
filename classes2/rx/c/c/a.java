package rx.c.c;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import rx.c.c.a.y;
import rx.i;
import rx.i.a;

public abstract class a<T>
{
  private Queue<T> a;
  private final int b;
  private i.a c;
  
  public a()
  {
    this(0, 0, 67L);
  }
  
  private a(int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramInt2;
    a(paramInt1);
    this.c = rx.f.d.b().a();
    this.c.a(new b(this, paramInt1, paramInt2), paramLong, paramLong, TimeUnit.SECONDS);
  }
  
  private void a(int paramInt)
  {
    if (y.a()) {}
    for (this.a = new rx.c.c.a.d(Math.max(this.b, 1024));; this.a = new ConcurrentLinkedQueue())
    {
      int i = 0;
      while (i < paramInt)
      {
        this.a.add(b());
        i += 1;
      }
    }
  }
  
  public T a()
  {
    Object localObject2 = this.a.poll();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = b();
    }
    return (T)localObject1;
  }
  
  public void a(T paramT)
  {
    if (paramT == null) {
      return;
    }
    this.a.offer(paramT);
  }
  
  protected abstract T b();
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */