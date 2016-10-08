package com.adhoc;

import android.os.Build.VERSION;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class ew
  implements fg
{
  private final eq a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  ew(eq parameq, Inflater paramInflater)
  {
    if (parameq == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramInflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.a = parameq;
    this.b = paramInflater;
  }
  
  public ew(fg paramfg, Inflater paramInflater)
  {
    this(ex.a(paramfg), paramInflater);
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
  
  public long a(eo parameo, long paramLong)
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
    do
    {
      for (;;)
      {
        boolean bool = b();
        try
        {
          fd localfd = parameo.e(1);
          int i = this.b.inflate(localfd.a, localfd.c, 2048 - localfd.c);
          if (i > 0)
          {
            localfd.c += i;
            parameo.b += i;
            return i;
          }
          if ((this.b.finished()) || (this.b.needsDictionary()))
          {
            c();
            if (localfd.b != localfd.c) {
              break label222;
            }
            parameo.a = localfd.a();
            fe.a(localfd);
            break label222;
          }
          if (bool) {
            throw new EOFException("source exhausted prematurely");
          }
        }
        catch (DataFormatException localDataFormatException) {}
      }
    } while (Build.VERSION.SDK_INT <= 8);
    throw new IOException(localDataFormatException);
    label222:
    return -1L;
  }
  
  public fh a()
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
    fd localfd = this.a.c().a;
    this.c = (localfd.c - localfd.b);
    this.b.setInput(localfd.a, localfd.b, this.c);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */