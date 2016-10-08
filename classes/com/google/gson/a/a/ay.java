package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.b.a;
import com.google.gson.j;

final class ay
  implements ah
{
  ay(Class paramClass, af paramaf) {}
  
  public <T2> af<T2> a(j paramj, a<T2> parama)
  {
    paramj = parama.getRawType();
    if (!this.a.isAssignableFrom(paramj)) {
      return null;
    }
    return new az(this, paramj);
  }
  
  public String toString()
  {
    return "Factory[typeHierarchy=" + this.a.getName() + ",adapter=" + this.b + "]";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */