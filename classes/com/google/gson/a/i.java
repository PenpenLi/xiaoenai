package com.google.gson.a;

import java.lang.reflect.Type;

class i
  implements z<T>
{
  private final ad d = ad.a();
  
  i(c paramc, Class paramClass, Type paramType) {}
  
  public T a()
  {
    try
    {
      Object localObject = this.d.a(this.a);
      return (T)localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Unable to invoke no-args constructor for " + this.b + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", localException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */