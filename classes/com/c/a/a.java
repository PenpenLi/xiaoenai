package com.c.a;

import java.util.ArrayList;

public abstract class a
  implements Cloneable
{
  ArrayList<a> a = null;
  
  public abstract a a(long paramLong);
  
  public void a() {}
  
  public void a(a parama)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(parama);
  }
  
  public void b() {}
  
  public void b(a parama)
  {
    if (this.a == null) {}
    do
    {
      return;
      this.a.remove(parama);
    } while (this.a.size() != 0);
    this.a = null;
  }
  
  public void c() {}
  
  public abstract boolean d();
  
  public boolean e()
  {
    return d();
  }
  
  public ArrayList<a> f()
  {
    return this.a;
  }
  
  public a g()
  {
    try
    {
      a locala = (a)super.clone();
      if (this.a != null)
      {
        ArrayList localArrayList = this.a;
        locala.a = new ArrayList();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          locala.a.add(localArrayList.get(i));
          i += 1;
        }
      }
      return localCloneNotSupportedException;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void b(a parama);
    
    public abstract void c(a parama);
    
    public abstract void d(a parama);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */