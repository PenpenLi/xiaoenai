package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.b.a;
import com.google.gson.j;

final class ax
  implements ah
{
  ax(Class paramClass1, Class paramClass2, af paramaf) {}
  
  public <T> af<T> a(j paramj, a<T> parama)
  {
    paramj = parama.getRawType();
    if ((paramj == this.a) || (paramj == this.b)) {
      return this.c;
    }
    return null;
  }
  
  public String toString()
  {
    return "Factory[type=" + this.a.getName() + "+" + this.b.getName() + ",adapter=" + this.c + "]";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */