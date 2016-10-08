package rx.c.b;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.a.e;
import rx.c.c.m;
import rx.h.b;
import rx.l;

public final class d
  extends AtomicReference<Thread>
  implements Runnable, l
{
  private static final long serialVersionUID = -3962399486978279857L;
  final m a;
  final rx.b.a b;
  
  public d(rx.b.a parama)
  {
    this.b = parama;
    this.a = new m();
  }
  
  public d(rx.b.a parama, m paramm)
  {
    this.b = parama;
    this.a = new m(new c(this, paramm));
  }
  
  public d(rx.b.a parama, b paramb)
  {
    this.b = parama;
    this.a = new m(new b(this, paramb));
  }
  
  public void a(Future<?> paramFuture)
  {
    this.a.a(new a(paramFuture, null));
  }
  
  public void a(b paramb)
  {
    this.a.a(new b(this, paramb));
  }
  
  public void c()
  {
    if (!this.a.d()) {
      this.a.c();
    }
  }
  
  public boolean d()
  {
    return this.a.d();
  }
  
  public void run()
  {
    try
    {
      lazySet(Thread.currentThread());
      this.b.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof e)) {}
      for (IllegalStateException localIllegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", localThrowable);; localIllegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", localIllegalStateException))
      {
        rx.e.d.a().b().a(localIllegalStateException);
        Thread localThread = Thread.currentThread();
        localThread.getUncaughtExceptionHandler().uncaughtException(localThread, localIllegalStateException);
        return;
      }
    }
    finally
    {
      c();
    }
  }
  
  private final class a
    implements l
  {
    private final Future<?> b;
    
    private a()
    {
      Future localFuture;
      this.b = localFuture;
    }
    
    public void c()
    {
      if (d.this.get() != Thread.currentThread())
      {
        this.b.cancel(true);
        return;
      }
      this.b.cancel(false);
    }
    
    public boolean d()
    {
      return this.b.isCancelled();
    }
  }
  
  private static final class b
    extends AtomicBoolean
    implements l
  {
    private static final long serialVersionUID = 247232374289553518L;
    final d a;
    final b b;
    
    public b(d paramd, b paramb)
    {
      this.a = paramd;
      this.b = paramb;
    }
    
    public void c()
    {
      if (compareAndSet(false, true)) {
        this.b.b(this.a);
      }
    }
    
    public boolean d()
    {
      return this.a.d();
    }
  }
  
  private static final class c
    extends AtomicBoolean
    implements l
  {
    private static final long serialVersionUID = 247232374289553518L;
    final d a;
    final m b;
    
    public c(d paramd, m paramm)
    {
      this.a = paramd;
      this.b = paramm;
    }
    
    public void c()
    {
      if (compareAndSet(false, true)) {
        this.b.b(this.a);
      }
    }
    
    public boolean d()
    {
      return this.a.d();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */