package rx.a;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class a
  extends RuntimeException
{
  private static final long serialVersionUID = 3026362227162912146L;
  private final List<Throwable> a;
  private final String b;
  private Throwable c = null;
  
  public a(String paramString, Collection<? extends Throwable> paramCollection)
  {
    paramString = new LinkedHashSet();
    ArrayList localArrayList = new ArrayList();
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Throwable localThrowable = (Throwable)paramCollection.next();
        if ((localThrowable instanceof a)) {
          paramString.addAll(((a)localThrowable).a());
        } else if (localThrowable != null) {
          paramString.add(localThrowable);
        } else {
          paramString.add(new NullPointerException());
        }
      }
    }
    paramString.add(new NullPointerException());
    localArrayList.addAll(paramString);
    this.a = Collections.unmodifiableList(localArrayList);
    this.b = (this.a.size() + " exceptions occurred. ");
  }
  
  public a(Collection<? extends Throwable> paramCollection)
  {
    this(null, paramCollection);
  }
  
  private final List<Throwable> a(Throwable paramThrowable)
  {
    ArrayList localArrayList = new ArrayList();
    Throwable localThrowable = paramThrowable.getCause();
    paramThrowable = localThrowable;
    if (localThrowable == null) {
      return localArrayList;
    }
    do
    {
      paramThrowable = paramThrowable.getCause();
      localArrayList.add(paramThrowable);
    } while (paramThrowable.getCause() != null);
    return localArrayList;
  }
  
  private void a(StringBuilder paramStringBuilder, Throwable paramThrowable, String paramString)
  {
    paramStringBuilder.append(paramString).append(paramThrowable).append("\n");
    paramString = paramThrowable.getStackTrace();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      paramStringBuilder.append("\t\tat ").append(localObject).append("\n");
      i += 1;
    }
    if (paramThrowable.getCause() != null)
    {
      paramStringBuilder.append("\tCaused by: ");
      a(paramStringBuilder, paramThrowable.getCause(), "");
    }
  }
  
  private void a(b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this).append("\n");
    ??? = getStackTrace();
    int j = ???.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = ???[i];
      localStringBuilder.append("\tat ").append(localObject2).append("\n");
      i += 1;
    }
    ??? = this.a.iterator();
    i = 1;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (Throwable)((Iterator)???).next();
      localStringBuilder.append("  ComposedException ").append(i).append(" :").append("\n");
      a(localStringBuilder, (Throwable)localObject2, "\t");
      i += 1;
    }
    synchronized (paramb.a())
    {
      paramb.a(localStringBuilder.toString());
      return;
    }
  }
  
  public List<Throwable> a()
  {
    return this.a;
  }
  
  public Throwable getCause()
  {
    try
    {
      a locala2;
      HashSet localHashSet;
      Iterator localIterator1;
      if (this.c == null)
      {
        locala2 = new a();
        localHashSet = new HashSet();
        localIterator1 = this.a.iterator();
        a locala1 = locala2;
      }
      for (;;)
      {
        Object localObject2;
        if (localIterator1.hasNext())
        {
          localObject2 = (Throwable)localIterator1.next();
          if (localHashSet.contains(localObject2)) {
            continue;
          }
          localHashSet.add(localObject2);
          Iterator localIterator2 = a((Throwable)localObject2).iterator();
          while (localIterator2.hasNext())
          {
            Throwable localThrowable3 = (Throwable)localIterator2.next();
            if (localHashSet.contains(localThrowable3)) {
              localObject2 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
            } else {
              localHashSet.add(localThrowable3);
            }
          }
        }
        try
        {
          ((Throwable)localObject1).initCause((Throwable)localObject2);
          Throwable localThrowable1 = ((Throwable)localObject1).getCause();
          continue;
          this.c = locala2;
          localThrowable1 = this.c;
          return localThrowable1;
        }
        catch (Throwable localThrowable2)
        {
          for (;;) {}
        }
      }
    }
    finally {}
  }
  
  public String getMessage()
  {
    return this.b;
  }
  
  public void printStackTrace()
  {
    printStackTrace(System.err);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    a(new c(paramPrintStream));
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    a(new d(paramPrintWriter));
  }
  
  static final class a
    extends RuntimeException
  {
    static String a = "Chain of Causes for CompositeException In Order Received =>";
    private static final long serialVersionUID = 3875212506787802066L;
    
    public String getMessage()
    {
      return a;
    }
  }
  
  private static abstract class b
  {
    abstract Object a();
    
    abstract void a(Object paramObject);
  }
  
  private static class c
    extends a.b
  {
    private final PrintStream a;
    
    c(PrintStream paramPrintStream)
    {
      super();
      this.a = paramPrintStream;
    }
    
    Object a()
    {
      return this.a;
    }
    
    void a(Object paramObject)
    {
      this.a.println(paramObject);
    }
  }
  
  private static class d
    extends a.b
  {
    private final PrintWriter a;
    
    d(PrintWriter paramPrintWriter)
    {
      super();
      this.a = paramPrintWriter;
    }
    
    Object a()
    {
      return this.a;
    }
    
    void a(Object paramObject)
    {
      this.a.println(paramObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */