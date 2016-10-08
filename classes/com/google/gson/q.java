package com.google.gson;

import com.google.gson.c.a;
import com.google.gson.c.d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongArray;

final class q
  extends af<AtomicLongArray>
{
  q(af paramaf) {}
  
  public AtomicLongArray a(a parama)
  {
    ArrayList localArrayList = new ArrayList();
    parama.a();
    while (parama.e()) {
      localArrayList.add(Long.valueOf(((Number)this.a.b(parama)).longValue()));
    }
    parama.b();
    int j = localArrayList.size();
    parama = new AtomicLongArray(j);
    int i = 0;
    while (i < j)
    {
      parama.set(i, ((Long)localArrayList.get(i)).longValue());
      i += 1;
    }
    return parama;
  }
  
  public void a(d paramd, AtomicLongArray paramAtomicLongArray)
  {
    paramd.b();
    int i = 0;
    int j = paramAtomicLongArray.length();
    while (i < j)
    {
      this.a.a(paramd, Long.valueOf(paramAtomicLongArray.get(i)));
      i += 1;
    }
    paramd.c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */