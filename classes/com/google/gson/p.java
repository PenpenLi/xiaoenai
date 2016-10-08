package com.google.gson;

import com.google.gson.c.a;
import com.google.gson.c.d;
import java.util.concurrent.atomic.AtomicLong;

final class p
  extends af<AtomicLong>
{
  p(af paramaf) {}
  
  public AtomicLong a(a parama)
  {
    return new AtomicLong(((Number)this.a.b(parama)).longValue());
  }
  
  public void a(d paramd, AtomicLong paramAtomicLong)
  {
    this.a.a(paramd, Long.valueOf(paramAtomicLong.get()));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */