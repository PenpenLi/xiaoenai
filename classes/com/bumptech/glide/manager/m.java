package com.bumptech.glide.manager;

import com.bumptech.glide.g.c;
import com.bumptech.glide.i.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class m
{
  private final Set<c> a = Collections.newSetFromMap(new WeakHashMap());
  private final List<c> b = new ArrayList();
  private boolean c;
  
  public void a()
  {
    this.c = true;
    Iterator localIterator = h.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.f())
      {
        localc.e();
        this.b.add(localc);
      }
    }
  }
  
  public void a(c paramc)
  {
    this.a.add(paramc);
    if (!this.c)
    {
      paramc.b();
      return;
    }
    this.b.add(paramc);
  }
  
  public void b()
  {
    this.c = false;
    Iterator localIterator = h.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((!localc.g()) && (!localc.i()) && (!localc.f())) {
        localc.b();
      }
    }
    this.b.clear();
  }
  
  public void b(c paramc)
  {
    this.a.remove(paramc);
    this.b.remove(paramc);
  }
  
  public void c()
  {
    Iterator localIterator = h.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).d();
    }
    this.b.clear();
  }
  
  public void d()
  {
    Iterator localIterator = h.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((!localc.g()) && (!localc.i()))
      {
        localc.e();
        if (!this.c) {
          localc.b();
        } else {
          this.b.add(localc);
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\manager\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */