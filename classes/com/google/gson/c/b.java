package com.google.gson.c;

import com.google.gson.a.a.g;
import com.google.gson.a.t;

final class b
  extends t
{
  public void a(a parama)
  {
    if ((parama instanceof g))
    {
      ((g)parama).o();
      return;
    }
    int j = a.a(parama);
    int i = j;
    if (j == 0) {
      i = a.b(parama);
    }
    if (i == 13)
    {
      a.a(parama, 9);
      return;
    }
    if (i == 12)
    {
      a.a(parama, 8);
      return;
    }
    if (i == 14)
    {
      a.a(parama, 10);
      return;
    }
    throw new IllegalStateException("Expected a name but was " + parama.f() + " " + " at line " + a.c(parama) + " column " + a.d(parama) + " path " + parama.q());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */