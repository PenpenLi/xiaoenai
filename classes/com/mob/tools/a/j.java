package com.mob.tools.a;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class j
  extends c
{
  private ArrayList<c> a = new ArrayList();
  
  public j a(c paramc)
  {
    this.a.add(paramc);
    return this;
  }
  
  protected InputStream a()
  {
    k localk = new k();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      localk.a(((c)localIterator.next()).a());
    }
    return localk;
  }
  
  protected long b()
  {
    Iterator localIterator = this.a.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((c)localIterator.next()).b() + l) {}
    return l;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((c)localIterator.next()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */