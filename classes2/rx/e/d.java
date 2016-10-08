package rx.e;

import java.util.concurrent.atomic.AtomicReference;

public class d
{
  static final a a = new e();
  private static final d b = new d();
  private final AtomicReference<a> c = new AtomicReference();
  private final AtomicReference<b> d = new AtomicReference();
  private final AtomicReference<f> e = new AtomicReference();
  
  private static Object a(Class<?> paramClass)
  {
    String str1 = paramClass.getSimpleName();
    String str2 = System.getProperty("rxjava.plugin." + str1 + ".implementation");
    if (str2 != null) {
      try
      {
        paramClass = Class.forName(str2).asSubclass(paramClass).newInstance();
        return paramClass;
      }
      catch (ClassCastException paramClass)
      {
        throw new RuntimeException(str1 + " implementation is not an instance of " + str1 + ": " + str2);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new RuntimeException(str1 + " implementation class not found: " + str2, paramClass);
      }
      catch (InstantiationException paramClass)
      {
        throw new RuntimeException(str1 + " implementation not able to be instantiated: " + str2, paramClass);
      }
      catch (IllegalAccessException paramClass)
      {
        throw new RuntimeException(str1 + " implementation not able to be accessed: " + str2, paramClass);
      }
    }
    return null;
  }
  
  public static d a()
  {
    return b;
  }
  
  public a b()
  {
    Object localObject;
    if (this.c.get() == null)
    {
      localObject = a(a.class);
      if (localObject != null) {
        break label43;
      }
      this.c.compareAndSet(null, a);
    }
    for (;;)
    {
      return (a)this.c.get();
      label43:
      this.c.compareAndSet(null, (a)localObject);
    }
  }
  
  public b c()
  {
    Object localObject;
    if (this.d.get() == null)
    {
      localObject = a(b.class);
      if (localObject != null) {
        break label43;
      }
      this.d.compareAndSet(null, c.a());
    }
    for (;;)
    {
      return (b)this.d.get();
      label43:
      this.d.compareAndSet(null, (b)localObject);
    }
  }
  
  public f d()
  {
    Object localObject;
    if (this.e.get() == null)
    {
      localObject = a(f.class);
      if (localObject != null) {
        break label43;
      }
      this.e.compareAndSet(null, f.d());
    }
    for (;;)
    {
      return (f)this.e.get();
      label43:
      this.e.compareAndSet(null, (f)localObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */