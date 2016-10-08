package com.marshalchen.ultimaterecyclerview;

import android.util.Log;

public final class k
{
  private static boolean a = true;
  private static String b = "Chen";
  
  private static StackTraceElement a()
  {
    return Thread.currentThread().getStackTrace()[4];
  }
  
  private static String a(StackTraceElement paramStackTraceElement)
  {
    return String.format("%s:%s.%s:%d", new Object[] { b, paramStackTraceElement.getClassName(), paramStackTraceElement.getMethodName(), Integer.valueOf(paramStackTraceElement.getLineNumber()) });
  }
  
  public static void a(Exception paramException, String paramString)
  {
    if (a)
    {
      Log.e(b, a(a()) + "\n>" + paramException.getMessage() + "\n>" + paramException.getStackTrace() + "   " + paramString);
      paramException.printStackTrace();
    }
  }
  
  public static void a(String paramString)
  {
    if (a) {
      Log.d(b, b(a()) + ">" + paramString);
    }
  }
  
  private static String b(StackTraceElement paramStackTraceElement)
  {
    return String.format("%s:%s:%d", new Object[] { b, paramStackTraceElement.getMethodName(), Integer.valueOf(paramStackTraceElement.getLineNumber()) });
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\marshalchen\ultimaterecyclerview\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */