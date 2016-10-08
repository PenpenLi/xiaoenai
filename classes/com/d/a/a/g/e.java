package com.d.a.a.g;

import java.util.Collection;
import java.util.Comparator;

public class e
  extends d
{
  public e(int paramInt, Comparator<com.d.a.a.e> paramComparator)
  {
    super(paramInt, paramComparator, new i(paramComparator));
  }
  
  public com.d.a.a.e a(boolean paramBoolean, Collection<String> paramCollection)
  {
    if (paramBoolean) {
      return super.a(paramCollection);
    }
    return super.a(d.a.b, paramCollection);
  }
  
  public b a(long paramLong, Collection<String> paramCollection)
  {
    throw new UnsupportedOperationException("cannot call network aware priority queue count w/o providing network status");
  }
  
  protected c a(d.a parama, int paramInt, Comparator<com.d.a.a.e> paramComparator)
  {
    return new j(paramInt, paramComparator);
  }
  
  public b b(Collection<String> paramCollection)
  {
    throw new UnsupportedOperationException("cannot call network aware priority queue count w/o providing network status");
  }
  
  public b b(boolean paramBoolean, Collection<String> paramCollection)
  {
    long l = System.nanoTime();
    if (paramBoolean) {
      return super.a(d.a.a, l, paramCollection).a(super.a(d.a.b, l, paramCollection));
    }
    return super.a(d.a.b, l, paramCollection);
  }
  
  protected d.a c(com.d.a.a.e parame)
  {
    if (parame.b()) {
      return d.a.a;
    }
    return d.a.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */