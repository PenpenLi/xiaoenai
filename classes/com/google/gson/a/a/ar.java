package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;
import java.util.Locale;
import java.util.StringTokenizer;

final class ar
  extends af<Locale>
{
  public Locale a(a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    Object localObject = new StringTokenizer(parama.h(), "_");
    if (((StringTokenizer)localObject).hasMoreElements()) {}
    for (parama = ((StringTokenizer)localObject).nextToken();; parama = null)
    {
      if (((StringTokenizer)localObject).hasMoreElements()) {}
      for (String str = ((StringTokenizer)localObject).nextToken();; str = null)
      {
        if (((StringTokenizer)localObject).hasMoreElements()) {}
        for (localObject = ((StringTokenizer)localObject).nextToken();; localObject = null)
        {
          if ((str == null) && (localObject == null)) {
            return new Locale(parama);
          }
          if (localObject == null) {
            return new Locale(parama, str);
          }
          return new Locale(parama, str, (String)localObject);
        }
      }
    }
  }
  
  public void a(d paramd, Locale paramLocale)
  {
    if (paramLocale == null) {}
    for (paramLocale = null;; paramLocale = paramLocale.toString())
    {
      paramd.b(paramLocale);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */