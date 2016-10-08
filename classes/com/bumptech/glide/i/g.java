package com.bumptech.glide.i;

public class g
{
  private Class<?> a;
  private Class<?> b;
  
  public g() {}
  
  public g(Class<?> paramClass1, Class<?> paramClass2)
  {
    a(paramClass1, paramClass2);
  }
  
  public void a(Class<?> paramClass1, Class<?> paramClass2)
  {
    this.a = paramClass1;
    this.b = paramClass2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (g)paramObject;
      if (!this.a.equals(((g)paramObject).a)) {
        return false;
      }
    } while (this.b.equals(((g)paramObject).b));
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() * 31 + this.b.hashCode();
  }
  
  public String toString()
  {
    return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\i\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */