package rx.h;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.l;

public final class a
  implements l
{
  static final AtomicIntegerFieldUpdater<a> b = AtomicIntegerFieldUpdater.newUpdater(a.class, "a");
  volatile int a;
  private final rx.b.a c;
  
  public a()
  {
    this.c = null;
  }
  
  private a(rx.b.a parama)
  {
    this.c = parama;
  }
  
  public static a a()
  {
    return new a();
  }
  
  public static a a(rx.b.a parama)
  {
    return new a(parama);
  }
  
  public final void c()
  {
    if ((b.compareAndSet(this, 0, 1)) && (this.c != null)) {
      this.c.a();
    }
  }
  
  public boolean d()
  {
    return this.a != 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */