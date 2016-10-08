package com.d.a.a.g;

import com.d.a.a.e;
import java.util.Collection;
import java.util.Comparator;

public abstract class d
  implements c
{
  c a;
  c b;
  final Comparator<e> c;
  final Comparator<e> d;
  
  public d(int paramInt, Comparator<e> paramComparator1, Comparator<e> paramComparator2)
  {
    this.c = paramComparator1;
    this.d = paramComparator2;
    this.a = a(a.a, paramInt, paramComparator1);
    this.b = a(a.b, paramInt, paramComparator1);
  }
  
  public int a()
  {
    return this.a.a() + this.b.a();
  }
  
  protected e a(a parama, Collection<String> paramCollection)
  {
    if (parama == a.a) {
      return this.a.a(paramCollection);
    }
    return this.b.a(paramCollection);
  }
  
  public e a(Collection<String> paramCollection)
  {
    e locale1;
    e locale2;
    for (;;)
    {
      locale1 = this.a.a(paramCollection);
      if ((locale1 != null) && (c(locale1) != a.a))
      {
        this.b.a(locale1);
        this.a.b(locale1);
      }
      else
      {
        locale2 = this.b.a(paramCollection);
        if ((locale2 == null) || (c(locale2) == a.b)) {
          break;
        }
        this.a.a(locale2);
        this.b.b(locale2);
      }
    }
    if (locale1 == null) {}
    do
    {
      return locale2;
      if (locale2 == null) {
        return locale1;
      }
    } while (this.d.compare(locale1, locale2) != -1);
    return locale1;
  }
  
  public b a(a parama, long paramLong, Collection<String> paramCollection)
  {
    if (parama == a.a) {
      return this.a.a(paramLong, paramCollection);
    }
    return this.b.a(paramLong, paramCollection);
  }
  
  protected abstract c a(a parama, int paramInt, Comparator<e> paramComparator);
  
  public boolean a(e parame)
  {
    if (c(parame) == a.a) {
      return this.a.a(parame);
    }
    return this.b.a(parame);
  }
  
  public b b(a parama, Collection<String> paramCollection)
  {
    if (parama == a.a) {
      return this.a.b(paramCollection);
    }
    return this.b.b(paramCollection);
  }
  
  public boolean b(e parame)
  {
    return (this.b.b(parame)) || (this.a.b(parame));
  }
  
  protected abstract a c(e parame);
  
  protected static enum a
  {
    private a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */