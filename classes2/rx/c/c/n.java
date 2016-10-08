package rx.c.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class n<T>
  implements Queue<T>
{
  private final LinkedList<T> a = new LinkedList();
  private final int b;
  
  public n()
  {
    this.b = -1;
  }
  
  public n(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean add(T paramT)
  {
    try
    {
      boolean bool = this.a.add(paramT);
      return bool;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    try
    {
      boolean bool = this.a.addAll(paramCollection);
      return bool;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public void clear()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Object clone()
  {
    try
    {
      n localn = new n(this.b);
      localn.addAll(this.a);
      return localn;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean contains(Object paramObject)
  {
    try
    {
      boolean bool = this.a.contains(paramObject);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    try
    {
      boolean bool = this.a.containsAll(paramCollection);
      return bool;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public T element()
  {
    try
    {
      Object localObject1 = this.a.element();
      return (T)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    try
    {
      boolean bool = this.a.equals(paramObject);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = this.a.hashCode();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isEmpty()
  {
    try
    {
      boolean bool = this.a.isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Iterator<T> iterator()
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      return localIterator;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public boolean offer(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	rx/c/c/n:b	I
    //   6: iconst_m1
    //   7: if_icmple +31 -> 38
    //   10: aload_0
    //   11: getfield 21	rx/c/c/n:a	Ljava/util/LinkedList;
    //   14: invokevirtual 75	java/util/LinkedList:size	()I
    //   17: istore_2
    //   18: aload_0
    //   19: getfield 23	rx/c/c/n:b	I
    //   22: istore_3
    //   23: iload_2
    //   24: iconst_1
    //   25: iadd
    //   26: iload_3
    //   27: if_icmple +11 -> 38
    //   30: iconst_0
    //   31: istore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: iload 4
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 21	rx/c/c/n:a	Ljava/util/LinkedList;
    //   42: aload_1
    //   43: invokevirtual 77	java/util/LinkedList:offer	(Ljava/lang/Object;)Z
    //   46: istore 4
    //   48: goto -15 -> 33
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	n
    //   0	56	1	paramT	T
    //   17	9	2	i	int
    //   22	6	3	j	int
    //   31	16	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	23	51	finally
    //   38	48	51	finally
  }
  
  public T peek()
  {
    try
    {
      Object localObject1 = this.a.peek();
      return (T)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public T poll()
  {
    try
    {
      Object localObject1 = this.a.poll();
      return (T)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public T remove()
  {
    try
    {
      Object localObject1 = this.a.remove();
      return (T)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public boolean remove(Object paramObject)
  {
    try
    {
      boolean bool = this.a.remove(paramObject);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    try
    {
      boolean bool = this.a.removeAll(paramCollection);
      return bool;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    try
    {
      boolean bool = this.a.retainAll(paramCollection);
      return bool;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public int size()
  {
    try
    {
      int i = this.a.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Object[] toArray()
  {
    try
    {
      Object[] arrayOfObject = this.a.toArray();
      return arrayOfObject;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public <R> R[] toArray(R[] paramArrayOfR)
  {
    try
    {
      paramArrayOfR = this.a.toArray(paramArrayOfR);
      return paramArrayOfR;
    }
    finally
    {
      paramArrayOfR = finally;
      throw paramArrayOfR;
    }
  }
  
  public String toString()
  {
    try
    {
      String str = this.a.toString();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */