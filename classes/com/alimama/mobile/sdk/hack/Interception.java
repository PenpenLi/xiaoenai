package com.alimama.mobile.sdk.hack;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Interception
{
  public static <T> T proxy(Object paramObject, InterceptionHandler<T> paramInterceptionHandler, Class<?>... paramVarArgs)
  {
    paramInterceptionHandler.setDelegatee(paramObject);
    return (T)Proxy.newProxyInstance(Interception.class.getClassLoader(), paramVarArgs, paramInterceptionHandler);
  }
  
  public static <T> T proxy(Object paramObject, Class<T> paramClass, InterceptionHandler<T> paramInterceptionHandler)
  {
    if ((paramObject instanceof Intercepted)) {
      return (T)paramObject;
    }
    paramInterceptionHandler.setDelegatee(paramObject);
    return (T)Proxy.newProxyInstance(Interception.class.getClassLoader(), new Class[] { paramClass, Intercepted.class }, paramInterceptionHandler);
  }
  
  private static abstract interface Intercepted {}
  
  public static abstract class InterceptionHandler<T>
    implements InvocationHandler
  {
    private T mDelegatee;
    
    protected T delegatee()
    {
      return (T)this.mDelegatee;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      try
      {
        paramObject = paramMethod.invoke(delegatee(), paramArrayOfObject);
        return paramObject;
      }
      catch (IllegalArgumentException paramObject)
      {
        ((IllegalArgumentException)paramObject).printStackTrace();
        return null;
      }
      catch (IllegalAccessException paramObject)
      {
        ((IllegalAccessException)paramObject).printStackTrace();
        return null;
      }
      catch (InvocationTargetException paramObject)
      {
        throw ((InvocationTargetException)paramObject).getTargetException();
      }
    }
    
    void setDelegatee(T paramT)
    {
      this.mDelegatee = paramT;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\hack\Interception.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */