package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;

final class at
  extends af<Boolean>
{
  public Boolean a(a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    if (parama.f() == c.f) {
      return Boolean.valueOf(Boolean.parseBoolean(parama.h()));
    }
    return Boolean.valueOf(parama.i());
  }
  
  public void a(d paramd, Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      paramd.f();
      return;
    }
    paramd.a(paramBoolean.booleanValue());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */