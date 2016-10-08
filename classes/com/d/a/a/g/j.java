package com.d.a.a.g;

import com.d.a.a.e;
import java.util.Collection;
import java.util.Comparator;

public class j
  extends d
{
  public j(int paramInt, Comparator<e> paramComparator)
  {
    super(paramInt, paramComparator, new i(paramComparator));
  }
  
  public b a(long paramLong, Collection<String> paramCollection)
  {
    return super.b(d.a.a, paramCollection).a(super.a(d.a.b, paramLong, paramCollection));
  }
  
  protected c a(d.a parama, int paramInt, Comparator<e> paramComparator)
  {
    if (parama == d.a.a) {
      return new f(paramComparator);
    }
    return new f(new a(paramComparator));
  }
  
  public b b(Collection<String> paramCollection)
  {
    throw new UnsupportedOperationException("cannot call time aware priority queue's count ready jobs w/o providing a time");
  }
  
  protected d.a c(e parame)
  {
    if (parame.g() <= System.nanoTime()) {
      return d.a.a;
    }
    return d.a.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\g\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */