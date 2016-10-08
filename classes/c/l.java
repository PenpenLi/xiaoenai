package c;

public abstract class l
  implements z
{
  private final z a;
  
  public l(z paramz)
  {
    if (paramz == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramz;
  }
  
  public long a(e parame, long paramLong)
  {
    return this.a.a(parame, paramLong);
  }
  
  public aa a()
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */