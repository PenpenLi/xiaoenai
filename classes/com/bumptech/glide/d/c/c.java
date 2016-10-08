package com.bumptech.glide.d.c;

import android.content.Context;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c
{
  private static final l c = new d();
  private final Map<Class, Map<Class, m>> a = new HashMap();
  private final Map<Class, Map<Class, l>> b = new HashMap();
  private final Context d;
  
  public c(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
  }
  
  private <T, Y> void a(Class<T> paramClass, Class<Y> paramClass1, l<T, Y> paraml)
  {
    Map localMap = (Map)this.b.get(paramClass);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.b.put(paramClass, localObject);
    }
    ((Map)localObject).put(paramClass1, paraml);
  }
  
  private <T, Y> void c(Class<T> paramClass, Class<Y> paramClass1)
  {
    a(paramClass, paramClass1, c);
  }
  
  private <T, Y> l<T, Y> d(Class<T> paramClass, Class<Y> paramClass1)
  {
    paramClass = (Map)this.b.get(paramClass);
    if (paramClass != null) {
      return (l)paramClass.get(paramClass1);
    }
    return null;
  }
  
  private <T, Y> m<T, Y> e(Class<T> paramClass, Class<Y> paramClass1)
  {
    Object localObject1 = (Map)this.a.get(paramClass);
    if (localObject1 != null) {}
    for (localObject1 = (m)((Map)localObject1).get(paramClass1);; localObject1 = null)
    {
      Object localObject2 = localObject1;
      Iterator localIterator;
      if (localObject1 == null) {
        localIterator = this.a.keySet().iterator();
      }
      while (localIterator.hasNext())
      {
        localObject2 = (Class)localIterator.next();
        if (((Class)localObject2).isAssignableFrom(paramClass))
        {
          localObject2 = (Map)this.a.get(localObject2);
          if (localObject2 != null)
          {
            localObject2 = (m)((Map)localObject2).get(paramClass1);
            localObject1 = localObject2;
            if (localObject2 != null) {
              return (m<T, Y>)localObject2;
            }
          }
        }
      }
      return (m<T, Y>)localObject1;
    }
  }
  
  public <T, Y> m<T, Y> a(Class<T> paramClass, Class<Y> paramClass1)
  {
    for (;;)
    {
      try
      {
        this.b.clear();
        paramClass = (Map)this.a.get(paramClass);
        if (paramClass != null)
        {
          paramClass = (m)paramClass.remove(paramClass1);
          return paramClass;
        }
      }
      finally {}
      paramClass = null;
    }
  }
  
  public <T, Y> m<T, Y> a(Class<T> paramClass, Class<Y> paramClass1, m<T, Y> paramm)
  {
    try
    {
      this.b.clear();
      Map localMap = (Map)this.a.get(paramClass);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new HashMap();
        this.a.put(paramClass, localObject);
      }
      paramClass1 = (m)((Map)localObject).put(paramClass1, paramm);
      paramClass = paramClass1;
      if (paramClass1 != null)
      {
        paramm = this.a.values().iterator();
        boolean bool;
        do
        {
          paramClass = paramClass1;
          if (!paramm.hasNext()) {
            break;
          }
          bool = ((Map)paramm.next()).containsValue(paramClass1);
        } while (!bool);
        paramClass = null;
      }
      return paramClass;
    }
    finally {}
  }
  
  public <T, Y> l<T, Y> b(Class<T> paramClass, Class<Y> paramClass1)
  {
    for (;;)
    {
      l locall;
      try
      {
        locall = d(paramClass, paramClass1);
        if (locall != null)
        {
          boolean bool = c.equals(locall);
          paramClass = locall;
          if (bool) {
            paramClass = null;
          }
          return paramClass;
        }
        m localm = e(paramClass, paramClass1);
        if (localm != null)
        {
          locall = localm.a(this.d, this);
          a(paramClass, paramClass1, locall);
          paramClass = locall;
          continue;
        }
        c(paramClass, paramClass1);
      }
      finally {}
      paramClass = locall;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */