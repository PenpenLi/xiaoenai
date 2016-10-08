package com.google.gson;

import com.google.gson.a.v;
import java.util.Map.Entry;
import java.util.Set;

public final class x
  extends u
{
  private final v<String, u> a = new v();
  
  public void a(String paramString, u paramu)
  {
    Object localObject = paramu;
    if (paramu == null) {
      localObject = w.a;
    }
    this.a.put(paramString, localObject);
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof x)) && (((x)paramObject).a.equals(this.a)));
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public Set<Map.Entry<String, u>> o()
  {
    return this.a.entrySet();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */