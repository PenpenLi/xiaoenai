package com.google.gson;

import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;

class m
  extends af<Number>
{
  m(j paramj) {}
  
  public Double a(a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    return Double.valueOf(parama.k());
  }
  
  public void a(d paramd, Number paramNumber)
  {
    if (paramNumber == null)
    {
      paramd.f();
      return;
    }
    double d = paramNumber.doubleValue();
    j.a(this.a, d);
    paramd.a(paramNumber);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */