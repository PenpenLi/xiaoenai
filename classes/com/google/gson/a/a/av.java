package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.b.a;
import com.google.gson.j;

final class av
  implements ah
{
  av(Class paramClass, af paramaf) {}
  
  public <T> af<T> a(j paramj, a<T> parama)
  {
    if (parama.getRawType() == this.a) {
      return this.b;
    }
    return null;
  }
  
  public String toString()
  {
    return "Factory[type=" + this.a.getName() + ",adapter=" + this.b + "]";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */