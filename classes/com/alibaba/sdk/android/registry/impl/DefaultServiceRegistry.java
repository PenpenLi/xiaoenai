package com.alibaba.sdk.android.registry.impl;

import com.alibaba.sdk.android.registry.ServiceRegistration;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.trace.ActionTraceLogger;
import com.alibaba.sdk.android.trace.TraceLoggerManager;
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

public class DefaultServiceRegistry
  implements ServiceRegistry
{
  private ReadWriteLock lock = new ReentrantReadWriteLock();
  private Map<ServiceRegistration, ServiceEntry> registrationServiceEntries = new HashMap();
  private Map<Class<?>, List<ServiceEntry>> typeServiceEntries = new HashMap();
  
  public <T> T getService(Class<T> paramClass, Map<String, String> paramMap)
  {
    this.lock.readLock().lock();
    for (;;)
    {
      try
      {
        Object localObject = (List)this.typeServiceEntries.get(paramClass);
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
          paramClass = paramClass.cast(((ServiceEntry)((List)localObject).get(0)).instance);
          return paramClass;
        }
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          ServiceEntry localServiceEntry = (ServiceEntry)((Iterator)localObject).next();
          Iterator localIterator = paramMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            String str = (String)localServiceEntry.properties.get(localEntry.getKey());
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
            paramClass = paramClass.cast(localServiceEntry.instance);
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
        this.lock.readLock().unlock();
      }
      int i = 1;
      continue;
      label285:
      i = 0;
    }
  }
  
  public <T> T[] getServices(Class<T> paramClass, Map<String, String> paramMap)
  {
    int i = 0;
    this.lock.readLock().lock();
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        Object localObject = (List)this.typeServiceEntries.get(paramClass);
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
            paramMap[i] = paramClass.cast(((ServiceEntry)((List)localObject).get(i)).instance);
            i += 1;
            continue;
          }
          return paramMap;
        }
        localArrayList = new ArrayList(((List)localObject).size());
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label337;
        }
        localServiceEntry = (ServiceEntry)((Iterator)localObject).next();
        Iterator localIterator = paramMap.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label376;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localServiceEntry.properties.get(localEntry.getKey());
        if (str == null) {
          break label382;
        }
        if (str.equals(localEntry.getValue())) {
          continue;
        }
      }
      finally
      {
        ServiceEntry localServiceEntry;
        this.lock.readLock().unlock();
      }
      if (i != 0)
      {
        localArrayList.add(paramClass.cast(localServiceEntry.instance));
        continue;
        label337:
        paramClass = localArrayList.toArray((Object[])Array.newInstance(paramClass, localArrayList.size()));
        this.lock.readLock().unlock();
        return paramClass;
        label376:
        i = 1;
        continue;
        label382:
        i = 0;
      }
    }
  }
  
  public ServiceRegistration registerService(Class<?>[] paramArrayOfClass, Object paramObject, Map<String, String> paramMap)
  {
    if ((paramArrayOfClass == null) || (paramArrayOfClass.length == 0) || (paramObject == null)) {
      throw new IllegalArgumentException("service types and instance must not be null");
    }
    ActionTraceLogger localActionTraceLogger = TraceLoggerManager.INSTANCE.action("registerService." + paramObject.getClass().getName()).begin();
    ServiceEntry localServiceEntry = new ServiceEntry();
    localServiceEntry.instance = paramObject;
    localServiceEntry.types = paramArrayOfClass;
    localServiceEntry.properties = Collections.synchronizedMap(new HashMap());
    if (paramMap != null)
    {
      paramObject = paramMap.entrySet().iterator();
      while (((Iterator)paramObject).hasNext())
      {
        paramMap = (Map.Entry)((Iterator)paramObject).next();
        if ((paramMap.getKey() != null) && (paramMap.getValue() != null)) {
          localServiceEntry.properties.put(paramMap.getKey(), paramMap.getValue());
        }
      }
    }
    this.lock.writeLock().lock();
    try
    {
      int j = paramArrayOfClass.length;
      int i = 0;
      while (i < j)
      {
        Class<?> localClass = paramArrayOfClass[i];
        paramMap = (List)this.typeServiceEntries.get(localClass);
        paramObject = paramMap;
        if (paramMap == null)
        {
          paramObject = new ArrayList(2);
          this.typeServiceEntries.put(localClass, paramObject);
        }
        ((List)paramObject).add(localServiceEntry);
        i += 1;
      }
      paramArrayOfClass = new InternalServiceRegistration(this, localServiceEntry.properties);
      this.registrationServiceEntries.put(paramArrayOfClass, localServiceEntry);
      return paramArrayOfClass;
    }
    finally
    {
      this.lock.writeLock().unlock();
      localActionTraceLogger.done();
    }
  }
  
  public Object unregisterService(ServiceRegistration paramServiceRegistration)
  {
    if (paramServiceRegistration == null) {
      return null;
    }
    this.lock.writeLock().lock();
    for (;;)
    {
      int i;
      try
      {
        paramServiceRegistration = (ServiceEntry)this.registrationServiceEntries.remove(paramServiceRegistration);
        if (paramServiceRegistration == null) {
          return null;
        }
        if (paramServiceRegistration.types != null)
        {
          Class[] arrayOfClass = paramServiceRegistration.types;
          int j = arrayOfClass.length;
          i = 0;
          if (i < j)
          {
            Class localClass = arrayOfClass[i];
            List localList = (List)this.typeServiceEntries.get(localClass);
            Iterator localIterator = localList.iterator();
            if (localIterator.hasNext())
            {
              if (localIterator.next() != paramServiceRegistration) {
                continue;
              }
              localIterator.remove();
            }
            if (localList.size() != 0) {
              break label199;
            }
            this.typeServiceEntries.remove(localClass);
            break label199;
          }
        }
        paramServiceRegistration = paramServiceRegistration.instance;
        return paramServiceRegistration;
      }
      finally
      {
        this.lock.writeLock().unlock();
      }
      label199:
      i += 1;
    }
  }
  
  static class InternalServiceRegistration
    implements ServiceRegistration
  {
    private Map<String, String> properties;
    private ServiceRegistry serviceRegistry;
    private final String uuid = UUID.randomUUID().toString();
    
    public InternalServiceRegistration(ServiceRegistry paramServiceRegistry, Map<String, String> paramMap)
    {
      this.serviceRegistry = paramServiceRegistry;
      this.properties = paramMap;
    }
    
    public boolean equals(Object paramObject)
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
      paramObject = (InternalServiceRegistration)paramObject;
      return this.uuid.equals(((InternalServiceRegistration)paramObject).uuid);
    }
    
    public int hashCode()
    {
      if (this.uuid == null) {}
      for (int i = 0;; i = this.uuid.hashCode()) {
        return i + 31;
      }
    }
    
    public void setProperties(Map<String, String> paramMap)
    {
      if (paramMap == null) {}
      for (;;)
      {
        return;
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          if ((localEntry.getKey() != null) && (localEntry.getValue() != null)) {
            this.properties.put(localEntry.getKey(), localEntry.getValue());
          }
        }
      }
    }
    
    public void unregister()
    {
      this.serviceRegistry.unregisterService(this);
    }
  }
  
  static class ServiceEntry
  {
    public Object instance;
    public Map<String, String> properties;
    public Class<?>[] types;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\registry\impl\DefaultServiceRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */