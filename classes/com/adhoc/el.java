package com.adhoc;

class el
  implements ff
{
  el(ek paramek, ff paramff) {}
  
  public fh a()
  {
    return this.b;
  }
  
  public void a_(eo parameo, long paramLong)
  {
    this.b.c();
    try
    {
      this.a.a_(parameo, paramLong);
      this.b.a(true);
      return;
    }
    catch (Throwable parameo)
    {
      fl.a(parameo);
      return;
    }
    finally
    {
      this.b.a(false);
    }
  }
  
  public void close()
  {
    this.b.c();
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
  
  public void flush()
  {
    this.b.c();
    try
    {
      this.a.flush();
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
    return "AsyncTimeout.sink(" + this.a + ")";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\el.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */