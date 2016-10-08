package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class s
  extends u
  implements Iterable<u>
{
  private final List<u> a = new ArrayList();
  
  public Number a()
  {
    if (this.a.size() == 1) {
      return ((u)this.a.get(0)).a();
    }
    throw new IllegalStateException();
  }
  
  public void a(u paramu)
  {
    Object localObject = paramu;
    if (paramu == null) {
      localObject = w.a;
    }
    this.a.add(localObject);
  }
  
  public String b()
  {
    if (this.a.size() == 1) {
      return ((u)this.a.get(0)).b();
    }
    throw new IllegalStateException();
  }
  
  public double c()
  {
    if (this.a.size() == 1) {
      return ((u)this.a.get(0)).c();
    }
    throw new IllegalStateException();
  }
  
  public long d()
  {
    if (this.a.size() == 1) {
      return ((u)this.a.get(0)).d();
    }
    throw new IllegalStateException();
  }
  
  public int e()
  {
    if (this.a.size() == 1) {
      return ((u)this.a.get(0)).e();
    }
    throw new IllegalStateException();
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof s)) && (((s)paramObject).a.equals(this.a)));
  }
  
  public boolean f()
  {
    if (this.a.size() == 1) {
      return ((u)this.a.get(0)).f();
    }
    throw new IllegalStateException();
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public Iterator<u> iterator()
  {
    return this.a.iterator();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */