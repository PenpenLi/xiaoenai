package com.alibaba.mtl.appmonitor.c;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

public class c<T extends b>
{
  private static AtomicLong c = new AtomicLong(0L);
  private static AtomicLong d = new AtomicLong(0L);
  private ConcurrentLinkedQueue<T> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private Integer jdField_b_of_type_JavaLangInteger = null;
  private Set<Integer> jdField_b_of_type_JavaUtilSet = new HashSet();
  private AtomicLong jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private final int m = 20;
  
  public T a()
  {
    c.getAndIncrement();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    b localb = (b)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
    if (localb != null)
    {
      this.jdField_b_of_type_JavaUtilSet.remove(Integer.valueOf(System.identityHashCode(localb)));
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
      d.getAndIncrement();
    }
    return localb;
  }
  
  public void a(T paramT)
  {
    paramT.clean();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() < 20) {
      synchronized (this.jdField_b_of_type_JavaUtilSet)
      {
        int i = System.identityHashCode(paramT);
        if (!this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(i)))
        {
          this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(i));
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramT);
        }
        return;
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */