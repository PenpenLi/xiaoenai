package b;

import java.io.IOException;

public enum ai
{
  private final String e;
  
  private ai(String paramString)
  {
    this.e = paramString;
  }
  
  public static ai a(String paramString)
  {
    if (paramString.equals(a.e)) {
      return a;
    }
    if (paramString.equals(b.e)) {
      return b;
    }
    if (paramString.equals(d.e)) {
      return d;
    }
    if (paramString.equals(c.e)) {
      return c;
    }
    throw new IOException("Unexpected protocol: " + paramString);
  }
  
  public String toString()
  {
    return this.e;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */