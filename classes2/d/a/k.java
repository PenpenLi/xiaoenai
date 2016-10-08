package d.a;

import com.f.a.a;

public class k
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler a;
  private r b;
  
  public k()
  {
    if (Thread.getDefaultUncaughtExceptionHandler() == this) {
      return;
    }
    this.a = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  private void a(Throwable paramThrowable)
  {
    if (a.h)
    {
      this.b.a(paramThrowable);
      return;
    }
    this.b.a(null);
  }
  
  public void a(r paramr)
  {
    this.b = paramr;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    a(paramThrowable);
    if ((this.a != null) && (this.a != Thread.getDefaultUncaughtExceptionHandler())) {
      this.a.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */