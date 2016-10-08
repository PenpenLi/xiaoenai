package com.d.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class c
{
  private ArrayList<String> a;
  private final TreeSet<String> b = new TreeSet();
  
  public Collection<String> a()
  {
    try
    {
      if (this.a == null) {
        this.a = new ArrayList(this.b);
      }
      ArrayList localArrayList = this.a;
      return localArrayList;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.b.add(paramString)) {
        this.a = null;
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      if (this.b.remove(paramString)) {
        this.a = null;
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */