package a.a.a.b;

import a.a.a.c.c;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class b<T>
  implements a<Long, T>
{
  private final c<Reference<T>> a = new c();
  private final ReentrantLock b = new ReentrantLock();
  
  public T a(long paramLong)
  {
    this.b.lock();
    try
    {
      Reference localReference = (Reference)this.a.a(paramLong);
      this.b.unlock();
      if (localReference != null) {
        return (T)localReference.get();
      }
    }
    finally
    {
      this.b.unlock();
    }
    return null;
  }
  
  public T a(Long paramLong)
  {
    return (T)a(paramLong.longValue());
  }
  
  public void a()
  {
    this.b.lock();
    try
    {
      this.a.a();
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public void a(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  public void a(long paramLong, T paramT)
  {
    this.b.lock();
    try
    {
      this.a.a(paramLong, new WeakReference(paramT));
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public void a(Iterable<Long> paramIterable)
  {
    this.b.lock();
    try
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Long localLong = (Long)paramIterable.next();
        this.a.b(localLong.longValue());
      }
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public void a(Long paramLong, T paramT)
  {
    a(paramLong.longValue(), paramT);
  }
  
  public T b(long paramLong)
  {
    Reference localReference = (Reference)this.a.a(paramLong);
    if (localReference != null) {
      return (T)localReference.get();
    }
    return null;
  }
  
  public T b(Long paramLong)
  {
    return (T)b(paramLong.longValue());
  }
  
  public void b()
  {
    this.b.lock();
  }
  
  public void b(long paramLong, T paramT)
  {
    this.a.a(paramLong, new WeakReference(paramT));
  }
  
  public void b(Long paramLong, T paramT)
  {
    b(paramLong.longValue(), paramT);
  }
  
  public void c()
  {
    this.b.unlock();
  }
  
  public void c(Long paramLong)
  {
    this.b.lock();
    try
    {
      this.a.b(paramLong.longValue());
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public boolean c(Long paramLong, T paramT)
  {
    this.b.lock();
    try
    {
      if ((a(paramLong) == paramT) && (paramT != null))
      {
        c(paramLong);
        return true;
      }
      return false;
    }
    finally
    {
      this.b.unlock();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */