package com.google.gson.a.a;

import com.google.gson.ab;
import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;

final class x
  extends af<AtomicIntegerArray>
{
  public AtomicIntegerArray a(a parama)
  {
    ArrayList localArrayList = new ArrayList();
    parama.a();
    while (parama.e()) {
      try
      {
        localArrayList.add(Integer.valueOf(parama.m()));
      }
      catch (NumberFormatException parama)
      {
        throw new ab(parama);
      }
    }
    parama.b();
    int j = localArrayList.size();
    parama = new AtomicIntegerArray(j);
    int i = 0;
    while (i < j)
    {
      parama.set(i, ((Integer)localArrayList.get(i)).intValue());
      i += 1;
    }
    return parama;
  }
  
  public void a(d paramd, AtomicIntegerArray paramAtomicIntegerArray)
  {
    paramd.b();
    int i = 0;
    int j = paramAtomicIntegerArray.length();
    while (i < j)
    {
      paramd.a(paramAtomicIntegerArray.get(i));
      i += 1;
    }
    paramd.c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */