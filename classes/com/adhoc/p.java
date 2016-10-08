package com.adhoc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class p
{
  private String a;
  private String b;
  private HashMap<String, Boolean> c = new HashMap();
  private boolean d;
  private boolean e;
  
  public String a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.c.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public HashMap<String, Boolean> b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    this.c.put(paramString, Boolean.valueOf(true));
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public void c(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean d()
  {
    Iterator localIterator = this.c.entrySet().iterator();
    boolean bool = true;
    if (localIterator.hasNext())
    {
      if (((Boolean)((Map.Entry)localIterator.next()).getValue()).booleanValue()) {
        break label54;
      }
      bool = false;
    }
    label54:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public boolean d(String paramString)
  {
    return ((Boolean)this.c.get(paramString)).booleanValue();
  }
  
  public boolean e()
  {
    return this.d;
  }
  
  public boolean f()
  {
    return this.e;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */