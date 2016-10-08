package com.mob.tools.b;

import com.mob.tools.gui.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class h
{
  private static HashSet<String> a = new HashSet();
  private static HashMap<String, Class<?>> b = new HashMap();
  private static d<String, Method> c = new d(25);
  private static d<String, Constructor<?>> d = new d(5);
  
  static
  {
    a.add("java.lang");
    a.add("java.io");
    a.add("java.net");
    a.add("java.util");
    a.add("com.mob.tools");
    a.add("com.mob.tools.gui");
    a.add("com.mob.tools.log");
    a.add("com.mob.tools.network");
    a.add("com.mob.tools.utils");
  }
  
  public static <T> T a(Object paramObject, String paramString)
  {
    try
    {
      Object localObject = b(paramObject, paramString);
      return (T)localObject;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof NoSuchFieldException)) {
        throw localThrowable;
      }
      throw new Throwable("className: " + paramObject.getClass() + ", fieldName: " + paramString, localThrowable);
    }
  }
  
  public static <T> T a(Object paramObject, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramVarArgs = b(paramObject, paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (Throwable paramVarArgs)
    {
      if ((paramVarArgs instanceof NoSuchMethodException)) {
        throw paramVarArgs;
      }
      throw new Throwable("className: " + paramObject.getClass() + ", methodName: " + paramString, paramVarArgs);
    }
  }
  
  public static Object a(String paramString, Object... paramVarArgs)
  {
    try
    {
      paramVarArgs = b(paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (Throwable paramVarArgs)
    {
      if ((paramVarArgs instanceof NoSuchMethodException)) {
        throw paramVarArgs;
      }
      throw new Throwable("className: " + paramString + ", methodName: <init>", paramVarArgs);
    }
  }
  
  public static String a(String paramString)
  {
    return a(null, paramString);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      if (paramString2.endsWith(".*"))
      {
        a.add(paramString2.substring(0, paramString2.length() - 2));
        paramString1 = "*";
        return paramString1;
      }
      paramString2 = Class.forName(paramString2);
      if (paramString1 == null) {
        paramString1 = paramString2.getSimpleName();
      }
      for (;;)
      {
        b.put(paramString1, paramString2);
        break;
      }
    }
    finally {}
  }
  
  public static void a(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      b(paramObject1, paramString, paramObject2);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof NoSuchFieldException)) {
        throw localThrowable;
      }
      throw new Throwable("className: " + paramObject1.getClass() + ", fieldName: " + paramString + ", value: " + String.valueOf(paramObject2), localThrowable);
    }
  }
  
  public static void a(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      b(paramString1, paramString2, paramObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof NoSuchFieldException)) {
        throw localThrowable;
      }
      throw new Throwable("className: " + paramString1 + ", fieldName: " + paramString2 + ", value: " + String.valueOf(paramObject), localThrowable);
    }
  }
  
  private static boolean a(Class<?> paramClass1, Class<?> paramClass2)
  {
    return ((paramClass1 == Byte.TYPE) && (paramClass2 == Byte.class)) || ((paramClass1 == Short.TYPE) && (paramClass2 == Short.class)) || ((paramClass1 == Character.TYPE) && (paramClass2 == Character.class)) || ((paramClass1 == Integer.TYPE) && (paramClass2 == Integer.class)) || ((paramClass1 == Long.TYPE) && (paramClass2 == Long.class)) || ((paramClass1 == Float.TYPE) && (paramClass2 == Float.class)) || ((paramClass1 == Double.TYPE) && (paramClass2 == Double.class)) || ((paramClass1 == Boolean.TYPE) && (paramClass2 == Boolean.class));
  }
  
  private static boolean a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    int i;
    if (paramArrayOfClass1.length == paramArrayOfClass2.length) {
      i = 0;
    }
    while (i < paramArrayOfClass1.length)
    {
      if ((paramArrayOfClass2[i] != null) && (!a(paramArrayOfClass1[i], paramArrayOfClass2[i])) && (!paramArrayOfClass1[i].isAssignableFrom(paramArrayOfClass2[i]))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static Class<?>[] a(Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass = new Class[paramArrayOfObject.length];
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      if (paramArrayOfObject[i] == null) {}
      for (Class localClass = null;; localClass = paramArrayOfObject[i].getClass())
      {
        arrayOfClass[i] = localClass;
        i += 1;
        break;
      }
    }
    return arrayOfClass;
  }
  
  /* Error */
  private static Class<?> b(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 51	com/mob/tools/b/h:b	Ljava/util/HashMap;
    //   6: aload_0
    //   7: invokevirtual 198	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 132	java/lang/Class
    //   13: astore_2
    //   14: aload_2
    //   15: astore_1
    //   16: aload_2
    //   17: ifnonnull +77 -> 94
    //   20: getstatic 24	com/mob/tools/b/h:a	Ljava/util/HashSet;
    //   23: invokevirtual 202	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   26: astore_3
    //   27: aload_2
    //   28: astore_1
    //   29: aload_3
    //   30: invokeinterface 208 1 0
    //   35: ifeq +59 -> 94
    //   38: aload_3
    //   39: invokeinterface 212 1 0
    //   44: checkcast 116	java/lang/String
    //   47: astore_1
    //   48: new 70	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   55: aload_1
    //   56: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc -42
    //   61: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 216	com/mob/tools/b/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   74: pop
    //   75: getstatic 51	com/mob/tools/b/h:b	Ljava/util/HashMap;
    //   78: aload_0
    //   79: invokevirtual 198	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: checkcast 132	java/lang/Class
    //   85: astore_2
    //   86: aload_2
    //   87: astore_1
    //   88: aload_2
    //   89: ifnull -60 -> 29
    //   92: aload_2
    //   93: astore_1
    //   94: ldc 2
    //   96: monitorexit
    //   97: aload_1
    //   98: areturn
    //   99: astore_0
    //   100: ldc 2
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    //   105: astore_1
    //   106: goto -31 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramString	String
    //   15	83	1	localObject	Object
    //   105	1	1	localThrowable	Throwable
    //   13	80	2	localClass	Class
    //   26	13	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   3	14	99	finally
    //   20	27	99	finally
    //   29	48	99	finally
    //   48	75	99	finally
    //   75	86	99	finally
    //   48	75	105	java/lang/Throwable
  }
  
  public static <T> T b(Object paramObject, String paramString)
  {
    Object localObject3 = new ArrayList();
    for (Object localObject1 = paramObject.getClass(); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      ((ArrayList)localObject3).add(localObject1);
    }
    localObject3 = ((ArrayList)localObject3).iterator();
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (Class)((Iterator)localObject3).next();
        try
        {
          localObject1 = ((Class)localObject1).getDeclaredField(paramString);
          if ((localObject1 != null) && (!Modifier.isStatic(((Field)localObject1).getModifiers())))
          {
            ((Field)localObject1).setAccessible(true);
            return (T)((Field)localObject1).get(paramObject);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
      }
    }
    throw new NoSuchFieldException("className: " + paramObject.getClass() + ", fieldName: " + paramString);
  }
  
  private static <T> T b(Object paramObject, String paramString, Object... paramVarArgs)
  {
    Object localObject1 = paramObject.getClass();
    String str = ((Class)localObject1).getName() + "#" + paramString + "#" + paramVarArgs.length;
    Object localObject2 = (Method)c.a(str);
    Class[] arrayOfClass = a(paramVarArgs);
    if ((localObject2 != null) && (!Modifier.isStatic(((Method)localObject2).getModifiers())) && (a(((Method)localObject2).getParameterTypes(), arrayOfClass)))
    {
      ((Method)localObject2).setAccessible(true);
      if (((Method)localObject2).getReturnType() == Void.TYPE)
      {
        ((Method)localObject2).invoke(paramObject, paramVarArgs);
        return null;
      }
      return (T)((Method)localObject2).invoke(paramObject, paramVarArgs);
    }
    localObject2 = new ArrayList();
    while (localObject1 != null)
    {
      ((ArrayList)localObject2).add(localObject1);
      localObject1 = ((Class)localObject1).getSuperclass();
    }
    localObject1 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Class)((Iterator)localObject1).next()).getDeclaredMethods();
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        if ((((Method)localObject3).getName().equals(paramString)) && (!Modifier.isStatic(((Method)localObject3).getModifiers())) && (a(((Method)localObject3).getParameterTypes(), arrayOfClass)))
        {
          c.a(str, localObject3);
          ((Method)localObject3).setAccessible(true);
          if (((Method)localObject3).getReturnType() == Void.TYPE)
          {
            ((Method)localObject3).invoke(paramObject, paramVarArgs);
            return null;
          }
          return (T)((Method)localObject3).invoke(paramObject, paramVarArgs);
        }
        i += 1;
      }
    }
    throw new NoSuchMethodException("className: " + paramObject.getClass() + ", methodName: " + paramString);
  }
  
  public static <T> T b(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = c(paramString1, paramString2);
      return (T)localObject;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof NoSuchFieldException)) {
        throw localThrowable;
      }
      throw new Throwable("className: " + paramString1 + ", fieldName: " + paramString2, localThrowable);
    }
  }
  
  private static Object b(String paramString, Object... paramVarArgs)
  {
    String str = paramString + "#" + paramVarArgs.length;
    Object localObject1 = (Constructor)d.a(str);
    Class[] arrayOfClass = a(paramVarArgs);
    if ((localObject1 != null) && (a(((Constructor)localObject1).getParameterTypes(), arrayOfClass)))
    {
      ((Constructor)localObject1).setAccessible(true);
      return ((Constructor)localObject1).newInstance(paramVarArgs);
    }
    localObject1 = b(paramString).getDeclaredConstructors();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (a(((Constructor)localObject2).getParameterTypes(), arrayOfClass))
      {
        d.a(str, localObject2);
        ((Constructor)localObject2).setAccessible(true);
        return ((Constructor)localObject2).newInstance(paramVarArgs);
      }
      i += 1;
    }
    throw new NoSuchMethodException("className: " + paramString + ", methodName: <init>");
  }
  
  private static void b(Object paramObject1, String paramString, Object paramObject2)
  {
    Object localObject3 = new ArrayList();
    for (Object localObject1 = paramObject1.getClass(); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      ((ArrayList)localObject3).add(localObject1);
    }
    localObject3 = ((ArrayList)localObject3).iterator();
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (Class)((Iterator)localObject3).next();
        try
        {
          localObject1 = ((Class)localObject1).getDeclaredField(paramString);
          if ((localObject1 != null) && (!Modifier.isStatic(((Field)localObject1).getModifiers())))
          {
            ((Field)localObject1).setAccessible(true);
            ((Field)localObject1).set(paramObject1, paramObject2);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
      }
    }
    throw new NoSuchFieldException("className: " + paramObject1.getClass() + ", fieldName: " + paramString + ", value: " + String.valueOf(paramObject2));
  }
  
  private static void b(String paramString1, String paramString2, Object paramObject)
  {
    Object localObject3 = new ArrayList();
    for (Object localObject1 = b(paramString1); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      ((ArrayList)localObject3).add(localObject1);
    }
    localObject3 = ((ArrayList)localObject3).iterator();
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (Class)((Iterator)localObject3).next();
        try
        {
          localObject1 = ((Class)localObject1).getDeclaredField(paramString2);
          if ((localObject1 != null) && (Modifier.isStatic(((Field)localObject1).getModifiers())))
          {
            ((Field)localObject1).setAccessible(true);
            ((Field)localObject1).set(null, paramObject);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
      }
    }
    throw new NoSuchFieldException("className: " + paramString1 + ", fieldName: " + paramString2 + ", value: " + String.valueOf(paramObject));
  }
  
  private static <T> T c(String paramString1, String paramString2)
  {
    Object localObject3 = new ArrayList();
    for (Object localObject1 = b(paramString1); localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass()) {
      ((ArrayList)localObject3).add(localObject1);
    }
    localObject3 = ((ArrayList)localObject3).iterator();
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (Class)((Iterator)localObject3).next();
        try
        {
          localObject1 = ((Class)localObject1).getDeclaredField(paramString2);
          if ((localObject1 != null) && (Modifier.isStatic(((Field)localObject1).getModifiers())))
          {
            ((Field)localObject1).setAccessible(true);
            return (T)((Field)localObject1).get(null);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject2 = null;
          }
        }
      }
    }
    throw new NoSuchFieldException("className: " + paramString1 + ", fieldName: " + paramString2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */