package com.adhoc;

import java.util.concurrent.TimeUnit;

public class fk
{
  private static fk a = null;
  private bg b;
  
  private fk()
  {
    try
    {
      this.b = new bg();
      this.b.a(30L, TimeUnit.SECONDS);
      this.b.c(20L, TimeUnit.SECONDS);
      this.b.b(20L, TimeUnit.SECONDS);
      return;
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
    }
  }
  
  public static fk a()
  {
    try
    {
      if (a == null) {
        a = new fk();
      }
      return a;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fl.a(localThrowable);
      }
    }
  }
  
  public void a(bj parambj, an paraman)
  {
    try
    {
      this.b.a(parambj).a(paraman);
      return;
    }
    catch (Throwable parambj)
    {
      fl.a(parambj);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\fk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */