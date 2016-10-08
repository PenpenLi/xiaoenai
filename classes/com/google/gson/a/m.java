package com.google.gson.a;

import com.google.gson.v;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

class m
  implements z<T>
{
  m(c paramc, Type paramType) {}
  
  public T a()
  {
    if ((this.a instanceof ParameterizedType))
    {
      Type localType = ((ParameterizedType)this.a).getActualTypeArguments()[0];
      if ((localType instanceof Class)) {
        return EnumSet.noneOf((Class)localType);
      }
      throw new v("Invalid EnumSet type: " + this.a.toString());
    }
    throw new v("Invalid EnumSet type: " + this.a.toString());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */