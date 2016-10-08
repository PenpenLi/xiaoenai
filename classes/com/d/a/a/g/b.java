package com.d.a.a.g;

import java.util.Iterator;
import java.util.Set;

public class b
{
  private int a;
  private Set<String> b;
  
  public b(int paramInt, Set<String> paramSet)
  {
    this.a = paramInt;
    this.b = paramSet;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public b a(b paramb)
  {
    if ((this.b == null) || (paramb.b == null))
    {
      this.a += paramb.a;
      if (this.b == null) {
        this.b = paramb.b;
      }
      return this;
    }
    Iterator localIterator = paramb.b.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.b.add(str)) {
        break label116;
      }
      i += 1;
    }
    label116:
    for (;;)
    {
      break;
      this.a = (this.a + paramb.a - i);
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */