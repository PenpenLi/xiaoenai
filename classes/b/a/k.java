package b.a;

import java.util.concurrent.ThreadFactory;

final class k
  implements ThreadFactory
{
  k(String paramString, boolean paramBoolean) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, this.a);
    paramRunnable.setDaemon(this.b);
    return paramRunnable;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */