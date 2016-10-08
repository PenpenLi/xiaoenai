package com.google.gson;

import com.google.gson.a.a.i;
import com.google.gson.c.a;
import com.google.gson.c.d;
import java.io.IOException;

public abstract class af<T>
{
  public final af<T> a()
  {
    return new ag(this);
  }
  
  public final u a(T paramT)
  {
    try
    {
      i locali = new i();
      a(locali, paramT);
      paramT = locali.a();
      return paramT;
    }
    catch (IOException paramT)
    {
      throw new v(paramT);
    }
  }
  
  public abstract void a(d paramd, T paramT);
  
  public abstract T b(a parama);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */