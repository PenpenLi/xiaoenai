package b.a.b;

import b.a.j;
import c.aa;
import c.e;
import c.y;
import java.net.ProtocolException;

public final class s
  implements y
{
  private boolean a;
  private final int b;
  private final e c = new e();
  
  public s()
  {
    this(-1);
  }
  
  public s(int paramInt)
  {
    this.b = paramInt;
  }
  
  public aa a()
  {
    return aa.b;
  }
  
  public void a(y paramy)
  {
    e locale = new e();
    this.c.a(locale, 0L, this.c.b());
    paramy.a_(locale, locale.b());
  }
  
  public void a_(e parame, long paramLong)
  {
    if (this.a) {
      throw new IllegalStateException("closed");
    }
    j.a(parame.b(), 0L, paramLong);
    if ((this.b != -1) && (this.c.b() > this.b - paramLong)) {
      throw new ProtocolException("exceeded content-length limit of " + this.b + " bytes");
    }
    this.c.a_(parame, paramLong);
  }
  
  public long b()
  {
    return this.c.b();
  }
  
  public void close()
  {
    if (this.a) {}
    do
    {
      return;
      this.a = true;
    } while (this.c.b() >= this.b);
    throw new ProtocolException("content-length promised " + this.b + " bytes, but received " + this.c.b());
  }
  
  public void flush() {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\b\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */