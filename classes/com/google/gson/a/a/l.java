package com.google.gson.a.a;

import com.google.gson.a.v;
import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.c.a;
import com.google.gson.c.d;
import com.google.gson.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class l
  extends af<Object>
{
  public static final ah a = new m();
  private final j b;
  
  private l(j paramj)
  {
    this.b = paramj;
  }
  
  public void a(d paramd, Object paramObject)
  {
    if (paramObject == null)
    {
      paramd.f();
      return;
    }
    af localaf = this.b.a(paramObject.getClass());
    if ((localaf instanceof l))
    {
      paramd.d();
      paramd.e();
      return;
    }
    localaf.a(paramd, paramObject);
  }
  
  public Object b(a parama)
  {
    Object localObject = parama.f();
    switch (n.a[localObject.ordinal()])
    {
    default: 
      throw new IllegalStateException();
    case 1: 
      localObject = new ArrayList();
      parama.a();
      while (parama.e()) {
        ((List)localObject).add(b(parama));
      }
      parama.b();
      return localObject;
    case 2: 
      localObject = new v();
      parama.c();
      while (parama.e()) {
        ((Map)localObject).put(parama.g(), b(parama));
      }
      parama.d();
      return localObject;
    case 3: 
      return parama.h();
    case 4: 
      return Double.valueOf(parama.k());
    case 5: 
      return Boolean.valueOf(parama.i());
    }
    parama.j();
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */