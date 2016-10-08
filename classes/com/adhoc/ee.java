package com.adhoc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ee
  extends Exception
{
  private static final Method a;
  private IOException b;
  
  static
  {
    try
    {
      Method localMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
      a = localMethod;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public ee(IOException paramIOException)
  {
    super(paramIOException);
    this.b = paramIOException;
  }
  
  private void a(IOException paramIOException1, IOException paramIOException2)
  {
    if (a != null) {}
    try
    {
      a.invoke(paramIOException1, new Object[] { paramIOException2 });
      return;
    }
    catch (InvocationTargetException paramIOException1)
    {
      fl.a(paramIOException1);
      return;
    }
    catch (Throwable paramIOException1)
    {
      fl.a(paramIOException1);
      return;
    }
    catch (IllegalAccessException paramIOException1) {}
  }
  
  public IOException a()
  {
    return this.b;
  }
  
  public void a(IOException paramIOException)
  {
    a(paramIOException, this.b);
    this.b = paramIOException;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */