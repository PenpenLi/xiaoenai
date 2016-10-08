package c;

import java.io.IOException;

class c
  implements z
{
  c(a parama, z paramz) {}
  
  public long a(e parame, long paramLong)
  {
    this.b.c();
    try
    {
      paramLong = this.a.a(parame, paramLong);
      this.b.a(true);
      return paramLong;
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
  
  public aa a()
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
    return "AsyncTimeout.source(" + this.a + ")";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */