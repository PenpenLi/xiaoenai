package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.c.c;
import com.google.gson.c.d;
import com.google.gson.j;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class a<E>
  extends af<Object>
{
  public static final ah a = new b();
  private final Class<E> b;
  private final af<E> c;
  
  public a(j paramj, af<E> paramaf, Class<E> paramClass)
  {
    this.c = new u(paramj, paramaf, paramClass);
    this.b = paramClass;
  }
  
  public void a(d paramd, Object paramObject)
  {
    if (paramObject == null)
    {
      paramd.f();
      return;
    }
    paramd.b();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.c.a(paramd, localObject);
      i += 1;
    }
    paramd.c();
  }
  
  public Object b(com.google.gson.c.a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    parama.a();
    while (parama.e()) {
      localArrayList.add(this.c.b(parama));
    }
    parama.b();
    parama = Array.newInstance(this.b, localArrayList.size());
    int i = 0;
    while (i < localArrayList.size())
    {
      Array.set(parama, i, localArrayList.get(i));
      i += 1;
    }
    return parama;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */