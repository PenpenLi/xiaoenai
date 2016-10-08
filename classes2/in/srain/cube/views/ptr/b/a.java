package in.srain.cube.views.ptr.b;

import android.util.Log;

public class a
{
  private static int a = 0;
  
  public static void a(String paramString1, String paramString2)
  {
    if (a > 1) {
      return;
    }
    Log.d(paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a > 0) {
      return;
    }
    String str = paramString2;
    if (paramVarArgs.length > 0) {
      str = String.format(paramString2, paramVarArgs);
    }
    Log.v(paramString1, str);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a > 2) {
      return;
    }
    Log.i(paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a > 1) {
      return;
    }
    String str = paramString2;
    if (paramVarArgs.length > 0) {
      str = String.format(paramString2, paramVarArgs);
    }
    Log.d(paramString1, str);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a > 4) {
      return;
    }
    Log.e(paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a > 2) {
      return;
    }
    String str = paramString2;
    if (paramVarArgs.length > 0) {
      str = String.format(paramString2, paramVarArgs);
    }
    Log.i(paramString1, str);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\in\srain\cube\views\ptr\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */