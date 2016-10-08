package com.alibaba.nb.android.trade.web.register.a;

import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class a
  implements AliTradeServiceRegistry
{
  private Map<Class<?>, List<b>> a = new HashMap();
  private Map<com.alibaba.nb.android.trade.web.register.a, b> b = new HashMap();
  private ReadWriteLock c = new ReentrantReadWriteLock();
  
  public final <T> T getService(Class<T> paramClass, Map<String, String> paramMap)
  {
    this.c.readLock().lock();
    for (;;)
    {
      try
      {
        Object localObject = (List)this.a.get(paramClass);
        if (localObject != null)
        {
          i = ((List)localObject).size();
          if (i != 0) {}
        }
        else
        {
          return null;
        }
        if ((paramMap == null) || (paramMap.size() == 0))
        {
          paramClass = paramClass.cast(((b)((List)localObject).get(0)).b);
          return paramClass;
        }
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          b localb = (b)((Iterator)localObject).next();
          Iterator localIterator = paramMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            String str = (String)localb.c.get(localEntry.getKey());
            if (str == null) {
              break label285;
            }
            if (str.equals(localEntry.getValue())) {
              continue;
            }
            break label285;
            if (i == 0) {
              continue;
            }
            paramClass = paramClass.cast(localb.b);
            return paramClass;
          }
        }
        else
        {
          return null;
        }
      }
      finally
      {
        this.c.readLock().unlock();
      }
      int i = 1;
      continue;
      label285:
      i = 0;
    }
  }
  
  public final <T> T[] getServices(Class<T> paramClass, Map<String, String> paramMap)
  {
    int i = 0;
    this.c.readLock().lock();
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        Object localObject = (List)this.a.get(paramClass);
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          paramClass = (Object[])Array.newInstance(paramClass, 0);
          return paramClass;
        }
        if ((paramMap == null) || (paramMap.size() == 0))
        {
          paramMap = (Object[])Array.newInstance(paramClass, ((List)localObject).size());
          int j = ((List)localObject).size();
          if (i < j)
          {
            paramMap[i] = paramClass.cast(((b)((List)localObject).get(i)).b);
            i += 1;
            continue;
          }
          return paramMap;
        }
        localArrayList = new ArrayList(((List)localObject).size());
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label331;
        }
        localb = (b)((Iterator)localObject).next();
        Iterator localIterator = paramMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label367;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localb.c.get(localEntry.getKey());
        if (str == null) {
          break label373;
        }
        if (str.equals(localEntry.getValue())) {
          continue;
        }
      }
      finally
      {
        b localb;
        this.c.readLock().unlock();
      }
      if (i != 0)
      {
        localArrayList.add(paramClass.cast(localb.b));
        continue;
        label331:
        paramClass = localArrayList.toArray((Object[])Array.newInstance(paramClass, localArrayList.size()));
        this.c.readLock().unlock();
        return paramClass;
        label367:
        i = 1;
        continue;
        label373:
        i = 0;
      }
    }
  }
  
  public final com.alibaba.nb.android.trade.web.register.a registerService(Class<?>[] paramArrayOfClass, Object paramObject, Map<String, String> paramMap)
  {
    if ((paramArrayOfClass == null) || (paramArrayOfClass.length == 0) || (paramObject == null)) {
      throw new IllegalArgumentException("service types and instance must not be null");
    }
    b localb = new b();
    localb.b = paramObject;
    localb.a = paramArrayOfClass;
    localb.c = Collections.synchronizedMap(new HashMap());
    if (paramMap != null)
    {
      paramObject = paramMap.entrySet().iterator();
      while (((Iterator)paramObject).hasNext())
      {
        paramMap = (Map.Entry)((Iterator)paramObject).next();
        if ((paramMap.getKey() != null) && (paramMap.getValue() != null)) {
          localb.c.put(paramMap.getKey(), paramMap.getValue());
        }
      }
    }
    this.c.writeLock().lock();
    try
    {
      int j = paramArrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        Class<?> localClass = paramArrayOfClass[i];
        paramMap = (List)this.a.get(localClass);
        paramObject = paramMap;
        if (paramMap == null)
        {
          paramObject = new ArrayList(2);
          this.a.put(localClass, paramObject);
        }
        ((List)paramObject).add(localb);
        i += 1;
      }
      paramArrayOfClass = new a(this, localb.c);
      this.b.put(paramArrayOfClass, localb);
      return paramArrayOfClass;
    }
    finally
    {
      this.c.writeLock().unlock();
    }
  }
  
  public final Object unregisterService(com.alibaba.nb.android.trade.web.register.a parama)
  {
    if (parama == null) {
      return null;
    }
    this.c.writeLock().lock();
    for (;;)
    {
      int i;
      try
      {
        parama = (b)this.b.remove(parama);
        if (parama == null) {
          return null;
        }
        if (parama.a != null)
        {
          Class[] arrayOfClass = parama.a;
          int j = arrayOfClass.length;
          i = 0;
          if (i < j)
          {
            Class localClass = arrayOfClass[i];
            List localList = (List)this.a.get(localClass);
            Iterator localIterator = localList.iterator();
            if (localIterator.hasNext())
            {
              if (localIterator.next() != parama) {
                continue;
              }
              localIterator.remove();
            }
            if (localList.size() != 0) {
              break label199;
            }
            this.a.remove(localClass);
            break label199;
          }
        }
        parama = parama.b;
        return parama;
      }
      finally
      {
        this.c.writeLock().unlock();
      }
      label199:
      i += 1;
    }
  }
  
  static final class a
    implements com.alibaba.nb.android.trade.web.register.a
  {
    private final String a = UUID.randomUUID().toString();
    private AliTradeServiceRegistry b;
    private Map<String, String> c;
    
    public a(AliTradeServiceRegistry paramAliTradeServiceRegistry, Map<String, String> paramMap)
    {
      this.b = paramAliTradeServiceRegistry;
      this.c = paramMap;
    }
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (this == paramObject) {
        bool1 = true;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      paramObject = (a)paramObject;
      return this.a.equals(((a)paramObject).a);
    }
    
    public final int hashCode()
    {
      if (this.a == null) {}
      for (int i = 0;; i = this.a.hashCode()) {
        return i + 31;
      }
    }
  }
  
  static final class b
  {
    public Class<?>[] a;
    public Object b;
    public Map<String, String> c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\register\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */