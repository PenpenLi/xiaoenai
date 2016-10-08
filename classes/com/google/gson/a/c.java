package com.google.gson.a;

import com.google.gson.b.a;
import com.google.gson.r;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

public final class c
{
  private final Map<Type, r<?>> a;
  
  public c(Map<Type, r<?>> paramMap)
  {
    this.a = paramMap;
  }
  
  private <T> z<T> a(Class<? super T> paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      if (!paramClass.isAccessible()) {
        paramClass.setAccessible(true);
      }
      paramClass = new k(this, paramClass);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass) {}
    return null;
  }
  
  private <T> z<T> a(Type paramType, Class<? super T> paramClass)
  {
    if (Collection.class.isAssignableFrom(paramClass))
    {
      if (SortedSet.class.isAssignableFrom(paramClass)) {
        return new l(this);
      }
      if (EnumSet.class.isAssignableFrom(paramClass)) {
        return new m(this, paramType);
      }
      if (Set.class.isAssignableFrom(paramClass)) {
        return new n(this);
      }
      if (Queue.class.isAssignableFrom(paramClass)) {
        return new o(this);
      }
      return new p(this);
    }
    if (Map.class.isAssignableFrom(paramClass))
    {
      if (ConcurrentNavigableMap.class.isAssignableFrom(paramClass)) {
        return new q(this);
      }
      if (ConcurrentMap.class.isAssignableFrom(paramClass)) {
        return new e(this);
      }
      if (SortedMap.class.isAssignableFrom(paramClass)) {
        return new f(this);
      }
      if (((paramType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(a.get(((ParameterizedType)paramType).getActualTypeArguments()[0]).getRawType()))) {
        return new g(this);
      }
      return new h(this);
    }
    return null;
  }
  
  private <T> z<T> b(Type paramType, Class<? super T> paramClass)
  {
    return new i(this, paramClass, paramType);
  }
  
  public <T> z<T> a(a<T> parama)
  {
    Type localType = parama.getType();
    Class localClass = parama.getRawType();
    parama = (r)this.a.get(localType);
    if (parama != null) {
      parama = new d(this, parama, localType);
    }
    z localz;
    do
    {
      do
      {
        return parama;
        parama = (r)this.a.get(localClass);
        if (parama != null) {
          return new j(this, parama, localType);
        }
        localz = a(localClass);
        parama = localz;
      } while (localz != null);
      localz = a(localType, localClass);
      parama = localz;
    } while (localz != null);
    return b(localType, localClass);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */