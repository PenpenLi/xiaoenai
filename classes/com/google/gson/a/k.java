package com.google.gson.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class k
  implements z<T>
{
  k(c paramc, Constructor paramConstructor) {}
  
  public T a()
  {
    try
    {
      Object localObject = this.a.newInstance(null);
      return (T)localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("Failed to invoke " + this.a + " with no args", localInstantiationException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException("Failed to invoke " + this.a + " with no args", localInvocationTargetException.getTargetException());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */