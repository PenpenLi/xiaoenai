package com.adhoc;

import java.io.IOException;

class em
  implements fg
{
  em(ek paramek, fg paramfg) {}
  
  public long a(eo parameo, long paramLong)
  {
    this.b.c();
    try
    {
      paramLong = this.a.a(parameo, paramLong);
      this.b.a(true);
      return paramLong;
    }
    catch (IOException parameo)
    {
      throw this.b.b(parameo);
    }
    finally
    {
      this.b.a(false);
    }
  }
  
  public fh a()
  {
    return this.b;
  }
  
  public void close()
  {
    try
    {
      this.a.close();
      this.b.a(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
      return;
    }
    finally
    {
      this.b.a(false);
    }
  }
  
  public String toString()
  {
    return "AsyncTimeout.source(" + this.a + ")";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */