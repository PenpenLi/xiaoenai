package com.adhoc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class fn
{
  public static Class a(Class paramClass, String paramString)
  {
    Class localClass;
    if (paramClass == null) {
      localClass = null;
    }
    do
    {
      return localClass;
      localClass = paramClass;
    } while (paramClass.getSimpleName().equals(paramString));
    return a(paramClass.getSuperclass(), paramString);
  }
  
  public static Object a(Field paramField, Object paramObject)
  {
    if (paramField != null) {
      a(paramField);
    }
    if (paramField != null) {
      return paramField.get(paramObject);
    }
    return null;
  }
  
  public static Field a(Class paramClass, String paramString1, String paramString2)
  {
    paramClass = a(paramClass, paramString2);
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredField(paramString1);
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      fl.a(paramClass);
    }
    return null;
  }
  
  public static void a(Field paramField)
  {
    if ((!Modifier.isPublic(paramField.getModifiers())) || (!Modifier.isPublic(paramField.getDeclaringClass().getModifiers()))) {
      paramField.setAccessible(true);
    }
  }
  
  public static Method b(Class paramClass, String paramString1, String paramString2)
  {
    paramClass = a(paramClass, paramString2);
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString1, new Class[0]);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      fl.a(paramClass);
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\fn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */