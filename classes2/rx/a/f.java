package rx.a;

import java.util.HashSet;
import java.util.Set;
import rx.e.a;
import rx.e.d;

public final class f
  extends RuntimeException
{
  private static final long serialVersionUID = -569558213262703934L;
  
  public static Throwable a(Throwable paramThrowable, Object paramObject)
  {
    Throwable localThrowable = b.b(paramThrowable);
    if ((localThrowable != null) && ((localThrowable instanceof a)) && (((a)localThrowable).a() == paramObject)) {
      return paramThrowable;
    }
    b.a(paramThrowable, new a(paramObject));
    return paramThrowable;
  }
  
  public static class a
    extends RuntimeException
  {
    private static final long serialVersionUID = -3454462756050397899L;
    private final Object a;
    
    public a(Object paramObject)
    {
      super();
      this.a = paramObject;
    }
    
    static String a(Object paramObject)
    {
      if (paramObject == null) {
        return "null";
      }
      if (a.a.contains(paramObject.getClass())) {
        return paramObject.toString();
      }
      if ((paramObject instanceof String)) {
        return (String)paramObject;
      }
      if ((paramObject instanceof Enum)) {
        return ((Enum)paramObject).name();
      }
      String str = d.a().b().a(paramObject);
      if (str != null) {
        return str;
      }
      return paramObject.getClass().getName() + ".class";
    }
    
    public Object a()
    {
      return this.a;
    }
    
    private static final class a
    {
      static final Set<Class<?>> a = ;
      
      private static Set<Class<?>> a()
      {
        HashSet localHashSet = new HashSet();
        localHashSet.add(Boolean.class);
        localHashSet.add(Character.class);
        localHashSet.add(Byte.class);
        localHashSet.add(Short.class);
        localHashSet.add(Integer.class);
        localHashSet.add(Long.class);
        localHashSet.add(Float.class);
        localHashSet.add(Double.class);
        return localHashSet;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */