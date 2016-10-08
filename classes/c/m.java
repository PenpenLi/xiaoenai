package c;

import java.util.concurrent.TimeUnit;

public class m
  extends aa
{
  private aa a;
  
  public m(aa paramaa)
  {
    if (paramaa == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramaa;
  }
  
  public final aa a()
  {
    return this.a;
  }
  
  public aa a(long paramLong)
  {
    return this.a.a(paramLong);
  }
  
  public aa a(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.a(paramLong, paramTimeUnit);
  }
  
  public final m a(aa paramaa)
  {
    if (paramaa == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramaa;
    return this;
  }
  
  public long d()
  {
    return this.a.d();
  }
  
  public aa f()
  {
    return this.a.f();
  }
  
  public void g()
  {
    this.a.g();
  }
  
  public long o_()
  {
    return this.a.o_();
  }
  
  public boolean p_()
  {
    return this.a.p_();
  }
  
  public aa q_()
  {
    return this.a.q_();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */