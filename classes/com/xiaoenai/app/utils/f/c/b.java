package com.xiaoenai.app.utils.f.c;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class b
{
  public static final a a(String paramString, Object[] paramArrayOfObject)
  {
    int j = 0;
    Throwable localThrowable = a(paramArrayOfObject);
    if (paramString == null) {
      return new a(null, paramArrayOfObject, localThrowable);
    }
    if (paramArrayOfObject == null) {
      return new a(paramString);
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString.length() + 50);
    int i = 0;
    if (j < paramArrayOfObject.length)
    {
      int k = paramString.indexOf("{}", i);
      if (k == -1)
      {
        if (i == 0) {
          return new a(paramString, paramArrayOfObject, localThrowable);
        }
        localStringBuffer.append(paramString.substring(i, paramString.length()));
        return new a(localStringBuffer.toString(), paramArrayOfObject, localThrowable);
      }
      if (a(paramString, k)) {
        if (!b(paramString, k))
        {
          j -= 1;
          localStringBuffer.append(paramString.substring(i, k - 1));
          localStringBuffer.append('{');
          i = k + 1;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuffer.append(paramString.substring(i, k - 1));
        a(localStringBuffer, paramArrayOfObject[j], new HashMap());
        i = k + 2;
        continue;
        localStringBuffer.append(paramString.substring(i, k));
        a(localStringBuffer, paramArrayOfObject[j], new HashMap());
        i = k + 2;
      }
    }
    localStringBuffer.append(paramString.substring(i, paramString.length()));
    if (j < paramArrayOfObject.length - 1) {
      return new a(localStringBuffer.toString(), paramArrayOfObject, localThrowable);
    }
    return new a(localStringBuffer.toString(), paramArrayOfObject, null);
  }
  
  static final Throwable a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
      return null;
    }
    paramArrayOfObject = paramArrayOfObject[(paramArrayOfObject.length - 1)];
    if ((paramArrayOfObject instanceof Throwable)) {
      return (Throwable)paramArrayOfObject;
    }
    return null;
  }
  
  private static void a(StringBuffer paramStringBuffer, Object paramObject)
  {
    try
    {
      paramStringBuffer.append(paramObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      System.err.println("SLF4J: Failed toString() invocation on an object of type [" + paramObject.getClass().getName() + "]");
      localThrowable.printStackTrace();
      paramStringBuffer.append("[FAILED toString()]");
    }
  }
  
  private static void a(StringBuffer paramStringBuffer, Object paramObject, Map paramMap)
  {
    if (paramObject == null)
    {
      paramStringBuffer.append("null");
      return;
    }
    if (!paramObject.getClass().isArray())
    {
      a(paramStringBuffer, paramObject);
      return;
    }
    if ((paramObject instanceof boolean[]))
    {
      a(paramStringBuffer, (boolean[])paramObject);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      a(paramStringBuffer, (byte[])paramObject);
      return;
    }
    if ((paramObject instanceof char[]))
    {
      a(paramStringBuffer, (char[])paramObject);
      return;
    }
    if ((paramObject instanceof short[]))
    {
      a(paramStringBuffer, (short[])paramObject);
      return;
    }
    if ((paramObject instanceof int[]))
    {
      a(paramStringBuffer, (int[])paramObject);
      return;
    }
    if ((paramObject instanceof long[]))
    {
      a(paramStringBuffer, (long[])paramObject);
      return;
    }
    if ((paramObject instanceof float[]))
    {
      a(paramStringBuffer, (float[])paramObject);
      return;
    }
    if ((paramObject instanceof double[]))
    {
      a(paramStringBuffer, (double[])paramObject);
      return;
    }
    a(paramStringBuffer, (Object[])paramObject, paramMap);
  }
  
  private static void a(StringBuffer paramStringBuffer, byte[] paramArrayOfByte)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfByte[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  private static void a(StringBuffer paramStringBuffer, char[] paramArrayOfChar)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfChar[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  private static void a(StringBuffer paramStringBuffer, double[] paramArrayOfDouble)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfDouble[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  private static void a(StringBuffer paramStringBuffer, float[] paramArrayOfFloat)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfFloat[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  private static void a(StringBuffer paramStringBuffer, int[] paramArrayOfInt)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfInt[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  private static void a(StringBuffer paramStringBuffer, long[] paramArrayOfLong)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfLong[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  private static void a(StringBuffer paramStringBuffer, Object[] paramArrayOfObject, Map paramMap)
  {
    paramStringBuffer.append('[');
    if (!paramMap.containsKey(paramArrayOfObject))
    {
      paramMap.put(paramArrayOfObject, null);
      int j = paramArrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        a(paramStringBuffer, paramArrayOfObject[i], paramMap);
        if (i != j - 1) {
          paramStringBuffer.append(", ");
        }
        i += 1;
      }
      paramMap.remove(paramArrayOfObject);
    }
    for (;;)
    {
      paramStringBuffer.append(']');
      return;
      paramStringBuffer.append("...");
    }
  }
  
  private static void a(StringBuffer paramStringBuffer, short[] paramArrayOfShort)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfShort[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  private static void a(StringBuffer paramStringBuffer, boolean[] paramArrayOfBoolean)
  {
    paramStringBuffer.append('[');
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuffer.append(paramArrayOfBoolean[i]);
      if (i != j - 1) {
        paramStringBuffer.append(", ");
      }
      i += 1;
    }
    paramStringBuffer.append(']');
  }
  
  static final boolean a(String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    while (paramString.charAt(paramInt - 1) != '\\') {
      return false;
    }
    return true;
  }
  
  static final boolean b(String paramString, int paramInt)
  {
    return (paramInt >= 2) && (paramString.charAt(paramInt - 2) == '\\');
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\f\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */