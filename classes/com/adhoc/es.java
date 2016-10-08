package com.adhoc;

import java.util.zip.Deflater;

public final class es
  implements ff
{
  private final ep a;
  private final Deflater b;
  private boolean c;
  
  es(ep paramep, Deflater paramDeflater)
  {
    if (paramep == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramDeflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.a = paramep;
    this.b = paramDeflater;
  }
  
  public es(ff paramff, Deflater paramDeflater)
  {
    this(ex.a(paramff), paramDeflater);
  }
  
  private void a(boolean paramBoolean)
  {
    eo localeo = this.a.c();
    fd localfd;
    label115:
    do
    {
      localfd = localeo.e(1);
      if (paramBoolean) {}
      for (int i = this.b.deflate(localfd.a, localfd.c, 2048 - localfd.c, 2);; i = this.b.deflate(localfd.a, localfd.c, 2048 - localfd.c))
      {
        if (i <= 0) {
          break label115;
        }
        localfd.c += i;
        localeo.b += i;
        this.a.t();
        break;
      }
    } while (!this.b.needsInput());
    if (localfd.b == localfd.c)
    {
      localeo.a = localfd.a();
      fe.a(localfd);
    }
  }
  
  public fh a()
  {
    return this.a.a();
  }
  
  public void a_(eo parameo, long paramLong)
  {
    fj.a(parameo.b, 0L, paramLong);
    while (paramLong > 0L)
    {
      fd localfd = parameo.a;
      int i = (int)Math.min(paramLong, localfd.c - localfd.b);
      this.b.setInput(localfd.a, localfd.b, i);
      a(false);
      parameo.b -= i;
      localfd.b += i;
      if (localfd.b == localfd.c)
      {
        parameo.a = localfd.a();
        fe.a(localfd);
      }
      paramLong -= i;
    }
  }
  
  void b()
  {
    this.b.finish();
    a(false);
  }
  
  public void close()
  {
    if (this.c) {}
    for (;;)
    {
      return;
      Object localObject3 = null;
      try
      {
        b();
        try
        {
          this.b.end();
          localObject1 = localObject3;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            Object localObject1;
            label34:
            if (localObject3 != null) {
              localObject2 = localObject3;
            }
          }
        }
        try
        {
          this.a.close();
          localObject3 = localObject1;
        }
        catch (Throwable localThrowable3)
        {
          localObject3 = localObject2;
          if (localObject2 != null) {
            break label34;
          }
          localObject3 = localThrowable3;
          break label34;
        }
        this.c = true;
        if (localObject3 == null) {
          continue;
        }
        fj.a((Throwable)localObject3);
        return;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        for (;;) {}
      }
    }
  }
  
  public void flush()
  {
    a(true);
    this.a.flush();
  }
  
  public String toString()
  {
    return "DeflaterSink(" + this.a + ")";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */