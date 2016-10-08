package rx.f;

import rx.e.f;
import rx.i;

public final class d
{
  private static final d d = new d();
  private final i a;
  private final i b;
  private final i c;
  
  private d()
  {
    i locali = rx.e.d.a().d().a();
    if (locali != null)
    {
      this.a = locali;
      locali = rx.e.d.a().d().b();
      if (locali == null) {
        break label76;
      }
    }
    label76:
    for (this.b = locali;; this.b = new a())
    {
      locali = rx.e.d.a().d().c();
      if (locali == null) {
        break label90;
      }
      this.c = locali;
      return;
      this.a = new rx.c.b.a();
      break;
    }
    label90:
    this.c = c.b();
  }
  
  public static i a()
  {
    return d.c;
  }
  
  public static i b()
  {
    return d.a;
  }
  
  public static i c()
  {
    return d.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */