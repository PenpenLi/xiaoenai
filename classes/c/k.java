package c;

public abstract class k
  implements y
{
  private final y a;
  
  public k(y paramy)
  {
    if (paramy == null) {
      throw new IllegalArgumentException("delegate == null");
    }
    this.a = paramy;
  }
  
  public aa a()
  {
    return this.a.a();
  }
  
  public void a_(e parame, long paramLong)
  {
    this.a.a_(parame, paramLong);
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void flush()
  {
    this.a.flush();
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.a.toString() + ")";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */