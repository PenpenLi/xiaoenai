package com.alibaba.sdk.android.util;

import com.alibaba.sdk.android.trace.AliSDKLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtils
{
  private static final Map<String, Class<?>> PRIMITIVE_CLASSES = new HashMap();
  private static final String TAG = ReflectionUtils.class.getSimpleName();
  
  static
  {
    PRIMITIVE_CLASSES.put("short", Short.TYPE);
    PRIMITIVE_CLASSES.put("int", Integer.TYPE);
    PRIMITIVE_CLASSES.put("long", Long.TYPE);
    PRIMITIVE_CLASSES.put("double", Double.TYPE);
    PRIMITIVE_CLASSES.put("float", Float.TYPE);
    PRIMITIVE_CLASSES.put("char", Character.TYPE);
  }
  
  public static Field getField(Class<?> paramClass, String paramString)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      localField.setAccessible(true);
      return localField;
    }
    catch (Exception localException) {}
    return getField(paramClass.getSuperclass(), paramString);
  }
  
  public static Method getMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramVarArgs = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      paramVarArgs.setAccessible(true);
      return paramVarArgs;
    }
    catch (Exception paramVarArgs) {}
    return getMethod(paramClass.getSuperclass(), paramString, new Class[0]);
  }
  
  /* Error */
  public static Object invoke(String paramString1, String paramString2, String[] paramArrayOfString, Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 107	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   4: astore 5
    //   6: aload_2
    //   7: ifnull +8 -> 15
    //   10: aload_2
    //   11: arraylength
    //   12: ifne +22 -> 34
    //   15: aload 5
    //   17: aload_1
    //   18: iconst_0
    //   19: anewarray 20	java/lang/Class
    //   22: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   25: astore_2
    //   26: aload_2
    //   27: aload_3
    //   28: aload 4
    //   30: invokevirtual 112	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   33: areturn
    //   34: aload 5
    //   36: aload_1
    //   37: aload_2
    //   38: invokestatic 116	com/alibaba/sdk/android/util/ReflectionUtils:toClasses	([Ljava/lang/String;)[Ljava/lang/Class;
    //   41: invokevirtual 109	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   44: astore_2
    //   45: goto -19 -> 26
    //   48: astore_2
    //   49: getstatic 26	com/alibaba/sdk/android/util/ReflectionUtils:TAG	Ljava/lang/String;
    //   52: new 118	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   59: ldc 121
    //   61: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 127
    //   70: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc -127
    //   79: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_2
    //   83: invokevirtual 132	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   86: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 141	com/alibaba/sdk/android/trace/AliSDKLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: new 143	java/lang/RuntimeException
    //   98: dup
    //   99: aload_2
    //   100: invokespecial 146	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramString1	String
    //   0	104	1	paramString2	String
    //   0	104	2	paramArrayOfString	String[]
    //   0	104	3	paramObject	Object
    //   0	104	4	paramArrayOfObject	Object[]
    //   4	31	5	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   0	6	48	java/lang/Exception
    //   10	15	48	java/lang/Exception
    //   15	26	48	java/lang/Exception
    //   26	34	48	java/lang/Exception
    //   34	45	48	java/lang/Exception
  }
  
  public static Class<?> loadClassQuietly(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public static <T> T newInstance(Class<T> paramClass, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    if (paramArrayOfClass != null) {}
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
      AliSDKLogger.e(TAG, "Fail to create the instance of type " + paramClass.getName() + ", the error is " + paramArrayOfClass.getMessage());
      throw new RuntimeException(paramArrayOfClass);
    }
  }
  
  public static Object newInstance(String paramString, String[] paramArrayOfString, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfString = newInstance(Class.forName(paramString), toClasses(paramArrayOfString), paramArrayOfObject);
      return paramArrayOfString;
    }
    catch (RuntimeException paramString)
    {
      throw paramString;
    }
    catch (Exception paramArrayOfString)
    {
      AliSDKLogger.e(TAG, "Fail to create the instance of type " + paramString + ", the error is " + paramArrayOfString.getMessage());
      throw new RuntimeException(paramArrayOfString);
    }
  }
  
  public static void set(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      paramString = paramObject1.getClass().getField(paramString);
      paramString.setAccessible(true);
      paramString.set(paramObject1, paramObject2);
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
  
  public static Class<?>[] toClasses(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    Class[] arrayOfClass = new Class[paramArrayOfString.length];
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (str.length() < 7) {
        arrayOfClass[i] = ((Class)PRIMITIVE_CLASSES.get(str));
      }
      if (arrayOfClass[i] == null) {
        arrayOfClass[i] = Class.forName(str);
      }
      i += 1;
    }
    return arrayOfClass;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\ReflectionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */