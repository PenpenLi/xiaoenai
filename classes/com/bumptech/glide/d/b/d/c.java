package com.bumptech.glide.d.b.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class c
{
  private final Map<d, Integer> a;
  private final List<d> b;
  private int c;
  private int d;
  
  public c(Map<d, Integer> paramMap)
  {
    this.a = paramMap;
    this.b = new ArrayList(paramMap.keySet());
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Integer localInteger = (Integer)paramMap.next();
      int i = this.c;
      this.c = (localInteger.intValue() + i);
    }
  }
  
  public d a()
  {
    d locald = (d)this.b.get(this.d);
    Integer localInteger = (Integer)this.a.get(locald);
    if (localInteger.intValue() == 1)
    {
      this.a.remove(locald);
      this.b.remove(this.d);
      this.c -= 1;
      if (!this.b.isEmpty()) {
        break label118;
      }
    }
    label118:
    for (int i = 0;; i = (this.d + 1) % this.b.size())
    {
      this.d = i;
      return locald;
      this.a.put(locald, Integer.valueOf(localInteger.intValue() - 1));
      break;
    }
  }
  
  public boolean b()
  {
    return this.c == 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */