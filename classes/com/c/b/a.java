package com.c.b;

public abstract class a<T>
  extends c<T, Float>
{
  public a(String paramString)
  {
    super(Float.class, paramString);
  }
  
  public abstract void a(T paramT, float paramFloat);
  
  public final void a(T paramT, Float paramFloat)
  {
    a(paramT, paramFloat.floatValue());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */