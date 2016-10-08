package com.adhoc;

import android.util.Log;
import java.io.PrintStream;

public class fl
{
  static String a = "ADHOC_SDK";
  public static final Boolean b = Boolean.valueOf(false);
  
  public static void a(Exception paramException)
  {
    if ((paramException == null) || (paramException.toString() == null)) {
      return;
    }
    if (b.booleanValue())
    {
      if (paramException != null) {
        paramException.printStackTrace();
      }
      Log.e(a, paramException.toString());
      return;
    }
    System.err.println(paramException.toString());
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {}
    while (!b.booleanValue()) {
      return;
    }
    Log.i(a, paramString);
  }
  
  public static void a(Throwable paramThrowable)
  {
    if ((paramThrowable == null) || (paramThrowable.toString() == null)) {
      return;
    }
    if (b.booleanValue())
    {
      paramThrowable.printStackTrace();
      Log.e(a, paramThrowable.toString());
      return;
    }
    System.err.println(paramThrowable.toString());
  }
  
  public static void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (b.booleanValue())
    {
      Log.e(a, paramString);
      return;
    }
    System.err.println(paramString);
  }
  
  public static void c(String paramString)
  {
    if (paramString == null) {}
    while (!b.booleanValue()) {
      return;
    }
    Log.d(a, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\fl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */