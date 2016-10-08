package com.google.gson.a.a;

import com.google.gson.a.b;
import com.google.gson.a.t;
import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.c.d;
import com.google.gson.j;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class k
  implements ah
{
  private final com.google.gson.a.c a;
  private final boolean b;
  
  public k(com.google.gson.a.c paramc, boolean paramBoolean)
  {
    this.a = paramc;
    this.b = paramBoolean;
  }
  
  private af<?> a(j paramj, Type paramType)
  {
    if ((paramType == Boolean.TYPE) || (paramType == Boolean.class)) {
      return v.f;
    }
    return paramj.a(com.google.gson.b.a.get(paramType));
  }
  
  public <T> af<T> a(j paramj, com.google.gson.b.a<T> parama)
  {
    Object localObject = parama.getType();
    if (!Map.class.isAssignableFrom(parama.getRawType())) {
      return null;
    }
    localObject = b.b((Type)localObject, b.e((Type)localObject));
    af localaf1 = a(paramj, localObject[0]);
    af localaf2 = paramj.a(com.google.gson.b.a.get(localObject[1]));
    parama = this.a.a(parama);
    return new a(paramj, localObject[0], localaf1, localObject[1], localaf2, parama);
  }
  
  private final class a<K, V>
    extends af<Map<K, V>>
  {
    private final af<K> b;
    private final af<V> c;
    private final com.google.gson.a.z<? extends Map<K, V>> d;
    
    public a(Type paramType1, af<K> paramaf, Type paramType2, af<V> paramaf1, com.google.gson.a.z<? extends Map<K, V>> paramz)
    {
      this.b = new u(paramType1, paramType2, paramaf);
      this.c = new u(paramType1, paramz, paramaf1);
      com.google.gson.a.z localz;
      this.d = localz;
    }
    
    private String a(com.google.gson.u paramu)
    {
      if (paramu.i())
      {
        paramu = paramu.m();
        if (paramu.p()) {
          return String.valueOf(paramu.a());
        }
        if (paramu.o()) {
          return Boolean.toString(paramu.f());
        }
        if (paramu.q()) {
          return paramu.b();
        }
        throw new AssertionError();
      }
      if (paramu.j()) {
        return "null";
      }
      throw new AssertionError();
    }
    
    public Map<K, V> a(com.google.gson.c.a parama)
    {
      Object localObject = parama.f();
      if (localObject == com.google.gson.c.c.i)
      {
        parama.j();
        return null;
      }
      Map localMap = (Map)this.d.a();
      if (localObject == com.google.gson.c.c.a)
      {
        parama.a();
        while (parama.e())
        {
          parama.a();
          localObject = this.b.b(parama);
          if (localMap.put(localObject, this.c.b(parama)) != null) {
            throw new com.google.gson.ab("duplicate key: " + localObject);
          }
          parama.b();
        }
        parama.b();
        return localMap;
      }
      parama.c();
      while (parama.e())
      {
        t.a.a(parama);
        localObject = this.b.b(parama);
        if (localMap.put(localObject, this.c.b(parama)) != null) {
          throw new com.google.gson.ab("duplicate key: " + localObject);
        }
      }
      parama.d();
      return localMap;
    }
    
    public void a(d paramd, Map<K, V> paramMap)
    {
      int m = 0;
      int k = 0;
      if (paramMap == null)
      {
        paramd.f();
        return;
      }
      if (!k.a(k.this))
      {
        paramd.d();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          localObject = (Map.Entry)paramMap.next();
          paramd.a(String.valueOf(((Map.Entry)localObject).getKey()));
          this.c.a(paramd, ((Map.Entry)localObject).getValue());
        }
        paramd.e();
        return;
      }
      Object localObject = new ArrayList(paramMap.size());
      ArrayList localArrayList = new ArrayList(paramMap.size());
      paramMap = paramMap.entrySet().iterator();
      int i = 0;
      if (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        com.google.gson.u localu = this.b.a(localEntry.getKey());
        ((List)localObject).add(localu);
        localArrayList.add(localEntry.getValue());
        if ((localu.g()) || (localu.h())) {}
        for (int j = 1;; j = 0)
        {
          i = j | i;
          break;
        }
      }
      if (i != 0)
      {
        paramd.b();
        i = k;
        while (i < ((List)localObject).size())
        {
          paramd.b();
          com.google.gson.a.ab.a((com.google.gson.u)((List)localObject).get(i), paramd);
          this.c.a(paramd, localArrayList.get(i));
          paramd.c();
          i += 1;
        }
        paramd.c();
        return;
      }
      paramd.d();
      i = m;
      while (i < ((List)localObject).size())
      {
        paramd.a(a((com.google.gson.u)((List)localObject).get(i)));
        this.c.a(paramd, localArrayList.get(i));
        i += 1;
      }
      paramd.e();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */