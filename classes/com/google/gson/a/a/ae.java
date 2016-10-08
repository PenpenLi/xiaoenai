package com.google.gson.a.a;

import com.google.gson.ab;
import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;
import java.math.BigDecimal;

final class ae
  extends af<BigDecimal>
{
  public BigDecimal a(a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    try
    {
      parama = new BigDecimal(parama.h());
      return parama;
    }
    catch (NumberFormatException parama)
    {
      throw new ab(parama);
    }
  }
  
  public void a(d paramd, BigDecimal paramBigDecimal)
  {
    paramd.a(paramBigDecimal);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */