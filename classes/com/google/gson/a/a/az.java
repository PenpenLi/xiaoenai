package com.google.gson.a.a;

import com.google.gson.ab;
import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.d;

class az
  extends af<T1>
{
  az(ay paramay, Class paramClass) {}
  
  public void a(d paramd, T1 paramT1)
  {
    this.b.b.a(paramd, paramT1);
  }
  
  public T1 b(a parama)
  {
    parama = this.b.b.b(parama);
    if ((parama != null) && (!this.a.isInstance(parama))) {
      throw new ab("Expected a " + this.a.getName() + " but was " + parama.getClass().getName());
    }
    return parama;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */