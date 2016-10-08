package com.adhoc;

import java.io.IOException;

public enum bi
{
  private final String e;
  
  private bi(String paramString)
  {
    this.e = paramString;
  }
  
  public static bi a(String paramString)
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */