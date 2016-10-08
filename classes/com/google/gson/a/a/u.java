package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.c.d;
import com.google.gson.j;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class u<T>
  extends af<T>
{
  private final j a;
  private final af<T> b;
  private final Type c;
  
  u(j paramj, af<T> paramaf, Type paramType)
  {
    this.a = paramj;
    this.b = paramaf;
    this.c = paramType;
  }
  
  private Type a(Type paramType, Object paramObject)
  {
    Object localObject = paramType;
    if (paramObject != null) {
      if ((paramType != Object.class) && (!(paramType instanceof TypeVariable)))
      {
        localObject = paramType;
        if (!(paramType instanceof Class)) {}
      }
      else
      {
        localObject = paramObject.getClass();
      }
    }
    return (Type)localObject;
  }
  
  public void a(d paramd, T paramT)
  {
    af localaf = this.b;
    Type localType = a(this.c, paramT);
    if (localType != this.c)
    {
      localaf = this.a.a(com.google.gson.b.a.get(localType));
      if ((localaf instanceof o.a)) {
        break label52;
      }
    }
    for (;;)
    {
      localaf.a(paramd, paramT);
      return;
      label52:
      if (!(this.b instanceof o.a)) {
        localaf = this.b;
      }
    }
  }
  
  public T b(com.google.gson.c.a parama)
  {
    return (T)this.b.b(parama);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */