package com.adhoc;

public abstract class et
  implements fg
{
  private final fg a;
  
  public et(fg paramfg)
  {
    if (paramfg == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramfg;
  }
  
  public long a(eo parameo, long paramLong)
  {
    return this.a.a(parameo, paramLong);
  }
  
  public fh a()
  {
    return this.a.a();
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.a.toString() + ")";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */