package com.google.gson;

import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;

class n
  extends af<Number>
{
  n(j paramj) {}
  
  public Float a(a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    return Float.valueOf((float)parama.k());
  }
  
  public void a(d paramd, Number paramNumber)
  {
    if (paramNumber == null)
    {
      paramd.f();
      return;
    }
    float f = paramNumber.floatValue();
    j.a(this.a, f);
    paramd.a(paramNumber);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */