package com.xiaoenai.app.utils;

import java.util.Vector;

public class x<T>
  extends Vector
{
  private int a = 0;
  private a b;
  
  public x(a parama)
  {
    this.b = parama;
  }
  
  public void a()
  {
    try
    {
      this.a += 1;
      this.b.a(this.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean add(Object paramObject)
  {
    try
    {
      a();
      boolean bool = super.add(paramObject);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  public void b()
  {
    try
    {
      this.a -= 1;
      this.b.a(this.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean remove(Object paramObject)
  {
    b();
    return super.remove(paramObject);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */