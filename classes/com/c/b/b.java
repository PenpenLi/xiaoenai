package com.c.b;

public abstract class b<T>
  extends c<T, Integer>
{
  public b(String paramString)
  {
    super(Integer.class, paramString);
  }
  
  public abstract void a(T paramT, int paramInt);
  
  public final void a(T paramT, Integer paramInteger)
  {
    a(paramT, Integer.valueOf(paramInteger.intValue()));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\c\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */