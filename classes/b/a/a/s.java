package b.a.a;

public enum s
{
  private s() {}
  
  public boolean a()
  {
    return (this == b) || (this == c);
  }
  
  public boolean b()
  {
    return this == a;
  }
  
  public boolean c()
  {
    return this == c;
  }
  
  public boolean d()
  {
    return this == b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */