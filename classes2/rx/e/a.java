package rx.e;

import rx.a.b;
import rx.annotations.Experimental;

public abstract class a
{
  @Experimental
  public final String a(Object paramObject)
  {
    try
    {
      String str = b(paramObject);
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      return paramObject.getClass().getName() + ".errorRendering";
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        b.a(localThrowable);
      }
    }
  }
  
  public void a(Throwable paramThrowable) {}
  
  @Experimental
  protected String b(Object paramObject)
  {
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */