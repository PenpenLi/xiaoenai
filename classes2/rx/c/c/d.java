package rx.c.c;

import java.security.PrivilegedAction;

final class d
  implements PrivilegedAction<ClassLoader>
{
  public ClassLoader a()
  {
    return ClassLoader.getSystemClassLoader();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */