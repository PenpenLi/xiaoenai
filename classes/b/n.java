package b;

class n
  implements Runnable
{
  n(m paramm) {}
  
  public void run()
  {
    long l1;
    do
    {
      l1 = this.a.a(System.nanoTime());
      if (l1 == -1L) {
        return;
      }
    } while (l1 <= 0L);
    long l2 = l1 / 1000000L;
    try
    {
      synchronized (this.a)
      {
        this.a.wait(l2, (int)(l1 - l2 * 1000000L));
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */