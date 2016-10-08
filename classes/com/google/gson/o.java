package com.google.gson;

import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;

final class o
  extends af<Number>
{
  public Number a(a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    return Long.valueOf(parama.l());
  }
  
  public void a(d paramd, Number paramNumber)
  {
    if (paramNumber == null)
    {
      paramd.f();
      return;
    }
    paramd.b(paramNumber.toString());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */