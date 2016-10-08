package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

class a
  implements h
{
  private final Set<i> a = Collections.newSetFromMap(new WeakHashMap());
  private boolean b;
  private boolean c;
  
  void a()
  {
    this.b = true;
    Iterator localIterator = com.bumptech.glide.i.h.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).d();
    }
  }
  
  public void a(i parami)
  {
    this.a.add(parami);
    if (this.c)
    {
      parami.f();
      return;
    }
    if (this.b)
    {
      parami.d();
      return;
    }
    parami.e();
  }
  
  void b()
  {
    this.b = false;
    Iterator localIterator = com.bumptech.glide.i.h.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).e();
    }
  }
  
  void c()
  {
    this.c = true;
    Iterator localIterator = com.bumptech.glide.i.h.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).f();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\manager\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */