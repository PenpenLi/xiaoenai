package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;
import java.net.URL;

final class aj
  extends af<URL>
{
  public URL a(a parama)
  {
    if (parama.f() == c.i) {
      parama.j();
    }
    do
    {
      return null;
      parama = parama.h();
    } while ("null".equals(parama));
    return new URL(parama);
  }
  
  public void a(d paramd, URL paramURL)
  {
    if (paramURL == null) {}
    for (paramURL = null;; paramURL = paramURL.toExternalForm())
    {
      paramd.b(paramURL);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */