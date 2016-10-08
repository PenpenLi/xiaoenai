package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.c.d;
import com.google.gson.j;
import java.lang.reflect.Field;

class p
  extends o.b
{
  final af<?> a = o.a(this.f, this.b, this.c, this.d);
  
  p(o paramo, String paramString, boolean paramBoolean1, boolean paramBoolean2, j paramj, Field paramField, com.google.gson.b.a parama, boolean paramBoolean3)
  {
    super(paramString, paramBoolean1, paramBoolean2);
  }
  
  void a(com.google.gson.c.a parama, Object paramObject)
  {
    parama = this.a.b(parama);
    if ((parama != null) || (!this.e)) {
      this.c.set(paramObject, parama);
    }
  }
  
  void a(d paramd, Object paramObject)
  {
    paramObject = this.c.get(paramObject);
    new u(this.b, this.a, this.d.getType()).a(paramd, paramObject);
  }
  
  public boolean a(Object paramObject)
  {
    if (!this.h) {}
    while (this.c.get(paramObject) == paramObject) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */