package rx.d;

import java.io.PrintStream;
import java.util.Arrays;
import rx.a.b;
import rx.a.e;
import rx.k;

public class a<T>
  extends k<T>
{
  boolean a = false;
  private final k<? super T> b;
  
  public a(k<? super T> paramk)
  {
    super(paramk);
    this.b = paramk;
  }
  
  private void c(Throwable paramThrowable)
  {
    System.err.println("RxJavaErrorHandler threw an Exception. It shouldn't. => " + paramThrowable.getMessage());
    paramThrowable.printStackTrace();
  }
  
  public void a()
  {
    if (!this.a) {
      this.a = true;
    }
    try
    {
      this.b.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      b.a(localThrowable);
      b(localThrowable);
      return;
    }
    finally
    {
      c();
    }
  }
  
  public void a(T paramT)
  {
    try
    {
      if (!this.a) {
        this.b.a(paramT);
      }
      return;
    }
    catch (Throwable paramT)
    {
      b.a(paramT);
      a(paramT);
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    b.a(paramThrowable);
    if (!this.a)
    {
      this.a = true;
      b(paramThrowable);
    }
  }
  
  protected void b(Throwable paramThrowable)
  {
    try
    {
      rx.e.d.a().b().a(paramThrowable);
    }
    catch (Throwable localThrowable6)
    {
      for (;;)
      {
        try
        {
          this.b.a(paramThrowable);
        }
        catch (Throwable localThrowable2)
        {
          if ((localThrowable2 instanceof e))
          {
            try
            {
              c();
              throw ((e)localThrowable2);
            }
            catch (Throwable localThrowable3) {}
            try
            {
              rx.e.d.a().b().a(localThrowable3);
              throw new RuntimeException("Observer.onError not implemented and error while unsubscribing.", new rx.a.a(Arrays.asList(new Throwable[] { paramThrowable, localThrowable3 })));
            }
            catch (Throwable localThrowable5)
            {
              c(localThrowable5);
              continue;
            }
          }
          try
          {
            rx.e.d.a().b().a(localThrowable3);
          }
          catch (Throwable localThrowable6)
          {
            try
            {
              c();
              throw new rx.a.d("Error occurred when trying to propagate error to Observer.onError", new rx.a.a(Arrays.asList(new Throwable[] { paramThrowable, localThrowable3 })));
            }
            catch (Throwable localThrowable7)
            {
              try
              {
                rx.e.d.a().b().a(localThrowable7);
                throw new rx.a.d("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new rx.a.a(Arrays.asList(new Throwable[] { paramThrowable, localThrowable3, localThrowable7 })));
              }
              catch (Throwable localThrowable8)
              {
                for (;;)
                {
                  c(localThrowable8);
                }
              }
            }
            localThrowable6 = localThrowable6;
            c(localThrowable6);
            continue;
          }
        }
        try
        {
          c();
          return;
        }
        catch (RuntimeException paramThrowable) {}
        localThrowable1 = localThrowable1;
        c(localThrowable1);
      }
    }
    try
    {
      rx.e.d.a().b().a(paramThrowable);
      throw new rx.a.d(paramThrowable);
    }
    catch (Throwable localThrowable4)
    {
      for (;;)
      {
        c(localThrowable4);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */