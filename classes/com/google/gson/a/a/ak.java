package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;
import com.google.gson.v;
import java.net.URI;
import java.net.URISyntaxException;

final class ak
  extends af<URI>
{
  public URI a(a parama)
  {
    if (parama.f() == c.i) {
      parama.j();
    }
    for (;;)
    {
      return null;
      try
      {
        parama = parama.h();
        if ("null".equals(parama)) {
          continue;
        }
        parama = new URI(parama);
        return parama;
      }
      catch (URISyntaxException parama)
      {
        throw new v(parama);
      }
    }
  }
  
  public void a(d paramd, URI paramURI)
  {
    if (paramURI == null) {}
    for (paramURI = null;; paramURI = paramURI.toASCIIString())
    {
      paramd.b(paramURI);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */