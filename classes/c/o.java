package c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class o
  implements z
{
  private final h a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  o(h paramh, Inflater paramInflater)
  {
    if (paramh == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramInflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.a = paramh;
    this.b = paramInflater;
  }
  
  public o(z paramz, Inflater paramInflater)
  {
    this(p.a(paramz), paramInflater);
  }
  
  private void c()
  {
    if (this.c == 0) {
      return;
    }
    int i = this.c - this.b.getRemaining();
    this.c -= i;
    this.a.g(i);
  }
  
  public long a(e parame, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.d) {
      throw new IllegalStateException("closed");
    }
    if (paramLong == 0L) {
      return 0L;
    }
    for (;;)
    {
      boolean bool = b();
      try
      {
        w localw = parame.e(1);
        int i = this.b.inflate(localw.a, localw.c, 2048 - localw.c);
        if (i > 0)
        {
          localw.c += i;
          parame.b += i;
          return i;
        }
        if ((this.b.finished()) || (this.b.needsDictionary()))
        {
          c();
          if (localw.b == localw.c)
          {
            parame.a = localw.a();
            x.a(localw);
          }
        }
        else
        {
          if (!bool) {
            continue;
          }
          throw new EOFException("source exhausted prematurely");
        }
      }
      catch (DataFormatException parame)
      {
        throw new IOException(parame);
      }
    }
    return -1L;
  }
  
  public aa a()
  {
    return this.a.a();
  }
  
  public boolean b()
  {
    if (!this.b.needsInput()) {
      return false;
    }
    c();
    if (this.b.getRemaining() != 0) {
      throw new IllegalStateException("?");
    }
    if (this.a.f()) {
      return true;
    }
    w localw = this.a.c().a;
    this.c = (localw.c - localw.b);
    this.b.setInput(localw.a, localw.b, this.c);
    return false;
  }
  
  public void close()
  {
    if (this.d) {
      return;
    }
    this.b.end();
    this.d = true;
    this.a.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */