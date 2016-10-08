package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.d;
import java.util.Currency;

final class an
  extends af<Currency>
{
  public Currency a(a parama)
  {
    return Currency.getInstance(parama.h());
  }
  
  public void a(d paramd, Currency paramCurrency)
  {
    paramd.b(paramCurrency.getCurrencyCode());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */