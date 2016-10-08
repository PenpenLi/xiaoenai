package rx.a;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rx.annotations.Experimental;

public final class b
{
  public static void a(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof e)) {
      throw ((e)paramThrowable);
    }
    if ((paramThrowable instanceof d))
    {
      Throwable localThrowable = ((d)paramThrowable).getCause();
      if ((localThrowable instanceof RuntimeException)) {
        throw ((RuntimeException)localThrowable);
      }
      throw ((d)paramThrowable);
    }
    if ((paramThrowable instanceof StackOverflowError)) {
      throw ((StackOverflowError)paramThrowable);
    }
    if ((paramThrowable instanceof VirtualMachineError)) {
      throw ((VirtualMachineError)paramThrowable);
    }
    if ((paramThrowable instanceof ThreadDeath)) {
      throw ((ThreadDeath)paramThrowable);
    }
    if ((paramThrowable instanceof LinkageError)) {
      throw ((LinkageError)paramThrowable);
    }
  }
  
  public static void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    HashSet localHashSet = new HashSet();
    int i = 0;
    for (;;)
    {
      Throwable localThrowable = paramThrowable1;
      if (paramThrowable1.getCause() != null)
      {
        if (i >= 25) {
          return;
        }
        paramThrowable1 = paramThrowable1.getCause();
        if (localHashSet.contains(paramThrowable1.getCause())) {
          localThrowable = paramThrowable1;
        }
      }
      else
      {
        try
        {
          localThrowable.initCause(paramThrowable2);
          return;
        }
        catch (Throwable paramThrowable1)
        {
          return;
        }
      }
      localHashSet.add(paramThrowable1.getCause());
      i += 1;
    }
  }
  
  @Experimental
  public static void a(List<? extends Throwable> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramList.size() == 1)
      {
        paramList = (Throwable)paramList.get(0);
        if ((paramList instanceof RuntimeException)) {
          throw ((RuntimeException)paramList);
        }
        if ((paramList instanceof Error)) {
          throw ((Error)paramList);
        }
        throw new RuntimeException(paramList);
      }
      throw new a("Multiple exceptions", paramList);
    }
  }
  
  public static Throwable b(Throwable paramThrowable)
  {
    int i = 0;
    for (;;)
    {
      Object localObject = paramThrowable;
      if (paramThrowable.getCause() != null)
      {
        if (i >= 25) {
          localObject = new RuntimeException("Stack too deep to get final cause");
        }
      }
      else {
        return (Throwable)localObject;
      }
      paramThrowable = paramThrowable.getCause();
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */