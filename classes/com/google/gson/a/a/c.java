package com.google.gson.a.a;

import com.google.gson.a.b;
import com.google.gson.a.z;
import com.google.gson.af;
import com.google.gson.ah;
import com.google.gson.c.d;
import com.google.gson.j;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

public final class c
  implements ah
{
  private final com.google.gson.a.c a;
  
  public c(com.google.gson.a.c paramc)
  {
    this.a = paramc;
  }
  
  public <T> af<T> a(j paramj, com.google.gson.b.a<T> parama)
  {
    Type localType = parama.getType();
    Class localClass = parama.getRawType();
    if (!Collection.class.isAssignableFrom(localClass)) {
      return null;
    }
    localType = b.a(localType, localClass);
    return new a(paramj, localType, paramj.a(com.google.gson.b.a.get(localType)), this.a.a(parama));
  }
  
  private static final class a<E>
    extends af<Collection<E>>
  {
    private final af<E> a;
    private final z<? extends Collection<E>> b;
    
    public a(j paramj, Type paramType, af<E> paramaf, z<? extends Collection<E>> paramz)
    {
      this.a = new u(paramj, paramaf, paramType);
      this.b = paramz;
    }
    
    public Collection<E> a(com.google.gson.c.a parama)
    {
      if (parama.f() == com.google.gson.c.c.i)
      {
        parama.j();
        return null;
      }
      Collection localCollection = (Collection)this.b.a();
      parama.a();
      while (parama.e()) {
        localCollection.add(this.a.b(parama));
      }
      parama.b();
      return localCollection;
    }
    
    public void a(d paramd, Collection<E> paramCollection)
    {
      if (paramCollection == null)
      {
        paramd.f();
        return;
      }
      paramd.b();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        this.a.a(paramd, localObject);
      }
      paramd.c();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */