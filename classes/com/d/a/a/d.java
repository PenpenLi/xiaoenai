package com.d.a.a;

import java.io.Serializable;

public abstract class d
  extends b
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private transient int a;
  private transient long b;
  
  protected d(k paramk)
  {
    super(paramk.c(), paramk.e(), paramk.d());
    this.a = paramk.f();
    this.b = paramk.g();
  }
  
  public final int h()
  {
    return this.a;
  }
  
  public final long i()
  {
    return this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */