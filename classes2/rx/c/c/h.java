package rx.c.c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public final class h
  implements ThreadFactory
{
  static final AtomicLongFieldUpdater<h> c = AtomicLongFieldUpdater.newUpdater(h.class, "b");
  final String a;
  volatile long b;
  
  public h(String paramString)
  {
    this.a = paramString;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, this.a + c.incrementAndGet(this));
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */