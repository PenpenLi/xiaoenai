package a.a.a;

import android.util.Log;

public class e
{
  public static int a(String paramString)
  {
    return Log.d("greenDAO", paramString);
  }
  
  public static int a(String paramString, Throwable paramThrowable)
  {
    return Log.i("greenDAO", paramString, paramThrowable);
  }
  
  public static int b(String paramString)
  {
    return Log.i("greenDAO", paramString);
  }
  
  public static int b(String paramString, Throwable paramThrowable)
  {
    return Log.w("greenDAO", paramString, paramThrowable);
  }
  
  public static int c(String paramString)
  {
    return Log.w("greenDAO", paramString);
  }
  
  public static int c(String paramString, Throwable paramThrowable)
  {
    return Log.e("greenDAO", paramString, paramThrowable);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */