package rx.c.c;

import java.security.AccessController;

public final class c
{
  private static final boolean a = ;
  
  public static boolean a()
  {
    return a;
  }
  
  static ClassLoader b()
  {
    if (System.getSecurityManager() == null) {
      return ClassLoader.getSystemClassLoader();
    }
    return (ClassLoader)AccessController.doPrivileged(new d());
  }
  
  private static boolean c()
  {
    try
    {
      Class.forName("android.app.Application", false, b());
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */