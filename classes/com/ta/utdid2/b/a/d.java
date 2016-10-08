package com.ta.utdid2.b.a;

import java.lang.reflect.Method;

public class d
{
  private static Class<?> jdField_a_of_type_JavaLangClass;
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static Method b;
  public static boolean e;
  
  static
  {
    boolean bool = true;
    if (getInt("alidebug", 0) == 1) {}
    for (;;)
    {
      e = bool;
      jdField_a_of_type_JavaLangClass = null;
      jdField_a_of_type_JavaLangReflectMethod = null;
      b = null;
      return;
      bool = false;
    }
  }
  
  private static void a()
  {
    try
    {
      if (jdField_a_of_type_JavaLangClass == null)
      {
        jdField_a_of_type_JavaLangClass = Class.forName("android.os.SystemProperties");
        jdField_a_of_type_JavaLangReflectMethod = jdField_a_of_type_JavaLangClass.getDeclaredMethod("get", new Class[] { String.class });
        b = jdField_a_of_type_JavaLangClass.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE });
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    
    try
    {
      int i = ((Integer)b.invoke(jdField_a_of_type_JavaLangClass, new Object[] { paramString, Integer.valueOf(paramInt) })).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\b\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */