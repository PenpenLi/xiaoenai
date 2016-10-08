package com.google.gson.a.a;

import com.google.gson.ab;
import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;

final class be
  extends af<Number>
{
  public Number a(a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    try
    {
      int i = parama.m();
      return Integer.valueOf(i);
    }
    catch (NumberFormatException parama)
    {
      throw new ab(parama);
    }
  }
  
  public void a(d paramd, Number paramNumber)
  {
    paramd.a(paramNumber);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */