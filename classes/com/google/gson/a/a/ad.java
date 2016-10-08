package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;

final class ad
  extends af<String>
{
  public String a(a parama)
  {
    c localc = parama.f();
    if (localc == c.i)
    {
      parama.j();
      return null;
    }
    if (localc == c.h) {
      return Boolean.toString(parama.i());
    }
    return parama.h();
  }
  
  public void a(d paramd, String paramString)
  {
    paramd.b(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */