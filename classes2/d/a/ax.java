package d.a;

import android.util.Log;
import java.util.Formatter;

public class ax
{
  public static boolean a = false;
  private static String b = "MobclickAgent";
  
  public static void a(String paramString)
  {
    a(b, paramString, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((!a) || ((paramThrowable != null) || (paramString2 == null))) {}
    try
    {
      Log.w(paramString1, "the msg is null!");
      return;
    }
    catch (Throwable paramString1) {}
    Log.d(paramString1, paramString2);
    return;
    if (paramString2 != null) {
      Log.d(paramString1, paramThrowable.toString() + ":  [" + paramString2 + "]");
    }
    for (;;)
    {
      paramString2 = paramThrowable.getStackTrace();
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        paramThrowable = paramString2[i];
        Log.d(paramString1, "        at  " + paramThrowable.toString());
        i += 1;
      }
      Log.d(paramString1, paramThrowable.toString());
    }
    return;
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    b(b, paramString, paramThrowable);
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    String str = "";
    try
    {
      if (paramString.contains("%"))
      {
        paramString = new Formatter().format(paramString, paramVarArgs).toString();
        b(b, paramString, null);
        return;
      }
      if (paramVarArgs != null) {
        str = (String)paramVarArgs[0];
      }
      b(paramString, str, null);
      return;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    d(b, null, paramThrowable);
  }
  
  public static void b(String paramString)
  {
    b(b, paramString, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((!a) || ((paramThrowable != null) || (paramString2 == null))) {}
    try
    {
      Log.w(paramString1, "the msg is null!");
      return;
    }
    catch (Throwable paramString1) {}
    Log.i(paramString1, paramString2);
    return;
    if (paramString2 != null) {
      Log.i(paramString1, paramThrowable.toString() + ":  [" + paramString2 + "]");
    }
    for (;;)
    {
      paramString2 = paramThrowable.getStackTrace();
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        paramThrowable = paramString2[i];
        Log.i(paramString1, "        at  " + paramThrowable.toString());
        i += 1;
      }
      Log.i(paramString1, paramThrowable.toString());
    }
    return;
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    d(b, paramString, paramThrowable);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    String str = "";
    try
    {
      if (paramString.contains("%"))
      {
        paramString = new Formatter().format(paramString, paramVarArgs).toString();
        d(b, paramString, null);
        return;
      }
      if (paramVarArgs != null) {
        str = (String)paramVarArgs[0];
      }
      d(paramString, str, null);
      return;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
  }
  
  public static void c(String paramString)
  {
    c(b, paramString, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((!a) || ((paramThrowable != null) || (paramString2 == null))) {}
    try
    {
      Log.w(paramString1, "the msg is null!");
      return;
    }
    catch (Throwable paramString1) {}
    Log.w(paramString1, paramString2);
    return;
    if (paramString2 != null) {
      Log.w(paramString1, paramThrowable.toString() + ":  [" + paramString2 + "]");
    }
    for (;;)
    {
      paramString2 = paramThrowable.getStackTrace();
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        paramThrowable = paramString2[i];
        Log.w(paramString1, "        at  " + paramThrowable.toString());
        i += 1;
      }
      Log.w(paramString1, paramThrowable.toString());
    }
    return;
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    String str = "";
    try
    {
      if (paramString.contains("%"))
      {
        paramString = new Formatter().format(paramString, paramVarArgs).toString();
        c(b, paramString, null);
        return;
      }
      if (paramVarArgs != null) {
        str = (String)paramVarArgs[0];
      }
      c(paramString, str, null);
      return;
    }
    catch (Throwable paramString)
    {
      a(paramString);
    }
  }
  
  public static void d(String paramString)
  {
    d(b, paramString, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((!a) || ((paramThrowable != null) || (paramString2 == null))) {}
    try
    {
      Log.w(paramString1, "the msg is null!");
      return;
    }
    catch (Throwable paramString1) {}
    Log.e(paramString1, paramString2);
    return;
    if (paramString2 != null) {
      Log.e(paramString1, paramThrowable.toString() + ":  [" + paramString2 + "]");
    }
    for (;;)
    {
      paramString2 = paramThrowable.getStackTrace();
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        paramThrowable = paramString2[i];
        Log.e(paramString1, "        at  " + paramThrowable.toString());
        i += 1;
      }
      Log.e(paramString1, paramThrowable.toString());
    }
    return;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */