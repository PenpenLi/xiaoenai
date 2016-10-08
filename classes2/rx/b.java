package rx;

import rx.a.e;

class b
  implements a.a<R>
{
  b(a parama, a.b paramb) {}
  
  public void a(k<? super R> paramk)
  {
    try
    {
      k localk = (k)a.d().a(this.a).a(paramk);
      try
      {
        localk.b();
        this.b.a.a(localk);
        return;
      }
      catch (Throwable localThrowable2)
      {
        if (!(localThrowable2 instanceof e)) {
          break label64;
        }
      }
      throw ((e)localThrowable2);
    }
    catch (Throwable localThrowable1)
    {
      if ((localThrowable1 instanceof e))
      {
        throw ((e)localThrowable1);
        label64:
        localThrowable1.a(localThrowable2);
        return;
      }
      paramk.a(localThrowable1);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */