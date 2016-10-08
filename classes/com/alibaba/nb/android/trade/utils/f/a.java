package com.alibaba.nb.android.trade.utils.f;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static final Map<String, Class<?>> a = new HashMap();
  private static final Map<String, Class<?>> b = new HashMap();
  private static final Map<String, Method> c = new HashMap();
  private static final Map<String, Field> d = new HashMap();
  private static final String e = a.class.getSimpleName();
  
  static
  {
    a.put("short", Short.TYPE);
    a.put("int", Integer.TYPE);
    a.put("long", Long.TYPE);
    a.put("double", Double.TYPE);
    a.put("float", Float.TYPE);
    a.put("char", Character.TYPE);
  }
  
  public static Class<?> a(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public static <T> T a(Class<T> paramClass, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    if (paramArrayOfClass != null) {}
    StringBuilder localStringBuilder;
    try
    {
      if (paramArrayOfClass.length == 0) {
        return (T)paramClass.newInstance();
      }
      paramArrayOfClass = paramClass.getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
      return paramArrayOfClass;
    }
    catch (Exception paramArrayOfClass)
    {
      paramArrayOfObject = e;
      localStringBuilder = new StringBuilder("Fail to create the instance of type ");
      if (paramClass == null) {}
    }
    for (paramClass = paramClass.getName();; paramClass = null)
    {
      com.alibaba.nb.android.trade.utils.d.a.d(paramArrayOfObject, paramClass + ", the error is " + paramArrayOfClass.getMessage());
      return null;
    }
  }
  
  public static Object a(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return null;
    }
    String str = paramObject.getClass().getName() + paramString;
    try
    {
      Field localField = (Field)d.get(str);
      Object localObject = localField;
      if (localField == null)
      {
        localObject = paramObject.getClass().getDeclaredField(paramString);
        ((Field)localObject).setAccessible(true);
        d.put(str, localObject);
      }
      localObject = ((Field)localObject).get(paramObject);
      return localObject;
    }
    catch (Exception localException) {}
    return a(paramObject.getClass().getSuperclass(), paramString);
  }
  
  public static Object a(String paramString1, String paramString2, String[] paramArrayOfString, Object paramObject, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject2 = (Class)b.get(paramString1);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = Class.forName(paramString1);
        b.put(paramString1, localObject1);
      }
      localObject2 = new StringBuffer();
      if (paramArrayOfString != null)
      {
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          ((StringBuffer)localObject2).append(paramArrayOfString[i]);
          i += 1;
        }
      }
      localObject2 = paramString1 + paramString2 + ((StringBuffer)localObject2).toString();
      Method localMethod = (Method)c.get(localObject2);
      if (localMethod == null)
      {
        if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
        for (paramArrayOfString = ((Class)localObject1).getMethod(paramString2, new Class[0]); paramArrayOfString != null; paramArrayOfString = ((Class)localObject1).getMethod(paramString2, a(paramArrayOfString)))
        {
          c.put(localObject2, paramArrayOfString);
          return paramArrayOfString.invoke(paramObject, paramArrayOfObject);
        }
      }
      paramArrayOfString = localMethod.invoke(paramObject, paramArrayOfObject);
      return paramArrayOfString;
    }
    catch (Exception paramArrayOfString)
    {
      com.alibaba.nb.android.trade.utils.d.a.d(e, "Fail to invoke the " + paramString1 + "." + paramString2 + ", the error is " + paramArrayOfString.getMessage());
    }
    return null;
  }
  
  public static Object a(String paramString, String[] paramArrayOfString, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfString = a(Class.forName(paramString), a(paramArrayOfString), paramArrayOfObject);
      return paramArrayOfString;
    }
    catch (RuntimeException paramString)
    {
      throw paramString;
    }
    catch (Exception paramArrayOfString)
    {
      com.alibaba.nb.android.trade.utils.d.a.d(e, "Fail to create the instance of type " + paramString + ", the error is " + paramArrayOfString.getMessage());
    }
    return null;
  }
  
  public static Field a(Class<?> paramClass, String paramString)
  {
    for (;;)
    {
      Object localObject;
      if (paramClass == null) {
        localObject = null;
      }
      for (;;)
      {
        return (Field)localObject;
        try
        {
          String str = paramClass.getName() + paramString;
          Field localField = (Field)d.get(str);
          localObject = localField;
          if (localField == null)
          {
            localObject = paramClass.getDeclaredField(paramString);
            ((Field)localObject).setAccessible(true);
            d.put(str, localObject);
            return (Field)localObject;
          }
        }
        catch (Exception localException)
        {
          paramClass = paramClass.getSuperclass();
        }
      }
    }
  }
  
  public static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    for (;;)
    {
      Object localObject;
      if (paramClass == null) {
        localObject = null;
      }
      for (;;)
      {
        return (Method)localObject;
        try
        {
          localObject = new StringBuffer();
          if (paramVarArgs.length > 0)
          {
            int j = paramVarArgs.length;
            int i = 0;
            while (i < j)
            {
              ((StringBuffer)localObject).append(paramVarArgs[i].getName());
              i += 1;
            }
          }
          String str = paramClass.getName() + paramString + ((StringBuffer)localObject).toString();
          Method localMethod = (Method)c.get(str);
          localObject = localMethod;
          if (localMethod == null)
          {
            paramVarArgs = paramClass.getDeclaredMethod(paramString, paramVarArgs);
            paramVarArgs.setAccessible(true);
            c.put(str, paramVarArgs);
            return paramVarArgs;
          }
        }
        catch (Exception paramVarArgs)
        {
          paramClass = paramClass.getSuperclass();
          paramVarArgs = new Class[0];
        }
      }
    }
  }
  
  public static void a(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      Object localObject = paramObject1.getClass().getName() + paramString;
      Field localField = (Field)d.get(localObject);
      localObject = localField;
      if (localField == null)
      {
        localObject = paramObject1.getClass().getField(paramString);
        ((Field)localObject).setAccessible(true);
        d.put(paramObject1.getClass().getName() + paramString, localObject);
      }
      ((Field)localObject).set(paramObject1, paramObject2);
      return;
    }
    catch (NoSuchFieldException paramObject1)
    {
      ((NoSuchFieldException)paramObject1).printStackTrace();
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      ((IllegalAccessException)paramObject1).printStackTrace();
    }
  }
  
  private static Class<?>[] a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    Class[] arrayOfClass = new Class[paramArrayOfString.length];
    int j = paramArrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = paramArrayOfString[i];
      if (str.length() < 7) {
        arrayOfClass[i] = ((Class)a.get(str));
      }
      if (arrayOfClass[i] == null)
      {
        if (!"boolean".equals(str)) {
          break label80;
        }
        arrayOfClass[i] = Boolean.TYPE;
      }
      for (;;)
      {
        i += 1;
        break;
        label80:
        arrayOfClass[i] = Class.forName(str);
      }
    }
    return arrayOfClass;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */