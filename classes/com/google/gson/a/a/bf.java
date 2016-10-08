package com.google.gson.a.a;

import com.google.gson.ab;
import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.d;
import java.util.concurrent.atomic.AtomicInteger;

final class bf
  extends af<AtomicInteger>
{
  public AtomicInteger a(a parama)
  {
    try
    {
      parama = new AtomicInteger(parama.m());
      return parama;
    }
    catch (NumberFormatException parama)
    {
      throw new ab(parama);
    }
  }
  
  public void a(d paramd, AtomicInteger paramAtomicInteger)
  {
    paramd.a(paramAtomicInteger.get());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */