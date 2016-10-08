package com.google.gson.a.a;

import com.google.gson.a.u;
import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;

final class ab
  extends af<Number>
{
  public Number a(a parama)
  {
    c localc = parama.f();
    switch (ba.a[localc.ordinal()])
    {
    case 2: 
    case 3: 
    default: 
      throw new com.google.gson.ab("Expecting number, got: " + localc);
    case 4: 
      parama.j();
      return null;
    }
    return new u(parama.h());
  }
  
  public void a(d paramd, Number paramNumber)
  {
    paramd.a(paramNumber);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */