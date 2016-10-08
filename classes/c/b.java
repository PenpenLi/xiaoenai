package c;

import java.io.IOException;

class b
  implements y
{
  b(a parama, y paramy) {}
  
  public aa a()
  {
    return this.b;
  }
  
  public void a_(e parame, long paramLong)
  {
    this.b.c();
    try
    {
      this.a.a_(parame, paramLong);
      this.b.a(true);
      return;
    }
    catch (IOException parame)
    {
      throw this.b.b(parame);
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
    catch (IOException localIOException)
    {
      throw this.b.b(localIOException);
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
    catch (IOException localIOException)
    {
      throw this.b.b(localIOException);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */