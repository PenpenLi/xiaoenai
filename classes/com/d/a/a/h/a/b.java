package com.d.a.a.h.a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class b
{
  private final StringBuilder a = new StringBuilder();
  private final Map<String, String> b = new HashMap();
  
  private String b(boolean paramBoolean, Collection<String> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.size() == 0))
    {
      if (paramBoolean) {
        return "w_n";
      }
      return "wo_n";
    }
    this.a.setLength(0);
    StringBuilder localStringBuilder = this.a;
    if (paramBoolean) {}
    for (String str = "X";; str = "Y")
    {
      localStringBuilder.append(str);
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        str = (String)paramCollection.next();
        this.a.append("-").append(str);
      }
    }
    return this.a.toString();
  }
  
  public String a(boolean paramBoolean, Collection<String> paramCollection)
  {
    try
    {
      paramCollection = b(paramBoolean, paramCollection);
      paramCollection = (String)this.b.get(paramCollection);
      return paramCollection;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, Collection<String> paramCollection)
  {
    try
    {
      paramCollection = b(paramBoolean, paramCollection);
      this.b.put(paramCollection, paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\h\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */