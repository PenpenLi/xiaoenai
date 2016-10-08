package com.google.gson.a;

import java.math.BigDecimal;

public final class u
  extends Number
{
  private final String a;
  
  public u(String paramString)
  {
    this.a = paramString;
  }
  
  private Object writeReplace()
  {
    return new BigDecimal(this.a);
  }
  
  public double doubleValue()
  {
    return Double.parseDouble(this.a);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof u));
      paramObject = (u)paramObject;
      if (this.a == ((u)paramObject).a) {
        break;
      }
      bool1 = bool2;
    } while (!this.a.equals(((u)paramObject).a));
    return true;
  }
  
  public float floatValue()
  {
    return Float.parseFloat(this.a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public int intValue()
  {
    try
    {
      int i = Integer.parseInt(this.a);
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        long l = Long.parseLong(this.a);
        return (int)l;
      }
      catch (NumberFormatException localNumberFormatException2) {}
    }
    return new BigDecimal(this.a).intValue();
  }
  
  public long longValue()
  {
    try
    {
      long l = Long.parseLong(this.a);
      return l;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return new BigDecimal(this.a).longValue();
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */