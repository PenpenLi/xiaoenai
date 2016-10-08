package rx.h;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.l;

public final class c
  implements l
{
  static final AtomicReferenceFieldUpdater<c, a> b = AtomicReferenceFieldUpdater.newUpdater(c.class, a.class, "a");
  volatile a a = new a(false, d.a());
  
  public void a(l paraml)
  {
    if (paraml == null) {
      throw new IllegalArgumentException("Subscription can not be null");
    }
    a locala1;
    a locala2;
    do
    {
      locala1 = this.a;
      if (locala1.a)
      {
        paraml.c();
        return;
      }
      locala2 = locala1.a(paraml);
    } while (!b.compareAndSet(this, locala1, locala2));
  }
  
  public void c()
  {
    a locala1;
    a locala2;
    do
    {
      locala1 = this.a;
      if (locala1.a) {
        return;
      }
      locala2 = locala1.a();
    } while (!b.compareAndSet(this, locala1, locala2));
    locala1.b.c();
  }
  
  public boolean d()
  {
    return this.a.a;
  }
  
  private static final class a
  {
    final boolean a;
    final l b;
    
    a(boolean paramBoolean, l paraml)
    {
      this.a = paramBoolean;
      this.b = paraml;
    }
    
    a a()
    {
      return new a(true, this.b);
    }
    
    a a(l paraml)
    {
      return new a(this.a, paraml);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */