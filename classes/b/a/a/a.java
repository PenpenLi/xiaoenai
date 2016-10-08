package b.a.a;

public enum a
{
  public final int s;
  public final int t;
  public final int u;
  
  private a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.s = paramInt1;
    this.t = paramInt2;
    this.u = paramInt3;
  }
  
  public static a a(int paramInt)
  {
    a[] arrayOfa = values();
    int i2 = arrayOfa.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a locala = arrayOfa[i1];
      if (locala.t == paramInt) {
        return locala;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static a b(int paramInt)
  {
    a[] arrayOfa = values();
    int i2 = arrayOfa.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a locala = arrayOfa[i1];
      if (locala.s == paramInt) {
        return locala;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static a c(int paramInt)
  {
    a[] arrayOfa = values();
    int i2 = arrayOfa.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a locala = arrayOfa[i1];
      if (locala.u == paramInt) {
        return locala;
      }
      i1 += 1;
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */