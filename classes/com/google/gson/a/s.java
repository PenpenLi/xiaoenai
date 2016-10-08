package com.google.gson.a;

import com.google.gson.af;
import com.google.gson.c.d;
import com.google.gson.j;

class s
  extends af<T>
{
  private af<T> f;
  
  s(r paramr, boolean paramBoolean1, boolean paramBoolean2, j paramj, com.google.gson.b.a parama) {}
  
  private af<T> b()
  {
    af localaf = this.f;
    if (localaf != null) {
      return localaf;
    }
    localaf = this.c.a(this.e, this.d);
    this.f = localaf;
    return localaf;
  }
  
  public void a(d paramd, T paramT)
  {
    if (this.b)
    {
      paramd.f();
      return;
    }
    b().a(paramd, paramT);
  }
  
  public T b(com.google.gson.c.a parama)
  {
    if (this.a)
    {
      parama.n();
      return null;
    }
    return (T)b().b(parama);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */