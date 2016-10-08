package com.adhoc;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class bp
  implements Closeable
{
  private Charset f()
  {
    bf localbf = a();
    if (localbf != null) {
      return localbf.a(cb.c);
    }
    return cb.c;
  }
  
  public abstract bf a();
  
  public abstract long b();
  
  public abstract eq c();
  
  public void close()
  {
    c().close();
  }
  
  public final byte[] d()
  {
    long l = b();
    if (l > 2147483647L) {
      throw new IOException("Cannot buffer entire body for content length: " + l);
    }
    eq localeq = c();
    try
    {
      byte[] arrayOfByte1 = localeq.q();
      cb.a(localeq);
      if ((l != -1L) && (l != arrayOfByte1.length)) {
        throw new IOException("Content-Length and stream length disagree");
      }
    }
    finally
    {
      cb.a(localeq);
    }
    return arrayOfByte2;
  }
  
  public final String e()
  {
    return new String(d(), f().name());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */