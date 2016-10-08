package com.f.a;

public abstract class n
  implements Runnable
{
  public abstract void a();
  
  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (localThrowable == null) {}
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\f\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */