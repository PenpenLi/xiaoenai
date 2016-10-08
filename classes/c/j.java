package c;

import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class j
  implements y
{
  private final g a;
  private final Deflater b;
  private boolean c;
  
  j(g paramg, Deflater paramDeflater)
  {
    if (paramg == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramDeflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.a = paramg;
    this.b = paramDeflater;
  }
  
  public j(y paramy, Deflater paramDeflater)
  {
    this(p.a(paramy), paramDeflater);
  }
  
  @IgnoreJRERequirement
  private void a(boolean paramBoolean)
  {
    e locale = this.a.c();
    w localw;
    label115:
    do
    {
      localw = locale.e(1);
      if (paramBoolean) {}
      for (int i = this.b.deflate(localw.a, localw.c, 2048 - localw.c, 2);; i = this.b.deflate(localw.a, localw.c, 2048 - localw.c))
      {
        if (i <= 0) {
          break label115;
        }
        localw.c += i;
        locale.b += i;
        this.a.u();
        break;
      }
    } while (!this.b.needsInput());
    if (localw.b == localw.c)
    {
      locale.a = localw.a();
      x.a(localw);
    }
  }
  
  public aa a()
  {
    return this.a.a();
  }
  
  public void a_(e parame, long paramLong)
  {
    ac.a(parame.b, 0L, paramLong);
    while (paramLong > 0L)
    {
      w localw = parame.a;
      int i = (int)Math.min(paramLong, localw.c - localw.b);
      this.b.setInput(localw.a, localw.b, i);
      a(false);
      parame.b -= i;
      localw.b += i;
      if (localw.b == localw.c)
      {
        parame.a = localw.a();
        x.a(localw);
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
        ac.a((Throwable)localObject3);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */