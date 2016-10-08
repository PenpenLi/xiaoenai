package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.d;
import com.google.gson.s;
import com.google.gson.w;
import com.google.gson.x;
import com.google.gson.z;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class as
  extends af<com.google.gson.u>
{
  public com.google.gson.u a(a parama)
  {
    switch (ba.a[parama.f().ordinal()])
    {
    default: 
      throw new IllegalArgumentException();
    case 3: 
      return new z(parama.h());
    case 1: 
      return new z(new com.google.gson.a.u(parama.h()));
    case 2: 
      return new z(Boolean.valueOf(parama.i()));
    case 4: 
      parama.j();
      return w.a;
    case 5: 
      localObject = new s();
      parama.a();
      while (parama.e()) {
        ((s)localObject).a(a(parama));
      }
      parama.b();
      return (com.google.gson.u)localObject;
    }
    Object localObject = new x();
    parama.c();
    while (parama.e()) {
      ((x)localObject).a(parama.g(), a(parama));
    }
    parama.d();
    return (com.google.gson.u)localObject;
  }
  
  public void a(d paramd, com.google.gson.u paramu)
  {
    if ((paramu == null) || (paramu.j()))
    {
      paramd.f();
      return;
    }
    if (paramu.i())
    {
      paramu = paramu.m();
      if (paramu.p())
      {
        paramd.a(paramu.a());
        return;
      }
      if (paramu.o())
      {
        paramd.a(paramu.f());
        return;
      }
      paramd.b(paramu.b());
      return;
    }
    if (paramu.g())
    {
      paramd.b();
      paramu = paramu.l().iterator();
      while (paramu.hasNext()) {
        a(paramd, (com.google.gson.u)paramu.next());
      }
      paramd.c();
      return;
    }
    if (paramu.h())
    {
      paramd.d();
      paramu = paramu.k().o().iterator();
      while (paramu.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramu.next();
        paramd.a((String)localEntry.getKey());
        a(paramd, (com.google.gson.u)localEntry.getValue());
      }
      paramd.e();
      return;
    }
    throw new IllegalArgumentException("Couldn't write " + paramu.getClass());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */