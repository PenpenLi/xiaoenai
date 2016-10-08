package com.alimama.mobile.sdk.hack;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Hack
{
  private static AssertionFailureHandler sFailureHandler;
  
  private static void fail(Hack.HackDeclaration.HackAssertionException paramHackAssertionException)
  {
    if ((sFailureHandler == null) || (!sFailureHandler.onAssertionFailure(paramHackAssertionException))) {
      throw paramHackAssertionException;
    }
  }
  
  public static <T> HackedClass<T> into(Class<T> paramClass)
  {
    return new HackedClass(paramClass);
  }
  
  public static <T> HackedClass<T> into(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = new HackedClass(paramClassLoader.loadClass(paramString));
      return paramClassLoader;
    }
    catch (Exception paramClassLoader)
    {
      fail(new Hack.HackDeclaration.HackAssertionException(paramClassLoader));
    }
    return new HackedClass(null);
  }
  
  public static <T> HackedClass<T> into(String paramString)
  {
    try
    {
      paramString = new HackedClass(Class.forName(paramString));
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      fail(new Hack.HackDeclaration.HackAssertionException(paramString));
    }
    return new HackedClass(null);
  }
  
  public static void setAssertionFailureHandler(AssertionFailureHandler paramAssertionFailureHandler)
  {
    sFailureHandler = paramAssertionFailureHandler;
  }
  
  public static abstract interface AssertionFailureHandler
  {
    public abstract boolean onAssertionFailure(Hack.HackDeclaration.HackAssertionException paramHackAssertionException);
  }
  
  public static abstract class HackDeclaration
  {
    public static class HackAssertionException
      extends Throwable
    {
      private static final long serialVersionUID = 1L;
      private Class<?> mHackedClass;
      private String mHackedFieldName;
      private String mHackedMethodName;
      
      public HackAssertionException(Exception paramException)
      {
        super();
      }
      
      public HackAssertionException(String paramString)
      {
        super();
      }
      
      public Class<?> getHackedClass()
      {
        return this.mHackedClass;
      }
      
      public String getHackedFieldName()
      {
        return this.mHackedFieldName;
      }
      
      public String getHackedMethodName()
      {
        return this.mHackedMethodName;
      }
      
      public void setHackedClass(Class<?> paramClass)
      {
        this.mHackedClass = paramClass;
      }
      
      public void setHackedFieldName(String paramString)
      {
        this.mHackedFieldName = paramString;
      }
      
      public void setHackedMethodName(String paramString)
      {
        this.mHackedMethodName = paramString;
      }
      
      public String toString()
      {
        if (getCause() != null) {
          return getClass().getName() + ": " + getCause();
        }
        return super.toString();
      }
    }
  }
  
  public static class HackedClass<C>
  {
    protected Class<C> mClass;
    
    public HackedClass(Class<C> paramClass)
    {
      this.mClass = paramClass;
    }
    
    public Hack.HackedConstructor constructor(Class<?>... paramVarArgs)
    {
      return new Hack.HackedConstructor(this.mClass, paramVarArgs);
    }
    
    public Hack.HackedField<C, Object> field(String paramString)
    {
      return new Hack.HackedField(this.mClass, paramString, 0);
    }
    
    public Class<C> getmClass()
    {
      return this.mClass;
    }
    
    public Hack.HackedMethod method(String paramString, Class<?>... paramVarArgs)
    {
      return new Hack.HackedMethod(this.mClass, paramString, paramVarArgs, 0);
    }
    
    public Hack.HackedField<C, Object> staticField(String paramString)
    {
      return new Hack.HackedField(this.mClass, paramString, 8);
    }
    
    public Hack.HackedMethod staticMethod(String paramString, Class<?>... paramVarArgs)
    {
      return new Hack.HackedMethod(this.mClass, paramString, paramVarArgs, 8);
    }
  }
  
  public static class HackedConstructor
  {
    protected Constructor<?> mConstructor;
    
    HackedConstructor(Class<?> paramClass, Class<?>[] paramArrayOfClass)
    {
      if (paramClass == null) {
        return;
      }
      try
      {
        this.mConstructor = paramClass.getDeclaredConstructor(paramArrayOfClass);
        return;
      }
      catch (NoSuchMethodException paramArrayOfClass)
      {
        paramArrayOfClass = new Hack.HackDeclaration.HackAssertionException(paramArrayOfClass);
        paramArrayOfClass.setHackedClass(paramClass);
        Hack.fail(paramArrayOfClass);
      }
    }
    
    public Object getInstance(Object... paramVarArgs)
    {
      this.mConstructor.setAccessible(true);
      try
      {
        paramVarArgs = this.mConstructor.newInstance(paramVarArgs);
        return paramVarArgs;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
      }
      return null;
    }
  }
  
  public static class HackedField<C, T>
  {
    private final Field mField;
    private WeakReference<Object> mObject;
    
    HackedField(Class<C> paramClass, String paramString, int paramInt)
    {
      if (paramClass == null)
      {
        this.mField = null;
        return;
      }
      Field localField1 = localField2;
      Object localObject1 = localObject2;
      try
      {
        this.mObject = null;
        localField1 = localField2;
        localObject1 = localObject2;
        localField2 = paramClass.getDeclaredField(paramString);
        if (paramInt > 0)
        {
          localField1 = localField2;
          localObject1 = localField2;
          if ((localField2.getModifiers() & paramInt) != paramInt)
          {
            localField1 = localField2;
            localObject1 = localField2;
            Hack.fail(new Hack.HackDeclaration.HackAssertionException(localField2 + " does not match modifiers: " + paramInt));
          }
        }
        localField1 = localField2;
        localObject1 = localField2;
        localField2.setAccessible(true);
        this.mField = localField2;
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localObject1 = localField1;
        Hack.HackDeclaration.HackAssertionException localHackAssertionException = new Hack.HackDeclaration.HackAssertionException(localNoSuchFieldException);
        localObject1 = localField1;
        localHackAssertionException.setHackedClass(paramClass);
        localObject1 = localField1;
        localHackAssertionException.setHackedFieldName(paramString);
        localObject1 = localField1;
        Hack.fail(localHackAssertionException);
        this.mField = localField1;
        return;
      }
      finally
      {
        this.mField = ((Field)localObject1);
      }
    }
    
    public T get()
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      try
      {
        if (this.mObject != null)
        {
          localObject1 = localObject2;
          if (this.mObject.get() != null) {
            localObject1 = this.mField.get(this.mObject.get());
          }
        }
        return (T)localObject1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      return null;
    }
    
    public Field getField()
    {
      return this.mField;
    }
    
    public void hijack(Interception.InterceptionHandler<?> paramInterceptionHandler)
    {
      Object localObject = get();
      if (localObject == null) {
        throw new IllegalStateException("Cannot hijack null");
      }
      set(Interception.proxy(localObject, paramInterceptionHandler, localObject.getClass().getInterfaces()));
    }
    
    public <T2> HackedField<C, T2> ofGenericType(Class<?> paramClass)
    {
      if ((this.mField != null) && (!paramClass.isAssignableFrom(this.mField.getType()))) {
        Hack.fail(new Hack.HackDeclaration.HackAssertionException(new ClassCastException(this.mField + " is not of type " + paramClass)));
      }
      return this;
    }
    
    public <T2> HackedField<C, T2> ofType(Class<T2> paramClass)
    {
      if ((this.mField != null) && (!paramClass.isAssignableFrom(this.mField.getType()))) {
        Hack.fail(new Hack.HackDeclaration.HackAssertionException(new ClassCastException(this.mField + " is not of type " + paramClass)));
      }
      return this;
    }
    
    public HackedField<C, T> ofType(String paramString)
    {
      try
      {
        paramString = ofType(Class.forName(paramString));
        return paramString;
      }
      catch (ClassNotFoundException paramString)
      {
        Hack.fail(new Hack.HackDeclaration.HackAssertionException(paramString));
      }
      return this;
    }
    
    public HackedField<C, T> on(C paramC)
    {
      this.mObject = new WeakReference(paramC);
      return this;
    }
    
    public void set(Object paramObject)
    {
      try
      {
        if ((this.mObject != null) && (this.mObject.get() != null)) {
          this.mField.set(this.mObject.get(), paramObject);
        }
        return;
      }
      catch (IllegalAccessException paramObject)
      {
        ((IllegalAccessException)paramObject).printStackTrace();
      }
    }
  }
  
  public static class HackedMethod
  {
    protected final Method mMethod;
    
    HackedMethod(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, int paramInt)
    {
      Object localObject = null;
      Class<?>[] arrayOfClass = null;
      if (paramClass == null)
      {
        this.mMethod = null;
        return;
      }
      try
      {
        paramArrayOfClass = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
        if (paramInt > 0)
        {
          arrayOfClass = paramArrayOfClass;
          localObject = paramArrayOfClass;
          if ((paramArrayOfClass.getModifiers() & paramInt) != paramInt)
          {
            arrayOfClass = paramArrayOfClass;
            localObject = paramArrayOfClass;
            Hack.fail(new Hack.HackDeclaration.HackAssertionException(paramArrayOfClass + " does not match modifiers: " + paramInt));
          }
        }
        arrayOfClass = paramArrayOfClass;
        localObject = paramArrayOfClass;
        paramArrayOfClass.setAccessible(true);
        this.mMethod = paramArrayOfClass;
        return;
      }
      catch (NoSuchMethodException paramArrayOfClass)
      {
        localObject = arrayOfClass;
        paramArrayOfClass = new Hack.HackDeclaration.HackAssertionException(paramArrayOfClass);
        localObject = arrayOfClass;
        paramArrayOfClass.setHackedClass(paramClass);
        localObject = arrayOfClass;
        paramArrayOfClass.setHackedMethodName(paramString);
        localObject = arrayOfClass;
        Hack.fail(paramArrayOfClass);
        this.mMethod = arrayOfClass;
        return;
      }
      finally
      {
        this.mMethod = ((Method)localObject);
      }
    }
    
    public Method getMethod()
    {
      return this.mMethod;
    }
    
    public Object invoke(Object paramObject, Object... paramVarArgs)
    {
      try
      {
        paramObject = this.mMethod.invoke(paramObject, paramVarArgs);
        return paramObject;
      }
      catch (IllegalAccessException paramObject)
      {
        ((IllegalAccessException)paramObject).printStackTrace();
      }
      return null;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\hack\Hack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */