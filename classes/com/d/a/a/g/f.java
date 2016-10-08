package com.d.a.a.g;

import com.d.a.a.e;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class f
  implements c
{
  private final TreeSet<e> a;
  private final Map<String, Integer> b;
  private final Map<Long, e> c;
  
  public f(Comparator<e> paramComparator)
  {
    this.a = new TreeSet(paramComparator);
    this.b = new HashMap();
    this.c = new HashMap();
  }
  
  private void a(String paramString)
  {
    if (!this.b.containsKey(paramString))
    {
      this.b.put(paramString, Integer.valueOf(1));
      return;
    }
    this.b.put(paramString, Integer.valueOf(((Integer)this.b.get(paramString)).intValue() + 1));
  }
  
  private e b()
  {
    if (this.a.size() < 1) {
      return null;
    }
    return (e)this.a.first();
  }
  
  private void b(String paramString)
  {
    Integer localInteger = (Integer)this.b.get(paramString);
    if ((localInteger == null) || (localInteger.intValue() == 0)) {
      com.d.a.a.e.b.b("detected inconsistency in NonPersistentJobSet's group id hash", new Object[0]);
    }
    while (Integer.valueOf(localInteger.intValue() - 1).intValue() != 0) {
      return;
    }
    this.b.remove(paramString);
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public e a(Collection<String> paramCollection)
  {
    Object localObject;
    if ((paramCollection == null) || (paramCollection.size() == 0))
    {
      localObject = b();
      return (e)localObject;
    }
    Iterator localIterator = this.a.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label77;
      }
      e locale = (e)localIterator.next();
      localObject = locale;
      if (locale.i() == null) {
        break;
      }
      localObject = locale;
      if (!paramCollection.contains(locale.i())) {
        break;
      }
    }
    label77:
    return null;
  }
  
  public b a(long paramLong, Collection<String> paramCollection)
  {
    int i = 0;
    int j = this.b.keySet().size();
    if (j > 0) {}
    for (HashSet localHashSet = new HashSet();; localHashSet = null)
    {
      Iterator localIterator = this.a.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          e locale = (e)localIterator.next();
          if (locale.g() >= paramLong) {
            break label150;
          }
          if (locale.i() != null)
          {
            if ((paramCollection != null) && (paramCollection.contains(locale.i()))) {
              continue;
            }
            if ((j <= 0) || (!localHashSet.add(locale.i()))) {
              break label150;
            }
            i += 1;
          }
        }
      }
      label150:
      for (;;)
      {
        break;
        i += 1;
        continue;
        return new b(i, localHashSet);
      }
    }
  }
  
  public boolean a(e parame)
  {
    if (parame.a() == null) {
      throw new RuntimeException("cannot add job holder w/o an ID");
    }
    boolean bool2 = this.a.add(parame);
    boolean bool1 = bool2;
    if (!bool2)
    {
      b(parame);
      bool1 = this.a.add(parame);
    }
    if (bool1)
    {
      this.c.put(parame.a(), parame);
      if (parame.i() != null) {
        a(parame.i());
      }
    }
    return bool1;
  }
  
  public b b(Collection<String> paramCollection)
  {
    HashSet localHashSet = null;
    if (this.b.size() == 0) {
      return new b(this.a.size(), null);
    }
    Iterator localIterator = this.a.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (locale.i() != null)
      {
        if ((paramCollection != null) && (paramCollection.contains(locale.i()))) {
          continue;
        }
        if (localHashSet == null)
        {
          localHashSet = new HashSet();
          localHashSet.add(locale.i());
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (!localHashSet.add(locale.i())) {
          break;
        }
      }
    }
    return new b(i, localHashSet);
  }
  
  public boolean b(e parame)
  {
    boolean bool = this.a.remove(parame);
    if (bool)
    {
      this.c.remove(parame.a());
      if (parame.i() != null) {
        b(parame.i());
      }
    }
    return bool;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\g\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */