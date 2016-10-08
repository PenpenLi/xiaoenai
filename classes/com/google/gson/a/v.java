package com.google.gson.a;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class v<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  private static final Comparator<Comparable> g;
  Comparator<? super K> a;
  d<K, V> b;
  int c = 0;
  int d = 0;
  final d<K, V> e = new d();
  private v<K, V>.a h;
  private v<K, V>.b i;
  
  static
  {
    if (!v.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      f = bool;
      g = new w();
      return;
    }
  }
  
  public v()
  {
    this(g);
  }
  
  public v(Comparator<? super K> paramComparator)
  {
    if (paramComparator != null) {}
    for (;;)
    {
      this.a = paramComparator;
      return;
      paramComparator = g;
    }
  }
  
  private void a(d<K, V> paramd)
  {
    int m = 0;
    d locald1 = paramd.b;
    d locald2 = paramd.c;
    d locald3 = locald2.b;
    d locald4 = locald2.c;
    paramd.c = locald3;
    if (locald3 != null) {
      locald3.a = paramd;
    }
    a(paramd, locald2);
    locald2.b = paramd;
    paramd.a = locald2;
    int j;
    if (locald1 != null)
    {
      j = locald1.h;
      if (locald3 == null) {
        break label135;
      }
    }
    label135:
    for (int k = locald3.h;; k = 0)
    {
      paramd.h = (Math.max(j, k) + 1);
      k = paramd.h;
      j = m;
      if (locald4 != null) {
        j = locald4.h;
      }
      locald2.h = (Math.max(k, j) + 1);
      return;
      j = 0;
      break;
    }
  }
  
  private void a(d<K, V> paramd1, d<K, V> paramd2)
  {
    d locald = paramd1.a;
    paramd1.a = null;
    if (paramd2 != null) {
      paramd2.a = locald;
    }
    if (locald != null)
    {
      if (locald.b == paramd1)
      {
        locald.b = paramd2;
        return;
      }
      if ((!f) && (locald.c != paramd1)) {
        throw new AssertionError();
      }
      locald.c = paramd2;
      return;
    }
    this.b = paramd2;
  }
  
  private boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private void b(d<K, V> paramd)
  {
    int m = 0;
    d locald1 = paramd.b;
    d locald2 = paramd.c;
    d locald3 = locald1.b;
    d locald4 = locald1.c;
    paramd.b = locald4;
    if (locald4 != null) {
      locald4.a = paramd;
    }
    a(paramd, locald1);
    locald1.c = paramd;
    paramd.a = locald1;
    int j;
    if (locald2 != null)
    {
      j = locald2.h;
      if (locald4 == null) {
        break label135;
      }
    }
    label135:
    for (int k = locald4.h;; k = 0)
    {
      paramd.h = (Math.max(j, k) + 1);
      k = paramd.h;
      j = m;
      if (locald3 != null) {
        j = locald3.h;
      }
      locald1.h = (Math.max(k, j) + 1);
      return;
      j = 0;
      break;
    }
  }
  
  private void b(d<K, V> paramd, boolean paramBoolean)
  {
    d locald1;
    d locald2;
    int j;
    int k;
    label37:
    int m;
    d locald3;
    if (paramd != null)
    {
      locald1 = paramd.b;
      locald2 = paramd.c;
      if (locald1 == null) {
        break label118;
      }
      j = locald1.h;
      if (locald2 == null) {
        break label124;
      }
      k = locald2.h;
      m = j - k;
      if (m != -2) {
        break label176;
      }
      locald1 = locald2.b;
      locald3 = locald2.c;
      if (locald3 == null) {
        break label130;
      }
      j = locald3.h;
      label76:
      if (locald1 == null) {
        break label136;
      }
      k = locald1.h;
      label86:
      j = k - j;
      if ((j != -1) && ((j != 0) || (paramBoolean))) {
        break label142;
      }
      a(paramd);
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label249;
      }
      label117:
      return;
      label118:
      j = 0;
      break;
      label124:
      k = 0;
      break label37;
      label130:
      j = 0;
      break label76;
      label136:
      k = 0;
      break label86;
      label142:
      if ((!f) && (j != 1)) {
        throw new AssertionError();
      }
      b(locald2);
      a(paramd);
    }
    label176:
    if (m == 2)
    {
      locald2 = locald1.b;
      locald3 = locald1.c;
      if (locald3 != null)
      {
        j = locald3.h;
        label206:
        if (locald2 == null) {
          break label263;
        }
        k = locald2.h;
        label218:
        j = k - j;
        if ((j != 1) && ((j != 0) || (paramBoolean))) {
          break label269;
        }
        b(paramd);
        label245:
        if (paramBoolean) {
          break label300;
        }
      }
    }
    label249:
    label263:
    label269:
    label300:
    label320:
    do
    {
      do
      {
        paramd = paramd.a;
        break;
        j = 0;
        break label206;
        k = 0;
        break label218;
        if ((!f) && (j != -1)) {
          throw new AssertionError();
        }
        a(locald1);
        b(paramd);
        break label245;
        break label117;
        if (m != 0) {
          break label320;
        }
        paramd.h = (j + 1);
      } while (!paramBoolean);
      return;
      if ((!f) && (m != -1) && (m != 1)) {
        throw new AssertionError();
      }
      paramd.h = (Math.max(j, k) + 1);
    } while (paramBoolean);
  }
  
  private Object writeReplace()
  {
    return new LinkedHashMap(this);
  }
  
  d<K, V> a(Object paramObject)
  {
    d locald = null;
    if (paramObject != null) {}
    try
    {
      locald = a(paramObject, false);
      return locald;
    }
    catch (ClassCastException paramObject) {}
    return null;
  }
  
  d<K, V> a(K paramK, boolean paramBoolean)
  {
    Object localObject3 = null;
    Comparator localComparator = this.a;
    Object localObject1 = this.b;
    int j;
    Object localObject2;
    if (localObject1 != null)
    {
      Comparable localComparable;
      if (localComparator == g)
      {
        localComparable = (Comparable)paramK;
        if (localComparable == null) {
          break label67;
        }
      }
      label58:
      label67:
      for (j = localComparable.compareTo(((d)localObject1).f);; j = localComparator.compare(paramK, ((d)localObject1).f))
      {
        if (j != 0) {
          break label84;
        }
        localObject2 = localObject1;
        return (d<K, V>)localObject2;
        localComparable = null;
        break;
      }
      label84:
      if (j < 0)
      {
        localObject2 = ((d)localObject1).b;
        label95:
        if (localObject2 != null) {
          break label175;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject3;
      if (!paramBoolean) {
        break label58;
      }
      localObject2 = this.e;
      if (localObject1 == null)
      {
        if ((localComparator == g) && (!(paramK instanceof Comparable)))
        {
          throw new ClassCastException(paramK.getClass().getName() + " is not Comparable");
          localObject2 = ((d)localObject1).c;
          break label95;
          label175:
          localObject1 = localObject2;
          break;
        }
        paramK = new d((d)localObject1, paramK, (d)localObject2, ((d)localObject2).e);
        this.b = paramK;
        this.c += 1;
        this.d += 1;
        return paramK;
      }
      paramK = new d((d)localObject1, paramK, (d)localObject2, ((d)localObject2).e);
      if (j < 0) {
        ((d)localObject1).b = paramK;
      }
      for (;;)
      {
        b((d)localObject1, true);
        break;
        ((d)localObject1).c = paramK;
      }
      j = 0;
    }
  }
  
  d<K, V> a(Map.Entry<?, ?> paramEntry)
  {
    d locald = a(paramEntry.getKey());
    if ((locald != null) && (a(locald.g, paramEntry.getValue()))) {}
    for (int j = 1; j != 0; j = 0) {
      return locald;
    }
    return null;
  }
  
  void a(d<K, V> paramd, boolean paramBoolean)
  {
    int k = 0;
    if (paramBoolean)
    {
      paramd.e.d = paramd.d;
      paramd.d.e = paramd.e;
    }
    d locald1 = paramd.b;
    d locald2 = paramd.c;
    d locald3 = paramd.a;
    int j;
    if ((locald1 != null) && (locald2 != null)) {
      if (locald1.h > locald2.h)
      {
        locald1 = locald1.b();
        a(locald1, false);
        locald2 = paramd.b;
        if (locald2 == null) {
          break label249;
        }
        j = locald2.h;
        locald1.b = locald2;
        locald2.a = locald1;
        paramd.b = null;
      }
    }
    for (;;)
    {
      locald2 = paramd.c;
      if (locald2 != null)
      {
        k = locald2.h;
        locald1.c = locald2;
        locald2.a = locald1;
        paramd.c = null;
      }
      locald1.h = (Math.max(j, k) + 1);
      a(paramd, locald1);
      return;
      locald1 = locald2.a();
      break;
      if (locald1 != null)
      {
        a(paramd, locald1);
        paramd.b = null;
      }
      for (;;)
      {
        b(locald3, false);
        this.c -= 1;
        this.d += 1;
        return;
        if (locald2 != null)
        {
          a(paramd, locald2);
          paramd.c = null;
        }
        else
        {
          a(paramd, null);
        }
      }
      label249:
      j = 0;
    }
  }
  
  d<K, V> b(Object paramObject)
  {
    paramObject = a(paramObject);
    if (paramObject != null) {
      a((d)paramObject, true);
    }
    return (d<K, V>)paramObject;
  }
  
  public void clear()
  {
    this.b = null;
    this.c = 0;
    this.d += 1;
    d locald = this.e;
    locald.e = locald;
    locald.d = locald;
  }
  
  public boolean containsKey(Object paramObject)
  {
    return a(paramObject) != null;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    a locala = this.h;
    if (locala != null) {
      return locala;
    }
    locala = new a();
    this.h = locala;
    return locala;
  }
  
  public V get(Object paramObject)
  {
    paramObject = a(paramObject);
    if (paramObject != null) {
      return (V)((d)paramObject).g;
    }
    return null;
  }
  
  public Set<K> keySet()
  {
    b localb = this.i;
    if (localb != null) {
      return localb;
    }
    localb = new b();
    this.i = localb;
    return localb;
  }
  
  public V put(K paramK, V paramV)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    paramK = a(paramK, true);
    Object localObject = paramK.g;
    paramK.g = paramV;
    return (V)localObject;
  }
  
  public V remove(Object paramObject)
  {
    paramObject = b(paramObject);
    if (paramObject != null) {
      return (V)((d)paramObject).g;
    }
    return null;
  }
  
  public int size()
  {
    return this.c;
  }
  
  class a
    extends AbstractSet<Map.Entry<K, V>>
  {
    a() {}
    
    public void clear()
    {
      v.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Map.Entry)) && (v.this.a((Map.Entry)paramObject) != null);
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new x(this);
    }
    
    public boolean remove(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {}
      do
      {
        return false;
        paramObject = v.this.a((Map.Entry)paramObject);
      } while (paramObject == null);
      v.this.a((v.d)paramObject, true);
      return true;
    }
    
    public int size()
    {
      return v.this.c;
    }
  }
  
  final class b
    extends AbstractSet<K>
  {
    b() {}
    
    public void clear()
    {
      v.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return v.this.containsKey(paramObject);
    }
    
    public Iterator<K> iterator()
    {
      return new y(this);
    }
    
    public boolean remove(Object paramObject)
    {
      return v.this.b(paramObject) != null;
    }
    
    public int size()
    {
      return v.this.c;
    }
  }
  
  private abstract class c<T>
    implements Iterator<T>
  {
    v.d<K, V> b = v.this.e.d;
    v.d<K, V> c = null;
    int d = v.this.d;
    
    private c() {}
    
    final v.d<K, V> b()
    {
      v.d locald = this.b;
      if (locald == v.this.e) {
        throw new NoSuchElementException();
      }
      if (v.this.d != this.d) {
        throw new ConcurrentModificationException();
      }
      this.b = locald.d;
      this.c = locald;
      return locald;
    }
    
    public final boolean hasNext()
    {
      return this.b != v.this.e;
    }
    
    public final void remove()
    {
      if (this.c == null) {
        throw new IllegalStateException();
      }
      v.this.a(this.c, true);
      this.c = null;
      this.d = v.this.d;
    }
  }
  
  static final class d<K, V>
    implements Map.Entry<K, V>
  {
    d<K, V> a;
    d<K, V> b;
    d<K, V> c;
    d<K, V> d;
    d<K, V> e;
    final K f;
    V g;
    int h;
    
    d()
    {
      this.f = null;
      this.e = this;
      this.d = this;
    }
    
    d(d<K, V> paramd1, K paramK, d<K, V> paramd2, d<K, V> paramd3)
    {
      this.a = paramd1;
      this.f = paramK;
      this.h = 1;
      this.d = paramd2;
      this.e = paramd3;
      paramd3.d = this;
      paramd2.e = this;
    }
    
    public d<K, V> a()
    {
      Object localObject1 = this.b;
      Object localObject2 = this;
      while (localObject1 != null)
      {
        d locald = ((d)localObject1).b;
        localObject2 = localObject1;
        localObject1 = locald;
      }
      return (d<K, V>)localObject2;
    }
    
    public d<K, V> b()
    {
      Object localObject1 = this.c;
      Object localObject2 = this;
      while (localObject1 != null)
      {
        d locald = ((d)localObject1).c;
        localObject2 = localObject1;
        localObject1 = locald;
      }
      return (d<K, V>)localObject2;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        if (this.f != null) {
          break label56;
        }
        bool1 = bool2;
        if (((Map.Entry)paramObject).getKey() == null)
        {
          if (this.g != null) {
            break label77;
          }
          bool1 = bool2;
          if (((Map.Entry)paramObject).getValue() != null) {}
        }
      }
      for (;;)
      {
        bool1 = true;
        label56:
        label77:
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!this.f.equals(((Map.Entry)paramObject).getKey()));
          break;
          bool1 = bool2;
        } while (!this.g.equals(((Map.Entry)paramObject).getValue()));
      }
    }
    
    public K getKey()
    {
      return (K)this.f;
    }
    
    public V getValue()
    {
      return (V)this.g;
    }
    
    public int hashCode()
    {
      int j = 0;
      int i;
      if (this.f == null)
      {
        i = 0;
        if (this.g != null) {
          break label33;
        }
      }
      for (;;)
      {
        return i ^ j;
        i = this.f.hashCode();
        break;
        label33:
        j = this.g.hashCode();
      }
    }
    
    public V setValue(V paramV)
    {
      Object localObject = this.g;
      this.g = paramV;
      return (V)localObject;
    }
    
    public String toString()
    {
      return this.f + "=" + this.g;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */