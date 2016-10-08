package com.bumptech.glide.d.b.b;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c
{
  private final Map<com.bumptech.glide.d.c, a> a = new HashMap();
  private final b b = new b(null);
  
  void a(com.bumptech.glide.d.c paramc)
  {
    try
    {
      a locala2 = (a)this.a.get(paramc);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = this.b.a();
        this.a.put(paramc, locala1);
      }
      locala1.b += 1;
      locala1.a.lock();
      return;
    }
    finally {}
  }
  
  void b(com.bumptech.glide.d.c paramc)
  {
    a locala1;
    for (;;)
    {
      try
      {
        locala1 = (a)this.a.get(paramc);
        if ((locala1 != null) && (locala1.b > 0)) {
          break;
        }
        paramc = new StringBuilder().append("Cannot release a lock that is not held, key: ").append(paramc).append(", interestedThreads: ");
        if (locala1 == null)
        {
          i = 0;
          throw new IllegalArgumentException(i);
        }
      }
      finally {}
      i = locala1.b;
    }
    int i = locala1.b - 1;
    locala1.b = i;
    if (i == 0)
    {
      a locala2 = (a)this.a.remove(paramc);
      if (!locala2.equals(locala1)) {
        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + locala1 + ", but actually removed: " + locala2 + ", key: " + paramc);
      }
      this.b.a(locala2);
    }
    locala1.a.unlock();
  }
  
  private static class a
  {
    final Lock a = new ReentrantLock();
    int b;
  }
  
  private static class b
  {
    private final Queue<c.a> a = new ArrayDeque();
    
    c.a a()
    {
      synchronized (this.a)
      {
        c.a locala = (c.a)this.a.poll();
        ??? = locala;
        if (locala == null) {
          ??? = new c.a(null);
        }
        return (c.a)???;
      }
    }
    
    void a(c.a parama)
    {
      synchronized (this.a)
      {
        if (this.a.size() < 10) {
          this.a.offer(parama);
        }
        return;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */