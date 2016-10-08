package com.d.a.a;

public class e
{
  protected Long a;
  protected int b;
  protected String c;
  protected int d;
  protected long e;
  protected long f;
  protected long g;
  protected boolean h;
  transient b i;
  
  public e(int paramInt, b paramb, long paramLong1, long paramLong2)
  {
    this(null, paramInt, paramb.f(), 0, paramb, System.nanoTime(), paramLong1, paramLong2);
  }
  
  public e(Long paramLong, int paramInt1, String paramString, int paramInt2, b paramb, long paramLong1, long paramLong2, long paramLong3)
  {
    this.a = paramLong;
    this.b = paramInt1;
    this.c = paramString;
    this.d = paramInt2;
    this.f = paramLong1;
    this.e = paramLong2;
    this.i = paramb;
    this.g = paramLong3;
    this.h = paramb.e();
  }
  
  public Long a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void a(Long paramLong)
  {
    this.a = paramLong;
  }
  
  public final boolean a(int paramInt)
  {
    return this.i.a(paramInt);
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public long e()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof e)) {}
    do
    {
      return false;
      paramObject = (e)paramObject;
    } while ((this.a == null) || (((e)paramObject).a == null));
    return this.a.equals(((e)paramObject).a);
  }
  
  public long f()
  {
    return this.g;
  }
  
  public long g()
  {
    return this.e;
  }
  
  public b h()
  {
    return this.i;
  }
  
  public int hashCode()
  {
    if (this.a == null) {
      return super.hashCode();
    }
    return this.a.intValue();
  }
  
  public String i()
  {
    return this.c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */