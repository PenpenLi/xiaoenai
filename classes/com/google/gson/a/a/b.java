package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.j;
import java.lang.reflect.GenericArrayType;

final class b
  implements ah
{
  public <T> af<T> a(j paramj, com.google.gson.b.a<T> parama)
  {
    parama = parama.getType();
    if ((!(parama instanceof GenericArrayType)) && ((!(parama instanceof Class)) || (!((Class)parama).isArray()))) {
      return null;
    }
    parama = com.google.gson.a.b.g(parama);
    return new a(paramj, paramj.a(com.google.gson.b.a.get(parama)), com.google.gson.a.b.e(parama));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */