package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.b.a;
import com.google.gson.j;

final class au
  implements ah
{
  public <T> af<T> a(j paramj, a<T> parama)
  {
    parama = parama.getRawType();
    if ((!Enum.class.isAssignableFrom(parama)) || (parama == Enum.class)) {
      return null;
    }
    paramj = parama;
    if (!parama.isEnum()) {
      paramj = parama.getSuperclass();
    }
    return new v.a(paramj);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */