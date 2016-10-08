package b;

import b.a.j;
import c.h;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public abstract class as
  implements Closeable
{
  public abstract long a();
  
  public final InputStream b()
  {
    return c().g();
  }
  
  public abstract h c();
  
  public void close()
  {
    j.a(c());
  }
  
  public final byte[] d()
  {
    long l = a();
    if (l > 2147483647L) {
      throw new IOException("Cannot buffer entire body for content length: " + l);
    }
    h localh = c();
    try
    {
      byte[] arrayOfByte1 = localh.r();
      j.a(localh);
      if ((l != -1L) && (l != arrayOfByte1.length)) {
        throw new IOException("Content-Length and stream length disagree");
      }
    }
    finally
    {
      j.a(localh);
    }
    return arrayOfByte2;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */